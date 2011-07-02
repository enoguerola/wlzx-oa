/**
 * 
 */
package system.entity;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import system.components.SecurityUserHolder;


  
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
	private int accountStyle;
	private PersonModel person;
	private Set<UserModel> subordinates=new TreeSet<UserModel>();//直属下属
	private Set<UserModel> leaders=new TreeSet<UserModel>();//直属领导
	private Set<RoleModel> roles=new TreeSet<RoleModel>();//所属角色
//	private Set<DepartmentModel> departments=new TreeSet<DepartmentModel>();//用户所在部门集
	private Boolean active;
	private RoleModel mainRole=new RoleModel();//主要角色
	private DepartmentModel mainDepartment=new DepartmentModel();//主要部门
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
	//获取所有角色
	public Set<RoleModel> getAllRoles() {
		Set<RoleModel> allRoles=new TreeSet<RoleModel>(getRoles());
		if(getMainRole()!=null)
		allRoles.add(getMainRole());
		return allRoles;
	}

	//用户拥有的权限
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();  
//        System.out.println(roles.size()+"getAuthorities");  
        if(SecurityUserHolder.isSuperRootUser(getName())){
        	setMainRole(SecurityUserHolder.getSuperRootRoleModel());
        }
        Set<RoleModel> roles = this.getAllRoles();  
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
	//获得用户所有权限
	@SuppressWarnings("unchecked")
	public Set<String>  getAllDams(){
		Set<String> damList=new HashSet();
		Set<RoleModel> roleList=getAllRoles();
		Iterator<RoleModel> iterator=roleList.iterator();
		while(iterator.hasNext()){
			RoleModel _role=iterator.next();	
			Iterator<DataAccessModeModel> iterator2=_role.getDataAccessModes().iterator();
			while(iterator2.hasNext()){
				DataAccessModeModel _dam =iterator2.next();	
				damList.add(_dam.getSymbol());
			}
			
		}
		return damList;
	}
	//判断用户是否含有某权限
	public boolean hasDam(String symbol)
	{	
		boolean has=false;
		Set<String> damList =getAllDams();
		Iterator<String> iterator=damList.iterator();
		while(iterator.hasNext()){
			String _symbol=iterator.next();	
			if(_symbol.equals(symbol)){
				has=true;
				break;
			}
		}
		return has;
		
	}
	
	//获得用户所在处室【不推荐在此写-need provided by yufeng;说明一级部门行政组，二级部门处室定死；分别用level标记数字1,2体现】
	public DepartmentModel belongMainOfficeDepartment(){
		return null;
	}
	//获得用户所在处室分管副校长【不推荐在此写-need provided by yufeng;说明一级角色校长，二级角色分管校长定死；分别用level标记数字1,2体现;处室主管角色level3标记】
	public Set<RoleModel> belongMainOfficeDepartmentMasterVicePrincipal(){
		return null;
	}
	//获得用户所在部门集
	public Set<DepartmentModel> getDepartments() {
		Set<DepartmentModel> departments=new HashSet<DepartmentModel>();
		for(RoleModel role:getAllRoles()){
			departments.add(role.getBelongDepartment());
		}
		return departments;
	}
	
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public int getAccountStyle() {
		return accountStyle;
	}
	public void setAccountStyle(int accountStyle) {
		this.accountStyle = accountStyle;
	}
	public RoleModel getMainRole() {
		return mainRole;
	}
	public void setMainRole(RoleModel mainRole) {
		this.mainRole = mainRole;
	}
	
	public DepartmentModel getMainDepartment() {
		if(getMainRole()!=null)
			return getMainRole().getBelongDepartment();
		else return mainDepartment;
	}
	
	public void setMainDepartment(DepartmentModel mainDepartment) {
		if(getMainRole()!=null)
			this.mainDepartment=getMainRole().getBelongDepartment();
		else this.mainDepartment = mainDepartment;
	}
	

	
	
}
