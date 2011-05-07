/**
 * 
 */
package system.dao;


import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import system.BaseDAOImpl;

import system.entity.ModuleModel;
import system.utils.StringUtils;




  
  /**
 *
 * 类名称：ModuleDAO
 * 类描述：
 * 创建人：wuyuyue
 * 创建时间：2011-4-14 下午11:06:50
 * 修改人：wuyuyue
 * 修改时间：2011-4-14 下午11:06:50
 * 修改备注：
 * @version
 *
 */

public class ModuleDAO extends BaseDAOImpl<ModuleModel> {
//	/** 
//     * 获取父亲模块
//     * @param module 
//     * @return ModuleModel
//     * @创建时间 2011-4-15 上午10:41:15
//     */ 
//	public ModuleModel getParent(ModuleModel module){
//		return null;
//	}
//	/** 
//     * 获取子模块集
//     * @param module 
//     * @return Set<ModuleModel> 
//     * @创建时间 2011-4-15 上午10:41:15
//     */
//	public Set<RoleModel> getChildren(ModuleModel module){
//		return null;
//	}
//	/** 
//     * 获取模块操作集
//     * @param module 
//     * @return Set<OperationModel> 
//     * @创建时间 2011-4-15 上午10:41:15
//     */
//	public Set<OperationModel> getOperations(ModuleModel module){
//		return null;
//	}
//	/** 
//     * 根节点的模块获取所属菜单
//     * @param module 
//     * @return MenuModel
//     * @创建时间 2011-4-15 上午10:41:15
//     */ 
//	public MenuModel getBelongMenu(ModuleModel module){
//		return null;
//	}
	/** 
	  * 通过唯一性系统标记查询模块实体
	  * @param symbol 
	  * @return T
	  * @创建时间 2011-4-15 上午10:41:15
	  */
	@SuppressWarnings("unchecked")
	public ModuleModel getModuleBySymbol(String symbol){
		if (StringUtils.isNotEmpty(symbol)) {
			DetachedCriteria criteria = DetachedCriteria.forClass(ModuleModel.class);
			criteria.add(Restrictions.eq("symbol", symbol));
			List<ModuleModel> result = this.getListByCriteria(criteria);
			return result != null && result.size() > 0 ? result.get(0) : null;
		}
		return null;
	}

	public void removeModuleBySymbol(String symbol) {
		// TODO Auto-generated method stub
		remove(getModuleBySymbol(symbol));
	}
}
