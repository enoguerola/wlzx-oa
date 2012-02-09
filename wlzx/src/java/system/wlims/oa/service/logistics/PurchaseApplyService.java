package system.wlims.oa.service.logistics;


import java.util.List;

import system.PaginationSupport;
import system.wlims.oa.entity.logistics.PurchaseApplyModel;
import system.wlims.oa.vo.PurchaseApplyVO;
import system.wlims.oa.vo.PurchaseApproveTaskVO;



public interface PurchaseApplyService{
	public void addPurchaseApply(PurchaseApplyModel apply);
	public void updatePurchaseApply(PurchaseApplyModel apply);
	public void canclePurchaseApplyById(String applyId);
	public void submitPurchaseApply(String applyId);
	public PurchaseApplyModel loadApplyInfoById(String applyId);
	public PurchaseApplyVO getPurchaseApplyDetailById(String applyId);
	public PaginationSupport<PurchaseApplyModel> getApplyListByUser(String applyUserId, int index,int pageSize);
	
	public List<PurchaseApproveTaskVO> getPersonPurchaseApproveTask(String userId);
	
	public List<PurchaseApproveTaskVO> getPersonPurchaseApproveHistoryTask(String userId);
	
	public void saveApprove(String taskId,String approveState,String approveDescription,String money);
	
}
