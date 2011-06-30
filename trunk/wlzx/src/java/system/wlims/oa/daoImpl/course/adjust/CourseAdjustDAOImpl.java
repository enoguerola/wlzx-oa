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
			Integer state, Integer type, String beginDate, String endDate) {
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
		if(!StringUtils.isEmpty(beginDate)){
			criteria.add(Restrictions.ge("applyCreationDate", java.sql.Date.valueOf(beginDate+" 00:00:00")));
		}
		if(!StringUtils.isEmpty(endDate)){
			criteria.add(Restrictions.le("applyCreationDate", java.sql.Date.valueOf(endDate+" 23:59:59")));
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
