package system.wlims.oa.service.attendance;

import java.util.Date;
import java.util.List;

import system.wlims.oa.entity.workFlow.takeLeave.TakeLeaveForm;

public interface TakeLeaveService {
	public void addTakeLeaveApply(TakeLeaveForm takeLeave);
	public boolean updateTakeLeaveApply(TakeLeaveForm takeLeave);
	public List<TakeLeaveForm> getUserTakeLeaveApplies(String userId);
	public TakeLeaveForm loadApplyInfoById(String id);
	public TakeLeaveForm getDetailInfoById(String id);
	public boolean cancleTakeLeaveApplyById(String id);
	public List<TakeLeaveForm> getTakeLeaveAppliesByConditions(String teacherId,String type,String status,String submitBeginDate,String submitEndDate,String takeLeaveBeginDate,String takeLeaveEndDate);
	boolean deleteTakeLeaveById(String id);
	boolean approveTakeLeave(TakeLeaveForm takeLeave);
	boolean terminateLeaveApply(String id, String date,String reason);
	boolean terminateLeaveApprove(String id,String option,Integer status,String approverId,Date approverDate);

}
