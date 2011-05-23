/**
 * 
 */
package system.entity;

import java.util.Set;
import java.util.TreeSet;



  
  /**
 *
 * 类名称：OperationModel
 * 类描述：模块操作模型
 * 创建人：wuyuyue
 * 创建时间：2011-4-14 下午05:35:06
 * 修改人：wuyuyue
 * 修改时间：2011-4-14 下午05:35:06
 * 修改备注：
 * @version
 *
 */

public class OperationModel extends BaseModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3083690818422837582L;
	private String rsValue;
	private String rsType;
	private String detail;
	private Set<ModuleModel> modules=new TreeSet<ModuleModel>();//操作所属模块集
	private Set<DataAccessModeModel> dataAccessModes=new TreeSet<DataAccessModeModel>();//操作数据访问方式集


	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Set<ModuleModel> getModules() {
		return modules;
	}
	public void setModules(Set<ModuleModel> modules) {
		this.modules = modules;
	}
	public Set<DataAccessModeModel> getDataAccessModes() {
		return dataAccessModes;
	}
	public void setDataAccessModes(Set<DataAccessModeModel> dataAccessModes) {
		this.dataAccessModes = dataAccessModes;
	}
	/** 
     * 获取操作所属模块
     * @创建时间 2011-4-15 上午10:41:15
     */ 
	public ModuleModel getBelongModule() {
		if(getModules().iterator()!=null)
			return getModules().iterator().next();
		else return null;
	}
	public String getRsValue() {
		return rsValue;
	}
	public void setRsValue(String rsValue) {
		this.rsValue = rsValue;
	}
	public String getRsType() {
		return rsType;
	}
	public void setRsType(String rsType) {
		this.rsType = rsType;
	}
	
	
	}
