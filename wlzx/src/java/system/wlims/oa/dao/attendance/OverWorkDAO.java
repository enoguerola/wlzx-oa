package system.wlims.oa.dao.attendance;

import java.util.List;

import system.BaseDAO;
import system.wlims.oa.entity.workFlow.overWork.OverWorkForm;

public interface OverWorkDAO  extends BaseDAO<OverWorkForm>{
	public List<OverWorkForm> getUserOverWorkApplies(String userId);

	public List<OverWorkForm> getOverWorkAppliesByConditions(
			String teacherId, String type, String status,
			String submitBeginDate, String submitEndDate,
			String overWorkBeginDate, String overWorkEndDate);
}
