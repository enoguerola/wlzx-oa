package system.components;

import java.util.List;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

public class MyLogoutHandler extends SecurityContextLogoutHandler {
	@SuppressWarnings("static-access")
	private static CacheManager cacheManager=CacheManager.getInstance().create("classpath:ehcache.xml");
	private static Cache cache=cacheManager.getCache("methodCache");
	public MyLogoutHandler() {
		super();
		if(cache==null){
   		  cache=new Cache("methodCache",50,true,false,60*30,60*15);
   		  cacheManager.addCache(cache);
   	  	}
	}
	@SuppressWarnings("rawtypes")
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication){
		
		super.logout(request, response, authentication);
		super.setInvalidateHttpSession(true);
		 HttpSession session = request.getSession();  
         if (null != session) {  
        	 session.invalidate();
         }  
		String targetCacheKeyPrefix ="system.serviceImpl.SystemServiceImpl";
		System.out.println("logout");
		List cachedKeys = cache.getKeys();
		if (!CollectionUtils.isEmpty(cachedKeys)) {
			for (Object cachedKey : cachedKeys) {
				String key = String.valueOf(cachedKey);
				if (key.startsWith(targetCacheKeyPrefix)){
					cache.remove(key);
				}
			}
		}
	}
	
	
}
