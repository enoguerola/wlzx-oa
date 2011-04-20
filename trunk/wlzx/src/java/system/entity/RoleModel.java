/**
 * 
 */
package system.entity;

import java.util.Set;
import java.util.TreeSet;



  
  /**
 *
 * 类名称：RoleModel
 * 类描述：角色模型
 * 创建人：wuyuyue
 * 创建时间：2011-4-14 下午08:32:29
 * 修改人：wuyuyue
 * 修改时间：2011-4-14 下午08:32:29
 * 修改备注：
 * @version
 *
 */

public class RoleModel extends BaseModel {
	private String detail;
	private Boolean supervisorFlag;//部门主管标记，注：有此标记的角色不可自行删除，随部门删除而删除
	private Set<RoleModel> subordinates=new TreeSet<RoleModel>();//直属下级角色
	private Set<RoleModel> leaders=new TreeSet<RoleModel>();//直属上级角色
	private Set<UserModel> users=new TreeSet<UserModel>();//角色用户集
	private Set<DataAccessModeModel> dataAccessModes=new TreeSet<DataAccessModeModel>();//角色数据访问权限
	private Set<DepartmentModel> departments=new TreeSet<DepartmentModel>();//所属部门集
	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Set<RoleModel> getSubordinates() {
		return subordinates;
	}

	public void setSubordinates(Set<RoleModel> subordinates) {
		this.subordinates = subordinates;
	}

	public Set<RoleModel> getLeaders() {
		return leaders;
	}

	public void setLeaders(Set<RoleModel> leaders) {
		this.leaders = leaders;
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

	public Set<DepartmentModel> getDepartments() {
		return departments;
	}

	public void setDepartments(Set<DepartmentModel> departments) {
		this.departments = departments;
	}


	public Boolean getSupervisorFlag() {
		return supervisorFlag;
	}

	public void setSupervisorFlag(Boolean supervisorFlag) {
		this.supervisorFlag = supervisorFlag;
	}
	/** 
     * 获取角色所在部门
     * @创建时间 2011-4-15 上午10:41:15
     */ 
	public DepartmentModel getBelongDepartment() {
		if(getDepartments().iterator()!=null)
			return getDepartments().iterator().next();
		else return null;
	}
}
