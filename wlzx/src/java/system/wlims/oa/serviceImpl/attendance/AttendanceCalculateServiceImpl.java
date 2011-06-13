package system.wlims.oa.serviceImpl.attendance;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import system.constants.Constants;
import system.dao.DepartmentDAO;
import system.dao.UserDAO;
import system.entity.DepartmentModel;
import system.entity.UserModel;
import system.utils.StringUtils;
import system.wlims.basic.dao.teacher.TeacherDAO;
import system.wlims.oa.dao.attendance.*;
import system.wlims.oa.entity.workFlow.moveRestDay.MoveRestDayForm;
import system.wlims.oa.entity.workFlow.overWork.OverWorkForm;
import system.wlims.oa.entity.workFlow.takeLeave.TakeLeaveForm;
import system.wlims.oa.service.attendance.AttendanceCalculateService;
import system.wlims.oa.vo.AttendanceCalculateVO;



public class AttendanceCalculateServiceImpl implements AttendanceCalculateService {
	private TakeLeaveDAO takeLeaveDAO;
	private OverWorkDAO overWorkDAO;
	private MoveRestDayDAO moveRestDayDAO;
	private UserDAO userDAO;
	private TeacherDAO teacherDAO;
	private DepartmentDAO departmentDAO;
	public TakeLeaveDAO getTakeLeaveDAO() {
		return takeLeaveDAO;
	}
	public void setTakeLeaveDAO(TakeLeaveDAO takeLeaveDAO) {
		this.takeLeaveDAO = takeLeaveDAO;
	}
	public OverWorkDAO getOverWorkDAO() {
		return overWorkDAO;
	}
	public void setOverWorkDAO(OverWorkDAO overWorkDAO) {
		this.overWorkDAO = overWorkDAO;
	}
	public MoveRestDayDAO getMoveRestDayDAO() {
		return moveRestDayDAO;
	}
	public void setMoveRestDayDAO(MoveRestDayDAO moveRestDayDAO) {
		this.moveRestDayDAO = moveRestDayDAO;
	}
	public UserDAO getUserDAO() {
		return userDAO;
	}
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	public TeacherDAO getTeacherDAO() {
		return teacherDAO;
	}
	public void setTeacherDAO(TeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}
	public DepartmentDAO getDepartmentDAO() {
		return departmentDAO;
	}
	public void setDepartmentDAO(DepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}
	@Override
	public int getSectionsOfValidMoveRestDay(String userId, String beginTime,
			String endTime) {
		// TODO Auto-generated method stub
		int result=0;
		List<MoveRestDayForm> list=moveRestDayDAO.getMoveRestDayAppliesByConditions(userId,MoveRestDayForm.Status.Pass.getValue().toString(),null,null,beginTime,endTime);
		if(list!=null){
			for(MoveRestDayForm form:list){
				String times=form.getTimes();
				String[] times_attr=times.split(";");
				for(String time:times_attr){
					int morning=Integer.parseInt(time.split(" ")[1].split("-")[0]);
					int afternoon=Integer.parseInt(time.split(" ")[1].split("-")[1]);
					int evening=Integer.parseInt(time.split(" ")[1].split("-")[2]);
					result+=morning+afternoon+evening;
					
				}
			}
		}
		return result;
	}
	@Override
	public int getSectionsOfValidOverWork(String userId, String beginTime,
			String endTime) {
		// TODO Auto-generated method stub
		int result=0;
		List<OverWorkForm> list=overWorkDAO.getOverWorkAppliesByConditions(userId,OverWorkForm.Status.OfficePass.getValue().toString(),null,null,beginTime,endTime);
		if(list!=null){
			for(OverWorkForm form:list){
				String times=form.getTimes();
				String[] times_attr=times.split(";");
				for(String time:times_attr){
					int morning=Integer.parseInt(time.split(" ")[1].split("-")[0]);
					int afternoon=Integer.parseInt(time.split(" ")[1].split("-")[1]);
					int evening=Integer.parseInt(time.split(" ")[1].split("-")[2]);
					result+=morning+afternoon+evening;
					
				}
			}
		}
		return result;
	}
	@SuppressWarnings("finally")
	@Override
	public int getSectionsOfValidTakeLeave(String userId, String beginTime,
			String endTime,String type) {
		// TODO Auto-generated method stub
		int result=0;
		List<TakeLeaveForm> list=takeLeaveDAO.getTakeLeaveAppliesByConditions(userId,type,TakeLeaveForm.Status.Pass.getValue().toString(),null,null,beginTime,endTime);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(list!=null){
			for(TakeLeaveForm form:list){
				try {
					Date d1= df.parse(form.getBeginTime().split(" ")[0]);
				    Date d2 = df.parse(form.getEndTime().split(" ")[0]);
				    long diff = d1.getTime() - d2.getTime();
				    long days = diff / (1000 * 60 * 60 * 24);
				    result+=days*Constants.DaysOfSections+(Integer.parseInt(form.getEndTime().split(" ")[1])-Integer.parseInt(form.getBeginTime().split(" ")[1]));
			    }catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					continue;
				}
			}
		}
		return result;
	}
	@Override
	public int getTimesOfValidMoveRestDay(String userId, String beginTime,
			String endTime) {
		// TODO Auto-generated method stub
		List<MoveRestDayForm> list=moveRestDayDAO.getMoveRestDayAppliesByConditions(userId,MoveRestDayForm.Status.Pass.getValue().toString(),null,null,beginTime,endTime);
		if(list==null)return 0;
		return list.size();
	}
	@Override
	public int getTimesOfValidOverWork(String userId, String beginTime,
			String endTime) {
		// TODO Auto-generated method stub
		List<OverWorkForm> list=overWorkDAO.getOverWorkAppliesByConditions(userId,OverWorkForm.Status.OfficePass.getValue().toString(),null,null,beginTime,endTime);
		if(list==null)return 0;
		return list.size();
	}
	@Override
	public int getTimesOfValidTakeLeave(String userId, String beginTime,
			String endTime,String type) {
		// TODO Auto-generated method stub
		List<TakeLeaveForm> list=takeLeaveDAO.getTakeLeaveAppliesByConditions(userId,type,TakeLeaveForm.Status.Pass.getValue().toString(),null,null,beginTime,endTime);
		if(list==null)return 0;
		return list.size();
	}
	@Override
	public List<AttendanceCalculateVO> getCalculateAttendanceByCondition(
			String userId, String departmentId, String beginTime,
			String endTime) {
		// TODO Auto-generated method stub
		List<AttendanceCalculateVO> results=new ArrayList<AttendanceCalculateVO>();
		List<UserModel> users=null;
		if(StringUtils.isNotEmpty(userId)){
			users=new ArrayList<UserModel>();
			users.add(userDAO.get(userId));
		}else if(StringUtils.isNotEmpty(departmentId)){
			DepartmentModel department=departmentDAO.get(departmentId);
			users=new ArrayList<UserModel>(department.getUsers());
		}else {
			users=userDAO.getAllUsers();
		}
		for(UserModel user:users){
			AttendanceCalculateVO vo=new AttendanceCalculateVO();
			vo.setUserID(user.getId());
			vo.setUserAccount(user.getName());
			vo.setDepartmentName(user.getMainRole().getBelongDepartment().getName());
			vo.setTakeLeave_leaveDaySections(getSectionsOfValidTakeLeave(user.getId(),beginTime,endTime,TakeLeaveForm.Types.Leave.getValue().toString()));
			vo.setTakeLeave_leaveTimes(getTimesOfValidTakeLeave(user.getId(),beginTime,endTime,TakeLeaveForm.Types.Leave.getValue().toString()));
			vo.setTakeLeave_businessTripDaySections(getSectionsOfValidTakeLeave(user.getId(),beginTime,endTime,TakeLeaveForm.Types.BusinessTrip.getValue().toString()));
			vo.setTakeLeave_businessTripTimes(getTimesOfValidTakeLeave(user.getId(),beginTime,endTime,TakeLeaveForm.Types.BusinessTrip.getValue().toString()));

			vo.setOverWorkDaySections(getSectionsOfValidOverWork(user.getId(),beginTime,endTime));
			vo.setOverWorkTimes(getTimesOfValidOverWork(user.getId(),beginTime,endTime));
			vo.setMoveRestDayDaySections(getSectionsOfValidMoveRestDay(user.getId(),beginTime,endTime));
			vo.setMoveRestDayTimes(getTimesOfValidMoveRestDay(user.getId(),beginTime,endTime));
			vo.setBeginTime(beginTime);
			vo.setEndTime(endTime);
			results.add(vo);
		}
		return results;
	}
	
	
	
}
