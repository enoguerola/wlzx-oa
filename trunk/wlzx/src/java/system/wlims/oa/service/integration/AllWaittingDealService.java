package system.wlims.oa.service.integration;



import java.util.List;
import system.wlims.oa.vo.TaskVO;

public interface AllWaittingDealService {
	
	List<TaskVO> getAllDealTasksByCondition(String accountId,String beginTime,String endTime);
	List<TaskVO> getAllWaittingDealTasksByCondition(String accountId,String beginTime,String endTime);
	
}
