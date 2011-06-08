package system.wlims.oa.entity.workFlow.takeLeave;

import system.wlims.oa.entity.workFlow.WorkFlowLogModel;


public class TakeLeaveWorkFlowLog extends WorkFlowLogModel {
	
	private TakeLeaveForm takeLeaveForm;

	public TakeLeaveForm getTakeLeaveForm() {
		return takeLeaveForm;
	}

	public void setTakeLeaveForm(TakeLeaveForm takeLeaveForm) {
		this.takeLeaveForm = takeLeaveForm;
	}

	

}
