package system.wlims.basic;

import java.util.List;

import system.BaseTest;
import system.ServiceException;
import system.wlims.basic.entity.teacher.TeacherModel;
import system.wlims.basic.service.teacher.TeacherService;

public class TeacherTest extends BaseTest {

	private TeacherService teacherService;
	
	public TeacherTest(){
		teacherService = (TeacherService)applicationContext.getBean("teacherServiceDest");
	}
	
	public void getAll() throws ServiceException{
		
		List<TeacherModel> list = teacherService.getTeacherModels(null, 1, 3);
		System.out.println(list == null);
		if(list != null){
			for(TeacherModel model:list){
				System.out.println(model.getBirthday());
			}
		}
	}
	
    public void update() throws ServiceException{
		
		teacherService.changeStatus("2", 2);
	}
	
	public static void main(String[] args) {
		TeacherTest test = new TeacherTest();
		try {
			test.getAll();
			test.update();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	public TeacherService getTeacherService() {
		return teacherService;
	}

}
