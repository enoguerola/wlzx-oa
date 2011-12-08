package system.dao;



import system.BaseDAO;
import system.DAOException;
import system.PaginationSupport;
import system.entity.LogModel;


public interface LogDAO extends BaseDAO<LogModel>{

	public void addLog(LogModel log) throws DAOException;
	public PaginationSupport<LogModel> getLogsByCondition(String userId, String beginTime, String endTime, int index,
			int pageSize) ;
	
}
