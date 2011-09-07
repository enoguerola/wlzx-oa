package system.wlims.oa.vo;

public class TaskVO {
	private String type;
	private int typeId;
	private String id;
	private String title;
	private String postTime;
	private String assignerId;
	private String workersIds;
	private String status;
	public static enum EType{
		Task(1, "领导指派"),
		CourseAdjust_Approve(2, "调课审批"),
		CourseAdjust_Arrange(16, "调课审批"),
		AskForLeave_Leave_TechArrange(3, "请假工作安排"),
		AskForLeave_Leave_OfficalApprove(4, "请假处室审批"),
		AskForLeave_Leave_VicePrincipalApprove(5, "请假副校长审批"),
		AskForLeave_Leave_PrincipalApprove(6, "请假校长审批"),
		AskForLeave_BusinessTrip_TechArrange(7, "出差工作安排"),
		AskForLeave_BusinessTrip_OfficalApprove(8, "出差审批"),
		AskForLeave_BusinessTrip_VicePrincipalApprove(9, "出差审批"),
		AskForLeave_BusinessTrip_PrincipalApprove(10, "出差审批"),
		AskForLeave_Cancle(11, "销假审批"),
		OverWork_OfficalApprove(12, "加班处室审批"),
		MoveRestDay_OfficalApprove(13, "调休处室审批"),
		MoveRestDay_VicePrincipalApprove(14, "调休副校长审批"),
		Conference_Approve(15, "会议室安排落实");
		
		private Integer value;
		private String text;
		
		EType(Integer value, String text){
			this.value = value;
			this.text = text;
		}
		
		public Integer getValue(){
			return value;
		}
		
		public String getText(){
			return this.text;
		}
	}
	public static enum ETitle{
		Task(1, "领导指派"),
		CourseAdjust_Approve(2, "您有一项调课申请需要进行审批"),
		CourseAdjust_Arrange(16, "您有一项调课课务需要进行安排"),
		AskForLeave_Leave_TechArrange(3, "您有一件请假的教学工作需要安排"),
		AskForLeave_Leave_OfficalApprove(4, "您有一件请假申请事务需要处理"),
		AskForLeave_Leave_VicePrincipalApprove(5, "您有一件请假申请事务需要处理"),
		AskForLeave_Leave_PrincipalApprove(6, "您有一件请假申请事务需要处理"),
		AskForLeave_BusinessTrip_TechArrange(7, "您有一件出差的教学工作需要安排"),
		AskForLeave_BusinessTrip_OfficalApprove(8, "您有一件出差申请事务需要处理"),
		AskForLeave_BusinessTrip_VicePrincipalApprove(9, "您有一件出差申请事务需要处理"),
		AskForLeave_BusinessTrip_PrincipalApprove(10, "您有一件出差申请事务需要处理"),
		
		AskForLeave_Cancle(11, "您有一件销假申请事务需要处理"),
		OverWork_OfficalApprove(12, "您有一件加班申请事务需要处理"),
		MoveRestDay_OfficalApprove(13, "您有一件调休申请事务需要处理"),
		MoveRestDay_VicePrincipalApprove(14, "您有一件调休申请事务需要处理"),
		Conference_Approve(15, "您有一件会议室申请需要审批落实");
		
		private Integer value;
		private String text;
		
		ETitle(Integer value, String text){
			this.value = value;
			this.text = text;
		}
		
		public Integer getValue(){
			return value;
		}
		
		public String getText(){
			return this.text;
		}
	}
	public static enum EStatus{
		ToBeDeal(1, "待处理"),
		OnGoing(2, "审批中"),
		Finished(3,"已落实"),
		Cancled(4,"已取消");
		private Integer value;
		private String text;
		
		EStatus(Integer value, String text){
			this.value = value;
			this.text = text;
		}
		
		public Integer getValue(){
			return value;
		}
		
		public String getText(){
			return this.text;
		}
	}
	public static enum EAssigner{
		Default(-1, "系统");
		private Integer value;
		private String text;
		
		EAssigner(Integer value, String text){
			this.value = value;
			this.text = text;
		}
		
		public Integer getValue(){
			return value;
		}
		
		public String getText(){
			return this.text;
		}
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPostTime() {
		return postTime;
	}
	public void setPostTime(String postTime) {
		this.postTime = postTime;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAssignerId() {
		return assignerId;
	}
	public void setAssignerId(String assignerId) {
		this.assignerId = assignerId;
	}
	public String getWorkersIds() {
		return workersIds;
	}
	public void setWorkersIds(String workersIds) {
		this.workersIds = workersIds;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

}
