
package system.entity;

import java.util.Set;
import java.util.TreeSet;

  /**
 *
 * 类名称：MenuModel
 * 类描述：系统菜单模型（系统功能模型）
 * 创建人：wuyuyue
 * 创建时间：2011-4-14 下午04:59:28
 * 修改人：wuyuyue
 * 修改时间：2011-4-14 下午04:59:28
 * 修改备注：
 * @version
 *
 */

public class MenuModel extends BaseModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6838421395568833220L;
	private String detail;
	private String menuIcon;
	private Set<SystemModel> systems=new TreeSet<SystemModel>();//功能菜单所属系统集
	private Set<ModuleModel> modules=new TreeSet<ModuleModel>();//功能菜单模块集
	private Set<MenuModel> children=new TreeSet<MenuModel>();//子功能菜单集
	private Set<MenuModel> parents=new TreeSet<MenuModel>();//父功能菜单集
	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Set<SystemModel> getSystems() {
		return systems;
	}

	public void setSystems(Set<SystemModel> systems) {
		this.systems = systems;
	}

	public Set<ModuleModel> getModules() {
		return modules;
	}

	public void setModules(Set<ModuleModel> modules) {
		this.modules = modules;
	}


	public Set<MenuModel> getParents() {
		return parents;
	}

	public void setParents(Set<MenuModel> parents) {
		this.parents = parents;
	}

	public Set<MenuModel> getChildren() {
		return children;
	}

	public void setChildren(Set<MenuModel> children) {
		this.children = children;
	}

	public String getMenuIcon() {
		return menuIcon;
	}

	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}

	public String getUrl() {
		if(modules!=null&&modules.size()>0){
			return getModules().iterator().next().getUrl();
		}
		else return null;
	}
	public MenuModel getParentMenu(){
		if(this.getParents()!=null&&this.getParents().size()>0){
			return this.getParents().iterator().next();
			
		}else return null;
		
	}
	public Set<DataAccessModeModel> getDams(){
		Set<DataAccessModeModel> dams=new TreeSet<DataAccessModeModel>();
		if(children==null||children.size()==0){
			for(ModuleModel module:modules){
				for(DataAccessModeModel dam:module.getDams()){
					dams.add(dam);
				}
			}
		}else {
			for(MenuModel menu:children){
				for(DataAccessModeModel dam:menu.getDams()){
					dams.add(dam);
				}
			}
		}
		
		return dams;
	}
	
}
