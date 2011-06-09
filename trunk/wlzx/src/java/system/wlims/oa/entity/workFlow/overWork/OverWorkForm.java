package system.wlims.oa.entity.workFlow.overWork;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import system.entity.workFlow.AbstractForm;

public class OverWorkForm extends AbstractForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2012439236604692460L;

	public OverWorkForm() {
		name = "加班申请单";
	}
	private String id;
	private String applyNo;
	private String teacherId;
	private String times;
	private String reason;
	
	private String officeChiefApproverId;
	private Integer officeChiefStatus;
	private Date officeChiefApproveTime;
	private String officeChiefApproveOption;
	private Integer status;
	private Set<OverWorkWorkFlowLog> logs=new TreeSet<OverWorkWorkFlowLog>();
	public static enum Status{
		Waiting(0, "待审批"),
		OfficePass(1, "审批通过"),
		OfficeDeny(2, "审批不通过"),
		Cancle(2, "取消");
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

	public String getApplyNo() {
		return applyNo;
	}

	public void setApplyNo(String applyNo) {
		this.applyNo = applyNo;
	}

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public String getTimes() {
		return times;
	}

	public void setTimes(String times) {
		this.times = times;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getOfficeChiefApproverId() {
		return officeChiefApproverId;
	}

	public void setOfficeChiefApproverId(String officeChiefApproverId) {
		this.officeChiefApproverId = officeChiefApproverId;
	}

	public Integer getOfficeChiefStatus() {
		return officeChiefStatus;
	}

	public void setOfficeChiefStatus(Integer officeChiefStatus) {
		this.officeChiefStatus = officeChiefStatus;
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

	public Set<OverWorkWorkFlowLog> getLogs() {
		return logs;
	}

	public void setLogs(Set<OverWorkWorkFlowLog> logs) {
		this.logs = logs;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
}
