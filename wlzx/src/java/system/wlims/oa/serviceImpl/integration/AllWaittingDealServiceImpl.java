package system.wlims.oa.serviceImpl.integration;



import java.util.List;

import system.wlims.oa.dao.attendance.MoveRestDayDAO;
import system.wlims.oa.dao.attendance.OverWorkDAO;
import system.wlims.oa.dao.attendance.TakeLeaveDAO;
import system.wlims.oa.dao.course.adjust.CourseAdjustDAO;
import system.wlims.oa.dao.task.TaskDAO;
import system.wlims.oa.service.integration.AllWaittingDealService;
import system.wlims.oa.vo.TaskVO;


public class AllWaittingDealServiceImpl  implements AllWaittingDealService{
	private TaskDAO taskDAO;
	private CourseAdjustDAO courseAdjustDAO;
	private MoveRestDayDAO moveRestDayDAO;
	private OverWorkDAO overWorkDAO;
	private TakeLeaveDAO takeLeaveDAO;
	
	@Override
	public List<TaskVO> getAllWaittingDealTasksByCondition(String accountId,
			String status, String beginTime, String endTime) {
		// TODO Auto-generated method stub
		return null;
	}

	public TaskDAO getTaskDAO() {
		return taskDAO;
	}

	public void setTaskDAO(TaskDAO taskDAO) {
		this.taskDAO = taskDAO;
	}

	public CourseAdjustDAO getCourseAdjustDAO() {
		return courseAdjustDAO;
	}

	public void setCourseAdjustDAO(CourseAdjustDAO courseAdjustDAO) {
		this.courseAdjustDAO = courseAdjustDAO;
	}

	public MoveRestDayDAO getMoveRestDayDAO() {
		return moveRestDayDAO;
	}

	public void setMoveRestDayDAO(MoveRestDayDAO moveRestDayDAO) {
		this.moveRestDayDAO = moveRestDayDAO;
	}

	public OverWorkDAO getOverWorkDAO() {
		return overWorkDAO;
	}

	public void setOverWorkDAO(OverWorkDAO overWorkDAO) {
		this.overWorkDAO = overWorkDAO;
	}

	public TakeLeaveDAO getTakeLeaveDAO() {
		return takeLeaveDAO;
	}

	public void setTakeLeaveDAO(TakeLeaveDAO takeLeaveDAO) {
		this.takeLeaveDAO = takeLeaveDAO;
	}
	
	

}
