package system.wlims.oa.serviceImpl.task;

import java.util.List;

import system.wlims.oa.dao.task.TaskDAO;
import system.wlims.oa.entity.task.TaskModel;
import system.wlims.oa.service.task.TaskService;

public class TaskServiceImpl implements TaskService {
	private TaskDAO taskDAO;
	@Override
	public void addTask(TaskModel task) {
		// TODO Auto-generated method stub
		taskDAO.saveOrUpdate(task);
	}

	@Override
	public List<TaskModel> getTasksByConditions(String assignerId,
			String workerIds, String status, String beginDate, String endDate,
			Integer index, Integer page) {
		// TODO Auto-generated method stub
		return taskDAO.getTasksByConditions(assignerId, workerIds, status, beginDate, endDate, index, page);
	}

	@Override
	public TaskModel loadTaskInfoById(String id) {
		// TODO Auto-generated method stub
		return taskDAO.get(id);
	}

	@Override
	public boolean remove(String id) {
		// TODO Auto-generated method stub
		TaskModel task=taskDAO.get(id);
		if(task==null)return false;
		else {
			taskDAO.remove(task);
			return true;
		}
	}

	@Override
	public boolean updateTask(TaskModel task) {
		// TODO Auto-generated method stub
		taskDAO.saveOrUpdate(task);
		return true;
	}

	public TaskDAO getTaskDAO() {
		return taskDAO;
	}

	public void setTaskDAO(TaskDAO taskDAO) {
		this.taskDAO = taskDAO;
	}
	

}
