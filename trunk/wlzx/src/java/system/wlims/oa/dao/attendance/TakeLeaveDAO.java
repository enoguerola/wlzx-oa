package system.wlims.oa.dao.attendance;

import java.util.List;

import system.BaseDAO;
import system.wlims.oa.entity.workFlow.takeLeave.TakeLeaveForm;

public interface TakeLeaveDAO  extends BaseDAO<TakeLeaveForm>{
	public List<TakeLeaveForm> getUserTakeLeaveApplies(String userId);

	public List<TakeLeaveForm> getTakeLeaveAppliesByConditions(
			String teacherId, String type, String status,
			String submitBeginDate, String submitEndDate,
			String takeLeaveBeginDate, String takeLeaveEndDate);
}
