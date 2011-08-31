package system.components;


import java.util.Set;
import java.util.TreeSet;

import org.apache.log4j.Logger;

import system.dao.RoleDAO;
import system.dao.UserDAO;
import system.entity.DataAccessModeModel;
import system.entity.RoleModel;
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
	
	private UserDAO userDAO;
	private RoleDAO roleDAO;

	
	public RoleDAO getRoleDAO() {
		return roleDAO;
	}

	public void setRoleDAO(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}

	public UserDetails loadUserByUsername(String userAccount)
			throws UsernameNotFoundException, DataAccessException {
	            UserModel userModel = userDAO.getUserByUserAccount(userAccount);  
	           
	            if (userModel ==null){  
	            	throw new UsernameNotFoundException(userAccount);
	            }  
	            else if(userAccount.equals(WlzxUserDetailsService.superUserName)){
	            	// System.out.println(userModel.getName());
	            	 userModel.setMainRole(SecurityUserHolder.getSuperRootRoleModel());
	            	
	            }
	            Set<DataAccessModeModel> dams=new TreeSet<DataAccessModeModel>();
	    		//添加基础权限
	    		RoleModel basic=roleDAO.getRoleBySymbol("basic_role");
	    		for(DataAccessModeModel dam:basic.getDataAccessModes()){
	    			if(!dams.contains(dam))
	    			dams.add(dam);
	    		}
    			for(RoleModel role:userAccount.equals(WlzxUserDetailsService.superUserName)?roleDAO.getAllRoles(true):userModel.getAllRoles()){
    				for(DataAccessModeModel dam:role.getDataAccessModes()){
    					if(!dams.contains(dam))
    					dams.add(dam);
    				}
    			}
    			userModel.setAuthorizations(dams);
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

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}






}
