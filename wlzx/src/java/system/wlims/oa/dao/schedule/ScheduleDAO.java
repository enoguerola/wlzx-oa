package system.wlims.oa.dao.schedule;


import java.util.List;

import system.BaseDAO;
import system.wlims.oa.entity.schedule.ScheduleModel;

public interface ScheduleDAO  extends BaseDAO<ScheduleModel>{

	public List<ScheduleModel> getSchedulesByConditions(String userId, String type,
			String scope, String emergence, String deparmentId, String title,
			String beginDate, String endDate) ;
}
