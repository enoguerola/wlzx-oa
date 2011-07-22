/**
 * 
 */
package system.entity;

import java.util.Set;
import java.util.TreeSet;


  
  /**
 *
 * 类名称：DataAccessModeModel
 * 类描述：数据访问元模型--最小权限控制单元
 * 创建人：wuyuyue
 * 创建时间：2011-4-14 下午05:39:00
 * 修改人：wuyuyue
 * 修改时间：2011-4-14 下午05:39:00
 * 修改备注：
 * @version
 *
 */

public class DataAccessModeModel extends BaseModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6537176421866028228L;
	private String detail;
	private String value;
	private Boolean emptyFlag=true;
	private Set<OperationModel> operations=new TreeSet<OperationModel>();
	private Set<DepartmentModel> departments=new TreeSet<DepartmentModel>();
	private Set<RoleModel> roles=new TreeSet<RoleModel>();

	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Set<OperationModel> getOperations() {
		return operations;
	}
	public void setOperations(Set<OperationModel> operations) {
		this.operations = operations;
	}
	/** 
     * 获取数据访问方式所属操作
     * @创建时间 2011-4-15 上午10:41:15
     */ 
	public OperationModel getBelongOperation() {
		if(getOperations().iterator()!=null)
			return getOperations().iterator().next();
		else return null;
	}
	public Set<DepartmentModel> getDepartments() {
		return departments;
	}
	public void setDepartments(Set<DepartmentModel> departments) {
		this.departments = departments;
	}
	public Set<RoleModel> getRoles() {
		return roles;
	}
	public void setRoles(Set<RoleModel> roles) {
		this.roles = roles;
	}
	public Boolean getEmptyFlag() {
		return emptyFlag;
	}
	public void setEmptyFlag(Boolean emptyFlag) {
		this.emptyFlag = emptyFlag;
	}
}
