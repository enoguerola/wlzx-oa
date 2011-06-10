package system.wlims.oa.serviceImpl.attendance;

import java.util.Date;
import java.util.List;

import system.utils.UtilDateTime;
import system.wlims.oa.dao.attendance.OverWorkDAO;
import system.wlims.oa.entity.workFlow.overWork.OverWorkForm;
import system.wlims.oa.entity.workFlow.overWork.OverWorkWorkFlowLog;
import system.wlims.oa.service.attendance.OverWorkService;

public class OverWorkServiceImpl implements OverWorkService {
	public OverWorkDAO overWorkDAO;
	@Override
	public void addOverWorkApply(OverWorkForm overWork) {
		// TODO Auto-generated method stub
		Date currenDate=new Date();
		overWork.setApplyNo(UtilDateTime.toDateString(currenDate, "yyyyMMddhhmmss"));
		OverWorkWorkFlowLog log=new OverWorkWorkFlowLog();
		log.setOperationName("发起申请");
		log.setOperationResult("生成编号为"+overWork.getApplyNo()+"的申请记录");
		log.setOperationTime(currenDate);
		log.setOperationTeacherId(overWork.getTeacherId());
		overWork.getLogs().add(log);
		overWorkDAO.saveOrUpdate(overWork);
	}
	@Override
	public boolean updateOverWorkApply(OverWorkForm overWork) {
		// TODO Auto-generated method stub
		OverWorkForm newOverWork=overWorkDAO.get(overWork.getId());		
		if(newOverWork.getStatus().intValue()!=OverWorkForm.Status.Waiting.getValue().intValue()){
			return false;
		}else{
		
			newOverWork.setReason(overWork.getReason());
			newOverWork.setTimes(overWork.getTimes());
			OverWorkWorkFlowLog log=new OverWorkWorkFlowLog();
			log.setOperationName("编辑申请");
			log.setOperationResult("编辑编号为"+overWork.getApplyNo()+"的申请记录");
			log.setOperationTime(new Date());
			log.setOperationTeacherId(overWork.getTeacherId());
			newOverWork.getLogs().add(log);
			overWorkDAO.saveOrUpdate(newOverWork);
			return true;
		}
	}
	@Override
	public boolean approveOverWork(OverWorkForm overWork) {
		// TODO Auto-generated method stub
		OverWorkForm newOverWork=overWorkDAO.get(overWork.getId());		
		if(newOverWork.getStatus().intValue()==OverWorkForm.Status.Cancle.getValue().intValue()||newOverWork.getStatus().intValue()==OverWorkForm.Status.OfficeDeny.getValue().intValue())return false;
		else{
		
			newOverWork.setOfficeChiefApproveOption(overWork.getOfficeChiefApproveOption());
			newOverWork.setOfficeChiefApproverId(overWork.getOfficeChiefApproverId());
			newOverWork.setOfficeChiefApproveTime(overWork.getOfficeChiefApproveTime());
			newOverWork.setOfficeChiefStatus(overWork.getOfficeChiefStatus());
			newOverWork.setReason(overWork.getReason());
			
			if(newOverWork.getOfficeChiefStatus().intValue()!=overWork.getOfficeChiefStatus().intValue()){
				OverWorkWorkFlowLog log=new OverWorkWorkFlowLog();
				log.setOperationName("处室审批");
				if(newOverWork.getOfficeChiefStatus()==1){
					log.setOperationResult("处室审批编号为"+overWork.getApplyNo()+"的申请通过");
					newOverWork.setOfficeChiefStatus(OverWorkForm.Status.OfficePass.getValue());
				}
				else if(newOverWork.getOfficeChiefStatus()==0){
					log.setOperationResult("处室审批编号为"+overWork.getApplyNo()+"的申请不通过");
					newOverWork.setOfficeChiefStatus(OverWorkForm.Status.OfficeDeny.getValue());	
				}
				log.setOperationTime(new Date());
				log.setOperationTeacherId(overWork.getOfficeChiefApproverId());
				newOverWork.getLogs().add(log);
			}
			
			
			overWorkDAO.saveOrUpdate(newOverWork);
			return true;
		}
	}
	
	@Override
	public boolean cancleOverWorkApplyById(String id) {
		// TODO Auto-generated method stub
		OverWorkForm overWork=overWorkDAO.get(id);
		if(overWork.getStatus().intValue()!=OverWorkForm.Status.Waiting.getValue().intValue())return false;
		else{
			overWork.setStatus(OverWorkForm.Status.Cancle.getValue());
			OverWorkWorkFlowLog log=new OverWorkWorkFlowLog();
			log.setOperationName("取消申请");
			log.setOperationResult("取消编号为"+overWork.getApplyNo()+"的申请记录");
			log.setOperationTime(new Date());
			log.setOperationTeacherId(overWork.getTeacherId());
			overWork.getLogs().add(log);
			overWorkDAO.saveOrUpdate(overWork);
			return true;
		}
	}


	@Override
	public List<OverWorkForm> getUserOverWorkApplies(String userId) {
		// TODO Auto-generated method stub
		return overWorkDAO.getUserOverWorkApplies(userId);
	}

	public OverWorkDAO getOverWorkDAO() {
		return overWorkDAO;
	}

	public void setOverWorkDAO(OverWorkDAO overWorkDAO) {
		this.overWorkDAO = overWorkDAO;
	}
	@Override
	public OverWorkForm getDetailInfoById(String id) {
		// TODO Auto-generated method stub
		return overWorkDAO.get(id);
	}
	@Override
	public OverWorkForm loadApplyInfoById(String id) {
		// TODO Auto-generated method stub
		return overWorkDAO.get(id);
	}
	@Override
	public List<OverWorkForm> getOverWorkAppliesByConditions(
			String teacherId, String type, String status,
			String submitBeginDate, String submitEndDate,
			String overWorkBeginDate, String overWorkEndDate) {
		// TODO Auto-generated method stub
		List<OverWorkForm> list=overWorkDAO.getOverWorkAppliesByConditions(teacherId,type,status,submitBeginDate,submitEndDate,overWorkBeginDate,overWorkEndDate);
		
		return list;
	}
	@Override
	public boolean deleteOverWorkById(String id){
		overWorkDAO.remove(overWorkDAO.get(id));
		return true;
	}

}
