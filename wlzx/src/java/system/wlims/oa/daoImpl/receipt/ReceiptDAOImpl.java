package system.wlims.oa.daoImpl.receipt;


import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import system.BaseDAOImpl;
import system.utils.StringUtils;
import system.wlims.oa.dao.receipt.ReceiptDAO;
import system.wlims.oa.entity.receipt.FileFlowModel;
import system.wlims.oa.entity.receipt.ReceiptModel;

public class ReceiptDAOImpl extends BaseDAOImpl<ReceiptModel> implements ReceiptDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<ReceiptModel> getByConditions(String inNumber, String office,
			String doNumber, String title, String subject, String summary, String beginDate, String endDate,
			String states, Integer isCompleted) {
			DetachedCriteria criteria = DetachedCriteria.forClass(ReceiptModel.class);
			if(StringUtils.isNotEmpty(inNumber))
				criteria.add(Restrictions.ilike("inNumber", inNumber, MatchMode.ANYWHERE));
			
			if(StringUtils.isNotEmpty(doNumber))
				criteria.add(Restrictions.ilike("doNumber", doNumber, MatchMode.ANYWHERE));
			
			if(StringUtils.isNotEmpty(states))
				criteria.add(Restrictions.sqlRestriction("status in("+states+")"));	
			if(StringUtils.isNotEmpty(title))
				criteria.add(Restrictions.like("title", title, MatchMode.ANYWHERE));
			if(StringUtils.isNotEmpty(subject))
				criteria.add(Restrictions.like("subject", subject, MatchMode.ANYWHERE));
			if(StringUtils.isNotEmpty(summary))
				criteria.add(Restrictions.like("summary", summary, MatchMode.ANYWHERE));
			
			if(StringUtils.isNotEmpty(beginDate)){
				criteria.add(Restrictions.sqlRestriction("registed_date>='"+beginDate+" 00:00:00'"));	
			}
			if(StringUtils.isNotEmpty(endDate)){
				criteria.add(Restrictions.sqlRestriction("registed_date<='"+endDate+" 59:59:59'"));	
			}
			if(isCompleted!=null){
				criteria.add(Restrictions.sqlRestriction("is_completed ='"+isCompleted+"'"));	
			}
			criteria.addOrder(Order.desc("registedDate"));
			List<ReceiptModel> list = getListByCriteria(criteria);
	
			return list;
	}
	
	
	public List<FileFlowModel> getReceiptFlowByConditions(String userId) {
			DetachedCriteria criteria = DetachedCriteria.forClass(FileFlowModel.class);
			criteria.add(Restrictions.sqlRestriction(" type in (2,4,6,8) "));
			criteria.add(Restrictions.eq("user", userId));
			//criteria.addOrder(Order.desc("registedDate"));
			List<FileFlowModel> list = getListByCriteria(criteria);
	
			return list;
	}

}
