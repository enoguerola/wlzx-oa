package system;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public abstract class BaseTest{
	
	protected static ApplicationContext applicationContext = 
		new ClassPathXmlApplicationContext(
				new String[]{"system/spring-system-basic.xml", "system/wlims/basic/teacher.xml", 
						     "system/system.xml", "system/spring-system.xml","system/spring-system-oa.xml","system/wlims/oa/all.xml"});
	
}