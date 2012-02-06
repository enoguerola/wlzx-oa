package system.wlims.oa.serviceImpl.logistics;

import java.util.Date;

import org.jbpm.api.Configuration;
import org.jbpm.api.ExecutionService;
import org.jbpm.api.HistoryService;
import org.jbpm.api.IdentityService;
import org.jbpm.api.ManagementService;
import org.jbpm.api.ProcessEngine;
import org.jbpm.api.RepositoryService;
import org.jbpm.api.TaskService;

import system.PaginationSupport;
import system.dao.DepartmentDAO;
import system.dao.RoleDAO;
import system.dao.UserDAO;
import system.entity.DepartmentModel;
import system.entity.RoleModel;
import system.utils.UtilDateTime;
import system.wlims.oa.dao.logistics.PurchaseApplyDAO;
import system.wlims.oa.entity.logistics.PurchaseApplyModel;
import system.wlims.oa.service.logistics.PurchaseApplyService;

public class PurchaseApplyServiceImpl implements PurchaseApplyService{
	private ProcessEngine processEngine;  
    private RepositoryService repositoryService;  
    private ExecutionService executionService;  
    private TaskService taskService;  
    private HistoryService historyService;
    private ManagementService managementService;
    private IdentityService identityService;
    public PurchaseApplyServiceImpl(){
		processEngine=Configuration.getProcessEngine();
		repositoryService=processEngine.getRepositoryService();  
        executionService = processEngine.getExecutionService();  
        taskService= processEngine.getTaskService();  
        historyService=processEngine.getHistoryService();
        managementService=processEngine.getManagementService();
        identityService=processEngine.getIdentityService();
        processEngine.getRepositoryService().createDeployment().addResourceFromClasspath("logistis-caigou.jpdl.xml").deploy();
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
	}

	
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
	public PaginationSupport<PurchaseApplyModel> getApplyListByUser(
			String applyUserId, int index, int pageSize) {
		// TODO Auto-generated method stub
		return purchaseApplyDAO.getApplyListByUser(applyUserId,index,pageSize);
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
}
