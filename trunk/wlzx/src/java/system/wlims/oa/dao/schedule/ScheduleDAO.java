package system.wlims.oa.dao.schedule;


import java.util.List;

import system.BaseDAO;
import system.wlims.oa.entity.schedule.ScheduleModel;

public interface ScheduleDAO  extends BaseDAO<ScheduleModel>{

	public List<ScheduleModel> getSchedulesByConditions(String userId, String type,String state,
			String departmentShare,String departmentIds,String schoolShare, String emergence,  String title,
			String beginDate, String endDate) ;
}
