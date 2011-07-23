package system.wlims.oa.entity.workFlow.takeLeave;


import java.util.Date;

import system.entity.workFlow.AbstractForm;

public class TakeLeaveTerminateForm extends AbstractForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8295088382974954038L;
	/**
	 * 
	 */
	public TakeLeaveTerminateForm() {
		name = "请假/出差销假申请单";
	}

	private String id;
	private String terminateDateTime;
	private String terminateReason;
	private Date terminateApplyTime;
	private String terminateOfficeApproverId;
	private String terminateOfficeApproverOption;
	private Date terminateApproveTime;
	private Integer status;
	private TakeLeaveForm takeLeaveForm;
	public static enum Rules{
		FirstApprove(1, "处室负责人审批");
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
	
	public static enum Status{
		Waiting(0, "待审批"),
		Pass(1, "审批通过"),
		Deny(2, "审批不通过");
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
	public String getTerminateDateTime() {
		return terminateDateTime;
	}
	public void setTerminateDateTime(String terminateDateTime) {
		this.terminateDateTime = terminateDateTime;
	}
	public String getTerminateReason() {
		return terminateReason;
	}
	public void setTerminateReason(String terminateReason) {
		this.terminateReason = terminateReason;
	}
	public Date getTerminateApplyTime() {
		return terminateApplyTime;
	}
	public void setTerminateApplyTime(Date terminateApplyTime) {
		this.terminateApplyTime = terminateApplyTime;
	}
	public String getTerminateOfficeApproverId() {
		return terminateOfficeApproverId;
	}
	public void setTerminateOfficeApproverId(String terminateOfficeApproverId) {
		this.terminateOfficeApproverId = terminateOfficeApproverId;
	}
	public String getTerminateOfficeApproverOption() {
		return terminateOfficeApproverOption;
	}
	public void setTerminateOfficeApproverOption(
			String terminateOfficeApproverOption) {
		this.terminateOfficeApproverOption = terminateOfficeApproverOption;
	}
	public Date getTerminateApproveTime() {
		return terminateApproveTime;
	}
	public void setTerminateApproveTime(Date terminateApproveTime) {
		this.terminateApproveTime = terminateApproveTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public TakeLeaveForm getTakeLeaveForm() {
		return takeLeaveForm;
	}
	public void setTakeLeaveForm(TakeLeaveForm takeLeaveForm) {
		this.takeLeaveForm = takeLeaveForm;
	}
	
}
