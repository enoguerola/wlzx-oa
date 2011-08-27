package system.components;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import system.dao.UserDAO;
import system.entity.UserModel;


public class MyUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	public static final String VALIDATE_CODE = "validateCode";
	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";
	
	private UserDAO userDAO;
    private static final Logger log = Logger.getLogger(MyUsernamePasswordAuthenticationFilter.class);
    protected MessageSourceAccessor messages = SpringSecurityMessageSource.getAccessor();
   
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
		
		if (!request.getMethod().equals("POST")) {
			throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
		}
		response.setCharacterEncoding("UTF-8");

		String username = obtainUsername(request);
		String password = obtainPassword(request);
		
		//验证用户账号与密码是否对应
		username = username.trim();
		
		UserModel user=null;
		user = userDAO.getUserByUserAccount(username);
		
		if(user == null ) {
			throw new AuthenticationServiceException(messages.getMessage("component.authorization.noCurrentAccount")); 
			
		}else if(!user.getPassword().equals(password)){
			throw new AuthenticationServiceException(messages.getMessage("component.authorization.badCredentials")); 
		}else if(user.getActive()==false){
			throw new AuthenticationServiceException(messages.getMessage("component.authorization.accountDisactived")); 
		}
		
		
		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
		
		// 允许子类设置详细属性
        setDetails(request, authRequest);
		
        // 运行UserDetailsService的loadUserByUsername 再次封装Authentication
		return this.getAuthenticationManager().authenticate(authRequest);
	}
	
//	protected void checkValidateCode(HttpServletRequest request) { 
//		HttpSession session = request.getSession();
//		
//	    String sessionValidateCode = obtainSessionValidateCode(session); 
//	    //让上一次的验证码失效
//	    session.setAttribute(VALIDATE_CODE, null);
//	    String validateCodeParameter = obtainValidateCodeParameter(request);  
//	    if (StringUtils.isEmpty(validateCodeParameter) || !sessionValidateCode.equalsIgnoreCase(validateCodeParameter)) {  
//	        throw new AuthenticationServiceException("验证码错误！");  
//	    }  
//	}
	
//	private String obtainValidateCodeParameter(HttpServletRequest request) {
//		Object obj = request.getParameter(VALIDATE_CODE);
//		return null == obj ? "" : obj.toString();
//	}

	protected String obtainSessionValidateCode(HttpSession session) {
		Object obj = session.getAttribute(VALIDATE_CODE);
		return null == obj ? "" : obj.toString();
	}

	@Override
	protected String obtainUsername(HttpServletRequest request) {
		Object obj = request.getParameter(USERNAME);
		return null == obj ? "" : obj.toString();
	}

	@Override
	protected String obtainPassword(HttpServletRequest request) {
		Object obj = request.getParameter(PASSWORD);
		return null == obj ? "" : obj.toString();
	}


	public static Logger getLog() {
		return log;
	}
	
	public void setMessageSource(MessageSource messageSource) {
		this.messages = new MessageSourceAccessor(messageSource);
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
}
