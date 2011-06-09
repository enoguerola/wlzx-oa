package system.wlims.oa.daoImpl.attendance;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import system.BaseDAOImpl;
import system.utils.StringUtils;
import system.wlims.oa.dao.attendance.OverWorkDAO;
import system.wlims.oa.entity.workFlow.overWork.OverWorkForm;

public class OverWorkDAOImpl  extends BaseDAOImpl<OverWorkForm> implements OverWorkDAO{

	@SuppressWarnings("unchecked")
	@Override
	public List<OverWorkForm> getUserOverWorkApplies(String userId) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(OverWorkForm.class);
		if(StringUtils.isNotEmpty(userId)){
			criteria.add(Restrictions.sqlRestriction("overWork_teacher_id='"+userId+"'"));	
		}
		criteria.addOrder(Order.desc("applyNo"));
		List<OverWorkForm> result = this.getListByCriteria(criteria);
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OverWorkForm> getOverWorkAppliesByConditions(
			String teacherId, String type, String status,
			String submitBeginDate, String submitEndDate,
			String overWorkBeginDate, String overWorkEndDate) {
		DetachedCriteria criteria = DetachedCriteria.forClass(OverWorkForm.class);
		if(StringUtils.isNotEmpty(teacherId)){
			criteria.add(Restrictions.sqlRestriction("overWork_teacher_id='"+teacherId+"'"));	
		}
		if(StringUtils.isNotEmpty(status)){
			criteria.add(Restrictions.sqlRestriction("overWork_status='"+status+"'"));	
		}
		if(StringUtils.isNotEmpty(type)){
			criteria.add(Restrictions.sqlRestriction("overWork_type in("+type+")"));	
		}
		if(StringUtils.isNotEmpty(submitBeginDate)){
			criteria.add(Restrictions.sqlRestriction("overWork_applyNo>='"+submitBeginDate.split("-")[0]+submitBeginDate.split("-")[1]+submitBeginDate.split("-")[2]+"000000'"));	
		}
		if(StringUtils.isNotEmpty(submitEndDate)){
			criteria.add(Restrictions.sqlRestriction("overWork_applyNo<='"+submitEndDate.split("-")[0]+submitEndDate.split("-")[1]+submitEndDate.split("-")[2]+"999999'"));	
		}
		if(StringUtils.isNotEmpty(overWorkBeginDate)){
			criteria.add(Restrictions.sqlRestriction("overWork_beginTime>='"+overWorkBeginDate+" 0'"));	
		}
		if(StringUtils.isNotEmpty(overWorkEndDate)){
			criteria.add(Restrictions.sqlRestriction("overWork_endTime<='"+overWorkEndDate+" 1'"));	
		}
		criteria.addOrder(Order.desc("applyNo"));
		List<OverWorkForm> result = this.getListByCriteria(criteria);
		return result;
	}

}
