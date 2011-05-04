package system.components;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.util.PathMatcher;
import org.springframework.util.AntPathMatcher;

import system.dao.DataAccessModeDAO;
import system.dao.RoleDAO;
import system.entity.DataAccessModeModel;
import system.entity.RoleModel;

/**
 * 
 * 此类在初始化时，应该取到所有资源及其对应角色的定义
 * 
 * @author Robin
 * 
 */
public class WlzxInvocationSecurityMetadataSource
        implements FilterInvocationSecurityMetadataSource {
	private DataAccessModeDAO resourcesDao;  
	private RoleDAO roleDao;  
    private PathMatcher urlMatcher = new AntPathMatcher();;
    private static Map<String, Collection<ConfigAttribute>> resourceMap = null;

  //加载所有资源与权限的关系
    @SuppressWarnings("unused")
	private void loadResourceDefine() {
    	if(resourceMap == null) {  
	        resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
	        List<DataAccessModeModel> resources = this.resourcesDao.getAllResources(); 
	         for (DataAccessModeModel resource : resources) { 
	        	if(resource.getBelongOperation().getRsType().equals("URL")){
	               Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
	               for(RoleModel role:roleDao.getAllRoles()){
	            	   if(role.getDataAccessModes().contains(resource)){   
	            		 //以角色符号封装为Spring的security Object  
	    	               ConfigAttribute configAttribute = new SecurityConfig(role.getSymbol());  
	    	               configAttributes.add(configAttribute);  
	            	   }
	               }
	               
	               resourceMap.put(resource.getBelongOperation().getRsValue(), configAttributes);  
               }
	        }  
        }
    }

    //返回所请求资源所需要的权限  
    public Collection<ConfigAttribute> getAttributes(Object object)
            throws IllegalArgumentException {
        // guess object is a URL.
        String url = ((FilterInvocation)object).getRequestUrl();
        Iterator<String> ite = resourceMap.keySet().iterator();
        while (ite.hasNext()) {
            String resURL = ite.next();
            if (urlMatcher.match(url, resURL)) {
                return resourceMap.get(resURL);
            }
        }
        return null;
    }

    public boolean supports(Class<?> clazz) {
        return true;
    }
    
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

	public DataAccessModeDAO getResourcesDao() {
		return resourcesDao;
	}

	public void setResourcesDao(DataAccessModeDAO resourcesDao) {
		this.resourcesDao = resourcesDao;
	}

	public RoleDAO getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(RoleDAO roleDao) {
		this.roleDao = roleDao;
	}

}