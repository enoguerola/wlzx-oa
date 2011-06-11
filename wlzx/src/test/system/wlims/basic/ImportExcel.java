package system.wlims.basic;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jxl.DateCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import system.ServiceException;
import system.entity.PersonModel.PersonStyle;
import system.utils.UtilDateTime;
import system.wlims.basic.entity.teacher.TeacherModel;
import system.wlims.basic.service.teacher.TeacherService;

public class ImportExcel {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext applicationContext =  new ClassPathXmlApplicationContext(
					new String[]{"system/*.xml", "system/wlims/basic/*.xml"});
		TeacherService teacherService = (TeacherService)applicationContext.getBean("teacherService");
		// TODO Auto-generated method stub
		
		Workbook workbook;
		try {
			workbook = Workbook.getWorkbook(new File("E:\\project\\wlzx\\t.xls"));
			Sheet sheet = workbook.getSheet(0);
			int rowCount = sheet.getRows();
			for (int i = 1; i <rowCount; i++) {
				 TeacherModel model = new TeacherModel();
				 
				 String group = sheet.getCell(0, i).getContents();
				 String name = sheet.getCell(1, i).getContents();
				 String shortNo = sheet.getCell(2, i).getContents();
				 String mobilePhone = sheet.getCell(3, i).getContents();
				 String officePhone = sheet.getCell(4, i).getContents();
				 String mail = sheet.getCell(5, i).getContents();
				 String address = sheet.getCell(6, i).getContents();
				 String homePhone = sheet.getCell(7, i).getContents();
				 String contactPhone = sheet.getCell(8, i).getContents();
				 //sex str to int
				 Integer sex = sheet.getCell(9, i).getContents() == "男" ? 0 : 1;
				 Date birthday = ((DateCell)sheet.getCell(10, i)).getDate();
				 
				 String nation = sheet.getCell(11, i).getContents();
				 //marriage str to int
				 Integer marriage = sheet.getCell(12, i).getContents() == "未婚" ? 0 : 1;
				 //politic str to int
				 Integer politic = sheet.getCell(13, i).getContents() == "党员" ? 0 : (sheet.getCell(13, i).getContents() == "团员" ? 1 :2);
				 String nativePlace = sheet.getCell(14, i).getContents();
				 String id = sheet.getCell(15, i).getContents();
				 
				 String education = sheet.getCell(16, i).getContents();
				 String major = sheet.getCell(17, i).getContents();
				 String school = sheet.getCell(18, i).getContents();
				 String position = sheet.getCell(19, i).getContents();
				 String profession = sheet.getCell(20, i).getContents();
				 Date workDate = ((DateCell)sheet.getCell(21, i)).getDate();
				 Date attendDate = ((DateCell)sheet.getCell(22, i)).getDate();
				 String skill = sheet.getCell(23, i).getContents();
				 Date skillDate = ((DateCell)sheet.getCell(24, i)).getDate();
				 
				 model.setAddress(address);
				 model.setBirthday(new java.sql.Date(birthday.getTime()));
				 model.setCreationDate(java.sql.Date.valueOf(UtilDateTime.nowDateString()));
				 model.setHomePhone(homePhone);
				 model.setModifiedDate(model.getCreationDate());
				 model.setName(name);
				 model.setNation(nation);
				 model.setPoliticsStatus(politic);
				 model.setSex(sex);
				 model.setStyle(PersonStyle.Teacher.getStyle());
				 model.setTeacherAttendDate(new java.sql.Date(attendDate.getTime()));
				 model.setTeacherContactPhone(contactPhone);
				 model.setTeacherEducation(education);
				 model.setTeacherGraduateSchool(school);
				 model.setTeacherID(id);
				 model.setTeacherMail(mail);
				 model.setTeacherMarried(marriage);
				 model.setTeacherMobilePhone(mobilePhone);
				 model.setTeacherNativePlace(nativePlace);
				 model.setTeacherNo(shortNo);
				 model.setTeacherOfficePhone(officePhone);
				 model.setTeacherPosition(position);
				 model.setTeacherProfessionTitle(profession);
				 model.setTeacherSkillLevel(skill);
				 model.setTeacherSkillLevelDate(new java.sql.Date(skillDate.getTime()));
				 model.setTeacherStatus(1);
				 model.setTeacherWorkDate(new java.sql.Date(workDate.getTime()));
				 model.setTeacherProfession(major);
				 
				 teacherService.save(model);
				 workbook.close(); 
			}
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	

	}

}
