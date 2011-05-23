
  /**
  * 文件名：SystemModel.java
  *
  * 版本信息：
  * 日期：2011-4-14
  * Copyright CHIMO Corporation 2011
  * 版权所有
  *
  */
  
package system.entity;

import java.util.Set;
import java.util.TreeSet;


  
  /**
 *
 * 项目名称：wlzx
 * 类名称：SystemModel
 * 类描述：系统模型
 * 创建人：wuyuyue
 * 创建时间：2011-4-14 下午04:57:15
 * 修改人：wuyuyue
 * 修改时间：2011-4-14 下午04:57:15
 * 修改备注：
 * @version
 *
 */

public class SystemModel extends BaseModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7218943086876550862L;
	private String detail;
	private String indexPath;
	private String systemIcon;
	private Set<MenuModel> menus=new TreeSet<MenuModel>();//系统功能菜单集
	private Set<SystemModel> children=new TreeSet<SystemModel>();//子系统集
	private Set<SystemModel> parents=new TreeSet<SystemModel>();//父亲系统集
	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Set<MenuModel> getMenus() {
		return menus;
	}

	public void setMenus(Set<MenuModel> menus) {
		this.menus = menus;
	}

	public Set<SystemModel> getChildren() {
		return children;
	}

	public void setChildren(Set<SystemModel> children) {
		this.children = children;
	}

	public Set<SystemModel> getParents() {
		return parents;
	}

	public void setParents(Set<SystemModel> parents) {
		this.parents = parents;
	}
	/** 
     * 所属父亲系统
     * @创建时间 2011-4-15 上午10:41:15
     */ 
	public SystemModel getBelongSystem(){
		if(getParents().iterator()!=null)
			return getParents().iterator().next();
		else return null;
	}

	public String getIndexPath() {
		return indexPath;
	}

	public void setIndexPath(String indexPath) {
		this.indexPath = indexPath;
	}

	public String getSystemIcon() {
		return systemIcon;
	}

	public void setSystemIcon(String systemIcon) {
		this.systemIcon = systemIcon;
	}
	public Set<DataAccessModeModel> getDams(){
		
		Set<DataAccessModeModel> dams=new TreeSet<DataAccessModeModel>();
		if(children==null||children.size()==0){
			for(MenuModel menu:menus){
				for(DataAccessModeModel dam:menu.getDams()){
					dams.add(dam);
				}
			}
		}else {
			for(SystemModel system:children){
				for(DataAccessModeModel dam:system.getDams()){
					dams.add(dam);
				}
			}
		}
		return dams;
	}

	
}
