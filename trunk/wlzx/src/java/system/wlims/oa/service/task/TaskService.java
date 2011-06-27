package system.wlims.oa.service.task;

import java.util.List;


import system.wlims.oa.entity.task.TaskModel;

public interface TaskService {
	
	public void addTask(TaskModel task);
	
	public boolean updateTask(TaskModel task);
	
	public TaskModel loadTaskInfoById(String id);
		
	public List<TaskModel> getTasksByConditions(String assignerId, String workerIds,String status, String beginDate,String endDate, Integer index, Integer page);
	
	boolean remove(String id);

}
