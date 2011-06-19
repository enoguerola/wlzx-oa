package system.wlims.oa.serviceImpl.schedule;

import java.util.List;

import system.wlims.oa.entity.schedule.ScheduleModel;
import system.wlims.oa.service.schedule.ScheduleService;

public class ScheduleServiceImpl implements ScheduleService {

	@Override
	public void addSchedule(ScheduleModel schedule) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean deleteScheduleById(String id) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public List<ScheduleModel> getSchedulesByConditions(String userId, String type,
			String scope, String emergence, String deparmentId, String title,
			String beginDate, String endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public boolean updateSchedule(ScheduleModel schedule) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean finishScheduleById(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}
