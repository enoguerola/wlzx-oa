package system.wlims.oa.serviceImpl.receipt;

import system.wlims.oa.dao.receipt.FileFlowDAO;
import system.wlims.oa.service.receipt.FileFlowService;

public class FileFlowServiceImpl implements FileFlowService {

	private FileFlowDAO fileFlowDAO;

	public void setFileFlowDAO(FileFlowDAO fileFlowDAO) {
		this.fileFlowDAO = fileFlowDAO;
	}

	public FileFlowDAO getFileFlowDAO() {
		return fileFlowDAO;
	}
	
}
