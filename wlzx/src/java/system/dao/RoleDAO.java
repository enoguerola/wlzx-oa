/**
 * 
 */
package system.dao;

import java.util.Set;

import system.BaseDAOImpl;
import system.entity.DataAccessModeModel;
import system.entity.DepartmentModel;
import system.entity.RoleModel;
import system.entity.UserModel;



  
  /**
 *
 * 类名称：RoleDAO
 * 类描述：
 * 创建人：wuyuyue
 * 创建时间：2011-4-14 下午11:21:04
 * 修改人：wuyuyue
 * 修改时间：2011-4-14 下午11:21:04
 * 修改备注：
 * @version
 *
 */

public class RoleDAO extends BaseDAOImpl<RoleModel> {
	/** 
     * 获取某角色用户集
     * @param role 
     * @return Set<UserModel> 
     * @创建时间 2011-4-15 上午10:41:15
     */ 
	public Set<UserModel> getAllUsers(RoleModel role){
		return null;
	}
	/** 
     * 获取角色数据访问权限集合
     * @param role 
     * @return Set<DataAccessModeMetaModel> 
     * @创建时间 2011-4-15 上午10:41:15
     */ 
	public Set<DataAccessModeModel> getRoleDataAccessModes(RoleModel role){
		return null;
	}
	/** 
     * 获取角色所在部门
     * @param role 
     * @return DepartmentModel
     * @创建时间 2011-4-15 上午10:41:15
     */ 
	public DepartmentModel getBelongDepartment(RoleModel role){
		return null;
	}
	/** 
     * 获取角色直属领导角色集
     * @param role 
     * @return Set<RoleModel> 
     * @创建时间 2011-4-15 上午10:41:15
     */ 
	public Set<RoleModel> getAllLeaders(RoleModel role){
		return null;
	}
	/** 
     * 获取角色领导的直属下属角色集
     * @param role 
     * @return Set<RoleModel> 
     * @创建时间 2011-4-15 上午10:41:15
     */
	public Set<RoleModel> getAllSubordinates(RoleModel role){
		return null;
	}
}
