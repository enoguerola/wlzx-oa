package system.wlims.oa.dao.receipt;

import java.util.List;

import system.BaseDAO;
import system.wlims.oa.entity.receipt.ReceiptModel;

public interface ReceiptDAO extends BaseDAO<ReceiptModel> {

	List<ReceiptModel> getByConditions(String inNumber, String office,
			String doNumber, String title, String subject, String summary, String beginDate, String endDate,
			String states, Integer isCompleted);

}
