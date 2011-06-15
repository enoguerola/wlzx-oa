package system.wlims.oa.entity.notice;

import system.wlims.oa.entity.BaseModel;

public class AttachmentModel extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3049622687536503053L;
	private String name;
	private String path;
	private String type;
	public String getName() {
		return name;
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
}
