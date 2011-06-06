package system.entity.workFlow;

import java.util.List;

public abstract class AbstractNode {
	public String name;
	public int step;
	public List<AbstractNode>  nextNodes ;
	public List<AbstractNode>  preNodes;
	public List<AbstractOperation> availableOperations;
}
