package system.wlims.oa.serviceImpl.notice;

import java.util.List;

import system.ServiceException;
import system.wlims.oa.dao.notice.AttachmentDAO;
import system.wlims.oa.entity.notice.AttachmentModel;
import system.wlims.oa.service.notice.AttachmentService;

public class AttachmentServiceImpl implements AttachmentService {

	private AttachmentDAO attachmentDAO;
	
	@Override
	public List<AttachmentModel> getAll(String noticeId)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(String id) throws ServiceException {
		// TODO Auto-generated method stub
		attachmentDAO.remove(id, AttachmentModel.class);
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
