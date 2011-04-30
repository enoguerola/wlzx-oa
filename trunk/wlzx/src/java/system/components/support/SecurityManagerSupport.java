package system.components.support;

import java.util.Map;


import org.apache.log4j.Logger;
import system.components.SecurityManager;
import system.service.SystemService;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class SecurityManagerSupport implements UserDetailsService,SecurityManager{
	
	private final static Logger logger = Logger.getLogger(SecurityManagerSupport.class);
	
	private SystemService systemService;

	
	public UserDetails loadUserByUsername(String userAccount)
			throws UsernameNotFoundException, DataAccessException {
		String userName = userAccount.toUpperCase();
		return SecurityUserHolder.isSuperRootUser(userName) ? 
				SecurityUserHolder.getSuperRootUserModel() : systemService.getUserByUserAccount(userName);
	}
	
	public Map<String, String> loadUrlAuthorities() {
//		try {
//			return resourceService.getResourceAuthorities();
//		} catch (ServiceException e) {
//			logger.error("SecurityManagerSupport loadUrlAuthorities: " + e.getMessage());
//		}
		return null;
	}
	
	public static Logger getLogger() {
		return logger;
	}

	public SystemService getSystemService() {
		return systemService;
	}

	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}



}
