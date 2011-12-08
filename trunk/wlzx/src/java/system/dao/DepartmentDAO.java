/**
 * 
 */
package system.dao;

import java.util.List;
import java.util.Set;


import system.BaseDAO;
import system.entity.DepartmentModel;



  
  /**
 *
 * 类名称：DepartmentDAO
 * 类描述：
 * 创建人：wuyuyue
 * 创建时间：2011-4-14 下午11:21:38
 * 修改人：wuyuyue
 * 修改时间：2011-4-14 下午11:21:38
 * 修改备注：
 * @version
 *
 */

public interface DepartmentDAO extends BaseDAO<DepartmentModel>{
	public Set<DepartmentModel> getAllLeaders(DepartmentModel department);
	
	public Set<DepartmentModel> getAllSubordinates(DepartmentModel department);
	
	public DepartmentModel getDepartmentBySymbol(String symbol);
	public DepartmentModel getSupervisorFlagDepartment();
	public DepartmentModel getDepartmentByName(String name) ;
	public List<DepartmentModel> getAllDepartments();

}
