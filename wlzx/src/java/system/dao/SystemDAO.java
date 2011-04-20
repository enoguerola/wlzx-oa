/**
 * 
 */
package system.dao;


import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import system.BaseDAOImpl;
import system.entity.SystemModel;
import system.utils.StringUtils;



  
  /**
 *
 * 类名称：SystemDAO
 * 类描述：
 * 创建人：wuyuyue
 * 创建时间：2011-4-14 下午10:59:41
 * 修改人：wuyuyue
 * 修改时间：2011-4-14 下午10:59:41
 * 修改备注：
 * @version
 *
 */

public class SystemDAO extends BaseDAOImpl<SystemModel>{
//	/** 
//     * 获取父亲系统
//     * @param system 
//     * @return SystemModel
//     * @创建时间 2011-4-15 上午10:41:15
//     */ 
//	public SystemModel getParent(SystemModel system){
//		return null;
//	}
//	/** 
//     * 获取子系统集
//     * @param system 
//     * @return Set<SystemModel> 
//     * @创建时间 2011-4-15 上午10:41:15
//     */
//	public Set<SystemModel> getChildren(SystemModel system){
//		return null;
//	}
//	/** 
//     * 若是叶子节点获取功能菜单集
//     * @param system 
//     * @return Set<MenuModel> 
//     * @创建时间 2011-4-15 上午10:41:15
//     */
//	public Set<MenuModel> getMenus(SystemModel system){
//		return null;
//	}
	/** 
	  * 通过唯一性系统标记查询系统实体
	  * @param symbol 
	  * @return T
	  * @创建时间 2011-4-15 上午10:41:15
	  */
	@SuppressWarnings("unchecked")
	public SystemModel getSystemBySymbol(String symbol){
		if (StringUtils.isNotEmpty(symbol)) {
			DetachedCriteria criteria = DetachedCriteria.forClass(SystemModel.class);
			criteria.add(Restrictions.eq("symbol", symbol));
			List<SystemModel> result = this.getListByCriteria(criteria);
			return result != null && result.size() > 0 ? result.get(0) : null;
		}
		return null;
	}
	
}
