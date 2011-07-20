package system.wlims.oa.serviceImpl.integration;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import system.wlims.oa.dao.attendance.MoveRestDayDAO;
import system.wlims.oa.dao.attendance.OverWorkDAO;
import system.wlims.oa.dao.attendance.TakeLeaveDAO;
import system.wlims.oa.dao.conference.ConferenceDAO;
import system.wlims.oa.dao.course.adjust.CourseAdjustDAO;
import system.wlims.oa.dao.task.TaskDAO;
import system.wlims.oa.entity.conference.ConferenceModel;
import system.wlims.oa.entity.course.adjust.ApplyModel;
import system.wlims.oa.entity.task.TaskModel;
import system.wlims.oa.entity.workFlow.moveRestDay.MoveRestDayForm;
import system.wlims.oa.entity.workFlow.overWork.OverWorkForm;
import system.wlims.oa.entity.workFlow.takeLeave.TakeLeaveForm;
import system.wlims.oa.service.integration.AllWaittingDealService;
import system.wlims.oa.vo.TaskVO;
import system.utils.UtilDateTime;;

public class AllWaittingDealServiceImpl  implements AllWaittingDealService{
	private TaskDAO taskDAO;
	private CourseAdjustDAO courseAdjustDAO;
	private MoveRestDayDAO moveRestDayDAO;
	private OverWorkDAO overWorkDAO;
	private TakeLeaveDAO takeLeaveDAO;
	private ConferenceDAO conferenceDAO;
	@Override
	public List<TaskVO> getAllDealTasksByCondition(String accountId, String beginTime, String endTime) {
		// TODO Auto-generated method stub
		List<TaskVO> list=new ArrayList<TaskVO>();
		//领导指派任务
		List<TaskModel> taskList=taskDAO.getTasksByConditions(null, accountId, null, beginTime, endTime);
		if(taskList!=null&&taskList.size()>0)
		for(TaskModel task:taskList){
			TaskVO taskVO=new TaskVO();
			taskVO.setType(TaskVO.EType.Task.getText());
			taskVO.setTypeId(TaskVO.EType.Task.getValue().intValue());
			taskVO.setAssignerId(task.getAssignerId());
			taskVO.setId(task.getId());
			taskVO.setPostTime(UtilDateTime.toDateString(task.getPostTime(),"yyyy-MM-dd HH:mm:ss"));
			taskVO.setTitle(task.getTitle());
			if(task.getStatus().intValue()==0)
				taskVO.setStatus(TaskVO.EStatus.OnGoing.getText());
			else if(task.getStatus().intValue()==1)
				taskVO.setStatus(TaskVO.EStatus.Finished.getText());
			taskVO.setWorkersIds(task.getWorkerIds());
			list.add(taskVO);
		}
		//请假出差审批任务
		List<TakeLeaveForm> takeLeaveList=takeLeaveDAO.getTakeLeaveAppliesByConditions(accountId,null,null,beginTime,endTime,null,null);
		if(takeLeaveList!=null&&takeLeaveList.size()>0)
			for(TakeLeaveForm takeLeaveForm:takeLeaveList){
					//请假出差期间工作落实
					TaskVO taskVO=new TaskVO();
					taskVO.setStatus(TaskVO.EStatus.ToBeDeal.getText());
					if(takeLeaveForm.getType().intValue()==TakeLeaveForm.Types.BusinessTrip.getValue().intValue()){
						taskVO.setType(TaskVO.EType.AskForLeave_BusinessTrip_TechArrange.getText());
						taskVO.setTypeId(TaskVO.EType.AskForLeave_BusinessTrip_TechArrange.getValue().intValue());
					}
					else if(takeLeaveForm.getType().intValue()==TakeLeaveForm.Types.Leave.getValue().intValue()){
						taskVO.setType(TaskVO.EType.AskForLeave_Leave_TechArrange.getText());
						taskVO.setTypeId(TaskVO.EType.AskForLeave_Leave_TechArrange.getValue().intValue());
					}
					taskVO.setAssignerId(TaskVO.EAssigner.Default.getValue().intValue()+"");
					taskVO.setId(takeLeaveForm.getId());
					try {
						Date postDate = new SimpleDateFormat("yyyyMMddHHmmss").parse(takeLeaveForm.getApplyNo());
						taskVO.setPostTime(UtilDateTime.toDateString(postDate,"yyyy-MM-dd HH:mm:ss"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
					if(takeLeaveForm.getType().intValue()==TakeLeaveForm.Types.BusinessTrip.getValue().intValue()){
						taskVO.setTitle(TaskVO.ETitle.AskForLeave_BusinessTrip_TechArrange.getText());}
					else if(takeLeaveForm.getType().intValue()==TakeLeaveForm.Types.Leave.getValue().intValue())
						taskVO.setTitle(TaskVO.ETitle.AskForLeave_Leave_TechArrange.getText());
					taskVO.setWorkersIds(takeLeaveForm.getTeacherId());
					if(takeLeaveForm.getArrangeTechDealAlready()==true){
						taskVO.setStatus(TaskVO.EStatus.Finished.getText());
						
					}else {
						if(takeLeaveForm.getStatus()!=null&&takeLeaveForm.getStatus().intValue()==TakeLeaveForm.Status.Cancle.getValue().intValue())
						taskVO.setStatus(TaskVO.EStatus.Cancled.getText());
						else taskVO.setStatus(TaskVO.EStatus.ToBeDeal.getText());
					}
					
					list.add(taskVO);
					
					//请假出差处室审批
					if(takeLeaveForm.getArrangeTechDealAlready()==true){
						TaskVO taskVO1=new TaskVO();
						taskVO1.setStatus(TaskVO.EStatus.ToBeDeal.getText());
						if(takeLeaveForm.getType().intValue()==TakeLeaveForm.Types.BusinessTrip.getValue().intValue()){
							taskVO1.setType(TaskVO.EType.AskForLeave_BusinessTrip_OfficalApprove.getText());
							taskVO1.setTypeId(TaskVO.EType.AskForLeave_BusinessTrip_OfficalApprove.getValue().intValue());

						}
						else if(takeLeaveForm.getType().intValue()==TakeLeaveForm.Types.Leave.getValue().intValue()){
							taskVO1.setType(TaskVO.EType.AskForLeave_Leave_OfficalApprove.getText());
							taskVO1.setTypeId(TaskVO.EType.AskForLeave_Leave_OfficalApprove.getValue().intValue());
						}
						taskVO1.setAssignerId(TaskVO.EAssigner.Default.getValue().intValue()+"");
						taskVO1.setId(takeLeaveForm.getId());
						try {
							Date postDate = new SimpleDateFormat("yyyyMMddHHmmss").parse(takeLeaveForm.getApplyNo());
							taskVO1.setPostTime(UtilDateTime.toDateString(postDate,"yyyy-MM-dd HH:mm:ss"));
						} catch (ParseException e) {
							e.printStackTrace();
						}
						if(takeLeaveForm.getType().intValue()==TakeLeaveForm.Types.BusinessTrip.getValue().intValue())
							taskVO1.setTitle(TaskVO.ETitle.AskForLeave_BusinessTrip_OfficalApprove.getText());
						else if(takeLeaveForm.getType().intValue()==TakeLeaveForm.Types.Leave.getValue().intValue())
							taskVO1.setTitle(TaskVO.ETitle.AskForLeave_Leave_OfficalApprove.getText());
						if(takeLeaveForm.getOfficeChiefStatus()==null){
							if(takeLeaveForm.getStatus()!=null&&takeLeaveForm.getStatus().intValue()==TakeLeaveForm.Status.Cancle.getValue().intValue())
								taskVO1.setStatus(TaskVO.EStatus.Cancled.getText());
							else taskVO1.setStatus(TaskVO.EStatus.ToBeDeal.getText());
						}
						else taskVO1.setStatus(TaskVO.EStatus.Finished.getText());
						taskVO1.setWorkersIds(takeLeaveForm.getTeacherId());
						list.add(taskVO1);
					}
					//请假出差副校长审批
					if(takeLeaveForm.getOfficeChiefStatus()!=null&&takeLeaveForm.getOfficeChiefStatus().intValue()==1){
						TaskVO taskVO2=new TaskVO();
						taskVO2.setStatus(TaskVO.EStatus.ToBeDeal.getText());
						if(takeLeaveForm.getType().intValue()==TakeLeaveForm.Types.BusinessTrip.getValue().intValue()){
							taskVO2.setType(TaskVO.EType.AskForLeave_BusinessTrip_VicePrincipalApprove.getText());
							taskVO2.setTypeId(TaskVO.EType.AskForLeave_BusinessTrip_VicePrincipalApprove.getValue().intValue());
						}
						else if(takeLeaveForm.getType().intValue()==TakeLeaveForm.Types.Leave.getValue().intValue()){
							taskVO2.setType(TaskVO.EType.AskForLeave_Leave_VicePrincipalApprove.getText());
							taskVO2.setTypeId(TaskVO.EType.AskForLeave_Leave_VicePrincipalApprove.getValue().intValue());
						}
						taskVO2.setAssignerId(TaskVO.EAssigner.Default.getValue().intValue()+"");
						taskVO2.setId(takeLeaveForm.getId());
						try {
							Date postDate = new SimpleDateFormat("yyyyMMddHHmmss").parse(takeLeaveForm.getApplyNo());
							taskVO2.setPostTime(UtilDateTime.toDateString(postDate,"yyyy-MM-dd HH:mm:ss"));
						} catch (ParseException e) {
							e.printStackTrace();
						}
						if(takeLeaveForm.getType().intValue()==TakeLeaveForm.Types.BusinessTrip.getValue().intValue())
							taskVO2.setTitle(TaskVO.ETitle.AskForLeave_BusinessTrip_VicePrincipalApprove.getText());
						else if(takeLeaveForm.getType().intValue()==TakeLeaveForm.Types.Leave.getValue().intValue())
							taskVO2.setTitle(TaskVO.ETitle.AskForLeave_Leave_VicePrincipalApprove.getText());
						if(takeLeaveForm.getVicePrincipalStatus()==null){
							if(takeLeaveForm.getStatus()!=null&&takeLeaveForm.getStatus().intValue()==TakeLeaveForm.Status.Cancle.getValue().intValue())
								taskVO2.setStatus(TaskVO.EStatus.Cancled.getText());
							else taskVO2.setStatus(TaskVO.EStatus.ToBeDeal.getText());
						}
						else taskVO2.setStatus(TaskVO.EStatus.Finished.getText());
						taskVO2.setWorkersIds(takeLeaveForm.getTeacherId());
						list.add(taskVO2);
					}
					
					//请假出差校长审批
					if(takeLeaveForm.getVicePrincipalStatus()!=null&&takeLeaveForm.getVicePrincipalStatus().intValue()==1){
						TaskVO taskVO3=new TaskVO();
						taskVO3.setStatus(TaskVO.EStatus.ToBeDeal.getText());
						if(takeLeaveForm.getType().intValue()==TakeLeaveForm.Types.BusinessTrip.getValue().intValue()){
							taskVO3.setType(TaskVO.EType.AskForLeave_BusinessTrip_PrincipalApprove.getText());
							taskVO3.setTypeId(TaskVO.EType.AskForLeave_BusinessTrip_PrincipalApprove.getValue().intValue());
						}
						else if(takeLeaveForm.getType().intValue()==TakeLeaveForm.Types.Leave.getValue().intValue()){
							taskVO3.setType(TaskVO.EType.AskForLeave_Leave_PrincipalApprove.getText());
							taskVO3.setTypeId(TaskVO.EType.AskForLeave_Leave_PrincipalApprove.getValue().intValue());
						}
						taskVO3.setAssignerId(TaskVO.EAssigner.Default.getValue().intValue()+"");
						taskVO3.setId(takeLeaveForm.getId());
						try {
							Date postDate = new SimpleDateFormat("yyyyMMddHHmmss").parse(takeLeaveForm.getApplyNo());
							taskVO3.setPostTime(UtilDateTime.toDateString(postDate,"yyyy-MM-dd HH:mm:ss"));
						} catch (ParseException e) {
							e.printStackTrace();
						}
						if(takeLeaveForm.getType().intValue()==TakeLeaveForm.Types.BusinessTrip.getValue().intValue())
							taskVO3.setTitle(TaskVO.ETitle.AskForLeave_BusinessTrip_PrincipalApprove.getText());
						else if(takeLeaveForm.getType().intValue()==TakeLeaveForm.Types.Leave.getValue().intValue())
							taskVO3.setTitle(TaskVO.ETitle.AskForLeave_Leave_PrincipalApprove.getText());
						if(takeLeaveForm.getPrincipalStatus()==null){
							if(takeLeaveForm.getStatus()!=null&&takeLeaveForm.getStatus().intValue()==TakeLeaveForm.Status.Cancle.getValue().intValue())
								taskVO3.setStatus(TaskVO.EStatus.Cancled.getText());
							else taskVO3.setStatus(TaskVO.EStatus.ToBeDeal.getText());
							
						}
						else taskVO3.setStatus(TaskVO.EStatus.Finished.getText());
						taskVO3.setWorkersIds(takeLeaveForm.getTeacherId());
						list.add(taskVO3);
					}
				}
		//加班审批任务
		List<OverWorkForm> overWorkList=overWorkDAO.getOverWorkAppliesByConditions(accountId, null, beginTime, endTime, null, null);
		if(overWorkList!=null&&overWorkList.size()>0)
			for(OverWorkForm overWorkForm:overWorkList){
						TaskVO taskVO1=new TaskVO();
						taskVO1.setType(TaskVO.EType.OverWork_OfficalApprove.getText());
						taskVO1.setTypeId(TaskVO.EType.OverWork_OfficalApprove.getValue().intValue());
						taskVO1.setAssignerId(TaskVO.EAssigner.Default.getValue().intValue()+"");
						taskVO1.setId(overWorkForm.getId());
						try {
							Date postDate = new SimpleDateFormat("yyyyMMddHHmmss").parse(overWorkForm.getApplyNo());
							taskVO1.setPostTime(UtilDateTime.toDateString(postDate,"yyyy-MM-dd HH:mm:ss"));
						} catch (ParseException e) {
							e.printStackTrace();
						}
						taskVO1.setTitle(TaskVO.ETitle.OverWork_OfficalApprove.getText());
						if(overWorkForm.getOfficeChiefStatus()==null){
							if(overWorkForm.getStatus()!=null&&overWorkForm.getStatus().intValue()==TakeLeaveForm.Status.Cancle.getValue().intValue())
								taskVO1.setStatus(TaskVO.EStatus.Cancled.getText());
							else taskVO1.setStatus(TaskVO.EStatus.ToBeDeal.getText());
						}
						else taskVO1.setStatus(TaskVO.EStatus.Finished.getText());
						taskVO1.setWorkersIds(overWorkForm.getTeacherId());
						list.add(taskVO1);
				
					
				}
		//调休审批任务
		List<MoveRestDayForm> moveRestDayList=moveRestDayDAO.getMoveRestDayAppliesByConditions(accountId, null, beginTime, endTime, null, null);
		if(moveRestDayList!=null&&moveRestDayList.size()>0)
			for(MoveRestDayForm moveRestDayForm:moveRestDayList){
						//处室审批
						TaskVO taskVO1=new TaskVO();
						taskVO1.setType(TaskVO.EType.MoveRestDay_OfficalApprove.getText());
						taskVO1.setTypeId(TaskVO.EType.MoveRestDay_OfficalApprove.getValue().intValue());
						taskVO1.setAssignerId(TaskVO.EAssigner.Default.getValue().intValue()+"");
						taskVO1.setId(moveRestDayForm.getId());
						try {
							Date postDate = new SimpleDateFormat("yyyyMMddHHmmss").parse(moveRestDayForm.getApplyNo());
							taskVO1.setPostTime(UtilDateTime.toDateString(postDate,"yyyy-MM-dd HH:mm:ss"));
						} catch (ParseException e) {
							e.printStackTrace();
						}
						taskVO1.setTitle(TaskVO.ETitle.MoveRestDay_OfficalApprove.getText());
						if(moveRestDayForm.getOfficeChiefStatus()==null){
							if(moveRestDayForm.getStatus()!=null&&moveRestDayForm.getStatus().intValue()==TakeLeaveForm.Status.Cancle.getValue().intValue())
								taskVO1.setStatus(TaskVO.EStatus.Cancled.getText());
							else taskVO1.setStatus(TaskVO.EStatus.ToBeDeal.getText());
						}
						else taskVO1.setStatus(TaskVO.EStatus.Finished.getText());
						taskVO1.setWorkersIds(moveRestDayForm.getTeacherId());
						list.add(taskVO1);
						//副校长审批
						if(moveRestDayForm.getOfficeChiefStatus()!=null&&moveRestDayForm.getOfficeChiefStatus().intValue()==1){
							TaskVO taskVO2=new TaskVO();
							taskVO2.setType(TaskVO.EType.MoveRestDay_VicePrincipalApprove.getText());
							taskVO2.setTypeId(TaskVO.EType.MoveRestDay_VicePrincipalApprove.getValue().intValue());
							taskVO2.setAssignerId(TaskVO.EAssigner.Default.getValue().intValue()+"");
							taskVO2.setId(moveRestDayForm.getId());
							try {
								Date postDate = new SimpleDateFormat("yyyyMMddHHmmss").parse(moveRestDayForm.getApplyNo());
								taskVO2.setPostTime(UtilDateTime.toDateString(postDate,"yyyy-MM-dd HH:mm:ss"));
							} catch (ParseException e) {
								e.printStackTrace();
							}
							taskVO2.setTitle(TaskVO.ETitle.MoveRestDay_VicePrincipalApprove.getText());
							if(moveRestDayForm.getVicePrincipalStatus()==null){
								if(moveRestDayForm.getStatus()!=null&&moveRestDayForm.getStatus().intValue()==TakeLeaveForm.Status.Cancle.getValue().intValue())
									taskVO2.setStatus(TaskVO.EStatus.Cancled.getText());
								else taskVO2.setStatus(TaskVO.EStatus.ToBeDeal.getText());
							}
							else taskVO2.setStatus(TaskVO.EStatus.Finished.getText());
							taskVO2.setWorkersIds(moveRestDayForm.getTeacherId());
							list.add(taskVO2);
						}
					
				}	
		//调课审批任务
		List<ApplyModel> applyList=courseAdjustDAO.getAppliesByCondition(accountId, null, null, beginTime, endTime);
		if(applyList!=null&&applyList.size()>0)
			for(ApplyModel applyModel:applyList){
						TaskVO taskVO1=new TaskVO();
						taskVO1.setType(TaskVO.EType.CourseAdjust_Approve.getText());
						taskVO1.setTypeId(TaskVO.EType.CourseAdjust_Approve.getValue().intValue());
						taskVO1.setAssignerId(TaskVO.EAssigner.Default.getValue().intValue()+"");
						taskVO1.setId(applyModel.getId());
						try {
							Date postDate = new SimpleDateFormat("yyyyMMddHHmmss").parse(applyModel.getApplyNo());
							taskVO1.setPostTime(UtilDateTime.toDateString(postDate,"yyyy-MM-dd HH:mm:ss"));
						} catch (ParseException e) {
							e.printStackTrace();
						}
						taskVO1.setTitle(TaskVO.ETitle.CourseAdjust_Approve.getText());
						if(applyModel.getApplyStatus()==ApplyModel.ApplyStatus.CANCLE.getStatus()){
								taskVO1.setStatus(TaskVO.EStatus.Cancled.getText());
						}else if(applyModel.getApplyStatus()==ApplyModel.ApplyStatus.WAITING.getStatus()){
								taskVO1.setStatus(TaskVO.EStatus.ToBeDeal.getText());
						}
						else taskVO1.setStatus(TaskVO.EStatus.Finished.getText());
						taskVO1.setWorkersIds(applyModel.getApplyTeacherId());
						list.add(taskVO1);
						
					
				}
		//会议室申请落实审批任务
		List<ConferenceModel> conferenceList=conferenceDAO.getConferencesByConditions(accountId, null, null, null, null, null, beginTime, endTime);
		if(conferenceList!=null&&conferenceList.size()>0)
			for(ConferenceModel conferenceModel:conferenceList){
						TaskVO taskVO1=new TaskVO();
						taskVO1.setType(TaskVO.EType.Conference_Approve.getText());
						taskVO1.setTypeId(TaskVO.EType.Conference_Approve.getValue().intValue());
						taskVO1.setAssignerId(TaskVO.EAssigner.Default.getValue().intValue()+"");
						taskVO1.setId(conferenceModel.getId());
						
						taskVO1.setPostTime(UtilDateTime.toDateString(conferenceModel.getApplyDateTime(),"yyyy-MM-dd HH:mm:ss"));
						taskVO1.setTitle(TaskVO.ETitle.Conference_Approve.getText());
						if(conferenceModel.getApplyStatus().intValue()==ConferenceModel.EStatus.Cancled.getValue().intValue()||conferenceModel.getApplyStatus().intValue()==ConferenceModel.EStatus.ArrangedCancled.getValue().intValue()){
								taskVO1.setStatus(TaskVO.EStatus.Cancled.getText());
						}else if(conferenceModel.getApplyStatus().intValue()==ConferenceModel.EStatus.Booking.getValue().intValue()){
								taskVO1.setStatus(TaskVO.EStatus.ToBeDeal.getText());
						}
						else taskVO1.setStatus(TaskVO.EStatus.Finished.getText());
						taskVO1.setWorkersIds(conferenceModel.getApplyUserId());
						list.add(taskVO1);
						
					
				}
		return list;
	}
	@Override
	public List<TaskVO> getAllWaittingDealTasksByCondition(String accountId, String beginTime, String endTime) {
		// TODO Auto-generated method stub
		List<TaskVO> list=new ArrayList<TaskVO>();
		//领导指派任务
		List<TaskModel> taskList=taskDAO.getTasksByConditions(null, accountId, TaskModel.EStatus.OnGoing.getValue().intValue()+"", beginTime, endTime);
		if(taskList!=null&&taskList.size()>0)
		for(TaskModel task:taskList){
			TaskVO taskVO=new TaskVO();
			taskVO.setType(TaskVO.EType.Task.getText());
			taskVO.setTypeId(TaskVO.EType.Task.getValue().intValue());
			taskVO.setAssignerId(task.getAssignerId());
			taskVO.setId(task.getId());
			taskVO.setPostTime(UtilDateTime.toDateString(task.getPostTime(),"yyyy-MM-dd HH:mm:ss"));
			taskVO.setTitle(task.getTitle());
			if(task.getStatus().intValue()==0)
				taskVO.setStatus(TaskVO.EStatus.OnGoing.getText());
			else if(task.getStatus().intValue()==1)
				taskVO.setStatus(TaskVO.EStatus.Finished.getText());
			taskVO.setWorkersIds(task.getWorkerIds());
			list.add(taskVO);
		}
		//请假出差审批任务
		List<TakeLeaveForm> takeLeaveList=takeLeaveDAO.getTakeLeaveAppliesByConditions(accountId,null,null,beginTime,endTime,null,null);
		if(takeLeaveList!=null&&takeLeaveList.size()>0)
			for(TakeLeaveForm takeLeaveForm:takeLeaveList){
					//请假出差期间工作落实
				if(takeLeaveForm.getArrangeTechDealAlready()==false&&takeLeaveForm.getStatus().intValue()!=TakeLeaveForm.Status.Cancle.getValue().intValue()){
					TaskVO taskVO=new TaskVO();
					taskVO.setStatus(TaskVO.EStatus.ToBeDeal.getText());
					if(takeLeaveForm.getType().intValue()==TakeLeaveForm.Types.BusinessTrip.getValue().intValue()){
						taskVO.setType(TaskVO.EType.AskForLeave_BusinessTrip_TechArrange.getText());
						taskVO.setTypeId(TaskVO.EType.AskForLeave_BusinessTrip_TechArrange.getValue().intValue());
					}
					else if(takeLeaveForm.getType().intValue()==TakeLeaveForm.Types.Leave.getValue().intValue()){
						taskVO.setType(TaskVO.EType.AskForLeave_Leave_TechArrange.getText());
						taskVO.setTypeId(TaskVO.EType.AskForLeave_Leave_TechArrange.getValue().intValue());
					}
						
					taskVO.setAssignerId(TaskVO.EAssigner.Default.getValue().intValue()+"");
					taskVO.setId(takeLeaveForm.getId());
					try {
						Date postDate = new SimpleDateFormat("yyyyMMddHHmmss").parse(takeLeaveForm.getApplyNo());
						taskVO.setPostTime(UtilDateTime.toDateString(postDate,"yyyy-MM-dd HH:mm:ss"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
					if(takeLeaveForm.getType().intValue()==TakeLeaveForm.Types.BusinessTrip.getValue().intValue())
						taskVO.setTitle(TaskVO.ETitle.AskForLeave_BusinessTrip_TechArrange.getText());
					else if(takeLeaveForm.getType().intValue()==TakeLeaveForm.Types.Leave.getValue().intValue())
						taskVO.setTitle(TaskVO.ETitle.AskForLeave_Leave_TechArrange.getText());
					taskVO.setWorkersIds(takeLeaveForm.getTeacherId());
					taskVO.setStatus(TaskVO.EStatus.ToBeDeal.getText());
					list.add(taskVO);
				}
					
					//请假出差处室审批
					if(takeLeaveForm.getArrangeTechDealAlready()==true&&takeLeaveForm.getOfficeChiefStatus()==null&&takeLeaveForm.getStatus().intValue()!=TakeLeaveForm.Status.Cancle.getValue().intValue()){
						TaskVO taskVO1=new TaskVO();
						taskVO1.setStatus(TaskVO.EStatus.ToBeDeal.getText());
						if(takeLeaveForm.getType().intValue()==TakeLeaveForm.Types.BusinessTrip.getValue().intValue()){
							taskVO1.setType(TaskVO.EType.AskForLeave_BusinessTrip_OfficalApprove.getText());
							taskVO1.setTypeId(TaskVO.EType.AskForLeave_BusinessTrip_OfficalApprove.getValue().intValue());
						}
						else if(takeLeaveForm.getType().intValue()==TakeLeaveForm.Types.Leave.getValue().intValue()){
							taskVO1.setType(TaskVO.EType.AskForLeave_Leave_OfficalApprove.getText());
							taskVO1.setTypeId(TaskVO.EType.AskForLeave_Leave_OfficalApprove.getValue().intValue());
						}
						taskVO1.setAssignerId(TaskVO.EAssigner.Default.getValue().intValue()+"");
						taskVO1.setId(takeLeaveForm.getId());
						try {
							Date postDate = new SimpleDateFormat("yyyyMMddHHmmss").parse(takeLeaveForm.getApplyNo());
							taskVO1.setPostTime(UtilDateTime.toDateString(postDate,"yyyy-MM-dd HH:mm:ss"));
						} catch (ParseException e) {
							e.printStackTrace();
						}
						if(takeLeaveForm.getType().intValue()==TakeLeaveForm.Types.BusinessTrip.getValue().intValue())
							taskVO1.setTitle(TaskVO.ETitle.AskForLeave_BusinessTrip_OfficalApprove.getText());
						else if(takeLeaveForm.getType().intValue()==TakeLeaveForm.Types.Leave.getValue().intValue())
							taskVO1.setTitle(TaskVO.ETitle.AskForLeave_Leave_OfficalApprove.getText());
						taskVO1.setStatus(TaskVO.EStatus.ToBeDeal.getText());
						
					}
					//请假出差副校长审批
					if(takeLeaveForm.getOfficeChiefStatus()!=null&&takeLeaveForm.getOfficeChiefStatus().intValue()==1&&takeLeaveForm.getVicePrincipalStatus()==null&&takeLeaveForm.getStatus().intValue()!=TakeLeaveForm.Status.Cancle.getValue().intValue()){
						TaskVO taskVO2=new TaskVO();
						taskVO2.setStatus(TaskVO.EStatus.ToBeDeal.getText());
						if(takeLeaveForm.getType().intValue()==TakeLeaveForm.Types.BusinessTrip.getValue().intValue()){
							taskVO2.setType(TaskVO.EType.AskForLeave_BusinessTrip_VicePrincipalApprove.getText());
							taskVO2.setTypeId(TaskVO.EType.AskForLeave_BusinessTrip_VicePrincipalApprove.getValue().intValue());
						}
						else if(takeLeaveForm.getType().intValue()==TakeLeaveForm.Types.Leave.getValue().intValue()){
							taskVO2.setType(TaskVO.EType.AskForLeave_Leave_VicePrincipalApprove.getText());
							taskVO2.setTypeId(TaskVO.EType.AskForLeave_Leave_VicePrincipalApprove.getValue().intValue());
						}
						taskVO2.setAssignerId(TaskVO.EAssigner.Default.getValue().intValue()+"");
						taskVO2.setId(takeLeaveForm.getId());
						try {
							Date postDate = new SimpleDateFormat("yyyyMMddHHmmss").parse(takeLeaveForm.getApplyNo());
							taskVO2.setPostTime(UtilDateTime.toDateString(postDate,"yyyy-MM-dd HH:mm:ss"));
						} catch (ParseException e) {
							e.printStackTrace();
						}
						if(takeLeaveForm.getType().intValue()==TakeLeaveForm.Types.BusinessTrip.getValue().intValue())
							taskVO2.setTitle(TaskVO.ETitle.AskForLeave_BusinessTrip_VicePrincipalApprove.getText());
						else if(takeLeaveForm.getType().intValue()==TakeLeaveForm.Types.Leave.getValue().intValue())
							taskVO2.setTitle(TaskVO.ETitle.AskForLeave_Leave_VicePrincipalApprove.getText());
						
						taskVO2.setStatus(TaskVO.EStatus.ToBeDeal.getText());
						
						taskVO2.setWorkersIds(takeLeaveForm.getTeacherId());
						list.add(taskVO2);
					}
					
					//请假出差校长审批
					if(takeLeaveForm.getVicePrincipalStatus()!=null&&takeLeaveForm.getVicePrincipalStatus().intValue()==1&&takeLeaveForm.getPrincipalStatus()==null&&takeLeaveForm.getStatus().intValue()!=TakeLeaveForm.Status.Cancle.getValue().intValue()){
						TaskVO taskVO3=new TaskVO();
						taskVO3.setStatus(TaskVO.EStatus.ToBeDeal.getText());
						if(takeLeaveForm.getType().intValue()==TakeLeaveForm.Types.BusinessTrip.getValue().intValue()){
							taskVO3.setType(TaskVO.EType.AskForLeave_BusinessTrip_PrincipalApprove.getText());
							taskVO3.setTypeId(TaskVO.EType.AskForLeave_BusinessTrip_PrincipalApprove.getValue().intValue());
						}
						else if(takeLeaveForm.getType().intValue()==TakeLeaveForm.Types.Leave.getValue().intValue()){
							taskVO3.setType(TaskVO.EType.AskForLeave_Leave_PrincipalApprove.getText());
							taskVO3.setTypeId(TaskVO.EType.AskForLeave_Leave_PrincipalApprove.getValue().intValue());
						}
						taskVO3.setAssignerId(TaskVO.EAssigner.Default.getValue().intValue()+"");
						taskVO3.setId(takeLeaveForm.getId());
						try {
							Date postDate = new SimpleDateFormat("yyyyMMddHHmmss").parse(takeLeaveForm.getApplyNo());
							taskVO3.setPostTime(UtilDateTime.toDateString(postDate,"yyyy-MM-dd HH:mm:ss"));
						} catch (ParseException e) {
							e.printStackTrace();
						}
						if(takeLeaveForm.getType().intValue()==TakeLeaveForm.Types.BusinessTrip.getValue().intValue())
							taskVO3.setTitle(TaskVO.ETitle.AskForLeave_BusinessTrip_PrincipalApprove.getText());
						else if(takeLeaveForm.getType().intValue()==TakeLeaveForm.Types.Leave.getValue().intValue())
							taskVO3.setTitle(TaskVO.ETitle.AskForLeave_Leave_PrincipalApprove.getText());

							taskVO3.setStatus(TaskVO.EStatus.ToBeDeal.getText());
							
						
						taskVO3.setWorkersIds(takeLeaveForm.getTeacherId());
						list.add(taskVO3);
					}
				}
		//加班审批任务
		List<OverWorkForm> overWorkList=overWorkDAO.getOverWorkAppliesByConditions(accountId, null, beginTime, endTime, null, null);
		if(overWorkList!=null&&overWorkList.size()>0)
			for(OverWorkForm overWorkForm:overWorkList){
					if(overWorkForm.getOfficeChiefStatus()==null&&overWorkForm.getStatus().intValue()!=OverWorkForm.Status.Cancle.getValue().intValue()){
	
							TaskVO taskVO1=new TaskVO();
							taskVO1.setType(TaskVO.EType.OverWork_OfficalApprove.getText());
							taskVO1.setTypeId(TaskVO.EType.OverWork_OfficalApprove.getValue().intValue());
							taskVO1.setAssignerId(TaskVO.EAssigner.Default.getValue().intValue()+"");
							taskVO1.setId(overWorkForm.getId());
							try {
								Date postDate = new SimpleDateFormat("yyyyMMddHHmmss").parse(overWorkForm.getApplyNo());
								taskVO1.setPostTime(UtilDateTime.toDateString(postDate,"yyyy-MM-dd HH:mm:ss"));
							} catch (ParseException e) {
								e.printStackTrace();
							}
							taskVO1.setTitle(TaskVO.ETitle.OverWork_OfficalApprove.getText());
							taskVO1.setStatus(TaskVO.EStatus.ToBeDeal.getText());
							taskVO1.setWorkersIds(overWorkForm.getTeacherId());
							list.add(taskVO1);
					}
					
				}
		//调休审批任务
		List<MoveRestDayForm> moveRestDayList=moveRestDayDAO.getMoveRestDayAppliesByConditions(accountId, null, beginTime, endTime, null, null);
		if(moveRestDayList!=null&&moveRestDayList.size()>0)
			for(MoveRestDayForm moveRestDayForm:moveRestDayList){
						//处室审批
				if(moveRestDayForm.getOfficeChiefStatus()==null&&moveRestDayForm.getStatus().intValue()!=TakeLeaveForm.Status.Cancle.getValue().intValue()){

						TaskVO taskVO1=new TaskVO();
						taskVO1.setType(TaskVO.EType.MoveRestDay_OfficalApprove.getText());
						taskVO1.setTypeId(TaskVO.EType.MoveRestDay_OfficalApprove.getValue().intValue());
						taskVO1.setAssignerId(TaskVO.EAssigner.Default.getValue().intValue()+"");
						taskVO1.setId(moveRestDayForm.getId());
						try {
							Date postDate = new SimpleDateFormat("yyyyMMddHHmmss").parse(moveRestDayForm.getApplyNo());
							taskVO1.setPostTime(UtilDateTime.toDateString(postDate,"yyyy-MM-dd HH:mm:ss"));
						} catch (ParseException e) {
							e.printStackTrace();
						}
						taskVO1.setTitle(TaskVO.ETitle.MoveRestDay_OfficalApprove.getText());
					
						taskVO1.setStatus(TaskVO.EStatus.ToBeDeal.getText());
						
						taskVO1.setWorkersIds(moveRestDayForm.getTeacherId());
						list.add(taskVO1);
					}
						
						
						//副校长审批
				if(moveRestDayForm.getVicePrincipalStatus()==null&&moveRestDayForm.getStatus().intValue()!=TakeLeaveForm.Status.Cancle.getValue().intValue()){
						if(moveRestDayForm.getOfficeChiefStatus()!=null&&moveRestDayForm.getOfficeChiefStatus().intValue()==1){
							TaskVO taskVO2=new TaskVO();
							taskVO2.setType(TaskVO.EType.MoveRestDay_VicePrincipalApprove.getText());
							taskVO2.setTypeId(TaskVO.EType.MoveRestDay_VicePrincipalApprove.getValue().intValue());
							taskVO2.setAssignerId(TaskVO.EAssigner.Default.getValue().intValue()+"");
							taskVO2.setId(moveRestDayForm.getId());
							try {
								Date postDate = new SimpleDateFormat("yyyyMMddHHmmss").parse(moveRestDayForm.getApplyNo());
								taskVO2.setPostTime(UtilDateTime.toDateString(postDate,"yyyy-MM-dd HH:mm:ss"));
							} catch (ParseException e) {
								e.printStackTrace();
							}
							taskVO2.setTitle(TaskVO.ETitle.MoveRestDay_VicePrincipalApprove.getText());
							taskVO2.setStatus(TaskVO.EStatus.ToBeDeal.getText());
							
							taskVO2.setWorkersIds(moveRestDayForm.getTeacherId());
							list.add(taskVO2);
						}
				}
			}	
		//调课审批任务
		List<ApplyModel> applyList=courseAdjustDAO.getAppliesByCondition(accountId, null, null, beginTime, endTime);
		if(applyList!=null&&applyList.size()>0)
			for(ApplyModel applyModel:applyList){
				if(applyModel.getApplyStatus()==ApplyModel.ApplyStatus.WAITING.getStatus()){
						TaskVO taskVO1=new TaskVO();
						taskVO1.setType(TaskVO.EType.CourseAdjust_Approve.getText());
						taskVO1.setTypeId(TaskVO.EType.CourseAdjust_Approve.getValue().intValue());
						taskVO1.setAssignerId(TaskVO.EAssigner.Default.getValue().intValue()+"");
						taskVO1.setId(applyModel.getId());
						try {
							Date postDate = new SimpleDateFormat("yyyyMMddHHmmss").parse(applyModel.getApplyNo());
							taskVO1.setPostTime(UtilDateTime.toDateString(postDate,"yyyy-MM-dd HH:mm:ss"));
						} catch (ParseException e) {
							e.printStackTrace();
						}
						taskVO1.setTitle(TaskVO.ETitle.CourseAdjust_Approve.getText());
						
						taskVO1.setStatus(TaskVO.EStatus.ToBeDeal.getText());
						
						taskVO1.setWorkersIds(applyModel.getApplyTeacherId());
						list.add(taskVO1);
				}	
					
			}	
		//会议室申请落实审批任务
		List<ConferenceModel> conferenceList=conferenceDAO.getConferencesByConditions(accountId, null, null, null, null, null, beginTime, endTime);
		if(conferenceList!=null&&conferenceList.size()>0)
			for(ConferenceModel conferenceModel:conferenceList){
				if(conferenceModel.getApplyStatus().intValue()==ConferenceModel.EStatus.Booking.getValue().intValue()){
						TaskVO taskVO1=new TaskVO();
						taskVO1.setType(TaskVO.EType.Conference_Approve.getText());
						taskVO1.setTypeId(TaskVO.EType.Conference_Approve.getValue().intValue());
						taskVO1.setAssignerId(TaskVO.EAssigner.Default.getValue().intValue()+"");
						taskVO1.setId(conferenceModel.getId());
						
						taskVO1.setPostTime(UtilDateTime.toDateString(conferenceModel.getApplyDateTime(),"yyyy-MM-dd HH:mm:ss"));
						taskVO1.setTitle(TaskVO.ETitle.Conference_Approve.getText());
						
						taskVO1.setStatus(TaskVO.EStatus.ToBeDeal.getText());
					
						taskVO1.setWorkersIds(conferenceModel.getApplyUserId());
						list.add(taskVO1);
				}		
			}
		return list;
	}
	public TaskDAO getTaskDAO() {
		return taskDAO;
	}

	public void setTaskDAO(TaskDAO taskDAO) {
		this.taskDAO = taskDAO;
	}

	public CourseAdjustDAO getCourseAdjustDAO() {
		return courseAdjustDAO;
	}

	public void setCourseAdjustDAO(CourseAdjustDAO courseAdjustDAO) {
		this.courseAdjustDAO = courseAdjustDAO;
	}

	public MoveRestDayDAO getMoveRestDayDAO() {
		return moveRestDayDAO;
	}

	public void setMoveRestDayDAO(MoveRestDayDAO moveRestDayDAO) {
		this.moveRestDayDAO = moveRestDayDAO;
	}

	public OverWorkDAO getOverWorkDAO() {
		return overWorkDAO;
	}

	public void setOverWorkDAO(OverWorkDAO overWorkDAO) {
		this.overWorkDAO = overWorkDAO;
	}

	public TakeLeaveDAO getTakeLeaveDAO() {
		return takeLeaveDAO;
	}

	public void setTakeLeaveDAO(TakeLeaveDAO takeLeaveDAO) {
		this.takeLeaveDAO = takeLeaveDAO;
	}
	public ConferenceDAO getConferenceDAO() {
		return conferenceDAO;
	}
	public void setConferenceDAO(ConferenceDAO conferenceDAO) {
		this.conferenceDAO = conferenceDAO;
	}
	
	

}
