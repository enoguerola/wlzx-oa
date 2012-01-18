package system.wlims.front.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

import system.wlims.front.entity.ModelNews;






@Controller
public class NewsJSONAction  {
	
	@RequestMapping("/newsJSON")
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		 String page =request.getParameter("page")==null?"1":(String)request.getParameter("page");
		   
		
		try {
			 List<ModelNews> list = NewsDispatch.getNewsList(page).getItems();
			 response.setContentType("json");
			    request.setCharacterEncoding("UTF-8");
			    response.setCharacterEncoding("UTF-8"); 
				response.setContentType("json");
				String before=new Gson().toJson(list);
//		        String after= CharsetConvertor.GBToUnicode(before);
				response.getWriter().write(before);
				response.flushBuffer();
				response.getWriter().close();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
	}


}
