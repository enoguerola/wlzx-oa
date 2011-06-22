package system.wlims.oa.entity.notice;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import system.wlims.oa.entity.BaseModel;

public class NoticeModel extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6086368109701704282L;
	private Integer scope;
	private String type;
	private String postDepartmentId;
	private String posterId;
	private Integer emergence;
	private String title;
	private String content;
	private Date postTime;
	private String lastEditorId;
	private Date lastEditTime;
	private Set<AttachmentModel> attachments=new TreeSet<AttachmentModel>(); 
	private Integer status;
	
	public static enum EScope{
		School(0, "校级公告"),
		Department(1, "部门公告");
		
		private Integer value;
		private String text;
		
		EScope(Integer value, String text){
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
	
	public static enum EStatus{
		Draft(0, "草稿"),
		Published(1, "已发布");
		
		private Integer value;
		private String text;
		
		EStatus(Integer value, String text){
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
	
	public Integer getScope() {
		return scope;
	}
	public void setScope(Integer scope) {
		this.scope = scope;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPostDepartmentId() {
		return postDepartmentId;
	}
	public void setPostDepartmentId(String postDepartmentId) {
		this.postDepartmentId = postDepartmentId;
	}
	public String getPosterId() {
		return posterId;
	}
	public void setPosterId(String posterId) {
		this.posterId = posterId;
	}
	public Integer getEmergence() {
		return emergence;
	}
	public void setEmergence(Integer emergence) {
		this.emergence = emergence;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getPostTime() {
		return postTime;
	}
	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}
	public String getLastEditorId() {
		return lastEditorId;
	}
	public void setLastEditorId(String lastEditorId) {
		this.lastEditorId = lastEditorId;
	}
	public Date getLastEditTime() {
		return lastEditTime;
	}
	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}
	public Set<AttachmentModel> getAttachments() {
		return attachments;
	}
	public void setAttachments(Set<AttachmentModel> attachments) {
		this.attachments = attachments;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getStatus() {
		return status;
	}
}
