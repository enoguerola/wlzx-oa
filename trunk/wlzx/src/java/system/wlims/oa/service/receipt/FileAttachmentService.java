package system.wlims.oa.service.receipt;


import system.ServiceException;
import system.wlims.oa.entity.receipt.FileAttachmentModel;


public interface FileAttachmentService {

	/**
	 * 
	 * @param model
	 * @throws ServiceException
	 */
	public void save(FileAttachmentModel model)throws ServiceException;
	
	/**
	 * 
	 * @param id
	 * @throws ServiceException
	 */
	//public void remove(String id)throws ServiceException;

}
