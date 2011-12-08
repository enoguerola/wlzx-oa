/**
 * 
 */
package system.dao;


import java.util.List;

import system.BaseDAO;
import system.PaginationSupport;
import system.entity.UserModel;





  
  /**
 *
 * 类名称：UserDAO
 * 类描述：
 * 创建人：wuyuyue
 * 创建时间：2011-4-14 下午10:41:15
 * 修改人：wuyuyue
 * 修改时间：2011-4-14 下午10:41:15
 * 修改备注：
 * @version
 *
 */

public interface UserDAO extends BaseDAO<UserModel>{
	public UserModel getUserByUserAccount(String userAccount);
	public List<UserModel> getAllUsers() ;
	public List<UserModel> getUsersByCondition(String account, Boolean status) ;

	public List<UserModel> getUsersByMainDepartment(String departmentId);
	public PaginationSupport<UserModel> getUsersByCondition(String account,Boolean status, int index, int pageSize) ;

}
