package system.wlims.oa.service.integration;



import java.util.List;
import system.wlims.oa.vo.TaskVO;

public interface AllWaittingDealService {
	
	List<TaskVO> getAllWaittingDealTasksByCondition(String accountId,String status,String beginTime,String endTime);

}
