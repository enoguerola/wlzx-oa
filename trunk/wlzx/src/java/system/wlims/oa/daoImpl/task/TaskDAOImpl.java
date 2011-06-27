package system.wlims.oa.daoImpl.task;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import system.BaseDAOImpl;
import system.utils.StringUtils;
import system.wlims.oa.dao.task.TaskDAO;
import system.wlims.oa.entity.task.TaskModel;

public class TaskDAOImpl extends BaseDAOImpl<TaskModel> implements TaskDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<TaskModel> getTasksByConditions(String assignerId,
			String workerIds, String status, String beginDate, String endDate,Integer index, Integer page) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(TaskModel.class);
		
		if(StringUtils.isNotEmpty(assignerId)){
			criteria.add(Restrictions.sqlRestriction("assigner_id='"+assignerId+"'"));	
		}
		if(StringUtils.isNotEmpty(status)){
			criteria.add(Restrictions.sqlRestriction("status ='"+status+"'"));	
		}
		if(StringUtils.isNotEmpty(workerIds)){
			for(String workerId:workerIds.split(";")){
				if(StringUtils.isNotEmpty(workerId)){
					criteria.add(Restrictions.sqlRestriction("LOCATE('"+workerId+",worker_ids,0) >0'"));
				}
			}
		}
		
		if(StringUtils.isNotEmpty(beginDate)){
			criteria.add(Restrictions.sqlRestriction("assign_time>='"+beginDate+" 00:00:00'"));	
		}
		if(StringUtils.isNotEmpty(beginDate)){
			criteria.add(Restrictions.sqlRestriction("assign_time<='"+endDate+" 59:59:59'"));	
		}
		criteria.addOrder(Order.desc("postTime"));
		
		return getListByCriteria(criteria, (index - 1)*page, page);
	}

}
