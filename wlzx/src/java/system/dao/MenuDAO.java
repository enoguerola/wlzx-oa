/**
 * 
 */
package system.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import system.BaseDAOImpl;
import system.entity.MenuModel;
import system.utils.StringUtils;


  
  /**
 *
 * 类名称：MenuDAO
 * 类描述：
 * 创建人：wuyuyue
 * 创建时间：2011-4-14 下午11:01:44
 * 修改人：wuyuyue
 * 修改时间：2011-4-14 下午11:01:44
 * 修改备注：
 * @version
 *
 */

public class MenuDAO extends BaseDAOImpl<MenuModel> {


//	/** 
//     * 获取父亲菜单
//     * @param menu 
//     * @return MenuModel
//     * @创建时间 2011-4-15 上午10:41:15
//     */ 
//	public MenuModel getParent(MenuModel menu){
//		return null;
//	}
//	/** 
//     * 获取子菜单集
//     * @param menu 
//     * @return Set<MenuModel> 
//     * @创建时间 2011-4-15 上午10:41:15
//     */
//	public Set<MenuModel> getChildren(MenuModel menu){
//		return null;
//	}
//	/** 
//     * 叶子节点的菜单获取对应模块
//     * @param menu 
//     * @return ModuleModel
//     * @创建时间 2011-4-15 上午10:41:15
//     */
//	public ModuleModel getModule(MenuModel menu){
//		return null;
//	}
//	/** 
//     * 若是根节点获取所属系统
//     * @param menu 
//     * @return SystemModel
//     * @创建时间 2011-4-15 上午10:41:15
//     */
//	public SystemModel getBelongSystem(MenuModel menu){
//		return null;
//	}
	/** 
	  * 通过唯一性系统标记查询菜单实体
	  * @param symbol 
	  * @return T
	  * @创建时间 2011-4-15 上午10:41:15
	  */
	@SuppressWarnings("unchecked")
	public MenuModel getMenuBySymbol(String symbol){
		if (StringUtils.isNotEmpty(symbol)) {
			DetachedCriteria criteria = DetachedCriteria.forClass(MenuModel.class);
			criteria.add(Restrictions.eq("symbol", symbol));
			List<MenuModel> result = this.getListByCriteria(criteria);
			return result != null && result.size() > 0 ? result.get(0) : null;
		}
		return null;
	}
	/** 
	  * 通过唯一性系统标记删除菜单实体
	  * @param symbol 
	  * @创建时间 2011-4-15 上午10:41:15
	  */
	public void removeMenuBySymbol(String symbol) {
//		MenuModel menu=getMenuBySymbol(symbol);
//		merge(menu);
		remove(getMenuBySymbol(symbol));	
	}
}
