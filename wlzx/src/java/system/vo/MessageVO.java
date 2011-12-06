
package system.vo;

import java.util.Date;



public class MessageVO{
	private String id;
	private String fromId;//0表示系统消息
	private String toIds;
	private int type;
	private String readFlag;
	private String content;
	private Date creationDate;
	private String readDate;
	private String linkObjectType;
	private String linkObjectId;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFromId() {
		return fromId;
	}
	public void setFromId(String fromId) {
		this.fromId = fromId;
	}
	public String getToIds() {
		return toIds;
	}
	public void setToIds(String toIds) {
		this.toIds = toIds;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getReadFlag() {
		return readFlag;
	}
	public void setReadFlag(String readFlag) {
		this.readFlag = readFlag;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public String getReadDate() {
		return readDate;
	}
	public void setReadDate(String readDate) {
		this.readDate = readDate;
	}
	public String getLinkObjectType() {
		return linkObjectType;
	}
	public void setLinkObjectType(String linkObjectType) {
		this.linkObjectType = linkObjectType;
	}
	public String getLinkObjectId() {
		return linkObjectId;
	}
	public void setLinkObjectId(String linkObjectId) {
		this.linkObjectId = linkObjectId;
	}
	
}
