package system.wlims.oa.service.attendance;

import java.util.List;

import system.wlims.oa.entity.workFlow.moveRestDay.MoveRestDayForm;

public interface MoveRestDayService {
	public void addMoveRestDayApply(MoveRestDayForm moveRestDay);
	public boolean updateMoveRestDayApply(MoveRestDayForm moveRestDay);
	public List<MoveRestDayForm> getUserMoveRestDayApplies(String userId);
	public MoveRestDayForm loadApplyInfoById(String id);
	public MoveRestDayForm getDetailInfoById(String id);
	public boolean cancleMoveRestDayApplyById(String id);
	public List<MoveRestDayForm> getMoveRestDayAppliesByConditions(String teacherId,String type,String status,String submitBeginDate,String submitEndDate,String moveRestDayBeginDate,String moveRestDayEndDate);
	boolean deleteMoveRestDayById(String id);
	boolean approveMoveRestDay(MoveRestDayForm moveRestDay);

}
