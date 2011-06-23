package system.wlims.basic;

import java.sql.Date;
import java.util.List;
import java.util.Random;

import system.BaseTest;
import system.ServiceException;
import system.utils.UtilDateTime;
import system.wlims.basic.entity.teacher.TeacherModel;
import system.wlims.basic.entity.teacher.TeacherRelation;
import system.wlims.basic.service.teacher.TeacherRelationService;
import system.wlims.basic.service.teacher.TeacherService;

public class TeacherTest extends BaseTest {

	private TeacherService teacherService;
	private TeacherRelationService teacherRelationService;
	
	public TeacherTest(){
		teacherService = (TeacherService)applicationContext.getBean("teacherService");
		teacherRelationService = (TeacherRelationService)applicationContext.getBean("teacherRelationService");
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
    
    public void delete()throws ServiceException{
    	//save teacher and relation
    	TeacherModel model = new TeacherModel();
    	model.setAddress("1");
    	model.setBirthday(Date.valueOf("1977-08-11"));
    	model.setCreationDate(Date.valueOf(UtilDateTime.nowDateString()));
    	model.setName("余峰");
    	model.setPoliticsStatus(0);
    	model.setSex(0);
    	model.setStyle(0);
    	Random random = new Random();
    	model.setTeacherID(random.nextInt() + "");
    	model.setTeacherMarried(0);
    	model.setTeacherNo(random.nextInt() + "");
    	model.setTeacherPosition("15");
    	model.setTeacherStatus(1);
    	model.setTeacherDepartment("德育处");
    	model.setNation("汉");
    	model.setTeacherNativePlace("   ");
    	model.setHomePhone("11111");
    	model.setTeacherMobilePhone("222222");
    	model.setTeacherEducation("education");
    	model.setTeacherProfession("profession");
    	model.setTeacherGraduateSchool("MY SCHool");
    	teacherService.save(model);
    	
    	TeacherRelation relation = new TeacherRelation();
    	relation.setCompany("121");
    	relation.setName("ooo");
    	relation.setPhone("323");
    	relation.setRelation("------");
    	relation.setTeacher(model);
    	teacherRelationService.save(relation, model.getId());
    	System.out.println("save ok");
    	
    	//update
    	model.setAddress("address");
    	teacherService.save(model);
    	System.out.println("update ok");
    	
    	//delete
    	teacherService.remove(model.getId());
    	System.out.println("delete ok");
    }
    
    public void remove(){
    	try {
			teacherService.remove("4");
			System.out.println("remove ok");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	public static void main(String[] args) {
		TeacherTest test = new TeacherTest();
		try {
			test.getAll();
			test.update();
			test.remove();
			//test.delete();
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

	public void setTeacherRelationService(TeacherRelationService teacherRelationService) {
		this.teacherRelationService = teacherRelationService;
	}

	public TeacherRelationService getTeacherRelationService() {
		return teacherRelationService;
	}

}
