package system.wlims.oa.service.attendance;

import java.util.List;

import system.wlims.oa.vo.AttendanceCalculateVO;


public interface AttendanceCalculateService {
	public int getSectionsOfValidTakeLeave(String userId,String beginTime,String endTime,String type);
	public int getSectionsOfValidOverWork(String userId,String beginTime,String endTime);
	public int getSectionsOfValidMoveRestDay(String userId,String beginTime,String endTime);
	public int getTimesOfValidTakeLeave(String userId,String beginTime,String endTime,String type);
	public int getTimesOfValidOverWork(String userId,String beginTime,String endTime);
	public int getTimesOfValidMoveRestDay(String userId,String beginTime,String endTime);
	public List<AttendanceCalculateVO> getCalculateAttendanceByCondition(String userId,String departmentId,String beginTime,String endTime);
}
