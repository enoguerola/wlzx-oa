package system.serviceImpl;





import org.apache.log4j.Logger;

import system.PaginationSupport;
import system.ServiceException;
import system.dao.LogDAO;
import system.entity.LogModel;
import system.service.LogService;



public class LogServiceImpl implements LogService{
	private static final Logger log = Logger.getLogger(LogServiceImpl.class);
	private LogDAO logDAO;
	public LogDAO getLogDAO() {
		return logDAO;
	}
	public void setLogDAO(LogDAO logDAO) {
		this.logDAO = logDAO;
	}
	public static Logger getLog() {
		return log;
	}
	
	public PaginationSupport<LogModel> getLogsByCondition(String userId, String beginTime, String endTime, int index,
			int pageSize) throws ServiceException {
		// TODO Auto-generated method stub
		return logDAO.getLogsByCondition( userId, beginTime, endTime, index, pageSize);
	}



}
