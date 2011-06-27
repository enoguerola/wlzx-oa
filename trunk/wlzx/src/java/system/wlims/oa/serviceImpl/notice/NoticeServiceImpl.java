package system.wlims.oa.serviceImpl.notice;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import system.DAOException;
import system.ServiceException;
import system.components.SecurityUserHolder;
import system.dao.DepartmentDAO;
import system.dao.UserDAO;
import system.entity.DepartmentModel;
import system.entity.UserModel;
import system.utils.StringUtils;
import system.utils.UtilDateTime;
import system.wlims.oa.dao.notice.AttachmentDAO;
import system.wlims.oa.dao.notice.NoticeDAO;
import system.wlims.oa.entity.notice.AttachmentModel;
import system.wlims.oa.entity.notice.NoticeModel;
import system.wlims.oa.service.notice.AttachmentService;
import system.wlims.oa.service.notice.NoticeService;

public class NoticeServiceImpl implements NoticeService {
	
	private NoticeDAO noticeDAO;
	private DepartmentDAO departmentDAO;
	private UserDAO userDAO;
	private AttachmentDAO attachmentDAO;

	@Override
	public void addNotice(NoticeModel notice, List list) {
		// TODO Auto-generated method stub
		UserModel userModel = SecurityUserHolder.getCurrentUser();
		notice.setLastEditorId(userModel.getId());
		notice.setLastEditTime(UtilDateTime.nowDate());
		if(notice.getStatus() == 0){
			notice.setPosterId(null);
			notice.setPostTime(null);
		}else{
			if(StringUtils.isEmpty(notice.getPosterId())){
				notice.setPosterId(userModel.getId());
				notice.setPostTime(UtilDateTime.nowDate());
			}
		}
		if(list != null && list.size() > 0){
			for(Object id : list){
				System.out.println(id);
				AttachmentModel attachmentModel = attachmentDAO.get((String)id);
				notice.getAttachments().add(attachmentModel);
			}
		}
			
		noticeDAO.saveOrUpdate(notice);
	}

	@Override
	public boolean remove(String id) {
		// TODO Auto-generated method stub
		try {
			noticeDAO.remove(loadNoticeInfoById(id));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<NoticeModel> getNoticesByConditions(String userId, String type,
			String scope, String emergence, String deparmentId, String title, String status,
			String beginDate, String endDate, Integer index, Integer page) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(NoticeModel.class);
		
		if(StringUtils.isNotEmpty(type))
			criteria.add(Restrictions.eq("type", type));
		
		if(StringUtils.isNotEmpty(scope))
			criteria.add(Restrictions.eq("scope", Integer.parseInt(scope)));
		
		if(StringUtils.isNotEmpty(emergence))
			criteria.add(Restrictions.eq("emergence", Integer.parseInt(emergence)));
		
		System.out.println(deparmentId);
		if(StringUtils.isNotEmpty(deparmentId)){
			// get all department under id
			Set<DepartmentModel> departmentSet = new HashSet<DepartmentModel>();
			DepartmentModel departmentModel = departmentDAO.get(deparmentId);
			departmentSet.add(departmentModel);
			departmentSet.addAll(departmentDAO.getAllSubordinates(departmentModel));
			Set<String> stringSet = new HashSet<String>();
			for(DepartmentModel model: departmentSet){
				stringSet.add(model.getId());
			}
			criteria.add(Restrictions.in("postDepartmentId", stringSet.toArray()));
		}
		
		if(StringUtils.isNotEmpty(title))
			criteria.add(Restrictions.like("title", title));
		
		if(StringUtils.isNotEmpty(beginDate))
			criteria.add(Restrictions.ge("postTime", beginDate));
		
		if(StringUtils.isNotEmpty(endDate))
			criteria.add(Restrictions.le("postTime", endDate));
		
		if(StringUtils.isNotEmpty(status)){
			int intstatus = Integer.parseInt(status);
			//草稿 lasteditorid
			if(intstatus == 0){
				if(StringUtils.isNotEmpty(userId))
					criteria.add(Restrictions.eq("lastEditorId", userId));
			//发布 posterid
			}else{
				if(StringUtils.isNotEmpty(userId))
					criteria.add(Restrictions.eq("posterId", userId));
			}
			criteria.add(Restrictions.eq("status", intstatus));
		}
		
		return noticeDAO.getListByCriteria(criteria, (index - 1)*page, page);
	}

	@Override
	public NoticeModel loadNoticeInfoById(String id) {
		// TODO Auto-generated method stub
		return noticeDAO.get(id);
	}

	@Override
	public boolean updateNotice(NoticeModel notice, List list) {
		// TODO Auto-generated method stub
		try{
			if(list != null && list.size() > 0){
				for(Object id : list){
					System.out.println(id);
					AttachmentModel attachmentModel = attachmentDAO.get((String)id);
					notice.getAttachments().add(attachmentModel);
				}
			}
			noticeDAO.saveOrUpdate(notice);
			return true;
		}catch (DAOException e){
			return false;
		}
	}

	public void setNoticeDAO(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}

	public NoticeDAO getNoticeDAO() {
		return noticeDAO;
	}

	public void setDepartmentDAO(DepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}

	public DepartmentDAO getDepartmentDAO() {
		return departmentDAO;
	}

	@Override
	public List<NoticeModel> getDepartmentNotice(Integer index, Integer page) throws ServiceException {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(NoticeModel.class);
		
		criteria.add(Restrictions.eq("scope", NoticeModel.EScope.Department.getValue()));
		criteria.add(Restrictions.eq("status", 1));
		criteria.addOrder(Order.desc("postTime"));
		
		UserModel userModel = SecurityUserHolder.getCurrentUser();
		Set<DepartmentModel> set = userModel.getDepartments();
		if(set != null && set.size() > 0){
			set.addAll(userDAO.getAllLeaders(userModel));
		}
		Set<String> stringSet = new HashSet<String>();
		
		for(DepartmentModel model: set){
			stringSet.add(model.getId());
		}
		criteria.add(Restrictions.in("postDepartmentId", stringSet.toArray()));
		
		return noticeDAO.getListByCriteria(criteria, (index - 1)*page, page);
	}

	@Override
	public List<NoticeModel> getSchoolNotice(Integer index, Integer page) throws ServiceException {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(NoticeModel.class);
		
		criteria.add(Restrictions.eq("scope", NoticeModel.EScope.School.getValue()));
		criteria.add(Restrictions.eq("status", 1));
		criteria.addOrder(Order.desc("postTime"));
		
		return noticeDAO.getListByCriteria(criteria, (index - 1)*page, page);
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public boolean publish(String id) throws ServiceException {
		// TODO Auto-generated method stub
		NoticeModel noticeModel = noticeDAO.get(id);
		UserModel userModel = SecurityUserHolder.getCurrentUser();
		noticeModel.setPostDepartmentId(userModel.getId());
		noticeModel.setPostTime(UtilDateTime.nowDate());
		noticeModel.setStatus(1);
		try {
			noticeDAO.saveOrUpdate(noticeModel);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}


	public void setAttachmentDAO(AttachmentDAO attachmentDAO) {
		this.attachmentDAO = attachmentDAO;
	}

	public AttachmentDAO getAttachmentDAO() {
		return attachmentDAO;
	}

	@Override
	public NoticeModel get(String id) throws ServiceException {
		// TODO Auto-generated method stub
		return noticeDAO.get(id);
	}

}
