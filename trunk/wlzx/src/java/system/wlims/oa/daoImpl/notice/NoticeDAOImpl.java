package system.wlims.oa.daoImpl.notice;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import system.BaseDAOImpl;
import system.DAOException;
import system.PaginationSupport;
import system.utils.StringUtils;
import system.wlims.oa.dao.notice.NoticeDAO;
import system.wlims.oa.entity.notice.NoticeModel;

public class NoticeDAOImpl extends BaseDAOImpl<NoticeModel> implements NoticeDAO {

	@Override
	public PaginationSupport<NoticeModel> getNoticesByConditions(
			String type, String scope, String emergence, String deparmentIds,
			String title, String beginDate, String endDate, Integer pageSize,
			Integer startIndex) throws DAOException {
		DetachedCriteria criteria = DetachedCriteria.forClass(NoticeModel.class);
		
		if(StringUtils.isNotEmpty(type))
			criteria.add(Restrictions.eq("type", type));
		
		if(StringUtils.isNotEmpty(scope))
			criteria.add(Restrictions.eq("scope", Integer.parseInt(scope)));
		
		if(StringUtils.isNotEmpty(emergence))
			criteria.add(Restrictions.eq("emergence", Integer.parseInt(emergence)));
		
		if(StringUtils.isNotEmpty(deparmentIds)){
			criteria.add(Restrictions.sqlRestriction("post_department_id in("+deparmentIds+")"));
		}
		
		if(StringUtils.isNotEmpty(title))
			criteria.add(Restrictions.like("title", title));
		
		if(StringUtils.isNotEmpty(beginDate))
			criteria.add(Restrictions.sqlRestriction("postTime >= '"+beginDate+" 00:00:00'"));
		if(StringUtils.isNotEmpty(endDate))
			criteria.add(Restrictions.sqlRestriction("postTime <= '"+endDate+" 23:59:59'"));
		criteria.add(Restrictions.eq("status", NoticeModel.EStatus.Published.getValue()));
		criteria.addOrder(Order.desc("postTime"));
		
		return this.findPageByCriteria(criteria, pageSize, startIndex);
	}

//	@Override
//	public List<NoticeModel> getNoticesByConditions(String userId, String type,
//			String scope, String emergence, String deparmentId, String title,
//			String beginDate, String endDate) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
