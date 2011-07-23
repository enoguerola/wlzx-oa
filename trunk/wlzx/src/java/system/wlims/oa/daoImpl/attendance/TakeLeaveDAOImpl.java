package system.wlims.oa.daoImpl.attendance;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import system.BaseDAOImpl;
import system.utils.StringUtils;
import system.wlims.oa.dao.attendance.TakeLeaveDAO;
import system.wlims.oa.entity.workFlow.takeLeave.TakeLeaveForm;

public class TakeLeaveDAOImpl  extends BaseDAOImpl<TakeLeaveForm> implements TakeLeaveDAO{

	@SuppressWarnings("unchecked")
	@Override
	public List<TakeLeaveForm> getUserTakeLeaveApplies(String userId) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(TakeLeaveForm.class);
		if(StringUtils.isNotEmpty(userId)){
			criteria.add(Restrictions.sqlRestriction("takeLeave_teacher_id='"+userId+"'"));	
		}
		criteria.addOrder(Order.desc("applyNo"));
		List<TakeLeaveForm> result = this.getListByCriteria(criteria);
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TakeLeaveForm> getTakeLeaveAppliesByConditions(
			String teacherId, String type, String status,
			String submitBeginDate, String submitEndDate,
			String takeLeaveBeginDate, String takeLeaveEndDate) {
		DetachedCriteria criteria = DetachedCriteria.forClass(TakeLeaveForm.class);
		if(StringUtils.isNotEmpty(teacherId)){
			criteria.add(Restrictions.sqlRestriction("takeLeave_teacher_id='"+teacherId+"'"));	
		}
		if(StringUtils.isNotEmpty(status)){
			criteria.add(Restrictions.sqlRestriction("takeLeave_status in('"+status+"')"));	
		}
		if(StringUtils.isNotEmpty(type)){
			criteria.add(Restrictions.sqlRestriction("takeLeave_type ='"+type+"'"));	
		}
		if(StringUtils.isNotEmpty(submitBeginDate)){
			criteria.add(Restrictions.sqlRestriction("takeLeave_applyNo>='"+submitBeginDate.split("-")[0]+submitBeginDate.split("-")[1]+submitBeginDate.split("-")[2]+"000000'"));	
		}
		if(StringUtils.isNotEmpty(submitEndDate)){
			criteria.add(Restrictions.sqlRestriction("takeLeave_applyNo<='"+submitEndDate.split("-")[0]+submitEndDate.split("-")[1]+submitEndDate.split("-")[2]+"999999'"));	
		}
		if(StringUtils.isNotEmpty(takeLeaveBeginDate)){
			criteria.add(Restrictions.sqlRestriction("takeLeave_beginTime>='"+takeLeaveBeginDate+" 0'"));	
		}
		if(StringUtils.isNotEmpty(takeLeaveEndDate)){
			criteria.add(Restrictions.sqlRestriction("takeLeave_endTime<='"+takeLeaveEndDate+" 2'"));	
		}
		criteria.addOrder(Order.desc("applyNo"));
		List<TakeLeaveForm> result = this.getListByCriteria(criteria);
		return result;
	}

}
