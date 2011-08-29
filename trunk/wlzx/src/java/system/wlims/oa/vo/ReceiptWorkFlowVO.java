package system.wlims.oa.vo;

import java.util.Date;

public class ReceiptWorkFlowVO {
	private String receiptId;
	private String receiptFlowId;
	private String title;
	private String authorId;
	private Date inDate;
	private String office;
	private Integer status;
	
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

	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getReceiptId() {
		return receiptId;
	}
	public void setReceiptId(String receiptId) {
		this.receiptId = receiptId;
	}
	public String getReceiptFlowId() {
		return receiptFlowId;
	}
	public void setReceiptFlowId(String receiptFlowId) {
		this.receiptFlowId = receiptFlowId;
	}
	public Date getInDate() {
		return inDate;
	}
	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}

}
