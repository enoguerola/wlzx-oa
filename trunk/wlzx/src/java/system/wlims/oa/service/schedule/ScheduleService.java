package system.wlims.oa.service.schedule;

import java.util.List;

import system.wlims.oa.entity.schedule.ScheduleModel;

public interface ScheduleService {
	public void addSchedule(ScheduleModel schedule);
	public boolean updateSchedule(ScheduleModel schedule);
	public List<ScheduleModel> getSchedulesByConditions(String userId,String type,String scope,String emergence,String deparmentId,String title,String beginDate,String endDate);
	boolean deleteScheduleById(String id);
	public boolean finishScheduleById(String id);

}
