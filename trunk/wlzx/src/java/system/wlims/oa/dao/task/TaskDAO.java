package system.wlims.oa.dao.task;



import java.util.List;

import system.BaseDAO;
import system.PaginationSupport;
import system.wlims.oa.entity.task.TaskModel;

public interface TaskDAO  extends BaseDAO<TaskModel>{

	public PaginationSupport<TaskModel> getTasksByConditions(String assignerId,
			String workerIds, String status, String beginDate, String endDate,Integer index, Integer page) ;

	public List<TaskModel> getTasksByConditions(String assignerId,
			String workerIds, String status, String beginDate, String endDate);
}
