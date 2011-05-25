package system.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.web.context.support.WebApplicationContextUtils;

import system.components.SecurityUserHolder;
import system.entity.UserModel;
import system.service.SystemService;



public class LoginRusultDealServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1603004932284674865L;

	protected MessageSourceAccessor messages = SpringSecurityMessageSource.getAccessor();

	public LoginRusultDealServlet() {
		super();
	}
	@Override
	public void destroy() {
		super.destroy(); 
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		UserModel user=SecurityUserHolder.getCurrentUser();
		String result="";
		if(user!=null){
			if(user.getActive()){
				result="success";
			}else{
//				result=messages.getMessage("UserDetailsService.credentialsExpired");
				result="用户帐号已经锁定,请联系管理员";
			}
		}else{
//			result=messages.getMessage("PasswordComparisonAuthenticator.badCredentials");
			result="用户名密码错误";
		}
		System.out.println(result);
		if(result.equals("success")){
			 ServletContext context = this.getServletContext();  
			 SystemService systemService=(SystemService)WebApplicationContextUtils.getRequiredWebApplicationContext(context).getBean("systemServiceDest");
			 System.out.println(systemService);
			 user.setLastLoginTime(new Date());
			 user.setLastLoginIP(request.getRemoteHost());
			 systemService.getUserDAO().saveOrUpdate(user);
		}
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(result);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		this.doGet(request, response);
	}
	public void init() throws ServletException {
 
	}
	
	public void setMessageSource(MessageSource messageSource) {
		this.messages = new MessageSourceAccessor(messageSource);
	}

}
