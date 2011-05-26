package system.wlims.basic.serviceImpl;

import system.wlims.basic.dao.DirectoryDao;
import system.wlims.basic.service.DirectoryService;

public class DirectoryServiceImpl implements DirectoryService {
	private DirectoryDao directoryDao;

	public DirectoryDao getDirectoryDao() {
		return directoryDao;
	}

	public void setDirectoryDao(DirectoryDao directoryDao) {
		this.directoryDao = directoryDao;
	}
}
