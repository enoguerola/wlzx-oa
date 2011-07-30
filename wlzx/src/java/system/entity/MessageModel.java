
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
	private String fromId;//0表示系统消息
	private String toIds;
	private int type;
	private String readFlags;
	private String content;
	private Date creationDate;
	private String readDates;
	private String postRemovedFlag;
	private String receiveRemovedFlags;
	public static enum MessageType{
		SYSTEM(0, "系统消息"),
		Person(1, "个人消息");
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
	public static enum MessageRemoveFlag{
		NotRemoved(0, "未删除"),
		Removed(1, "已删除");
		private int value;
		private String name;
		
		private MessageRemoveFlag(int value, String name){
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

	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
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
	public String getPostRemovedFlag() {
		return postRemovedFlag;
	}
	public void setPostRemovedFlag(String postRemovedFlag) {
		this.postRemovedFlag = postRemovedFlag;
	}
	public String getReceiveRemovedFlags() {
		return receiveRemovedFlags;
	}
	public void setReceiveRemovedFlags(String receiveRemovedFlags) {
		this.receiveRemovedFlags = receiveRemovedFlags;
	}
	public String getRemovedFlagByUserId(String userId){
		String[] toIdsAttr=toIds.split(";");
		String[] receiveRemovedFlagsAttr= receiveRemovedFlags.split(";");
		for(int i=0;i<toIdsAttr.length;i++){
			if(toIdsAttr[i].equals(userId)){
				return receiveRemovedFlagsAttr[i];
			}
		}
		return null;
	}
	public void setRemoveFlagByUserId(String state,String userId){
		String[] toIdsAttr=toIds.split(";");
		String[] receiveRemovedFlagsAttr= receiveRemovedFlags.split(";");
		for(int i=0;i<toIdsAttr.length;i++){
			if(toIdsAttr[i].equals(userId)){
				String result="";
				for(int j=0;j<i;j++){
					result+=receiveRemovedFlagsAttr[j]+";";
				}
				result+=state+";";
				for(int k=i+1;k<receiveRemovedFlagsAttr.length;k++){
					result+=receiveRemovedFlagsAttr[k]+";";
				}
				setReceiveRemovedFlags(result);
			}
		}
		
	}
	public boolean toIdsContains(String userId){
		String[] toIdsAttr=toIds.split(";");
		for(int i=0;i<toIdsAttr.length;i++){
			if(toIdsAttr[i].equals(userId)){
				return true;
			}
		}
		return false;
	}
	public String getReadFlagByUserId(String userId){
		String[] toIdsAttr=toIds.split(";");
		String[] readFlagsAttr= readFlags.split(";");
		for(int i=0;i<toIdsAttr.length;i++){
			if(toIdsAttr[i].equals(userId)){
				return readFlagsAttr[i];
			}
		}
		return null;
	}
	public void setReadFlagByUserId(String state,String userId){
		String[] toIdsAttr=toIds.split(";");
		String[] readFlagsAttr= readFlags.split(";");
		for(int i=0;i<toIdsAttr.length;i++){
			if(toIdsAttr[i].equals(userId)){
				String result="";
				for(int j=0;j<i;j++){
					result+=readFlagsAttr[j]+";";
				}
				result+=state+";";
				for(int k=i+1;k<readFlagsAttr.length;k++){
					result+=readFlagsAttr[k]+";";
				}
				setReadFlags(result);
			}
		}
		
	}
	public String getReadDateByUserId(String userId){
		String[] toIdsAttr=toIds.split(";");
		String[] readDatesAttr= readDates.split(";");
		for(int i=0;i<toIdsAttr.length;i++){
			if(toIdsAttr[i].equals(userId)){
				return readDatesAttr[i];
			}
		}
		return null;
	}
	public void setReadDateByUserId(String date,String userId){
		String[] toIdsAttr=toIds.split(";");
		String[] readDatesAttr= readDates.split(";");
		for(int i=0;i<toIdsAttr.length;i++){
			if(toIdsAttr[i].equals(userId)){
				String result="";
				for(int j=0;j<i;j++){
					result+=readDatesAttr[j]+";";
				}
				result+=date+";";
				for(int k=i+1;k<readDatesAttr.length;k++){
					result+=readDatesAttr[k]+";";
				}
				setReadDates(result);
			}
		}
		
	}
	public String getReadFlags() {
		return readFlags;
	}
	public void setReadFlags(String readFlags) {
		this.readFlags = readFlags;
	}
	public String getReadDates() {
		return readDates;
	}
	public void setReadDates(String readDates) {
		this.readDates = readDates;
	}
}
