package system.wlims.oa.serviceImpl.receipt;

import java.sql.Date;
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
import system.wlims.oa.dao.receipt.FileFlowDAO;
import system.wlims.oa.dao.receipt.ReceiptDAO;
import system.wlims.oa.entity.receipt.FileFlowModel;
import system.wlims.oa.entity.receipt.ReceiptModel;
import system.wlims.oa.service.receipt.ReceiptService;

public class ReceiptServiceImpl implements ReceiptService {

	private ReceiptDAO receiptDAO;
	private FileFlowDAO fileFlowDAO;

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
			criteria.add(Restrictions.eq("inNumber", inNumber));
		
		if(StringUtils.isNotEmpty(doNumber))
			criteria.add(Restrictions.eq("doNumber", doNumber));
		
		if(StringUtils.isNotEmpty(office))
			criteria.add(Restrictions.eq("office", office));
		
		if(StringUtils.isNotEmpty(title))
			criteria.add(Restrictions.or(Restrictions.like("title", title, MatchMode.ANYWHERE), 
					Restrictions.like("summary", title,  MatchMode.ANYWHERE)));
		
		if(StringUtils.isNotEmpty(startDate))
			criteria.add(Restrictions.ge("inDate", Date.valueOf(startDate)));
		
		if(StringUtils.isNotEmpty(endDate))
			criteria.add(Restrictions.le("inDate", Date.valueOf(endDate)));
		
		criteria.addOrder(Order.asc("status")).addOrder(Order.asc("isCompleted")).addOrder(Order.desc("inDate"));
			}

	@Override
	public List<ReceiptModel> get(String inNumber, String office, String doNumber, String status, 
			  String title, String startDate, String endDate, int page, int pageCount) throws ServiceException {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(ReceiptModel.class);
		
		addSearchRestrictions(criteria, inNumber, office, doNumber, title, startDate, endDate, page, pageCount);
		
		if(StringUtils.isNotEmpty(status)){
			if(status.indexOf(",") > -1){
				String[] statusList = status.split(",");
				Integer[] statusIntList = new Integer[statusList.length];
				for(int i=0; i<statusList.length; i++)
					statusIntList[i] = Integer.parseInt(statusList[i]);
				criteria.add(Restrictions.in("status", statusIntList));
			}else if(status.indexOf(";") > -1){
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
		
		List<ReceiptModel> list = receiptDAO.getListByCriteria(criteria, (page - 1)*pageCount, pageCount);
		if(SecurityUserHolder.isSuperRootUser())
			return list;
		if(StringUtils.isNotEmpty(status) && ";".indexOf(status) > -1)
			return filter(list, Integer.parseInt(status.substring(0, 1)));
		return list;
	}
	
	//过滤 没有该用户fileflow的receipt
	private List<ReceiptModel> filter(List<ReceiptModel> list, int status){
		if(list != null && list.size() > 0){
			for(ReceiptModel receipt:list){
				List<FileFlowModel> fileFlowList = fileFlowDAO.getList(receipt, status/2);
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
					list.remove(receipt);
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
			model.setRegistedDate(Date.valueOf(UtilDateTime.nowDateString("yyyy-MM-DD")));
			model.setIsCompleted(0);
		}
		receiptDAO.saveOrUpdate(model);
		return model;
	}

	@Override
	public String complete(String id) throws ServiceException {
		// TODO Auto-generated method stub
		ReceiptModel model = receiptDAO.get(id);
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
}
