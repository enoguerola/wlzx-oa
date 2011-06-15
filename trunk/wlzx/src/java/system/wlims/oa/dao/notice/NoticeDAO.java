package system.wlims.oa.dao.notice;


import java.util.List;

import system.BaseDAO;
import system.wlims.oa.entity.notice.NoticeModel;

public interface NoticeDAO  extends BaseDAO<NoticeModel>{

	public List<NoticeModel> getNoticesByConditions(String userId, String type,
			String scope, String emergence, String deparmentId, String title,
			String beginDate, String endDate) ;
}
