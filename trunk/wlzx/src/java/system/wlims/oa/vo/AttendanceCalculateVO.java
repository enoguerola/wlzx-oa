package system.wlims.oa.vo;

public class AttendanceCalculateVO {
	private String userID;
	private String userAccount;
	private String departmentName;
	private String userName;
	private String type;
	private int takeLeave_leaveTimes;
	private int takeLeave_leaveDaySections;
	private int takeLeave_businessTripTimes;
	private int takeLeave_businessTripDaySections;
	private int overWorkTimes;
	private int overWorkDaySections;
	private int moveRestDayTimes;
	private int moveRestDayDaySections;
	private String beginTime;
	private String endTime;
	private int times;//冗余
	private double daySections;//冗余
	private String typeName;//冗余
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getTakeLeave_leaveTimes() {
		return takeLeave_leaveTimes;
	}
	public void setTakeLeave_leaveTimes(int takeLeaveLeaveTimes) {
		takeLeave_leaveTimes = takeLeaveLeaveTimes;
	}
	public int getTakeLeave_leaveDaySections() {
		return takeLeave_leaveDaySections;
	}
	public void setTakeLeave_leaveDaySections(int takeLeaveLeaveDaySections) {
		takeLeave_leaveDaySections = takeLeaveLeaveDaySections;
	}
	public int getTakeLeave_businessTripTimes() {
		return takeLeave_businessTripTimes;
	}
	public void setTakeLeave_businessTripTimes(int takeLeaveBusinessTripTimes) {
		takeLeave_businessTripTimes = takeLeaveBusinessTripTimes;
	}
	public int getTakeLeave_businessTripDaySections() {
		return takeLeave_businessTripDaySections;
	}
	public void setTakeLeave_businessTripDaySections(
			int takeLeaveBusinessTripDaySections) {
		takeLeave_businessTripDaySections = takeLeaveBusinessTripDaySections;
	}
	public int getOverWorkTimes() {
		return overWorkTimes;
	}
	public void setOverWorkTimes(int overWorkTimes) {
		this.overWorkTimes = overWorkTimes;
	}
	public int getOverWorkDaySections() {
		return overWorkDaySections;
	}
	public void setOverWorkDaySections(int overWorkDaySections) {
		this.overWorkDaySections = overWorkDaySections;
	}
	public int getMoveRestDayTimes() {
		return moveRestDayTimes;
	}
	public void setMoveRestDayTimes(int moveRestDayTimes) {
		this.moveRestDayTimes = moveRestDayTimes;
	}
	public int getMoveRestDayDaySections() {
		return moveRestDayDaySections;
	}
	public void setMoveRestDayDaySections(int moveRestDayDaySections) {
		this.moveRestDayDaySections = moveRestDayDaySections;
	}
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getTimes() {
		return times;
	}
	public void setTimes(int times) {
		this.times = times;
	}
	public double getDaySections() {
		return daySections;
	}
	public void setDaySections(double daySections) {
		this.daySections = daySections;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
}
