/**
 * 
 */
package system.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

public class DepartmentModel  extends BaseModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7972036409727505069L;
	private int level;//部门级别
	private String detail;
	private String phone;
	private Set<DepartmentModel> subordinates=new TreeSet<DepartmentModel>();//直属下级部门
	private Set<DepartmentModel> leaders=new TreeSet<DepartmentModel>();//直属上级部门
	private Set<RoleModel> roles=new TreeSet<RoleModel>();//部门角色集
	private Set<RoleModel> leaderRoles=new TreeSet<RoleModel>();//部门上级领导角色集
	private Set<DataAccessModeModel> dataAccessModes=new TreeSet<DataAccessModeModel>();//部门数据访问权限
	private Set<UserModel> mainUsers=new TreeSet<UserModel>();//主部门用户集
	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Set<DepartmentModel> getSubordinates() {
		return subordinates;
	}

	public void setSubordinates(Set<DepartmentModel> subordinates) {
		this.subordinates = subordinates;
	}

	public Set<DepartmentModel> getLeaders() {
		return leaders;
	}

	public void setLeaders(Set<DepartmentModel> leaders) {
		this.leaders = leaders;
	}

	public Set<RoleModel> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleModel> roles) {
		this.roles = roles;
	}

	public Set<DataAccessModeModel> getDataAccessModes() {
		return dataAccessModes;
	}
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setDataAccessModes(Set<DataAccessModeModel> dataAccessModes) {
		this.dataAccessModes = dataAccessModes;
	}
	/** 
     * 获取部门主管角色
     * @创建时间 2011-4-15 上午10:41:15
     */ 
	public RoleModel getSupervisorRole() {
		for(RoleModel role:getRoles()){
			if(role.getSupervisorFlag()==true){
				return role;
			}
		}
		return null;
	}

	public Set<RoleModel> getLeaderRoles() {
		return leaderRoles;
	}

	public void setLeaderRoles(Set<RoleModel> leaderRoles) {
		this.leaderRoles = leaderRoles;
	}
	//获得所有子部门
	public Set<DepartmentModel> getAllSubordinates() {
		Set<DepartmentModel> results=new HashSet<DepartmentModel>();
		addSubordinates(this,results);
		return results;
	}
	public void addSubordinates(DepartmentModel department,Set<DepartmentModel> results) {
		if(department.getSubordinates()!=null&&department.getSubordinates().size()>0){
			for(DepartmentModel sub:department.getSubordinates()){
				results.add(sub);
				addSubordinates(sub,results);
			}
		}
	}
	//获得部门及子部门所有用户集
	public Set<UserModel> getUsers() {
		Set<UserModel> users=new HashSet<UserModel>(mainUsers);
		for(RoleModel role:this.getAllRoles()){
			for(UserModel user:role.getAllUsers())
			users.add(user);
		}
		for(DepartmentModel department:this.getAllSubordinates()){
			for(UserModel user:department.getMainUsers())
			users.add(user);
		}
		return users;
	}
	//获得部门及子部门所有岗位
	public List<RoleModel> getAllRoles(){
		List<RoleModel> result=new ArrayList<RoleModel>();
		for(DepartmentModel department:this.getAllSubordinates()){
			for(RoleModel role:department.getAllRoles()){
				result.add(role);
			}
		}
		for(RoleModel role:this.getRoles()){
			result.add(role);
			addSubRoles(role,result);
		}
		return result;
	}
//	//获得部门及子部门所有用户
//	public Set<UserModel> getAllUsers(){
//		Set<UserModel> result=new HashSet<UserModel>();
//		for(DepartmentModel department:this.getAllSubordinates()){
//			for(RoleModel role:department.getAllRoles()){
//				for(UserModel user:role.getAllUsers()){
//					if(!result.contains(user)){
//						result.add(user);
//					}
//				}
//			}
//		}
//		return result;
//	}
	public void addSubRoles(RoleModel role,List<RoleModel> result){
		if(role==null)return ;
		for(RoleModel _role:role.getSubordinates()){
			result.add(_role);
			addSubRoles(_role,result);
		}
		
	}

	public Set<UserModel> getMainUsers() {
		return mainUsers;
	}

	public void setMainUsers(Set<UserModel> mainUsers) {
		this.mainUsers = mainUsers;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	
	

}
