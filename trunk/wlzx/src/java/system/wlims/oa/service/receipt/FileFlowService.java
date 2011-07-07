package system.wlims.oa.service.receipt;

import java.util.List;

import system.ServiceException;
import system.wlims.basic.vo.UserAddressVo;
import system.wlims.oa.entity.receipt.FileFlowModel;
import system.wlims.oa.entity.receipt.ReceiptModel;



public interface FileFlowService {
	
	/**
	 * 
	 * @param receiptId
	 * @param userIdList
	 * @param update
	 * @param type
	 * @throws ServiceException
	 */
	void save(String receiptId, String userIdList, boolean update, int type)throws ServiceException;
	
	/**
	 * 
	 * @param receipt
	 * @return
	 * @throws ServiceException

	 */
	List<FileFlowModel> getList(ReceiptModel receipt)throws ServiceException;
	
	/**
	 * 
	 * @param receiptId
	 * @return
	 * @throws ServiceException
	 */
	List<FileFlowModel> getList(String receiptId)throws ServiceException;
	
	/**
	 * 
	 * @param model
	 * @throws ServiceException
	 */
	void remove(FileFlowModel model)throws ServiceException;
	
	/**
	 * 
	 * @param id
	 * @throws ServiceException
	 */
	void remove(String id)throws ServiceException;
	
	/**
	 * 
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	FileFlowModel get(String id)throws ServiceException;
	
	/**
	 * 
	 * @param model
	 * @param type
	 * @param step
	 * @param user
	 * @throws ServiceException
	 */
	void save(ReceiptModel model, Integer type, Integer step, String user)throws ServiceException;
	
	/**
	 * 
	 * @param model
	 * @throws ServiceException
	 */
	void update(FileFlowModel model)throws ServiceException;
	
	List<UserAddressVo> getTeacher(String receiptId)throws ServiceException;
}
