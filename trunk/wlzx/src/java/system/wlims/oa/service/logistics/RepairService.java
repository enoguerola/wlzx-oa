package system.wlims.oa.service.logistics;

import system.PaginationSupport;
import system.ServiceException;
import system.wlims.oa.entity.logistics.RepairModel;

public interface RepairService {
	
	public void saveRepair(RepairModel repair)throws ServiceException;	
	
	public void handup(String id)throws ServiceException;
	
	public RepairModel getRepair(String id)throws ServiceException;
	
	public PaginationSupport<RepairModel> getRepairsByApplyId(String applyId, int startIndex ,int pageSize)throws ServiceException;
}
