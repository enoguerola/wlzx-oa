package system.components;

import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.access.intercept.aopalliance.MethodSecurityInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class WlzxMethodSecurityIntercept extends MethodSecurityInterceptor {
	@Override
	public Object invoke(MethodInvocation mi){
		  InterceptorStatusToken token = super.beforeInvocation(mi);
		System.out.println("aaaaaaaaaaaaa");
		return null;
	}
}
