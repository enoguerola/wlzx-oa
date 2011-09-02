package system.wlims.oa.serviceImpl.receipt;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import system.DAOException;
import system.ServiceException;
import system.components.SecurityUserHolder;
import system.constants.Constants;
import system.entity.UserModel;
import system.utils.StringUtils;
import system.utils.UtilDateTime;
import system.wlims.oa.dao.notice.AttachmentDAO;
import system.wlims.oa.dao.receipt.FileFlowDAO;
import system.wlims.oa.dao.receipt.ReceiptDAO;
import system.wlims.oa.entity.notice.AttachmentModel;
import system.wlims.oa.entity.receipt.FileFlowModel;
import system.wlims.oa.entity.receipt.ReceiptModel;
import system.wlims.oa.service.receipt.ReceiptService;
import system.wlims.oa.vo.ReceiptWorkFlowVO;

public class ReceiptServiceImpl implements ReceiptService {

	private ReceiptDAO receiptDAO;
	private FileFlowDAO fileFlowDAO;
	private AttachmentDAO attachmentDAO;
	public void setReceiptDAO(ReceiptDAO receiptDAO) {
		this.receiptDAO = receiptDAO;
	}

	public ReceiptDAO getReceiptDAO() {
		return receiptDAO;
	}

	@Override
	public ReceiptModel get(String id) throws ServiceException {
		// TODO Auto-generated method stub
		return receiptDAO.get(id);
	}
	
	private void addSearchRestrictions(DetachedCriteria criteria, String inNumber, String office, String doNumber, 
			  String title, String startDate, String endDate, int page, int pageCount){
		if(StringUtils.isNotEmpty(inNumber))
			criteria.add(Restrictions.ilike("inNumber", inNumber, MatchMode.ANYWHERE));
		
		if(StringUtils.isNotEmpty(doNumber))
			criteria.add(Restrictions.ilike("doNumber", doNumber, MatchMode.ANYWHERE));
		
		if(StringUtils.isNotEmpty(office))
			criteria.add(Restrictions.ilike("office", office, MatchMode.ANYWHERE));
		
		if(StringUtils.isNotEmpty(title))
			criteria.add(Restrictions.or(Restrictions.like("title", title, MatchMode.ANYWHERE), 
					Restrictions.like("summary", title,  MatchMode.ANYWHERE)));
		if(StringUtils.isNotEmpty(startDate))
			criteria.add(Restrictions.sqlRestriction("in_date >= '"+startDate+" 00:00:00'"));		
		if(StringUtils.isNotEmpty(endDate))
			criteria.add(Restrictions.sqlRestriction("in_date <= '"+endDate+" 23:59:59'"));
		
//		if(StringUtils.isNotEmpty(startDate))
//			criteria.add(Restrictions.ge("inDate", Date.valueOf(startDate)));
//		
//		if(StringUtils.isNotEmpty(endDate))
//			criteria.add(Restrictions.le("inDate", Date.valueOf(endDate)));
		
		criteria.addOrder(Order.asc("status")).addOrder(Order.asc("isCompleted")).addOrder(Order.desc("inDate"));
			}

	@SuppressWarnings("unchecked")
	@Override
	public List<ReceiptModel> get(String inNumber, String office, String doNumber, String status, 
			  String title, String startDate, String endDate, int page, int pageCount) throws ServiceException {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(ReceiptModel.class);
		
		addSearchRestrictions(criteria, inNumber, office, doNumber, title, startDate, endDate, page, pageCount);
		
		if(StringUtils.isNotEmpty(status)){
			// 如果一个 receipt 流向下一步，需要对上步仍然可见
			if(status.indexOf(",") > -1){
				String[] statusList = status.split(",");
				Integer[] statusIntList = new Integer[statusList.length];
				for(int i=0; i<statusList.length; i++)
					statusIntList[i] = Integer.parseInt(statusList[i]);
				criteria.add(Restrictions.in("status", statusIntList));
			}else if(status.indexOf(";") > -1){
				// 对于 登记 拟办 传阅等 status 中有“;”号
				String[] statusList = status.split(";");
				Integer[] statusIntList = new Integer[statusList.length];
				for(int i=0; i<statusList.length; i++)
					statusIntList[i] = Integer.parseInt(statusList[i]);
				criteria.add(Restrictions.in("status", statusIntList));
			}
			else{
				criteria.add(Restrictions.eq("status", Integer.parseInt(status)));
			}
		}
		
		//List<ReceiptModel> list = receiptDAO.getListByCriteria(criteria, (page - 1)*pageCount, pageCount);
		List<ReceiptModel> list = receiptDAO.getListByCriteria(criteria);
		if(SecurityUserHolder.isSuperRootUser())
			return list;
		if(StringUtils.isNotEmpty(status) && ";".indexOf(status) > -1)
			return filter(list, Integer.parseInt(status.substring(0, 1)));
		return list;
	}
	
	//过滤 没有该用户fileflow的receipt
	private List<ReceiptModel> filter(List<ReceiptModel> list, int status){
		if(list != null && list.size() > 0){
			for(Iterator<ReceiptModel> iterator = list.iterator(); iterator.hasNext();){
				ReceiptModel receipt = iterator.next();
				List<FileFlowModel> fileFlowList = fileFlowDAO.getListByType(receipt, status/2);
				boolean exist = false;
				if(fileFlowList != null && fileFlowList.size() > 0){
					UserModel userModel = SecurityUserHolder.getCurrentUser();
					for(FileFlowModel fileFlow:fileFlowList){
						if(userModel.getId().equals(fileFlow.getUser())){
							exist = true;
							//把 fileflow的状态复制到 receipt
							if(fileFlow.getIsCompleted() == 1)
								receipt.setStatus(fileFlow.getType() * 2 + 3);
							else
								receipt.setStatus(fileFlow.getType() * 2 + 2);
							break;
						}
					}
				}
				if(!exist)
					iterator.remove();
			}
		}
		return list;
	}

	@Override
	public void remove(String id) throws ServiceException {
		// TODO Auto-generated method stub
		receiptDAO.remove(receiptDAO.get(id));
	}

	@Override
	public ReceiptModel save(ReceiptModel model) throws ServiceException {
		// TODO Auto-generated method stub
		if(model.getStatus() != null && model.getStatus() == 1){
			model.setRegistedDate(java.sql.Date.valueOf(UtilDateTime.nowDateString("yyyy-MM-DD")));
			model.setIsCompleted(1);
		}
		model.setAttachments(null);
		receiptDAO.saveOrUpdate(model);
		return model;
	}

	@Override
	public String complete(String id) throws ServiceException {
		// TODO Auto-generated method stub
		ReceiptModel model = receiptDAO.get(id);
		
		List<FileFlowModel> list = fileFlowDAO.getListByType(model, FileFlowModel.EType.Circulateing.getValue());
		if(list != null && list.size() > 0){
			for(FileFlowModel fileFlowModel:list){
				if(fileFlowModel.getIsCompleted() != 0){
					fileFlowModel.setIsCompleted(1);
					fileFlowDAO.saveOrUpdate(fileFlowModel);
				}
			}
		}
		
		model.setIsCompleted(1);
		
		try {
			receiptDAO.saveOrUpdate(model);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Constants.DAO_ERROR;
		}
		return Constants.NONE_ERROR;
	}

	@Override
	public String register(String id) throws ServiceException {
		// TODO Auto-generated method stub
		ReceiptModel model = receiptDAO.get(id);
		model.setStatus(ReceiptModel.EStatus.Register.getValue());
		
		if(StringUtils.isEmpty(model.getInNumber()) || StringUtils.isEmpty(model.getSubject())
				|| StringUtils.isEmpty(model.getSummary()))
			return Constants.FIELD_NONE_ERROR;
		
		try {
			receiptDAO.saveOrUpdate(model);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Constants.DAO_ERROR;
		}
		return Constants.NONE_ERROR;
	}

	public FileFlowDAO getFileFlowDAO() {
		return fileFlowDAO;
	}

	public void setFileFlowDAO(FileFlowDAO fileFlowDAO) {
		this.fileFlowDAO = fileFlowDAO;
	}
	
	

	@SuppressWarnings("unchecked")
	@Override
	public ReceiptModel addReceipt(ReceiptModel model,List list)
			throws ServiceException {
		// TODO Auto-generated method stub
		if(list != null && list.size() > 0){
			for(Object id : list){
				 //System.out.println(id);
				AttachmentModel attachmentModel = attachmentDAO.get((String)id);
				model.getAttachments().add(attachmentModel);
			}
		}
		//model.setCreationDate(new Date());
		model.setReceiverId(SecurityUserHolder.getCurrentUser().getId());
		model.setStatus(ReceiptModel.EStatus.Draft.getValue());
		receiptDAO.saveOrUpdate(model);
		
		FileFlowModel flow=new FileFlowModel();
		flow.setType(FileFlowModel.EType.Draft.getValue());
		flow.setText(FileFlowModel.EType.Draft.getText());
		flow.setCreationDate(new Date());
		flow.setUser(model.getReceiverId());
		flow.setReceiptId(model.getId());
		flow.setIsCompleted(null);
		fileFlowDAO.saveOrUpdate(flow);
		
		return receiptDAO.get(model.getId());
	}


	@Override
	public ReceiptModel updateReceipt(ReceiptModel model,String adds,String removes)
			throws ServiceException {
		try{
//			if(list != null && list.size() > 0){
//				for(Object id : list){
//					System.out.println(id);
//					AttachmentModel attachmentModel = attachmentDAO.get((String)id);
//					notice.getAttachments().add(attachmentModel);
//				}
//			}
			 //System.out.println(adds+"aaaaaaa");
			 //System.out.println(removes+"bbbbbbbbb");
			if(StringUtils.isNotEmpty(adds)){
				String[] adds_attr=adds.split(";");
				for(int i=0;i<adds_attr.length;i++){
					String id=adds_attr[i];
					if(StringUtils.isNotEmpty(id)){
						AttachmentModel attachmentModel = attachmentDAO.get(id);
						if(attachmentModel!=null)
							model.getAttachments().add(attachmentModel);
					}
				}
			}
			if(StringUtils.isNotEmpty(removes)){
				String[] removes_attr=removes.split(";");
				for(int i=0;i<removes_attr.length;i++){
					String id=removes_attr[i];
					if(StringUtils.isNotEmpty(id)){
						AttachmentModel attachmentModel =null;
						for(AttachmentModel a:model.getAttachments()){
							if(a.getId().equals(id)){
								attachmentModel=a;
								break;
							}
						}
						if(attachmentModel!=null)
							model.getAttachments().remove(attachmentModel);
					}
				}
			}
			receiptDAO.saveOrUpdate(model);
			return model;
		}catch (DAOException e){
			return null;
		}
	}
	@Override
	public boolean addNextWorkFlows(String receiptId, String flowType,
			String userIds) {
		// TODO Auto-generated method stub
		if(StringUtils.isEmpty(userIds))return false;
		String[] users=userIds.split(",");
		for(int i=0;i<users.length;i++){
			FileFlowModel flow=new FileFlowModel();
			flow.setType(Integer.parseInt(flowType));
			if(flowType.equals("0")){
				flow.setText(FileFlowModel.EType.Draft.getText());
			}
			//flow.setText(FileFlowModel.EType.values().);
			flow.setCreationDate(new Date());
			flow.setUser(users[i]);
			flow.setReceiptId(receiptId);
			flow.setIsCompleted(null);
			fileFlowDAO.saveOrUpdate(flow);
		}
		ReceiptModel model=receiptDAO.get(receiptId);
		model.setStatus(Integer.parseInt(flowType));
		receiptDAO.saveOrUpdate(model);
		return true;
	}
	@Override
	public boolean finishWorkFlow(String flowId,String state,String text)
			throws ServiceException {
		// TODO Auto-generated method stub
		FileFlowModel flow=fileFlowDAO.get(flowId);
		if(StringUtils.isNotEmpty(state))
		flow.setIsCompleted(Integer.parseInt(state));
		flow.setCompletedDate(new Date());
		flow.setText(text);
		fileFlowDAO.saveOrUpdate(flow);
		String receiptId=flow.getReceiptId();
		ReceiptModel file=receiptDAO.get(receiptId);
		if(file.thisStateIsAllDealed(flow.getType())){
			file.setStatus(file.getStatus()+1);
			receiptDAO.saveOrUpdate(file);
			
		}
		return true;
	}
	@Override
	public List<ReceiptWorkFlowVO> getWorkFlowsByConditions(String inNumber, String office, String doNumber,String title,String subject,String summary,String beginDate,
			String endDate, String states, Integer isCompleted, String userId)
			throws ServiceException {
		// TODO Auto-generated method stub
		List<ReceiptWorkFlowVO> results=new ArrayList<ReceiptWorkFlowVO>();
		List<ReceiptModel> list=receiptDAO.getByConditions(inNumber, office, doNumber, title, subject,summary,beginDate, endDate, states,isCompleted);
		for(ReceiptModel receipt:list){
			if(receipt.getFileFlows()!=null&&receipt.getFileFlows().size()>0){
				for(FileFlowModel fileFlow:receipt.getFileFlows()){
					if((fileFlow.getIsCompleted()==null)&&fileFlow.getUser().equals(userId)){
						ReceiptWorkFlowVO vo=new ReceiptWorkFlowVO();
						vo.setReceiptId(receipt.getId());
						vo.setReceiptFlowId(fileFlow.getId());
						vo.setTitle(receipt.getTitle());
						vo.setOffice(receipt.getOffice());
						vo.setAuthorId(receipt.getReceiverId());
						vo.setInDate(receipt.getInDate());
						vo.setStatus(receipt.getStatus());
						results.add(vo);
					}
					
				}
			}
		}
		return results;
	}
	public AttachmentDAO getAttachmentDAO() {
		return attachmentDAO;
	}

	public void setAttachmentDAO(AttachmentDAO attachmentDAO) {
		this.attachmentDAO = attachmentDAO;
	}
}
