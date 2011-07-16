package system.wlims.oa.entity.receipt;

import java.sql.Date;

import system.wlims.oa.entity.notice.AttachmentModel;


/**
 * 收文管理 附件
 * @author Administrator
 *
 */
public class FileAttachmentModel extends AttachmentModel{

	private static final long serialVersionUID = -3310487104072829040L;
	private ReceiptModel receipt;
	private Date date;

	public void setReceipt(ReceiptModel receipt) {
		this.receipt = receipt;
	}

	public ReceiptModel getReceipt() {
		return receipt;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return date;
	}
}
