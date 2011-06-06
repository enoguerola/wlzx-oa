package system.entity.workFlow;

import java.util.List;

public abstract class AbstractWorkFlow  implements WorkFlowInterface{
	public String type;
	public String name;
	public AbstractForm form;
	public AbstractNode startNode;
	public AbstractNode endNode;
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
