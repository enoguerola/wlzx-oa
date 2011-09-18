package system.wlims.oa.serviceImpl.attendance;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import system.components.SecurityUserHolder;
import system.entity.MessageModel;
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
			if(newTakeLeave.getOfficeChiefStatus()==null){
				TakeLeaveWorkFlowLog log=new TakeLeaveWorkFlowLog();
				log.setOperationName("处室审批");
				if(takeLeave.getOfficeChiefStatus()==1){
					log.setOperationResult("处室审批编号为"+takeLeave.getApplyNo()+"的申请通过");
					if(newTakeLeave.getSections()/3.0<=TakeLeaveForm.Rules.FirstApprove.getValue()*1.0){
							newTakeLeave.setStatus(TakeLeaveForm.Status.Pass.getValue());
							String content="您申请的编号为"+takeLeave.getApplyNo()+"的请假/出差审批已经通过";
							systemService.sendMessage(MessageModel.DefaultFromId, takeLeave.getTeacherId(),MessageModel.MessageType.SYSTEM.getValue(), content);

					}
					else {
						newTakeLeave.setStatus(TakeLeaveForm.Status.OfficePass.getValue());
						String content="处室审批已经通过编号为"+takeLeave.getApplyNo()+"的请假/出差申请";
						if(takeLeave.getType().intValue()==TakeLeaveForm.Types.BusinessTrip.getValue().intValue())
							systemService.sendMessage(MessageModel.DefaultFromId, systemService.getWorkersIds(TaskVO.EType.AskForLeave_BusinessTrip_VicePrincipalApprove.getValue()), MessageModel.MessageType.SYSTEM.getValue(), content);
						else systemService.sendMessage(MessageModel.DefaultFromId, systemService.getWorkersIds(TaskVO.EType.AskForLeave_Leave_VicePrincipalApprove.getValue()), MessageModel.MessageType.SYSTEM.getValue(), content);

					
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
			if(newTakeLeave.getVicePrincipalStatus()==null){
				TakeLeaveWorkFlowLog log=new TakeLeaveWorkFlowLog();
				log.setOperationName("分管副校长审批");
				if(takeLeave.getVicePrincipalStatus().intValue()==1){
					log.setOperationResult("分管副校长审批编号为"+takeLeave.getApplyNo()+"的申请通过");
					if(newTakeLeave.getSections()/3.0<=TakeLeaveForm.Rules.SecordApprove.getValue()*1.0){
						newTakeLeave.setStatus(TakeLeaveForm.Status.Pass.getValue());
						String content="您申请的编号为"+takeLeave.getApplyNo()+"的请假/出差审批已经通过";
						systemService.sendMessage(MessageModel.DefaultFromId, takeLeave.getTeacherId(),MessageModel.MessageType.SYSTEM.getValue(), content);
	
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
			if(newTakeLeave.getPrincipalStatus()==null){
				TakeLeaveWorkFlowLog log=new TakeLeaveWorkFlowLog();
				log.setOperationName("校长审批");
				if(takeLeave.getPrincipalStatus().intValue()==1){
					log.setOperationResult("校长审批编号为"+takeLeave.getApplyNo()+"的申请通过");
//					if(newTakeLeave.getSections()/3.0<=TakeLeaveForm.Rules.ThirdApprove.getValue()*1.0)
//						newTakeLeave.setStatus(TakeLeaveForm.Status.Pass.getValue());
//					else newTakeLeave.setStatus(TakeLeaveForm.Status.Pass.getValue());	
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
	@Override
	public List<TakeLeaveForm> getTakeLeaveAppliesByConditions(
			String teacherId, String type, String status,
			String submitBeginDate, String submitEndDate,
			String takeLeaveBeginDate, String takeLeaveEndDate) {
		// TODO Auto-generated method stub
		List<TakeLeaveForm> results=new ArrayList<TakeLeaveForm>();
		List<TakeLeaveForm> list=takeLeaveDAO.getTakeLeaveAppliesByConditions(teacherId,type,status,submitBeginDate,submitEndDate,takeLeaveBeginDate,takeLeaveEndDate);
		UserModel user=SecurityUserHolder.getCurrentUser();
		if(user.hasDam("takeLeaveApprove_main@defaultVisit@@noFilter@"))
			return list;
		if(user.hasDam("takeLeaveApprove_main@defaultVisit@@notSelfManagerFilter@")){
			for(TakeLeaveForm form:list){
				if(user.hasSubordinateUser(form.getTeacherId())){
					results.add(form);
				}
			}
			return results;
		}
		else if(user.hasDam("takeLeaveApprove_main@defaultVisit@@notSelfOfficeFilter@")){
			for(TakeLeaveForm form:list){
				if(user.hasSubordinateUser(form.getTeacherId())){
					results.add(form);
				}
			}
			return results;
		}
		
		return list;
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

}
