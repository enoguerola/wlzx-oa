package system.service;

import system.ServiceException;
import system.PaginationSupport;
import system.entity.LogModel;



public interface LogService{
	/**
	 * 查询满足条件的日志列表
	 * @return
	 */
	PaginationSupport<LogModel> getLogsByCondition(String userId,String beginTime,String endTime,int index,int pageSize)throws ServiceException;

}

