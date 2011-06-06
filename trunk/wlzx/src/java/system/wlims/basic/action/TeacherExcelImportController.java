package system.wlims.basic.action;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Cell;
import jxl.CellType;
import jxl.DateCell;
import jxl.NumberCell;
import jxl.Sheet;
import jxl.Workbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import system.entity.PersonModel.PersonStyle;
import system.utils.UtilDateTime;
import system.wlims.basic.entity.teacher.TeacherModel;
import system.wlims.basic.service.teacher.TeacherService;

@Controller
public class TeacherExcelImportController{
	
	private TeacherService teacherService;
	
	public TeacherExcelImportController(){
		System.out.println("cccasas");
	}

    @RequestMapping("/spring/imageUpload.action") 
    public void upload()throws Exception{
    	System.out.println("cccasaaaaas");
    }



	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		MultipartHttpServletRequest re = (MultipartHttpServletRequest)request;
		Map map = re.getFileMap();
		MultipartFile file = null;
		for( Object obj : map.values()){
			MultipartFile multipartFile = (MultipartFile)obj;
			file = multipartFile;
		}

		Workbook workbook = null;
		
		try {
		 workbook = Workbook.getWorkbook(file.getInputStream());
		 System.out.println("ddd");
		} catch (Exception e) {
		 throw new Exception("file to import not found!");
		}

		Sheet sheet = workbook.getSheet(0);
		Cell cell = null;

		int columnCount=3;
		int rowCount = sheet.getRows();
		for (int i = 0; i <rowCount; i++) {
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
		 Integer sex = Integer.parseInt(sheet.getCell(9, i).getContents());
		 Date birthday = ((DateCell)sheet.getCell(10, i)).getDate();
		 
		 String nation = sheet.getCell(11, i).getContents();
		 Integer marriage = Integer.parseInt(sheet.getCell(12, i).getContents());
		 Integer politic = Integer.parseInt(sheet.getCell(13, i).getContents());
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
		 model.setBirthday((java.sql.Date)birthday);
		 model.setCreationDate(java.sql.Date.valueOf(UtilDateTime.nowDateString()));
		 model.setHomePhone(homePhone);
		 model.setModifiedDate(model.getCreationDate());
		 model.setName(name);
		 model.setNation(nation);
		 model.setPoliticsStatus(politic);
		 model.setSex(sex);
		 model.setStyle(PersonStyle.Teacher.getStyle());
		 model.setTeacherAttendDate((java.sql.Date)attendDate);
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
		 model.setTeacherProfession(profession);
		 model.setTeacherSkillLevel(skill);
		 model.setTeacherSkillLevelDate((java.sql.Date)skillDate);
		 model.setTeacherStatus(1);
		 model.setTeacherWorkDate((java.sql.Date)workDate);
		 
		 teacherService.save(model);
		 
		 for (int j = 0; j <columnCount; j++) {
		   //注意，这里的两个参数，第一个是表示列的，第二才表示行
		   cell=sheet.getCell(j, i);
		   
		   
		   //要根据单元格的类型分别做处理，否则格式化过的内容可能会不正确
		   if(cell.getType()==CellType.NUMBER){
		     System.out.print(((NumberCell)cell).getValue());
		   }
		   else if(cell.getType()==CellType.DATE){
		     System.out.print(((DateCell)cell).getDate());
		   }
		   else{
		     System.out.print(cell.getContents());
		   }
		   
		   //System.out.print(cell.getContents());
		 }
		 System.out.print("\n");
		}
		//关闭它，否则会有内存泄露
		workbook.close(); 

		return null;
	}

	@Autowired
	public void setTeacherService(@Qualifier("teacherService") TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	public TeacherService getTeacherService() {
		return teacherService;
	}
	
}
