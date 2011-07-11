package system.wlims.oa.serviceImpl.receipt;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.taglibs.standard.lang.jstl.NullLiteral;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;


import system.ServiceException;
import system.dao.UserDAO;
import system.entity.UserModel;
import system.utils.UtilDateTime;
import system.wlims.basic.dao.teacher.TeacherDAO;
import system.wlims.basic.entity.teacher.TeacherModel;
import system.wlims.basic.vo.UserAddressVo;
import system.wlims.oa.dao.receipt.FileFlowDAO;
import system.wlims.oa.dao.receipt.ReceiptDAO;
import system.wlims.oa.entity.receipt.FileFlowModel;
import system.wlims.oa.entity.receipt.ReceiptModel;
import system.wlims.oa.service.receipt.FileFlowService;

public class FileFlowServiceImpl implements FileFlowService {

	private FileFlowDAO fileFlowDAO;
	private ReceiptDAO receiptDAO;
	private UserDAO userDAO;
	private TeacherDAO teacherDAO;

	@Override
	public void save(String receiptId, String userIdList, boolean update, int type)
			throws ServiceException {
		// TODO Auto-generated method stub
		ReceiptModel receipt = receiptDAO.get(receiptId);

		String[] userArray = userIdList.split(",");
		List<FileFlowModel> flows = getList(receipt);	
		int step;//第几步
		
		if(update){
			//更新当前步骤
			step = flows.get(0).getStep();
			for(FileFlowModel model : flows){
				boolean exist = false;
				for(String userid:userArray){
					if(model.getUser().equals(userid))
						exist = true;
				}
				if(!exist){
					flows.remove(model);
					remove(model);
				}
			}
			for(String id:userArray){
				boolean exist = false;
				for(FileFlowModel model:flows){
					if(model.getUser().equals(id))
						exist = true;
				}
				if(!exist){
					save(receipt, type, step, id);
				}
			}
			
		}else{
			//保存下一步
			//得到该步的step
			if(flows != null && flows.size() > 0)
				step = flows.get(0).getStep() + 1;
			else
				step = 1;
			for(String id:userArray){
				save(receipt, type, step, id);
			}
			receipt.setStatus(type * 2 + 2);
			receiptDAO.saveOrUpdate(receipt);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<FileFlowModel> getList(ReceiptModel receipt)
			throws ServiceException {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(FileFlowModel.class);
		
		if(receipt != null)
			criteria.add(Restrictions.eq("receipt", receipt));
		criteria.addOrder(Order.asc("step"));
		
		List<FileFlowModel> list = fileFlowDAO.getListByCriteria(criteria);
		
		if(list != null && list.size() > 0){
			int max = 0;
			for(FileFlowModel model : list){
				if(model.getStep() > max)
					max = model.getStep();
			}
			for(FileFlowModel model : list){
				if(model.getStep() < max)
					list.remove(model);
			}
		}
		return list;
	}
	
	@Override
	public List<FileFlowModel> getList(String receiptId, Integer step) throws ServiceException {
		// TODO Auto-generated method stub
		ReceiptModel receipt = receiptDAO.get(receiptId);
		
		return fileFlowDAO.getList(receipt, step);
	}
	

	@Override
	public void remove(FileFlowModel model) throws ServiceException {
		// TODO Auto-generated method stub
		fileFlowDAO.remove(model);
	}
	
	@Override
	public void save(ReceiptModel model, Integer type, Integer step, String user)
			throws ServiceException {
		// TODO Auto-generated method stub
		FileFlowModel fileFlowModel = new FileFlowModel();
		fileFlowModel.setCompletedDate(null);
		fileFlowModel.setDepartment("0");
		fileFlowModel.setIsCompleted(0);
		fileFlowModel.setReceipt(model);
		fileFlowModel.setStep(step);
		fileFlowModel.setText(null);
		fileFlowModel.setType(type);
		fileFlowModel.setUser(user);
		fileFlowDAO.saveOrUpdate(fileFlowModel);
	}

	@Override
	public void update(FileFlowModel model) throws ServiceException {
		// TODO Auto-generated method stub
		if(model.getIsCompleted() == 1){
			Date date = Date.valueOf(UtilDateTime.nowDateString("yyyy-MM-dd"));
			model.setCompletedDate(date);
		}
		fileFlowDAO.saveOrUpdate(model);
		if(model.getIsCompleted() == 1)
			saveReceiptStatus(model);
	}
	
	//如果全部提交 设置receipt为相应状态
	private void saveReceiptStatus(FileFlowModel model){
		DetachedCriteria criteria = DetachedCriteria.forClass(FileFlowModel.class);
		
		criteria.add(Restrictions.eq("receipt", model.getReceipt()));
		criteria.add(Restrictions.eq("step", model.getStep()));
		criteria.add(Restrictions.eq("isCompleted", 0));
		
		List<FileFlowModel> list = fileFlowDAO.getListByCriteria(criteria);
		if(list == null || list.size() == 0){
			//send message to somebody
			model.getReceipt().setStatus(model.getType() * 2 + 3);
			receiptDAO.saveOrUpdate(model.getReceipt());
		}
	}

	@Override
	public void remove(String id) throws ServiceException {
		// TODO Auto-generated method stub
		remove(get(id));
	}

	@Override
	public List<UserAddressVo> getTeacher(String receiptId) throws ServiceException {
		// TODO Auto-generated method stub
		List<FileFlowModel> list = getList(receiptDAO.get(receiptId));
		
		List<UserAddressVo> userAddressVoList = new ArrayList<UserAddressVo>();
		for(FileFlowModel model:list){
			UserAddressVo vo = new UserAddressVo();
			UserModel userModel = userDAO.get(model.getUser());
			TeacherModel teacher = teacherDAO.getTeacherByUserId(model.getUser());
			vo.setUserName(teacher.getName());
			vo.setUserID(model.getUser());
			vo.setOfficePhone(teacher.getTeacherOfficePhone());
			vo.setMobilePhone(teacher.getTeacherMobilePhone());
			if(userModel.getMainRole()!=null){
				vo.setMainRoleName(userModel.getMainRole().getName());
				
			}else{
				vo.setMainRoleName("未指定");
			}
			if(userModel.getMainDepartment()!=null){
					vo.setMainDepartmentName(userModel.getMainDepartment().getName());
			}else {
				vo.setMainDepartmentName("未指定");
			}
			vo.setEmail(model.getType() + "");
			userAddressVoList.add(vo);
		}
		
		return userAddressVoList;
	}
	
	@Override
	public FileFlowModel get(String id) throws ServiceException {
		// TODO Auto-generated method stub
		return fileFlowDAO.get(id);
	}

	public ReceiptDAO getReceiptDAO() {
		return receiptDAO;
	}

	public void setReceiptDAO(ReceiptDAO receiptDAO) {
		this.receiptDAO = receiptDAO;
	}
	
	public void setFileFlowDAO(FileFlowDAO fileFlowDAO) {
		this.fileFlowDAO = fileFlowDAO;
	}

	public FileFlowDAO getFileFlowDAO() {
		return fileFlowDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public TeacherDAO getTeacherDAO() {
		return teacherDAO;
	}

	public void setTeacherDAO(TeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}

	@Override
	public FileFlowModel save(String id, String text, Integer isCompleted)
			throws ServiceException {
		// TODO Auto-generated method stub
		FileFlowModel model = fileFlowDAO.get(id);
		model.setText(text);
		model.setIsCompleted(isCompleted);
		
		if(isCompleted == 1){
			Date date = Date.valueOf(UtilDateTime.nowDateString());
			model.setCompletedDate(date);
			fileFlowDAO.saveOrUpdate(model);
			//check all step isCompleted
			saveReceiptStatus(model);
		}else
			fileFlowDAO.saveOrUpdate(model);
		model.setReceipt(null);
		return model;
	}


}
