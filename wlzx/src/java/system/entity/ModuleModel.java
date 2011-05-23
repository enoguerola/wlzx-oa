  
package system.entity;

import java.util.Set;
import java.util.TreeSet;

/**
*
* 类名称：ModuleModel
* 类描述：菜单模块模型
* 创建人：wuyuyue
* 创建时间：2011-4-14 下午05:17:25
* 修改人：wuyuyue
* 修改时间：2011-4-14 下午05:17:25
* 修改备注：
* @version
*
*/

public class ModuleModel extends BaseModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8940806580674257805L;
	private String detail;
	private String url;
	private Set<MenuModel> menus=new TreeSet<MenuModel>();//模块所属菜单功能集
	private Set<OperationModel> operations=new TreeSet<OperationModel>();//模块操作集
	private Set<ModuleModel> children=new TreeSet<ModuleModel>();//子模块集
	private Set<ModuleModel> parents=new TreeSet<ModuleModel>();//父模块集

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	public String getUrl(){
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Set<MenuModel> getMenus() {
		return menus;
	}

	public void setMenus(Set<MenuModel> menus) {
		this.menus = menus;
	}

	public Set<OperationModel> getOperations() {
		return operations;
	}

	public void setOperations(Set<OperationModel> operations) {
		this.operations = operations;
	}


	public Set<ModuleModel> getParents() {
		return parents;
	}

	public void setParents(Set<ModuleModel> parents) {
		this.parents = parents;
	}
	/** 
     * 获取模块所属功能菜单
     * @创建时间 2011-4-15 上午10:41:15
     */ 
	public MenuModel getBelongMenu() {
		if(getMenus().iterator()!=null)
			return getMenus().iterator().next();
		else return null;
	}
	/** 
     * 所属父亲模块
     * @创建时间 2011-4-15 上午10:41:15
     */ 
	public ModuleModel getBelongModule(){
		if(getParents().iterator()!=null)
			return getParents().iterator().next();
		else return null;
	}

	public Set<ModuleModel> getChildren() {
		return children;
	}

	public void setChildren(Set<ModuleModel> children) {
		this.children = children;
	}
	public Set<DataAccessModeModel> getDams(){
		Set<DataAccessModeModel> dams=new TreeSet<DataAccessModeModel>();
		for(OperationModel operation:operations){
			for(DataAccessModeModel dam:operation.getDataAccessModes()){
				dams.add(dam);
			}
		}
		return dams;
	}
}
