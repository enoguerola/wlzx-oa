package system.wlims.oa;


import system.BaseTest;
import system.PaginationSupport;
import system.wlims.oa.dao.task.TaskDAO;
import system.wlims.oa.entity.task.TaskModel;

public class TaskTest extends BaseTest {

	private TaskDAO taskDAO;
	
	public TaskTest(){
		setTaskDAO((TaskDAO)applicationContext.getBean("taskDAO"));
	}
	
	public void getTasksByConditionsTest(String departmentId, String workerIds,String status,
			String beginDate,String endDate, Integer index, Integer page){
		
		PaginationSupport<TaskModel> ps=taskDAO.getTasksByConditions(departmentId, workerIds, status, beginDate, endDate, index, page);
		System.out.println(ps.getItems().size());
	}
	public static void main(String[] args){
		TaskTest test = new TaskTest();
		
		test.getTasksByConditionsTest(null,null,null,null,null,0,10);
	}



	public TaskDAO getTaskDAO() {
		return taskDAO;
	}

	public void setTaskDAO(TaskDAO taskDAO) {
		this.taskDAO = taskDAO;
	}
}
