package system.wlims.oa.service.notice;

import java.util.List;

import system.wlims.oa.entity.notice.NoticeModel;

public interface NoticeService {
	public void addNotice(NoticeModel notice);
	public boolean updateNotice(NoticeModel notice);
	public NoticeModel loadNoticeInfoById(String id);
	public NoticeModel getDetailInfoById(String id);
	public List<NoticeModel> getNoticesByConditions(String userId,String type,String scope,String emergence,String deparmentId,
			String title,String beginDate,String endDate, Integer index, Integer page);
	boolean deleteTakeLeaveById(String id);

}
