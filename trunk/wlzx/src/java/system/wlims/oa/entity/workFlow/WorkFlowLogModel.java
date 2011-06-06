package system.wlims.oa.entity.workFlow;

import java.util.Date;

public class WorkFlowLogModel {
	private String id;
	private String operationTeacherId;
	private Date operationTime;
	private String operationName;
	private String operationResult;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
