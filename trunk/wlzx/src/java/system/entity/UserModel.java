/**
 * 
 */
package system.entity;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


  
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

public class UserModel  extends BaseModel implements UserDetails{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3928147466709546513L;
	private String pwd;
	private Date lastLoginTime;
	private String lastLoginIP;
	private String email;
	private PersonModel person;
	private Set<UserModel> subordinates=new TreeSet<UserModel>();//直属下属
	private Set<UserModel> leaders=new TreeSet<UserModel>();//直属领导
	private Set<RoleModel> roles=new TreeSet<RoleModel>();//所属角色
	private Set<DepartmentModel> departments=new TreeSet<DepartmentModel>();//用户所在部门集
	private Boolean active;
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
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


	//用户拥有的权限
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();  
        Set<RoleModel> roles = this.getRoles();  
//        System.out.println(roles.size()+"getAuthorities");  
        for(RoleModel role : roles) {  
        	authSet.add(new SimpleGrantedAuthority(role.getSymbol())); 
        }  
        return authSet;  
	}
	//用户名
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return getName();
	}
	//密码
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return getPwd();
	}

	//用户账号是否过期
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	//用户账号是否被锁定
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	//用户密码是否过期
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	//用户是否可用
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	public Set<DepartmentModel> getDepartments() {
		return departments;
	}
	public void setDepartments(Set<DepartmentModel> departments) {
		this.departments = departments;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	

	
	
}
