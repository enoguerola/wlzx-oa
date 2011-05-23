package system.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	/**
	 * 
	 */
	public static final String SECURITY_FORM_USER_NAME_KEY = "j_username";
	public static final String SECURITY_FORM_PASSWORD_KEY = "j_password";
	public static final String SECURITY_FORM_REMEMBER_KEY="j_rememberPWD";
	public static final String SPRING_SECURITY_REMEMBER_KEY = "_spring_security_remember_me";
	public static final String SPRING_SECURITY_LAST_USERNAME_KEY = "SPRING_SECURITY_LAST_USERNAME";
	public static final String SPRING_SECURITY_LAST_USERNAME_PASSWORD_KEY = "SPRING_SECURITY_LAST_USERNAME_PASSWORD";
	public static final String REMEBER_PASSWORD = "REMEMBER_PASSWORD";
	
	private String usernameParameter = SECURITY_FORM_USER_NAME_KEY;
	private String passwordParameter = SECURITY_FORM_PASSWORD_KEY;
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
				result=messages.getMessage("UserDetailsService.expired");
			}
		}else{
			result=messages.getMessage("PasswordComparisonAuthenticator.badCredentials");
			
		}
		System.out.println(result);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(result);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		this.doGet(request, response);
	}
	public void init() throws ServletException {
		 ServletContext context = this.getServletContext();  
		 SystemService systemService=(SystemService)WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext()).getBean("systemServiceDest");
		 
	        
	}
	protected String obtainUsername(HttpServletRequest request) {
		String userName= request.getParameter(this.usernameParameter);
		if(userName!=null){
			return userName.trim().toLowerCase();
		}else{
			return null;
		}
	}
	
	protected String obtainPassword(HttpServletRequest request) {
		String password=request.getParameter(this.passwordParameter);
		if(password!=null){
			return password.trim();
		}else{
			return null;
		}
	}
}
