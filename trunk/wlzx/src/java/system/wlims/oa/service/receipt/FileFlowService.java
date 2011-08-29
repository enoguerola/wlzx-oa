package system.wlims.oa.service.receipt;

import java.util.List;

import system.ServiceException;
import system.wlims.basic.vo.UserAddressVo;
import system.wlims.oa.entity.receipt.FileFlowModel;
import system.wlims.oa.entity.receipt.ReceiptModel;



public interface FileFlowService {
	
//	/**
//	 * 
//	 * @param receiptId
//	 * @param userIdList
//	 * @param update
//	 * @param type
//	 * @throws ServiceException
//	 */
//	void save(String receiptId, String userIdList, boolean update, int type)throws ServiceException;
//	
//	/**
//	 * 得到所有
//	 * @param receiptId
//	 * @return
//	 * @throws ServiceException
//	 */
//	List<FileFlowModel> getAllList(String receiptId)throws ServiceException;
//	
//	/**
//	 * 
//	 * @param receipt
//	 * @return
//	 * @throws ServiceException
//	   得到当前或上次的FileFlowModel list
//	 */
//	List<FileFlowModel> getList(ReceiptModel receipt)throws ServiceException;
//	
//	/**
//	 * 
//	 * @param receiptId
//	 * @return
//	 * @throws ServiceException
//	 * 得到某环节 FileFlowModel list
//	 */
//	List<FileFlowModel> getList(String receiptId, Integer step)throws ServiceException;
//	
//	/**
//	 * 
//	 * @param model
//	 * @throws ServiceException
//	 */
//	void remove(FileFlowModel model)throws ServiceException;
//	
//	/**
//	 * 
//	 * @param id
//	 * @throws ServiceException
//	 */
//	void remove(String id)throws ServiceException;
//	
//	/**
//	 * 
//	 * @param id
//	 * @return
//	 * @throws ServiceException
//	 */
//	FileFlowModel get(String id)throws ServiceException;
//	
//	/**
//	 * 
//	 * @param model
//	 * @param type
//	 * @param step
//	 * @param user
//	 * @throws ServiceException
//	 */
//	void save(ReceiptModel model, Integer type, Integer step, String user)throws ServiceException;
//	
//	/**
//	 * 
//	 * @param model
//	 * @throws ServiceException
//	 */
//	void update(FileFlowModel model)throws ServiceException;
//	
//	/**
//	 * @description 得到上一环节的所有老师
//	 * @param receiptId
//	 * @return
//	 * @throws ServiceException
//	 */
//	List<UserAddressVo> getTeacher(String receiptId)throws ServiceException;
//	
//	FileFlowModel save(String id, String text, Integer isCompleted)throws ServiceException;
}
