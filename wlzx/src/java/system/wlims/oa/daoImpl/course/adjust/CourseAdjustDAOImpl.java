package system.wlims.oa.daoImpl.course.adjust;


import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import system.BaseDAOImpl;
import system.utils.StringUtils;
import system.wlims.oa.dao.course.adjust.CourseAdjustDAO;
import system.wlims.oa.entity.course.adjust.ApplyModel;

public class CourseAdjustDAOImpl extends BaseDAOImpl<ApplyModel> implements CourseAdjustDAO{

	@SuppressWarnings("unchecked")
	@Override
	public List<ApplyModel> getAppliesByCondition(String accountId,
			Integer state, Integer type, String submitBeginDate, String submitEndDate) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(ApplyModel.class);
		if(!StringUtils.isEmpty(accountId)){
			criteria.add(Restrictions.eq("applyTeacherId", accountId));
		}
		if(state!=null){
			criteria.add(Restrictions.eq("applyStatus", state));
		}
		if(type!=null){
			criteria.add(Restrictions.eq("applyType", type));
		}
		if(StringUtils.isNotEmpty(submitBeginDate)){
			criteria.add(Restrictions.sqlRestriction("apply_no >='"+submitBeginDate.split("-")[0]+submitBeginDate.split("-")[1]+submitBeginDate.split("-")[2]+"000000'"));	
		}
		if(StringUtils.isNotEmpty(submitEndDate)){
			criteria.add(Restrictions.sqlRestriction("apply_no <='"+submitEndDate.split("-")[0]+submitEndDate.split("-")[1]+submitEndDate.split("-")[2]+"999999'"));	
		}
		
		
		criteria.addOrder(Order.asc("applyNo"));
		List<ApplyModel> result = getListByCriteria(criteria);
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ApplyModel> personalApplySearch(String userId) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(ApplyModel.class);
		criteria.add(Restrictions.eq("applyTeacherId",userId));
		criteria.addOrder(Order.desc("applyNo"));
		List<ApplyModel> result = getListByCriteria(criteria);
		return result;
	}

}
