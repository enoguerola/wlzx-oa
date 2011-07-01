package system.components;


import org.apache.log4j.Logger;

import system.dao.UserDAO;
import system.entity.UserModel;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class WlzxUserDetailsService implements UserDetailsService{
	public static final String superUserName = "super_root";
	public static final String superUserPwd = "134bca5421a15476a1e5ebaebdba1ede";
	public static final String superUserRole = "ROLE_SUPER_ROOT";
	private final static Logger logger = Logger.getLogger(WlzxUserDetailsService.class);
	
	private UserDAO userDao;

	
	public UserDetails loadUserByUsername(String userAccount)
			throws UsernameNotFoundException, DataAccessException {
	            UserModel userModel = userDao.getUserByUserAccount(userAccount);  
	           
	            if (userModel ==null){  
	                String message = "用户"+userAccount+"不存在";  
	                logger.error(message);  
	                throw new UsernameNotFoundException(message);  
	            }  
	            else if(SecurityUserHolder.isSuperRootUser(userAccount)){
	            	 System.out.println(userModel.getName());
	            	 userModel.setMainRole(SecurityUserHolder.getSuperRootRoleModel());
	            	
	            }
	           // userModel.getAuthorities();
	           return userModel;
	}
//	
//	    //取得用户的权限  
//	    @SuppressWarnings("unused")
//		private Set<GrantedAuthority> obtionGrantedAuthorities(UserModel user) {  
//	        Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();  
//	        List<DataAccessModeModel> resources = new ArrayList<DataAccessModeModel>();  
//	        Set<RoleModel> roles = user.getRoles();  
//	          
//	        for(RoleModel role : roles) {  
//	            Set<DataAccessModeModel> tempRes = role.getDataAccessModes();  
//	            for(DataAccessModeModel res : tempRes) {  
//	                resources.add(res);  
//	            }  
//	        }  
//	        for(DataAccessModeModel res : resources) {  
//	            authSet.add(new SimpleGrantedAuthority(res.getSymbol()));  
//	        }  
//	        return authSet;  
//	    }  
	
	public static Logger getLogger() {
		return logger;
	}

	public UserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}





}
