/**
 * 
 */
package system.entity;

import java.util.TreeSet;
import java.util.Set;
import java.util.TreeSet;



  
  /**
 *
 * 类名称：DepartmentModel
 * 类描述：部门模型
 * 创建人：wuyuyue
 * 创建时间：2011-4-14 下午08:33:04
 * 修改人：wuyuyue
 * 修改时间：2011-4-14 下午08:33:04
 * 修改备注：
 * @version
 *
 */

public class DRModel  extends SimpleBaseModel{
	
	private static final long serialVersionUID = 5683390976366143184L;
	/**
	 * 
	 */
	private String departmentId;
	private String roleId;
	private Boolean basicFlag;
	private Set<UserModel> users=new TreeSet<UserModel>();
	private Set<UserModel> mainUsers=new TreeSet<UserModel>();
	private Set<DataAccessModeModel> dataAccessModes=new TreeSet<DataAccessModeModel>();//数据访问权限

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public Set<UserModel> getUsers() {
		return users;
	}

	public void setUsers(Set<UserModel> users) {
		this.users = users;
	}

	public Set<DataAccessModeModel> getDataAccessModes() {
		return dataAccessModes;
	}

	public void setDataAccessModes(Set<DataAccessModeModel> dataAccessModes) {
		this.dataAccessModes = dataAccessModes;
	}

	public Boolean getBasicFlag() {
		return basicFlag;
	}

	public void setBasicFlag(Boolean basicFlag) {
		this.basicFlag = basicFlag;
	}

	public Set<UserModel> getMainUsers() {
		return mainUsers;
	}

	public void setMainUsers(Set<UserModel> mainUsers) {
		this.mainUsers = mainUsers;
	}
	public  Set<UserModel> getAllUsers(){
		Set<UserModel> results=getMainUsers();
		
		for(UserModel user:getUsers()){
			if(!results.contains(user))
				results.add(user);
		}
		
		return results;
		
	}

}
