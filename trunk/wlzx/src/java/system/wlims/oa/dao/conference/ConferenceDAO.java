package system.wlims.oa.dao.conference;


import java.util.List;

import system.BaseDAO;
import system.wlims.oa.entity.conference.ConferenceModel;

public interface ConferenceDAO  extends BaseDAO<ConferenceModel>{
	public List<ConferenceModel> getConferencesByConditions(String applyUserId, String name,String states,
			String placeId,String meetingBeginTime, String meetingEndTime,String applyBeginTime, String applyEndTime) ;
	
}
