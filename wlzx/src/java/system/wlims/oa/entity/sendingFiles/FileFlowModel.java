package system.wlims.oa.entity.sendingFiles;

import java.util.Date;

import system.wlims.basic.entity.BaseModel;

/**
 * 文件流转
 * @author Administrator
 *
 */
public class FileFlowModel extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3566529782819796081L;
	private Integer type;
	private Integer isCompleted;
	private String text;
	private Date completedDate;
	private Date creationDate;
	private String user;
	private String sendingFileId;	
	public static enum EType{
		Draft(0, "发文拟稿"),
		CheckDraft(2, "发文核稿"),
		CounterSign(4, "发文会签"),
		Issue(6, "发文签发"),
		Circulate(8, "发文传阅");
		
		private int value;
		private String text;
		
		EType(int value, String text){
			this.value = value;
			this.text = text;
		}
		
		public Integer getValue(){
			return value;
		}
		
		public String getText(){
			return this.text;
		}
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(Integer isCompleted) {
		this.isCompleted = isCompleted;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}


	public void setUser(String user) {
		this.user = user;
	}

	public String getUser() {
		return user;
	}


	public void setCompletedDate(Date completedDate) {
		this.completedDate = completedDate;
	}

	public Date getCompletedDate() {
		return completedDate;
	}

	public String getSendingFileId() {
		return sendingFileId;
	}

	public void setSendingFileId(String sendingFileId) {
		this.sendingFileId = sendingFileId;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	

}
