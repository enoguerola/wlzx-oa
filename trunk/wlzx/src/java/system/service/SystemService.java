/**
 * 
 */
package system.service;



import java.util.List;
import java.util.Set;

import system.PaginationSupport;
import system.entity.*;

import system.vo.MessageVO;



  
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

public interface SystemService{
	

	//获得当前登录用户所有权限集
	public Set<DataAccessModeModel> fetchAuthorizations();
	//获得当前登录用户某系统权限集
	public SystemModel fetchAuthorizationMenusBySystem(String systemSymbol);
	
	//获得某系统
	public SystemModel getSystemBySymbol(String symbol);
	//获得某菜单
	public MenuModel getMenuBySymbol(String symbol);
	//获得某模块
	public ModuleModel getModuleBySymbol(String symbol);
	//获得某部门
	public DepartmentModel getDepartmentBySymbol(String symbol);
	//获得某部门
	public DepartmentModel getDepartmentById(String departmentId);
	//获得某角色（岗位）
	public RoleModel getRoleById(String roleId);
	//获得某角色（岗位）
	public RoleModel getRoleBySymbol(String symbol);
	//获得所有角色（岗位）
	public List<RoleModel> getAllRoles();
	//获得某角色（岗位）用户
	public Set<UserModel> getRoleUsers(String roleId);
	//获得所有部门
	public List<DepartmentModel> getAllDepartments();
	//获得某部门用户
	public Set<UserModel> getDepartmentUsers(String departmentId);
	//获得某部门角色（岗位）用户
	public Set<UserModel> getDRUsers(String departmentId,String roleId);
	//获得未授权用户
	public List<UserModel> getUnAuthUsers();
	//获得某用户
	public UserModel getUserByUserAccount(String userAccount);
	//获得某用户
	public UserModel getUserByUserId(String userId);
	//获得所有用户
	public List<UserModel> getAllUsers();
	//按条件查询用户
	public List<UserModel> getUsersByCondition(String account,Boolean status);
	public PaginationSupport<UserModel> getUsersByCondition(String account,Boolean status, int index,int pageSize);
	//激活用户
	public UserModel activeUser(String account);
	//冻结用户
	public UserModel freezeUser(String account);
	//重置用户密码
	public UserModel resetUserPW(String account);
	//修改个人用户密码【0:失败；1：原密码错误；2：修改成功】
	public int saveUserPW(String oldPW,String newPW);
	//新增菜单
	public MenuModel menuAdd(MenuModel menu,String parentType,String parentSymbol);
	//更新菜单
	public MenuModel menuUpdate(MenuModel menu);
	//删除菜单
	public boolean menuRemove(String symbol);
	//新增模块
	public ModuleModel moduleAdd(ModuleModel module,String parentType,String parentSymbol);
	//更新模块
	public ModuleModel moduleUpdate(ModuleModel module);
	//删除模块
	public boolean moduleRemove(String symbol);
	//新增操作
	public OperationModel operationAdd(OperationModel operation,String parentType,String parentSymbol);
	//更新操作
	public OperationModel operationUpdate(OperationModel operation);
	//删除操作
	public boolean operationRemove(String symbol);
	//获得操作
	public OperationModel getOperationBySymbol(String symbol);
	//新增数据访问方式
	public DataAccessModeModel dataAccessModeAdd(DataAccessModeModel dataAccessMode,String parentType,String parentSymbol);
	//更新数据访问方式
	public DataAccessModeModel dataAccessModeUpdate(DataAccessModeModel dataAccessMode);
	//删除数据访问方式
	public boolean dataAccessModeRemove(String symbol);
	//获得数据访问方式
	public DataAccessModeModel getDataAccessModeBySymbol(String symbol);
	//新增部门
	public DepartmentModel departmentAdd(DepartmentModel department,String parentDepartmentId,String masterUserIds,String leaderUserIds);
	//获得部门岗位
	//public List<RoleModel> getDepartmentRoles(String departmentId);
	
	
	
	//更新部门
	public DepartmentModel departmentUpdate(DepartmentModel department,String masterUserIds,String leaderUserIds);
	//删除部门
	public boolean departmentRemove(String id);
	//新增岗位
	public RoleModel roleAdd(RoleModel role);
	//更新岗位
	public RoleModel roleUpdate(RoleModel role);
	//删除岗位
	public boolean roleRemove(String id);
	/*获得部门各系统权限集*/
	//public String getDepartmentSystemAuthorization(String departmentId,String systemId);
	
	/*获得部门各系统权限集*/
	
	/*保存部门系统权限集*/
	//public boolean saveDepartmentSystemAuthorization(String departmentId,String systemId,String adds,String removes);
	/*获得部门角色（岗位）各系统权限集*/
	public String getRoleSystemAuthorization(String departmentId,String roleId,String systemId);
	/*保存部门角色系统权限集*/
	public boolean saveRoleSystemAuthorization(String departmentId,String roleId,String systemId,String adds,String removes);
	//获得自身接受未读消息
	public List<MessageVO> getSelfReceivedNotReadMessages(String beginDate,String endDate);
	
	
	
	//获得自身接受已读消息
	public List<MessageVO> getSelfReceivedAlreadyReadMessages(String beginDate,String endDate);
	//获得自身所有发送消息
	public List<MessageVO> getSelfPostedMessages(String beginDate,String endDate);
	//获得消息
	public MessageModel getMessage(String id);
	//发送消息
	public boolean sendMessage(String fromId,String toIds,int type,String content);
	//发送消息2
	public boolean sendMessage(String fromId,String toIds,int type,String content,String linkObject,String linkObjectId);
	//删除消息
	public boolean deleteMessage(String id);
	//伪删除消息
	public boolean deletePostMessage(String id);
	//伪删除消息
	public boolean deleteReceiveMessage(String id,String userId);
	
	//标记消息为已读
	public boolean readMessage(String id,String userId);
	public String getWorkersIds(Integer type);
	

	
}
