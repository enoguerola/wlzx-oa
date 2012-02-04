package system.wlims.oa.daoImpl.logistics;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import system.BaseDAOImpl;
import system.DAOException;
import system.PaginationSupport;
import system.utils.StringUtils;
import system.wlims.oa.dao.logistics.RepairDAO;
import system.wlims.oa.entity.logistics.RepairModel;


public class RepairDAOImpl extends BaseDAOImpl<RepairModel>  implements RepairDAO {

	@Override
	public PaginationSupport<RepairModel> getRepairsByApplyId(String applyId,
			int startIndex, int pageSize) throws DAOException {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(RepairModel.class);
		if(StringUtils.isNotEmpty(applyId)&&(!applyId.equalsIgnoreCase("1")))
			criteria.add(Restrictions.eq("applyId", applyId));
		return this.findPageByCriteria(criteria, pageSize, startIndex);
	}


}
