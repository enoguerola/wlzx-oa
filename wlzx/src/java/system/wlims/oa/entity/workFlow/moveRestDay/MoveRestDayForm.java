package system.wlims.oa.entity.workFlow.moveRestDay;


import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import system.entity.workFlow.AbstractForm;

public class MoveRestDayForm extends AbstractForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4062245718060317411L;

	/**
	 * 
	 */

	public MoveRestDayForm() {
		name = "调休申请单";
	}
	private String id;
	private String applyNo;
	private String teacherId;
	private String times;
	
	private String time;
	private String reason;
	
	private String officeChiefApproverId;
	private Integer officeChiefStatus;
	private Date officeChiefApproveTime;
	private String officeChiefApproveOption;
	
	private String vicePrincipalApproverId;
	private Integer vicePrincipalStatus;
	private Date vicePrincipalApproveTime;
	private String vicePrincipalApproveOption; 
	
	
	private Integer status;
	private Set<MoveRestDayWorkFlowLog> logs=new TreeSet<MoveRestDayWorkFlowLog>();
	
	
	public String getTime() {
		String[] ss = times.split(";");
		String temp ="" ;
		for(int i=0;i<ss.length;i++){
			String[] nn = ss[i].split(" ");
			String[] tt = nn[1].split("-");
			temp =temp+"  "+nn[0];
			if(tt[0].equalsIgnoreCase("1")){
				temp = temp + " 上午";
			} 
			if(tt[1].equalsIgnoreCase("1")){
				temp = temp + " 下午";
			}
			if(tt[2].equalsIgnoreCase("1")){
				temp = temp +" 晚上";
			}
		}
		
		return temp;
	}
	public static enum Rules{
		FirstApprove(1, "处室负责人审批"),
		SecordApprove(2, "分管副校长审批");
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
		OfficePass(1, "审批中-处室通过"),
		Pass(2, "审批通过"),
		Deny(3, "审批不通过"),
		Cancle(4, "取消");
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

	public Set<MoveRestDayWorkFlowLog> getLogs() {
		return logs;
	}

	public void setLogs(Set<MoveRestDayWorkFlowLog> logs) {
		this.logs = logs;
	}



	public String getVicePrincipalApproverId() {
		return vicePrincipalApproverId;
	}

	public void setVicePrincipalApproverId(String vicePrincipalApproverId) {
		this.vicePrincipalApproverId = vicePrincipalApproverId;
	}

	public Integer getVicePrincipalStatus() {
		return vicePrincipalStatus;
	}

	public void setVicePrincipalStatus(Integer vicePrincipalStatus) {
		this.vicePrincipalStatus = vicePrincipalStatus;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	public int getSections(){
		int result=0;
		String times=getTimes();
		String[] times_attr=times.split(";");
		for(String time:times_attr){
			int morning=Integer.parseInt(time.split(" ")[1].split("-")[0]);
			int afternoon=Integer.parseInt(time.split(" ")[1].split("-")[1]);
			int evening=Integer.parseInt(time.split(" ")[1].split("-")[2]);
			result+=morning+afternoon+evening;
			
		}
		return result;
	}
	public String getTimes() {
		return times;
	}

	public void setTimes(String times) {
		this.times = times;
	}
	
	
}
