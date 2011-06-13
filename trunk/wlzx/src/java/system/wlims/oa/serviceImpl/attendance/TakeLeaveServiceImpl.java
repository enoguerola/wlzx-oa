package system.wlims.oa.serviceImpl.attendance;

import java.util.Date;
import java.util.List;

import system.components.SecurityUserHolder;
import system.entity.UserModel;
import system.utils.UtilDateTime;
import system.wlims.oa.dao.attendance.TakeLeaveDAO;
import system.wlims.oa.entity.workFlow.takeLeave.TakeLeaveForm;
import system.wlims.oa.entity.workFlow.takeLeave.TakeLeaveWorkFlowLog;
import system.wlims.oa.service.attendance.TakeLeaveService;

public class TakeLeaveServiceImpl implements TakeLeaveService {
	public TakeLeaveDAO takeLeaveDAO;
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
		takeLeaveDAO.saveOrUpdate(takeLeave);
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
			newTakeLeave.setArrangeManage(takeLeave.getArrangeTech());
			newTakeLeave.setArrangeService(takeLeave.getArrangeTech());
			newTakeLeave.setOfficeChiefApproveOption(takeLeave.getOfficeChiefApproveOption());
			newTakeLeave.setOfficeChiefApproverId(takeLeave.getOfficeChiefApproverId());
			newTakeLeave.setOfficeChiefApproveTime(takeLeave.getOfficeChiefApproveTime());
			newTakeLeave.setVicePrincipalApproveOption(takeLeave.getVicePrincipalApproveOption());
			newTakeLeave.setVicePrincipalApproverId(takeLeave.getVicePrincipalApproverId());
			newTakeLeave.setVicePrincipalApproveTime(takeLeave.getVicePrincipalApproveTime());
			newTakeLeave.setPrincipalApproveOption(takeLeave.getPrincipalApproveOption());
			newTakeLeave.setPrincipalApproverId(takeLeave.getPrincipalApproverId());
			newTakeLeave.setPrincipalApproveTime(takeLeave.getPrincipalApproveTime());
			
			
			
			
			newTakeLeave.setReason(takeLeave.getReason());
			UserModel user=SecurityUserHolder.getCurrentUser();
			if(newTakeLeave.getArrangeTechDealAlready()!=takeLeave.getArrangeTechDealAlready()&&takeLeave.getArrangeTechDealAlready()==true){
				TakeLeaveWorkFlowLog log=new TakeLeaveWorkFlowLog();
				log.setOperationName("落实请假/出差期间工作");
				log.setOperationResult("落实编号为"+takeLeave.getApplyNo()+"的申请请假/出差期间教学工作");
				log.setOperationTime(new Date());
				log.setOperationTeacherId(user.getId());
				newTakeLeave.getLogs().add(log);
			}
			if(newTakeLeave.getArrangeManageDealAlready()!=takeLeave.getArrangeManageDealAlready()&&takeLeave.getArrangeManageDealAlready()==true){
				TakeLeaveWorkFlowLog log=new TakeLeaveWorkFlowLog();
				log.setOperationName("落实请假/出差期间管理工作");
				log.setOperationResult("落实编号为"+takeLeave.getApplyNo()+"的申请请假/出差期间管理工作");
				log.setOperationTime(new Date());
				log.setOperationTeacherId(user.getId());
				newTakeLeave.getLogs().add(log);
			}
			if(newTakeLeave.getArrangeServiceDealAlready()!=takeLeave.getArrangeServiceDealAlready()&&takeLeave.getArrangeServiceDealAlready()==true){
				TakeLeaveWorkFlowLog log=new TakeLeaveWorkFlowLog();
				log.setOperationName("落实请假/出差期间服务工作");
				log.setOperationResult("落实编号为"+takeLeave.getApplyNo()+"的申请请假/出差期间服务工作");
				log.setOperationTime(new Date());
				log.setOperationTeacherId(user.getId());
				newTakeLeave.getLogs().add(log);
			}
			if(takeLeave.getOfficeChiefStatus()!=null&&newTakeLeave.getOfficeChiefStatus().intValue()!=takeLeave.getOfficeChiefStatus().intValue()){
				TakeLeaveWorkFlowLog log=new TakeLeaveWorkFlowLog();
				log.setOperationName("处室审批");
				if(takeLeave.getOfficeChiefStatus()==1){
					log.setOperationResult("处室审批编号为"+takeLeave.getApplyNo()+"的申请通过");
					newTakeLeave.setStatus(TakeLeaveForm.Status.OfficePass.getValue());
				}
				else if(takeLeave.getOfficeChiefStatus()==2){
					log.setOperationResult("处室审批编号为"+takeLeave.getApplyNo()+"的申请不通过");
					newTakeLeave.setStatus(TakeLeaveForm.Status.Deny.getValue());	
				}
				log.setOperationTime(new Date());
				log.setOperationTeacherId(takeLeave.getOfficeChiefApproverId());
				newTakeLeave.getLogs().add(log);
			}
			if(takeLeave.getVicePrincipalStatus()!=null&&newTakeLeave.getVicePrincipalStatus().intValue()!=takeLeave.getVicePrincipalStatus().intValue()){
				TakeLeaveWorkFlowLog log=new TakeLeaveWorkFlowLog();
				log.setOperationName("分管副校长审批");
				if(takeLeave.getVicePrincipalStatus().intValue()==1){
					log.setOperationResult("分管副校长审批编号为"+takeLeave.getApplyNo()+"的申请通过");
					newTakeLeave.setStatus(TakeLeaveForm.Status.VicePrincipalPass.getValue());	
				}
				else if(takeLeave.getVicePrincipalStatus().intValue()==2){
					log.setOperationResult("分管副校长审批编号为"+takeLeave.getApplyNo()+"的申请不通过");
					newTakeLeave.setStatus(TakeLeaveForm.Status.Deny.getValue());	
				}
				log.setOperationTime(new Date());
				log.setOperationTeacherId(takeLeave.getVicePrincipalApproverId());
				newTakeLeave.getLogs().add(log);
			}
			if(takeLeave.getPrincipalStatus()!=null&&newTakeLeave.getPrincipalStatus().intValue()!=takeLeave.getPrincipalStatus().intValue()){
				TakeLeaveWorkFlowLog log=new TakeLeaveWorkFlowLog();
				log.setOperationName("校长审批");
				if(takeLeave.getPrincipalStatus().intValue()==1){
					log.setOperationResult("校长审批编号为"+takeLeave.getApplyNo()+"的申请通过");
					newTakeLeave.setStatus(TakeLeaveForm.Status.Pass.getValue());	
				}
				else if(takeLeave.getPrincipalStatus().intValue()==2){
					log.setOperationResult("校长审批编号为"+takeLeave.getApplyNo()+"的申请不通过");
					newTakeLeave.setStatus(TakeLeaveForm.Status.Deny.getValue());	
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
		List<TakeLeaveForm> list=takeLeaveDAO.getTakeLeaveAppliesByConditions(teacherId,type,status,submitBeginDate,submitEndDate,takeLeaveBeginDate,takeLeaveEndDate);
		
		return list;
	}
	@Override
	public boolean deleteTakeLeaveById(String id){
		takeLeaveDAO.remove(takeLeaveDAO.get(id));
		return true;
	}

}
