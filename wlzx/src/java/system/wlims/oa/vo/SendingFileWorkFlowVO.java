package system.wlims.oa.vo;

import java.util.Date;

public class SendingFileWorkFlowVO {
	private String sendingFileId;
	private String sendingFileFlowId;
	private String title;
	private String authorId;
	private Date creationDate;
	private String auspiceDepartment;
	private Integer status;
	public String getSendingFileId() {
		return sendingFileId;
	}
	public void setSendingFileId(String sendingFileId) {
		this.sendingFileId = sendingFileId;
	}
	public String getSendingFileFlowId() {
		return sendingFileFlowId;
	}
	public void setSendingFileFlowId(String sendingFileFlowId) {
		this.sendingFileFlowId = sendingFileFlowId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthorId() {
		return authorId;
	}
	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public String getAuspiceDepartment() {
		return auspiceDepartment;
	}
	public void setAuspiceDepartment(String auspiceDepartment) {
		this.auspiceDepartment = auspiceDepartment;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

}
