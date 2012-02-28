package system.wlims.oa.serviceImpl.logistics;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
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
import org.jbpm.api.cmd.Command;
import org.jbpm.api.cmd.Environment;

import org.jbpm.api.history.HistoryProcessInstance;
import org.jbpm.api.history.HistoryTask;
import org.jbpm.api.model.Transition;
import org.jbpm.api.task.Task;
import org.jbpm.pvm.internal.env.EnvironmentFactory;
import org.jbpm.pvm.internal.history.model.HistoryTaskInstanceImpl;
import org.jbpm.pvm.internal.model.ActivityImpl;
import org.jbpm.pvm.internal.model.ExecutionImpl;
import org.jbpm.pvm.internal.model.ProcessDefinitionImpl;
import org.jbpm.pvm.internal.model.TransitionImpl;

import system.PaginationSupport;
import system.dao.DepartmentDAO;
import system.dao.RoleDAO;
import system.dao.UserDAO;
import system.entity.DepartmentModel;
import system.entity.RoleModel;
import system.utils.StringUtils;
import system.utils.UtilDateTime;
import system.wlims.oa.dao.logistics.PurchaseApplyDAO;
import system.wlims.oa.entity.logistics.PurchaseApplyModel;
import system.wlims.oa.service.logistics.PurchaseApplyService;
import system.wlims.oa.vo.JBPMTaskVO;
import system.wlims.oa.vo.PurchaseApplyVO;
import system.wlims.oa.vo.PurchaseApproveTaskVO;

public class PurchaseApplyServiceImpl implements PurchaseApplyService{
	private ProcessEngine processEngine;  
    private RepositoryService repositoryService;  
    private ExecutionService executionService;  
    private TaskService taskService;  
    private HistoryService historyService;
    private ManagementService managementService;
    private IdentityService identityService;
    public PurchaseApplyServiceImpl() {
		processEngine=Configuration.getProcessEngine();
		repositoryService=processEngine.getRepositoryService();  
        executionService = processEngine.getExecutionService();  
        taskService= processEngine.getTaskService();  
        historyService=processEngine.getHistoryService();
        managementService=processEngine.getManagementService();
        identityService=processEngine.getIdentityService();
	}
	
	private PurchaseApplyDAO purchaseApplyDAO;
	private DepartmentDAO departmentDAO;
	private UserDAO userDAO;
	private RoleDAO roleDAO;
	public PurchaseApplyDAO getPurchaseApplyDAO() {
		return purchaseApplyDAO;
	}

	public void setPurchaseApplyDAO(PurchaseApplyDAO purchaseApplyDAO) {
		this.purchaseApplyDAO = purchaseApplyDAO;
	}
	
	@Override
	public void submitPurchaseApply(String applyId){
		PurchaseApplyModel model=purchaseApplyDAO.get(applyId);
		model.setSubmitFlag(true);
		model.setApplyTime(new Date());
		purchaseApplyDAO.saveOrUpdate(model);
		Task task=taskService.createTaskQuery().processInstanceId(model.getProcessInstanceId()).assignee(model.getApplyUser()).uniqueResult();//取刚发起的流程的任务
		taskService.completeTask(task.getId());
	}

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void addPurchaseApply(PurchaseApplyModel apply) {
		// TODO Auto-generated method stub
		Date currentDate=new Date();
		apply.setApplyNo(UtilDateTime.toDateString(currentDate, "yyyyMMddHHmmss"));
		apply.setApplyTime(currentDate);
		String departmentId=apply.getApplyUserDepartmentId();
		DepartmentModel department=departmentDAO.get(departmentId); 
		try{
			apply.setApplyUserDepartmentLeader(department.getMasterUsers().iterator().next().getId());
		}catch(Exception e){
			apply.setApplyUserDepartmentLeader("1");
		}
		DepartmentModel resourceDepartment=departmentDAO.getResourceFlagDepartment();
		try{
			apply.setResourceDepartmentLeader(resourceDepartment.getMasterUsers().iterator().next().getId());
		}catch(Exception e){
			apply.setResourceDepartmentLeader("1");
		}
		DepartmentModel applyUserFirstLevelDepartment=department.getTrueFirstLevelDepartment();
		try{
			apply.setApplyUserViceHeaderMaster(applyUserFirstLevelDepartment.getLeaderUsers().iterator().next().getId());
		}catch(Exception e){
			apply.setApplyUserViceHeaderMaster("1");
		}
		
		RoleModel financeViceHeaderMasterRole=roleDAO.getFinanceViceHeaderMasterRole();
		try{
			apply.setFinanceViceHeaderMaster(financeViceHeaderMasterRole.getAllUsers().iterator().next().getId());
		}catch(Exception e){
			apply.setFinanceViceHeaderMaster("1");
		}
		
		DepartmentModel root=departmentDAO.getDepartmentBySymbol("root");
		try{
			apply.setHeaderMaster(root.getLeaderUsers().iterator().next().getId());
		}catch(Exception e){
			apply.setHeaderMaster("1");
		}
		purchaseApplyDAO.saveOrUpdate(apply);
		Map map=new HashMap();
		map.put("purchase", apply);
		ProcessInstance processInstance = executionService.startProcessInstanceByKey("caigou", map);
		apply.setProcessInstanceId(processInstance.getId());
		purchaseApplyDAO.saveOrUpdate(apply);
	}

	@Override
	public void updatePurchaseApply(PurchaseApplyModel apply) {
		// TODO Auto-generated method stub
		String departmentId=apply.getApplyUserDepartmentId();
		DepartmentModel department=departmentDAO.get(departmentId); 
		try{
			apply.setApplyUserDepartmentLeader(department.getMasterUsers().iterator().next().getId());
		}catch(Exception e){
			apply.setApplyUserDepartmentLeader("1");
		}
		DepartmentModel resourceDepartment=departmentDAO.getResourceFlagDepartment();
		try{
			apply.setResourceDepartmentLeader(resourceDepartment.getMasterUsers().iterator().next().getId());
		}catch(Exception e){
			apply.setResourceDepartmentLeader("1");
		}
		DepartmentModel applyUserFirstLevelDepartment=department.getTrueFirstLevelDepartment();
		try{
			apply.setApplyUserViceHeaderMaster(applyUserFirstLevelDepartment.getLeaderUsers().iterator().next().getId());
		}catch(Exception e){
			apply.setApplyUserViceHeaderMaster("1");
		}
		
		RoleModel financeViceHeaderMasterRole=roleDAO.getFinanceViceHeaderMasterRole();
		try{
			apply.setFinanceViceHeaderMaster(financeViceHeaderMasterRole.getAllUsers().iterator().next().getId());
		}catch(Exception e){
			apply.setFinanceViceHeaderMaster("1");
		}
		
		DepartmentModel root=departmentDAO.getDepartmentBySymbol("root");
		try{
			apply.setHeaderMaster(root.getLeaderUsers().iterator().next().getId());
		}catch(Exception e){
			apply.setHeaderMaster("1");
		}
		purchaseApplyDAO.saveOrUpdate(apply);
	}

	@Override
	public void canclePurchaseApplyById(String applyId) {
		// TODO Auto-generated method stub
		PurchaseApplyModel model=purchaseApplyDAO.get(applyId);
		model.setCancleFlag(true);
		purchaseApplyDAO.saveOrUpdate(model);
	}

	@Override
	public PurchaseApplyModel loadApplyInfoById(String applyId) {
		// TODO Auto-generated method stub
		return purchaseApplyDAO.get(applyId);
	}
	@Override
	public PurchaseApplyVO getPurchaseApplyDetailById(String applyId) {
		// TODO Auto-generated method stub
		PurchaseApplyVO vo=new PurchaseApplyVO();
		PurchaseApplyModel model=purchaseApplyDAO.get(applyId);
		vo.setApplyNo(model.getApplyNo());
		vo.setApplyTime(model.getApplyTime());
		vo.setApplyUser(model.getApplyUser());
		vo.setApplyUserDepartmentId(model.getApplyUserDepartmentId());
		vo.setApplyUserDepartmentLeader(model.getApplyUserDepartmentLeader());
		vo.setApplyUserViceHeaderMaster(model.getApplyUserViceHeaderMaster());
		vo.setCancleFlag(model.getCancleFlag());
		vo.setFinanceViceHeaderMaster(model.getFinanceViceHeaderMaster());
		vo.setHeaderMaster(model.getHeaderMaster());
		vo.setId(model.getId());
		vo.setIsGovernmentPurchase(model.getIsGovernmentPurchase());
		vo.setMoney(model.getMoney());
		vo.setProcessInstanceId(model.getProcessInstanceId());
		vo.setPurchaseDescription(model.getPurchaseDescription());
		vo.setPurchaseName(model.getPurchaseName());
		vo.setResourceDepartmentLeader(vo.getResourceDepartmentLeader());
		vo.setSubmitFlag(model.getSubmitFlag());
		vo.setSchoolOfficeApproveState(model.getSchoolOfficeApproveState());
		vo.setSchoolOfficeApproveDescription(model.getSchoolOfficeApproveDescription());
		vo.setPurchaseDate(model.getPurchaseDate());
		vo.setPurchaseDetail(model.getPurchaseDetail());
		vo.setPurchaseUser(model.getPurchaseUser());
		List<JBPMTaskVO> listObjects=new ArrayList<JBPMTaskVO>();
//		ProcessInstance pd = executionService.findProcessInstanceById(model.getProcessInstanceId());
		
		List<HistoryTask> hList=historyService.createHistoryTaskQuery().executionId(model.getProcessInstanceId()).list();
		for(HistoryTask task:hList){
			JBPMTaskVO o=new JBPMTaskVO();
			// 好像只能自己写hql了
			HistoryTaskInstanceImpl hti =  getHistoryTaskInstanceByTaskId(task.getId());
			System.out.println(hti.getActivityName());
			if(hti.getActivityName().equals("申请"))continue;

			o.setAssignee(task.getAssignee());
			o.setName(hti.getActivityName());
			o.setBeginTime(task.getCreateTime());
			o.setEndTime(task.getEndTime());
			o.setId(task.getId());
//			Set<String> parms=historyService.getVariableNames(task.getId());
//			if(parms!=null&&parms.contains("approveState")&&parms.contains("approveDescription")){
//				o.setState(historyService.getVariable(task.getId(),"approveState").toString());
//				o.setDescription(historyService.getVariable(task.getId(),"approveDescription").toString());
//			}
			Set<String> parms=historyService.getVariableNames(model.getProcessInstanceId());
			if(parms!=null&&parms.contains(task.getId()+"approveState")&&parms.contains(task.getId()+"approveDescription")){
				o.setState(historyService.getVariable(model.getProcessInstanceId(),task.getId()+"approveState").toString());
				o.setDescription(historyService.getVariable(model.getProcessInstanceId(),task.getId()+"approveDescription").toString());
			}
			

			listObjects.add(o);
		}
		// 根据任务开始的时间进行排序，列出来
//		List<HistoryActivityInstance> haInstances = historyService.createHistoryActivityInstanceQuery().processInstanceId(model.getProcessInstanceId()).orderAsc(HistoryProcessInstanceQuery.PROPERTY_STARTTIME).list();
//		for (HistoryActivityInstance ha : haInstances) { 
//			JBPMTaskVO o=new JBPMTaskVO();
//			HistoryTaskInstanceImpl historyTaskInstanceImpl=(HistoryTaskInstanceImpl)ha;
//			Hibernate.initialize(historyTaskInstanceImpl.getHistoryTask());
////			HistoryTaskImpl task=historyTaskInstanceImpl.getHistoryTask();
////			o.setAssignee(task.getAssignee());
//			o.setName(ha.getActivityName());
//			o.setBeginTime(ha.getStartTime());
//			o.setEndTime(ha.getEndTime());
////			o.setId(task.getId());
////			o.setState(task.getState());
//			listObjects.add(o);
//		}  
		
		vo.setHistoryJBPMTaskVOs(listObjects);
		ProcessInstance  processInstance=executionService.createProcessInstanceQuery().processInstanceId(model.getProcessInstanceId()).uniqueResult();
		if(processInstance==null){
			HistoryProcessInstance  historyProcessInstance =historyService.createHistoryProcessInstanceQuery().processInstanceId(model.getProcessInstanceId()).uniqueResult();
			if(historyProcessInstance!=null)
				vo.setState(historyProcessInstance.getEndActivityName());
			if(StringUtils.isNotEmpty(model.getSchoolOfficeApproveState()))
				 model.setState("校办会决议"+model.getSchoolOfficeApproveState());
		}else{
			Task task=taskService.createTaskQuery().processInstanceId(model.getProcessInstanceId()).uniqueResult();
			vo.setState(task.getActivityName());

		}

		return vo;
	}
	@Override
	public PaginationSupport<PurchaseApplyModel> getApplyListByUser(
			String applyUserId, int index, int pageSize) {
		// TODO Auto-generated method stub
		PaginationSupport<PurchaseApplyModel> ps= purchaseApplyDAO.getApplyListByUser(applyUserId,index,pageSize);
		if(ps!=null&&ps.getItemCount()>0){
			for(PurchaseApplyModel model:ps.getItems()){
				ProcessInstance  processInstance=executionService.createProcessInstanceQuery().processInstanceId(model.getProcessInstanceId()).uniqueResult();
				if(processInstance==null){
					
					HistoryProcessInstance  historyProcessInstance =historyService.createHistoryProcessInstanceQuery().processInstanceId(model.getProcessInstanceId()).uniqueResult();
					if(historyProcessInstance!=null)
						model.setState(historyProcessInstance.getEndActivityName());
					
				}else{
					Task task=taskService.createTaskQuery().processInstanceId(model.getProcessInstanceId()).uniqueResult();
					model.setState(task.getActivityName());

				}
				if(StringUtils.isNotEmpty(model.getSchoolOfficeApproveState()))
					 model.setState("校办会决议"+model.getSchoolOfficeApproveState());
			}
		}
		return ps;
	}

	public DepartmentDAO getDepartmentDAO() {
		return departmentDAO;
	}

	public void setDepartmentDAO(DepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public RoleDAO getRoleDAO() {
		return roleDAO;
	}

	public void setRoleDAO(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}
	


	public HistoryTaskInstanceImpl getHistoryTaskInstanceByTaskId(final String taskId){
	  return processEngine.execute(new Command<HistoryTaskInstanceImpl>(){
	    private static final long serialVersionUID = 1L;
	    @Override
	    public HistoryTaskInstanceImpl execute(Environment environment)
	        throws Exception {
	      Session session = environment.get(Session.class);
	      StringBuilder hql = new StringBuilder();
	      hql.append("select hti from ").append(HistoryTaskInstanceImpl.class.getName());
	      hql.append(" as hti ");
	      hql.append("where hti.historyTask.dbid = :taskDbid");
	      return (HistoryTaskInstanceImpl) session.createQuery(hql.toString())
	               .setLong("taskDbid", Long.valueOf(taskId)).uniqueResult();
	    }
	  });
	}

	@Override
	public List<PurchaseApproveTaskVO> getPersonPurchaseApproveTask(
			String userId) {
		// TODO Auto-generated method stub
		List<PurchaseApproveTaskVO> results=new ArrayList<PurchaseApproveTaskVO>();
		ProcessDefinition pd=repositoryService.createProcessDefinitionQuery().processDefinitionKey("caigou").uniqueResult();
		List<Task> list=taskService.createTaskQuery().processDefinitionId(pd.getId()).assignee(userId).list();
		if(list!=null&&list.size()>0){
			for(Task task:list){
				ProcessInstance processInstance = executionService.findProcessInstanceById(task.getExecutionId());
				PurchaseApplyModel model=purchaseApplyDAO.getByProcessInstanceId(processInstance.getId());
				if(model.getCancleFlag()==true)continue;
				if(task.getActivityName().equals("申请"))continue;
				PurchaseApproveTaskVO vo=new PurchaseApproveTaskVO();
				vo.setApplyNo(model.getApplyNo());
				vo.setApplyTime(model.getApplyTime());
				vo.setApplyUser(model.getApplyUser());
				vo.setApplyUserDepartmentId(model.getApplyUserDepartmentId());
				vo.setApplyUserDepartmentLeader(model.getApplyUserDepartmentLeader());
				vo.setApplyUserViceHeaderMaster(model.getApplyUserViceHeaderMaster());
				vo.setCancleFlag(model.getCancleFlag());
				vo.setFinanceViceHeaderMaster(model.getFinanceViceHeaderMaster());
				vo.setHeaderMaster(model.getHeaderMaster());
				vo.setApplyId(model.getId());
				vo.setIsGovernmentPurchase(model.getIsGovernmentPurchase());
				vo.setMoney(model.getMoney());
				vo.setProcessInstanceId(model.getProcessInstanceId());
				vo.setPurchaseDescription(model.getPurchaseName());
				vo.setPurchaseName(model.getPurchaseName());
				vo.setResourceDepartmentLeader(vo.getResourceDepartmentLeader());
				vo.setSubmitFlag(model.getSubmitFlag());
				
				vo.setTaskId(task.getId());
				vo.setActivityName(task.getActivityName());
				vo.setAssignee(task.getAssignee());
				vo.setBeginTime(task.getCreateTime());
				results.add(vo);
			}
		}
		
		return results;
	}

	@Override
	public List<PurchaseApproveTaskVO> getPersonPurchaseApproveHistoryTask(
			String userId) {
		List<PurchaseApproveTaskVO> results=new ArrayList<PurchaseApproveTaskVO>();
		List<HistoryTask> list=historyService.createHistoryTaskQuery().assignee(userId).list();
//		List<HistoryProcessInstance> list2=historyService.createHistoryProcessInstanceQuery().processDefinitionId(null).list();
		
		
		if(list!=null&&list.size()>0){
			for(HistoryTask task:list){
				HistoryTaskInstanceImpl hti =  getHistoryTaskInstanceByTaskId(task.getId());
				PurchaseApplyModel model=purchaseApplyDAO.getByProcessInstanceId(hti.getExecutionId());
				if(hti.getActivityName().equals("申请"))continue;
				PurchaseApproveTaskVO vo=new PurchaseApproveTaskVO();
				vo.setApplyNo(model.getApplyNo());
				vo.setApplyTime(model.getApplyTime());
				vo.setApplyUser(model.getApplyUser());
				vo.setApplyUserDepartmentId(model.getApplyUserDepartmentId());
				vo.setApplyUserDepartmentLeader(model.getApplyUserDepartmentLeader());
				vo.setApplyUserViceHeaderMaster(model.getApplyUserViceHeaderMaster());
				vo.setCancleFlag(model.getCancleFlag());
				vo.setFinanceViceHeaderMaster(model.getFinanceViceHeaderMaster());
				vo.setHeaderMaster(model.getHeaderMaster());
				vo.setApplyId(model.getId());
				vo.setIsGovernmentPurchase(model.getIsGovernmentPurchase());
				vo.setMoney(model.getMoney());
				vo.setProcessInstanceId(model.getProcessInstanceId());
				vo.setPurchaseDescription(model.getPurchaseName());
				vo.setPurchaseName(model.getPurchaseName());
				vo.setResourceDepartmentLeader(vo.getResourceDepartmentLeader());
				vo.setSubmitFlag(model.getSubmitFlag());
				
				
				vo.setTaskId(task.getId());
				vo.setActivityName(hti.getActivityName());
				vo.setAssignee(task.getAssignee());
				vo.setBeginTime(task.getCreateTime());
				vo.setEndTime(task.getEndTime());
				Set<String> parms=historyService.getVariableNames(model.getProcessInstanceId());
				if(parms!=null&&parms.contains(task.getId()+"approveState")&&parms.contains(task.getId()+"approveDescription")){
					vo.setApproveResult(historyService.getVariable(model.getProcessInstanceId(),task.getId()+"approveState").toString());
					vo.setApproveDescription(historyService.getVariable(model.getProcessInstanceId(),task.getId()+"approveDescription").toString());
				}
				
				results.add(vo);
			}
		}
		
		return results;
	}

	@Override
	public void saveApprove(String applyId,String taskId, String approveState,
			String approveDescription, String money) {
		// TODO Auto-generated method stub
		PurchaseApplyModel model=purchaseApplyDAO.get(applyId);

		if(StringUtils.isEmpty(taskId)){//校长办公会议决议
			//suspendProcessInstance(model.getProcessInstanceId());//挂起进程
			model.setCancleFlag(true);

			model.setSchoolOfficeApproveState(approveState);
			model.setSchoolOfficeApproveDescription(approveDescription);
			purchaseApplyDAO.saveOrUpdate(model);
			
//			ProcessInstance  processInstance=executionService.createProcessInstanceQuery().processInstanceId(model.getProcessInstanceId()).uniqueResult();
////			 Execution execution=executionService.findExecutionById(model.getProcessInstanceId());
//			addOutTransition((ProcessDefinitionImpl)repositoryService.createProcessDefinitionQuery().processDefinitionKey("caigou").uniqueResult(),processInstance.findActiveActivityNames().iterator().next(),"校办会决议");
//			taskService.completeTask(taskService.createTaskQuery().processInstanceId(model.getProcessInstanceId()).orderDesc(TaskQuery.PROPERTY_CREATEDATE).list().get(0).getId(),"校办会决议");  
//			removeOutTransition((ProcessDefinitionImpl)repositoryService.createProcessDefinitionQuery().processDefinitionKey("caigou").uniqueResult(),processInstance.findActiveActivityNames().iterator().next(),"校办会决议");

		}
		else{
			HistoryTaskInstanceImpl hti =  getHistoryTaskInstanceByTaskId(taskId);
			ProcessInstance processInstance = executionService.findProcessInstanceById( hti.getExecutionId());
//			ProcessDefinition pd=repositoryService.createProcessDefinitionQuery().processDefinitionKey("caigou").uniqueResult();
			if(StringUtils.isNotEmpty(money)){
				model.setMoney(Double.parseDouble(money));
				purchaseApplyDAO.saveOrUpdate(model);
				Map<String, Object> map=new HashMap<String, Object>();
				map.put("purchase", model);
				map.put(taskId+"approveState", approveState);
				map.put(taskId+"approveDescription", approveDescription);
				executionService.createVariables(processInstance.getId(), map, true);
				taskService.completeTask(taskId,approveState);  

			}else{
				Map<String, Object> map=new HashMap<String, Object>();
				map.put(taskId+"approveState", approveState);
				map.put(taskId+"approveDescription", approveDescription);
				executionService.createVariables(processInstance.getId(), map, true);
				taskService.completeTask(taskId,approveState);  

			}
//			String executionId = processInstance.findActiveExecutionIn("wait for response").getId();
	//
//			processInstance = executionService.signalExecutionById(executionId, approveState);
		}
		
		
		
		

		
	}
	@Override
	public void savePurchase(String applyId, String purchaseDetail,
			String purchaseDate, String purchaseUser) {
		// TODO Auto-generated method stub
		PurchaseApplyModel model=purchaseApplyDAO.get(applyId);
		model.setPurchaseDate(purchaseDate);
		model.setPurchaseDetail(purchaseDetail);
		model.setPurchaseUser(purchaseUser);
		purchaseApplyDAO.saveOrUpdate(model);
 
	}
	@Override
	public PaginationSupport<PurchaseApplyModel> getApplyByConditions(
			String applyUserId, String applyDepartmentId,
			String applyBeginDate, String applyEndDate, int index, int pageSize) {
		// TODO Auto-generated method stub
		PaginationSupport<PurchaseApplyModel> ps= purchaseApplyDAO.getApplyByConditions(applyUserId,applyDepartmentId,applyBeginDate,applyEndDate,index,pageSize);
		if(ps!=null&&ps.getItemCount()>0){
			for(PurchaseApplyModel model:ps.getItems()){
				ProcessInstance  processInstance=executionService.createProcessInstanceQuery().processInstanceId(model.getProcessInstanceId()).uniqueResult();
				if(processInstance==null){
					HistoryProcessInstance  historyProcessInstance =historyService.createHistoryProcessInstanceQuery().processInstanceId(model.getProcessInstanceId()).uniqueResult();
					if(historyProcessInstance!=null)
						model.setState(historyProcessInstance.getEndActivityName());
				
				}else{
					Task task=taskService.createTaskQuery().processInstanceId(model.getProcessInstanceId()).uniqueResult();
					model.setState(task.getActivityName());

				}
				if(StringUtils.isNotEmpty(model.getSchoolOfficeApproveState()))
					 model.setState("校办会决议"+model.getSchoolOfficeApproveState());
				
				if(model.getPurchaseDate()!=null)model.setCanPurchase(false) ;
				else{
					if((model.getState().equals("批准采购")||model.getState().equals("校办会决议批准"))&&model.getPurchaseDate()==null)model.setCanPurchase(true);
					else model.setCanPurchase(false) ;	
					
				}
				
				
				if(model.getPurchaseDate()!=null)model.setCanSchoolOfficeApprove(false) ;
				else{
					
					if(model.getSchoolOfficeApproveState()==null||model.getSchoolOfficeApproveState()=="")model.setCanSchoolOfficeApprove(true) ;
					else model.setCanSchoolOfficeApprove(false) ;
				}
				
				
				if(model.getPurchaseDate()!=null)model.setCanActiveOrCancle(false) ;
				else{
					if(model.getState().equals("不予采购")||model.getState().equals("批准采购"))model.setCanActiveOrCancle(false) ;
					else model.setCanActiveOrCancle(true) ;
				}
				
				
			}
		}
		return ps;
	}

	@Override
	public void activeOrCancle(String applyId) {
		// TODO Auto-generated method stub
		PurchaseApplyModel model=purchaseApplyDAO.get(applyId);
		if(model.getCancleFlag()==true){
			model.setCancleFlag(false);
			purchaseApplyDAO.saveOrUpdate(model);
			//resumeProcessInstance(model.getProcessInstanceId());

		}else{
			model.setCancleFlag(true);
			purchaseApplyDAO.saveOrUpdate(model);
			//suspendProcessInstance(model.getProcessInstanceId());

		}
	}
	public void suspendProcessInstance(String processInstanceId){
		
		EnvironmentFactory environmentFactory = (EnvironmentFactory) processEngine; 
		Environment environment = environmentFactory.openEnvironment(); 
	    Session session = environment.get(Session.class);
	    Transaction transaction = session.beginTransaction();

		ExecutionImpl execution = (ExecutionImpl) session.get(ExecutionImpl.class, new Long(processInstanceId.substring(processInstanceId.indexOf("caigou")+"caigou".length()+1)));
//            execution.setState(Execution.STATE_SUSPENDED);
            execution.suspend();
            session.save(execution);
            session.flush();
            transaction.commit();

	}
	public void resumeProcessInstance(String processInstanceId){
		
		EnvironmentFactory environmentFactory = (EnvironmentFactory) processEngine; 
		Environment environment = environmentFactory.openEnvironment(); 
	    Session session = environment.get(Session.class);
	    Transaction transaction = session.beginTransaction();
		ExecutionImpl execution = (ExecutionImpl) session.get(ExecutionImpl.class, new Long(processInstanceId.substring(processInstanceId.indexOf("caigou")+"caigou".length()+1)));
//            execution.setState(Execution.STATE_ACTIVE_CONCURRENT);
            execution.resume();
            session.save(execution);
            session.flush();
            transaction.commit();

	}
//	 /**
//	  * 动态创建连接当前任务节点至名称为destName的节点的Transition
//	  * @param taskId 任务节点ID
//	  * @param sourceName 源节点名称
//	  * @param destName  目标节点名称
//	  */
//	 public void addOutTransition(ProcessDefinitionImpl pd,String sourceName,String destName){
//
//		 EnvironmentFactory environmentFactory = (EnvironmentFactory) processEngine;
//		 Environment env=null;
//		 try {
//			 env = environmentFactory.openEnvironment();
//			    Session session = env.get(Session.class);
//			    Transaction transaction = session.beginTransaction();
//
//			 //取得当前流程的活动定义
//			 ActivityImpl sourceActivity = pd.findActivity(sourceName);
//			 //取得目标的活动定义
//			 ActivityImpl destActivity=pd.findActivity(destName);
//
//			 //为两个节点创建连接
//
//			 TransitionImpl transition = sourceActivity.createOutgoingTransition();
//
//			 transition.setName(destName);
//
//			 transition.setDestination(destActivity);
//
//			 sourceActivity.addOutgoingTransition(transition);
//			 session.save(sourceActivity);
//	            session.flush();
//	            transaction.commit();
//		 }catch(Exception ex){
//			 System.out.println(ex.getCause());
//		 }
//	 }
//	 /**
//	  * 动态删除连接sourceName与destName的Transition
//	  * @param taskId
//	  * @param sourceName
//	  * @param destName
//	  */
//	 @SuppressWarnings("unchecked")
//	public void removeOutTransition(ProcessDefinitionImpl pd,String sourceName,String destName){
//		 EnvironmentFactory environmentFactory = (EnvironmentFactory) processEngine;
//		 Environment env=null;
//		 try {
//			 env = environmentFactory.openEnvironment();
//			 Session session = env.get(Session.class);
//			    Transaction transaction = session.beginTransaction();
//			 //取得当前流程的活动定义
//			 ActivityImpl sourceActivity = pd.findActivity(sourceName);
//			 
//			 //若存在这个连接，则需要把该连接删除
//			 List<Transition> trans=(List<Transition>) sourceActivity.getOutgoingTransitions();
//			 for(Transition tran:trans){
//				if(destName.equals(tran.getDestination().getName())){//删除该连接
//					trans.remove(tran);
//					break;
//				}
//			 }
//			 session.save(sourceActivity);
//	            session.flush();
//	            transaction.commit();
//		 }catch(Exception ex){
//			 System.out.println(ex.getCause());
//
//		 }
//	 }

	@Override
	public List<PurchaseApplyModel> getPersonApplyList(String applyUserId) {
		// TODO Auto-generated method stub
		List<PurchaseApplyModel> list= purchaseApplyDAO.getApplyListByUser(applyUserId);
		if(list.size()>0){
			for(PurchaseApplyModel model:list){
				ProcessInstance  processInstance=executionService.createProcessInstanceQuery().processInstanceId(model.getProcessInstanceId()).uniqueResult();
				if(processInstance==null){
					HistoryProcessInstance  historyProcessInstance =historyService.createHistoryProcessInstanceQuery().processInstanceId(model.getProcessInstanceId()).uniqueResult();
					if(historyProcessInstance!=null)
						model.setState(historyProcessInstance.getEndActivityName());
				
				}else{
					Task task=taskService.createTaskQuery().processInstanceId(model.getProcessInstanceId()).uniqueResult();
					model.setState(task.getActivityName());

				}
				if(StringUtils.isNotEmpty(model.getSchoolOfficeApproveState()))
					 model.setState("校办会决议"+model.getSchoolOfficeApproveState());
				
				if(model.getPurchaseDate()!=null)model.setCanPurchase(false) ;
				else{
					if((model.getState().equals("批准采购")||model.getState().equals("校办会决议批准"))&&model.getPurchaseDate()==null)model.setCanPurchase(true);
					else model.setCanPurchase(false) ;	
					
				}
				
				
				if(model.getPurchaseDate()!=null)model.setCanSchoolOfficeApprove(false) ;
				else{
					
					if(model.getSchoolOfficeApproveState()==null||model.getSchoolOfficeApproveState()=="")model.setCanSchoolOfficeApprove(true) ;
					else model.setCanSchoolOfficeApprove(false) ;
				}
				
				
				if(model.getPurchaseDate()!=null)model.setCanActiveOrCancle(false) ;
				else{
					if(model.getState().equals("不予采购")||model.getState().equals("批准采购"))model.setCanActiveOrCancle(false) ;
					else model.setCanActiveOrCancle(true) ;
				}
				
				
			}
		}
		return list;
	}

	
}
