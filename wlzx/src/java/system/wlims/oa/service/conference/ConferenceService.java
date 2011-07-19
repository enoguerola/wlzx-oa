package system.wlims.oa.service.conference;

import java.util.Date;
import java.util.List;

import system.ServiceException;
import system.wlims.oa.entity.conference.ConferenceModel;

public interface ConferenceService {
	
	@SuppressWarnings("unchecked")
	public void addConference(ConferenceModel Conference, List list);
	public boolean updateConference(ConferenceModel conference, String adds,String removes);
	public boolean adjustConferenceById(String id,Date date,String beginTime,String endTime,String placeId);
	public boolean saveSummary(String id, String adds,String removes);
	public boolean remove(String id);
	public boolean cancleConferenceById(String id);
	public ConferenceModel get(String id)throws ServiceException;
	
	public List<ConferenceModel> getConferencesByConditions(String applyUserId, String name,String states,
			String placeId,String meetingBeginTime, String meetingEndTime,String applyBeginTime, String applyEndTime) ;
	public List<ConferenceModel> getAttendConferenceByConditions(String userId, String meetingBeginTime, String meetingEndTime) ;
	public  List<String> validateTimeAndPositionConflict(String id,Date date,String beginTime,String endTime,String placeId);
}
