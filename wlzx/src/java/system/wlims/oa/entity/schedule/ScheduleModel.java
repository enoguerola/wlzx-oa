package system.wlims.oa.entity.schedule;


import system.wlims.oa.entity.BaseModel;

public class ScheduleModel extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4150396257343191646L;

	/**
	 * 
	 */
	private String title;
	private String content;
	private String beginTime;
	private String endTime;
	private String posterId;
	private Integer type;
	private Integer share;
	private Integer emergence;
	private Integer finishStatus;
	private Integer submitStatus;
	private String departmentId;
	public static enum Type{
		Personal(1, "私人日程"),
		Working(2, "工作日程");
		private Integer status;
		private String name;
		
		private Type(Integer status, String name){
			this.setStatus(status);
			this.setName(name);
		}

		public void setStatus(Integer status) {
			this.status = status;
		}

		public Integer getStatus() {
			return status;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}
	public static enum Share{
		School(1, "学校共享"),
		Department(2, "部门共享");
		private Integer status;
		private String name;
		
		private Share(Integer status, String name){
			this.setStatus(status);
			this.setName(name);
		}

		public void setStatus(Integer status) {
			this.status = status;
		}

		public Integer getStatus() {
			return status;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}
	public static enum Emergence{
		ImportantEmergence(1, "重要紧急"),
		ImportantNotEmergence(2, "重要非紧急"),
		EmergenceNotImportant(2, "紧急非重要");
		private Integer status;
		private String name;
		
		private Emergence(Integer status, String name){
			this.setStatus(status);
			this.setName(name);
		}

		public void setStatus(Integer status) {
			this.status = status;
		}

		public Integer getStatus() {
			return status;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}
	public static enum FinishStatus{
		OnGoing(1, "进行中"),
		Finished(2, "已完结");
		private Integer status;
		private String name;
		
		private FinishStatus(Integer status, String name){
			this.setStatus(status);
			this.setName(name);
		}

		public void setStatus(Integer status) {
			this.status = status;
		}

		public Integer getStatus() {
			return status;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}
	public static enum SubmitStatus{
		NotSubmit(1, "未提交"),
		AlreadySubmit(2, "已提交");
		private Integer status;
		private String name;
		
		private SubmitStatus(Integer status, String name){
			this.setStatus(status);
			this.setName(name);
		}

		public void setStatus(Integer status) {
			this.status = status;
		}

		public Integer getStatus() {
			return status;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public String getPosterId() {
		return posterId;
	}
	public void setPosterId(String posterId) {
		this.posterId = posterId;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getShare() {
		return share;
	}
	public void setShare(Integer share) {
		this.share = share;
	}
	public Integer getEmergence() {
		return emergence;
	}
	public void setEmergence(Integer emergence) {
		this.emergence = emergence;
	}
	public Integer getFinishStatus() {
		return finishStatus;
	}
	public void setFinishStatus(Integer finishStatus) {
		this.finishStatus = finishStatus;
	}
	public Integer getSubmitStatus() {
		return submitStatus;
	}
	public void setSubmitStatus(Integer submitStatus) {
		this.submitStatus = submitStatus;
	}
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
}
