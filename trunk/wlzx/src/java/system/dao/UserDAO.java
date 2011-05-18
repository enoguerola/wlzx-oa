/**
 * 
 */
package system.dao;


import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import system.BaseDAOImpl;
import system.entity.UserModel;
import system.utils.StringUtils;





  
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
//	/** 
//     * 获取某用户角色集
//     * @param user 
//     * @return Set<RoleModel> 
//     * @创建时间 2011-4-15 上午10:41:15
//     */ 
//	public Set<RoleModel> getAllRoles(UserModel user){
//		return null;
//	}
//	/** 
//     * 获取用户直属领导用户集
//     * @param user 
//     * @return Set<UserModel> 
//     * @创建时间 2011-4-15 上午10:41:15
//     */ 
//	public Set<UserModel> getAllLeaders(UserModel user){
//		return null;
//	}
//	/** 
//     * 获取用户领导的直属下属用户集
//     * @param user 
//     * @return Set<UserModel> 
//     * @创建时间 2011-4-15 上午10:41:15
//     */
//	public Set<UserModel> getAllSubordinates(UserModel user){
//		return null;
//	}

	/** 
	  * 通过用户姓名查询用户实体
	  * @param userAccount 
	  * @return T
	  * @创建时间 2011-4-15 上午10:41:15
	  */
	@SuppressWarnings("unchecked")
	public UserModel getUserByUserAccount(String userAccount){
		if (StringUtils.isNotEmpty(userAccount)) {
			DetachedCriteria criteria = DetachedCriteria.forClass(UserModel.class);
			criteria.add(Restrictions.eq("name", userAccount));
			List<UserModel> result = this.getListByCriteria(criteria);
			return result != null && result.size() > 0 ? result.get(0) : null;
		}
		return null;
	}

}