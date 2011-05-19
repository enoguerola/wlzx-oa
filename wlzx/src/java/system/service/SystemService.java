/**
 * 
 */
package system.service;


import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import system.dao.*;
import system.entity.*;



  
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
	//获得某模块
	public ModuleModel getModuleBySymbol(String symbol){		
		return moduleDAO.getModuleBySymbol(symbol);
	}
	//获得某部门
	public DepartmentModel getDepartmentBySymbol(String symbol){		
		return departmentDAO.getDepartmentBySymbol(symbol);
	}
	//获得某部门
	public DepartmentModel getDepartmentById(String departmentId){		
		return departmentDAO.get(departmentId);
	}
	//获得某角色（岗位）
	public RoleModel getRoleById(String roleId){		
		return roleDAO.get(roleId);
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
		MenuModel newMenu=menuDAO.get(menu.getId());
		newMenu.setSymbol(menu.getSymbol());
		newMenu.setCreationDate(menu.getCreationDate());
		newMenu.setDetail(menu.getDetail());
		newMenu.setName(menu.getName());
		newMenu.setSequence(menu.getSequence());
		menuDAO.saveOrUpdate(newMenu);
		return newMenu;		
	}
	//删除菜单
	public boolean menuRemove(String symbol){
//		System.out.println(symbol);
		menuDAO.removeMenuBySymbol(symbol);
		return true;		
	}
	//新增模块
	public ModuleModel moduleAdd(ModuleModel module,String parentType,String parentSymbol){
		if(parentType.equals("menu")){
			MenuModel parentMenu=menuDAO.getMenuBySymbol(parentSymbol);
			parentMenu.getModules().add(module);
			menuDAO.saveOrUpdate(parentMenu);
			return module;
		}else return null;
		
	}
	//更新模块
	public ModuleModel moduleUpdate(ModuleModel module){
		ModuleModel newModule=moduleDAO.get(module.getId());
		newModule.setSymbol(module.getSymbol());
		newModule.setCreationDate(module.getCreationDate());
		newModule.setDetail(module.getDetail());
		newModule.setName(module.getName());
		newModule.setSequence(module.getSequence());
		newModule.setUrl(module.getUrl());
		moduleDAO.saveOrUpdate(newModule);	
		return module;		
	}
	//删除模块
	public boolean moduleRemove(String symbol){
//		System.out.println(symbol);
		moduleDAO.removeModuleBySymbol(symbol);
		return true;		
	}
	//新增部门
	public DepartmentModel departmentAdd(DepartmentModel department,String parentId,String supervisorName){
			DepartmentModel parentDepartment=departmentDAO.get(parentId);
			parentDepartment.getSubordinates().add(department);	
			RoleModel supervisorRole=new RoleModel();
			supervisorRole.setSymbol(department.getSymbol()+"_supervisor");
			supervisorRole.setCreationDate(department.getCreationDate());
			supervisorRole.setName(supervisorName);
			supervisorRole.setModifiedDate(new Date());
			supervisorRole.setSupervisorFlag(true);
			department.getRoles().add(supervisorRole);
			departmentDAO.saveOrUpdate(parentDepartment);
			return department;
		
	}
	//更新部门
	public DepartmentModel departmentUpdate(DepartmentModel department,String supervisorName){
		DepartmentModel newDepartment=departmentDAO.get(department.getId());
		newDepartment.setSymbol(department.getSymbol());
		newDepartment.setCreationDate(department.getCreationDate());
		newDepartment.setDetail(department.getDetail());
		newDepartment.setName(department.getName());
		newDepartment.setSequence(department.getSequence());
		departmentDAO.saveOrUpdate(newDepartment);
		RoleModel role=newDepartment.getSupervisorRole();
		role.setSymbol(department.getSymbol()+"_supervisor");
		role.setName(supervisorName);
		role.setModifiedDate(new Date());
		roleDAO.saveOrUpdate(role);
		return newDepartment;
	}
	//删除部门
	public boolean departmentRemove(String id){
		departmentDAO.remove(departmentDAO.get(id));
		return true;		
	}
	//新增岗位
	public RoleModel roleAdd(RoleModel role,String parentId){
			RoleModel parentRole=roleDAO.get(parentId);
			parentRole.getSubordinates().add(role);	
			roleDAO.saveOrUpdate(parentRole);
			return role;
		
	}
	//更新岗位
	public RoleModel roleUpdate(RoleModel role){
		RoleModel newRole=roleDAO.get(role.getId());
		newRole.setSymbol(role.getSymbol());
		newRole.setCreationDate(role.getCreationDate());
		newRole.setDetail(role.getDetail());
		newRole.setName(role.getName());
		newRole.setSequence(role.getSequence());
		roleDAO.saveOrUpdate(newRole);
		return newRole;
	}
	//删除岗位
	public boolean roleRemove(String id){
		roleDAO.remove(roleDAO.get(id));
		return true;		
	}
	public static void main(String[] args) {
		 ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"system/service/system.xml","system/service/spring-system.xml"});
		SystemService systemService=(SystemService)applicationContext.getBean("systemService");
		ModuleModel module=new ModuleModel();
		module.setName("a");
		module.setCreationDate(new Date());
		module.setDetail("aaa");
		module.setSymbol("rg22222");
		module.setSequence(1);
		systemService.moduleAdd(module,"menu","gweg");
	}
}
