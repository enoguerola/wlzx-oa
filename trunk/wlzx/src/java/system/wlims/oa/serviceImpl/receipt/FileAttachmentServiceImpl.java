package system.wlims.oa.serviceImpl.receipt;


import system.ServiceException;
import system.wlims.oa.dao.receipt.FileAttachmentDAO;
import system.wlims.oa.entity.receipt.FileAttachmentModel;
import system.wlims.oa.service.receipt.FileAttachmentService;

public class FileAttachmentServiceImpl implements FileAttachmentService {

	private FileAttachmentDAO fileAttachmentDAO;

	@Override
	public void save(FileAttachmentModel model) throws ServiceException {
		// TODO Auto-generated method stub
		fileAttachmentDAO.saveOrUpdate(model);
	}

	public void setFileAttachmentDAO(FileAttachmentDAO fileAttachmentDAO) {
		this.fileAttachmentDAO = fileAttachmentDAO;
	}

	public FileAttachmentDAO getFileAttachmentDAO() {
		return fileAttachmentDAO;
	}

	@Override
	public FileAttachmentModel get(String id) throws ServiceException {
		// TODO Auto-generated method stub
		FileAttachmentModel model = fileAttachmentDAO.get(id);
		model.setReceipt(null);
		return model;
	}

	@Override
	public String remove(String id) throws ServiceException {
		// TODO Auto-generated method stub
		fileAttachmentDAO.remove(get(id));
		return id;
	}

}
