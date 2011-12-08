/**
 * 
 */
package system.dao;

import system.BaseDAO;
import system.entity.MenuModel;


  
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

public interface MenuDAO extends BaseDAO<MenuModel> {


	public MenuModel getMenuBySymbol(String symbol);
	public void removeMenuBySymbol(String symbol) ;
}
