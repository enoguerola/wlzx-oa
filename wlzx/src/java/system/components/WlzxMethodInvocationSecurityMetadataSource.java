package system.components;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.aop.framework.ReflectiveMethodInvocation;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.access.method.MethodSecurityMetadataSource;


import system.dao.DRDAO;
import system.dao.DataAccessModeDAO;
import system.entity.DRModel;
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
	private DRDAO drDAO; 

//	private RoleDAO roleDao;  
//    private PathMatcher urlMatcher = new AntPathMatcher();
    private static Map<String, Collection<ConfigAttribute>> resourceMap = null;

	//加载所有资源与权限的关系
    public void loadResourceDefine() {
//    	if(resourceMap == null) {  
    		 resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
    		 resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
    		 //配置超级用户资源
    		 RoleModel superRole=SecurityUserHolder.getSuperRootRoleModel(); 		
	           for(DataAccessModeModel super_resource:resourcesDao.getAllResources()){
	        	   
	           		if(super_resource.getBelongOperation().getRsType().equals("METHOD")){
	           			String key=super_resource.getBelongOperation().getRsValue();
	           		 // System.out.println("角色：["+superRole.getSymbol()+"]拥有的Method资源有："+key); 
		                if(!resourceMap.containsKey(key)){
		                	Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
		                	ConfigAttribute super_ca = new SecurityConfig(superRole.getSymbol());  
			        	   	atts.add(super_ca);  
		                	resourceMap.put(key, atts); 
		                }
		                 
	               }
	           } 
	           //加载用户资源
	           for (DRModel dr:drDAO.getAllDRs(false)){
	                for(DataAccessModeModel resource:dr.getDataAccessModes()){ 
	                	if(resource.getBelongOperation().getRsType().equals("METHOD")){
	                		 String key=resource.getBelongOperation().getRsValue();
	                		 //	System.out.println("角色：["+role.getSymbol()+"]拥有的Method资源有："+key); 
		                	ConfigAttribute ca = new SecurityConfig(dr.getBasicFlag()==null||dr.getBasicFlag()==false?dr.getId():"basic_dr");  
		                	resourceMap.get(key).add(ca);
	                    }
	                }  
	            }  
//        }
    }

	@Override
	public Collection<ConfigAttribute> getAttributes(Method method, Class<?> targetClass) {
		// TODO Auto-generated method stub
		String class_method = targetClass.getName() + "." + method.getName();
		 //System.out.println("调用method:=" + class_method);
		 Iterator<String> ite = resourceMap.keySet().iterator();
	        while (ite.hasNext()) {
	            String resMethod = ite.next();
	            if (resMethod.equals(class_method)) {
	                return resourceMap.get(resMethod);
	            }
	        }
	        return null;
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Method method = ((ReflectiveMethodInvocation) object).getMethod();
		Class targetClass = method.getDeclaringClass();
		return getAttributes(method, targetClass);
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


	public DRDAO getDrDAO() {
		return drDAO;
	}

	public void setDrDAO(DRDAO drDAO) {
		this.drDAO = drDAO;
	}

}