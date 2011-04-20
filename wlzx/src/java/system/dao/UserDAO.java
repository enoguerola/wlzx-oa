/**
 * 
 */
package system.dao;

import java.util.Set;

import system.BaseDAOImpl;
import system.entity.RoleModel;
import system.entity.UserModel;





  
  /**
 *
 * 类名称：UserDAO
 * 类描述：
 * 创建人：wuyuyue
 * 创建时间：2011-4-14 下午10:41:15
 * 修改人：wuyuyue
 * 修改时间：2011-4-14 下午10:41:15
 * 修改备注：
 * @version
 *
 */

public class UserDAO extends BaseDAOImpl<UserModel>{
	/** 
     * 获取某用户角色集
     * @param user 
     * @return Set<RoleModel> 
     * @创建时间 2011-4-15 上午10:41:15
     */ 
	public Set<RoleModel> getAllRoles(UserModel user){
		return null;
	}
	/** 
     * 获取用户直属领导用户集
     * @param user 
     * @return Set<UserModel> 
     * @创建时间 2011-4-15 上午10:41:15
     */ 
	public Set<UserModel> getAllLeaders(UserModel user){
		return null;
	}
	/** 
     * 获取用户领导的直属下属用户集
     * @param user 
     * @return Set<UserModel> 
     * @创建时间 2011-4-15 上午10:41:15
     */
	public Set<UserModel> getAllSubordinates(UserModel user){
		return null;
	}

}
