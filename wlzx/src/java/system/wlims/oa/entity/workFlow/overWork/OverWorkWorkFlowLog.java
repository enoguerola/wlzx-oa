package system.wlims.oa.entity.workFlow.overWork;

import system.wlims.oa.entity.workFlow.WorkFlowLogModel;


public class OverWorkWorkFlowLog extends WorkFlowLogModel {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1134017758497067636L;
	private OverWorkForm overWorkForm;

	public OverWorkForm getOverWorkForm() {
		return overWorkForm;
	}

	public void setOverWorkForm(OverWorkForm overWorkForm) {
		this.overWorkForm = overWorkForm;
	}

	

}
