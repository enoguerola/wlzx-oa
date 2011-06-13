package system.wlims.oa.entity.workFlow.takeLeave;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import system.entity.workFlow.AbstractForm;

public class TakeLeaveForm extends AbstractForm {

	/**
	 * 
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
	private String endTime;
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
		Cancle(5, "取消");
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
}
