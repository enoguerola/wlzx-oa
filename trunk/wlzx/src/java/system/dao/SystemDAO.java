/**
 * 
 */
package system.dao;


import system.BaseDAO;
import system.entity.SystemModel;



  
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

public interface SystemDAO extends BaseDAO<SystemModel>{

	public SystemModel getSystemBySymbol(String symbol);
	
}
