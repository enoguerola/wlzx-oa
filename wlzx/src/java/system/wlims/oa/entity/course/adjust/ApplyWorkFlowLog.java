package system.wlims.oa.entity.course.adjust;

import system.wlims.oa.entity.workFlow.WorkFlowLogModel;


public class ApplyWorkFlowLog extends WorkFlowLogModel {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1134017758497067636L;
	private ApplyModel applyForm;
	public ApplyModel getApplyForm() {
		return applyForm;
	}
	public void setApplyForm(ApplyModel applyForm) {
		this.applyForm = applyForm;
	}

	

	

}
