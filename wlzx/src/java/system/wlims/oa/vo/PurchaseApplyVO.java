package system.wlims.oa.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class PurchaseApplyVO {
	private String id;
	private String processInstanceId;
	private String applyNo;
	private String purchaseName;
	private String purchaseDescription;
	private Boolean isGovernmentPurchase;
	private String applyUser;
	private String applyUserDepartmentId;
	private Date applyTime;
	private Double money;

	private String applyUserDepartmentLeader;
	private String resourceDepartmentLeader;
	private String applyUserViceHeaderMaster;
	private String financeViceHeaderMaster;
	private String headerMaster;
	private Boolean cancleFlag=false;
	private Boolean submitFlag=false;
	private List<JBPMTaskVO> historyJBPMTaskVOs=new ArrayList<JBPMTaskVO>();
	private String state;
	public String getApplyUser() {
		return applyUser;
	}
	public void setApplyUser(String applyUser) {
		this.applyUser = applyUser;
	}
	public String getApplyUserDepartmentLeader() {
		return applyUserDepartmentLeader;
	}
	public void setApplyUserDepartmentLeader(String applyUserDepartmentLeader) {
		this.applyUserDepartmentLeader = applyUserDepartmentLeader;
	}
	public String getResourceDepartmentLeader() {
		return resourceDepartmentLeader;
	}
	public void setResourceDepartmentLeader(String resourceDepartmentLeader) {
		this.resourceDepartmentLeader = resourceDepartmentLeader;
	}
	public String getApplyUserViceHeaderMaster() {
		return applyUserViceHeaderMaster;
	}
	public void setApplyUserViceHeaderMaster(String applyUserViceHeaderMaster) {
		this.applyUserViceHeaderMaster = applyUserViceHeaderMaster;
	}
	public String getFinanceViceHeaderMaster() {
		return financeViceHeaderMaster;
	}
	public void setFinanceViceHeaderMaster(String financeViceHeaderMaster) {
		this.financeViceHeaderMaster = financeViceHeaderMaster;
	}
	public String getHeaderMaster() {
		return headerMaster;
	}
	public void setHeaderMaster(String headerMaster) {
		this.headerMaster = headerMaster;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public String getApplyNo() {
		return applyNo;
	}
	public void setApplyNo(String applyNo) {
		this.applyNo = applyNo;
	}
	public String getPurchaseName() {
		return purchaseName;
	}
	public void setPurchaseName(String purchaseName) {
		this.purchaseName = purchaseName;
	}
	public String getPurchaseDescription() {
		return purchaseDescription;
	}
	public void setPurchaseDescription(String purchaseDescription) {
		this.purchaseDescription = purchaseDescription;
	}
	public Boolean getIsGovernmentPurchase() {
		return isGovernmentPurchase;
	}
	public void setIsGovernmentPurchase(Boolean isGovernmentPurchase) {
		this.isGovernmentPurchase = isGovernmentPurchase;
	}
	public String getApplyUserDepartmentId() {
		return applyUserDepartmentId;
	}
	public void setApplyUserDepartmentId(String applyUserDepartmentId) {
		this.applyUserDepartmentId = applyUserDepartmentId;
	}
	public Date getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	public Boolean getCancleFlag() {
		return cancleFlag;
	}
	public void setCancleFlag(Boolean cancleFlag) {
		this.cancleFlag = cancleFlag;
	}
	public Boolean getSubmitFlag() {
		return submitFlag;
	}
	public void setSubmitFlag(Boolean submitFlag) {
		this.submitFlag = submitFlag;
	}
	public String getProcessInstanceId() {
		return processInstanceId;
	}
	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}
	public List<JBPMTaskVO> getHistoryJBPMTaskVOs() {
		return historyJBPMTaskVOs;
	}
	public void setHistoryJBPMTaskVOs(List<JBPMTaskVO> historyJBPMTaskVOs) {
		this.historyJBPMTaskVOs = historyJBPMTaskVOs;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
