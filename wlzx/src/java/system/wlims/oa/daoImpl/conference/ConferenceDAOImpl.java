package system.wlims.oa.daoImpl.conference;

import java.util.List;
import system.BaseDAOImpl;
import system.wlims.oa.dao.conference.ConferenceDAO;
import system.wlims.oa.entity.conference.ConferenceModel;

public class ConferenceDAOImpl extends BaseDAOImpl<ConferenceModel> implements ConferenceDAO {

	@Override
	public List<ConferenceModel> getConferencesByConditions(String applyUserId,
			String name, Integer applyStatus, String placeId,
			String meetingBeginTime, String meetingEndTime,
			String applyBeginTime, String applyEndTime) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
