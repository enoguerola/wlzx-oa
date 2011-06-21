/**
 * 
 */
package system.dao;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.SetUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import system.BaseDAOImpl;
import system.entity.DepartmentModel;
import system.utils.SetUtil;
import system.utils.StringUtils;



  
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
//	/** 
//     * 获取部门数据访问权限集合
//     * @param department 
//     * @return Set<DataAccessModeMetaModel> 
//     * @创建时间 2011-4-15 上午10:41:15
//     */ 
//	public Set<DataAccessModeModel> getDepartmentDataAccessModes(DepartmentModel department){
//		return null;
//	}
//	/** 
//     * 获取部门主管角色
//     * @param department 
//     * @return Set<RoleModel> 
//     * @创建时间 2011-4-15 上午10:41:15
//     */ 
//	public RoleModel getDepartmentMasterRole(DepartmentModel department){
//		return null;
//	}
//	/** 
//     * 获取部门角色集
//     * @param department 
//     * @return Set<RoleModel> 
//     * @创建时间 2011-4-15 上午10:41:15
//     */ 
//	public Set<RoleModel> getAllDepartmentRoles(DepartmentModel department){
//		return null;
//	}
//	/** 
//     * 获取部门直属领导部门集
//     * @param department 
//     * @return Set<DepartmentModel> 
//     * @创建时间 2011-4-15 上午10:41:15
//     */ 
//	public Set<DepartmentModel> getAllLeaders(DepartmentModel department){
//		return null;
//	}
	/** 
     * 获取部门领导的直属下属部门集
     * @param department 
     * @return Set<DepartmentModel> 
     * @创建时间 2011-4-15 上午10:41:15
     */
	public Set<DepartmentModel> getAllSubordinates(DepartmentModel department){
		Set<DepartmentModel> set = new HashSet<DepartmentModel>();
		if(department.getSubordinates() != null && department.getSubordinates().size() > 0){
			for(DepartmentModel model : department.getSubordinates()){
				Set<DepartmentModel> tmpSet = getAllSubordinates(model);
				SetUtil.merge(set, tmpSet);
				set.add(model);
			}
		}
		return set;
	}
	/** 
	  * 通过唯一性系统标记查询部门实体
	  * @param symbol 
	  * @return T
	  * @创建时间 2011-4-15 上午10:41:15
	  */
	@SuppressWarnings("unchecked")
	public DepartmentModel getDepartmentBySymbol(String symbol){
		if (StringUtils.isNotEmpty(symbol)) {
			DetachedCriteria criteria = DetachedCriteria.forClass(DepartmentModel.class);
			criteria.add(Restrictions.eq("symbol", symbol));
			List<DepartmentModel> result = this.getListByCriteria(criteria);
			return result != null && result.size() > 0 ? result.get(0) : null;
		}
		return null;
	}

}
