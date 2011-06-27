package system.wlims.oa;


import system.BaseTest;
import system.dao.UserDAO;
import system.wlims.oa.dao.schedule.ScheduleDAO;

public class ScheduleTest extends BaseTest {

	private ScheduleDAO scheduleDAO;
	private UserDAO userDAO;
	
	public ScheduleTest(){
		setScheduleDAO((ScheduleDAO)applicationContext.getBean("scheduleDAO"));
		setUserDAO((UserDAO)applicationContext.getBean("userDAO"));
	}
	
	public void getSchedulesByConditionsTest(String userId, String type,String state,
			String departmentShare,String departmentId,String schoolShare, String emergence,  String title,
			String beginDate, String endDate){
		scheduleDAO.getSchedulesByConditions(userId, type, state, departmentShare,departmentId, schoolShare,emergence, title, beginDate, endDate);
	}
	public static void main(String[] args){
		ScheduleTest test = new ScheduleTest();
		String userId="2";
		String scheduleScope=null;
		String scheduleState=null;
		String scheduleBeginDate="2011-06-19";
		String scheduleEndDate="2011-06-23";
		test.getSchedulesByConditionsTest(userId,scheduleScope,scheduleState,null,null,null,null,null,scheduleBeginDate,scheduleEndDate);
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public ScheduleDAO getScheduleDAO() {
		return scheduleDAO;
	}

	public void setScheduleDAO(ScheduleDAO scheduleDAO) {
		this.scheduleDAO = scheduleDAO;
	}
}
