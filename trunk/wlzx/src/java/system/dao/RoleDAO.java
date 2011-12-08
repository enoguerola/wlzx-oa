/**
 * 
 */
package system.dao;

import java.util.List;

import system.BaseDAO;
import system.entity.RoleModel;



  
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

public interface RoleDAO extends BaseDAO<RoleModel>{

	public RoleModel getRoleBySymbol(String symbol);

	public List<RoleModel> getAllRoles(boolean filterBasicFlag);

	public List<RoleModel> getTeachingRoles();
	public RoleModel getRoleByName(String roleName);
}
