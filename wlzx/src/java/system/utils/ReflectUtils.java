package system.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import system.wlims.basic.entity.teacher.TeacherModel;


public class ReflectUtils {
	
	public static HashMap<String, Object> getAllComponentsName(String preKey, Object f) {
		HashMap<String, Object> data = new HashMap<String, Object>();
		if (f != null) {
			Field[] fields = f.getClass().getDeclaredFields();
			List<Field> list = new ArrayList<Field>();
			for(Field field:fields)
				list.add(field);
			
			Class parent = f.getClass().getSuperclass();  
			// 如果有父类并且父类不是Object 
			if (parent != null && !((Class) parent).getName().equals("Object")) {  
				Field[] pfields = parent.getDeclaredFields();
				
				for(Field field:pfields)
					list.add(field);
			}  
			 

			for(int i = 0 , len = list.size(); i < len; i++) {
				String varName = list.get(i).getName();
				try {
					boolean accessFlag = list.get(i).isAccessible();
					list.get(i).setAccessible(true);
					Method method = f.getClass().getMethod(
							"get" + varName.substring(0,1).toUpperCase() + varName.substring(1), new Class[]{});
					if (method != null) {
						data.put(preKey + varName, method.invoke(f, new Object[]{}));
						list.get(i).setAccessible(accessFlag);
					}
				} catch (IllegalArgumentException ex) {
					ex.printStackTrace();
				} catch (IllegalAccessException ex) {
					ex.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		return data;
	}
	
	/**  
	    * java反射bean的get方法  
	    *   
	    * @param objectClass  
	    * @param fieldName  
	    * @return  
	    */  
	   @SuppressWarnings("unchecked")   
	   public static Method getGetMethod(Class objectClass, String fieldName) {   
	       StringBuffer sb = new StringBuffer();   
	       sb.append("get");   
	       sb.append(fieldName.substring(0, 1).toUpperCase());   
	       sb.append(fieldName.substring(1));   
	       try {   
	           return objectClass.getMethod(sb.toString());   
	       } catch (Exception e) {  
	    	   e.printStackTrace(); 
	       }   
	       return null;   
	   }  

	   /**  
	     * java反射bean的set方法  
	     *   
	     * @param objectClass  
	     * @param fieldName  
	     * @return  
	     */  
	    @SuppressWarnings("unchecked")   
	    public static Method getSetMethod(Class objectClass, String fieldName) {   
	        try {   
	            Class[] parameterTypes = new Class[1];   
	            Field field = objectClass.getDeclaredField(fieldName);   
	            parameterTypes[0] = field.getType();   
	            StringBuffer sb = new StringBuffer();   
	            sb.append("set");   
	            sb.append(fieldName.substring(0, 1).toUpperCase());   
	            sb.append(fieldName.substring(1));   
	            Method method = objectClass.getMethod(sb.toString(), parameterTypes);   
	            return method;   
	        } catch (Exception e) {   
	            e.printStackTrace();   
	        }   
	        return null;   
	    }  

	    
	    /**  
	     * 执行set方法  
	     *   
	     * @param o 执行对象  
	     * @param fieldName 属性  
	     * @param value 值  
	     */  
	    public static void invokeSet(Object o, String fieldName, Object value) {   
	        Method method = getSetMethod(o.getClass(), fieldName);   
	        try {   
	        	if (method != null) {
		            method.invoke(o, new Object[] { value });   
				}
	        } catch (Exception e) {   
	            e.printStackTrace();   
	        }   
	    }   
	  
	    /**  
	     * 执行get方法  
	     *   
	     * @param o 执行对象  
	     * @param fieldName 属性  
	     */  
	    public static Object invokeGet(Object o, String fieldName) {   
	        Method method = getGetMethod(o.getClass(), fieldName);   
	        try {   
	            return method.invoke(o, new Object[0]);   
	        } catch (Exception e) {   
	            e.printStackTrace();   
	        }   
	        return null;   
	    }  

	
	public static HashMap<String, Object> getAllComponentsName(Object f) {
		return getAllComponentsName("", f);
	}
	
	public static void main(String[] args)
	{
		TeacherModel base = new TeacherModel();
		base.setAddress("龙游");
		System.out.println(base.toString());
		// 测试代码用来获取一个JLabel中声名的所有的属性名和其属性变量
		getAllComponentsName(base);
	}

}
