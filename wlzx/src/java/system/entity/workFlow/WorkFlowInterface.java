package system.entity.workFlow;

import java.util.List;

public interface WorkFlowInterface {
	public AbstractNode getCurrentNode();
	public List<AbstractOperation> getCurrentAvailableOperations();
}
