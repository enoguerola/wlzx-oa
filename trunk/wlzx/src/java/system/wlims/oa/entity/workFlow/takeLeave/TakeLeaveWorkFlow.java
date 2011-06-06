package system.wlims.oa.entity.workFlow.takeLeave;


import system.entity.workFlow.AbstractWorkFlow;
import system.wlims.oa.entity.workFlow.takeLeave.node.BeginNode;
import system.wlims.oa.entity.workFlow.takeLeave.node.EndNode;

public class TakeLeaveWorkFlow extends AbstractWorkFlow {

public TakeLeaveWorkFlow(){
		this.name="请假流程";
		this.type="考勤";
		startNode=new BeginNode();
		endNode=new EndNode();
		
	}
	
	

}
