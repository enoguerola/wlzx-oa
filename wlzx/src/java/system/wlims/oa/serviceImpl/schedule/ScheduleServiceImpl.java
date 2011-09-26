package system.wlims.oa.serviceImpl.schedule;

import java.util.List;

import system.dao.UserDAO;
import system.entity.PersonModel;
import system.entity.UserModel;
import system.wlims.oa.dao.schedule.ScheduleDAO;
import system.wlims.oa.entity.schedule.ScheduleModel;
import system.wlims.oa.service.schedule.ScheduleService;

public class ScheduleServiceImpl implements ScheduleService {
	private ScheduleDAO scheduleDAO;
	private UserDAO userDAO;
	@Override
	public void addSchedule(ScheduleModel schedule) {
		// TODO Auto-generated method stub
		UserModel user=userDAO.get(schedule.getPosterId());
		if(user.getAccountStyle()==PersonModel.PersonStyle.SuperRoot.getStyle()){
			schedule.setDepartmentId(null);
		}else{
			if(user.getMainDR()!=null)
			schedule.setDepartmentId(user.getMainDR().getDepartmentId());
		}
		scheduleDAO.saveOrUpdate(schedule);
	}
	@Override
	public ScheduleModel getSchedule(String id) {
		// TODO Auto-generated method stub
		return scheduleDAO.get(id);
	}
	@Override
	public boolean deleteSchedule(String id) {
		// TODO Auto-generated method stub
		ScheduleModel schedule=scheduleDAO.get(id);
		if(schedule!=null){
			scheduleDAO.remove(schedule);
			return true;
		}
		return false;
	}


	@Override
	public List<ScheduleModel> getSchedulesByConditions(String userId, String type,String state,
			String departmentShare,String departmentIds,String schoolShare, String emergence,  String title,
			String beginDate, String endDate) {
		// TODO Auto-generated method stub
		return scheduleDAO.getSchedulesByConditions(userId, type, state, departmentShare,departmentIds,schoolShare,emergence,  title, beginDate, endDate);
	}

	

	@Override
	public boolean updateSchedule(ScheduleModel schedule) {
		// TODO Auto-generated method stub
		ScheduleModel newSchedule=scheduleDAO.get(schedule.getId());
		newSchedule.setBeginTime(schedule.getBeginTime());
		newSchedule.setEndTime(schedule.getEndTime());
		newSchedule.setTitle(schedule.getTitle());
		newSchedule.setContent(schedule.getContent());
		newSchedule.setDepartmentShare(schedule.getDepartmentShare());
		newSchedule.setSchoolShare(schedule.getSchoolShare());
		newSchedule.setType(schedule.getType());
		newSchedule.setEmergence(schedule.getEmergence());
		newSchedule.setRepeatStatus(schedule.getRepeatStatus());
		newSchedule.setRepeatEndTime(schedule.getRepeatEndTime());
		newSchedule.setRepeatInterval(schedule.getRepeatInterval());
		newSchedule.setRepeatOnDays(schedule.getRepeatOnDays());
		newSchedule.setRepeatType(schedule.getRepeatType());
		scheduleDAO.merge(newSchedule);
		return true;
	}

	@Override
	public boolean finishSchedule(String id) {
		ScheduleModel schedule=scheduleDAO.get(id);
		if(schedule!=null){
			schedule.setFinishStatus(ScheduleModel.FinishStatus.Finished.getStatus());
			scheduleDAO.saveOrUpdate(schedule);
			return true;
		}
		return false;
	}

	public ScheduleDAO getScheduleDAO() {
		return scheduleDAO;
	}

	public void setScheduleDAO(ScheduleDAO scheduleDAO) {
		this.scheduleDAO = scheduleDAO;
	}
	public UserDAO getUserDAO() {
		return userDAO;
	}
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	@Override
	public boolean updateScheduleTime(String id, String beginTime,
			String endTime) {
		ScheduleModel schedule=scheduleDAO.get(id);
		if(schedule!=null){
			schedule.setBeginTime(beginTime);
			schedule.setEndTime(endTime);
			scheduleDAO.saveOrUpdate(schedule);
			return true;
		}
		return false;
	}
	@Override
	public List<ScheduleModel> getPublicSchedulesByConditions(String userId,
			String type, String state, String departmentIds, String emergence,
			String title, String beginDate, String endDate) {
		// TODO Auto-generated method stub
		return scheduleDAO.getPublicSchedulesByConditions(userId, type, state, departmentIds, emergence, title, beginDate, endDate);
	}
	@Override
	public List<ScheduleModel> getPersonSchedulesByConditions(String userId,
			String type, String state, String departmentIds, String emergence,
			String title, String beginDate, String endDate) {
		// TODO Auto-generated method stub
		return scheduleDAO.getPersonSchedulesByConditions(userId, type, state, departmentIds, emergence, title, beginDate, endDate);
	}

}
