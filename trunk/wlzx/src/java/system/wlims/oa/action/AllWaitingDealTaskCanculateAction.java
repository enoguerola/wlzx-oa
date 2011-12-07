package system.wlims.oa.action;

import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import system.wlims.oa.service.integration.AllWaittingDealService;
import system.wlims.oa.vo.TaskVO;





@Controller
public class AllWaitingDealTaskCanculateAction{
	
	
	private AllWaittingDealService allWaittingDealService;
	

	@RequestMapping("/general/allWaittingDealTaskCanculate")
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		 String id = (String)request.getParameter("id");
		response.setCharacterEncoding("UTF-8");
        response.setContentType("json");
		String userId=(String)request.getParameter("userId");
		String beginTime=(String)request.getParameter("beginTime");
		String endTime=(String)request.getParameter("endTime");
		List<TaskVO> list=allWaittingDealService.getAllWaittingDealTasksByCondition(userId, beginTime, endTime);
		int size=0;
		if(list!=null)size=list.size();
		System.out.println(size);

		response.getWriter().write(size);
		response.flushBuffer();
		response.getWriter().close();

	}
	
	
	@Autowired
	public void setAllWaittingDealService(@Qualifier("allWaittingDealServiceDest")AllWaittingDealService allWaittingDealService) {
		this.allWaittingDealService = allWaittingDealService;
	}
	public AllWaittingDealService getAllWaittingDealService() {
		return allWaittingDealService;
	}
	
	

}
