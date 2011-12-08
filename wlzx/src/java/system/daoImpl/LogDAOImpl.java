package system.daoImpl;




import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import system.BaseDAOImpl;
import system.DAOException;
import system.PaginationSupport;
import system.dao.LogDAO;
import system.entity.LogModel;
import system.utils.StringUtils;


public class LogDAOImpl extends BaseDAOImpl<LogModel> implements LogDAO{

	public void addLog(LogModel log) throws DAOException {
		// TODO Auto-generated method stub
		this.getSession().saveOrUpdate(log);
		this.getSession().flush();
	}

	public PaginationSupport<LogModel> getLogsByCondition(String userId, String beginTime, String endTime, int index,
			int pageSize) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(LogModel.class);
		
		if(StringUtils.isNotEmpty(userId)){
			criteria.add(Restrictions.eq("user", userId));
		}
		if(StringUtils.isNotEmpty(beginTime))
			criteria.add(Restrictions.sqlRestriction("operation_time >= '"+beginTime+" 00:00:00'"));
			
		if(StringUtils.isNotEmpty(endTime))
			criteria.add(Restrictions.sqlRestriction("operation_time <= '"+endTime+" 23:59:59'"));
		criteria.addOrder(Order.desc("operationTime"));
		return  this.findPageByCriteria(criteria, pageSize, index);
	}
	
}
