package system.wlims.oa.entity.workFlow.moveRestDay;

import system.wlims.oa.entity.workFlow.WorkFlowLogModel;


public class MoveRestDayWorkFlowLog extends WorkFlowLogModel {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -6999866971547561313L;
	/**
	 * 
	 */
	private MoveRestDayForm moveRestDayForm;

	public MoveRestDayForm getMoveRestDayForm() {
		return moveRestDayForm;
	}

	public void setMoveRestDayForm(MoveRestDayForm moveRestDayForm) {
		this.moveRestDayForm = moveRestDayForm;
	}

	

}
