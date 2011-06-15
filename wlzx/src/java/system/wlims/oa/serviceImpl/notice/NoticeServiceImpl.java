package system.wlims.oa.serviceImpl.notice;

import java.util.List;

import system.wlims.oa.entity.notice.NoticeModel;
import system.wlims.oa.service.notice.NoticeService;

public class NoticeServiceImpl implements NoticeService {

	@Override
	public void addNotice(NoticeModel notice) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean deleteTakeLeaveById(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public NoticeModel getDetailInfoById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NoticeModel> getNoticesByConditions(String userId, String type,
			String scope, String emergence, String deparmentId, String title,
			String beginDate, String endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NoticeModel loadNoticeInfoById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateNotice(NoticeModel notice) {
		// TODO Auto-generated method stub
		return false;
	}

}
