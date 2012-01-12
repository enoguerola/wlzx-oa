package system.wlims.front.action;

import java.io.IOException;
import java.util.Date;
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

import system.ServiceException;
import system.dao.DepartmentDAO;
import system.entity.DepartmentModel;
import system.utils.UtilDateTime;
import system.wlims.oa.entity.notice.NoticeModel;
import system.wlims.oa.entity.schedule.ScheduleModel;
import system.wlims.oa.service.notice.NoticeService;
import system.wlims.oa.service.schedule.ScheduleService;





@Controller
public class IndexAction  {
	private NoticeService noticeServiceDest;
	private ScheduleService scheduleServiceDest;
	private DepartmentDAO departmentDAO;
	@RequestMapping("/index")
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		 try {
			List<NoticeModel> notices=noticeServiceDest.getTop5SchoolNotice();
			if(notices!=null&&notices.size()>0){
				for(NoticeModel notice:notices){
					DepartmentModel department=departmentDAO.get(notice.getPostDepartmentId());
					if(department!=null)
					notice.setPostDepartmentName(department.getName());
				}
			}
			String today=UtilDateTime.dateString(new Date());
			List<ScheduleModel> schedules=scheduleServiceDest.getPublicSchedulesByConditions(null,null,null,null,null,null,today,today);
			if(schedules!=null&&schedules.size()>0){
				for(ScheduleModel schedule:schedules){
					DepartmentModel department=departmentDAO.get(schedule.getDepartmentId());
					if(department!=null)
					schedule.setDepartmentName(department.getName());
				}
			}
			
		   request.setAttribute("notices", notices);
		   request.setAttribute("schedules", schedules);
			
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		 
		 
		 ServletContext app = request.getSession().getServletContext();
		 RequestDispatcher disp;
		 disp = app.getRequestDispatcher("/front/index.jsp");
		 disp.forward(request, response);
	}
	public NoticeService getNoticeServiceDest() {
		return noticeServiceDest;
	}
	@Autowired
	public void setNoticeServiceDest(@Qualifier("noticeServiceDest")NoticeService noticeServiceDest) {
		this.noticeServiceDest = noticeServiceDest;
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
