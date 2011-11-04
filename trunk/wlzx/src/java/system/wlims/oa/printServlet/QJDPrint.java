package system.wlims.oa.printServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;

import system.wlims.oa.entity.workFlow.takeLeave.TakeLeaveForm;
import system.wlims.oa.service.attendance.TakeLeaveService;


/**
 * 
 * @author skyturing
 *
 */
public class QJDPrint extends HttpServlet {
	
	private TakeLeaveService takeLeaveServiceDest;

	
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
	}
	
	@RequestMapping("/general/print/QJDPrint")
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 TakeLeaveForm tlFotm = takeLeaveServiceDest.getDetailInfoById("1");
		// PrintWriter out = response.getWriter();
		//response.setContentType("text/html;charset=GB2312");
		// out.println("<HTML><BODY>");
		// out.println(tlFotm.getApplyNo());
		// out.println("</BODY></HTML>");
		 request.setAttribute("tlFotm", tlFotm);
		 ServletContext app = getServletContext();
		 RequestDispatcher disp;
		 disp = app.getRequestDispatcher("QJDPrint.jsp");
		 disp.forward(request, response);
	}
	
	
	@Autowired
	public void setTakeLeaveService(@Qualifier("scheduleServiceDest")TakeLeaveService takeLeaveServiceDest) {
		this.takeLeaveServiceDest = takeLeaveServiceDest;
	}
	public TakeLeaveService getTakeLeaveService() {
		return takeLeaveServiceDest;
	}

	
}
