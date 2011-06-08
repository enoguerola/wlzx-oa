package system.wlims.oa.serviceImpl.attendance;

import java.util.Date;
import java.util.List;

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
		takeLeave.setApplyNo(UtilDateTime.toDateString(currenDate, "yyyyMMddhhmmss"));
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
		if(takeLeave.getStatus()!=TakeLeaveForm.Status.Waiting.getValue())return false;
		else{
			TakeLeaveWorkFlowLog log=new TakeLeaveWorkFlowLog();
			log.setOperationName("编辑申请");
			log.setOperationResult("编辑编号为"+takeLeave.getApplyNo()+"的申请记录");
			log.setOperationTime(new Date());
			log.setOperationTeacherId(takeLeave.getTeacherId());
			takeLeave.getLogs().add(log);
			takeLeaveDAO.merge(takeLeave);
			return true;
		}
	}

	@Override
	public boolean cancleTakeLeaveApplyById(String id) {
		// TODO Auto-generated method stub
		TakeLeaveForm takeLeave=takeLeaveDAO.get(id);
		if(takeLeave.getStatus()!=TakeLeaveForm.Status.Waiting.getValue())return false;
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
	public TakeLeaveForm getTakeLeaveFormById(String id) {
		// TODO Auto-generated method stub
		return takeLeaveDAO.get(id);
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


}
