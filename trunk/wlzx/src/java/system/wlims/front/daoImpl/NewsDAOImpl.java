package system.wlims.front.daoImpl;


import org.apache.log4j.Logger;

import system.BaseDAOImpl;
import system.wlims.front.dao.NewsDAO;
import system.wlims.front.entity.ModelNews;

public class NewsDAOImpl extends BaseDAOImpl<ModelNews> implements NewsDAO {
	
	private final static Logger logger = Logger.getLogger(NewsDAOImpl.class);
	
	
	public static Logger getLogger() {
		return logger;
	}

	
}
