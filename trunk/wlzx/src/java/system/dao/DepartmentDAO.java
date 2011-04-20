/**
 * 
 */
package system.dao;

import java.util.Set;

import system.BaseDAOImpl;
import system.entity.DataAccessModeModel;
import system.entity.DepartmentModel;
import system.entity.RoleModel;



  
  /**
 *
 * 类名称：DepartmentDAO
 * 类描述：
 * 创建人：wuyuyue
 * 创建时间：2011-4-14 下午11:21:38
 * 修改人：wuyuyue
 * 修改时间：2011-4-14 下午11:21:38
 * 修改备注：
 * @version
 *
 */

public class DepartmentDAO extends BaseDAOImpl<DepartmentModel> {
	/** 
     * 获取部门数据访问权限集合
     * @param department 
     * @return Set<DataAccessModeMetaModel> 
     * @创建时间 2011-4-15 上午10:41:15
     */ 
	public Set<DataAccessModeModel> getDepartmentDataAccessModes(DepartmentModel department){
		return null;
	}
	/** 
     * 获取部门主管角色
     * @param department 
     * @return Set<RoleModel> 
     * @创建时间 2011-4-15 上午10:41:15
     */ 
	public RoleModel getDepartmentMasterRole(DepartmentModel department){
		return null;
	}
	/** 
     * 获取部门角色集
     * @param department 
     * @return Set<RoleModel> 
     * @创建时间 2011-4-15 上午10:41:15
     */ 
	public Set<RoleModel> getAllDepartmentRoles(DepartmentModel department){
		return null;
	}
	/** 
     * 获取部门直属领导部门集
     * @param department 
     * @return Set<DepartmentModel> 
     * @创建时间 2011-4-15 上午10:41:15
     */ 
	public Set<DepartmentModel> getAllLeaders(DepartmentModel department){
		return null;
	}
	/** 
     * 获取部门领导的直属下属部门集
     * @param department 
     * @return Set<DepartmentModel> 
     * @创建时间 2011-4-15 上午10:41:15
     */
	public Set<DepartmentModel> getAllSubordinates(DepartmentModel department){
		return null;
	}
}
