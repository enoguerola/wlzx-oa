package system.wlims.front.serviceImpl;


import org.apache.log4j.Logger;

import system.wlims.front.dao.NewsDAO;
import system.wlims.front.service.NewsService;

public class NewsServiceImpl implements NewsService {
	
	private final static Logger logger = Logger.getLogger(NewsServiceImpl.class);
	

	private NewsDAO trainDAO;
	
	
	public static Logger getLogger() {
		return logger;
	}


	public NewsDAO getTrainDAO() {
		return trainDAO;
	}


	public void setTrainDAO(NewsDAO trainDAO) {
		this.trainDAO = trainDAO;
	}

}
