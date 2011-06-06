
package system.entity;

import java.util.Date;

  /**
 *
 * 类名称：MenuModel
 * 类描述：短消息模型
 * 创建人：wuyuyue
 * 创建时间：2011-4-14 下午04:59:28
 * 修改人：wuyuyue
 * 修改时间：2011-4-14 下午04:59:28
 * 修改备注：
 * @version
 *
 */

public class MessageModel extends SimpleBaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1845573306963128881L;
	/**
	 * 
	 */
	private UserModel from;
	private UserModel to;
	private int type;
	private int status;
	private String content;
	private Date creationDate;
	private Date readDate;
	public static enum MessageType{
		SYSTEM(0, "系统消息");
		private int value;
		private String name;
		
		private MessageType(int value, String name){
			this.setValue(value);
			this.setName(name);
		}

		public void setValue(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
		public void setName(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}
	public static enum MessageStatus{
		NOT_READ(0, "未读"),
		ALREADY_READ(1, "已读");
		private int value;
		private String name;
		
		private MessageStatus(int value, String name){
			this.setValue(value);
			this.setName(name);
		}

		public void setValue(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
		public void setName(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}

	public UserModel getFrom() {
		return from;
	}
	public void setFrom(UserModel from) {
		this.from = from;
	}
	public UserModel getTo() {
		return to;
	}
	public void setTo(UserModel to) {
		this.to = to;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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
	public Date getReadDate() {
		return readDate;
	}
	public void setReadDate(Date readDate) {
		this.readDate = readDate;
	}
	
}
