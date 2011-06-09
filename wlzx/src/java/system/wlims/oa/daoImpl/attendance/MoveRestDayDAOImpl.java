package system.wlims.oa.daoImpl.attendance;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import system.BaseDAOImpl;
import system.utils.StringUtils;
import system.wlims.oa.dao.attendance.MoveRestDayDAO;
import system.wlims.oa.entity.workFlow.moveRestDay.MoveRestDayForm;

public class MoveRestDayDAOImpl  extends BaseDAOImpl<MoveRestDayForm> implements MoveRestDayDAO{

	@SuppressWarnings("unchecked")
	@Override
	public List<MoveRestDayForm> getUserMoveRestDayApplies(String userId) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(MoveRestDayForm.class);
		if(StringUtils.isNotEmpty(userId)){
			criteria.add(Restrictions.sqlRestriction("moveRestDay_teacher_id='"+userId+"'"));	
		}
		criteria.addOrder(Order.desc("applyNo"));
		List<MoveRestDayForm> result = this.getListByCriteria(criteria);
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MoveRestDayForm> getMoveRestDayAppliesByConditions(
			String teacherId, String type, String status,
			String submitBeginDate, String submitEndDate,
			String moveRestDayBeginDate, String moveRestDayEndDate) {
		DetachedCriteria criteria = DetachedCriteria.forClass(MoveRestDayForm.class);
		if(StringUtils.isNotEmpty(teacherId)){
			criteria.add(Restrictions.sqlRestriction("moveRestDay_teacher_id='"+teacherId+"'"));	
		}
		if(StringUtils.isNotEmpty(status)){
			criteria.add(Restrictions.sqlRestriction("moveRestDay_status='"+status+"'"));	
		}
		if(StringUtils.isNotEmpty(type)){
			criteria.add(Restrictions.sqlRestriction("moveRestDay_type in("+type+")"));	
		}
		if(StringUtils.isNotEmpty(submitBeginDate)){
			criteria.add(Restrictions.sqlRestriction("moveRestDay_applyNo>='"+submitBeginDate.split("-")[0]+submitBeginDate.split("-")[1]+submitBeginDate.split("-")[2]+"000000'"));	
		}
		if(StringUtils.isNotEmpty(submitEndDate)){
			criteria.add(Restrictions.sqlRestriction("moveRestDay_applyNo<='"+submitEndDate.split("-")[0]+submitEndDate.split("-")[1]+submitEndDate.split("-")[2]+"999999'"));	
		}
		if(StringUtils.isNotEmpty(moveRestDayBeginDate)){
			criteria.add(Restrictions.sqlRestriction("moveRestDay_beginTime>='"+moveRestDayBeginDate+" 0'"));	
		}
		if(StringUtils.isNotEmpty(moveRestDayEndDate)){
			criteria.add(Restrictions.sqlRestriction("moveRestDay_endTime<='"+moveRestDayEndDate+" 1'"));	
		}
		criteria.addOrder(Order.desc("applyNo"));
		List<MoveRestDayForm> result = this.getListByCriteria(criteria);
		return result;
	}

}
