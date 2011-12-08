package system.dao;




import java.util.List;

import system.BaseDAO;
import system.entity.DRModel;

public interface DRDAO extends BaseDAO<DRModel>{

	public DRModel getBasicDR();
	public DRModel getDRByDepartmentIdAndRoleId(String departmentId,String roleId);
	public List<DRModel> getAllDRs(boolean filterBasicFlag) ;

}
