package system.components;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.access.method.MethodSecurityMetadataSource;
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
public class WlzxMethodInvocationSecurityMetadataSource
        implements MethodSecurityMetadataSource {
	private DataAccessModeDAO resourcesDao;  
	private RoleDAO roleDao;  
//    private PathMatcher urlMatcher = new AntPathMatcher();
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
                	if(resource.getBelongOperation().getRsType().equals("METHOD")){
	                	System.out.println("角色：["+role.getSymbol()+"]拥有的resource有："+resource.getBelongOperation().getRsValue());  
	                    resourceMap.put(resource.getBelongOperation().getRsValue(), atts); 
                    }
                }  
            }  
        }
    }

	@Override
	public Collection<ConfigAttribute> getAttributes(Method method, Class<?> arg1) {
		// TODO Auto-generated method stub
		System.out.println(method.toString()+"2");
		return null;
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		  System.out.println(object.toString());
		  return null;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return true;
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