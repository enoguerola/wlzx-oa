/**
 * 
 */
package system.entity;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;


  
  /**
 *
 * 类名称：UserModel
 * 类描述：用户模型
 * 创建人：wuyuyue
 * 创建时间：2011-4-14 下午08:29:51
 * 修改人：wuyuyue
 * 修改时间：2011-4-14 下午08:29:51
 * 修改备注：
 * @version
 *
 */

public class UserModel  extends BaseModel {
	private String password;
	private Date lastLoginTime;
	private String lastLoginIP;
	private String email;
	private PersonModel person;
	private Set<UserModel> subordinates=new TreeSet<UserModel>();//直属下属
	private Set<UserModel> leaders=new TreeSet<UserModel>();//直属领导
	private Set<RoleModel> roles=new TreeSet<RoleModel>();//所属角色
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public String getLastLoginIP() {
		return lastLoginIP;
	}
	public void setLastLoginIP(String lastLoginIP) {
		this.lastLoginIP = lastLoginIP;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public PersonModel getPerson() {
		return person;
	}
	public void setPerson(PersonModel person) {
		this.person = person;
	}
	public Set<UserModel> getSubordinates() {
		return subordinates;
	}
	public void setSubordinates(Set<UserModel> subordinates) {
		this.subordinates = subordinates;
	}
	public Set<UserModel> getLeaders() {
		return leaders;
	}
	public void setLeaders(Set<UserModel> leaders) {
		this.leaders = leaders;
	}
	public Set<RoleModel> getRoles() {
		return roles;
	}
	public void setRoles(Set<RoleModel> roles) {
		this.roles = roles;
	}

	
	
}
