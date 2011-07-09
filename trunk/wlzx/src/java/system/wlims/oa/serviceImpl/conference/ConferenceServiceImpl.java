package system.wlims.oa.serviceImpl.conference;

import java.util.Date;
import java.util.List;

import system.DAOException;
import system.ServiceException;
import system.dao.UserDAO;
import system.wlims.oa.dao.notice.AttachmentDAO;
import system.wlims.oa.dao.conference.ConferenceDAO;
import system.wlims.oa.entity.notice.AttachmentModel;
import system.wlims.oa.entity.conference.ConferenceModel;
import system.wlims.oa.service.conference.ConferenceService;

public class ConferenceServiceImpl implements ConferenceService {
	
	private ConferenceDAO conferenceDAO;
	private UserDAO userDAO;
	private AttachmentDAO attachmentDAO;

	@SuppressWarnings("unchecked")
	@Override
	public void addConference(ConferenceModel conference, List list) {
		// TODO Auto-generated method stub
//		UserModel userModel = SecurityUserHolder.getCurrentUser();
//		conference.setLastEditorId(userModel.getId());
//		conference.setLastEditTime(UtilDateTime.nowDate());
//		if(conference.getStatus() == 0){
//			conference.setPosterId(null);
//			conference.setPostTime(null);
//		}else{
//			if(StringUtils.isEmpty(conference.getPosterId())){
//				conference.setPosterId(userModel.getId());
//				conference.setPostTime(UtilDateTime.nowDate());
//			}
//		}
		conference.setApplyDateTime(new Date());
		conference.setApplyStatus(ConferenceModel.EStatus.Booking.getValue());
		if(list != null && list.size() > 0){
			for(Object id : list){
				System.out.println(id);
				AttachmentModel attachmentModel = attachmentDAO.get((String)id);
				conference.getAttachments().add(attachmentModel);
			}
		}
			
		conferenceDAO.saveOrUpdate(conference);
	}

	@Override
	public boolean remove(String id) {
		// TODO Auto-generated method stub
		try {
			conferenceDAO.remove((conferenceDAO.get(id)));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@Override
	public boolean cancleConferenceById(String id) {
		ConferenceModel conference=conferenceDAO.get(id);
		if(conference.getApplyStatus().intValue()!=ConferenceModel.EStatus.Booking.getValue().intValue())return false;
		else{
			conference.setApplyStatus(ConferenceModel.EStatus.Cancled.getValue());
//			MoveRestDayWorkFlowLog log=new MoveRestDayWorkFlowLog();
//			log.setOperationName("取消申请");
//			log.setOperationResult("取消编号为"+conference.getApplyNo()+"的申请记录");
//			log.setOperationTime(new Date());
//			log.setOperationTeacherId(conference.getTeacherId());
//			conference.getLogs().add(log);
			conferenceDAO.saveOrUpdate(conference);
			return true;
		}
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public boolean updateConference(ConferenceModel conference, List list) {
		// TODO Auto-generated method stub
		try{
			if(list != null && list.size() > 0){
				for(Object id : list){
					System.out.println(id);
					AttachmentModel attachmentModel = attachmentDAO.get((String)id);
					conference.getAttachments().add(attachmentModel);
				}
			}
			conferenceDAO.saveOrUpdate(conference);
			return true;
		}catch (DAOException e){
			return false;
		}
	}



	@Override
	public ConferenceModel get(String id) throws ServiceException {
		// TODO Auto-generated method stub
		return conferenceDAO.get(id);
	}

	@Override
	public List<ConferenceModel> getConferencesByConditions(String applyUserId,
			String name, Integer applyStatus, String placeId,
			String meetingBeginTime, String meetingEndTime,
			String applyBeginTime, String applyEndTime) {
		// TODO Auto-generated method stub
		return conferenceDAO.getConferencesByConditions(applyUserId, name, applyStatus, placeId, meetingBeginTime, meetingEndTime, applyBeginTime, applyEndTime);
	}
	public void setConferenceDAO(ConferenceDAO conferenceDAO) {
		this.conferenceDAO = conferenceDAO;
	}

	public ConferenceDAO getConferenceDAO() {
		return conferenceDAO;
	}

	


	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	


	public void setAttachmentDAO(AttachmentDAO attachmentDAO) {
		this.attachmentDAO = attachmentDAO;
	}

	public AttachmentDAO getAttachmentDAO() {
		return attachmentDAO;
	}

	@Override
	public boolean adjustConferenceById(String id, Date date,
			String beginTime, String endTime, String placeId) {
		// TODO Auto-generated method stub
		ConferenceModel model=conferenceDAO.get(id);
		if(model==null)return false;
		else {
			model.setMeetingDate(date);
			model.setBeginTime(beginTime);
			model.setEndTime(endTime);
			model.setPlaceId(placeId);
			model.setApplyStatus(ConferenceModel.EStatus.Arranged.getValue());
			conferenceDAO.saveOrUpdate(model);
			return true;
		
		}
	}
}
