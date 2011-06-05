package system;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public abstract class BaseTest{
	
	protected static ApplicationContext applicationContext = 
		new ClassPathXmlApplicationContext(
				new String[]{"system/spring-system-basic.xml", "system/wlims/basic/teacher.xml"});
	
}