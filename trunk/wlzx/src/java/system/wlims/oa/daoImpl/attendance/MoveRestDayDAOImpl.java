package system.wlims.oa.daoImpl.attendance;

import java.util.ArrayList;
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
			String teacherId, String status,
			String submitBeginDate, String submitEndDate,
			String moveRestDayBeginDate, String moveRestDayEndDate) {
		DetachedCriteria criteria = DetachedCriteria.forClass(MoveRestDayForm.class);
		if(StringUtils.isNotEmpty(teacherId)){
			criteria.add(Restrictions.sqlRestriction("moveRestDay_teacher_id='"+teacherId+"'"));	
		}
		if(StringUtils.isNotEmpty(status)){
			criteria.add(Restrictions.sqlRestriction("moveRestDay_status in("+status+")"));	
		}
	
		if(StringUtils.isNotEmpty(submitBeginDate)){
			criteria.add(Restrictions.sqlRestriction("moveRestDay_applyNo>='"+submitBeginDate.split("-")[0]+submitBeginDate.split("-")[1]+submitBeginDate.split("-")[2]+"000000'"));	
		}
		if(StringUtils.isNotEmpty(submitEndDate)){
			criteria.add(Restrictions.sqlRestriction("moveRestDay_applyNo<='"+submitEndDate.split("-")[0]+submitEndDate.split("-")[1]+submitEndDate.split("-")[2]+"999999'"));	
		}
//		if(StringUtils.isNotEmpty(moveRestDayBeginDate)){
//			criteria.add(Restrictions.sqlRestriction("moveRestDay_times>='"+moveRestDayBeginDate+" 0'"));	
//		}
//		if(StringUtils.isNotEmpty(moveRestDayEndDate)){
//			criteria.add(Restrictions.sqlRestriction("moveRestDay_times<='"+moveRestDayEndDate+" 1'"));	
//		}
		criteria.addOrder(Order.desc("applyNo"));
		List<MoveRestDayForm> result = this.getListByCriteria(criteria);
		return getMoveRestDayAppliesByConditions(result, moveRestDayBeginDate,moveRestDayEndDate);

	}
	private List<MoveRestDayForm> getMoveRestDayAppliesByConditions(List<MoveRestDayForm> list,String moveRestDayBeginDate, String moveRestDayEndDate){
			
			if(list!=null){
				if(StringUtils.isEmpty(moveRestDayBeginDate)&&StringUtils.isEmpty(moveRestDayEndDate))return list;
				List<MoveRestDayForm> result = new ArrayList<MoveRestDayForm>() ;
				for(MoveRestDayForm form:list){
					String times=form.getTimes();
					String[] times_attr=times.split(";");
					boolean flag=false;
					for(String time:times_attr){
						if(StringUtils.isNotEmpty(moveRestDayBeginDate)&&StringUtils.isNotEmpty(moveRestDayEndDate)){
							if(time.compareTo(moveRestDayBeginDate+" 0-0-0")>=0&&time.compareTo(moveRestDayBeginDate+" 1-1-1")<=0){
								flag=true;
								break;
							}
						}else if(StringUtils.isNotEmpty(moveRestDayBeginDate)){
							if(time.compareTo(moveRestDayBeginDate+" 0-0-0")>=0){
								flag=true;
								break;
							}
						}else if(StringUtils.isNotEmpty(moveRestDayEndDate)){
							if(time.compareTo(moveRestDayBeginDate+" 1-1-1")<=0){
								flag=true;
								break;
							}
						}
						
							
					}
					if(flag==true){
						result.add(form);
						break;
					}
				}
				return result;
			}
			return null;
			
		}

}
