package system.wlims.oa.serviceImpl.attendance;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import system.wlims.oa.dao.attendance.*;
import system.wlims.oa.entity.workFlow.moveRestDay.MoveRestDayForm;
import system.wlims.oa.entity.workFlow.overWork.OverWorkForm;
import system.wlims.oa.entity.workFlow.takeLeave.TakeLeaveForm;
import system.wlims.oa.service.attendance.AttendanceCalculateService;



public class AttendanceCalculateServiceImpl implements AttendanceCalculateService {
	public TakeLeaveDAO takeLeaveDAO;
	public OverWorkDAO overWorkDAO;
	public MoveRestDayDAO moveRestDayDAO;
	public static final int Days_Of_Sections=3;
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
	@Override
	public int getSectionsOfValidMoveRestDay(String teacherId, String beginTime,
			String endTime) {
		// TODO Auto-generated method stub
		int result=0;
		List<MoveRestDayForm> list=moveRestDayDAO.getMoveRestDayAppliesByConditions(teacherId,MoveRestDayForm.Status.Pass.getValue().toString(),null,null,beginTime,endTime);
		if(list!=null){
			for(MoveRestDayForm form:list){
				String times=form.getTimes();
				String[] times_attr=times.split(";");
				for(String time:times_attr){
					int morning=Integer.parseInt(time.split(" ")[1].split("-")[0]);
					int afternoon=Integer.parseInt(time.split(" ")[1].split("-")[0]);
					int evening=Integer.parseInt(time.split(" ")[1].split("-")[0]);
					result+=morning+afternoon+evening;
					
				}
			}
		}
		return result;
	}
	@Override
	public int getSectionsOfValidOverWork(String teacherId, String beginTime,
			String endTime) {
		// TODO Auto-generated method stub
		int result=0;
		List<OverWorkForm> list=overWorkDAO.getOverWorkAppliesByConditions(teacherId,OverWorkForm.Status.OfficePass.getValue().toString(),null,null,beginTime,endTime);
		if(list!=null){
			for(OverWorkForm form:list){
				String times=form.getTimes();
				String[] times_attr=times.split(";");
				for(String time:times_attr){
					int morning=Integer.parseInt(time.split(" ")[1].split("-")[0]);
					int afternoon=Integer.parseInt(time.split(" ")[1].split("-")[0]);
					int evening=Integer.parseInt(time.split(" ")[1].split("-")[0]);
					result+=morning+afternoon+evening;
					
				}
			}
		}
		return result;
	}
	@SuppressWarnings("finally")
	@Override
	public int getSectionsOfValidTakeLeave(String teacherId, String beginTime,
			String endTime,String type) {
		// TODO Auto-generated method stub
		int result=0;
		List<TakeLeaveForm> list=takeLeaveDAO.getTakeLeaveAppliesByConditions(teacherId,type,TakeLeaveForm.Status.Pass.getValue().toString(),null,null,beginTime,endTime);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(list!=null){
			for(TakeLeaveForm form:list){
				try {
					Date d1= df.parse(form.getBeginTime().split(" ")[0]);
				    Date d2 = df.parse(form.getEndTime().split(" ")[0]);
				    long diff = d1.getTime() - d2.getTime();
				    long days = diff / (1000 * 60 * 60 * 24);
				    result+=days*AttendanceCalculateServiceImpl.Days_Of_Sections+(Integer.parseInt(form.getEndTime().split(" ")[1])-Integer.parseInt(form.getBeginTime().split(" ")[1]));
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
	
}
