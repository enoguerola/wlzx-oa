package system.wlims.oa.entity.logistics;

import java.util.Date;

import system.wlims.oa.entity.BaseModel;

public class PurchaseApplyModel extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9078432634342762817L;
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
	private String state;//辅助
	
	private String schoolOfficeApproveState;
	private String schoolOfficeApproveDescription;
	private String purchaseDetail;
	private String purchaseUser;
	private String purchaseDate="";
	
	private Boolean canPurchase=false;//辅助
	private Boolean canSchoolOfficeApprove=false;//辅助
	private Boolean canActiveOrCancle=false;//辅助
	
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getSchoolOfficeApproveState() {
		return schoolOfficeApproveState;
	}
	public void setSchoolOfficeApproveState(String schoolOfficeApproveState) {
		this.schoolOfficeApproveState = schoolOfficeApproveState;
	}
	public String getSchoolOfficeApproveDescription() {
		return schoolOfficeApproveDescription;
	}
	public void setSchoolOfficeApproveDescription(
			String schoolOfficeApproveDescription) {
		this.schoolOfficeApproveDescription = schoolOfficeApproveDescription;
	}
	public String getPurchaseDetail() {
		return purchaseDetail;
	}
	public void setPurchaseDetail(String purchaseDetail) {
		this.purchaseDetail = purchaseDetail;
	}
	public String getPurchaseUser() {
		return purchaseUser;
	}
	public void setPurchaseUser(String purchaseUser) {
		this.purchaseUser = purchaseUser;
	}
	public String getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public Boolean getCanPurchase() {
		return canPurchase;
	}
	public void setCanPurchase(Boolean canPurchase) {
		this.canPurchase = canPurchase;
	}
	public Boolean getCanSchoolOfficeApprove() {
		return canSchoolOfficeApprove;
	}
	public void setCanSchoolOfficeApprove(Boolean canSchoolOfficeApprove) {
		this.canSchoolOfficeApprove = canSchoolOfficeApprove;
	}
	public Boolean getCanActiveOrCancle() {
		return canActiveOrCancle;
	}
	public void setCanActiveOrCancle(Boolean canActiveOrCancle) {
		this.canActiveOrCancle = canActiveOrCancle;
	}
	
}
