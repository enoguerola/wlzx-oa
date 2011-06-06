package system.wlims.oa.entity.workFlow.takeLeave.node;

import java.util.ArrayList;

import system.entity.workFlow.AbstractNode;

public class EndNode extends AbstractNode {
	public EndNode(){
		this.name="结束";
		this.step=3;
		this.preNodes=new ArrayList<AbstractNode>();
		this.preNodes.add(new ApproveNode());
		this.nextNodes=null;
	}
}
