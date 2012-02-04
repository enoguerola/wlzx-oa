package system.wlims.oa.entity.logistics;

import system.wlims.oa.entity.BaseModel;

public class PurchaseFormModel extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9078432634342762817L;
	private String applyUser;
	private String applyUserDepartmentLeader;
	private String resourceDepartmentLeader;
	private String applyUserViceHeaderMaster;
	private String financeViceHeaderMaster;
	private String headerMaster;
	private Double money;
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
}
