package system.wlims.oa.entity.logistics;

import java.util.Date;

import system.wlims.oa.entity.BaseModel;

public class RepairModel extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5064507889354620316L;
	/**
	 * 
	 */
	private String repairNo;
	private String items;
	private String description;
	private String isElectric;//是否电教： 1电教 2非电教
	private String applyId;
	private Date applyDate;
	private String phone;
	private int repairType;
	private String cause;//故障原因：1人为  2非人为
	private String failureCause;
	private String result;//维修结果：1完成 2未完成
	private String repairResult;
	private String repairer;
	private Date repairDate;
	private String operatorId;
	private Date operateDate;
	private Integer status;//状态：0未提交 1已提交未确认 2已确认未处理 3已处理 4已取消
	public static enum EStatus{
		Uncommitted(0, "未提交"),
		Unconfirmed(1, "已提交未确认"),
		Untreated(2, "已确认未处理"),
		Handled(3, "已处理"),
		Cancled(4, "已取消");
		
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
	public void setRepairNo(String repairNo) {
		this.repairNo = repairNo;
	}
	public String getRepairNo() {
		return repairNo;
	}
	public void setItems(String items) {
		this.items = items;
	}
	public String getItems() {
		return items;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return description;
	}
	public void setIsElectric(String isElectric) {
		this.isElectric = isElectric;
	}
	public String getIsElectric() {
		return isElectric;
	}
	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}
	public String getApplyId() {
		return applyId;
	}
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}
	public Date getApplyDate() {
		return applyDate;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPhone() {
		return phone;
	}
	public void setRepairType(int repairType) {
		this.repairType = repairType;
	}
	public int getRepairType() {
		return repairType;
	}
	public void setCause(String cause) {
		this.cause = cause;
	}
	public String getCause() {
		return cause;
	}
	public void setFailureCause(String failureCause) {
		this.failureCause = failureCause;
	}
	public String getFailureCause() {
		return failureCause;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getResult() {
		return result;
	}
	public void setRepairResult(String repairResult) {
		this.repairResult = repairResult;
	}
	public String getRepairResult() {
		return repairResult;
	}
	public void setRepairer(String repairer) {
		this.repairer = repairer;
	}
	public String getRepairer() {
		return repairer;
	}
	public void setRepairDate(Date repairDate) {
		this.repairDate = repairDate;
	}
	public Date getRepairDate() {
		return repairDate;
	}
	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}
	public String getOperatorId() {
		return operatorId;
	}
	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}
	public Date getOperateDate() {
		return operateDate;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getStatus() {
		return status;
	}

	
}
