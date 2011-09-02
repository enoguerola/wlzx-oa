/**
 * 
 */
package system.entity;

import java.util.HashSet;
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
	/**
	 * 
	 */
	private static final long serialVersionUID = 7679845606857505181L;
	private String detail;
	private int level;//岗位级别
	private Boolean supervisorFlag=false;//部门主管标记，注：有此标记的角色不可自行删除，随部门删除而删除
	private Set<RoleModel> subordinates=new TreeSet<RoleModel>();//直属下级角色
	private Set<RoleModel> leaders=new TreeSet<RoleModel>();//直属上级角色
	private Set<UserModel> users=new TreeSet<UserModel>();//角色用户集
	private Set<UserModel> mainUsers=new TreeSet<UserModel>();//主角色用户集
	private Set<DataAccessModeModel> dataAccessModes=new TreeSet<DataAccessModeModel>();//角色数据访问权限
	private Set<DepartmentModel> departments=new TreeSet<DepartmentModel>();//所属部门集
	private Set<DepartmentModel> leadingDepartments=new TreeSet<DepartmentModel>();//该角色所领导的部门集
	private Boolean basicFlag=false;
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
	public Set<UserModel> getAllUsers() {
		Set<UserModel> sets=new HashSet<UserModel>();
		for(UserModel user:getMainUsers()){
			sets.add(user);
		}
		for(UserModel user:getUsers()){
			sets.add(user);
		}
		return sets;
	}
	public Set<RoleModel> getAllSubordinates() {
		Set<RoleModel> sets=new HashSet<RoleModel>();
		for(RoleModel role:getSubordinates()){
			addSubordinates(sets,role);
		}
		
		return sets;
	}
	private void addSubordinates(Set<RoleModel> sets,RoleModel role){
		if(role==null)return;
		sets.add(role);
		for(RoleModel subRole:role.getSubordinates()){
			addSubordinates(sets,subRole);
		}
		
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
		RoleModel role=getTopLeadRole(this);
		if(role.getDepartments()!=null&&role.getDepartments().size()>0)
			return role.getDepartments().iterator().next();
		else return null;
		
	}
	/**
	 * 获取角色本部门主管角色
	 * */
	public static RoleModel getTopLeadRole(RoleModel role){
		if(getLeaderRole(role)==null) return role;
		else return getTopLeadRole(getLeaderRole(role));
	}
	/** 
     * 获取角色直属领导角色
     * @创建时间 2011-4-15 上午10:41:15
     */ 
	public static RoleModel getLeaderRole(RoleModel role) {
		if(role.getLeaders()!=null&&role.getLeaders().size()>0)
			return role.getLeaders().iterator().next();
		else return null;
	}

	public Set<DepartmentModel> getLeadingDepartments() {
		return leadingDepartments;
	}

	public void setLeadingDepartments(Set<DepartmentModel> leadingDepartments) {
		this.leadingDepartments = leadingDepartments;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Set<UserModel> getMainUsers() {
		return mainUsers;
	}

	public void setMainUsers(Set<UserModel> mainUsers) {
		this.mainUsers = mainUsers;
	}

	public Boolean getBasicFlag() {
		return basicFlag;
	}

	public void setBasicFlag(Boolean basicFlag) {
		this.basicFlag = basicFlag;
	}
}
