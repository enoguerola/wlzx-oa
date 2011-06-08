package system.wlims.oa.entity.workFlow;

import java.util.Date;

import system.wlims.oa.entity.BaseModel;

public class WorkFlowLogModel  extends BaseModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3614857749991830281L;
	private String operationTeacherId;
	private Date operationTime;
	private String operationName;
	private String operationResult;
	
	public String getOperationTeacherId() {
		return operationTeacherId;
	}
	public void setOperationTeacherId(String operationTeacherId) {
		this.operationTeacherId = operationTeacherId;
	}
	public Date getOperationTime() {
		return operationTime;
	}
	public void setOperationTime(Date operationTime) {
		this.operationTime = operationTime;
	}
	public String getOperationName() {
		return operationName;
	}
	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}
	public String getOperationResult() {
		return operationResult;
	}
	public void setOperationResult(String operationResult) {
		this.operationResult = operationResult;
	}
}
