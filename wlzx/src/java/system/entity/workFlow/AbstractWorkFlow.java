package system.entity.workFlow;


public abstract class AbstractWorkFlow {
	public String type;
	public String name;
	public AbstractForm form;
	public AbstractNode startNode;
	public AbstractNode endNode;
	
}
