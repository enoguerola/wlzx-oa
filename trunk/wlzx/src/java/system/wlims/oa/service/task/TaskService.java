package system.wlims.oa.service.task;



import java.util.List;

import system.PaginationSupport;
import system.wlims.oa.entity.task.TaskModel;

public interface TaskService {
	
	public void addTask(TaskModel task);
	
	public boolean updateTask(TaskModel task);
	
	public TaskModel loadTaskInfoById(String id);
		
	public PaginationSupport<TaskModel> getTasksByConditions(String assignerId, String workerIds,String status, String beginDate,String endDate, Integer index, Integer page);
	public List<TaskModel> getTasksByConditions(String assignerId, String workerIds,String status, String beginDate,String endDate);
	boolean deleteTaskById(String id);

}
