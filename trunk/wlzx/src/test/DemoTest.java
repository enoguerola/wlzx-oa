

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.jbpm.api.Configuration;
import org.jbpm.api.ExecutionService;
import org.jbpm.api.HistoryService;
import org.jbpm.api.IdentityService;
import org.jbpm.api.ManagementService;
import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.ProcessEngine;
import org.jbpm.api.ProcessInstance;
import org.jbpm.api.RepositoryService;
import org.jbpm.api.TaskService;
import org.jbpm.api.history.HistoryActivityInstance;
import org.jbpm.api.history.HistoryTask;
import org.jbpm.api.task.Task;

import system.wlims.oa.entity.logistics.PurchaseApplyModel;

public class DemoTest extends TestCase {
	//----发布流程定义
	//第一步：启动流程引擎
	    private ProcessEngine processEngine;  
	    private RepositoryService repositoryService;  
	    private ExecutionService executionService;  
	    private TaskService taskService;  
	    private HistoryService historyService;
	    private ManagementService managementService;
	    private IdentityService identityService;
	public DemoTest(){
		processEngine=Configuration.getProcessEngine();
		repositoryService=processEngine.getRepositoryService();  
        executionService = processEngine.getExecutionService();  
        taskService= processEngine.getTaskService();  
        historyService=processEngine.getHistoryService();
        managementService=processEngine.getManagementService();
        identityService=processEngine.getIdentityService();
	}
	protected void setUp(){
		processEngine.getRepositoryService().createDeployment()
		.addResourceFromClasspath("logistis-caigou.jpdl.xml").deploy();
	}
//	//测试发布
//	public void testDeploy(){
//		//获取流程服务
//		RepositoryService service=processEngine.getRepositoryService();
//		//把流程定义发布到流程引擎中
//		String developementId=service.createDeployment()
//		                      .addResourceFromClasspath("logistis-caigou.jpdl.xml").deploy();
//		
//		
//		//----查看流程定义
//		//发布流程定义信息，查看已发布流程定义列表
//		List<ProcessDefinition> definitions=service.createProcessDefinitionQuery().list();//执行搜索
//		for (ProcessDefinition processDefinition : definitions) {
//			System.out.println(processDefinition.getId());
//		}
//		
//		//----删除流程定义，这里用级联删除会比较好
//		service.deleteDeploymentCascade(developementId);
//		
//		//查看输出后流程定义的个数
//		System.out.println(service.createProcessDefinitionQuery().list().size());
//		
//	}
//	public void testProcessInstance(){
//		//这个是专门管理流程实例的
//		ExecutionService executionService=processEngine.getExecutionService();
//		//通过流程定义文件的名称当做KEY来获取流程实例；也就是发布新流程
//		ProcessInstance processInstance=executionService.startProcessInstanceByKey("caigou");
//		System.out.println(processInstance);
//		
//		//这里输出流程实例是否结束，针对本实例来说肯定是FALSE，因为本实例中有STATE，所以会在STATE这里处理等待状态，不会结束 
//		//也就是接下来要说的执行等待的流程,除非你调用executionService.signalExecutionById
//		System.out.println(processInstance.isEnded());
//		
//		//这个方法将是处理等待转该的流程执行到结束，返回值热仍然是一个流程实例
//		processInstance=executionService.signalExecutionById(processInstance.getId());
//		System.out.println(processInstance.isEnded());
//	}
//	public void testDeleteProcessInstance(){
//		ExecutionService executionService=processEngine.getExecutionService();
//		ProcessInstance processInstance=executionService.startProcessInstanceByKey("caigou");
//		executionService.deleteProcessInstanceCascade(processInstance.getId());
//		
//	}
	
//	public void testProcessInastanceList(){
//	  ExecutionService executionService=processEngine.getExecutionService();
//	  ProcessInstance pi=executionService.startProcessInstanceByKey("caigou");
//	  ProcessInstance pi1=executionService.startProcessInstanceByKey("caigou");
//	  List<ProcessInstance> pis=executionService.createProcessInstanceQuery().list();
//	  for (ProcessInstance processInstance : pis) {
//		System.out.println(processInstance);
//	}
//	}
	public void testPurchase(){
		  PurchaseApplyModel purchase=new PurchaseApplyModel();
		  purchase.setApplyUser("11");
		  purchase.setApplyUserDepartmentLeader("22");
		  Map map=new HashMap();
		  map.put("purchase", purchase);
		  ProcessInstance processInstance = executionService.startProcessInstanceByKey("caigou", map);
		  Task task=taskService.createTaskQuery().processInstanceId(processInstance.getId())
		  				  .assignee(purchase.getApplyUser())
		  				  .uniqueResult();//取刚发起的流程的任务
		  taskService.completeTask(task.getId());//跳过申请task节点
		//7由RepositoryService创建流程定义查询接口

        List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().list();
        for(ProcessDefinition processDefinition:list){
            System.out.println(processDefinition.getDeploymentId()+"---" +processDefinition.getId()+"---"+processDefinition.getName());
        }
		 List<Task> tasks= taskService.findPersonalTasks("22");
		 for(Task t:tasks){
			 System.out.println(t.getName());
		 }
		 List<HistoryTask> hts=historyService.createHistoryTaskQuery().executionId(task.getExecutionId()).list();
		 for(HistoryTask ht:hts){
			 System.out.println(ht.getState());
		 }
		 List<HistoryActivityInstance> hais=historyService.createHistoryActivityInstanceQuery().executionId(task.getExecutionId()).list();
		 for(HistoryActivityInstance hai:hais){
			 System.out.println(hai.getActivityName());
		 }
	}
}
