package system.wlims.oa.entity.sendingFiles;

import java.sql.Date;

import system.wlims.oa.entity.BaseModel;


/**
 * 收文管理 附件
 * @author Administrator
 *
 */
public class FileAttachmentModel extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8555235599899575500L;
	private String name;
	private String path;
	private String type;
	private String size;
	private SendingFileModel sendingFile;
	private Date date;

	

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public SendingFileModel getSendingFile() {
		return sendingFile;
	}

	public void setSendingFile(SendingFileModel sendingFile) {
		this.sendingFile = sendingFile;
	}

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

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
}
