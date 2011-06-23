package system.wlims.oa.service.notice;

import java.util.List;

import com.sun.swing.internal.plaf.basic.resources.basic;

import system.ServiceException;
import system.wlims.oa.entity.notice.NoticeModel;

public interface NoticeService {
	
	public void addNotice(NoticeModel notice);
	
	public boolean updateNotice(NoticeModel notice);
	
	public NoticeModel loadNoticeInfoById(String id);
		
	public List<NoticeModel> getNoticesByConditions(String userId,String type,String scope,String emergence,String deparmentId,
			String title, String status, String beginDate,String endDate, Integer index, Integer page);
	
	boolean remove(String id);
	
	public List<NoticeModel> getDepartmentNotice(Integer index, Integer page)throws ServiceException;
	
	public List<NoticeModel> getSchoolNotice(Integer index, Integer page)throws ServiceException;
	
	public boolean publish(String id)throws ServiceException;

}
