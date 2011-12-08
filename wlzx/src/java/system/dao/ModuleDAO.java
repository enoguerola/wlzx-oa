/**
 * 
 */
package system.dao;


import java.util.List;

import system.BaseDAO;
import system.entity.ModuleModel;




  
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

public interface ModuleDAO extends BaseDAO<ModuleModel>{
	public ModuleModel getModuleBySymbol(String symbol);
	public void removeModuleBySymbol(String symbol) ;
	public List<ModuleModel> getAllModules();
}
