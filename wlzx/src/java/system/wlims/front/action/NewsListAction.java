package system.wlims.front.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import system.PaginationSupport;
import system.wlims.front.entity.ModelNews;






@Controller
public class NewsListAction  {
	
	@RequestMapping("/newsList")
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String type = (String)request.getParameter("type");
//		String emergence = (String)request.getParameter("emergence");
//		String deparmentIds = (String)request.getParameter("deparmentIds");
//		String title = (String)request.getParameter("title");
//		String beginDate = (String)request.getParameter("beginDate");
//		String endDate = (String)request.getParameter("endDate");
		
		 String page =request.getParameter("cpage")==null?"1":(String)request.getParameter("cpage");
		   
			
		 
		try {
			PaginationSupport<ModelNews> newsPages = NewsDispatch.getNewsList(page);
			 request.setAttribute("newsPages", newsPages);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		 
		 
		 ServletContext app = request.getSession().getServletContext();
		 RequestDispatcher disp;
		 disp = app.getRequestDispatcher("/front/newsList.jsp");
		 disp.forward(request, response);
	}


}
