package system.wlims.oa.entity;

import java.util.Date;

import system.wlims.oa.entity.BaseModel;

public class AttachmentModel extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3049622687536503053L;
	private String name;
	private String belongObject;
	private String belongObjectId;
	private String path;
	private String type;
	private String size;
	private Date date;

	public String getName() {
		return name;
	}
	public String getBelongObject() {
		return belongObject;
	}
	public void setBelongObject(String belongObject) {
		this.belongObject = belongObject;
	}
	public String getBelongObjectId() {
		return belongObjectId;
	}
	public void setBelongObjectId(String belongObjectId) {
		this.belongObjectId = belongObjectId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

}
