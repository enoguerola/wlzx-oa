/**
 * 
 */
package system.serviceImpl;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import system.dao.*;
import system.entity.DataAccessModeModel;
import system.entity.DepartmentModel;
import system.entity.MenuModel;
import system.entity.ModuleModel;
import system.entity.OperationModel;
import system.entity.RoleModel;
import system.entity.SystemModel;
import system.entity.UserModel;
import system.service.InitService;


  
  /**
 *
 * 类名称：InitService
 * 类描述：
 * 创建人：wuyuyue
 * 创建时间：2011-4-16 下午02:46:05
 * 修改人：wuyuyue
 * 修改时间：2011-4-16 下午02:46:05
 * 修改备注：
 * @version
 *
 */

public class InitServiceImpl  implements InitService{
	private SystemDAO systemDAO;
	private MenuDAO menuDAO;
	private ModuleDAO moduleDAO;
	private OperationDAO operationDAO;
	private DataAccessModeDAO dataAccessModeDAO;
	private DepartmentDAO departmentDAO;
	private RoleDAO roleDAO;
	private UserDAO userDAO;
	/**
	 * @param args
	 */
	public SystemDAO getSystemDAO() {
		return systemDAO;
	}
	public void setSystemDAO(SystemDAO systemDAO) {
		this.systemDAO = systemDAO;
	}
	public MenuDAO getMenuDAO() {
		return menuDAO;
	}
	public void setMenuDAO(MenuDAO menuDAO) {
		this.menuDAO = menuDAO;
	}
	public ModuleDAO getModuleDAO() {
		return moduleDAO;
	}
	public void setModuleDAO(ModuleDAO moduleDAO) {
		this.moduleDAO = moduleDAO;
	}
	public OperationDAO getOperationDAO() {
		return operationDAO;
	}
	public void setOperationDAO(OperationDAO operationDAO) {
		this.operationDAO = operationDAO;
	}
	public DataAccessModeDAO getDataAccessModeDAO() {
		return dataAccessModeDAO;
	}
	public void setDataAccessModeDAO(DataAccessModeDAO dataAccessModeDAO) {
		this.dataAccessModeDAO = dataAccessModeDAO;
	}
	public DepartmentDAO getDepartmentDAO() {
		return departmentDAO;
	}
	public void setDepartmentDAO(DepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}
	public RoleDAO getRoleDAO() {
		return roleDAO;
	}
	public void setRoleDAO(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}
	public UserDAO getUserDAO() {
		return userDAO;
	}
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	
	public void initSystem(){
		//初始化根系统
		SystemModel root=systemDAO.getSystemBySymbol("root");
		if(root==null){
			root=new SystemModel();
			root.setSymbol("root");
			root.setCreationDate(new Date());
			root.setName("温岭数字化校园系列");
			root.setDetail("数字化校园信息平台是以学校现有网络为基础，以服务于全校师生的教学、科研、生活为目的，建立在学校数据中心平台之上，涵盖了学校的信息化标准管理、学校管理、学生管理、教学管理、教职工管理、科研管理、财务管理、资产与设备管理、行政办公管理、数字图书资料管理等全方位的管理信息平台与信息服务平台。");
			root.setIndexPath("system/index.swf");
			root.setModifiedDate(new Date());
		}else{
			
		}
		systemDAO.saveOrUpdate(root);

	}
	public void printSystemStructure(){
		System.out.println("***系统结构图begin***");
		SystemModel root=systemDAO.getSystemBySymbol("root");
		printSystem(root,"");
		System.out.println("***系统结构图end***");
	}
	
	public void printSystem(SystemModel system,String tab){
		if(system!=null){
			System.out.println(tab+"->"+system.getName()+"(系统)");
			if(system.getChildren()!=null)
			for(SystemModel subSystem:system.getChildren()){
				printSystem(subSystem,tab+"  ");
				if(subSystem.getMenus()!=null)
				for(MenuModel menu:subSystem.getMenus()){
					printMenu(menu,tab+"  "+"  ");
				}
			}
		}
	}
	public void printMenu(MenuModel menu,String tab){
		if(menu!=null){
			System.out.println(tab+"->"+menu.getName()+"(菜单)");
			if(menu.getChildren()!=null)
			for(MenuModel subMenu:menu.getChildren()){
				printMenu(subMenu,tab+"  ");
				if(subMenu.getModules()!=null)
				for(ModuleModel module:subMenu.getModules()){
					printModule(module,tab+"  "+"  ");
				}
			}
		}
		
	}
	public void printModule(ModuleModel module,String tab){
		if(module!=null){
			System.out.println(tab+"->"+module.getName()+"(模块)");
			if(module.getChildren()!=null&&module.getChildren().size()>0)
				for(ModuleModel subModule:module.getChildren()){
					printModule(subModule,tab+"  ");
					if(subModule.getOperations()!=null)
					for(OperationModel operation:subModule.getOperations()){
						printOperation(operation,tab+"  "+"  ");
					}
				}
			else{
				for(OperationModel operation:module.getOperations()){
					printOperation(operation,tab+"  "+"  ");
				}
			}
		}
		
	}
	public void printOperation(OperationModel operation,String tab){
		if(operation!=null){
			System.out.println(tab+"->"+operation.getName()+"(操作)");
			if(operation.getDataAccessModes()!=null&&operation.getDataAccessModes().size()>0)
				for(DataAccessModeModel dam:operation.getDataAccessModes()){
					printDAM(dam,tab+"  "+"  ");
				}
		}	
	}
	public void printDAM(DataAccessModeModel dam,String tab){
		if(dam!=null){
			System.out.println(tab+"->"+dam.getName()+"(访问)");
		}	
	}
	public void initDepartment(){
		//初始化根部门
		DepartmentModel root=departmentDAO.getDepartmentBySymbol("root");
		if(root==null){
			root=new DepartmentModel();
			root.setSymbol("root");
			root.setCreationDate(new Date());
			root.setName("温岭中学");
			root.setModifiedDate(new Date());
			RoleModel rootRole=new RoleModel();
			rootRole.setSymbol("root_supervisor");
			rootRole.setCreationDate(new Date());
			rootRole.setName("温岭中学校长");
			rootRole.setModifiedDate(new Date());
			rootRole.setSupervisorFlag(true);
			root.getRoles().add(rootRole);
		}else{
			
			
		}
		departmentDAO.saveOrUpdate(root);
	}
	public void printDepartmentStructure(){
		System.out.println("***部门结构图begin***");
		DepartmentModel root=departmentDAO.getDepartmentBySymbol("root");
		printDepartment(root,"");
		System.out.println("***部门结构图end***");
	}

	private void printDepartment(DepartmentModel department, String tab) {
		if(department!=null){
			System.out.println(tab+"->"+department.getName()+"(部门)");
			if(department.getSubordinates()!=null)
			for(DepartmentModel subDepartment:department.getSubordinates()){
				printDepartment(subDepartment,tab+"  ");
				if(subDepartment.getRoles()!=null)
				for(RoleModel role:subDepartment.getRoles()){
					printRole(role,tab+"  "+"  ");
				}
			}
		}
		
	}
	private void printRole(RoleModel role, String tab) {
		if(role!=null){
			System.out.println(tab+"->"+role.getName()+"(角色)");
			if(role.getSubordinates()!=null)
			for(RoleModel subRole:role.getSubordinates()){
				printRole(subRole,tab+"  ");
				if(subRole.getUsers()!=null)
				for(UserModel user:subRole.getUsers()){
					printUser(user,tab+"  "+"  ");
				}
			}
		}
		
	}
	private void printUser(UserModel user, String tab) {
		if(user!=null){
			System.out.println(tab+"->"+user.getName()+"(用户)");
			if(user.getSubordinates()!=null)
			for(UserModel subUser:user.getSubordinates()){
				printUser(subUser,tab+"  ");
				
			}
		}
		
	}
	public static void main(String[] args) {
		 ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"system/service/system.xml","system/service/spring-system.xml"});
		// TODO Auto-generated method stub
		InitServiceImpl initService=(InitServiceImpl)applicationContext.getBean("initService");
		initService.initSystem();
		initService.printSystemStructure();
		initService.initDepartment();
		initService.printDepartmentStructure();
//		System.out.println(initService.getModuleDAO().getModuleBySymbol("basic_authorization_department_main").getOperations().size());

	}
}
