package system.components;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.security.core.AuthenticationException;

import org.springframework.security.web.authentication.AuthenticationFailureHandler;


public class MyAccessAuthenticationFailureHandler implements AuthenticationFailureHandler {


	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException exception) throws IOException, ServletException {
		response.getWriter().write(exception.getMessage());
		response.flushBuffer();
		response.getWriter().close();
    }

}