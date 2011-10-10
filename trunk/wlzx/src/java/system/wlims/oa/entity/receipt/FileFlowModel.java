package system.wlims.oa.entity.receipt;

import java.util.Date;

import system.wlims.basic.entity.BaseModel;

/**
 * 文件流转
 * @author Administrator
 *
 */
public class FileFlowModel extends BaseModel {

	private static final long serialVersionUID = 1122933345808995996L;
//	private Integer type;
//	private Integer isCompleted;
//	private String text;
//	private Integer step;
//	private Date completedDate;
//	
//	private String user;
//	private String department;
//	private ReceiptModel receipt;
//	
//	public static enum EType{
//		DeviseHandling(0, "拟办"),
//		RatifyHandling(1, "批示"),
//		Undertake(2, "承办"),
//		Circulate(3, "传阅");
//		
//		private int value;
//		private String text;
//		
//		EType(int value, String text){
//			this.value = value;
//			this.text = text;
//		}
//		
//		public Integer getValue(){
//			return value;
//		}
//		
//		public String getText(){
//			return this.text;
//		}
//	}
//
//	public Integer getType() {
//		return type;
//	}
//
//	public void setType(Integer type) {
//		this.type = type;
//	}
//
//	public Integer getIsCompleted() {
//		return isCompleted;
//	}
//
//	public void setIsCompleted(Integer isCompleted) {
//		this.isCompleted = isCompleted;
//	}
//
//	public String getText() {
//		return text;
//	}
//
//	public void setText(String text) {
//		this.text = text;
//	}
//
//	public Integer getStep() {
//		return step;
//	}
//
//	public void setStep(Integer step) {
//		this.step = step;
//	}
//
//	public ReceiptModel getReceipt() {
//		return receipt;
//	}
//
//	public void setReceipt(ReceiptModel receipt) {
//		this.receipt = receipt;
//	}
//
//	public static long getSerialversionuid() {
//		return serialVersionUID;
//	}
//
//	public void setUser(String user) {
//		this.user = user;
//	}
//
//	public String getUser() {
//		return user;
//	}
//
//	public void setDepartment(String department) {
//		this.department = department;
//	}
//
//	public String getDepartment() {
//		return department;
//	}
//
//	public void setCompletedDate(Date completedDate) {
//		this.completedDate = completedDate;
//	}
//
//	public Date getCompletedDate() {
//		return completedDate;
//	}
	private Integer type;
	private Integer isCompleted;
	private String text;
	private Date completedDate;


	private Date creationDate;
	private String user;
	private String receiptId;	
	private ReceiptModel receipt;
	public static enum EType{
		Draft(0, "收文登记 "),
		DeviseHandling(2, "收文拟办"),
		RatifyHandling(4, "收文批办"),
		Undertakeing(6, "收文承办"),
		Circulateing(8, "收文传阅");
		
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

	public ReceiptModel getReceipt() {
		return receipt;
	}

	public void setReceipt(ReceiptModel receipt) {
		this.receipt = receipt;
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

	public String getReceiptId() {
		return receiptId;
	}

	public void setReceiptId(String receiptId) {
		this.receiptId = receiptId;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date date) {
		this.creationDate = date;
	}
}
