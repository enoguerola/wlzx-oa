package system.wlims.oa.daoImpl.logistics;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import system.BaseDAOImpl;
import system.PaginationSupport;
import system.entity.DepartmentModel;
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


}
