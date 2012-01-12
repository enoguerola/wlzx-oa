package system.wlims.front.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;


import system.dao.DepartmentDAO;
import system.wlims.front.CalendarJSON;
import system.wlims.oa.entity.schedule.ScheduleModel;
import system.wlims.oa.service.schedule.ScheduleService;





@Controller
public class ScheduleListAction  {
	private ScheduleService scheduleServiceDest;
	private DepartmentDAO departmentDAO;
	@RequestMapping("/scheduleList")
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		 ServletContext app = request.getSession().getServletContext();
		 RequestDispatcher disp;
		 disp = app.getRequestDispatcher("/front/scheduleList.jsp");
		 
		 List<ScheduleModel> lists= scheduleServiceDest.getPublicSchedulesByConditions(null, null, null, null, null, null, null, null);
		 if(lists!=null&&lists.size()>0){
			 List<CalendarJSON> jsons=new ArrayList<CalendarJSON>();
			 for(ScheduleModel schedule:lists){
				 CalendarJSON vo=new CalendarJSON();
				 vo.setId(schedule.getId());
				 vo.setStart(schedule.getBeginTime());
				 vo.setEnd(schedule.getEndTime());
				 vo.setEditable(false);
				 vo.setTitle(schedule.getTitle());
				 if(schedule.getFinishStatus()==1){
						vo.setColor("gray");
				}
				 jsons.add(vo);
			 }
			 System.out.println(new Gson().toJson(jsons));
			 request.setAttribute("data", new Gson().toJson(jsons)) ;
		 }
		 
		 disp.forward(request, response);
	}
	public ScheduleService getScheduleServiceDest() {
		return scheduleServiceDest;
	}
	@Autowired
	public void setScheduleServiceDest(@Qualifier("scheduleServiceDest")ScheduleService scheduleServiceDest) {
		this.scheduleServiceDest = scheduleServiceDest;
	}
	public DepartmentDAO getDepartmentDAO() {
		return departmentDAO;
	}
	@Autowired
	public void setDepartmentDAO(@Qualifier("departmentDAO")DepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}

	
	


}
