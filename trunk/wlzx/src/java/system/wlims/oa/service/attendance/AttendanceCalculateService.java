package system.wlims.oa.service.attendance;

import java.util.List;

import system.wlims.oa.entity.workFlow.moveRestDay.MoveRestDayForm;
import system.wlims.oa.entity.workFlow.overWork.OverWorkForm;
import system.wlims.oa.entity.workFlow.takeLeave.TakeLeaveForm;
import system.wlims.oa.vo.AttendanceCalculateVO;


public interface AttendanceCalculateService {
	public int getSectionsOfValidTakeLeave(String userId,String beginTime,String endTime,String type);
	public int getSectionsOfValidOverWork(String userId,String beginTime,String endTime);
	public int getSectionsOfValidMoveRestDay(String userId,String beginTime,String endTime);
	public int getTimesOfValidTakeLeave(String userId,String beginTime,String endTime,String type);
	public int getTimesOfValidOverWork(String userId,String beginTime,String endTime);
	public int getTimesOfValidMoveRestDay(String userId,String beginTime,String endTime);
	public List<AttendanceCalculateVO> getCalculateAttendanceByCondition(String type,String userId,String departmentId,String beginTime,String endTime);
	
	public List<TakeLeaveForm> getValidTakeLeave_LeaveAttendanceByCondition(String userId,String beginTime,String endTime);
	public List<TakeLeaveForm> getValidTakeLeave_BusinessTripAttendanceByCondition(String userId,String beginTime,String endTime);
	public List<OverWorkForm> getValidOverWorkAttendanceByCondition(String userId,String beginTime,String endTime);
	public List<MoveRestDayForm> getValidMoveRestDayAttendanceByCondition(String userId,String beginTime,String endTime);

	
	
}
