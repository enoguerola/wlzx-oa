package system.wlims.basic.entity;

import java.util.Set;
import java.util.TreeSet;

import system.entity.BaseModel;
import system.entity.SystemModel;

public class DirectoryModel extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -917530983550918568L;
	private String value;
	private String type;
	private String description;
	private String extraValue;
	private Set<SystemModel> children=new TreeSet<SystemModel>();//子字典集
	private Set<SystemModel> parents=new TreeSet<SystemModel>();//父亲字典集 
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getExtraValue() {
		return extraValue;
	}
	public void setExtraValue(String extraValue) {
		this.extraValue = extraValue;
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
}
