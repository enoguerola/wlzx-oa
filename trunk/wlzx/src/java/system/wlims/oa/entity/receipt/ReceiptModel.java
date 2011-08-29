package system.wlims.oa.entity.receipt;

import java.sql.Date;
import java.util.Set;


import system.wlims.basic.entity.BaseModel;
import system.wlims.oa.entity.notice.AttachmentModel;
import system.wlims.oa.entity.receipt.FileFlowModel;

/**
 * 收文
 * @author Administrator
 *
 */
public class ReceiptModel extends BaseModel {

	private static final long serialVersionUID = -6408314329607076972L;
	private String doNumber;
	private String office;
	private String inNumber;
	private Date inDate;
	private String subject;
	private String title;
	private String summary;
	private Integer status;
	private Integer isCompleted;
	private Date registedDate;
	private String receiverId;
	private Set<AttachmentModel> attachments;
	private Set<FileFlowModel> fileFlows;
	public static enum EStatus{
		Draft(0, "草稿"),
		Register(1, "已登记"),
		DeviseHandling(2, "拟办中"),
		DeviseHandled(3, "拟办完毕"),
		RatifyHandling(4, "批办中"),
		RatifyHandled(5, "批办完毕"),
		Undertakeing(6, "承办中"),
		Undertaked(7, "承办完毕"),
		Circulateing(8, "传阅中"),
		Circulated(9, "传阅完毕");
		
		private int value;
		private String text;
		
		EStatus(int value, String text){
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

	public String getDoNumber() {
		return doNumber;
	}

	public void setDoNumber(String doNumber) {
		this.doNumber = doNumber;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public String getInNumber() {
		return inNumber;
	}

	public void setInNumber(String inNumber) {
		this.inNumber = inNumber;
	}


	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(Integer isCompleted) {
		this.isCompleted = isCompleted;
	}

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}

	public Date getInDate() {
		return inDate;
	}

	public void setRegistedDate(Date registedDate) {
		this.registedDate = registedDate;
	}

	public Date getRegistedDate() {
		return registedDate;
	}

	public Set<AttachmentModel> getAttachments() {
		return attachments;
	}

	public void setAttachments(Set<AttachmentModel> attachments) {
		this.attachments = attachments;
	}

	public String getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}

	public Set<FileFlowModel> getFileFlows() {
		return fileFlows;
	}

	public void setFileFlows(Set<FileFlowModel> fileFlows) {
		this.fileFlows = fileFlows;
	}

	public boolean thisStateIsAllDealed(Integer type) {
		boolean result=true;
		if(fileFlows!=null&&fileFlows.size()>0){
			for(FileFlowModel file:fileFlows){
				if(file.getType().intValue()==type.intValue()){
					if(file.getIsCompleted()==null)result=false;
				}
			}

		}
		return result;
	}
	
	
	
}
