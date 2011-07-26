package system.wlims.oa.daoImpl.conference;

import java.sql.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import system.BaseDAOImpl;
import system.utils.StringUtils;
import system.utils.UtilDateTime;
import system.wlims.oa.dao.conference.ConferenceDAO;
import system.wlims.oa.entity.conference.ConferenceModel;

public class ConferenceDAOImpl extends BaseDAOImpl<ConferenceModel> implements ConferenceDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<ConferenceModel> getConferencesByConditions(String applyUserId,
			String name, String states, String placeId,
			String meetingBeginTime, String meetingEndTime,
			String applyBeginTime, String applyEndTime) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(ConferenceModel.class);
		
		if(StringUtils.isNotEmpty(name))
			criteria.add(Restrictions.like("name", name));
		
		if(StringUtils.isNotEmpty(applyUserId))
			criteria.add(Restrictions.sqlRestriction("apply_user_id='"+applyUserId+"'"));
		if(StringUtils.isNotEmpty(states))
			criteria.add(Restrictions.sqlRestriction("apply_status in ("+states+")"));
		if(StringUtils.isNotEmpty(placeId))
			criteria.add(Restrictions.sqlRestriction("place_id='"+placeId+"'"));
		if(StringUtils.isNotEmpty(meetingBeginTime))
			criteria.add(Restrictions.sqlRestriction("date >= '"+meetingBeginTime+" 00:00:00'"));		
		if(StringUtils.isNotEmpty(meetingEndTime))
			criteria.add(Restrictions.sqlRestriction("date <= '"+meetingEndTime+" 23:59:59'"));
		if(StringUtils.isNotEmpty(applyBeginTime))
			criteria.add(Restrictions.sqlRestriction("apply_time >= '"+applyBeginTime+" 00:00:00'"));		
		if(StringUtils.isNotEmpty(applyEndTime))
			criteria.add(Restrictions.sqlRestriction("apply_time <= '"+applyEndTime+" 23:59:59'"));
//		if(StringUtils.isNotEmpty(meetingBeginTime))
//			criteria.add(Restrictions.ge("meetingDate",  Date.valueOf(meetingBeginTime)));
//		
//		if(StringUtils.isNotEmpty(meetingEndTime))
//			criteria.add(Restrictions.le("meetingDate",  Date.valueOf(meetingEndTime)));
//		
//		if(StringUtils.isNotEmpty(applyBeginTime))
//			criteria.add(Restrictions.ge("applyDateTime",  Date.valueOf(applyBeginTime)));
//		if(StringUtils.isNotEmpty(applyEndTime))
//			criteria.add(Restrictions.le("applyDateTime",  Date.valueOf(applyEndTime)));
		criteria.addOrder(Order.desc("meetingDate"));
		return getListByCriteria(criteria);
	}
	//返回有冲突的会议记录
	@SuppressWarnings("unchecked")
	@Override
	public List<ConferenceModel> validateTimeAndPositionConflict(String id,
			java.util.Date date, String beginTime, String endTime,
			String placeId,String states) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(ConferenceModel.class);
		
		if(StringUtils.isNotEmpty(id))
			criteria.add(Restrictions.ne("id", id));
		
		if(StringUtils.isNotEmpty(placeId))
			criteria.add(Restrictions.eq("placeId", placeId));
		if(StringUtils.isNotEmpty(states))
			criteria.add(Restrictions.sqlRestriction("apply_status in ("+states+")"));
		if(date!=null)
			criteria.add(Restrictions.sqlRestriction("date='"+UtilDateTime.toDateString(date)+"'"));
		
		if(StringUtils.isNotEmpty(beginTime)&&StringUtils.isNotEmpty(endTime)){
			criteria.add(Restrictions.and(Restrictions.sqlRestriction("time_begin between'"+beginTime+"' and '"+endTime+"'"), Restrictions.sqlRestriction("time_end between'"+beginTime+"' and '"+endTime+"'")));
		}
		
		return getListByCriteria(criteria);
	}

	

}
