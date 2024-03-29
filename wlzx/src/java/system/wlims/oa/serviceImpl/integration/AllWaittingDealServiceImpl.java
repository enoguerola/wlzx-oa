package system.wlims.oa.serviceImpl.integration;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import system.components.SecurityUserHolder;
import system.dao.DepartmentDAO;
import system.dao.RoleDAO;
import system.entity.DepartmentModel;
import system.entity.RoleModel;
import system.entity.UserModel;
import system.service.SystemService;
import system.utils.StringUtils;
import system.utils.UtilDateTime;
import system.wlims.oa.dao.attendance.MoveRestDayDAO;
import system.wlims.oa.dao.attendance.OverWorkDAO;
import system.wlims.oa.dao.attendance.TakeLeaveDAO;
import system.wlims.oa.dao.conference.ConferenceDAO;
import system.wlims.oa.dao.course.adjust.CourseAdjustDAO;
import system.wlims.oa.dao.receipt.ReceiptDAO;
import system.wlims.oa.dao.task.TaskDAO;
import system.wlims.oa.entity.conference.ConferenceModel;
import system.wlims.oa.entity.course.adjust.ApplyModel;
import system.wlims.oa.entity.receipt.FileFlowModel;
import system.wlims.oa.entity.task.TaskModel;
import system.wlims.oa.entity.workFlow.moveRestDay.MoveRestDayForm;
import system.wlims.oa.entity.workFlow.overWork.OverWorkForm;
import system.wlims.oa.entity.workFlow.takeLeave.TakeLeaveForm;
import system.wlims.oa.entity.workFlow.takeLeave.TakeLeaveTerminateForm;
import system.wlims.oa.service.integration.AllWaittingDealService;
import system.wlims.oa.vo.TaskVO;

public class AllWaittingDealServiceImpl  implements AllWaittingDealService{
	private TaskDAO taskDAO;
	private CourseAdjustDAO courseAdjustDAO;
	private MoveRestDayDAO moveRestDayDAO;
	private OverWorkDAO overWorkDAO;
	private TakeLeaveDAO takeLeaveDAO;
	private ConferenceDAO conferenceDAO;
//	private UserDAO userDAO;
	private RoleDAO roleDAO;
	private DepartmentDAO departmentDAO;
	private SystemService systemService;
	private ReceiptDAO receiptDAO;

	@Override
	public List<TaskVO> getAllDealTasksByCondition(String accountId, String beginTime, String endTime) {
		return getTasksByCondition(accountId,beginTime,endTime);
	}
	@Override
	public List<TaskVO> getAllHistoryTasksByCondition(String accountId,
			String beginTime, String endTime) {
		List<TaskVO> result=new ArrayList<TaskVO>();
		List<TaskVO> list=getTasksByCondition(accountId,beginTime,endTime);
		for(TaskVO task:list){
			if(!task.getStatus().equals(TaskVO.EStatus.ToBeDeal.getText()))
				result.add(task);
		}
		return result;
	}
	public ReceiptDAO getReceiptDAO() {
		return receiptDAO;
	}
	public void setReceiptDAO(ReceiptDAO receiptDAO) {
		this.receiptDAO = receiptDAO;
	}
	@Override
	public List<TaskVO> getAllWaittingDealTasksByCondition(String accountId, String beginTime, String endTime) {

		List<TaskVO> result=new ArrayList<TaskVO>();
		List<TaskVO> list=getTasksByCondition(accountId,beginTime,endTime);
		for(TaskVO task:list){
			if(task.getStatus().equals(TaskVO.EStatus.ToBeDeal.getText()))
				result.add(task);
		}
		return result;
	}
	private List<TaskVO> getTasksByCondition(String accountId, String beginTime, String endTime) {
		// TODO Auto-generated method stub
		List<TaskVO> list=new ArrayList<TaskVO>();
		UserModel user=systemService.getUserByUserId(accountId);
		if(user==null)return null;
		long begin_a=System.currentTimeMillis();
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
				taskVO.setContent(task.getContent());
				if(task.getStatusByWorkerId(accountId)==null)continue;
				if(task.getStatusByWorkerId(accountId).equals(TaskModel.EStatus.OnGoing.getValue().intValue()+""))
					taskVO.setStatus(TaskVO.EStatus.ToBeDeal.getText());
				else if(task.getStatusByWorkerId(accountId).equals(TaskModel.EStatus.Finished.getValue().intValue()+""))
					taskVO.setStatus(TaskVO.EStatus.Finished.getText());
				taskVO.setWorkersIds(task.getWorkerIds());
				list.add(taskVO);
		}
		System.out.println(System.currentTimeMillis()-begin_a+"a");
		
		long begin_b=System.currentTimeMillis();
		
		List<RoleModel> teachingRoles=roleDAO.getTeachingRoles();
		DepartmentModel rootDepartment=departmentDAO.getDepartmentBySymbol("root");
		
		
		//请假出差审批任务
		List<TakeLeaveForm> takeLeaveList=takeLeaveDAO.getTakeLeaveAppliesByConditions(null,null,TakeLeaveForm.Status.Waiting.getValue().intValue()+","+TakeLeaveForm.Status.OfficePass.getValue().intValue()+","+TakeLeaveForm.Status.VicePrincipalPass.getValue().intValue()+","+TakeLeaveForm.Status.TerminateWaiting.getValue().intValue()+","+TakeLeaveForm.Status.TerminatePass.getValue().intValue()+","+TakeLeaveForm.Status.TerminateDeny.getValue().intValue(),beginTime,endTime,null,null);
		if(takeLeaveList!=null&&takeLeaveList.size()>0)
			for(TakeLeaveForm takeLeaveForm:takeLeaveList){

				/**
				 * 1.请假人在行政组【0级部门】中---教学1级审批权限人审批【课程处】--教学2级审批权限人审批【教学副校长】--所有审批权限人审批【校长】----------通过给行政组的人配置教学职务来绕开
				 * 2.请假人拥有教学职务『
				 * 					主职务含有教学职务（“教师”“教研组长”）:教学1级审批权限人审批【课程处】--教学2级审批权限人审批【教学副校长】--所有审批权限人审批【校长】
				 * 					副职务含有教学职务（“教师”“教研组长”）:1级下属审批权限【本部门处长】--2级下属审批权限【本部门分管副校长】--所有审批权限人审批【校长】；通知拥有教学1级审批权限人审批的人【课程处】
				 * 				』
				 * 3.其他---1级下属审批权限【本部门处长】--2级下属审批权限【本部门分管副校长】--所有审批权限人审批【校长】
				 */
				
				long begin_t=System.currentTimeMillis();
				UserModel applier=systemService.getUserByUserId(takeLeaveForm.getTeacherId());
				System.out.println(System.currentTimeMillis()-begin_t+"t0");
				Boolean hasTeachingRoleInMain=false;
     			Boolean hasTeachingRole=false;
     			Boolean hasRootDepartment=false;
			
				if(teachingRoles!=null&&teachingRoles.size()>0){
					for(RoleModel teachingRole:teachingRoles){
						if(applier.hasRoleInMain(teachingRole.getId())){
							hasTeachingRoleInMain=true;
							break;
						}
					}
					System.out.println(System.currentTimeMillis()-begin_t+"t1");
					for(RoleModel teachingRole:teachingRoles){
						if(applier.hasRole(teachingRole.getId())){
							hasTeachingRole=true;
							break;
						}
					}
					System.out.println(System.currentTimeMillis()-begin_t+"t2");
				}
				if(rootDepartment!=null&&applier.hasDepartment(rootDepartment.getId())){
					hasRootDepartment=true;
				}
				applier.setHasTeachingRole(hasTeachingRole);
				applier.setHasTeachingRoleInMain(hasTeachingRoleInMain);
				applier.setHasRootDepartment(hasRootDepartment);
				System.out.println(System.currentTimeMillis()-begin_t+"t3");

				// 请假人拥有教学职务
				if(applier.getHasTeachingRoleInMain()==true||applier.getHasRootDepartment()==true){
					//请假出差教学1级审批权限人审批【课程处】
					if(user.hasDam("takeLeaveOfficeTeachingApprove@noFilter@")){
						//if(takeLeaveForm.getArrangeTechDealAlready()==true){
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
							taskVO1.setWorkersIds(getWorkersIds(TaskVO.EType.AskForLeave_Leave_Teaching_OfficalApprove.getValue(),accountId));
							//taskVO1.setWorkersIds(takeLeaveForm.getTeacherId());
							list.add(taskVO1);
						//}
					}
					//请假出差教学2级审批权限人审批【教学副校长】
					if(user.hasDam("takeLeaveVicePrincipalTeachingApprove@noFilter@")){
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
							taskVO2.setWorkersIds(getWorkersIds(TaskVO.EType.AskForLeave_Leave_Teaching_VicePrincipalApprove.getValue(),accountId));
							//taskVO2.setWorkersIds(takeLeaveForm.getTeacherId());
							list.add(taskVO2);
						}
					}	
					//请假出差所有审批权限人审批【校长】
					if(user.hasDam("takeLeavePrincipalApprove@noFilter@")){
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
							taskVO3.setWorkersIds(getWorkersIds(TaskVO.EType.AskForLeave_BusinessTrip_PrincipalApprove.getValue(),accountId));
							//taskVO3.setWorkersIds(takeLeaveForm.getTeacherId());
							list.add(taskVO3);
						}
					}
					
				
					
				}else{// 其他
					//请假出差本处室审批
					if(user.hasDam("takeLeaveOfficeApprove@noFilter@")&&SecurityUserHolder.getCurrentUser()!=null&&SecurityUserHolder.getCurrentUser().hasSubordinateUser(takeLeaveForm.getTeacherId())){
						//if(takeLeaveForm.getArrangeTechDealAlready()==true){
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
							taskVO1.setWorkersIds(getWorkersIds(TaskVO.EType.AskForLeave_BusinessTrip_OfficalApprove.getValue(),accountId));
							//taskVO1.setWorkersIds(takeLeaveForm.getTeacherId());
							list.add(taskVO1);
						//}
					}
					//请假出差分管副校长审批
					if(user.hasDam("takeLeaveVicePrincipalApprove@noFilter@")&&SecurityUserHolder.getCurrentUser()!=null&&SecurityUserHolder.getCurrentUser().hasSubordinateUser(takeLeaveForm.getTeacherId())){
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
							taskVO2.setWorkersIds(getWorkersIds(TaskVO.EType.AskForLeave_BusinessTrip_VicePrincipalApprove.getValue(),accountId));
							//taskVO2.setWorkersIds(takeLeaveForm.getTeacherId());
							list.add(taskVO2);
						}
					}	
					//请假出差校长审批
					if(user.hasDam("takeLeavePrincipalApprove@noFilter@")){
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
							taskVO3.setWorkersIds(getWorkersIds(TaskVO.EType.AskForLeave_BusinessTrip_PrincipalApprove.getValue(),accountId));
							//taskVO3.setWorkersIds(takeLeaveForm.getTeacherId());
							list.add(taskVO3);
						}
					}
					
				}
				
				//销假审批
				if(user.hasDam("takeLeaveTerminateApprove@noFilter@")){
					if(takeLeaveForm.getTakeLeaveTerminateForm()!=null&&StringUtils.isNotEmpty(takeLeaveForm.getTakeLeaveTerminateForm().getId())){
						TaskVO taskVO3=new TaskVO();
						taskVO3.setStatus(TaskVO.EStatus.ToBeDeal.getText());
						taskVO3.setType(TaskVO.EType.AskForLeave_Cancle.getText());
						taskVO3.setTypeId(TaskVO.EType.AskForLeave_Cancle.getValue().intValue());
						taskVO3.setAssignerId(TaskVO.EAssigner.Default.getValue().intValue()+"");
						taskVO3.setId(takeLeaveForm.getId());
						taskVO3.setPostTime(UtilDateTime.toDateString(takeLeaveForm.getTakeLeaveTerminateForm().getTerminateApplyTime(),"yyyy-MM-dd HH:mm:ss"));
						taskVO3.setTitle(TaskVO.ETitle.AskForLeave_Cancle.getText());
						if(takeLeaveForm.getTakeLeaveTerminateForm().getStatus().intValue()==TakeLeaveTerminateForm.Status.Waiting.getValue().intValue()){
							taskVO3.setStatus(TaskVO.EStatus.ToBeDeal.getText());
						}	else taskVO3.setStatus(TaskVO.EStatus.Finished.getText());
						taskVO3.setWorkersIds(getWorkersIds(TaskVO.EType.AskForLeave_Cancle.getValue(),accountId));
						//taskVO3.setWorkersIds(takeLeaveForm.getTeacherId());
						list.add(taskVO3);
					}
				}
				}
				System.out.println(System.currentTimeMillis()-begin_b+"b");
				
				long begin_d=System.currentTimeMillis();
				//加班审批任务
				List<OverWorkForm> overWorkList=overWorkDAO.getOverWorkAppliesByConditions(null, null, beginTime, endTime, null, null);
				if(overWorkList!=null&&overWorkList.size()>0)
					for(OverWorkForm overWorkForm:overWorkList){
						if(user.hasDam("overWork_approve_main@defaultVisit@@noFilter@")){
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
								taskVO1.setWorkersIds(getWorkersIds(TaskVO.EType.OverWork_OfficalApprove.getValue(),accountId));
								list.add(taskVO1);
						}
							
						}
				System.out.println(System.currentTimeMillis()-begin_d+"d");
				long begin_e=System.currentTimeMillis();
				//调休审批任务
				List<MoveRestDayForm> moveRestDayList=moveRestDayDAO.getMoveRestDayAppliesByConditions(null, null, beginTime, endTime, null, null);
				if(moveRestDayList!=null&&moveRestDayList.size()>0)
					for(MoveRestDayForm moveRestDayForm:moveRestDayList){
								//处室审批
						if(user.hasDam("moveRestDayOfficeApprove@noFilter@")){
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
								taskVO1.setWorkersIds(getWorkersIds(TaskVO.EType.MoveRestDay_OfficalApprove.getValue(),accountId));
								list.add(taskVO1);
						}	
						//副校长审批
						if(user.hasDam("moveRestDayVicePrincipalApprove@noFilter@")){
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
									taskVO2.setWorkersIds(getWorkersIds(TaskVO.EType.MoveRestDay_VicePrincipalApprove.getValue(),accountId));
									list.add(taskVO2);
								}
						}
						}
				System.out.println(System.currentTimeMillis()-begin_e+"e");
				long begin_h=System.currentTimeMillis();
				//调课审批任务
				List<ApplyModel> applyList=courseAdjustDAO.getAppliesByCondition(null, null, null, beginTime, endTime);
				if(applyList!=null&&applyList.size()>0)
					for(ApplyModel applyModel:applyList){
						//课务安排
						if(user.hasDam("adjust_class_apply_arrange_main@defaultVisit@@noFilter@")){
							
							TaskVO taskVO1=new TaskVO();
							taskVO1.setType(TaskVO.EType.CourseAdjust_Arrange.getText());
							taskVO1.setTypeId(TaskVO.EType.CourseAdjust_Arrange.getValue().intValue());
							taskVO1.setAssignerId(TaskVO.EAssigner.Default.getValue().intValue()+"");
							taskVO1.setId(applyModel.getId());
							try {
								Date postDate = new SimpleDateFormat("yyyyMMddHHmmss").parse(applyModel.getApplyNo());
								taskVO1.setPostTime(UtilDateTime.toDateString(postDate,"yyyy-MM-dd HH:mm:ss"));
							} catch (ParseException e) {
								e.printStackTrace();
							}
							taskVO1.setTitle(TaskVO.ETitle.CourseAdjust_Arrange.getText());
							if(applyModel.getApplyStatus()==ApplyModel.ApplyStatus.CANCLE.getStatus()){
									taskVO1.setStatus(TaskVO.EStatus.Cancled.getText());
							}else if(applyModel.alreadyArranged()==false){
									taskVO1.setStatus(TaskVO.EStatus.ToBeDeal.getText());
							}
							else taskVO1.setStatus(TaskVO.EStatus.Finished.getText());
							//taskVO1.setWorkersIds(applyModel.getApplyTeacherId());
							taskVO1.setWorkersIds(getWorkersIds(TaskVO.EType.CourseAdjust_Arrange.getValue(),accountId));
							list.add(taskVO1);
					}	
						//审批
						if(user.hasDam("adjust_class_apply_approve_main@defaultVisit@@noFilter@")){
							if(applyModel.alreadyArranged()==true){
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
								//taskVO1.setWorkersIds(applyModel.getApplyTeacherId());
								taskVO1.setWorkersIds(getWorkersIds(TaskVO.EType.CourseAdjust_Approve.getValue(),accountId));
								list.add(taskVO1);
								
							}
								
						}		
							
						}
				
				System.out.println(System.currentTimeMillis()-begin_h+"h");
				long begin_f=System.currentTimeMillis();
				//会议室申请落实审批任务
				List<ConferenceModel> conferenceList=conferenceDAO.getConferencesByConditions(null, null, null, null, null, null, beginTime, endTime);
				if(conferenceList!=null&&conferenceList.size()>0)
					for(ConferenceModel conferenceModel:conferenceList){
						if(user.hasDam("conferenceArrange_main@defaultVisit@@noFilter@")){
						
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
								taskVO1.setWorkersIds(getWorkersIds(TaskVO.EType.Conference_Approve.getValue(),accountId));
								//taskVO1.setWorkersIds(conferenceModel.getApplyUserId());
								list.add(taskVO1);
								
							
						}
					}
				
				System.out.println(System.currentTimeMillis()-begin_f+"f");
				long begin_g=System.currentTimeMillis();
				
				//收文任务
				//List<ConferenceModel> conferenceList=conferenceDAO.getConferencesByConditions(null, null, null, null, null, null, beginTime, endTime);
				List<FileFlowModel> receiptList=receiptDAO.getReceiptFlowByConditions(user.getId());
		
				if(receiptList!=null&&receiptList.size()>0)
					for(FileFlowModel fileFlowModel:receiptList){
						//if(user.hasDam("conferenceArrange_main@defaultVisit@@noFilter@")){
						
								TaskVO taskVO1=new TaskVO();
								
								if(fileFlowModel.getType()==2){
									taskVO1.setType(TaskVO.EType.SW_NB.getText());
									taskVO1.setTypeId(TaskVO.EType.SW_NB.getValue().intValue());
									taskVO1.setTitle(TaskVO.ETitle.SW_NB.getText());
									//taskVO1.setWorkersIds(getWorkersIds(TaskVO.EType.SW_NB.getValue(),null));
								}else if (fileFlowModel.getType()==4){
									taskVO1.setType(TaskVO.EType.SW_PB.getText());
									taskVO1.setTypeId(TaskVO.EType.SW_PB.getValue().intValue());
									taskVO1.setTitle(TaskVO.ETitle.SW_PB.getText());
									//taskVO1.setWorkersIds(getWorkersIds(TaskVO.EType.SW_PB.getValue(),null));
								}else if (fileFlowModel.getType()==6){
									taskVO1.setType(TaskVO.EType.SW_CB.getText());
									taskVO1.setTypeId(TaskVO.EType.SW_CB.getValue().intValue());
									taskVO1.setTitle(TaskVO.ETitle.SW_CB.getText());
									//taskVO1.setWorkersIds(getWorkersIds(TaskVO.EType.SW_CB.getValue(),null));
								}else{
									taskVO1.setType(TaskVO.EType.SW_CY.getText());
									taskVO1.setTypeId(TaskVO.EType.SW_CY.getValue().intValue());
									taskVO1.setTitle(TaskVO.ETitle.SW_CY.getText());
									//taskVO1.setWorkersIds(getWorkersIds(TaskVO.EType.SW_CY.getValue(),null));
								}
								
								
								taskVO1.setWorkersIds(user.getId());
								
								taskVO1.setAssignerId(TaskVO.EAssigner.Default.getValue().intValue()+"");
								taskVO1.setId(fileFlowModel.getReceiptId()+ ";"+fileFlowModel.getId());
								
								taskVO1.setPostTime(UtilDateTime.toDateString(fileFlowModel.getCreationDate(),"yyyy-MM-dd HH:mm:ss"));
								
								taskVO1.setStatus(TaskVO.EStatus.ToBeDeal.getText());
								
								//taskVO1.setWorkersIds(conferenceModel.getApplyUserId());
								list.add(taskVO1);
								
							
						//}
					}
				System.out.println(System.currentTimeMillis()-begin_g+"g");
				return list;
	}

	//childId非空则取得的workerIds必须是childId的领导
	public String getWorkersIds(Integer type,String accountId){
//		if(StringUtils.isEmpty(childId)){
//			return systemService.getWorkersIds(type);
//		}
//		String ids= systemService.getWorkersIds(type);
//		if(StringUtils.isNotEmpty(ids)){
//			StringBuilder result=new StringBuilder() ;
//			String[] idAttrs=ids.split(";");
//			for(String id:idAttrs){
//				if(userDAO.get(id).hasSubordinateUser(childId))
//					result.append(id+";");
//				
//			}
//			return result.toString();
//			
//		}else return null;
		return accountId;
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
	
	public SystemService getSystemService() {
		return systemService;
	}
	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}
	public RoleDAO getRoleDAO() {
		return roleDAO;
	}
	public void setRoleDAO(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}
	public DepartmentDAO getDepartmentDAO() {
		return departmentDAO;
	}
	public void setDepartmentDAO(DepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}
	
	
	

}
