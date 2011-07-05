package system.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.core.SpringSecurityMessageSource;

import system.components.SecurityUserHolder;
import system.entity.UserModel;



public class LoginFailServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1603004932284674865L;

	protected MessageSourceAccessor messages = SpringSecurityMessageSource.getAccessor();

	public LoginFailServlet() {
		super();
	}
	@Override
	public void destroy() {
		super.destroy(); 
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		response.setHeader("Cache-Control","no-cache");    
		response.setHeader("Pragma","no-cache");    
		response.setDateHeader ("Expires", -1);    

		UserModel user=SecurityUserHolder.getCurrentUser();
		String result="";
		if(user!=null){
//			if(user.getActive()){
//				result="success";
//			}else{
////				result=messages.getMessage("UserDetailsService.credentialsExpired");
//				result="用户帐号已经锁定,请联系管理员";
//			}
		}else{
//			result=messages.getMessage("PasswordComparisonAuthenticator.badCredentials");
			result="用户名密码错误";
		}
//		if(result.equals("success")){
//			 ServletContext context = this.getServletContext();  
//			 UserDAO userDAO=(UserDAO)WebApplicationContextUtils.getRequiredWebApplicationContext(context).getBean("userDAO");
//			
//			 UserModel preUser=userDAO.get(user.getId());
//			 preUser.setLastLoginTime(new Date());
//			 preUser.setLastLoginIP(request.getRemoteHost());
//			 userDAO.saveOrUpdate(preUser);
//		}
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(result);
		response.flushBuffer();
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
