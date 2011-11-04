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
import system.wlims.oa.entity.workFlow.moveRestDay.MoveRestDayForm;
import system.wlims.oa.service.attendance.MoveRestDayService;




@Controller
public class TXDPrintAction  {
	
	
	private MoveRestDayService  moveRestDayServiceDest;
	
	private TeacherService  teacherServiceDest;

	@RequestMapping("/general/print/TXDPrint")
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 String id = (String)request.getParameter("id");
		 MoveRestDayForm mrForm = moveRestDayServiceDest.getDetailInfoById(id);
			// PrintWriter out = response.getWriter();
			//response.setContentType("text/html;charset=GB2312");
			// out.println("<HTML><BODY>");
			// out.println(tlFotm.getApplyNo());
			// out.println("</BODY></HTML>");
		 try {
				String tm = teacherServiceDest.getTeacherNameByUserId(mrForm.getTeacherId());
				mrForm.setTeacherId(tm);
				
				if(mrForm.getOfficeChiefApproverId()!=null&&!mrForm.getOfficeChiefApproverId().equalsIgnoreCase(""))
				{
					tm = teacherServiceDest.getTeacherNameByUserId(mrForm.getOfficeChiefApproverId());
					mrForm.setOfficeChiefApproverId(tm);
				}
			
				if(mrForm.getVicePrincipalApproverId()!=null&&!mrForm.getVicePrincipalApproverId().equalsIgnoreCase(""))
				{
					tm = teacherServiceDest.getTeacherNameByUserId(mrForm.getVicePrincipalApproverId());
					mrForm.setVicePrincipalApproverId(tm);
				}
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		 request.setAttribute("mrForm", mrForm);
		 
		
		 
		 
		 
		 ServletContext app = request.getSession().getServletContext();
		 RequestDispatcher disp;
		 disp = app.getRequestDispatcher("/TXDPrint.jsp");
		 disp.forward(request, response);
	}
	
	
	@Autowired
	public void setMoveRestDayService(@Qualifier("moveRestDayServiceDest")MoveRestDayService moveRestDayServiceDest) {
		this.moveRestDayServiceDest = moveRestDayServiceDest;
	}
	public MoveRestDayService getMoveRestDayService() {
		return moveRestDayServiceDest;
	}
	
	@Autowired
	public void setTeacherService(@Qualifier("teacherServiceDest")TeacherService teacherServiceDest) {
		this.teacherServiceDest = teacherServiceDest;
	}
	public TeacherService getTeacherService() {
		return teacherServiceDest;
	}
	

}
