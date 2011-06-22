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
	private String shares;
	private Integer emergence;
	private Integer finishStatus;
	private Integer submitStatus;
	private String departmentId;
	private Integer repeatStatus;
	private Integer repeatType;
	private Integer repeatInterval;
	private String repeatOnDays;
	private String repeatEndTime;

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
		EmergenceNotImportant(3, "紧急非重要");
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
	public static enum RepeatStatus{
		Repeat(1, "循环"),
		NotRepeat(2, "不循环");
		private Integer status;
		private String name;
		
		private RepeatStatus(Integer status, String name){
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
	public static enum RepeatType{
		VariantDaily(0, "每日"),
		VariantEveryWeekday(1, "每工作日 (周一.-周五.)"),
		VariantMoWedFri(2, "每周一、周三、周五"),
		VariantTuesThurs(3, "每周二、周四"),
		VariantWeekly(4, "每周"),
		VariantMonthly(5, "每月"),
		VariantYearly(6, "每年");
		private Integer status;
		private String name;
		
		private RepeatType(Integer status, String name){
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
	public Integer getRepeatStatus() {
		return repeatStatus;
	}
	public void setRepeatStatus(Integer repeatStatus) {
		this.repeatStatus = repeatStatus;
	}
	public Integer getRepeatType() {
		return repeatType;
	}
	public void setRepeatType(Integer repeatType) {
		this.repeatType = repeatType;
	}
	public Integer getRepeatInterval() {
		return repeatInterval;
	}
	public void setRepeatInterval(Integer repeatInterval) {
		this.repeatInterval = repeatInterval;
	}
	public String getRepeatOnDays() {
		return repeatOnDays;
	}
	public void setRepeatOnDays(String repeatOnDays) {
		this.repeatOnDays = repeatOnDays;
	}
	public String getRepeatEndTime() {
		return repeatEndTime;
	}
	public void setRepeatEndTime(String repeatEndTime) {
		this.repeatEndTime = repeatEndTime;
	}
	public String getShares() {
		return shares;
	}
	public void setShares(String shares) {
		this.shares = shares;
	}
}
