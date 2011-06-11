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
	private String detail;
	private String phone;
	private Set<DepartmentModel> subordinates=new TreeSet<DepartmentModel>();//直属下级部门
	private Set<DepartmentModel> leaders=new TreeSet<DepartmentModel>();//直属上级部门
	private Set<RoleModel> roles=new TreeSet<RoleModel>();//部门角色集
	private Set<RoleModel> leaderRoles=new TreeSet<RoleModel>();//部门上级领导角色集
	private Set<DataAccessModeModel> dataAccessModes=new TreeSet<DataAccessModeModel>();//部门数据访问权限
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

	//获得部门及子部门所有用户集
	public Set<UserModel> getUsers() {
		Set<UserModel> users=new HashSet<UserModel>();
		for(RoleModel role:this.getAllRoles()){
			for(UserModel user:role.getUsers())
			users.add(user);
		}
		return users;
	}
	//获得部门及子部门所有岗位
	public List<RoleModel> getAllRoles(){
		List<RoleModel> result=new ArrayList<RoleModel>();
		for(RoleModel role:this.getRoles()){
			result.add(role);
			addSubRoles(role,result);
		}
		return result;
	}
	public void addSubRoles(RoleModel role,List<RoleModel> result){
		if(role==null)return ;
		for(RoleModel _role:role.getSubordinates()){
			result.add(_role);
			addSubRoles(_role,result);
		}
		
	}
	
	

}
