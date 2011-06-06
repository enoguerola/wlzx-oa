package system.entity.workFlow;

import java.util.List;

import system.entity.RoleModel;

public abstract class AbstractOperation {
public String name;
public AbstractNode afterOperation2Node;
public List<RoleModel> availableRoles;
public List<AbstractRule> rules;
}
