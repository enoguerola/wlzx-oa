/**
 * 
 */
package system.dao;

import java.util.List;

import system.BaseDAO;
import system.entity.DataAccessModeModel;


  
  /**
 *
 * 类名称：DataAccessModeDAO
 * 类描述：
 * 创建人：wuyuyue
 * 创建时间：2011-4-15 上午09:21:16
 * 修改人：wuyuyue
 * 修改时间：2011-4-15 上午09:21:16
 * 修改备注：
 * @version
 *
 */

public interface DataAccessModeDAO extends BaseDAO<DataAccessModeModel>{

	public DataAccessModeModel getDAMBySymbol(String symbol);

	public DataAccessModeModel getDataAccessModeBySymbol(String symbol);

	public List<DataAccessModeModel> getAllResources();

	public void removeDataAccessModeBySymbol(String symbol);
}
