package system.wlims.oa.serviceImpl.task;


import java.util.List;

import system.PaginationSupport;
import system.wlims.oa.dao.task.TaskDAO;
import system.wlims.oa.entity.task.TaskModel;
import system.wlims.oa.service.task.TaskService;

public class TaskServiceImpl implements TaskService {
	private TaskDAO taskDAO;
	@Override
	public void addTask(TaskModel task) {
		// TODO Auto-generated method stub
		String[] workerIdAttr=task.getWorkerIds().split(";");
		String workerStatus="";
		for(int i=0;i<workerIdAttr.length;i++){
			workerStatus+="0;";
		}
		task.setWorkerStatus(workerStatus);
		taskDAO.saveOrUpdate(task);
	}

	@Override
	public PaginationSupport<TaskModel> getTasksByConditions(String assignerId,
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
	public boolean deleteTaskById(String id) {
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
		TaskModel preTask=taskDAO.get(task.getId());
		String[] workerIdAttr=task.getWorkerIds().split(";");
		String workerStatus="";
		for(int i=0;i<workerIdAttr.length;i++){
			if(preTask.getStatusByWorkerId(workerIdAttr[i])!=null)
				workerStatus+=preTask.getStatusByWorkerId(workerIdAttr[i])+";";
			else workerStatus+="0;";
		}
		task.setWorkerStatus(workerStatus);
		if(task.isAllFinished())
			task.setStatus(TaskModel.EStatus.Finished.getValue());
		taskDAO.merge(task);
		return true;
	}
	public boolean finishTask(String taskId,String workerId) {
		// TODO Auto-generated method stub
		TaskModel task=taskDAO.get(taskId);
		task.setStatusByWorkerId(TaskModel.EStatus.Finished.getValue().intValue()+"", workerId);
		if(task.isAllFinished())
			task.setStatus(TaskModel.EStatus.Finished.getValue());
		taskDAO.saveOrUpdate(task);
		return true;
	}


	public TaskDAO getTaskDAO() {
		return taskDAO;
	}

	public void setTaskDAO(TaskDAO taskDAO) {
		this.taskDAO = taskDAO;
	}

	@Override
	public List<TaskModel> getTasksByConditions(String assignerId,
			String workerIds, String status, String beginDate, String endDate) {
		// TODO Auto-generated method stub
		return taskDAO.getTasksByConditions(assignerId, workerIds, status, beginDate, endDate);
	}
	

}
