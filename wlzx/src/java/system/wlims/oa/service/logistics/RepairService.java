package system.wlims.oa.service.logistics;

import system.PaginationSupport;
import system.ServiceException;
import system.wlims.oa.entity.logistics.RepairModel;

public interface RepairService {
	/**
	 * 保存维修单
	 * @param 维修单
	 * @return void
	 */	
	public void saveRepair(RepairModel repair)throws ServiceException;	
	/**
	 * 删除维修单
	 * @param 维修单id
	 * @return void
	 */	
	public void deleteRepair(String id)throws ServiceException;
	/**
	 * 提交维修单
	 * @param 维修单id
	 * @return void
	 */	
	public void handup(String id)throws ServiceException;
	/**
	 * 受理维修单
	 * @param 维修单id
	 * @return void
	 */	
	public void confirm(String id)throws ServiceException;
	/**
	 * 取消保存维修单
	 * @param 维修单id
	 * @return void
	 */	
	public void cancleRepair(String id)throws ServiceException;
	/**
	 * 通过id号获取维修单
	 * @param 维修单id
	 * @return 维修单
	 */	
	public RepairModel getRepair(String id)throws ServiceException;
	
	public PaginationSupport<RepairModel> getRepairsByApplyId(String applyId, int startIndex ,int pageSize)throws ServiceException;
	/**
	 * 获取维修单
	 * @param 申请者id 申请开始时间 申请结束时间 维修者 维修开始时间 维修结束时间 状态 是否电教
	 * @return 维修单
	 */	
	public PaginationSupport<RepairModel> getRepairsByConditions(String applyId,String applyBeginDate, String applyEndDate,
			String repairer,String repairBeginDate, String repairEndDate,String status,
			String isElectric,int startIndex, int pageSize )throws ServiceException;
}
