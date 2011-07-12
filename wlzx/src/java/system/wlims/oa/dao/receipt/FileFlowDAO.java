package system.wlims.oa.dao.receipt;

import java.util.List;

import system.BaseDAO;
import system.DAOException;
import system.wlims.oa.entity.receipt.FileFlowModel;
import system.wlims.oa.entity.receipt.ReceiptModel;

public interface FileFlowDAO extends BaseDAO<FileFlowModel> {


	/**
	 * 得到所有 某step的FileFlowModel list
	 * @param receipt
	 * @param step
	 * @return
	 * @throws DAOException
	 */
	List<FileFlowModel> getList(ReceiptModel receipt, Integer step)throws DAOException;
	
	/**
	 * 得到某步之前 所有 FileFlowModel List
	 * @param receipt
	 * @param maxStep
	 * @return
	 * @throws DAOException
	 */
	List<FileFlowModel> getAllBefore(ReceiptModel receipt, Integer maxStep)throws DAOException;
	
}
