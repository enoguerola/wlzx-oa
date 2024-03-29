package system.wlims.oa.serviceImpl.notice;

import system.ServiceException;
import system.wlims.oa.dao.notice.AttachmentDAO;
import system.wlims.oa.entity.AttachmentModel;
import system.wlims.oa.service.notice.AttachmentService;

public class AttachmentServiceImpl implements AttachmentService {

	private AttachmentDAO attachmentDAO;

	@Override
	public void remove(String id) throws ServiceException {
		// TODO Auto-generated method stub
		attachmentDAO.remove(attachmentDAO.get(id));
	}

	@Override
	public void save(AttachmentModel model) throws ServiceException {
		// TODO Auto-generated method stub
		attachmentDAO.saveOrUpdate(model);
	}

	public void setAttachmentDAO(AttachmentDAO attachmentDAO) {
		this.attachmentDAO = attachmentDAO;
	}

	public AttachmentDAO getAttachmentDAO() {
		return attachmentDAO;
	}

}
