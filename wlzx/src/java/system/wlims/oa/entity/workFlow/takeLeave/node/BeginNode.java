package system.wlims.oa.entity.workFlow.takeLeave.node;

import java.util.ArrayList;

import system.entity.workFlow.AbstractNode;

public class BeginNode extends AbstractNode {
	public	BeginNode(){
		name="开始";
		step=0;
		preNodes=null;
		nextNodes=new ArrayList<AbstractNode>();
		nextNodes.add(new ApplyNode());
	}
}
