package system.wlims.oa.action;

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

import system.wlims.basic.service.teacher.TeacherService;
import system.wlims.oa.entity.workFlow.overWork.OverWorkForm;
import system.wlims.oa.service.attendance.OverWorkService;





@Controller
public class JBDPrintAction  {
	
	
	private OverWorkService overWorkServiceDest;
	
	private TeacherService  teacherServiceDest;

	@RequestMapping("/general/print/JBDPrint")
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 String id = (String)request.getParameter("id");
		 OverWorkForm owForm = overWorkServiceDest.getDetailInfoById(id);
			// PrintWriter out = response.getWriter();
			//response.setContentType("text/html;charset=GB2312");
			// out.println("<HTML><BODY>");
			// out.println(tlFotm.getApplyNo());
			// out.println("</BODY></HTML>");
		 try {
				String tm = teacherServiceDest.getTeacherNameByUserId(owForm.getTeacherId());
				owForm.setTeacherId(tm);
				
				if(owForm.getOfficeChiefApproverId()!=null&&!owForm.getOfficeChiefApproverId().equalsIgnoreCase(""))
				{
					tm = teacherServiceDest.getTeacherNameByUserId(owForm.getOfficeChiefApproverId());
					owForm.setOfficeChiefApproverId(tm);
				}
				
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		 request.setAttribute("owForm", owForm);
		 
		 ServletContext app = request.getSession().getServletContext();
		 RequestDispatcher disp;
		 disp = app.getRequestDispatcher("/JBDPrint.jsp");
		 disp.forward(request, response);
	}
	
	
	@Autowired
	public void setOverWorkService(@Qualifier("overWorkServiceDest")OverWorkService overWorkServiceDest) {
		this.overWorkServiceDest = overWorkServiceDest;
	}
	public OverWorkService getOverWorkService() {
		return overWorkServiceDest;
	}
	
	@Autowired
	public void setTeacherService(@Qualifier("teacherServiceDest")TeacherService teacherServiceDest) {
		this.teacherServiceDest = teacherServiceDest;
	}
	public TeacherService getTeacherService() {
		return teacherServiceDest;
	}
	

}
