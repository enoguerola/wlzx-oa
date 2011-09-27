/**
 * 
 */
package system.entity;

import java.util.TreeSet;
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
	private Boolean teacherFlag=false;
	private Boolean basicFlag=false;
	private Set<DRModel> relativeDRs=new TreeSet<DRModel>();
	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}



	public Boolean getSupervisorFlag() {
		return supervisorFlag;
	}

	public void setSupervisorFlag(Boolean supervisorFlag) {
		this.supervisorFlag = supervisorFlag;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}



	public Boolean getBasicFlag() {
		return basicFlag;
	}

	public void setBasicFlag(Boolean basicFlag) {
		this.basicFlag = basicFlag;
	}
	public Set<UserModel> getAllUsers(){
		
		Set<UserModel> results=new TreeSet<UserModel>();
		for(DRModel dr:getRelativeDRs()){
			for(UserModel user:dr.getAllUsers()){
				if(!results.contains(user))
					results.add(user);
			}
		}
		return results;
		
	}

	public Set<DRModel> getRelativeDRs() {
		return relativeDRs;
	}
	
	public void setRelativeDRs(Set<DRModel> relativeDRs) {
		this.relativeDRs = relativeDRs;
	}

	public Boolean getTeacherFlag() {
		return teacherFlag;
	}

	public void setTeacherFlag(Boolean teacherFlag) {
		this.teacherFlag = teacherFlag;
	}

}
