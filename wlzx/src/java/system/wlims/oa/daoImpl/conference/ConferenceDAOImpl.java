package system.wlims.oa.daoImpl.conference;

import java.sql.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import system.BaseDAOImpl;
import system.utils.StringUtils;
import system.wlims.oa.dao.conference.ConferenceDAO;
import system.wlims.oa.entity.conference.ConferenceModel;

public class ConferenceDAOImpl extends BaseDAOImpl<ConferenceModel> implements ConferenceDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<ConferenceModel> getConferencesByConditions(String applyUserId,
			String name, Integer applyStatus, String placeId,
			String meetingBeginTime, String meetingEndTime,
			String applyBeginTime, String applyEndTime) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(ConferenceModel.class);
		
		if(StringUtils.isNotEmpty(name))
			criteria.add(Restrictions.like("name", name));
		
		if(StringUtils.isNotEmpty(applyUserId))
			criteria.add(Restrictions.sqlRestriction("apply_user_id='"+applyUserId+"'"));
		if(applyStatus!=null)
			criteria.add(Restrictions.eq("applyStatus", applyStatus));
		if(StringUtils.isNotEmpty(placeId))
			criteria.add(Restrictions.sqlRestriction("place_id='"+placeId+"'"));
		
		if(StringUtils.isNotEmpty(meetingBeginTime))
			criteria.add(Restrictions.ge("meetingDate",  Date.valueOf(meetingBeginTime)));
		
		if(StringUtils.isNotEmpty(meetingEndTime))
			criteria.add(Restrictions.le("meetingDate",  Date.valueOf(meetingEndTime)));
		
		if(StringUtils.isNotEmpty(applyBeginTime))
			criteria.add(Restrictions.ge("applyDateTime",  Date.valueOf(applyBeginTime)));
		if(StringUtils.isNotEmpty(applyEndTime))
			criteria.add(Restrictions.ge("applyDateTime",  Date.valueOf(applyEndTime)));
		
		return getListByCriteria(criteria);
	}

	

}
