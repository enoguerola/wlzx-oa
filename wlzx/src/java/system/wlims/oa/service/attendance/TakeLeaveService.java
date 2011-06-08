package system.wlims.oa.service.attendance;

import java.util.List;

import system.wlims.oa.entity.workFlow.takeLeave.TakeLeaveForm;

public interface TakeLeaveService {
	public void addTakeLeaveApply(TakeLeaveForm takeLeave);
	public boolean updateTakeLeaveApply(TakeLeaveForm takeLeave);
	public List<TakeLeaveForm> getUserTakeLeaveApplies(String userId);
	public TakeLeaveForm getTakeLeaveFormById(String id);
	public boolean cancleTakeLeaveApplyById(String id);
}
