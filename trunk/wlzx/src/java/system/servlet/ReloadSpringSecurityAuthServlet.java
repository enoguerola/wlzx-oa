package system.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.context.support.WebApplicationContextUtils;

import system.components.WlzxMethodInvocationSecurityMetadataSource;
import system.components.WlzxUrlInvocationSecurityMetadataSource;





public class ReloadSpringSecurityAuthServlet extends HttpServlet{
	
	
	private static final long serialVersionUID = 2773163413819667268L;
	public ReloadSpringSecurityAuthServlet() {
		super();
	}
	@Override
	public void destroy() {
		super.destroy(); 
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		//System.out.println("reload");
		 ServletContext context = this.getServletContext();  
		 WlzxUrlInvocationSecurityMetadataSource wlzxUrlSecurityMetadataSource=(WlzxUrlInvocationSecurityMetadataSource)WebApplicationContextUtils.getRequiredWebApplicationContext(context).getBean("wlzxUrlSecurityMetadataSource");
		 wlzxUrlSecurityMetadataSource.loadResourceDefine();
		 WlzxMethodInvocationSecurityMetadataSource wlzxMethodSecurityMetadataSource=(WlzxMethodInvocationSecurityMetadataSource)WebApplicationContextUtils.getRequiredWebApplicationContext(context).getBean("wlzxMethodSecurityMetadataSource");
		 wlzxMethodSecurityMetadataSource.loadResourceDefine();
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		this.doGet(request, response);
	}
	public void init() throws ServletException {
		// System.out.println("启动");
	        
	}


}
