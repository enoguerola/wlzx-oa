package system.wlims.oa.serviceImpl.task;


import java.util.Date;
import java.util.List;

import system.PaginationSupport;
import system.entity.MessageModel;
import system.service.SystemService;
import system.utils.UtilDateTime;
import system.wlims.basic.service.teacher.TeacherService;
import system.wlims.oa.dao.task.TaskDAO;
import system.wlims.oa.entity.task.TaskModel;
import system.wlims.oa.service.task.TaskService;

public class TaskServiceImpl implements TaskService {
	private TaskDAO taskDAO;
	private SystemService systemService;
	private TeacherService teacherService;
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
		String content=teacherService.getTeacherNameByUserId(task.getAssignerId())+"于"+UtilDateTime.toDateString(task.getPostTime(),"yyyy-MM-dd HH:mm:ss")+"指派任务\""+task.getTitle()+"\"与你等，请及时完成任务";
		systemService.sendMessage(task.getAssignerId(),task.getWorkerIds(), MessageModel.MessageType.Person.getValue(), content);

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
		String content=teacherService.getTeacherNameByUserId(task.getAssignerId())+"于"+UtilDateTime.toDateString(new Date(),"yyyy-MM-dd HH:mm:ss")+"对原发布于"+UtilDateTime.toDateString(task.getPostTime(),"yyyy-MM-dd HH:mm:ss")+"指派任务\""+preTask.getTitle()+"\"进行了编辑，请注意查看并按时完成任务";
		systemService.sendMessage(task.getAssignerId(),task.getWorkerIds(), MessageModel.MessageType.Person.getValue(), content);

		return true;
	}
	public boolean finishTask(String taskId,String workerId) {
		// TODO Auto-generated method stub
		TaskModel task=taskDAO.get(taskId);
		task.setStatusByWorkerId(TaskModel.EStatus.Finished.getValue().intValue()+"", workerId);
		String content=teacherService.getTeacherNameByUserId(workerId)+"于"+UtilDateTime.toDateString(new Date(),"yyyy-MM-dd HH:mm:ss")+"完成指派任务\""+task.getTitle()+"\"";
		systemService.sendMessage(workerId,task.getAssignerId(), MessageModel.MessageType.Person.getValue(), content);

		if(task.isAllFinished()){
			task.setStatus(TaskModel.EStatus.Finished.getValue());
			String content2=UtilDateTime.toDateString(new Date(),"yyyy-MM-dd HH:mm:ss")+"您指派的任务\""+task.getTitle()+"\"已经全部完成";
			systemService.sendMessage(MessageModel.DefaultFromId,task.getAssignerId(), MessageModel.MessageType.SYSTEM.getValue(), content2);

		}
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

	public SystemService getSystemService() {
		return systemService;
	}

	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}

	public TeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	

}
