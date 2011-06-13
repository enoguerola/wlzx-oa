package system.wlims.oa.service.attendance;


public interface AttendanceCalculateService {
	public int getSectionsOfValidTakeLeave(String teacherId,String beginTime,String endTime,String type);
	public int getSectionsOfValidOverWork(String teacherId,String beginTime,String endTime);
	public int getSectionsOfValidMoveRestDay(String teacherId,String beginTime,String endTime);

}
