package system.wlims.oa.entity.workFlow.takeLeave;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import system.constants.Constants;
import system.entity.BaseModel;
import system.entity.workFlow.AbstractForm;

public class TakeLeaveForm extends AbstractForm implements Comparable<TakeLeaveForm>{

	/**
	 * 1.请假人在行政组【0级部门】---教学1级审批权限人审批【课程处】--教学2级审批权限人审批【教学副校长】--所有审批权限人审批【校长】----------通过给行政组的人配置教学职务来绕开
	 * 2.请假人拥有教学职务『
	 * 					主职务含有教学职务（“教师”“教研组长”）:教学1级审批权限人审批【课程处】--教学2级审批权限人审批【教学副校长】--所有审批权限人审批【校长】
	 * 					副职务含有教学职务（“教师”“教研组长”）:1级下属审批权限【本部门处长】--2级下属审批权限【本部门分管副校长】--所有审批权限人审批【校长】；通知拥有教学1级审批权限人审批的人【课程处】
	 * 				』
	 * 3.其他---1级下属审批权限【本部门处长】--2级下属审批权限【本部门分管副校长】--所有审批权限人审批【校长】
	 */
	private static final long serialVersionUID = -4962937018669042405L;
	public TakeLeaveForm() {
		name = "请假/出差申请单";
	}
	private String id;
	private String applyNo;
	private Integer type;
	private String teacherId;
	private String beginTime;
	private String beginDate;
	private String endTime;
	private String endDate;
	public String getBeginDate() {
		String[] ss = beginTime.split(" ");
		if(ss[1].equalsIgnoreCase("0")){
			return ss[0]+" 上午";
		}else if(ss[1].equalsIgnoreCase("1")){
			return ss[0]+" 下午";
		}else{
			return ss[0]+" 晚上";
		}
	}
	public String getEndDate() {
		String[] ss = endTime.split(" ");
		if(ss[1].equalsIgnoreCase("0")){
			return ss[0]+" 上午";
		}else if(ss[1].equalsIgnoreCase("1")){
			return ss[0]+" 下午";
		}else{
			return ss[0]+" 晚上";
		}
	}
	private String reason;
	private String arrangeTech;
	private String arrangeService;
	private String arrangeManage;
	private Boolean arrangeTechDealAlready;
	private Boolean arrangeServiceDealAlready;
	private Boolean arrangeManageDealAlready;
	private String officeChiefApproverId;
	private Integer officeChiefStatus;
	private Integer vicePrincipalStatus;
	private Integer principalStatus;
	private Date officeChiefApproveTime;
	private String officeChiefApproveOption;
	private String vicePrincipalApproverId;
	private Date vicePrincipalApproveTime;
	private String vicePrincipalApproveOption; 
	private String principalApproverId;
	private Date principalApproveTime;
	private String principalApproveOption; 
	private String remark;
	private Integer status;
	private Set<TakeLeaveWorkFlowLog> logs=new TreeSet<TakeLeaveWorkFlowLog>();
	private Set<TakeLeaveTerminateForm> terminateForms=new TreeSet<TakeLeaveTerminateForm>();
	public static enum Rules{
		FirstApprove(1, "处室负责人审批"),
		SecordApprove(2, "分管副校长审批"),
		ThirdApprove(3, "校长审批");
		private Integer value;
		private String name;
		
		private Rules(Integer value, String name){
			this.setValue(value);
			this.setName(name);
		}

		public void setValue(Integer value) {
			this.value = value;
		}

		public Integer getValue() {
			return value;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}
	public static enum Types{
		Leave(0, "请假"),
		BusinessTrip(1, "出差");
		private Integer value;
		private String name;
		
		private Types(Integer value, String name){
			this.setValue(value);
			this.setName(name);
		}

		public void setValue(Integer value) {
			this.value = value;
		}

		public Integer getValue() {
			return value;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}
	public static enum Status{
		Waiting(0, "待审批"),
		OfficePass(1, "审批中-处室通过"),
		VicePrincipalPass(2, "审批中-分管副校长通过"),
		Pass(3, "审批通过"),
		Deny(4, "审批不通过"),
		Cancle(5, "取消"),
		TerminateWaiting(6, "等待销假审批"),
		TerminatePass(7, "销假审批通过"),
		TerminateDeny(8, "销假审批不通过");
		private Integer value;
		private String name;
		
		private Status(Integer value, String name){
			this.setValue(value);
			this.setName(name);
		}

		public void setValue(Integer value) {
			this.value = value;
		}

		public Integer getValue() {
			return value;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getArrangeTech() {
		return arrangeTech;
	}
	public void setArrangeTech(String arrangeTech) {
		this.arrangeTech = arrangeTech;
	}
	public String getArrangeService() {
		return arrangeService;
	}
	public void setArrangeService(String arrangeService) {
		this.arrangeService = arrangeService;
	}
	public String getArrangeManage() {
		return arrangeManage;
	}
	public void setArrangeManage(String arrangeManage) {
		this.arrangeManage = arrangeManage;
	}
	public String getOfficeChiefApproverId() {
		return officeChiefApproverId;
	}
	public void setOfficeChiefApproverId(String officeChiefApproverId) {
		this.officeChiefApproverId = officeChiefApproverId;
	}
	public Date getOfficeChiefApproveTime() {
		return officeChiefApproveTime;
	}
	public void setOfficeChiefApproveTime(Date officeChiefApproveTime) {
		this.officeChiefApproveTime = officeChiefApproveTime;
	}
	public String getOfficeChiefApproveOption() {
		return officeChiefApproveOption;
	}
	public void setOfficeChiefApproveOption(String officeChiefApproveOption) {
		this.officeChiefApproveOption = officeChiefApproveOption;
	}
	public String getVicePrincipalApproverId() {
		return vicePrincipalApproverId;
	}
	public void setVicePrincipalApproverId(String vicePrincipalApproverId) {
		this.vicePrincipalApproverId = vicePrincipalApproverId;
	}
	public Date getVicePrincipalApproveTime() {
		return vicePrincipalApproveTime;
	}
	public void setVicePrincipalApproveTime(Date vicePrincipalApproveTime) {
		this.vicePrincipalApproveTime = vicePrincipalApproveTime;
	}
	public String getVicePrincipalApproveOption() {
		return vicePrincipalApproveOption;
	}
	public void setVicePrincipalApproveOption(String vicePrincipalApproveOption) {
		this.vicePrincipalApproveOption = vicePrincipalApproveOption;
	}
	public String getPrincipalApproverId() {
		return principalApproverId;
	}
	public void setPrincipalApproverId(String principalApproverId) {
		this.principalApproverId = principalApproverId;
	}
	public Date getPrincipalApproveTime() {
		return principalApproveTime;
	}
	public void setPrincipalApproveTime(Date principalApproveTime) {
		this.principalApproveTime = principalApproveTime;
	}
	public String getPrincipalApproveOption() {
		return principalApproveOption;
	}
	public void setPrincipalApproveOption(String principalApproveOption) {
		this.principalApproveOption = principalApproveOption;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Set<TakeLeaveWorkFlowLog> getLogs() {
		return logs;
	}
	public void setLogs(Set<TakeLeaveWorkFlowLog> logs) {
		this.logs = logs;
	}
	public String getApplyNo() {
		return applyNo;
	}
	public void setApplyNo(String applyNo) {
		this.applyNo = applyNo;
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
	public Boolean getArrangeTechDealAlready() {
		return arrangeTechDealAlready;
	}
	public void setArrangeTechDealAlready(Boolean arrangeTechDealAlready) {
		this.arrangeTechDealAlready = arrangeTechDealAlready;
	}
	public Boolean getArrangeServiceDealAlready() {
		return arrangeServiceDealAlready;
	}
	public void setArrangeServiceDealAlready(Boolean arrangeServiceDealAlready) {
		this.arrangeServiceDealAlready = arrangeServiceDealAlready;
	}
	public Boolean getArrangeManageDealAlready() {
		return arrangeManageDealAlready;
	}
	public void setArrangeManageDealAlready(Boolean arrangeManageDealAlready) {
		this.arrangeManageDealAlready = arrangeManageDealAlready;
	}
	public Integer getOfficeChiefStatus() {
		return officeChiefStatus;
	}
	public void setOfficeChiefStatus(Integer officeChiefStatus) {
		this.officeChiefStatus = officeChiefStatus;
	}
	public Integer getVicePrincipalStatus() {
		return vicePrincipalStatus;
	}
	public void setVicePrincipalStatus(Integer vicePrincipalStatus) {
		this.vicePrincipalStatus = vicePrincipalStatus;
	}
	public Integer getPrincipalStatus() {
		return principalStatus;
	}
	public void setPrincipalStatus(Integer principalStatus) {
		this.principalStatus = principalStatus;
	}
	@SuppressWarnings("finally")
	public int getSections(){
		int result=0;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date d1= df.parse(getBeginTime().split(" ")[0]);
		    Date d2 = df.parse(getEndTime().split(" ")[0]);
		    long diff = d2.getTime() - d1.getTime();
		    long days = diff / (1000 * 60 * 60 * 24);
		    result+=days*Constants.DaysOfSections+(Integer.parseInt(getEndTime().split(" ")[1])-Integer.parseInt(getBeginTime().split(" ")[1]));
	    }catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return result;
		}
	}
	public Set<TakeLeaveTerminateForm> getTerminateForms() {
		return terminateForms;
	}
	public void setTerminateForms(Set<TakeLeaveTerminateForm> terminateForms) {
		this.terminateForms = terminateForms;
	}
	public TakeLeaveTerminateForm getTakeLeaveTerminateForm() {
		if(getTerminateForms()!=null&&getTerminateForms().size()>0)
			return getTerminateForms().iterator().next();
		else return null;
	}
	  @Override  
	    public boolean equals(Object obj) {  
	        return getId().equals(((BaseModel)obj).getId());  
	    }
	    @Override  
	    public int hashCode() {  
	        // TODO Auto-generated method stub  
	        return   Integer.parseInt(getId()) ;
	    } 
		/* (non-Javadoc)
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		@Override
		public int compareTo(TakeLeaveForm form) {
			// TODO Auto-generated method stub
			return this.id.compareTo(form.id);//这里的compareTo方法是String中的，String已实现 Comparable接口，按照字母顺序来排序的。它返回的也是int（1,,0,,-1）同时实现了对字母排序。比如，有年龄相同的姓名不相同的元素，那么就会按字母顺序来排，如果都一样，则就是同一元素
		}
}
