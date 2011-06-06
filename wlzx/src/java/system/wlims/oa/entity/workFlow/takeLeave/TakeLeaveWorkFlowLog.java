package system.wlims.oa.entity.workFlow.takeLeave;

import system.wlims.oa.entity.workFlow.WorkFlowLogModel;


public class TakeLeaveWorkFlowLog extends WorkFlowLogModel {
	
	private TakeLeaveWorkFlow takeLeaveWorkFlow;

	public TakeLeaveWorkFlow getTakeLeaveWorkFlow() {
		return takeLeaveWorkFlow;
	}

	public void setTakeLeaveWorkFlow(TakeLeaveWorkFlow takeLeaveWorkFlow) {
		this.takeLeaveWorkFlow = takeLeaveWorkFlow;
	}

}
