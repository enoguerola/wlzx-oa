package system.wlims.oa.entity.workFlow.takeLeave.node;

import java.util.ArrayList;

import system.entity.workFlow.AbstractNode;

public class ApplyNode extends AbstractNode {
	public ApplyNode(){
		name="申请";
		step=1;
		preNodes=new ArrayList<AbstractNode>();
		preNodes.add(new BeginNode());
		nextNodes=new ArrayList<AbstractNode>();
		nextNodes.add(new ApproveNode());
	}
}
