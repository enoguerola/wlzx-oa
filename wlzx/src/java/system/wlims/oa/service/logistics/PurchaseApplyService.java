package system.wlims.oa.service.logistics;


import system.PaginationSupport;
import system.wlims.oa.entity.logistics.PurchaseApplyModel;
import system.wlims.oa.vo.PurchaseApplyVO;



public interface PurchaseApplyService{
	public void addPurchaseApply(PurchaseApplyModel apply);
	public void updatePurchaseApply(PurchaseApplyModel apply);
	public void canclePurchaseApplyById(String applyId);
	public void submitPurchaseApply(String applyId);
	public PurchaseApplyModel loadApplyInfoById(String applyId);
	public PurchaseApplyVO getPurchaseApplyDetailById(String applyId);
	public PaginationSupport<PurchaseApplyModel> getApplyListByUser(String applyUserId, int index,int pageSize);
}
