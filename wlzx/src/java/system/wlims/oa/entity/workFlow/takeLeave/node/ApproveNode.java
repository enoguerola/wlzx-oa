package system.wlims.oa.entity.workFlow.takeLeave.node;

import java.util.ArrayList;

import system.entity.workFlow.AbstractNode;

public class ApproveNode extends AbstractNode {
	public ApproveNode(){
		name="审批";
		step=2;
		preNodes=new ArrayList<AbstractNode>();
		preNodes.add(new ApplyNode());
		nextNodes=new ArrayList<AbstractNode>();
		nextNodes.add(new EndNode());
	}
}
