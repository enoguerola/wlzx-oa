package system.wlims.oa.serviceImpl.attendance;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import system.components.SecurityUserHolder;
import system.dao.DepartmentDAO;
import system.dao.RoleDAO;
import system.dao.UserDAO;
import system.entity.DepartmentModel;
import system.entity.MessageModel;
import system.entity.RoleModel;
import system.entity.UserModel;
import system.service.SystemService;
import system.utils.StringUtils;
import system.utils.UtilDateTime;
import system.wlims.basic.service.teacher.TeacherService;
import system.wlims.oa.dao.attendance.TakeLeaveDAO;
import system.wlims.oa.entity.workFlow.takeLeave.TakeLeaveForm;
import system.wlims.oa.entity.workFlow.takeLeave.TakeLeaveTerminateForm;
import system.wlims.oa.entity.workFlow.takeLeave.TakeLeaveWorkFlowLog;
import system.wlims.oa.service.attendance.TakeLeaveService;
import system.wlims.oa.vo.TaskVO;

public class TakeLeaveServiceImpl implements TakeLeaveService {
	private TakeLeaveDAO takeLeaveDAO;
	private SystemService systemService;
	private TeacherService teacherService;
	private UserDAO userDAO;
	private RoleDAO roleDAO;
	private DepartmentDAO departmentDAO;
	@Override
	public void addTakeLeaveApply(TakeLeaveForm takeLeave) {
		// TODO Auto-generated method stub
		Date currenDate=new Date();
		takeLeave.setApplyNo(UtilDateTime.toDateString(currenDate, "yyyyMMddHHmmss"));
		TakeLeaveWorkFlowLog log=new TakeLeaveWorkFlowLog();
		log.setOperationName("发起申请");
		log.setOperationResult("生成编号为"+takeLeave.getApplyNo()+"的申请记录");
		log.setOperationTime(currenDate);
		log.setOperationTeacherId(takeLeave.getTeacherId());
		takeLeave.getLogs().add(log);
		takeLeave.setOfficeChiefStatus(null);
		takeLeave.setVicePrincipalStatus(null);
		takeLeave.setPrincipalStatus(null);
		takeLeaveDAO.saveOrUpdate(takeLeave);
		String content="请课程处落实申请编号为"+takeLeave.getApplyNo()+"的请假/出差申请期间教学工作";
		if(takeLeave.getType().intValue()==TakeLeaveForm.Types.BusinessTrip.getValue().intValue())
			systemService.sendMessage(MessageModel.DefaultFromId, systemService.getWorkersIds(TaskVO.EType.AskForLeave_BusinessTrip_TechArrange.getValue()), MessageModel.MessageType.SYSTEM.getValue(), content);
		else systemService.sendMessage(MessageModel.DefaultFromId, systemService.getWorkersIds(TaskVO.EType.AskForLeave_Leave_TechArrange.getValue()), MessageModel.MessageType.SYSTEM.getValue(), content);

	}
	@Override
	public boolean updateTakeLeaveApply(TakeLeaveForm takeLeave) {
		// TODO Auto-generated method stub
		TakeLeaveForm newTakeLeave=takeLeaveDAO.get(takeLeave.getId());		
		if(newTakeLeave.getStatus().intValue()!=TakeLeaveForm.Status.Waiting.getValue().intValue())return false;
		else{
			newTakeLeave.setBeginTime(takeLeave.getBeginTime());
			newTakeLeave.setEndTime(takeLeave.getEndTime());
			newTakeLeave.setArrangeManage(takeLeave.getArrangeManage());
			newTakeLeave.setArrangeService(takeLeave.getArrangeService());
			newTakeLeave.setArrangeTech(takeLeave.getArrangeTech());
			newTakeLeave.setReason(takeLeave.getReason());
			TakeLeaveWorkFlowLog log=new TakeLeaveWorkFlowLog();
			log.setOperationName("编辑申请");
			log.setOperationResult("编辑编号为"+takeLeave.getApplyNo()+"的申请记录");
			log.setOperationTime(new Date());
			log.setOperationTeacherId(takeLeave.getTeacherId());
			newTakeLeave.getLogs().add(log);
			takeLeaveDAO.saveOrUpdate(newTakeLeave);
			return true;
		}
	}
	@Override
	public boolean approveTakeLeave(TakeLeaveForm takeLeave) {
		// TODO Auto-generated method stub
		TakeLeaveForm newTakeLeave=takeLeaveDAO.get(takeLeave.getId());		
		if(newTakeLeave.getStatus().intValue()==TakeLeaveForm.Status.Cancle.getValue().intValue()||newTakeLeave.getStatus().intValue()==TakeLeaveForm.Status.Deny.getValue().intValue())return false;
		else{
			newTakeLeave.setArrangeTech(takeLeave.getArrangeTech());
			newTakeLeave.setArrangeManage(takeLeave.getArrangeManage());
			newTakeLeave.setArrangeService(takeLeave.getArrangeService());
			newTakeLeave.setOfficeChiefApproveOption(takeLeave.getOfficeChiefApproveOption());
			newTakeLeave.setOfficeChiefApproverId(takeLeave.getOfficeChiefApproverId());
			newTakeLeave.setOfficeChiefApproveTime(takeLeave.getOfficeChiefApproveTime());
			newTakeLeave.setVicePrincipalApproveOption(takeLeave.getVicePrincipalApproveOption());
			newTakeLeave.setVicePrincipalApproverId(takeLeave.getVicePrincipalApproverId());
			newTakeLeave.setVicePrincipalApproveTime(takeLeave.getVicePrincipalApproveTime());
			newTakeLeave.setPrincipalApproveOption(takeLeave.getPrincipalApproveOption());
			newTakeLeave.setPrincipalApproverId(takeLeave.getPrincipalApproverId());
			newTakeLeave.setPrincipalApproveTime(takeLeave.getPrincipalApproveTime());
			newTakeLeave.setRemark(takeLeave.getRemark());
			
			
			
			newTakeLeave.setReason(takeLeave.getReason());
//			UserModel user=SecurityUserHolder.getCurrentUser();
//			if(newTakeLeave.getArrangeTechDealAlready()!=takeLeave.getArrangeTechDealAlready()&&takeLeave.getArrangeTechDealAlready()==true){
//				TakeLeaveWorkFlowLog log=new TakeLeaveWorkFlowLog();
//				log.setOperationName("落实请假/出差期间教学工作");
//				log.setOperationResult("落实编号为"+takeLeave.getApplyNo()+"的申请请假/出差期间教学工作");
//				log.setOperationTime(new Date());
//				log.setOperationTeacherId(user.getId());
//				newTakeLeave.getLogs().add(log);
//				String content="课程处已经落实申请编号为"+takeLeave.getApplyNo()+"的请假/出差期间教学工作";
//				if(takeLeave.getType().intValue()==TakeLeaveForm.Types.BusinessTrip.getValue().intValue())
//					systemService.sendMessage(MessageModel.DefaultFromId, systemService.getWorkersIds(TaskVO.EType.AskForLeave_BusinessTrip_OfficalApprove.getValue()), MessageModel.MessageType.SYSTEM.getValue(), content);
//				else systemService.sendMessage(MessageModel.DefaultFromId, systemService.getWorkersIds(TaskVO.EType.AskForLeave_Leave_OfficalApprove.getValue()), MessageModel.MessageType.SYSTEM.getValue(), content);
//
//			}
//			if(newTakeLeave.getArrangeManageDealAlready()!=takeLeave.getArrangeManageDealAlready()&&takeLeave.getArrangeManageDealAlready()==true){
//				TakeLeaveWorkFlowLog log=new TakeLeaveWorkFlowLog();
//				log.setOperationName("落实请假/出差期间管理工作");
//				log.setOperationResult("落实编号为"+takeLeave.getApplyNo()+"的申请请假/出差期间管理工作");
//				log.setOperationTime(new Date());
//				log.setOperationTeacherId(user.getId());
//				newTakeLeave.getLogs().add(log);
//			}
//			if(newTakeLeave.getArrangeServiceDealAlready()!=takeLeave.getArrangeServiceDealAlready()&&takeLeave.getArrangeServiceDealAlready()==true){
//				TakeLeaveWorkFlowLog log=new TakeLeaveWorkFlowLog();
//				log.setOperationName("落实请假/出差期间服务工作");
//				log.setOperationResult("落实编号为"+takeLeave.getApplyNo()+"的申请请假/出差期间服务工作");
//				log.setOperationTime(new Date());
//				log.setOperationTeacherId(user.getId());
//				newTakeLeave.getLogs().add(log);
//			}
			UserModel applier=userDAO.get(takeLeave.getTeacherId());
			Boolean hasTeachingRoleInMain=false;
 			Boolean hasTeachingRole=false;
			List<RoleModel> teachingRoles=roleDAO.getTeachingRoles();
			if(teachingRoles!=null&&teachingRoles.size()>0){
				for(RoleModel teachingRole:teachingRoles){
					if(applier.hasRoleInMain(teachingRole.getId())){
						hasTeachingRoleInMain=true;
						break;
					}
				}
				for(RoleModel teachingRole:teachingRoles){
					if(applier.hasRole(teachingRole.getId())){
						hasTeachingRole=true;
						break;
					}
				}
			}
			applier.setHasTeachingRole(hasTeachingRole);
			applier.setHasTeachingRoleInMain(hasTeachingRoleInMain);
			if(hasTeachingRoleInMain==true){//教学申请审批
				if(newTakeLeave.getOfficeChiefStatus()==null&&takeLeave.getOfficeChiefStatus()!=null){
					TakeLeaveWorkFlowLog log=new TakeLeaveWorkFlowLog();
					log.setOperationName("课程处审批");
					if(takeLeave.getOfficeChiefStatus()==1){
						log.setOperationResult("课程处审批编号为"+takeLeave.getApplyNo()+"的申请通过");
						if(newTakeLeave.getSections()/3.0<=TakeLeaveForm.Rules.FirstApprove.getValue()*1.0){
								newTakeLeave.setStatus(TakeLeaveForm.Status.Pass.getValue());
								String content="您申请的编号为"+takeLeave.getApplyNo()+"的请假/出差审批已经通过";
								systemService.sendMessage(MessageModel.DefaultFromId, takeLeave.getTeacherId(),MessageModel.MessageType.SYSTEM.getValue(), content);

						}
						else {
							newTakeLeave.setStatus(TakeLeaveForm.Status.OfficePass.getValue());
							String content="课程处审批已经通过编号为"+takeLeave.getApplyNo()+"的请假/出差申请";
							if(takeLeave.getType().intValue()==TakeLeaveForm.Types.BusinessTrip.getValue().intValue())
								systemService.sendMessage(MessageModel.DefaultFromId, systemService.getWorkersIds(TaskVO.EType.AskForLeave_BusinessTrip_VicePrincipalApprove.getValue()), MessageModel.MessageType.SYSTEM.getValue(), content);
							else systemService.sendMessage(MessageModel.DefaultFromId, systemService.getWorkersIds(TaskVO.EType.AskForLeave_Leave_VicePrincipalApprove.getValue()), MessageModel.MessageType.SYSTEM.getValue(), content);

						
						}
					}
					else if(takeLeave.getOfficeChiefStatus()==2){
						log.setOperationResult("课程处审批编号为"+takeLeave.getApplyNo()+"的申请不通过");
						newTakeLeave.setStatus(TakeLeaveForm.Status.Deny.getValue());	
						String content="您申请的编号为"+takeLeave.getApplyNo()+"的请假/出差课程处审批不通过";
						systemService.sendMessage(MessageModel.DefaultFromId, takeLeave.getTeacherId(),MessageModel.MessageType.SYSTEM.getValue(), content);

					}
					log.setOperationTime(new Date());
					log.setOperationTeacherId(takeLeave.getOfficeChiefApproverId());
					newTakeLeave.getLogs().add(log);
				}
				if(newTakeLeave.getVicePrincipalStatus()==null&&takeLeave.getVicePrincipalStatus()!=null){
					TakeLeaveWorkFlowLog log=new TakeLeaveWorkFlowLog();
					log.setOperationName("分管教学副校长审批");
					if(takeLeave.getVicePrincipalStatus().intValue()==1){
						log.setOperationResult("分管教学副校长审批编号为"+takeLeave.getApplyNo()+"的申请通过");
						if(newTakeLeave.getSections()/3.0<=TakeLeaveForm.Rules.SecordApprove.getValue()*1.0){
							newTakeLeave.setStatus(TakeLeaveForm.Status.Pass.getValue());
							String content="您申请的编号为"+takeLeave.getApplyNo()+"的请假/出差审批已经通过";
							systemService.sendMessage(MessageModel.DefaultFromId, takeLeave.getTeacherId(),MessageModel.MessageType.SYSTEM.getValue(), content);
		
						}
						else { 
							newTakeLeave.setStatus(TakeLeaveForm.Status.VicePrincipalPass.getValue());
							String content="分管教学副校长审批已经通过编号为"+takeLeave.getApplyNo()+"的请假/出差申请";
							if(takeLeave.getType().intValue()==TakeLeaveForm.Types.BusinessTrip.getValue().intValue())
								systemService.sendMessage(MessageModel.DefaultFromId, systemService.getWorkersIds(TaskVO.EType.AskForLeave_BusinessTrip_VicePrincipalApprove.getValue()), MessageModel.MessageType.SYSTEM.getValue(), content);
							else systemService.sendMessage(MessageModel.DefaultFromId, systemService.getWorkersIds(TaskVO.EType.AskForLeave_Leave_VicePrincipalApprove.getValue()), MessageModel.MessageType.SYSTEM.getValue(), content);
							
						}
						
					}
					else if(takeLeave.getVicePrincipalStatus().intValue()==2){
						log.setOperationResult("分管教学副校长审批编号为"+takeLeave.getApplyNo()+"的申请不通过");
						newTakeLeave.setStatus(TakeLeaveForm.Status.Deny.getValue());	
						String content="您申请的编号为"+takeLeave.getApplyNo()+"的请假/出差分管教学副校长审批不通过";
						systemService.sendMessage(MessageModel.DefaultFromId, takeLeave.getTeacherId(),MessageModel.MessageType.SYSTEM.getValue(), content);

					}
					log.setOperationTime(new Date());
					log.setOperationTeacherId(takeLeave.getVicePrincipalApproverId());
					newTakeLeave.getLogs().add(log);
				}
				if(newTakeLeave.getPrincipalStatus()==null&&takeLeave.getPrincipalStatus()!=null){
					TakeLeaveWorkFlowLog log=new TakeLeaveWorkFlowLog();
					log.setOperationName("校长审批");
					if(takeLeave.getPrincipalStatus().intValue()==1){
						log.setOperationResult("校长审批编号为"+takeLeave.getApplyNo()+"的申请通过");
//						if(newTakeLeave.getSections()/3.0<=TakeLeaveForm.Rules.ThirdApprove.getValue()*1.0)
//							newTakeLeave.setStatus(TakeLeaveForm.Status.Pass.getValue());
//						else newTakeLeave.setStatus(TakeLeaveForm.Status.Pass.getValue());	
						newTakeLeave.setStatus(TakeLeaveForm.Status.Pass.getValue());	
						String content="您申请的编号为"+takeLeave.getApplyNo()+"的请假/出差校长审批通过";
						systemService.sendMessage(MessageModel.DefaultFromId, takeLeave.getTeacherId(),MessageModel.MessageType.SYSTEM.getValue(), content);

					}
					else if(takeLeave.getPrincipalStatus().intValue()==2){
						log.setOperationResult("校长审批编号为"+takeLeave.getApplyNo()+"的申请不通过");
						newTakeLeave.setStatus(TakeLeaveForm.Status.Deny.getValue());	
						String content="您申请的编号为"+takeLeave.getApplyNo()+"的请假/出差校长审批不通过";
						systemService.sendMessage(MessageModel.DefaultFromId, takeLeave.getTeacherId(),MessageModel.MessageType.SYSTEM.getValue(), content);

					}
					log.setOperationTime(new Date());
					log.setOperationTeacherId(takeLeave.getPrincipalApproverId());
					newTakeLeave.getLogs().add(log);
				}
				
			}else{
				if(newTakeLeave.getOfficeChiefStatus()==null&&takeLeave.getOfficeChiefStatus()!=null){
					TakeLeaveWorkFlowLog log=new TakeLeaveWorkFlowLog();
					log.setOperationName("处室审批");
					if(takeLeave.getOfficeChiefStatus()==1){
						log.setOperationResult("处室审批编号为"+takeLeave.getApplyNo()+"的申请通过");
						if(newTakeLeave.getSections()/3.0<=TakeLeaveForm.Rules.FirstApprove.getValue()*1.0){
								newTakeLeave.setStatus(TakeLeaveForm.Status.Pass.getValue());
								String content="您申请的编号为"+takeLeave.getApplyNo()+"的请假/出差审批已经通过";
								systemService.sendMessage(MessageModel.DefaultFromId, takeLeave.getTeacherId(),MessageModel.MessageType.SYSTEM.getValue(), content);
								//通知课程处
								if(hasTeachingRole==true){
									String noticeMessageContent="教师"+teacherService.getTeacherNameByUserId(takeLeave.getTeacherId())+"申请的编号为"+takeLeave.getApplyNo()+"的请假/出差所在处室审批已经通过";
									systemService.sendMessage(MessageModel.DefaultFromId, systemService.getWorkersIds(TaskVO.EType.AskForLeave_Leave_Teaching_OfficalApprove.getValue()),MessageModel.MessageType.SYSTEM.getValue(), noticeMessageContent);
								}

						}
						else {
							newTakeLeave.setStatus(TakeLeaveForm.Status.OfficePass.getValue());
							String content="处室审批已经通过编号为"+takeLeave.getApplyNo()+"的请假/出差申请";
							
							if(takeLeave.getType().intValue()==TakeLeaveForm.Types.BusinessTrip.getValue().intValue())
								systemService.sendMessage(MessageModel.DefaultFromId, systemService.getWorkersIds(TaskVO.EType.AskForLeave_BusinessTrip_VicePrincipalApprove.getValue()), MessageModel.MessageType.SYSTEM.getValue(), content);
							else systemService.sendMessage(MessageModel.DefaultFromId, systemService.getWorkersIds(TaskVO.EType.AskForLeave_Leave_VicePrincipalApprove.getValue()), MessageModel.MessageType.SYSTEM.getValue(), content);
							
							//通知课程处
							if(hasTeachingRole==true){
								String noticeMessageContent="教师"+teacherService.getTeacherNameByUserId(takeLeave.getTeacherId())+"申请的编号为"+takeLeave.getApplyNo()+"的请假/出差分管副校长审批已经通过";
								systemService.sendMessage(MessageModel.DefaultFromId, systemService.getWorkersIds(TaskVO.EType.AskForLeave_Leave_Teaching_OfficalApprove.getValue()),MessageModel.MessageType.SYSTEM.getValue(), noticeMessageContent);
							}
						
						}
					}
					else if(takeLeave.getOfficeChiefStatus()==2){
						log.setOperationResult("处室审批编号为"+takeLeave.getApplyNo()+"的申请不通过");
						newTakeLeave.setStatus(TakeLeaveForm.Status.Deny.getValue());	
						String content="您申请的编号为"+takeLeave.getApplyNo()+"的请假/出差处室审批不通过";
						systemService.sendMessage(MessageModel.DefaultFromId, takeLeave.getTeacherId(),MessageModel.MessageType.SYSTEM.getValue(), content);

					}
					log.setOperationTime(new Date());
					log.setOperationTeacherId(takeLeave.getOfficeChiefApproverId());
					newTakeLeave.getLogs().add(log);
				}
				if(newTakeLeave.getVicePrincipalStatus()==null&&takeLeave.getVicePrincipalStatus()!=null){
					TakeLeaveWorkFlowLog log=new TakeLeaveWorkFlowLog();
					log.setOperationName("分管副校长审批");
					if(takeLeave.getVicePrincipalStatus().intValue()==1){
						log.setOperationResult("分管副校长审批编号为"+takeLeave.getApplyNo()+"的申请通过");
						if(newTakeLeave.getSections()/3.0<=TakeLeaveForm.Rules.SecordApprove.getValue()*1.0){
							newTakeLeave.setStatus(TakeLeaveForm.Status.Pass.getValue());
							String content="您申请的编号为"+takeLeave.getApplyNo()+"的请假/出差审批已经通过";
							systemService.sendMessage(MessageModel.DefaultFromId, takeLeave.getTeacherId(),MessageModel.MessageType.SYSTEM.getValue(), content);
							//通知课程处
							if(hasTeachingRole==true){
								String noticeMessageContent="教师"+teacherService.getTeacherNameByUserId(takeLeave.getTeacherId())+"申请的编号为"+takeLeave.getApplyNo()+"的请假/出差校长审批已经通过";
								systemService.sendMessage(MessageModel.DefaultFromId, systemService.getWorkersIds(TaskVO.EType.AskForLeave_Leave_Teaching_OfficalApprove.getValue()),MessageModel.MessageType.SYSTEM.getValue(), noticeMessageContent);
							}
		
						}
						else { 
							newTakeLeave.setStatus(TakeLeaveForm.Status.VicePrincipalPass.getValue());
							String content="分管副校长审批已经通过编号为"+takeLeave.getApplyNo()+"的请假/出差申请";
							if(takeLeave.getType().intValue()==TakeLeaveForm.Types.BusinessTrip.getValue().intValue())
								systemService.sendMessage(MessageModel.DefaultFromId, systemService.getWorkersIds(TaskVO.EType.AskForLeave_BusinessTrip_VicePrincipalApprove.getValue()), MessageModel.MessageType.SYSTEM.getValue(), content);
							else systemService.sendMessage(MessageModel.DefaultFromId, systemService.getWorkersIds(TaskVO.EType.AskForLeave_Leave_VicePrincipalApprove.getValue()), MessageModel.MessageType.SYSTEM.getValue(), content);
							
						}
						
					}
					else if(takeLeave.getVicePrincipalStatus().intValue()==2){
						log.setOperationResult("分管副校长审批编号为"+takeLeave.getApplyNo()+"的申请不通过");
						newTakeLeave.setStatus(TakeLeaveForm.Status.Deny.getValue());	
						String content="您申请的编号为"+takeLeave.getApplyNo()+"的请假/出差分管副校长审批不通过";
						systemService.sendMessage(MessageModel.DefaultFromId, takeLeave.getTeacherId(),MessageModel.MessageType.SYSTEM.getValue(), content);

					}
					log.setOperationTime(new Date());
					log.setOperationTeacherId(takeLeave.getVicePrincipalApproverId());
					newTakeLeave.getLogs().add(log);
				}
				if(newTakeLeave.getPrincipalStatus()==null&&takeLeave.getPrincipalStatus()!=null){
					TakeLeaveWorkFlowLog log=new TakeLeaveWorkFlowLog();
					log.setOperationName("校长审批");
					if(takeLeave.getPrincipalStatus().intValue()==1){
						log.setOperationResult("校长审批编号为"+takeLeave.getApplyNo()+"的申请通过");
//						if(newTakeLeave.getSections()/3.0<=TakeLeaveForm.Rules.ThirdApprove.getValue()*1.0)
//							newTakeLeave.setStatus(TakeLeaveForm.Status.Pass.getValue());
//						else newTakeLeave.setStatus(TakeLeaveForm.Status.Pass.getValue());	
						newTakeLeave.setStatus(TakeLeaveForm.Status.Pass.getValue());	
						String content="您申请的编号为"+takeLeave.getApplyNo()+"的请假/出差校长审批通过";
						systemService.sendMessage(MessageModel.DefaultFromId, takeLeave.getTeacherId(),MessageModel.MessageType.SYSTEM.getValue(), content);
						
						//通知课程处
						if(hasTeachingRole==true){
							String noticeMessageContent="";
							systemService.sendMessage(MessageModel.DefaultFromId, systemService.getWorkersIds(TaskVO.EType.AskForLeave_Leave_Teaching_OfficalApprove.getValue()),MessageModel.MessageType.SYSTEM.getValue(), noticeMessageContent);
						}

					}
					else if(takeLeave.getPrincipalStatus().intValue()==2){
						log.setOperationResult("校长审批编号为"+takeLeave.getApplyNo()+"的申请不通过");
						newTakeLeave.setStatus(TakeLeaveForm.Status.Deny.getValue());	
						String content="您申请的编号为"+takeLeave.getApplyNo()+"的请假/出差校长审批不通过";
						systemService.sendMessage(MessageModel.DefaultFromId, takeLeave.getTeacherId(),MessageModel.MessageType.SYSTEM.getValue(), content);

					}
					log.setOperationTime(new Date());
					log.setOperationTeacherId(takeLeave.getPrincipalApproverId());
					newTakeLeave.getLogs().add(log);
				}
				
			}
			
			newTakeLeave.setArrangeTechDealAlready(takeLeave.getArrangeTechDealAlready());
			newTakeLeave.setArrangeManageDealAlready(takeLeave.getArrangeManageDealAlready());
			newTakeLeave.setArrangeServiceDealAlready(takeLeave.getArrangeServiceDealAlready());

			newTakeLeave.setOfficeChiefStatus(takeLeave.getOfficeChiefStatus());
			newTakeLeave.setVicePrincipalStatus(takeLeave.getVicePrincipalStatus());
			newTakeLeave.setPrincipalStatus(takeLeave.getPrincipalStatus());
			takeLeaveDAO.saveOrUpdate(newTakeLeave);
			return true;
		}
	}
	
	@Override
	public boolean cancleTakeLeaveApplyById(String id) {
		// TODO Auto-generated method stub
		TakeLeaveForm takeLeave=takeLeaveDAO.get(id);
		if(takeLeave.getStatus().intValue()!=TakeLeaveForm.Status.Waiting.getValue().intValue())return false;
		else{
			takeLeave.setStatus(TakeLeaveForm.Status.Cancle.getValue());
			TakeLeaveWorkFlowLog log=new TakeLeaveWorkFlowLog();
			log.setOperationName("取消申请");
			log.setOperationResult("取消编号为"+takeLeave.getApplyNo()+"的申请记录");
			log.setOperationTime(new Date());
			log.setOperationTeacherId(takeLeave.getTeacherId());
			takeLeave.getLogs().add(log);
			takeLeaveDAO.saveOrUpdate(takeLeave);
			return true;
		}
	}


	@Override
	public List<TakeLeaveForm> getUserTakeLeaveApplies(String userId) {
		// TODO Auto-generated method stub
		return takeLeaveDAO.getUserTakeLeaveApplies(userId);
	}

	public TakeLeaveDAO getTakeLeaveDAO() {
		return takeLeaveDAO;
	}

	public void setTakeLeaveDAO(TakeLeaveDAO takeLeaveDAO) {
		this.takeLeaveDAO = takeLeaveDAO;
	}
	@Override
	public TakeLeaveForm getDetailInfoById(String id) {
		// TODO Auto-generated method stub
		return takeLeaveDAO.get(id);
	}
	@Override
	public TakeLeaveForm loadApplyInfoById(String id) {
		// TODO Auto-generated method stub
		return takeLeaveDAO.get(id);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<TakeLeaveForm> getTakeLeaveAppliesByConditions(
			String teacherId, String type, String status,
			String submitBeginDate, String submitEndDate,
			String takeLeaveBeginDate, String takeLeaveEndDate) {
		// TODO Auto-generated method stub
		Set<TakeLeaveForm> results=new TreeSet<TakeLeaveForm>();
		List<TakeLeaveForm> list=takeLeaveDAO.getTakeLeaveAppliesByConditions(teacherId,type,status,submitBeginDate,submitEndDate,takeLeaveBeginDate,takeLeaveEndDate);
		UserModel user=SecurityUserHolder.getCurrentUser();
		List<RoleModel> teachingRoles=roleDAO.getTeachingRoles();
		DepartmentModel rootDepartment=departmentDAO.getDepartmentBySymbol("root");
		for(TakeLeaveForm form:list){
			/**
			 * 1.请假人在行政组【0级部门】中---教学1级审批权限人审批【课程处】--教学2级审批权限人审批【教学副校长】--所有审批权限人审批【校长】----------通过给行政组的人配置教学职务来绕开
			 * 2.请假人拥有教学职务『
			 * 					主职务含有教学职务（“教师”“教研组长”）:教学1级审批权限人审批【课程处】--教学2级审批权限人审批【教学副校长】--所有审批权限人审批【校长】
			 * 					副职务含有教学职务（“教师”“教研组长”）:1级下属审批权限【本部门处长】--2级下属审批权限【本部门分管副校长】--所有审批权限人审批【校长】；通知拥有教学1级审批权限人审批的人【课程处】
			 * 				』
			 * 3.其他---1级下属审批权限【本部门处长】--2级下属审批权限【本部门分管副校长】--所有审批权限人审批【校长】
			 */
			UserModel applier=userDAO.get(form.getTeacherId());
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
				for(RoleModel teachingRole:teachingRoles){
					if(applier.hasRole(teachingRole.getId())){
						hasTeachingRole=true;
						break;
					}
				}
			}
			if(rootDepartment!=null&&applier.hasDepartment(rootDepartment.getId())){
				hasRootDepartment=true;
			}
			applier.setHasTeachingRole(hasTeachingRole);
			applier.setHasTeachingRoleInMain(hasTeachingRoleInMain);
			applier.setHasRootDepartment(hasRootDepartment);
			// 请假人拥有教学职务
			if(applier.getHasTeachingRoleInMain()==true||applier.getHasRootDepartment()==true){
				//请假出差教学1级审批权限人审批【课程处】
				if(user.hasDam("takeLeaveOfficeTeachingApprove@noFilter@")){
					if(!results.contains(form))
						results.add(form);
				}
				//请假出差教学2级审批权限人审批【教学副校长】
				if(user.hasDam("takeLeaveVicePrincipalTeachingApprove@noFilter@")){
					if(!results.contains(form))
						results.add(form);
				}
				//请假出差所有审批权限人审批【校长】
				if(user.hasDam("takeLeavePrincipalApprove@noFilter@")){
					if(!results.contains(form))
						results.add(form);
				}
				
			}else{
				//请假出差本处室审批
				if(user.hasDam("takeLeaveOfficeApprove@noFilter@")&&SecurityUserHolder.getCurrentUser()!=null&&SecurityUserHolder.getCurrentUser().hasSubordinateUser(form.getTeacherId())){
					if(!results.contains(form))
						results.add(form);
				}
				//请假出差分管副校长审批
				if(user.hasDam("takeLeaveVicePrincipalApprove@noFilter@")&&SecurityUserHolder.getCurrentUser()!=null&&SecurityUserHolder.getCurrentUser().hasSubordinateUser(form.getTeacherId())){
					if(!results.contains(form))
						results.add(form);
				}	
				//请假出差校长审批
				if(user.hasDam("takeLeavePrincipalApprove@noFilter@")){
					if(!results.contains(form))
						results.add(form);
				}
				
				
			}
			
		}
		
		
		
		return new ArrayList(results);
	}
	@Override
	public boolean deleteTakeLeaveById(String id){
		takeLeaveDAO.remove(takeLeaveDAO.get(id));
		return true;
	}
	@Override
	public boolean terminateLeaveApply(String id, String date, String reason) {
		// TODO Auto-generated method stub
		TakeLeaveForm takeLeave=takeLeaveDAO.get(id);
		if(takeLeave==null)return false;
		if(takeLeave.getStatus().intValue()<TakeLeaveForm.Status.Pass.getValue().intValue())return false;
		TakeLeaveTerminateForm takeLeaveTerminateForm=takeLeave.getTakeLeaveTerminateForm();
		if(takeLeaveTerminateForm==null||StringUtils.isEmpty(takeLeaveTerminateForm.getId())){
			takeLeaveTerminateForm=new TakeLeaveTerminateForm();
			takeLeaveTerminateForm.setTerminateApplyTime(new Date());
		}else{
			if(takeLeaveTerminateForm.getStatus().intValue()!=TakeLeaveTerminateForm.Status.Waiting.getValue().intValue())return false;
			takeLeave.getTerminateForms().removeAll(takeLeave.getTerminateForms());
		}
		takeLeaveTerminateForm.setTerminateDateTime(date);
		takeLeaveTerminateForm.setTerminateReason(reason);
		takeLeaveTerminateForm.setStatus(TakeLeaveTerminateForm.Status.Waiting.getValue());
		TakeLeaveWorkFlowLog log=new TakeLeaveWorkFlowLog();
		log.setOperationName("销假申请");
		log.setOperationResult("编号为"+takeLeave.getApplyNo()+"的记录申请销假");
		log.setOperationTime(new Date());
		log.setOperationTeacherId(takeLeave.getTeacherId());
		takeLeave.getLogs().add(log);
		takeLeave.setStatus(TakeLeaveForm.Status.TerminateWaiting.getValue());
//		takeLeaveDAO.saveOrUpdate(takeLeave);
//		Set<TakeLeaveTerminateForm> terminateForms=new TreeSet<TakeLeaveTerminateForm>();
//		terminateForms.add(takeLeaveTerminateForm);
		takeLeave.getTerminateForms().add(takeLeaveTerminateForm);
		takeLeaveDAO.saveOrUpdate(takeLeave);
		return true;
	}
	@Override
	public boolean terminateLeaveApprove(String id, String date, String reason, String option,
			Integer status,String approverId,Date approverDate) {
		TakeLeaveForm takeLeave=takeLeaveDAO.get(id);
		if(takeLeave==null)return false;
		TakeLeaveTerminateForm takeLeaveTerminateForm=takeLeave.getTakeLeaveTerminateForm();
		if(takeLeaveTerminateForm==null||StringUtils.isEmpty(takeLeaveTerminateForm.getId())){
			takeLeaveTerminateForm=new TakeLeaveTerminateForm();
			takeLeaveTerminateForm.setTerminateApplyTime(new Date());
		}
		else{
//			if(takeLeaveTerminateForm.getStatus().intValue()!=TakeLeaveTerminateForm.Status.Waiting.getValue().intValue())return false;
			takeLeave.getTerminateForms().removeAll(takeLeave.getTerminateForms());
		}
		takeLeaveTerminateForm.setTerminateDateTime(date);
		takeLeaveTerminateForm.setTerminateReason(reason);
		takeLeaveTerminateForm.setTerminateApproveTime(approverDate);
		takeLeaveTerminateForm.setTerminateOfficeApproverOption(option);
		takeLeaveTerminateForm.setTerminateOfficeApproverId(approverId);
		takeLeaveTerminateForm.setStatus(status);

		TakeLeaveWorkFlowLog log=new TakeLeaveWorkFlowLog();
		log.setOperationName("销假审批");
		if(status.intValue()==TakeLeaveForm.Status.TerminatePass.getValue().intValue()){
			log.setOperationResult("编号为"+takeLeave.getApplyNo()+"的销假申请审批通过");
			takeLeave.setStatus(TakeLeaveForm.Status.TerminatePass.getValue());
		}
		else if(status.intValue()==TakeLeaveForm.Status.TerminateDeny.getValue().intValue()){
			log.setOperationResult("编号为"+takeLeave.getApplyNo()+"的销假申请审批不通过");
			takeLeave.setStatus(TakeLeaveForm.Status.TerminateDeny.getValue());
		}
		log.setOperationTime(new Date());
		log.setOperationTeacherId(approverId);
		takeLeave.getLogs().add(log);
		takeLeave.getTerminateForms().add(takeLeaveTerminateForm);
//		takeLeaveDAO.saveOrUpdate(takeLeave);
//		Set<TakeLeaveTerminateForm> terminateForms=new TreeSet<TakeLeaveTerminateForm>();
//		terminateForms.add(takeLeaveTerminateForm);
//		takeLeave.setTerminateForms(terminateForms);
		takeLeaveDAO.saveOrUpdate(takeLeave);
		return true;
	}
	public SystemService getSystemService() {
		return systemService;
	}
	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}
	public TeacherService getTeacherService() {
		return teacherService;
	}
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	public UserDAO getUserDAO() {
		return userDAO;
	}
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
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
