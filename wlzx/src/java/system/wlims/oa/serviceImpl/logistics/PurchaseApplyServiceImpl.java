package system.wlims.oa.serviceImpl.logistics;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
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

import org.jbpm.api.history.HistoryTask;
import org.jbpm.api.task.Task;
import org.jbpm.pvm.internal.history.model.HistoryTaskInstanceImpl;

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
		vo.setPurchaseDescription(model.getPurchaseName());
		vo.setPurchaseName(model.getPurchaseName());
		vo.setResourceDepartmentLeader(vo.getResourceDepartmentLeader());
		vo.setSubmitFlag(model.getSubmitFlag());
		
		List<JBPMTaskVO> listObjects=new ArrayList<JBPMTaskVO>();
//		ProcessInstance pd = executionService.findProcessInstanceById(model.getProcessInstanceId());
  
		List<HistoryTask> hList=historyService.createHistoryTaskQuery().executionId(model.getProcessInstanceId()).list();
		for(HistoryTask task:hList){
			JBPMTaskVO o=new JBPMTaskVO();
			// 好像只能自己写hql了
			HistoryTaskInstanceImpl hti =  getHistoryTaskInstanceByTaskId(task.getId());
			System.out.println(hti.getActivityName());
			o.setAssignee(task.getAssignee());
			o.setName(hti.getActivityName());
			o.setBeginTime(task.getCreateTime());
			o.setEndTime(task.getEndTime());
			o.setId(task.getId());
			o.setState(task.getState());
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
		vo.setState(taskService.createTaskQuery().processInstanceId(model.getProcessInstanceId()).uniqueResult().getActivityName());
		return vo;
	}
	@Override
	public PaginationSupport<PurchaseApplyModel> getApplyListByUser(
			String applyUserId, int index, int pageSize) {
		// TODO Auto-generated method stub
		PaginationSupport<PurchaseApplyModel> ps= purchaseApplyDAO.getApplyListByUser(applyUserId,index,pageSize);
		if(ps!=null&&ps.getItemCount()>0){
			for(PurchaseApplyModel model:ps.getItems()){
				model.setState(taskService.createTaskQuery().processInstanceId(model.getProcessInstanceId()).uniqueResult().getActivityName());

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
		ProcessDefinition pd=repositoryService.createProcessDefinitionQuery().processDefinitionKey("caigou").uniqueResult();
		List<HistoryTask> list=historyService.createHistoryTaskQuery().assignee(userId).list();
		if(list!=null&&list.size()>0){
			for(HistoryTask task:list){
				HistoryTaskInstanceImpl hti =  getHistoryTaskInstanceByTaskId(task.getId());
				ProcessInstance processInstance = executionService.findProcessInstanceById(task.getExecutionId());
				if(!processInstance.getProcessDefinitionId().equals(pd.getId()))continue;
				if(processInstance.isActive(hti.getActivityName()))continue;
				PurchaseApplyModel model=purchaseApplyDAO.getByProcessInstanceId(processInstance.getId());
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
				
				
				results.add(vo);
			}
		}
		
		return results;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void saveApprove(String taskId, String approveState,
			String approveDescription, String money) {
		// TODO Auto-generated method stub
		Map map=new HashMap();
		map.put("approveDescription", approveDescription);
		Task task=taskService.getTask(taskId);
		if(StringUtils.isNotEmpty(money)){
			ProcessInstance processInstance = executionService.findProcessInstanceById(task.getExecutionId());
			PurchaseApplyModel model=purchaseApplyDAO.getByProcessInstanceId(processInstance.getId());
			model.setMoney(Double.parseDouble(money));
			purchaseApplyDAO.saveOrUpdate(model);
		}
		HistoryTaskInstanceImpl hti =  getHistoryTaskInstanceByTaskId(task.getId());
		taskService.completeTask(taskId,approveState,map); 
		
		
	}

	
}
