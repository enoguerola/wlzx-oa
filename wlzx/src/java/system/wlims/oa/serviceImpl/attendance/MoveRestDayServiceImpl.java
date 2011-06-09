package system.wlims.oa.serviceImpl.attendance;

import java.util.Date;
import java.util.List;


import system.utils.UtilDateTime;
import system.wlims.oa.dao.attendance.MoveRestDayDAO;
import system.wlims.oa.entity.workFlow.moveRestDay.MoveRestDayForm;
import system.wlims.oa.entity.workFlow.moveRestDay.MoveRestDayWorkFlowLog;
import system.wlims.oa.service.attendance.MoveRestDayService;

public class MoveRestDayServiceImpl implements MoveRestDayService {
	public MoveRestDayDAO moveRestDayDAO;
	@Override
	public void addMoveRestDayApply(MoveRestDayForm moveRestDay) {
		// TODO Auto-generated method stub
		Date currenDate=new Date();
		moveRestDay.setApplyNo(UtilDateTime.toDateString(currenDate, "yyyyMMddhhmmss"));
		MoveRestDayWorkFlowLog log=new MoveRestDayWorkFlowLog();
		log.setOperationName("发起申请");
		log.setOperationResult("生成编号为"+moveRestDay.getApplyNo()+"的申请记录");
		log.setOperationTime(currenDate);
		log.setOperationTeacherId(moveRestDay.getTeacherId());
		moveRestDay.getLogs().add(log);
		moveRestDayDAO.saveOrUpdate(moveRestDay);
	}
	@Override
	public boolean updateMoveRestDayApply(MoveRestDayForm moveRestDay) {
		// TODO Auto-generated method stub
		MoveRestDayForm newMoveRestDay=moveRestDayDAO.get(moveRestDay.getId());		
		if(newMoveRestDay.getStatus()!=MoveRestDayForm.Status.Waiting.getValue())return false;
		else{
			newMoveRestDay.setBeginTime(moveRestDay.getBeginTime());
			newMoveRestDay.setEndTime(moveRestDay.getEndTime());
			
			newMoveRestDay.setReason(moveRestDay.getReason());
			MoveRestDayWorkFlowLog log=new MoveRestDayWorkFlowLog();
			log.setOperationName("编辑申请");
			log.setOperationResult("编辑编号为"+moveRestDay.getApplyNo()+"的申请记录");
			log.setOperationTime(new Date());
			log.setOperationTeacherId(moveRestDay.getTeacherId());
			newMoveRestDay.getLogs().add(log);
			moveRestDayDAO.saveOrUpdate(newMoveRestDay);
			return true;
		}
	}
	@Override
	public boolean approveMoveRestDay(MoveRestDayForm moveRestDay) {
		// TODO Auto-generated method stub
		MoveRestDayForm newMoveRestDay=moveRestDayDAO.get(moveRestDay.getId());		
		if(newMoveRestDay.getStatus()==MoveRestDayForm.Status.Cancle.getValue()||newMoveRestDay.getStatus()==MoveRestDayForm.Status.Deny.getValue())return false;
		else{
			newMoveRestDay.setOfficeChiefApproveOption(moveRestDay.getOfficeChiefApproveOption());
			newMoveRestDay.setOfficeChiefApproverId(moveRestDay.getOfficeChiefApproverId());
			newMoveRestDay.setOfficeChiefApproveTime(moveRestDay.getOfficeChiefApproveTime());
			newMoveRestDay.setOfficeChiefStatus(moveRestDay.getOfficeChiefStatus());
			newMoveRestDay.setVicePrincipalApproveOption(moveRestDay.getVicePrincipalApproveOption());
			newMoveRestDay.setVicePrincipalApproverId(moveRestDay.getVicePrincipalApproverId());
			newMoveRestDay.setVicePrincipalApproveTime(moveRestDay.getVicePrincipalApproveTime());
			newMoveRestDay.setVicePrincipalStatus(moveRestDay.getVicePrincipalStatus());
		
			newMoveRestDay.setReason(moveRestDay.getReason());
			
			if(newMoveRestDay.getOfficeChiefStatus()!=moveRestDay.getOfficeChiefStatus()){
				MoveRestDayWorkFlowLog log=new MoveRestDayWorkFlowLog();
				log.setOperationName("处室审批");
				if(newMoveRestDay.getOfficeChiefStatus()==1){
					log.setOperationResult("处室审批编号为"+moveRestDay.getApplyNo()+"的申请通过");
					newMoveRestDay.setStatus(MoveRestDayForm.Status.OfficePass.getValue());
				}
				else if(newMoveRestDay.getOfficeChiefStatus()==0){
					log.setOperationResult("处室审批编号为"+moveRestDay.getApplyNo()+"的申请不通过");
					newMoveRestDay.setStatus(MoveRestDayForm.Status.Deny.getValue());	
				}
				log.setOperationTime(new Date());
				log.setOperationTeacherId(moveRestDay.getOfficeChiefApproverId());
				newMoveRestDay.getLogs().add(log);
			}
			if(newMoveRestDay.getVicePrincipalStatus()!=moveRestDay.getVicePrincipalStatus()){
				MoveRestDayWorkFlowLog log=new MoveRestDayWorkFlowLog();
				log.setOperationName("分管副校长审批");
				if(newMoveRestDay.getVicePrincipalStatus()==1){
					log.setOperationResult("分管副校长审批编号为"+moveRestDay.getApplyNo()+"的申请通过");
					newMoveRestDay.setStatus(MoveRestDayForm.Status.Pass.getValue());	
				}
				else if(newMoveRestDay.getVicePrincipalStatus()==0){
					log.setOperationResult("分管副校长审批编号为"+moveRestDay.getApplyNo()+"的申请不通过");
					newMoveRestDay.setStatus(MoveRestDayForm.Status.Deny.getValue());	
				}
				log.setOperationTime(new Date());
				log.setOperationTeacherId(moveRestDay.getVicePrincipalApproverId());
				newMoveRestDay.getLogs().add(log);
			}
			
			
			moveRestDayDAO.saveOrUpdate(newMoveRestDay);
			return true;
		}
	}
	
	@Override
	public boolean cancleMoveRestDayApplyById(String id) {
		// TODO Auto-generated method stub
		MoveRestDayForm moveRestDay=moveRestDayDAO.get(id);
		if(moveRestDay.getStatus()!=MoveRestDayForm.Status.Waiting.getValue())return false;
		else{
			moveRestDay.setStatus(MoveRestDayForm.Status.Cancle.getValue());
			MoveRestDayWorkFlowLog log=new MoveRestDayWorkFlowLog();
			log.setOperationName("取消申请");
			log.setOperationResult("取消编号为"+moveRestDay.getApplyNo()+"的申请记录");
			log.setOperationTime(new Date());
			log.setOperationTeacherId(moveRestDay.getTeacherId());
			moveRestDay.getLogs().add(log);
			moveRestDayDAO.saveOrUpdate(moveRestDay);
			return true;
		}
	}


	@Override
	public List<MoveRestDayForm> getUserMoveRestDayApplies(String userId) {
		// TODO Auto-generated method stub
		return moveRestDayDAO.getUserMoveRestDayApplies(userId);
	}

	public MoveRestDayDAO getMoveRestDayDAO() {
		return moveRestDayDAO;
	}

	public void setMoveRestDayDAO(MoveRestDayDAO moveRestDayDAO) {
		this.moveRestDayDAO = moveRestDayDAO;
	}
	@Override
	public MoveRestDayForm getDetailInfoById(String id) {
		// TODO Auto-generated method stub
		return moveRestDayDAO.get(id);
	}
	@Override
	public MoveRestDayForm loadApplyInfoById(String id) {
		// TODO Auto-generated method stub
		return moveRestDayDAO.get(id);
	}
	@Override
	public List<MoveRestDayForm> getMoveRestDayAppliesByConditions(
			String teacherId, String type, String status,
			String submitBeginDate, String submitEndDate,
			String moveRestDayBeginDate, String moveRestDayEndDate) {
		// TODO Auto-generated method stub
		List<MoveRestDayForm> list=moveRestDayDAO.getMoveRestDayAppliesByConditions(teacherId,type,status,submitBeginDate,submitEndDate,moveRestDayBeginDate,moveRestDayEndDate);
		
		return list;
	}
	@Override
	public boolean deleteMoveRestDayById(String id){
		moveRestDayDAO.remove(moveRestDayDAO.get(id));
		return true;
	}

}
