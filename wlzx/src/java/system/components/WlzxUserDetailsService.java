package system.components;


import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.log4j.Logger;

import system.dao.DRDAO;
import system.dao.DataAccessModeDAO;
import system.dao.RoleDAO;
import system.dao.UserDAO;
import system.entity.DRModel;
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
	private DRDAO drDAO;
	private DataAccessModeDAO resourcesDao;  
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
	            	
//	            	 userModel.setMainDR(mainDR)(SecurityUserHolder.getSuperRootRoleModel());
	            	
	            	userModel.setAuthorizations(new TreeSet<DataAccessModeModel>(resourcesDao.getAllResources()));
	            	
	            	userModel.setHasTeachingRole(true);
	            	userModel.setHasTeachingRoleInMain(true);
	            	
	            }else{
	            	 Set<DataAccessModeModel> dams=new TreeSet<DataAccessModeModel>();
	 	    		//添加基础权限
	 	    		DRModel basic=drDAO.getBasicDR();
	 	    		for(DataAccessModeModel dam:basic.getDataAccessModes()){
	 	    			if(!dams.contains(dam))
	 	    			dams.add(dam);
	 	    		}
	     			for(DRModel dr:userModel.getAllDRs()){
	     				for(DataAccessModeModel dam:dr.getDataAccessModes()){
	     					if(!dams.contains(dam))
	     					dams.add(dam);
	     				}
	     			}
	     			userModel.setAuthorizations(dams);
	     			
	     			Boolean hasTeachingRoleInMain=false;
	     			Boolean hasTeachingRole=false;
					List<RoleModel> teachingRoles=roleDAO.getTeachingRoles();
					if(teachingRoles!=null&&teachingRoles.size()>0){
						for(RoleModel teachingRole:teachingRoles){
							if(userModel.hasRoleInMain(teachingRole.getId())){
								hasTeachingRoleInMain=true;
								break;
							}
						}
						for(RoleModel teachingRole:teachingRoles){
							if(userModel.hasRole(teachingRole.getId())){
								hasTeachingRole=true;
								break;
							}
						}
					}
					userModel.setHasTeachingRole(hasTeachingRole);
	            	userModel.setHasTeachingRoleInMain(hasTeachingRoleInMain);
	            }
	           
	           return userModel;
	}
//	
//	    //取得用户的权限  
//	    @SuppressWarnings("unused")
//		private Set<GrantedAuthority> obtionGrantedAuthorities(UserModel user) {  
//	        Set<GrantedAuthority> authSet = new TreeSet<GrantedAuthority>();  
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

	public DRDAO getDrDAO() {
		return drDAO;
	}

	public void setDrDAO(DRDAO drDAO) {
		this.drDAO = drDAO;
	}

	public DataAccessModeDAO getResourcesDao() {
		return resourcesDao;
	}

	public void setResourcesDao(DataAccessModeDAO resourcesDao) {
		this.resourcesDao = resourcesDao;
	}






}
