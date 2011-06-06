/**
 * 
 */
package system.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import system.components.SecurityUserHolder;
import system.dao.*;
import system.entity.*;
import system.utils.CipherUtil;
import system.utils.StringUtils;



  
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

public class SystemService{
	
	private SystemDAO systemDAO;
	private MenuDAO menuDAO;
	private ModuleDAO moduleDAO;
	private OperationDAO operationDAO;
	private DataAccessModeDAO dataAccessModeDAO;
	private DepartmentDAO departmentDAO;
	private RoleDAO roleDAO;
	private UserDAO userDAO;

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
	//获得当前登录用户所有权限集
	public Set<DataAccessModeModel> getAuthorizations(){
		Set<DataAccessModeModel> dams=new TreeSet<DataAccessModeModel>();
//		UserModel user=userDAO.get("2");
		UserModel user=SecurityUserHolder.getCurrentUser();
		if(user!=null){
			for(RoleModel role:user.getRoles()){
				for(DataAccessModeModel dam:role.getDataAccessModes()){
					if(!dams.contains(dam))
					dams.add(dam);
				}
			}
		}
		
		return  dams;
	}
	//获得当前登录用户某系统权限集
	public SystemModel getAuthorizationMenusBySystem(String systemSymbol){
		SystemModel authSystem=getSystemBySymbol(systemSymbol);
		Set<DataAccessModeModel> dams=getAuthorizations();
		if(authSystem.getDams().size()>0){
			if(dams.containsAll(authSystem.getDams()))
				return authSystem;
			else {
				if(authSystem.getChildren()==null||authSystem.getChildren().size()==0){
					if(authSystem.getMenus()!=null){
						StringBuilder filterMenus=new StringBuilder("");
						for(MenuModel menu:authSystem.getMenus()){
							boolean filter=true;							
							for(DataAccessModeModel dam:menu.getDams()){//用户权限含该菜单部分权限集则不用过滤
								if(dams.contains(dam)){
									filter=false;
									break;
								}
							}
							if(filter==false){
								 filterAuthorization(menu,dams);
								 continue;
							}
							else {
//								if(menu.getParents()==null||menu.getParents().size()==0){
									filterMenus.append(menu.getId()+";");									
//								}else{
//									 filterAuthorization(menu,dams);
//								}
									
							}
							
						}
						for(String filterMenu:filterMenus.toString().split(";")){//移除过滤顶级菜单
							if(filterMenu!=null&&!filterMenu.equals("")){
								authSystem.getMenus().remove(menuDAO.get(filterMenu));
							}
						}
						
					}
				}
				
			}
		}
		return  authSystem;
	}
	private void filterAuthorization(MenuModel authMenu,Set<DataAccessModeModel> dams){
		StringBuilder filterMenus=new StringBuilder("");
		for(MenuModel menu:authMenu.getChildren()){
			if(menu.getChildren()!=null&&menu.getChildren().size()>0){
				for(MenuModel subMenu:menu.getChildren()){
					filterAuthorization(subMenu,dams);
				}
			}
			boolean filter=true;							
			for(DataAccessModeModel dam:menu.getDams()){//用户权限含该菜单部分权限集则不用过滤
				if(dams.contains(dam)){
					filter=false;
					break;
				}
			}
			if(filter==true){
				filterMenus.append(menu.getId()+";");
			}
			
		}
		for(String filterMenu:filterMenus.toString().split(";")){//移除过滤顶级菜单
			if(filterMenu!=null&&!filterMenu.equals("")){
				authMenu.getChildren().remove(menuDAO.get(filterMenu));
			}
		}
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
	//获得所有角色（岗位）
	public List<RoleModel> getAllRoles(){		
		return roleDAO.getAllRoles();
	}
	//获得某角色（岗位）用户
	public Set<UserModel> getRoleUsers(String roleId){	
		RoleModel role=roleDAO.get(roleId);
		return role.getUsers();
	}
	//获得某部门用户
	public Set<UserModel> getDepartmentUsers(String departmentId){	
		DepartmentModel department=departmentDAO.get(departmentId);
		return department.getUsers();
	}
	//获得未授权用户
	public List<UserModel> getUnAuthUsers(){	
		List<UserModel> unAuthUsers=new ArrayList<UserModel>();
		List<UserModel> allUsers=userDAO.getAllUsers();
		for(UserModel user:allUsers){
			if(user.getRoles()==null||user.getRoles().size()==0){
				unAuthUsers.add(user);
			}
		}
		return unAuthUsers;
		
	}
	//获得某用户
	public UserModel getUserByUserAccount(String userAccount){		
		return userDAO.getUserByUserAccount(userAccount);
	}
	//获得所有用户
	public List<UserModel> getAllUsers(){		
		return userDAO.getAllUsers();
	}
	//按条件查询用户
	public List<UserModel> getUsersByCondition(String account,Boolean status){
		System.out.println(status);
		return userDAO.getUsersByCondition(account,status);
	}
	//激活用户
	public UserModel activeUser(String account){
		UserModel user=userDAO.get(account);
		user.setActive(true);
		userDAO.saveOrUpdate(user);
		return user;
	}
	//冻结用户
	public UserModel freezeUser(String account){
		UserModel user=userDAO.get(account);
		user.setActive(false);
		userDAO.saveOrUpdate(user);
		return user;
	}
	//重置用户密码
	public UserModel resetUserPW(String account){
		UserModel user=userDAO.get(account);
		user.setPwd(CipherUtil.encodeByMD5(user.getName()));
		userDAO.saveOrUpdate(user);
		return user;
	}
	//修改个人用户密码【0:失败；1：原密码错误；2：修改成功】
	public int saveUserPW(String oldPW,String newPW){
		UserModel user=SecurityUserHolder.getCurrentUser();
		if(user==null)return 0;
		else{
			if(!user.getPwd().equals(CipherUtil.encodeByMD5(oldPW)))
				return 1;
			else{
				user.setPwd(CipherUtil.encodeByMD5(newPW));
				userDAO.saveOrUpdate(user);
				return 2;
			}
		}
		
	}
	//新增菜单
	public MenuModel menuAdd(MenuModel menu,String parentType,String parentSymbol){
		if(parentType.equals("system")){
			menuDAO.saveOrUpdate(menu);
			SystemModel parentSystem=systemDAO.getSystemBySymbol(parentSymbol);
			parentSystem.getMenus().add(menu);
			systemDAO.saveOrUpdate(parentSystem);
			return menu;
		}else if(parentType.equals("menu")){
			menuDAO.saveOrUpdate(menu);
			MenuModel parentMenu=menuDAO.getMenuBySymbol(parentSymbol);
//			System.out.println(menu);
			parentMenu.getChildren().add(menu);
			menuDAO.merge(parentMenu);
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
			 moduleDAO.saveOrUpdate(module);
			 OperationModel operation=new OperationModel();
			 operation.setName("页面访问");
			 operation.setSymbol(module.getSymbol()+"@defaultVisit@");
			 operation.setRsType("URL");
			 operation.setRsValue("/"+module.getUrl()+"*");
			 operation.setCreationDate(module.getCreationDate());
			 operation.setModifiedDate(module.getModifiedDate());
			 operationDAO.saveOrUpdate(operation);
			 DataAccessModeModel dam=new DataAccessModeModel();
			 dam.setName("全部数据");
			 dam.setSymbol(operation.getSymbol()+"@noFilter@");
			 dam.setCreationDate(operation.getCreationDate());
			 dam.setModifiedDate(operation.getModifiedDate());		
			 dataAccessModeDAO.saveOrUpdate(dam);
			 operation.getDataAccessModes().add(dam);
			 operationDAO.merge(operation);
			 module.getOperations().add(operation);
			 moduleDAO.merge(module);
			MenuModel parentMenu=menuDAO.getMenuBySymbol(parentSymbol);
			parentMenu.getModules().add(module);		 
			
			menuDAO.merge(parentMenu);
			return module;
			
		}else return null;
		
	}
	//更新模块
	public ModuleModel moduleUpdate(ModuleModel module){
		ModuleModel newModule=moduleDAO.get(module.getId());
		newModule.setSymbol(module.getSymbol());
		newModule.setCreationDate(module.getCreationDate());
		newModule.setModifiedDate(new Date());
		newModule.setDetail(module.getDetail());
		newModule.setName(module.getName());
		newModule.setSequence(module.getSequence());
		newModule.setUrl(module.getUrl());
		moduleDAO.saveOrUpdate(newModule);	
		//更新默认访问操作
		 OperationModel operation=operationDAO.getOperationBySymbol(module.getSymbol()+"@defaultVisit@");
		 operation.setSymbol(newModule.getSymbol()+"@defaultVisit@");
		 operation.setRsType("URL");
		 operation.setRsValue("/"+newModule.getUrl()+"*");
		 operation.setModifiedDate(newModule.getModifiedDate());
		 operationDAO.saveOrUpdate(operation);
		//更新默认访问操作默认数据访问方式
		 DataAccessModeModel dam=dataAccessModeDAO.getDataAccessModeBySymbol(module.getSymbol()+"@defaultVisit@"+"@noFilter@");
		 dam.setSymbol(operation.getSymbol()+"@noFilter@");
		 dam.setModifiedDate(operation.getModifiedDate());
		 dataAccessModeDAO.saveOrUpdate(dam);
		return module;		
	}
	//删除模块
	public boolean moduleRemove(String symbol){
//		System.out.println(symbol);
		moduleDAO.removeModuleBySymbol(symbol);
		return true;		
	}
	//新增部门
	public DepartmentModel departmentAdd(DepartmentModel department,String parentDepartmentId,String supervisorName,String leaderRoleIds){
			//父亲部门与新部门的关系保存
			DepartmentModel parentDepartment=departmentDAO.get(parentDepartmentId);
			parentDepartment.getSubordinates().add(department);	
			//新部门主管岗位初始化
			RoleModel supervisorRole=new RoleModel();
			supervisorRole.setSymbol(department.getSymbol()+"_supervisor");
			supervisorRole.setCreationDate(department.getCreationDate());
			supervisorRole.setName(supervisorName);
			supervisorRole.setModifiedDate(new Date());
			supervisorRole.setSupervisorFlag(true);
			department.getRoles().add(supervisorRole);
			departmentDAO.saveOrUpdate(parentDepartment);
			//新部门直属领导保存
			String[] ids=leaderRoleIds.split(";");
			for(String leaderRoleId:ids){
				RoleModel leaderRole=roleDAO.get(leaderRoleId);
				leaderRole.getLeadingDepartments().add(department);
				roleDAO.saveOrUpdate(leaderRole);
			}
			
			return department;
		
	}
	//更新部门
	public DepartmentModel departmentUpdate(DepartmentModel department,String supervisorName,String leaderRoleIds){
		//更新部门信息
		DepartmentModel newDepartment=departmentDAO.get(department.getId());
		newDepartment.setSymbol(department.getSymbol());
		newDepartment.setCreationDate(department.getCreationDate());
		newDepartment.setModifiedDate(new Date());
		newDepartment.setDetail(department.getDetail());
		newDepartment.setName(department.getName());
		newDepartment.setSequence(department.getSequence());
		departmentDAO.saveOrUpdate(newDepartment);
		//更新部门主管信息
		RoleModel role=newDepartment.getSupervisorRole();
		role.setSymbol(department.getSymbol()+"_supervisor");
		role.setName(supervisorName);
		role.setModifiedDate(new Date());
		roleDAO.saveOrUpdate(role);
		//更新部门直属领导
		for(RoleModel preLeaderRole:newDepartment.getLeaderRoles()){
			preLeaderRole.getLeadingDepartments().remove(newDepartment);
			roleDAO.saveOrUpdate(preLeaderRole);
		}
		String[] ids=leaderRoleIds.split(";");	
		for(String leaderRoleId:ids){
			RoleModel leaderRole=roleDAO.get(leaderRoleId);
			leaderRole.getLeadingDepartments().add(newDepartment);
			roleDAO.saveOrUpdate(leaderRole);
		}
	
		return newDepartment;
	}
	//删除部门
	public boolean departmentRemove(String id){
		departmentDAO.remove(departmentDAO.get(id));
		return true;		
	}
	//新增岗位
	public RoleModel roleAdd(RoleModel role,String parentId,String userIds){
			roleDAO.saveOrUpdate(role);
			RoleModel parentRole=roleDAO.get(parentId);
			parentRole.getSubordinates().add(role);	
			roleDAO.saveOrUpdate(parentRole);
			if(!StringUtils.isEmpty(userIds))
				for(String userId:userIds.split(";")){
					UserModel user=userDAO.get(userId);
					role.getUsers().add(user);
					
				}
			roleDAO.saveOrUpdate(role);
			return role;
		
	}
	//更新岗位
	public RoleModel roleUpdate(RoleModel role,String userIds){
		RoleModel newRole=roleDAO.get(role.getId());
		newRole.setSymbol(role.getSymbol());
		newRole.setCreationDate(role.getCreationDate());
		newRole.setModifiedDate(new Date());
		newRole.setLevel(role.getLevel());
		newRole.setDetail(role.getDetail());
		newRole.setName(role.getName());
		newRole.setSequence(role.getSequence());
		for(UserModel preUser:role.getUsers()){
			newRole.getUsers().remove(preUser);
		}
		if(!StringUtils.isEmpty(userIds))
		for(String userId:userIds.split(";")){
			UserModel user=userDAO.get(userId);
			newRole.getUsers().add(user);
			
		}
		roleDAO.saveOrUpdate(newRole);
		return newRole;
	}
	//删除岗位
	public boolean roleRemove(String id){
		roleDAO.remove(roleDAO.get(id));
		return true;		
	}
	/*获得部门各系统权限集*/
	public String getDepartmentSystemAuthorization(String departmentId,String systemId){
		System.out.println(departmentId+"--"+systemId);
		StringBuilder sb=new StringBuilder();
		SystemModel system=systemDAO.get(systemId);
		DepartmentModel department=departmentDAO.get(departmentId);
		Set<DataAccessModeModel> dams=department.getDataAccessModes();
		int state=0;
		if(system.getDams().size()>0){
			if(dams.containsAll(system.getDams()))state=1;
			else {
				for(DataAccessModeModel dam:system.getDams()){
					if(dams.contains(dam)){
						state=2;break;
					}
				}
			}
		}
		
		sb.append("<node state='"+state+"' type='system' label='"+system.getName()+"'>");
		if(system.getMenus()!=null)
			for(MenuModel menu:system.getMenus()){
				buildMenu(menu,sb,dams);
			}
		sb.append("</node>");
		return sb.toString();	
	}
	private void buildMenu(MenuModel menu,StringBuilder sb,Set<DataAccessModeModel> dams){
		if(menu!=null){
			int state=0;
			if(menu.getDams().size()>0){
				if(dams.containsAll(menu.getDams()))state=1;
				else {
					for(DataAccessModeModel dam:menu.getDams()){
						if(dams.contains(dam)){
							state=2;break;
						}
					}
				}
			}
			sb.append("<node state='"+state+"' type='menu' label='"+menu.getName()+"'>");
			if(menu.getChildren()!=null&&menu.getChildren().size()>0){
				for(MenuModel subMenu:menu.getChildren()){
					buildMenu(subMenu,sb,dams);
				}

			}else{
				if(menu.getModules()!=null)
					for(ModuleModel module:menu.getModules()){
						buildModule(module,sb,dams);
					}
			}
			sb.append("</node>");
		}
		
	}
	private void buildModule(ModuleModel module,StringBuilder sb,Set<DataAccessModeModel> dams){
		if(module!=null){	
			for(OperationModel operation:module.getOperations()){
				buildOperation(operation,sb,dams);
			}
		}
		
	}
	private void buildOperation(OperationModel operation,StringBuilder sb,Set<DataAccessModeModel> dams){
		if(operation!=null){
			int state=0;
			if(operation.getDataAccessModes().size()>0){
				if(dams.containsAll(operation.getDataAccessModes()))state=1;
				else {
					for(DataAccessModeModel dam:operation.getDataAccessModes()){
						if(dams.contains(dam)){
							state=2;break;
						}
					}
				}
			}
			sb.append("<node  state='"+state+"' type='operation' label='"+operation.getName()+"'>");
			if(operation.getDataAccessModes()!=null&&operation.getDataAccessModes().size()>0)
				for(DataAccessModeModel dam:operation.getDataAccessModes()){
					buildDAM(dam, sb,dams);
				}
			sb.append("</node>");
		}	
	}
	private void buildDAM(DataAccessModeModel dam,StringBuilder sb,Set<DataAccessModeModel> dams){
		if(dam!=null){
			int state=0;
			if(dams.contains(dam))state=1;
			sb.append("<node  state='"+state+"' type='dam' id='"+dam.getId()+"' label='"+dam.getName()+"'>");
			sb.append("</node>");
		}	
	}
	/*获得部门各系统权限集*/
	
	/*保存部门系统权限集*/
	public boolean saveDepartmentSystemAuthorization(String departmentId,String systemId,String adds,String removes){
		System.out.println(adds);
		System.out.println(removes);
		DepartmentModel department=departmentDAO.get(departmentId);
		Set<DataAccessModeModel> dams=department.getDataAccessModes();
		for(String add:adds.split(";")){
			if(add!=null&&!add.equals("")){
				DataAccessModeModel dam=dataAccessModeDAO.get(add);
				if(!dams.contains(dam))
					dams.add(dam);
			}
			
		}
		for(String remove:removes.split(";")){
			if(remove!=null&&!remove.equals("")){
				DataAccessModeModel dam=dataAccessModeDAO.get(remove);
				if(dams.contains(dam))
					dams.remove(dam);
			}
		}
		departmentDAO.merge(department);
		return true;
	}
	/*获得角色（岗位）各系统权限集*/
	public String getRoleSystemAuthorization(String roleId,String systemId){
		System.out.println(roleId+"--"+systemId);
		StringBuilder sb=new StringBuilder();
		SystemModel system=systemDAO.get(systemId);
		RoleModel role=roleDAO.get(roleId);
		Set<DataAccessModeModel> dams=role.getDataAccessModes();
		int state=0;
		if(system.getDams().size()>0){
			if(dams.containsAll(system.getDams()))state=1;
			else {
				for(DataAccessModeModel dam:system.getDams()){
					if(dams.contains(dam)){
						state=2;break;
					}
				}
			}
		}
		
		sb.append("<node state='"+state+"' type='system' label='"+system.getName()+"'>");
		if(system.getMenus()!=null)
			for(MenuModel menu:system.getMenus()){
				buildMenu(menu,sb,dams);
			}
		sb.append("</node>");
		return sb.toString();	
	}
	
	/*保存角色系统权限集*/
	public boolean saveRoleSystemAuthorization(String roleId,String systemId,String adds,String removes){
		System.out.println(adds);
		System.out.println(removes);
		RoleModel role=roleDAO.get(roleId);
		Set<DataAccessModeModel> dams=role.getDataAccessModes();
		for(String add:adds.split(";")){
			if(add!=null&&!add.equals("")){
				DataAccessModeModel dam=dataAccessModeDAO.get(add);
				if(!dams.contains(dam))
					dams.add(dam);
			}
			
		}
		for(String remove:removes.split(";")){
			if(remove!=null&&!remove.equals("")){
				DataAccessModeModel dam=dataAccessModeDAO.get(remove);
				if(dams.contains(dam))
					dams.remove(dam);
			}
		}
		roleDAO.merge(role);
		

		return true;
	}
	
	
	
	public static void main(String[] args) {
		 ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"system/service/system.xml","system/service/spring-system.xml"});	 
		 SystemService systemService=(SystemService)applicationContext.getBean("systemService");
		 System.out.println(systemService.getAuthorizationMenusBySystem("oa"));
//		 System.out.println(systemService.getDepartmentSystemAuthorization("3","2"));
//		 systemService.saveDepartmentSystemAuthorization("1","3",";14;",";3;");
//		Set<DataAccessModeModel> dams= systemService.getDepartmentById("1").getDataAccessModes();
//		DataAccessModeModel dam=systemService.dataAccessModeDAO.get("14");
//		systemService.dataAccessModeDAO.merge(dam);
//		System.out.println(dams.contains(dam));
//		 List<ModuleModel> list=systemService.getModuleDAO().getAllModules();
//		 System.out.println(list.size());
//		 for(ModuleModel module:list){
//			 OperationModel operation=new OperationModel();
//			 operation.setName("默认模块访问");
//			 operation.setSymbol(module.getSymbol()+"@defaultVisit@");
//			 operation.setRsType("URL");
//			 operation.setRsValue("/"+module.getUrl()+"*");
//			 operation.setCreationDate(module.getCreationDate());
//			 operation.setModifiedDate(module.getModifiedDate());
//			 DataAccessModeModel dam=new DataAccessModeModel();
//			 dam.setName("默认数据访问");
//			 dam.setSymbol(operation.getSymbol()+"@noFilter@");
//			 dam.setCreationDate(operation.getCreationDate());
//			 dam.setModifiedDate(operation.getModifiedDate());
//			 operation.getDataAccessModes().add(dam);
//			 module.getOperations().add(operation);
//			 
//			 systemService.getModuleDAO().saveOrUpdate(module);
//		 }
		 
//		ModuleModel module=new ModuleModel();
//		module.setName("a");
//		module.setCreationDate(new Date());
//		module.setDetail("aaa");
//		module.setSymbol("rg22222");
//		module.setSequence(1);
//		systemService.moduleAdd(module,"menu","gweg");
	}
	
}