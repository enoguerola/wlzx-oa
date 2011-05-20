/**
 * 
 */
package system.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import system.BaseDAOImpl;
import system.entity.RoleModel;
import system.utils.StringUtils;



  
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
//	/** 
//     * 获取某角色用户集
//     * @param role 
//     * @return Set<UserModel> 
//     * @创建时间 2011-4-15 上午10:41:15
//     */ 
//	public Set<UserModel> getAllUsers(RoleModel role){
//		return null;
//	}
//	/** 
//     * 获取角色数据访问权限集合
//     * @param role 
//     * @return Set<DataAccessModeMetaModel> 
//     * @创建时间 2011-4-15 上午10:41:15
//     */ 
//	public Set<DataAccessModeModel> getRoleDataAccessModes(RoleModel role){
//		return null;
//	}
//	/** 
//     * 获取角色所在部门
//     * @param role 
//     * @return DepartmentModel
//     * @创建时间 2011-4-15 上午10:41:15
//     */ 
//	public DepartmentModel getBelongDepartment(RoleModel role){
//		return null;
//	}
//	/** 
//     * 获取角色直属领导角色集
//     * @param role 
//     * @return Set<RoleModel> 
//     * @创建时间 2011-4-15 上午10:41:15
//     */ 
//	public Set<RoleModel> getAllLeaders(RoleModel role){
//		return null;
//	}
//	/** 
//     * 获取角色领导的直属下属角色集
//     * @param role 
//     * @return Set<RoleModel> 
//     * @创建时间 2011-4-15 上午10:41:15
//     */
//	public Set<RoleModel> getAllSubordinates(RoleModel role){
//		return null;
//	}
	/** 
	  * 通过唯一性系统标记查询部门实体
	  * @param symbol 
	  * @return T
	  * @创建时间 2011-4-15 上午10:41:15
	  */
	@SuppressWarnings("unchecked")
	public RoleModel getRoleBySymbol(String symbol){
		if (StringUtils.isNotEmpty(symbol)) {
			DetachedCriteria criteria = DetachedCriteria.forClass(RoleModel.class);
			criteria.add(Restrictions.eq("symbol", symbol));
			List<RoleModel> result = this.getListByCriteria(criteria);
			return result != null && result.size() > 0 ? result.get(0) : null;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<RoleModel> getAllRoles() {
		DetachedCriteria criteria = DetachedCriteria.forClass(RoleModel.class);
		criteria.addOrder(Order.asc("level"));
		List<RoleModel> result = this.getListByCriteria(criteria);
		return result;
	}
}
