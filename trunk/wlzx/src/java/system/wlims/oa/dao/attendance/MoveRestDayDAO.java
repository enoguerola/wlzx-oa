package system.wlims.oa.dao.attendance;

import java.util.List;

import system.BaseDAO;
import system.wlims.oa.entity.workFlow.moveRestDay.MoveRestDayForm;

public interface MoveRestDayDAO  extends BaseDAO<MoveRestDayForm>{
	public List<MoveRestDayForm> getUserMoveRestDayApplies(String userId);

	public List<MoveRestDayForm> getMoveRestDayAppliesByConditions(
			String teacherId, String type, String status,
			String submitBeginDate, String submitEndDate,
			String moveRestDayBeginDate, String moveRestDayEndDate);
}
