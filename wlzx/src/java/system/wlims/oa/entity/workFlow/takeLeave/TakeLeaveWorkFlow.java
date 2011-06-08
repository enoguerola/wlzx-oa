package system.wlims.oa.entity.workFlow.takeLeave;


import java.util.List;

import system.entity.workFlow.AbstractNode;
import system.entity.workFlow.AbstractOperation;
import system.entity.workFlow.AbstractWorkFlow;
import system.entity.workFlow.WorkFlowInterface;
import system.wlims.oa.entity.workFlow.takeLeave.node.BeginNode;
import system.wlims.oa.entity.workFlow.takeLeave.node.EndNode;

public class TakeLeaveWorkFlow extends AbstractWorkFlow  implements WorkFlowInterface{

	public TakeLeaveWorkFlow(){
		this.name="请假流程";
		this.type="考勤";
		startNode=new BeginNode();
		endNode=new EndNode();
		
	}

	@Override
	public List<AbstractOperation> getCurrentAvailableOperations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractNode getCurrentNode() {
		// TODO Auto-generated method stub
		return null;
	} 

	

}
