package system.wlims.front.action;

import java.io.IOException;

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
import system.wlims.oa.entity.notice.NoticeModel;
import system.wlims.oa.service.notice.NoticeService;





@Controller
public class NoticeDetailAction  {
	private NoticeService noticeServiceDest;
	private DepartmentDAO departmentDAO;
	@RequestMapping("/noticeDetail")
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 String id = (String)request.getParameter("id");

		 try {
			NoticeModel notice=noticeServiceDest.get(id);
			DepartmentModel department=departmentDAO.get(notice.getPostDepartmentId());
			if(department!=null)
			notice.setPostDepartmentName(department.getName());
		   request.setAttribute("notice", notice);
			
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		 
		 
		 ServletContext app = request.getSession().getServletContext();
		 RequestDispatcher disp;
		 disp = app.getRequestDispatcher("/front/noticeDetail.jsp");
		 disp.forward(request, response);
	}
	public NoticeService getNoticeServiceDest() {
		return noticeServiceDest;
	}
	@Autowired
	public void setNoticeServiceDest(@Qualifier("noticeServiceDest")NoticeService noticeServiceDest) {
		this.noticeServiceDest = noticeServiceDest;
	}
	
	public DepartmentDAO getDepartmentDAO() {
		return departmentDAO;
	}
	@Autowired
	public void setDepartmentDAO(@Qualifier("departmentDAO")DepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}
	
	


}
