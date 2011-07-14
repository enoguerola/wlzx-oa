package system.wlims.oa.entity.receipt;

import system.wlims.oa.entity.BaseModel;


/**
 * 收文管理 附件
 * @author Administrator
 *
 */
public class FileAttachmentModel extends BaseModel{

	private static final long serialVersionUID = -1404385406623147461L;

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
