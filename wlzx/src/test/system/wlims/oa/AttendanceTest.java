package system.wlims.oa;


import java.util.List;

import system.BaseTest;
import system.wlims.oa.dao.attendance.TakeLeaveDAO;
import system.wlims.oa.entity.workFlow.takeLeave.TakeLeaveForm;

public class AttendanceTest extends BaseTest {

	private TakeLeaveDAO takeLeaveDAO;
	
	public AttendanceTest(){
		setTakeLeaveDAO((TakeLeaveDAO)applicationContext.getBean("takeLeaveDAO"));
	}
	
	public void getTakeLeaveAppliesByConditions(String teacherId, String type, String status,
			String submitBeginDate, String submitEndDate,
			String takeLeaveBeginDate, String takeLeaveEndDate){
		
		List<TakeLeaveForm> list=takeLeaveDAO.getTakeLeaveAppliesByConditions(teacherId, type, status, submitBeginDate, submitEndDate, takeLeaveBeginDate, takeLeaveEndDate);
		System.out.println(list.size());
	}
	public static void main(String[] args){
		AttendanceTest test = new AttendanceTest();
		
		test.getTakeLeaveAppliesByConditions(null,null,null,null,null,null,null);
	}



	public TakeLeaveDAO getTakeLeaveDAO() {
		return takeLeaveDAO;
	}

	public void setTakeLeaveDAO(TakeLeaveDAO takeLeaveDAO) {
		this.takeLeaveDAO = takeLeaveDAO;
	}
}
