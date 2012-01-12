package system.wlims.oa.serviceImpl.notice;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import system.DAOException;
import system.PaginationSupport;
import system.ServiceException;
import system.components.SecurityUserHolder;
import system.dao.DepartmentDAO;
import system.dao.UserDAO;
import system.entity.UserModel;
import system.utils.StringUtils;
import system.utils.UtilDateTime;
import system.wlims.oa.dao.notice.AttachmentDAO;
import system.wlims.oa.dao.notice.NoticeDAO;
import system.wlims.oa.entity.AttachmentModel;
import system.wlims.oa.entity.notice.NoticeModel;
import system.wlims.oa.service.notice.NoticeService;

public class NoticeServiceImpl implements NoticeService {
	
	private NoticeDAO noticeDAO;
	private DepartmentDAO departmentDAO;
	private UserDAO userDAO;
	private AttachmentDAO attachmentDAO;

	@Override
	public void addNotice(NoticeModel notice, String attachmentIds) {
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
		noticeDAO.saveOrUpdate(notice);
		/*if(list != null && list.size() > 0){
			for(Object id : list){
				 //	System.out.println(id);
				AttachmentModel attachmentModel = attachmentDAO.get((String)id);
				notice.getAttachments().add(attachmentModel);
			}
		}
		noticeDAO.saveOrUpdate(notice);*/
		if(StringUtils.isNotEmpty(attachmentIds)){
			String[] ids=attachmentIds.split(";");
			for(int i=0;i<ids.length;i++){
				AttachmentModel attachment=attachmentDAO.get(ids[i]);
				attachment.setBelongObject("NoticeModel");
				attachment.setBelongObjectId(notice.getId());
				attachmentDAO.saveOrUpdate(attachment);
			}
		}
		NoticeModel newModel=noticeDAO.get(notice.getId());
		noticeDAO.merge(newModel);
	}

	@Override
	public boolean deleteNoticeById(String id) {
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

	@SuppressWarnings("unchecked")
	@Override
	public List<NoticeModel> getNoticesByConditions(String userId, String type,
			String scope, String emergence, String deparmentIds, String title, String status,
			String beginDate, String endDate, Integer index, Integer page) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(NoticeModel.class);
		
		if(StringUtils.isNotEmpty(type))
			criteria.add(Restrictions.eq("type", type));
		
		if(StringUtils.isNotEmpty(scope))
			criteria.add(Restrictions.eq("scope", Integer.parseInt(scope)));
		
		if(StringUtils.isNotEmpty(emergence))
			criteria.add(Restrictions.eq("emergence", Integer.parseInt(emergence)));
		
		 //System.out.println(deparmentId);
		if(StringUtils.isNotEmpty(deparmentIds)){
//			// get all department under id
//			Set<DepartmentModel> departmentSet = new TreeSet<DepartmentModel>();
//			DepartmentModel departmentModel = departmentDAO.get(deparmentId);
//			departmentSet.add(departmentModel);
//			departmentSet.addAll(departmentDAO.getAllSubordinates(departmentModel));
//			Set<String> stringSet = new TreeSet<String>();
//			for(DepartmentModel model: departmentSet){
//				stringSet.add(model.getId());
//			}
//			criteria.add(Restrictions.in("postDepartmentId", stringSet.toArray()));
			criteria.add(Restrictions.sqlRestriction("post_department_id in("+deparmentIds+")"));
		}
		
		if(StringUtils.isNotEmpty(title))
			criteria.add(Restrictions.like("title", title));
		
		

		if(StringUtils.isNotEmpty(status)){
			int intstatus = Integer.parseInt(status);
			//草稿 lasteditorid
			if(intstatus == 0){
				if(StringUtils.isNotEmpty(userId))
					criteria.add(Restrictions.eq("lastEditorId", userId));
				if(StringUtils.isNotEmpty(beginDate))
					criteria.add(Restrictions.sqlRestriction("last_edit_time >= '"+beginDate+" 00:00:00'"));
						//criteria.add(Restrictions.ge("postTime",  Date.valueOf(beginDate)));
					
					if(StringUtils.isNotEmpty(endDate))
						//criteria.add(Restrictions.le("postTime",  Date.valueOf(endDate)));
					criteria.add(Restrictions.sqlRestriction("last_edit_time <= '"+endDate+" 23:59:59'"));
			//发布 posterid
			}else{
				if(StringUtils.isNotEmpty(userId))
					criteria.add(Restrictions.eq("posterId", userId));
				if(StringUtils.isNotEmpty(beginDate))
					criteria.add(Restrictions.sqlRestriction("postTime >= '"+beginDate+" 00:00:00'"));
						//criteria.add(Restrictions.ge("postTime",  Date.valueOf(beginDate)));
					
					if(StringUtils.isNotEmpty(endDate))
						//criteria.add(Restrictions.le("postTime",  Date.valueOf(endDate)));
					criteria.add(Restrictions.sqlRestriction("postTime <= '"+endDate+" 23:59:59'"));
			}
			criteria.add(Restrictions.eq("status", intstatus));
		}
		return noticeDAO.getListByCriteria(criteria);
		//return noticeDAO.getListByCriteria(criteria, (index - 1)*page, page);
	}

	@Override
	public NoticeModel loadNoticeInfoById(String id) {
		// TODO Auto-generated method stub
		return noticeDAO.get(id);
	}

	@Override
	public boolean updateNotice(NoticeModel notice,String adds,String removes) {
		// TODO Auto-generated method stub
		try{
//			if(list != null && list.size() > 0){
//				for(Object id : list){
//					System.out.println(id);
//					AttachmentModel attachmentModel = attachmentDAO.get((String)id);
//					notice.getAttachments().add(attachmentModel);
//				}
//			}
			if(StringUtils.isNotEmpty(adds)){
				String[] adds_attr=adds.split(";");
				for(int i=0;i<adds_attr.length;i++){
					String id=adds_attr[i];
					if(StringUtils.isNotEmpty(id)){
						AttachmentModel attachmentModel = attachmentDAO.get(id);
						if(attachmentModel!=null)
						notice.getAttachments().add(attachmentModel);
					}
				}
			}
			if(StringUtils.isNotEmpty(removes)){
				String[] removes_attr=removes.split(";");
				for(int i=0;i<removes_attr.length;i++){
					String id=removes_attr[i];
					if(StringUtils.isNotEmpty(id)){
						AttachmentModel attachmentModel =null;
						for(AttachmentModel a:notice.getAttachments()){
							if(a.getId().equals(id)){
								attachmentModel=a;
								break;
							}
						}
						if(attachmentModel!=null)
						notice.getAttachments().remove(attachmentModel);
					}
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

	@SuppressWarnings("unchecked")
	@Override
	public List<NoticeModel> getDepartmentNotice(String beginDate, String endDate,String departments) throws ServiceException {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(NoticeModel.class);
		if(StringUtils.isNotEmpty(beginDate))
			criteria.add(Restrictions.sqlRestriction("postTime >= '"+beginDate+" 00:00:00'"));
		if(StringUtils.isNotEmpty(endDate))
			criteria.add(Restrictions.sqlRestriction("postTime <= '"+endDate+" 23:59:59'"));
		criteria.add(Restrictions.eq("scope", NoticeModel.EScope.Department.getValue()));
		criteria.add(Restrictions.eq("status", NoticeModel.EStatus.Published.getValue()));
		if(StringUtils.isNotEmpty(departments))
			criteria.add(Restrictions.sqlRestriction("post_department_id in("+departments+")"));
		criteria.addOrder(Order.desc("postTime"));

//		if(!SecurityUserHolder.isSuperRootUser()){
//			UserModel userModel = SecurityUserHolder.getCurrentUser();
//			Set<DepartmentModel> set = userModel.getAllDepartments();
//			
//			Set<String> stringSet = new TreeSet<String>();
//			if(set!=null&&set.size()>0){
//				for(DepartmentModel model: set){
//					stringSet.add(model.getId());
//				}
//				criteria.add(Restrictions.in("postDepartmentId", stringSet.toArray()));
//				
//			}
//		}

		
		return noticeDAO.getListByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NoticeModel> getSchoolNotice(String beginDate, String endDate) throws ServiceException {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(NoticeModel.class);
		if(StringUtils.isNotEmpty(beginDate))
			criteria.add(Restrictions.sqlRestriction("postTime >= '"+beginDate+" 00:00:00'"));
		if(StringUtils.isNotEmpty(endDate))
			criteria.add(Restrictions.sqlRestriction("postTime <= '"+endDate+" 23:59:59'"));
		criteria.add(Restrictions.eq("scope", NoticeModel.EScope.School.getValue()));
		criteria.add(Restrictions.eq("status", NoticeModel.EStatus.Published.getValue()));
		criteria.addOrder(Order.desc("postTime"));
		return noticeDAO.getListByCriteria(criteria);
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
		//noticeModel.setPostDepartmentId(userModel.getId());
		noticeModel.setPostTime(UtilDateTime.nowDate());
		noticeModel.setStatus(1);
		noticeModel.setPosterId(userModel.getId());
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

	@Override
	public List<NoticeModel> getTop5DepartmentNotice(String departments)
			throws ServiceException {
		// TODO Auto-generated method stub
		List<NoticeModel> result=new ArrayList<NoticeModel>();
		List<NoticeModel> list=getDepartmentNotice(null,null,departments);
		int countMax=5;
		for(int i=0;i<list.size()&&i<countMax;i++){
			result.add(list.get(i));
		}
		return result;
	}

	@Override
	public List<NoticeModel> getTop5SchoolNotice() throws ServiceException {
		// TODO Auto-generated method stub
		List<NoticeModel> result=new ArrayList<NoticeModel>();
		List<NoticeModel> list=getSchoolNotice(null,null);
		int countMax=5;
		for(int i=0;i<list.size()&&i<countMax;i++){
			result.add(list.get(i));
		}
		return result;
	}

	@Override
	public int addReadNumsByOne(String id) throws ServiceException {
		// TODO Auto-generated method stub
		NoticeModel notice= noticeDAO.get(id);
		if(notice.getStatus()!=0){
			notice.setReadNums(notice.getReadNums()+1);
			noticeDAO.merge(notice);
		}
		return notice.getReadNums();
	}

	@Override
	public PaginationSupport<NoticeModel> getFrontPageSchoolNoticesByConditions(
			String type, String emergence, String deparmentIds,
			String title, String beginDate, String endDate,  Integer pageSize, Integer startIndex) throws ServiceException {
		// TODO Auto-generated method stub
		return noticeDAO.getNoticesByConditions(type, NoticeModel.EScope.School.getValue()+"", emergence, deparmentIds, title, beginDate, endDate, pageSize, startIndex) ;
	}

}
