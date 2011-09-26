package system.wlims.oa.service.schedule;

import java.util.List;

import system.wlims.oa.entity.schedule.ScheduleModel;

public interface ScheduleService {
	public void addSchedule(ScheduleModel schedule);
	public boolean updateSchedule(ScheduleModel schedule);
	public List<ScheduleModel> getSchedulesByConditions(String userId, String type,String state,
			String departmentShare,String departmentIds,String schoolShare, String emergence,  String title,
			String beginDate, String endDate);
	public List<ScheduleModel> getPublicSchedulesByConditions(String userId, String type,String state,String departmentIds, String emergence,  String title,String beginDate, String endDate);
	public List<ScheduleModel> getPersonSchedulesByConditions(String userId, String type,String state,String departmentIds, String emergence,  String title,String beginDate, String endDate);
	boolean deleteSchedule(String id);
	public boolean finishSchedule(String id);
	public ScheduleModel getSchedule(String id);
	public boolean updateScheduleTime(String id,String beginTime,String endTime);
	
}
