package system.wlims.oa.daoImpl.sendingFiles;


import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import system.BaseDAOImpl;
import system.utils.StringUtils;
import system.wlims.oa.dao.sendingFiles.SendingFileDAO;
import system.wlims.oa.entity.sendingFiles.SendingFileModel;

public class SendingFileDAOImpl extends BaseDAOImpl<SendingFileModel> implements SendingFileDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<SendingFileModel> getByConditions(
			String dispatchWord,String dispatchYear,String dispatchNumber, String title,
			String auspiceDepartment, String beginDate, String endDate,
			String states,Integer isCompleted) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SendingFileModel.class);
		if(StringUtils.isNotEmpty(dispatchWord)){
			criteria.add(Restrictions.sqlRestriction("dispatch_word='"+dispatchWord+"'"));	
			
		}	
		if(StringUtils.isNotEmpty(dispatchYear)){
			criteria.add(Restrictions.sqlRestriction("dispatch_year='"+dispatchYear+"'"));	
			
		}	
		if(StringUtils.isNotEmpty(dispatchNumber)){
			criteria.add(Restrictions.sqlRestriction("dispatch_number='"+dispatchNumber+"'"));	
			
		}	
		if(StringUtils.isNotEmpty(states)){
			criteria.add(Restrictions.sqlRestriction("status in("+states+")"));	
		}
		if(StringUtils.isNotEmpty(title))
			criteria.add(Restrictions.like("title", title));
		if(StringUtils.isNotEmpty(auspiceDepartment))
			criteria.add(Restrictions.like("auspiceDepartment", auspiceDepartment));
		
		if(StringUtils.isNotEmpty(beginDate)){
			criteria.add(Restrictions.sqlRestriction("creation_date>='"+beginDate+" 00:00:00'"));	
		}
		if(StringUtils.isNotEmpty(endDate)){
			criteria.add(Restrictions.sqlRestriction("creation_date<='"+endDate+" 59:59:59'"));	
		}
		if(isCompleted!=null){
			criteria.add(Restrictions.sqlRestriction("is_completed ='"+isCompleted+"'"));	
		}
		criteria.addOrder(Order.desc("creationDate"));
		List<SendingFileModel> list = getListByCriteria(criteria);

		return list;
	}


}
