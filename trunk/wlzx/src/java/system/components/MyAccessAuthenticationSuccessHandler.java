package system.components;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import system.dao.UserDAO;
import system.entity.UserModel;


public class MyAccessAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	public static final String AUTHEN_SUCCESS = "success";
	private UserDAO userDAO;
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication) throws IOException,
			ServletException {
		// TODO Auto-generated method stub
		this.saveLoginLog(request);
		response.getWriter().write(MyAccessAuthenticationSuccessHandler.AUTHEN_SUCCESS);
		response.flushBuffer();
		response.getWriter().close();
	}
	private void saveLoginLog(HttpServletRequest request){

		try{
			if( SecurityContextHolder.getContext().getAuthentication()!=null){
				UserModel user= (UserModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				user= userDAO.getUserByUserAccount(user.getUsername());
                
				if(user!=null){
					 user.setLastLoginTime(new Date()); 
	                 user.setLastLoginIP(request.getRemoteHost());
	                 userDAO.merge(user);
                 }
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	public UserDAO getUserDAO() {
		return userDAO;
	}
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
}