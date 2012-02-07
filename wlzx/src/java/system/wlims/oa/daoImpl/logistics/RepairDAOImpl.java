package system.wlims.oa.daoImpl.logistics;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import system.BaseDAOImpl;
import system.DAOException;
import system.PaginationSupport;
import system.utils.StringUtils;
import system.wlims.oa.dao.logistics.RepairDAO;
import system.wlims.oa.entity.logistics.RepairModel;


public class RepairDAOImpl extends BaseDAOImpl<RepairModel>  implements RepairDAO {


	@Override
	public PaginationSupport<RepairModel> getRepairsByConditions(
			String applyId, String applyBeginDate, String applyEndDate,
			String repairer, String repairBeginDate, String repairEndDate,
			String status, String isElectric, int startIndex, int pageSize)
			throws DAOException {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(RepairModel.class);
		if(StringUtils.isNotEmpty(applyId)&&(!applyId.equalsIgnoreCase("1")))
			criteria.add(Restrictions.eq("applyId", applyId));
		if(StringUtils.isNotEmpty(applyBeginDate))
			criteria.add(Restrictions.sqlRestriction("apply_date >= '"+applyBeginDate+" 00:00:00'"));		
		if(StringUtils.isNotEmpty(applyEndDate))
			criteria.add(Restrictions.sqlRestriction("apply_date <= '"+applyEndDate+" 23:59:59'"));
		if(StringUtils.isNotEmpty(repairer))
			criteria.add(Restrictions.like("repairer", repairer,MatchMode.ANYWHERE));
		if(StringUtils.isNotEmpty(repairBeginDate))
			criteria.add(Restrictions.sqlRestriction("repair_date >= '"+repairBeginDate+" 00:00:00'"));		
		if(StringUtils.isNotEmpty(repairEndDate))
			criteria.add(Restrictions.sqlRestriction("repair_date <= '"+repairEndDate+" 23:59:59'"));
		if(StringUtils.isNotEmpty(status))
			criteria.add(Restrictions.sqlRestriction("status in ("+status+")"));
		if(StringUtils.isNotEmpty(isElectric))
			criteria.add(Restrictions.sqlRestriction("is_electric in ("+isElectric+")"));
		return this.findPageByCriteria(criteria, pageSize, startIndex);
	}


}
