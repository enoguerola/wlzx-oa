package system.components;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.security.core.Authentication;

import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


public class MyAccessAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	public static final String AUTHEN_SUCCESS = "success";

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication) throws IOException,
			ServletException {
		// TODO Auto-generated method stub
		response.getWriter().write(MyAccessAuthenticationSuccessHandler.AUTHEN_SUCCESS);
		response.flushBuffer();
		response.getWriter().close();
	}

}