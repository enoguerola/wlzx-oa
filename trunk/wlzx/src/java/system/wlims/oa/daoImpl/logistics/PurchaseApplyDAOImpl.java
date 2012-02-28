package system.wlims.oa.daoImpl.logistics;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import system.BaseDAOImpl;
import system.PaginationSupport;
import system.utils.StringUtils;
import system.wlims.oa.dao.logistics.PurchaseApplyDAO;
import system.wlims.oa.entity.logistics.PurchaseApplyModel;


public class PurchaseApplyDAOImpl extends BaseDAOImpl<PurchaseApplyModel>  implements PurchaseApplyDAO {

	@Override
	public PaginationSupport<PurchaseApplyModel> getApplyListByUser(
			String applyUserId, int index, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(PurchaseApplyModel.class);
		
	
		if(StringUtils.isNotEmpty(applyUserId))
			criteria.add(Restrictions.sqlRestriction("apply_user='"+applyUserId+"'"));
		
		criteria.addOrder(Order.desc("applyTime"));
		return this.findPageByCriteria(criteria, pageSize, index);
	}
	@Override
	public List<PurchaseApplyModel> getApplyListByUser(String applyUserId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(PurchaseApplyModel.class);
		
	
		if(StringUtils.isNotEmpty(applyUserId))
			criteria.add(Restrictions.sqlRestriction("apply_user='"+applyUserId+"'"));
		
		criteria.addOrder(Order.desc("applyTime"));
		return this.getListByCriteria(criteria);
	}
	@SuppressWarnings("unchecked")
	@Override
	public PurchaseApplyModel getByProcessInstanceId(String processInstanceId) {
		if (StringUtils.isNotEmpty(processInstanceId)) {
			DetachedCriteria criteria = DetachedCriteria.forClass(PurchaseApplyModel.class);
			criteria.add(Restrictions.eq("processInstanceId", processInstanceId));
			List<PurchaseApplyModel> result = this.getListByCriteria(criteria);
			return result != null && result.size() > 0 ? result.get(0) : null;
		}
		return null;
	}

	@Override
	public PaginationSupport<PurchaseApplyModel> getApplyByConditions(
			String applyUserId, String applyDepartmentId,
			String applyBeginDate, String applyEndDate, int index, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(PurchaseApplyModel.class);
		
		criteria.add(Restrictions.eq("submitFlag", true));
		if(StringUtils.isNotEmpty(applyUserId))
			criteria.add(Restrictions.sqlRestriction("apply_user='"+applyUserId+"'"));
		if(StringUtils.isNotEmpty(applyDepartmentId))
			criteria.add(Restrictions.sqlRestriction("apply_user_department_id='"+applyDepartmentId+"'"));
		if(StringUtils.isNotEmpty(applyBeginDate))
			criteria.add(Restrictions.sqlRestriction("apply_time >= '"+applyBeginDate+" 00:00:00'"));		
		if(StringUtils.isNotEmpty(applyEndDate))
			criteria.add(Restrictions.sqlRestriction("apply_time <= '"+applyEndDate+" 23:59:59'"));
		
		criteria.addOrder(Order.desc("applyTime"));
		return this.findPageByCriteria(criteria, pageSize, index);
	}


}
