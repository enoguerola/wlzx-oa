package system.wlims.front.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import system.wlims.front.entity.ModelNews;





@Controller
public class NewsDetailAction  {

	@RequestMapping("/newsDetail")
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 String id = (String)request.getParameter("id");

			try {
				ModelNews news = NewsDispatch.getNews(id);
				   request.setAttribute("news", news);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
	
		 
		 ServletContext app = request.getSession().getServletContext();
		 RequestDispatcher disp;
		 disp = app.getRequestDispatcher("/front/newsDetail.jsp");
		 disp.forward(request, response);
	}
	

}
