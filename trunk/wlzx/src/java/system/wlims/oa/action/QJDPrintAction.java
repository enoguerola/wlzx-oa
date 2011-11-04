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

import system.ServiceException;
import system.wlims.basic.entity.teacher.TeacherModel;
import system.wlims.basic.service.teacher.TeacherService;
import system.wlims.oa.entity.workFlow.takeLeave.TakeLeaveForm;
import system.wlims.oa.service.attendance.TakeLeaveService;




@Controller
public class QJDPrintAction  {
	
	
	private TakeLeaveService takeLeaveServiceDest;
	
	private TeacherService  teacherServiceDest;

	@RequestMapping("/general/print/QJDPrint")
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 String id = (String)request.getParameter("id");
		 TakeLeaveForm tlForm = takeLeaveServiceDest.getDetailInfoById(id);
			// PrintWriter out = response.getWriter();
			//response.setContentType("text/html;charset=GB2312");
			// out.println("<HTML><BODY>");
			// out.println(tlFotm.getApplyNo());
			// out.println("</BODY></HTML>");
		 try {
				String tm = teacherServiceDest.getTeacherNameByUserId(tlForm.getTeacherId());
				tlForm.setTeacherId(tm);
				
				if(tlForm.getOfficeChiefApproverId()!=null&&!tlForm.getOfficeChiefApproverId().equalsIgnoreCase(""))
				{
					tm = teacherServiceDest.getTeacherNameByUserId(tlForm.getOfficeChiefApproverId());
					tlForm.setOfficeChiefApproverId(tm);
				}
				if(tlForm.getPrincipalApproverId()!=null&&!tlForm.getPrincipalApproverId().equalsIgnoreCase(""))
				{
					tm = teacherServiceDest.getTeacherNameByUserId(tlForm.getPrincipalApproverId());
					tlForm.setPrincipalApproverId(tm);
				}
				if(tlForm.getVicePrincipalApproverId()!=null&&!tlForm.getVicePrincipalApproverId().equalsIgnoreCase(""))
				{
					tm = teacherServiceDest.getTeacherNameByUserId(tlForm.getVicePrincipalApproverId());
					tlForm.setVicePrincipalApproverId(tm);
				}
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		 request.setAttribute("tlForm", tlForm);
		 
		
		 
		 
		 
		 ServletContext app = request.getSession().getServletContext();
		 RequestDispatcher disp;
		 disp = app.getRequestDispatcher("/QJDPrint.jsp");
		 disp.forward(request, response);
	}
	
	
	@Autowired
	public void setTakeLeaveService(@Qualifier("takeLeaveServiceDest")TakeLeaveService takeLeaveServiceDest) {
		this.takeLeaveServiceDest = takeLeaveServiceDest;
	}
	public TakeLeaveService getTakeLeaveService() {
		return takeLeaveServiceDest;
	}
	
	@Autowired
	public void setTeacherService(@Qualifier("teacherServiceDest")TeacherService teacherServiceDest) {
		this.teacherServiceDest = teacherServiceDest;
	}
	public TeacherService getTeacherService() {
		return teacherServiceDest;
	}
	

}
