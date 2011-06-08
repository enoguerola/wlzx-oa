package system.wlims.oa.entity.workFlow.takeLeave;

import system.wlims.oa.entity.workFlow.WorkFlowLogModel;


public class TakeLeaveWorkFlowLog extends WorkFlowLogModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3450589910733137403L;
	private TakeLeaveForm takeLeaveForm;

	public TakeLeaveForm getTakeLeaveForm() {
		return takeLeaveForm;
	}

	public void setTakeLeaveForm(TakeLeaveForm takeLeaveForm) {
		this.takeLeaveForm = takeLeaveForm;
	}

	

}
