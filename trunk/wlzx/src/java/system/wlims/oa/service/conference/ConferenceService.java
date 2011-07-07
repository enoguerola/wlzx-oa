package system.wlims.oa.service.conference;

import java.util.List;

import system.ServiceException;
import system.wlims.oa.entity.conference.ConferenceModel;

public interface ConferenceService {
	
	public void addConference(ConferenceModel Conference, List list);
	
	public boolean updateConference(ConferenceModel Conference, List list);
	

	boolean remove(String id);
		
	public ConferenceModel get(String id)throws ServiceException;
	
	public List<ConferenceModel> getConferencesByConditions(String applyUserId, String name,Integer applyStatus,
			String placeId,String meetingBeginTime, String meetingEndTime,String applyBeginTime, String applyEndTime) ;

}
