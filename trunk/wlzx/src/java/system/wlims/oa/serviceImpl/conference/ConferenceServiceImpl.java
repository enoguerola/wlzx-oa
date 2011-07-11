package system.wlims.oa.serviceImpl.conference;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import system.DAOException;
import system.ServiceException;
import system.dao.UserDAO;
import system.utils.StringUtils;
import system.utils.UtilDateTime;
import system.wlims.basic.dao.PlaceDao;
import system.wlims.basic.entity.PlaceModel;
import system.wlims.oa.dao.notice.AttachmentDAO;
import system.wlims.oa.dao.conference.ConferenceDAO;
import system.wlims.oa.entity.notice.AttachmentModel;
import system.wlims.oa.entity.conference.ConferenceModel;
import system.wlims.oa.service.conference.ConferenceService;

public class ConferenceServiceImpl implements ConferenceService {
	
	private ConferenceDAO conferenceDAO;
	private UserDAO userDAO;
	private AttachmentDAO attachmentDAO;
	private PlaceDao placeDao;
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
			if(conference.getApplyStatus().intValue()==ConferenceModel.EStatus.Arranged.getValue().intValue())
				conference.setApplyStatus(ConferenceModel.EStatus.ArrangedCancled.getValue());
			else conference.setApplyStatus(ConferenceModel.EStatus.Cancled.getValue());
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
			String name, String states, String placeId,
			String meetingBeginTime, String meetingEndTime,
			String applyBeginTime, String applyEndTime) {
		// TODO Auto-generated method stub
		return conferenceDAO.getConferencesByConditions(applyUserId, name, states, placeId, meetingBeginTime, meetingEndTime, applyBeginTime, applyEndTime);
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
	public List<ConferenceModel> getAttendConferenceByConditions(String userId, String meetingBeginTime, String meetingEndTime) {
		List<ConferenceModel> results=new ArrayList<ConferenceModel>();
		List<ConferenceModel> lists=conferenceDAO.getConferencesByConditions(null, null,"3,4",null,meetingBeginTime,meetingEndTime,null,null);
		if(lists!=null&&lists.size()>0){
			for(ConferenceModel model:lists){
				if(StringUtils.isNotEmpty(userId)&&StringUtils.isNotEmpty(model.getTeacherAttendIds())){
					String[] ids=model.getTeacherAttendIds().split(";");
					if(ids!=null&&ids.length>0)
					for(int i=0;i<ids.length;i++){
						if(ids[i].equals(userId)){
							results.add(model);
							break;
						}
					}
					
				}
			}
		}
		return results;		
	}
	public Map<String, Map<String,Map<String,List<ConferenceModel>>>> getConferencePlaceArrangments(String beginTime,String endTime){
		Map<String, Map<String,Map<String,List<ConferenceModel>>>> data = new TreeMap<String, Map<String,Map<String,List<ConferenceModel>>>>();
		List<Date> dates=UtilDateTime.getDatesDateRange(java.sql.Date.valueOf(beginTime), java.sql.Date.valueOf(endTime));
		for(Date wdate : dates){
			data.put(UtilDateTime.toDateString(wdate), new TreeMap<String, Map<String,List<ConferenceModel>>>());
		}
		List<ConferenceModel> conferences = conferenceDAO.getConferencesByConditions(null, null, null, null, beginTime, endTime, null, null);
		List<PlaceModel> places = placeDao.getPlacesByCondition(null, null, null, null, null, null, null);
		
				if(conferences != null && places != null){
					for(ConferenceModel conference : conferences){
						// 过滤已取消会议
						if (conference.getApplyStatus().intValue() == ConferenceModel.EStatus.Booking.getValue().intValue()||conference.getApplyStatus().intValue() == ConferenceModel.EStatus.Arranged.getValue().intValue()) {
							String conferenceDate = UtilDateTime.toDateString(conference.getApplyDateTime());
							if(!data.containsKey(conferenceDate)){
								data.put(conferenceDate, new TreeMap<String, Map<String,List<ConferenceModel>>>());
							}
							
//							ArrayList<String> timeAreas=MaryUtils.audioTimeCrosss(lesson.getLessonDayTime());
//							for(String timeArea:timeAreas){
								String timeArea=conference.getBeginTime()+"-"+conference.getEndTime();
								if(!data.get(conferenceDate).containsKey(timeArea)){
									Map<String, List<ConferenceModel>> placeMap = new LinkedHashMap<String, List<ConferenceModel>>();
									
									for(PlaceModel place : places){
										if(!placeMap.containsKey(place.getId())){
											placeMap.put(place.getId(), null);
										}
									}
									data.get(conferenceDate).put(timeArea, placeMap);
								}
//							}

//						for(String timeArea:timeAreas){
							if(data.get(conferenceDate).get(timeArea).get(conference.getPlaceId())==null)
								data.get(conferenceDate).get(timeArea).put(conference.getPlaceId(), new ArrayList<ConferenceModel>());
							data.get(conferenceDate).get(timeArea).get(conference.getPlaceId()).add(conference);
//						}
					}			
				}
			}
			
			
		return data;
	}

	public PlaceDao getPlaceDao() {
		return placeDao;
	}

	public void setPlaceDao(PlaceDao placeDao) {
		this.placeDao = placeDao;
	}
}
