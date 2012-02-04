package system.wlims.oa.serviceImpl.logistics;

import system.wlims.oa.dao.logistics.PurchaseApplyDAO;
import system.wlims.oa.service.logistics.PurchaseApplyService;

public class PurchaseApplyServiceImpl implements PurchaseApplyService{
	private PurchaseApplyDAO purchaseApplyDAO;

	public PurchaseApplyDAO getPurchaseApplyDAO() {
		return purchaseApplyDAO;
	}

	public void setPurchaseApplyDAO(PurchaseApplyDAO purchaseApplyDAO) {
		this.purchaseApplyDAO = purchaseApplyDAO;
	}
	
	
}
