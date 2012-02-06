package system.wlims.oa.dao.logistics;



import system.BaseDAO;
import system.PaginationSupport;
import system.wlims.oa.entity.logistics.PurchaseApplyModel;

public interface PurchaseApplyDAO  extends BaseDAO<PurchaseApplyModel>{

	public PaginationSupport<PurchaseApplyModel> getApplyListByUser(String applyUserId, int index, int pageSize);

}
