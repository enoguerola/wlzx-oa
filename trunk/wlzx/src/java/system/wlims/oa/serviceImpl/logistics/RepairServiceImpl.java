package system.wlims.oa.serviceImpl.logistics;


import java.util.Date;


import system.PaginationSupport;
import system.ServiceException;
import system.utils.StringUtils;
import system.utils.UtilDateTime;
import system.wlims.oa.dao.logistics.RepairDAO;
import system.wlims.oa.entity.logistics.RepairModel;
import system.wlims.oa.service.logistics.RepairService;

public class RepairServiceImpl implements RepairService {
	
	private RepairDAO repairDAO;

	public void setRepairDAO(RepairDAO repairDAO) {
		this.repairDAO = repairDAO;
	}

	public RepairDAO getRepairDAO() {
		return repairDAO;
	}

	@Override
	public RepairModel getRepair(String id) throws ServiceException {
		// TODO Auto-generated method stub
		return repairDAO.get(id);
	}

	@Override
	public PaginationSupport<RepairModel> getRepairsByApplyId(String applyId,
			int startIndex, int pageSize) throws ServiceException {
		// TODO Auto-generated method stub
		return repairDAO.getRepairsByApplyId(applyId, startIndex, pageSize);
	}

	@Override
	public void saveRepair(RepairModel repair) throws ServiceException {
		// TODO Auto-generated method stub
		if(StringUtils.isEmpty(repair.getId()))
		{
			repair.setRepairNo(UtilDateTime.toDateString(new Date(), "yyMMddHHmmss"));
			repairDAO.saveOrUpdate(repair);
		}			
		else repairDAO.merge(repair);
	}

	@Override
	public void handup(String id) throws ServiceException {
		// TODO Auto-generated method stub
		RepairModel model=repairDAO.get(id);
		model.setStatus(RepairModel.EStatus.Unconfirmed.getValue());
		repairDAO.merge(model);
	}

}
