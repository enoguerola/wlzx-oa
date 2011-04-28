/**
 * 
 */
package system.service;

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

public class InitService {
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
	
	public static void main(String[] args) {
		 ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"system/service/system.xml","system/service/spring-system.xml"});
		// TODO Auto-generated method stub
		InitService initService=(InitService)applicationContext.getBean("initService");
		initService.initSystem();
		initService.printSystemStructure();
		initService.initDepartment();
		initService.printDepartmentStructure();
//		System.out.println(initService.getModuleDAO().getModuleBySymbol("basic_authorization_department_main").getOperations().size());

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
		//初始化基础数据系统
		SystemModel basic=systemDAO.getSystemBySymbol("basic");
		if(basic==null){
			basic=new SystemModel();
			basic.setSymbol("basic");
			basic.setCreationDate(new Date());
			basic.setName("基础数据系统");
			basic.setDetail("基础数据系统是数字化校园所有业务应用系统的公共数据库，处于中心位置，基础数据库保持最完整、最准确的数据，提供其他业务系统使用。基础数据库管理系统实现对基础数据库所有信息库的维护管理。");
			basic.setIndexPath("basic/index.swf");
			basic.setModifiedDate(new Date());
			/*
			 * 基础数据系统菜单初始化开始
			 *
			 * */
				//基础数据
				MenuModel basicData=menuDAO.getMenuBySymbol("basic_data");
				if(basicData==null){
					basicData=new MenuModel();
					basicData.setSymbol("basic_data");
					basicData.setName("基础数据");
					basicData.setCreationDate(new Date());
					basicData.setModifiedDate(new Date());
					//员工基础数据
					MenuModel staffBasicData=menuDAO.getMenuBySymbol("basic_data_staff");
					if(staffBasicData==null){
						staffBasicData=new MenuModel();
						staffBasicData.setSymbol("basic_data_staff");
						staffBasicData.setName("员工基础数据");
						staffBasicData.setCreationDate(new Date());
						staffBasicData.setModifiedDate(new Date());		
						basicData.getChildren().add(staffBasicData);
					}else{
						
					}
					basic.getMenus().add(basicData);
					
				}else{
					
				}		
				
				
				//系统授权
				MenuModel basicAuthorization=menuDAO.getMenuBySymbol("basic_authorization");
				if(basicAuthorization==null){
					basicAuthorization=new MenuModel();
					basicAuthorization.setSymbol("basic_authorization");
					basicAuthorization.setName("系统授权");
					basicAuthorization.setCreationDate(new Date());
					basicAuthorization.setModifiedDate(new Date());
					basic.getMenus().add(basicAuthorization);
					//部门授权
					MenuModel departmentAuthorization=menuDAO.getMenuBySymbol("basic_authorization_department");
					if(departmentAuthorization==null){
						departmentAuthorization=new MenuModel();
						departmentAuthorization.setSymbol("basic_authorization_department");
						departmentAuthorization.setName("部门授权");
						departmentAuthorization.setCreationDate(new Date());
						departmentAuthorization.setModifiedDate(new Date());		
						basicAuthorization.getChildren().add(departmentAuthorization);
						//部门授权主模块
						ModuleModel departmentAuthorizationMainModule=moduleDAO.getModuleBySymbol("basic_authorization_department_main");
						if(departmentAuthorizationMainModule==null){
							departmentAuthorizationMainModule=new ModuleModel();
							departmentAuthorizationMainModule.setSymbol("basic_authorization_department_main");
							departmentAuthorizationMainModule.setName("部门授权主模块");
							departmentAuthorizationMainModule.setCreationDate(new Date());
							departmentAuthorizationMainModule.setModifiedDate(new Date());
							departmentAuthorizationMainModule.setUrl("basic/authorization/departmentAuthorization.swf");
							departmentAuthorization.getModules().add(departmentAuthorizationMainModule);
							//部门授权主模块查询操作
							OperationModel departmentAuthorizationMainModuleSearch=operationDAO.getOperationBySymbol("basic_authorization_department_main_search");
							if(departmentAuthorizationMainModuleSearch==null){
								departmentAuthorizationMainModuleSearch=new OperationModel();
								departmentAuthorizationMainModuleSearch.setName("查询");
								departmentAuthorizationMainModuleSearch.setUrl("");
								departmentAuthorizationMainModuleSearch.setSymbol("basic_authorization_department_main_search");
								departmentAuthorizationMainModuleSearch.setCreationDate(new Date());
								departmentAuthorizationMainModuleSearch.setModifiedDate(new Date());
								departmentAuthorizationMainModule.getOperations().add(departmentAuthorizationMainModuleSearch);
								//部门授权主模块查询操作数据访问控制
								DataAccessModeModel departmentAuthorizationMainModuleSearchDataDefaultFilter=dataAccessModeDAO.getDataAccessModeBySymbol("basic_authorization_department_main_search_deafultFilter");
								if(departmentAuthorizationMainModuleSearchDataDefaultFilter==null){
									departmentAuthorizationMainModuleSearchDataDefaultFilter=new DataAccessModeModel();
									departmentAuthorizationMainModuleSearchDataDefaultFilter.setName("全部");
									departmentAuthorizationMainModuleSearchDataDefaultFilter.setValue("NULL");//空过滤类
									departmentAuthorizationMainModuleSearchDataDefaultFilter.setSymbol("basic_authorization_department_main_search_deafultFilter");
									departmentAuthorizationMainModuleSearchDataDefaultFilter.setCreationDate(new Date());
									departmentAuthorizationMainModuleSearchDataDefaultFilter.setModifiedDate(new Date());
									departmentAuthorizationMainModuleSearch.getDataAccessModes().add(departmentAuthorizationMainModuleSearchDataDefaultFilter);
								}else{
										
								}
							}else {
								
							}
							
							//部门授权主模块编辑保存操作
							OperationModel departmentAuthorizationMainModuleEdit=operationDAO.getOperationBySymbol("basic_authorization_department_main_edit");
							if(departmentAuthorizationMainModuleEdit==null){
								departmentAuthorizationMainModuleEdit=new OperationModel();
								departmentAuthorizationMainModuleEdit.setName("编辑");
								departmentAuthorizationMainModuleEdit.setUrl("");
								departmentAuthorizationMainModuleEdit.setSymbol("basic_authorization_department_main_edit");
								departmentAuthorizationMainModuleEdit.setCreationDate(new Date());
								departmentAuthorizationMainModuleEdit.setModifiedDate(new Date());
								departmentAuthorizationMainModuleEdit.setUrl("");
								departmentAuthorizationMainModule.getOperations().add(departmentAuthorizationMainModuleEdit);
								//部门授权主模块编辑操作数据访问控制
								DataAccessModeModel departmentAuthorizationMainModuleEditDataDefaultFilter=dataAccessModeDAO.getDataAccessModeBySymbol("basic_authorization_department_main_edit_deafultFilter");
								if(departmentAuthorizationMainModuleEditDataDefaultFilter==null){
									departmentAuthorizationMainModuleEditDataDefaultFilter=new DataAccessModeModel();
									departmentAuthorizationMainModuleEditDataDefaultFilter.setName("全部");
									departmentAuthorizationMainModuleEditDataDefaultFilter.setValue("NULL");//空过滤类
									departmentAuthorizationMainModuleEditDataDefaultFilter.setSymbol("basic_authorization_department_main_edit_deafultFilter");
									departmentAuthorizationMainModuleEditDataDefaultFilter.setCreationDate(new Date());
									departmentAuthorizationMainModuleEditDataDefaultFilter.setModifiedDate(new Date());
									departmentAuthorizationMainModuleEdit.getDataAccessModes().add(departmentAuthorizationMainModuleEditDataDefaultFilter);
								}else{
									
								}
							}else {
								
							}
							
							
						}else{
							
						}
					}else{
						
					}
					//部门角色授权
					MenuModel roleAuthorization=menuDAO.getMenuBySymbol("basic_authorization_role");
					if(roleAuthorization==null){
						roleAuthorization=new MenuModel();
						roleAuthorization.setSymbol("basic_authorization_role");
						roleAuthorization.setName("岗位授权");
						roleAuthorization.setCreationDate(new Date());
						roleAuthorization.setModifiedDate(new Date());		
						basicAuthorization.getChildren().add(roleAuthorization);
						//部门角色授权主模块
						ModuleModel roleAuthorizationMainModule=moduleDAO.getModuleBySymbol("basic_authorization_role_main");
						if(roleAuthorizationMainModule==null){
							roleAuthorizationMainModule=new ModuleModel();
							roleAuthorizationMainModule.setSymbol("basic_authorization_role_main");
							roleAuthorizationMainModule.setName("岗位授权主模块");
							roleAuthorizationMainModule.setCreationDate(new Date());
							roleAuthorizationMainModule.setModifiedDate(new Date());
							roleAuthorizationMainModule.setUrl("basic/authorization/roleAuthorization.swf");
							roleAuthorization.getModules().add(roleAuthorizationMainModule);
						}else{
							
						}
					}else{
						
					}
				}else{
				
				}		
						
				
				//系统设置
				MenuModel basicSetting=menuDAO.getMenuBySymbol("basic_setting");
				if(basicSetting==null){
					basicSetting=new MenuModel();
					basicSetting.setSymbol("basic_setting");
					basicSetting.setName("系统设置");
					basicSetting.setCreationDate(new Date());
					basicSetting.setModifiedDate(new Date());
					basic.getMenus().add(basicSetting);	
					//部门设置
					MenuModel departmentSetting=menuDAO.getMenuBySymbol("basic_setting_department");
					if(departmentSetting==null){
						departmentSetting=new MenuModel();
						departmentSetting.setSymbol("basic_setting_department");
						departmentSetting.setName("部门设置");
						departmentSetting.setCreationDate(new Date());
						departmentSetting.setModifiedDate(new Date());		
						basicSetting.getChildren().add(departmentSetting);
						//部门设置主模块
						ModuleModel departmentSettingMainModule=moduleDAO.getModuleBySymbol("basic_setting_department_main");
						if(departmentSettingMainModule==null){
							departmentSettingMainModule=new ModuleModel();
							departmentSettingMainModule.setSymbol("basic_setting_department_main");
							departmentSettingMainModule.setName("部门设置主模块");
							departmentSettingMainModule.setCreationDate(new Date());
							departmentSettingMainModule.setModifiedDate(new Date());
							departmentSettingMainModule.setUrl("basic/setting/departmentSetting.swf");
							departmentSetting.getModules().add(departmentSettingMainModule);

						}else{
							
						}
					}else{
						
					}
					//岗位设置
					MenuModel roleSetting=menuDAO.getMenuBySymbol("basic_setting_role");
					if(roleSetting==null){
						roleSetting=new MenuModel();
						roleSetting.setSymbol("basic_setting_role");
						roleSetting.setName("岗位设置");
						roleSetting.setCreationDate(new Date());
						roleSetting.setModifiedDate(new Date());		
						basicSetting.getChildren().add(roleSetting);
						//岗位设置主模块
						ModuleModel roleSettingMainModule=moduleDAO.getModuleBySymbol("basic_setting_role_main");
						if(roleSettingMainModule==null){
							roleSettingMainModule=new ModuleModel();
							roleSettingMainModule.setSymbol("basic_setting_role_main");
							roleSettingMainModule.setName("岗位设置主模块");
							roleSettingMainModule.setCreationDate(new Date());
							roleSettingMainModule.setModifiedDate(new Date());
							roleSettingMainModule.setUrl("basic/setting/roleSetting.swf");
							roleSetting.getModules().add(roleSettingMainModule);

						}else{
							
						}
						
					}else{
						
					}
				}else{
					
				}		
			/*
			 * 基础数据系统菜单初始化结束
			 *
			 * */
			root.getChildren().add(basic);
		}else{
			
		}
		
		//初始化OA系统		
		SystemModel oa=systemDAO.getSystemBySymbol("oa");
		if(oa==null){
			oa=new SystemModel();
			oa.setSymbol("oa");
			oa.setCreationDate(new Date());
			oa.setName("办公自动化系统");
			oa.setDetail("办公自动化系统以公文流转为核心，实现办公流程的快速高效；同时提供多种部门间的信息交流的手段和渠道，加强部门间的沟通协作；提供信息共享的平台，实现公共资源的共享；提供辅助办公功能，为每一项业务提供相关信息，促进学校办公的成熟和规范化；提供强大的搜索查询功能，便于用户在日积月累的海量信息中快速的查找需要的内容");
			oa.setModifiedDate(new Date());
			oa.setIndexPath("oa/index.swf");

			//公共事务管理
			MenuModel publicAffair=menuDAO.getMenuBySymbol("oa_public_affair");
			if(publicAffair==null){
				publicAffair=new MenuModel();
				publicAffair.setSymbol("oa_public_affair");
				publicAffair.setName("公共事务管理");
				publicAffair.setCreationDate(new Date());
				publicAffair.setModifiedDate(new Date());
				//公告管理
				MenuModel noticeManage=menuDAO.getMenuBySymbol("notice_manage");
				if(noticeManage==null){
					noticeManage=new MenuModel();
					noticeManage.setSymbol("notice_manage");
					noticeManage.setName("公告管理");
					noticeManage.setCreationDate(new Date());
					noticeManage.setModifiedDate(new Date());		
					publicAffair.getChildren().add(noticeManage);
					MenuModel noticePost=menuDAO.getMenuBySymbol("notice_post");
					if(noticePost==null){
						noticePost=new MenuModel();
						noticePost.setSymbol("notice_post");
						noticePost.setName("公告发布");
						noticePost.setCreationDate(new Date());
						noticePost.setModifiedDate(new Date());		
						noticeManage.getChildren().add(noticePost);
					}else{
						
					}
					MenuModel noticeList=menuDAO.getMenuBySymbol("notice_list");
					if(noticeList==null){
						noticeList=new MenuModel();
						noticeList.setSymbol("notice_list");
						noticeList.setName("公告管理");
						noticeList.setCreationDate(new Date());
						noticeList.setModifiedDate(new Date());		
						noticeManage.getChildren().add(noticeList);
					}else{
						
					}
					MenuModel noticeSign=menuDAO.getMenuBySymbol("notice_sign");
					if(noticeSign==null){
						noticeSign=new MenuModel();
						noticeSign.setSymbol("notice_sign");
						noticeSign.setName("公告签批");
						noticeSign.setCreationDate(new Date());
						noticeSign.setModifiedDate(new Date());		
						noticeManage.getChildren().add(noticeSign);
					}else{
						
					}
				}else{
					
				}
				//日程管理
				MenuModel scheduleManage=menuDAO.getMenuBySymbol("schedule_manage");
				if(scheduleManage==null){
					scheduleManage=new MenuModel();
					scheduleManage.setSymbol("scheduleManage");
					scheduleManage.setName("日程管理");
					scheduleManage.setCreationDate(new Date());
					scheduleManage.setModifiedDate(new Date());		
					publicAffair.getChildren().add(scheduleManage);
//					MenuModel noticePost=menuDAO.getMenuBySymbol("notice_post");
//					if(noticePost==null){
//						noticePost=new MenuModel();
//						noticePost.setSymbol("notice_post");
//						noticePost.setName("公告发布");
//						noticePost.setCreationDate(new Date());
//						noticePost.setModifiedDate(new Date());		
//						publicAffair.getChildren().add(noticePost);
//					}else{
//						
//					}
//					MenuModel noticeList=menuDAO.getMenuBySymbol("notice_list");
//					if(noticeList==null){
//						noticeList=new MenuModel();
//						noticeList.setSymbol("notice_list");
//						noticeList.setName("公告管理");
//						noticeList.setCreationDate(new Date());
//						noticeList.setModifiedDate(new Date());		
//						publicAffair.getChildren().add(noticeList);
//					}else{
//						
//					}
//					MenuModel noticeSign=menuDAO.getMenuBySymbol("notice_sign");
//					if(noticeSign==null){
//						noticeSign=new MenuModel();
//						noticeSign.setSymbol("notice_sign");
//						noticeSign.setName("公告签批");
//						noticeSign.setCreationDate(new Date());
//						noticeSign.setModifiedDate(new Date());		
//						publicAffair.getChildren().add(noticeSign);
//					}else{
//						
//					}
				}else{
					
				}
				oa.getMenus().add(publicAffair);
				
			}else{
				
			}
			//内部事务管理
			MenuModel insideAffair=menuDAO.getMenuBySymbol("oa_inside_affair");
			if(insideAffair==null){
				insideAffair=new MenuModel();
				insideAffair.setSymbol("oa_inside_affair");
				insideAffair.setName("内部事务管理");
				insideAffair.setCreationDate(new Date());
				insideAffair.setModifiedDate(new Date());
				
				oa.getMenus().add(insideAffair);
				
			}else{
				
			}
			//公文管理
			MenuModel officialDocument=menuDAO.getMenuBySymbol("oa_official_document");
			if(officialDocument==null){
				officialDocument=new MenuModel();
				officialDocument.setSymbol("oa_official_document");
				officialDocument.setName("公文管理");
				officialDocument.setCreationDate(new Date());
				officialDocument.setModifiedDate(new Date());
				
				oa.getMenus().add(officialDocument);
				
			}else{
				
			}
			//学校管理
			MenuModel schoolAffair=menuDAO.getMenuBySymbol("oa_school_affair");
			if(schoolAffair==null){
				schoolAffair=new MenuModel();
				schoolAffair.setSymbol("oa_school_affair");
				schoolAffair.setName("学校管理");
				schoolAffair.setCreationDate(new Date());
				schoolAffair.setModifiedDate(new Date());
				oa.getMenus().add(schoolAffair);
				
			}else{
				
			}
			//系统管理
			MenuModel systemManage=menuDAO.getMenuBySymbol("oa_system_management");
			if(systemManage==null){
				systemManage=new MenuModel();
				systemManage.setSymbol("oa_system_management");
				systemManage.setName("系统管理");
				systemManage.setCreationDate(new Date());
				systemManage.setModifiedDate(new Date());
				
				oa.getMenus().add(systemManage);
				
			}else{
				
			}	
			root.getChildren().add(oa);
		
		}else{
			
		}
		
		systemDAO.saveOrUpdate(root);
		//补充完善菜单1
		MenuModel departmentRole=menuDAO.getMenuBySymbol("oa_school_affair_department_role");
		if(departmentRole==null){
			departmentRole=new MenuModel();
			departmentRole.setSymbol("oa_school_affair_department_role");
			departmentRole.setName("部门与岗位");
			departmentRole.setCreationDate(new Date());
			departmentRole.setModifiedDate(new Date());
			MenuModel schoolAffair=menuDAO.getMenuBySymbol("oa_school_affair");
			schoolAffair.getChildren().add(departmentRole);
			menuDAO.saveOrUpdate(schoolAffair);
		}
		MenuModel departmentAuthorization=menuDAO.getMenuBySymbol("basic_authorization_department");
		departmentRole.getChildren().add(departmentAuthorization);
		MenuModel roleAuthorization=menuDAO.getMenuBySymbol("basic_authorization_role");
		departmentRole.getChildren().add(roleAuthorization);
		MenuModel roleSetting=menuDAO.getMenuBySymbol("basic_setting_role");
		departmentRole.getChildren().add(roleSetting);
		MenuModel departmentSetting=menuDAO.getMenuBySymbol("basic_setting_department");
		departmentRole.getChildren().add(departmentSetting);
		menuDAO.merge(departmentRole);
		
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
}
