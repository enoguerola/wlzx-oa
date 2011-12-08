/**
 * 
 */
package system.dao;

import system.BaseDAO;
import system.entity.OperationModel;


  
  /**
 *
 * 类名称：OperationDAO
 * 类描述：
 * 创建人：wuyuyue
 * 创建时间：2011-4-14 下午11:18:29
 * 修改人：wuyuyue
 * 修改时间：2011-4-14 下午11:18:29
 * 修改备注：
 * @version
 *
 */

public interface OperationDAO extends BaseDAO<OperationModel>{

	public OperationModel getOperationBySymbol(String symbol);

	public void removeOperationBySymbol(String symbol);
}
