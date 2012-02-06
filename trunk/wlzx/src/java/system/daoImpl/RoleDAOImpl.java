/**
 * 
 */
package system.daoImpl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import system.BaseDAOImpl;
import system.dao.RoleDAO;
import system.entity.DepartmentModel;
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

public class RoleDAOImpl extends BaseDAOImpl<RoleModel> implements RoleDAO {
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
	public RoleModel getFinanceViceHeaderMasterRole(){
		DetachedCriteria criteria = DetachedCriteria.forClass(RoleModel.class);
		criteria.add(Restrictions.eq("financeViceHeaderMasterFlag", true));
		List<RoleModel> result = this.getListByCriteria(criteria);
		return result != null && result.size() > 0 ? result.get(0) : null;
	}
	@SuppressWarnings("unchecked")
	public List<RoleModel> getAllRoles(boolean filterBasicFlag) {
		DetachedCriteria criteria = DetachedCriteria.forClass(RoleModel.class);
		criteria.addOrder(Order.asc("level"));
		if(filterBasicFlag==true)
		//过滤基础角色
		criteria.add(Restrictions.ne("basicFlag", true));
		List<RoleModel> result = this.getListByCriteria(criteria);
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<RoleModel> getTeachingRoles() {
		DetachedCriteria criteria = DetachedCriteria.forClass(RoleModel.class);
		criteria.addOrder(Order.asc("level"));
		criteria.add(Restrictions.eq("teacherFlag", true));
		List<RoleModel> result = this.getListByCriteria(criteria);
		return result;
	}
	@SuppressWarnings("unchecked")
	public RoleModel getRoleByName(String roleName) {
		if (StringUtils.isNotEmpty(roleName)) {
			DetachedCriteria criteria = DetachedCriteria.forClass(RoleModel.class);
			criteria.add(Restrictions.eq("name", roleName));
			List<RoleModel> result = this.getListByCriteria(criteria);
			return result != null && result.size() > 0 ? result.get(0) : null;
		}
		return null;
	}
}
