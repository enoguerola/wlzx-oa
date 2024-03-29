package system.wlims.oa.dao.logistics;

import system.BaseDAO;
import system.DAOException;
import system.PaginationSupport;
import system.wlims.oa.entity.logistics.RepairModel;

public interface RepairDAO  extends BaseDAO<RepairModel>{
	
	public PaginationSupport<RepairModel> getRepairsByConditions(String applyId,String applyBeginDate, String applyEndDate,
			String repairer,String repairBeginDate, String repairEndDate,String status,
			String isElectric,int startIndex, int pageSize )throws DAOException;
}
