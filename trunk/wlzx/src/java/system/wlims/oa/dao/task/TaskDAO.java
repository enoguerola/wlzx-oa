package system.wlims.oa.dao.task;


import java.util.List;

import system.BaseDAO;
import system.wlims.oa.entity.task.TaskModel;

public interface TaskDAO  extends BaseDAO<TaskModel>{

	public List<TaskModel> getTasksByConditions(String assignerId,
			String workerIds, String status, String beginDate, String endDate,Integer index, Integer page) ;
}
