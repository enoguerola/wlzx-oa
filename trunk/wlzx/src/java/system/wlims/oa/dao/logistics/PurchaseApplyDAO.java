package system.wlims.oa.dao.logistics;



import java.util.List;

import system.BaseDAO;
import system.PaginationSupport;
import system.wlims.oa.entity.logistics.PurchaseApplyModel;

public interface PurchaseApplyDAO  extends BaseDAO<PurchaseApplyModel>{

	public PaginationSupport<PurchaseApplyModel> getApplyListByUser(String applyUserId, int index, int pageSize);
	public List<PurchaseApplyModel> getApplyListByUser(String applyUserId);
	public PurchaseApplyModel getByProcessInstanceId(String id);

	public PaginationSupport<PurchaseApplyModel> getApplyByConditions(String applyUserId, String applyDepartmentId,String applyBeginDate, String applyEndDate, int index, int pageSize);

}
