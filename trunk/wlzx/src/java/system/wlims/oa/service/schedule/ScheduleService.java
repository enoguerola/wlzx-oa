package system.wlims.oa.service.schedule;

import java.util.List;

import system.wlims.oa.entity.schedule.ScheduleModel;

public interface ScheduleService {
	public void addSchedule(ScheduleModel schedule);
	public boolean updateSchedule(ScheduleModel schedule);
	public List<ScheduleModel> getSchedulesByConditions(String userId, String type,String shares, String emergence, String deparmentId, String title,String beginDate, String endDate);
	boolean deleteSchedule(String id);
	public boolean finishSchedule(String id);
	public ScheduleModel getSchedule(String id);
}
