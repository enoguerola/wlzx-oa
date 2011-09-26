package system.wlims.oa.daoImpl.schedule;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import system.BaseDAOImpl;
import system.utils.StringUtils;
import system.wlims.oa.dao.schedule.ScheduleDAO;
import system.wlims.oa.entity.schedule.ScheduleModel;

public class ScheduleDAOImpl extends BaseDAOImpl<ScheduleModel> implements ScheduleDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<ScheduleModel> getSchedulesByConditions(String userId, String type,String state,
			String departmentShare,String departmentIds,String schoolShare, String emergence,  String title,
			String beginDate, String endDate) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ScheduleModel.class);
		if(StringUtils.isNotEmpty(userId)){
			criteria.add(Restrictions.sqlRestriction("poster_id='"+userId+"'"));	
		}
		if(StringUtils.isNotEmpty(state)){
			criteria.add(Restrictions.sqlRestriction("finish_status ='"+state+"'"));	
		}
		if(StringUtils.isNotEmpty(departmentShare)){
			criteria.add(Restrictions.sqlRestriction("department_share ='"+departmentShare+"'"));	
		}
		if(StringUtils.isNotEmpty(departmentIds)){
			criteria.add(Restrictions.sqlRestriction("department_id in('"+departmentIds+"')"));	
		}
		if(StringUtils.isNotEmpty(schoolShare)){
			criteria.add(Restrictions.sqlRestriction("school_share ='"+schoolShare+"'"));	
		}
		if(StringUtils.isNotEmpty(type)){
			criteria.add(Restrictions.sqlRestriction("type ='"+type+"'"));	
		}
		if(StringUtils.isNotEmpty(emergence)){
			criteria.add(Restrictions.sqlRestriction("emergence ='"+emergence+"'"));	
		}
		
		if(StringUtils.isNotEmpty(beginDate)){
			criteria.add(Restrictions.sqlRestriction("begin_time>='"+beginDate+" 00:00:00'"));	
		}
		if(StringUtils.isNotEmpty(endDate)){
			criteria.add(Restrictions.sqlRestriction("end_time<='"+endDate+" 59:59:59'"));	
		}
		criteria.addOrder(Order.desc("beginTime"));
		List<ScheduleModel> result = this.getListByCriteria(criteria);
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ScheduleModel> getPublicSchedulesByConditions(String userId,
			String type, String state, String departmentIds, String emergence,
			String title, String beginDate, String endDate) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ScheduleModel.class);
		if(StringUtils.isNotEmpty(userId)){
			criteria.add(Restrictions.sqlRestriction("poster_id='"+userId+"'"));	
		}
		if(StringUtils.isNotEmpty(state)){
			criteria.add(Restrictions.sqlRestriction("finish_status ='"+state+"'"));	
		}
		
		if(StringUtils.isNotEmpty(departmentIds)){
			criteria.add(Restrictions.sqlRestriction("department_id in('"+departmentIds+"')"));	
		}
		
		if(StringUtils.isNotEmpty(type)){
			criteria.add(Restrictions.sqlRestriction("type ='"+type+"'"));	
		}
		if(StringUtils.isNotEmpty(emergence)){
			criteria.add(Restrictions.sqlRestriction("emergence ='"+emergence+"'"));	
		}
		
		if(StringUtils.isNotEmpty(beginDate)){
			criteria.add(Restrictions.sqlRestriction("begin_time>='"+beginDate+" 00:00:00'"));	
		}
		if(StringUtils.isNotEmpty(endDate)){
			criteria.add(Restrictions.sqlRestriction("end_time<='"+endDate+" 59:59:59'"));	
		}
		criteria.addOrder(Order.desc("beginTime"));
		criteria.add(Restrictions.or(Restrictions.sqlRestriction("department_share ='1'"), Restrictions.sqlRestriction("school_share ='1'")));	

		List<ScheduleModel> result = this.getListByCriteria(criteria);
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ScheduleModel> getPersonSchedulesByConditions(String userId,
			String type, String state, String departmentIds, String emergence,
			String title, String beginDate, String endDate) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ScheduleModel.class);
		if(StringUtils.isNotEmpty(userId)){
			criteria.add(Restrictions.sqlRestriction("poster_id='"+userId+"'"));	
		}
		if(StringUtils.isNotEmpty(state)){
			criteria.add(Restrictions.sqlRestriction("finish_status ='"+state+"'"));	
		}
			
		
		if(StringUtils.isNotEmpty(departmentIds)){
			criteria.add(Restrictions.sqlRestriction("department_id in('"+departmentIds+"')"));	
		}
		
		if(StringUtils.isNotEmpty(type)){
			criteria.add(Restrictions.sqlRestriction("type ='"+type+"'"));	
		}
		if(StringUtils.isNotEmpty(emergence)){
			criteria.add(Restrictions.sqlRestriction("emergence ='"+emergence+"'"));	
		}
		
		if(StringUtils.isNotEmpty(beginDate)){
			criteria.add(Restrictions.sqlRestriction("begin_time>='"+beginDate+" 00:00:00'"));	
		}
		if(StringUtils.isNotEmpty(endDate)){
			criteria.add(Restrictions.sqlRestriction("end_time<='"+endDate+" 59:59:59'"));	
		}
		criteria.addOrder(Order.desc("beginTime"));
		criteria.add(Restrictions.and(Restrictions.sqlRestriction("department_share !='1'"), Restrictions.sqlRestriction("school_share !='1'")));	
		List<ScheduleModel> result = this.getListByCriteria(criteria);
		return result;
	}

}
