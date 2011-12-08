package system.components;

import java.lang.reflect.Method;
import java.util.Date;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.reflect.MethodSignature;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.ObjectUtils;
import org.springframework.util.CollectionUtils;

import system.Action;
import system.dao.LogDAO;
import system.entity.LogModel;
import system.entity.UserModel;

import java.util.List;
  
public class GenericLoggerCacheBean {  
	  private LogDAO logDAO;  
	  private static final Logger log = Logger.getLogger(GenericLoggerCacheBean.class);
	  @SuppressWarnings("static-access")
	  private static CacheManager cacheManager=CacheManager.getInstance().create("classpath:ehcache.xml");
	  private static Cache cache=cacheManager.getCache("methodCache");
      public GenericLoggerCacheBean(){
    	  if(cache==null){
    		  cache=new Cache("methodCache",50,true,false,60*30,60*15);
    		  cacheManager.addCache(cache);
    	  }
      }
	    @SuppressWarnings({  "rawtypes" })
		public Object  runAround(ProceedingJoinPoint point) throws Throwable{  
 	    	 MethodSignature joinPointObject = (MethodSignature) point.getSignature();  
             Method method = joinPointObject.getMethod();    
	    	 String methodName = point.getSignature().getName();  
             Class targetClass = point.getTarget().getClass();  
             Object args[] = point.getArgs();
             
	        if(methodName.startsWith("get")){
		    	String cacheKey = getCacheKey(point);
		    	Element cached = cache.get(cacheKey);
		    	if (cached == null) {  //not hit
		 			  Object retVal = point.proceed();
		 	          
		 			cached = new Element(cacheKey, retVal);
		 			cache.put(cached);
		 			return retVal;
		 		} else {
		 			return cache.get(cacheKey).getObjectValue();
		 		}
	        }else{
	        	Object retVal = point.proceed();
	        	// set方法除外的方法记录日志
	             if (!(methodName.startsWith("set") )) {  
	                
	                     boolean hasAnnotation = method.isAnnotationPresent(Action.class);  
	                     if (hasAnnotation) {  
	                         Action annotation = method.getAnnotation(Action.class);  
	                         String type = annotation.type();  
	                         String name = annotation.name();  
	                         String descp = annotation.description();  
	                         //取到当前的操作用户  
	                         UserModel user=null;
	                         if( SecurityContextHolder.getContext().getAuthentication()!=null){
	                        	 user= (UserModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		        			 }
	                         if(user!=null){  
	                             try{  
	                            	
	                            	 if(args!=null&&args.length>0)
	            	                 for(Object arg :args){
	            	                	 descp+=arg;
	            	                 }
	                                   LogModel sysLog=new LogModel();  
	                                   sysLog.setType(type);
	                                   sysLog.setName(name);
	                                   sysLog.setDetail(descp);
	                                   sysLog.setMethod(targetClass+":"+ method.getName());
	                                   sysLog.setOperationTime(new Date());
	                                   sysLog.setUser(user.getId());
	                                   logDAO.addLog(sysLog);  
	                             }catch(Exception ex){  
	                            	 log.error(ex.getMessage());  
	                             }  
	                         }  
	                           
	                     }  
	                
	   
	             } 
	            // 清空缓存
	             afterReturning(retVal,method,args,targetClass);
	             return retVal;
	        	
	        }
	 		
	 		
	    	

	    } 
	    
	    
	    @SuppressWarnings("rawtypes")
		public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
			String targetCacheKeyPrefix = target.toString().split(" ")[1] + ".";
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
	    
	    
	
	    protected String getCacheKey(ProceedingJoinPoint point) {
    	    MethodSignature joinPointObject = (MethodSignature) point.getSignature();
    	    Method method = joinPointObject.getMethod();    
            @SuppressWarnings("rawtypes")
			Class targetClass = point.getTarget().getClass();  
			String targetClassName = targetClass.getName();
			String methodName = method.getName();
			Object[] arguments = point.getArgs();
			System.out.println("aaaaaaaaaaa");
			StringBuffer cacheKey = new StringBuffer();
			cacheKey.append(targetClassName).append(".").append(methodName).append("(");
			if (!ObjectUtils.isEmpty(arguments)) {
				for (Object argument : arguments) {
					cacheKey.append(argument).append(",");
				}
				cacheKey.deleteCharAt(cacheKey.length() - 1);
			}
			cacheKey.append(")");
			return cacheKey.toString();
		}
	    //方法运行出现异常时调用  
	    @AfterThrowing(throwing = "ex")  
	    public void afterThrowing(Exception ex){  
	        System.out.println("afterThrowing"+ex);  
	    }
	    
		public static Logger getLog() {
			return log;
		}
		public LogDAO getLogDAO() {
			return logDAO;
		}
		public void setLogDAO(LogDAO logDAO) {
			this.logDAO = logDAO;
		}
		
}  
