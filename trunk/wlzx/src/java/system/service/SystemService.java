/**
 * 
 */
package system.service;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import system.dao.*;
import system.entity.DepartmentModel;
import system.entity.MenuModel;
import system.entity.RoleModel;
import system.entity.SystemModel;
import system.entity.UserModel;


  
  /**
 *
 * 类名称：SystemService
 * 类描述：
 * 创建人：wuyuyue
 * 创建时间：2011-4-16 下午02:46:05
 * 修改人：wuyuyue
 * 修改时间：2011-4-16 下午02:46:05
 * 修改备注：
 * @version
 *
 */

public class SystemService {
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
	//获得某系统
	public SystemModel getSystemBySymbol(String symbol){		
		return systemDAO.getSystemBySymbol(symbol);
	}
	//获得某菜单
	public MenuModel getMenuBySymbol(String symbol){		
		return menuDAO.getMenuBySymbol(symbol);
	}
	//获得某部门
	public DepartmentModel getDepartmentBySymbol(String symbol){		
		return departmentDAO.getDepartmentBySymbol(symbol);
	}
	//获得某角色（岗位）
	public RoleModel getRoleBySymbol(String symbol){		
		return roleDAO.getRoleBySymbol(symbol);
	}
	//获得某用户
	public UserModel getUserByUserAccount(String userAccount){		
		return userDAO.getUserByUserAccount(userAccount);
	}
	//新增菜单
	public MenuModel menuAdd(MenuModel menu,String parentType,String parentSymbol){
		if(parentType.equals("system")){
			SystemModel parentSystem=systemDAO.getSystemBySymbol(parentSymbol);
			parentSystem.getMenus().add(menu);
			systemDAO.saveOrUpdate(parentSystem);
			return menu;
		}else if(parentType.equals("menu")){
			MenuModel parentMenu=menuDAO.getMenuBySymbol(parentSymbol);
			parentMenu.getChildren().add(menu);
			menuDAO.saveOrUpdate(parentMenu);
			return menu;
		} else return null;
		
	}
	//更新菜单
	public MenuModel menuUpdate(MenuModel menu){
		menuDAO.saveOrUpdate(menu);
		return menu;		
	}
	//删除菜单
	public boolean menuRemove(String symbol){
//		System.out.println(symbol);
		menuDAO.removeMenuBySymbol(symbol);
		return true;		
	}
	public static void main(String[] args) {
		 ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"system/service/system.xml","system/service/spring-system.xml"});
		// TODO Auto-generated method stub
		SystemService systemService=(SystemService)applicationContext.getBean("systemService");
		systemService.menuRemove("a");
	}
}
