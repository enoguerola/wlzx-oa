package system.wlims.oa.serviceImpl.notice;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import system.DAOException;
import system.components.SecurityUserHolder;
import system.entity.UserModel;
import system.utils.StringUtils;
import system.utils.UtilDateTime;
import system.wlims.oa.dao.notice.NoticeDAO;
import system.wlims.oa.entity.notice.NoticeModel;
import system.wlims.oa.service.notice.NoticeService;

public class NoticeServiceImpl implements NoticeService {
	
	private NoticeDAO noticeDAO;

	@Override
	public void addNotice(NoticeModel notice) {
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
	}

	@Override
	public boolean deleteTakeLeaveById(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public NoticeModel getDetailInfoById(String id) {
		// TODO Auto-generated method stub
		return noticeDAO.get(id);
	}

	@Override
	public List<NoticeModel> getNoticesByConditions(String userId, String type,
			String scope, String emergence, String deparmentId, String title,
			String beginDate, String endDate, Integer index, Integer page) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(NoticeModel.class);
		
		if(StringUtils.isNotEmpty(userId))
			criteria.add(Restrictions.eq("posterId", userId));
		
		if(StringUtils.isNotEmpty(type))
			criteria.add(Restrictions.eq("type", type));
		
		if(StringUtils.isNotEmpty(scope))
			criteria.add(Restrictions.eq("scope", Integer.parseInt(scope)));
		
		if(StringUtils.isNotEmpty(emergence))
			criteria.add(Restrictions.eq("emergence", Integer.parseInt(emergence)));
		
		if(StringUtils.isNotEmpty(deparmentId))
			criteria.add(Restrictions.eq("postDepartmentId", deparmentId));
		
		if(StringUtils.isNotEmpty(title))
			criteria.add(Restrictions.like("title", title));
		
		if(StringUtils.isNotEmpty(beginDate))
			criteria.add(Restrictions.ge("postTime", beginDate));
		
		if(StringUtils.isNotEmpty(endDate))
			criteria.add(Restrictions.ge("postTime", endDate));
		
		criteria.add(Restrictions.eq("status", 1));
		
		return noticeDAO.getListByCriteria(criteria, (index - 1)*page, page);
	}

	@Override
	public NoticeModel loadNoticeInfoById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateNotice(NoticeModel notice) {
		// TODO Auto-generated method stub
		try{
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

}
