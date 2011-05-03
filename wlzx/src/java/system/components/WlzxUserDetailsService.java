package system.components;



import org.apache.log4j.Logger;
import system.service.SystemService;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class WlzxUserDetailsService implements UserDetailsService{
	public static final String superUserName = "super_root";
	public static final String superUserPwd = "134bca5421a15476a1e5ebaebdba1ede";
	public static final String superUserRole = "ROLE_SUPER_ROOT";
	private final static Logger logger = Logger.getLogger(WlzxUserDetailsService.class);
	
	private SystemService systemService;

	
	public UserDetails loadUserByUsername(String userAccount)
			throws UsernameNotFoundException, DataAccessException {
		String userName = userAccount.toUpperCase();
		return SecurityUserHolder.isSuperRootUser(userName) ? 
				SecurityUserHolder.getSuperRootUserModel() : systemService.getUserByUserAccount(userName);
	}
	
//	public Map<String, String> loadUrlAuthorities() {
////		try {
////			return resourceService.getResourceAuthorities();
////		} catch (ServiceException e) {
////			logger.error("SecurityManagerSupport loadUrlAuthorities: " + e.getMessage());
////		}
//		return null;
//	}
	
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
