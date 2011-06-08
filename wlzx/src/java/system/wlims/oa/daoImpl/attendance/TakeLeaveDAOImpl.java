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

}
