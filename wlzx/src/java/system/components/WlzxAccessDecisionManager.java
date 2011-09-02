package system.components;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public class WlzxAccessDecisionManager implements AccessDecisionManager {

	public void decide(Authentication authentication, Object object,
			Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		   // System.out.println(configAttributes);  
	        if (configAttributes == null) {  
	            return;  
	        }  
	        //System.out.println("正在访问的资源是："+object.toString());  
	        Iterator<ConfigAttribute> ite = configAttributes.iterator();  
	        while (ite.hasNext()) {  
	            ConfigAttribute ca = ite.next();  
	            //  System.out.println("needRole is："+ca.getAttribute());  
	            String needRole = ((SecurityConfig) ca).getAttribute();  
	            for (GrantedAuthority ga : authentication.getAuthorities()) {  
	            	 //System.out.println("\t授权信息是："+ga.getAuthority());  
	                if (needRole.equals(ga.getAuthority())) { // ga is user's role.  
	                	 //System.out.println("判断到，needRole是"+needRole+",用户拥有该角色"+ga.getAuthority()+"，授权数据相匹配");  
	                    return;  
	                }  
	            }  
	        }  
	        throw new AccessDeniedException("没有权限");  
	}

	@Override
	public boolean supports(ConfigAttribute attribute) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

}
