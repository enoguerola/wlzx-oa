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
	private Set<UserModel> leaderUsers=new TreeSet<UserModel>();//直属领导用户集
	private Set<UserModel> masterUsers=new TreeSet<UserModel>();//部门主管用户集
	
	private Set<DRModel> relativeDRs=new TreeSet<DRModel>();
	
	
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


	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Set<UserModel> getLeaderUsers() {
		return leaderUsers;
	}

	public void setLeaderUsers(Set<UserModel> leaderUsers) {
		this.leaderUsers = leaderUsers;
	}

	public Set<UserModel> getMasterUsers() {
		return masterUsers;
	}

	public void setMasterUsers(Set<UserModel> masterUsers) {
		this.masterUsers = masterUsers;
	}
	//获得所有子部门
	public Set<DepartmentModel> getAllSubordinates() {
		Set<DepartmentModel> results=new TreeSet<DepartmentModel>();
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

	public Set<DRModel> getRelativeDRs() {
		return relativeDRs;
	}

	public void setRelativeDRs(Set<DRModel> relativeDRs) {
		this.relativeDRs = relativeDRs;
	}
	public Set<UserModel> getSelfUsers(){
		Set<UserModel> results=new TreeSet<UserModel>();
		
		for(DRModel dr:getRelativeDRs()){
			for(UserModel user:dr.getAllUsers()){
				if(!results.contains(user))
					results.add(user);
			}
		}
		return results;
		
	}
	
	public Set<UserModel> getAllUsers(){
		
		Set<UserModel> results=new TreeSet<UserModel>();
		 Set<DepartmentModel> allSubDepartments=getAllSubordinates();
		 for(DepartmentModel department:allSubDepartments)
			for(DRModel dr:department.getRelativeDRs()){
				for(UserModel user:dr.getAllUsers()){
					if(!results.contains(user))
						results.add(user);
				}
			}
		return results;
		
	}



	
	
	

}
