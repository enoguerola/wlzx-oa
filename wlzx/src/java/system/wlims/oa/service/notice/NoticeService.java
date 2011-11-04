package system.wlims.oa.service.notice;

import java.util.List;

import system.ServiceException;
import system.wlims.oa.entity.notice.NoticeModel;

public interface NoticeService {
	
	@SuppressWarnings("unchecked")
	public void addNotice(NoticeModel notice, String attachmentIds);
	
	public boolean updateNotice(NoticeModel notice, String adds,String removes);
	
	public NoticeModel loadNoticeInfoById(String id);
		
	public List<NoticeModel> getNoticesByConditions(String userId,String type,String scope,String emergence,String deparmentId,
			String title, String status, String beginDate,String endDate, Integer index, Integer page);
	
	boolean deleteNoticeById(String id);
	
	public List<NoticeModel> getDepartmentNotice(String beginDate, String endDate,String departments)throws ServiceException;
	
	public List<NoticeModel> getSchoolNotice(String beginDate, String endDate)throws ServiceException;
	public List<NoticeModel> getTop5DepartmentNotice(String departments)throws ServiceException;
	public List<NoticeModel> getTop5SchoolNotice()throws ServiceException;
	public boolean publish(String id)throws ServiceException;
	
	public NoticeModel get(String id)throws ServiceException;
	
	public int addReadNumsByOne(String id)throws ServiceException;

}
