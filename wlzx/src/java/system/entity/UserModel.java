/**
 * 
 */
package system.entity;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import system.components.WlzxUserDetailsService;



  
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
	private Boolean active;
	
	
	private DRModel mainDR=new DRModel();//主部门岗位
	private Set<DRModel> drs=new TreeSet<DRModel>();//其他部门岗位
	
	private Set<DataAccessModeModel> authorizations=new TreeSet<DataAccessModeModel>();//辅助
	
	private Set<DepartmentModel> leaderDepartments=new TreeSet<DepartmentModel>();//领导部门
	private Set<DepartmentModel> masterDepartments=new TreeSet<DepartmentModel>();//主管部门
	
	private Boolean hasTeachingRoleInMain=false;//辅助
	private Boolean hasTeachingRole=false;//辅助
	private Boolean hasRootDepartment=false;;//辅助
	
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

	public Set<DRModel> getAllDRs() {
		Set<DRModel> allDrs=new TreeSet<DRModel>(getDrs());
		if(getMainDR()!=null)
			allDrs.add(getMainDR());
		return allDrs;
	}
	
	public Set<String> getAllRoleIds() {
		Set<String> roleIds=new TreeSet<String>();
		for(DRModel dr:getAllDRs()){
			roleIds.add(dr.getRoleId());

		}
		return roleIds;
	}
	public Boolean hasRole(String roleId) {
		Boolean has=false;
		for(String id:getAllRoleIds()){
			if(id.equals(roleId)){
				has=true;
				break;
			}
		}
		return has;
	}
	public Boolean hasRoleInMain(String roleId) {
		Boolean has=false;
		if(mainDR!=null){
			if(roleId.equals(mainDR.getRoleId()))
				has=true;
		}
		return has;
	}
	public Set<String> getAllDepartmentIds() {
		Set<String> departmentIds=new TreeSet<String>();
		for(DRModel dr:getAllDRs()){
			departmentIds.add(dr.getDepartmentId());

		}
		return departmentIds;
	}
	public boolean hasDepartment(String departmentId) {
		Boolean has=false;
		for(String id:getAllDepartmentIds()){
			if(id.equals(departmentId)){
				has=true;
				break;
			}
		}
		return has;
	}
	//用户拥有的权限
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();  
		 if(getName().equals(WlzxUserDetailsService.superUserName)){
			 authSet.add(new SimpleGrantedAuthority(WlzxUserDetailsService.superUserRole));
		 }
        Set<DRModel> drs = this.getAllDRs();  
        for(DRModel dr : drs) {  
        	authSet.add(new SimpleGrantedAuthority(dr.getId())); 
        }  
        //默认继承最小权限集
        authSet.add(new SimpleGrantedAuthority("basic_dr")); 
        return authSet;  
	}
	//用户名
	@Override
	public String getUsername() {
		return getName();
	}
	//密码
	@Override
	public String getPassword() {
		return getPwd();
	}

	//用户账号是否过期
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	//用户账号是否被锁定
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	//用户密码是否过期
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	//用户是否可用
	@Override
	public boolean isEnabled() {
		return true;
	}
	//获得用户所有权限
	public Set<String>  getAllDams(){
		Set<String> damList=new TreeSet<String>();
		Set<DRModel> drsList=getAllDRs();
		Iterator<DRModel> iterator=drsList.iterator();
		while(iterator.hasNext()){
			DRModel _role=iterator.next();	
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

	
	
	//获得用户所有下属集
	public Set<UserModel> getAllSubordinates() {
		Set<UserModel> results=new TreeSet<UserModel>();
		results.add(this);
		if(getLeaderDepartments()!=null&&getLeaderDepartments().size()>0)
			for(DepartmentModel department:getLeaderDepartments()){
				if(department.getAllSubUsers()!=null&&department.getAllSubUsers().size()>0){
					for(UserModel user:department.getAllSubUsers()){
						if(!results.contains(user))results.add(user);
					}
				}
			}
		if(getMasterDepartments()!=null&&getMasterDepartments().size()>0)
			for(DepartmentModel department:getMasterDepartments()){
				if(department.getAllSubUsers()!=null&&department.getAllSubUsers().size()>0){
					for(UserModel user:department.getAllSubUsers()){
						if(!results.contains(user))results.add(user);
					}
				}
			}
		
		return results;
	}
	public Boolean hasSubordinateUser(String userId){
		Boolean has=false;
		Set<UserModel> subordinates=getAllSubordinates();
		for (UserModel subordinate:subordinates){
			if(subordinate.getId().equals(userId)){
				has=true;
				break;
			}
		}
		return has;
		
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

	public Set<DataAccessModeModel> getAuthorizations() {
		return authorizations;
	}
	public void setAuthorizations(Set<DataAccessModeModel> authorizations) {
		this.authorizations = authorizations;
	}
	
	public Set<DepartmentModel> getLeaderDepartments() {
		return leaderDepartments;
	}
	public void setLeaderDepartments(Set<DepartmentModel> leaderDepartments) {
		this.leaderDepartments = leaderDepartments;
	}
	public Set<DepartmentModel> getMasterDepartments() {
		return masterDepartments;
	}
	public void setMasterDepartments(Set<DepartmentModel> masterDepartments) {
		this.masterDepartments = masterDepartments;
	}
	public DRModel getMainDR() {
		return mainDR;
	}
	public void setMainDR(DRModel mainDR) {
		this.mainDR = mainDR;
	}
	public Set<DRModel> getDrs() {
		return drs;
	}
	public void setDrs(Set<DRModel> drs) {
		this.drs = drs;
	}
	public Boolean getHasTeachingRoleInMain() {
		return hasTeachingRoleInMain;
	}
	public void setHasTeachingRoleInMain(Boolean hasTeachingRoleInMain) {
		this.hasTeachingRoleInMain = hasTeachingRoleInMain;
	}
	public Boolean getHasTeachingRole() {
		return hasTeachingRole;
	}
	public void setHasTeachingRole(Boolean hasTeachingRole) {
		this.hasTeachingRole = hasTeachingRole;
	}
	
	public Boolean getHasRootDepartment() {
		return hasRootDepartment;
	}
	public void setHasRootDepartment(Boolean hasRootDepartment) {
		this.hasRootDepartment = hasRootDepartment;
	}
	
	
}
