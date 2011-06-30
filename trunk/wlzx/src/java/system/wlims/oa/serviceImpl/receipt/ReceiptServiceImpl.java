package system.wlims.oa.serviceImpl.receipt;

import system.wlims.oa.dao.receipt.ReceiptDAO;
import system.wlims.oa.service.receipt.ReceiptService;

public class ReceiptServiceImpl implements ReceiptService {

	private ReceiptDAO receiptDAO;

	public void setReceiptDAO(ReceiptDAO receiptDAO) {
		this.receiptDAO = receiptDAO;
	}

	public ReceiptDAO getReceiptDAO() {
		return receiptDAO;
	}
}
