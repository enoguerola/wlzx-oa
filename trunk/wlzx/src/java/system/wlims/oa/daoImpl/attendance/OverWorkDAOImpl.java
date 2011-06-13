package system.wlims.oa.daoImpl.attendance;

import java.util.ArrayList;
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
			String teacherId, String status,
			String submitBeginDate, String submitEndDate,
			String overWorkBeginDate, String overWorkEndDate) {
		DetachedCriteria criteria = DetachedCriteria.forClass(OverWorkForm.class);
		if(StringUtils.isNotEmpty(teacherId)){
			criteria.add(Restrictions.sqlRestriction("overWork_teacher_id='"+teacherId+"'"));	
		}
		if(StringUtils.isNotEmpty(status)){
			criteria.add(Restrictions.sqlRestriction("overWork_status in("+status+")"));	
		}
		
		if(StringUtils.isNotEmpty(submitBeginDate)){
			criteria.add(Restrictions.sqlRestriction("overWork_applyNo>='"+submitBeginDate.split("-")[0]+submitBeginDate.split("-")[1]+submitBeginDate.split("-")[2]+"000000'"));	
		}
		if(StringUtils.isNotEmpty(submitEndDate)){
			criteria.add(Restrictions.sqlRestriction("overWork_applyNo<='"+submitEndDate.split("-")[0]+submitEndDate.split("-")[1]+submitEndDate.split("-")[2]+"999999'"));	
		}
//		if(StringUtils.isNotEmpty(overWorkBeginDate)){
//			criteria.add(Restrictions.sqlRestriction("overWork_times>='"+overWorkBeginDate+" 0'"));	
//		}
//		if(StringUtils.isNotEmpty(overWorkEndDate)){
//			criteria.add(Restrictions.sqlRestriction("overWork_times<='"+overWorkEndDate+" 1'"));	
//		}
		criteria.addOrder(Order.desc("applyNo"));
		List<OverWorkForm> result = this.getListByCriteria(criteria);
		return getOverWorkAppliesByConditions(result, overWorkBeginDate,overWorkEndDate);
	}
	private List<OverWorkForm> getOverWorkAppliesByConditions(List<OverWorkForm> list,String overWorkBeginDate, String overWorkEndDate){
		
		if(list!=null){
			if(StringUtils.isEmpty(overWorkBeginDate)&&StringUtils.isEmpty(overWorkEndDate))return list;
			List<OverWorkForm> result = new ArrayList<OverWorkForm>() ;
			for(OverWorkForm form:list){
				String times=form.getTimes();
				String[] times_attr=times.split(";");
				boolean flag=false;
				for(String time:times_attr){
					if(StringUtils.isNotEmpty(overWorkBeginDate)&&StringUtils.isNotEmpty(overWorkEndDate)){
						if(time.compareTo(overWorkBeginDate+" 0-0-0")>=0&&time.compareTo(overWorkEndDate+" 1-1-1")<=0){
							flag=true;
							break;
						}
					}else if(StringUtils.isNotEmpty(overWorkBeginDate)){
						if(time.compareTo(overWorkBeginDate+" 0-0-0")>=0){
							flag=true;
							break;
						}
					}else if(StringUtils.isNotEmpty(overWorkEndDate)){
						if(time.compareTo(overWorkEndDate+" 1-1-1")<=0){
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
