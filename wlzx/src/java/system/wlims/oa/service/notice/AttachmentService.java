package system.wlims.oa.service.notice;


import system.ServiceException;
import system.wlims.oa.entity.AttachmentModel;

public interface AttachmentService {

	/**
	 * 
	 * @param model
	 * @throws ServiceException
	 */
	public void save(AttachmentModel model)throws ServiceException;
	
	/**
	 * 
	 * @param id
	 * @throws ServiceException
	 */
	public void remove(String id)throws ServiceException;
	
	
}
