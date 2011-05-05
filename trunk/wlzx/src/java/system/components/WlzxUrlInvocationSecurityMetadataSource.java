package system.components;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.web.FilterInvocation;
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
public class WlzxUrlInvocationSecurityMetadataSource
        implements SecurityMetadataSource{
	private DataAccessModeDAO resourcesDao;  
	private RoleDAO roleDao;  
    private PathMatcher urlMatcher = new AntPathMatcher();
    private static Map<String, Collection<ConfigAttribute>> resourceMap = null;

  //加载所有资源与权限的关系
    @SuppressWarnings("unused")
	private void loadResourceDefine() {
    	if(resourceMap == null) {  
    		 resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
            for (RoleModel role:roleDao.getAllRoles()){  
                Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();  
                ConfigAttribute ca = new SecurityConfig(role.getSymbol());  
                atts.add(ca);  
                Set<DataAccessModeModel> resources = role.getDataAccessModes();  
                //把资源放入到spring security的resouceMap中  
                for(DataAccessModeModel resource:resources){ 
                	if(resource.getBelongOperation().getRsType().equals("URL")){
	                	System.out.println("角色：["+role.getSymbol()+"]拥有的URL资源有："+resource.getBelongOperation().getRsValue());  
	                    resourceMap.put(resource.getBelongOperation().getRsValue(), atts); 
                    }
                }  
            }  
        }
    }

    //返回所请求资源所需要的权限  
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object)
            throws IllegalArgumentException {
        String url = ((FilterInvocation)object).getRequestUrl();
        System.out.println("访问URL:=" + url);
        Iterator<String> ite = resourceMap.keySet().iterator();
        while (ite.hasNext()) {
            String resURL = ite.next();
            if (urlMatcher.match(resURL,url )) {
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
	public static void main(String[] args){
		String url1="/basic/authorization/departmentAuthorization.swf?uid=1304486667468";
		String url2="/basic/authorization/departmentAuthorization.swf*";
		PathMatcher urlMatcher = new AntPathMatcher();
		System.out.println(urlMatcher.match(url2,url1));
		 
	}

}