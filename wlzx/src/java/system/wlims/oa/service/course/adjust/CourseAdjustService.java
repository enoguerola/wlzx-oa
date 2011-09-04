package system.wlims.oa.service.course.adjust;

import java.util.List;
import java.util.Set;

import system.wlims.oa.entity.course.adjust.ApplyItemModel;
import system.wlims.oa.entity.course.adjust.ApplyModel;


public interface CourseAdjustService{
	boolean applyAdd(ApplyModel apply);
	List<ApplyModel> personalApplySearch();
	ApplyModel getApplyById(String applyId);
	boolean cancleApplyById(String applyId);
	boolean deleteApplyById(String applyId);
	ApplyModel loadApplyInfo(String applyId);
	boolean applyUpdate(ApplyModel apply,Set<ApplyItemModel> applyItems);
	List<ApplyModel> getAppliesByCondition(String accountId,Integer state,Integer type, String beginDate,String endDate);
	boolean saveApprove(ApplyModel apply);
	boolean saveArrange(ApplyModel apply);
	
}
