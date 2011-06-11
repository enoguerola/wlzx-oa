package system.wlims.oa.service.attendance;

import java.util.List;

import system.wlims.oa.entity.workFlow.overWork.OverWorkForm;

public interface OverWorkService {
	public void addOverWorkApply(OverWorkForm overWork);
	public boolean updateOverWorkApply(OverWorkForm overWork);
	public List<OverWorkForm> getUserOverWorkApplies(String userId);
	public OverWorkForm loadApplyInfoById(String id);
	public OverWorkForm getDetailInfoById(String id);
	public boolean cancleOverWorkApplyById(String id);
	public List<OverWorkForm> getOverWorkAppliesByConditions(String teacherId,String status,String submitBeginDate,String submitEndDate,String overWorkBeginDate,String overWorkEndDate);
	boolean deleteOverWorkById(String id);
	boolean approveOverWork(OverWorkForm overWork);

}
