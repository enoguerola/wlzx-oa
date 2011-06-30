package system.wlims.oa.dao.course.adjust;

import java.util.List;

import system.BaseDAO;
import system.wlims.oa.entity.course.adjust.ApplyModel;

public interface CourseAdjustDAO extends BaseDAO<ApplyModel>{
	List<ApplyModel> getAppliesByCondition(String accountId,Integer state,Integer type, String beginDate,String endDate);
	List<ApplyModel> personalApplySearch(String accountId);
}
