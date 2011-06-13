package system.wlims.basic.action;

import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.xml.sax.helpers.AttributesImpl;

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

    @RequestMapping("/basic/staff/spring/excelUpload.action") 
    @ResponseBody//这个是表示，返回内容以这里构造的为准。不返回常用的视图。需要配置支持。
    public void upload(@RequestParam("name") String fname, //设置请求参数的名称和类型
    		@RequestParam("file") CommonsMultipartFile file,HttpServletResponse response)throws Exception{
    	Workbook workbook = null;
    	workbook = Workbook.getWorkbook(file.getInputStream());
    	Sheet sheet = workbook.getSheet(0);
    	
    	System.out.println(sheet.getColumns());
    	
		PrintWriter out = null;
		out = response.getWriter();
		// SAX 2.0 ContentHandler.
        TransformerHandler hd = null;
        
        StreamResult streamResult = new StreamResult(out); 
        SAXTransformerFactory tf = (SAXTransformerFactory) SAXTransformerFactory.newInstance(); // SAX XML parsing factory.
               
        hd = tf.newTransformerHandler();                                                        // Set the XML handler.
        Transformer serializer = hd.getTransformer();                                           // You'll serialize the data.
        serializer.setOutputProperty(OutputKeys.ENCODING,"UTF-8");                              // You'll use UTF-8 for the XML encoding.
        serializer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM,"response.dtd");                 // Set the doctype to the custom DTD.
        serializer.setOutputProperty(OutputKeys.INDENT,"yes");                                  // Though not required, you can provide automatic indentation of the XML.
        serializer.setOutputProperty(OutputKeys.METHOD,"xml");                                  // Identifies the method used for outputting the result tree.
        hd.setResult(streamResult);

        hd.startDocument();
        
        AttributesImpl atts = new AttributesImpl();  
        hd.startElement("","","response",atts); 
        
		int rowCount = sheet.getRows();
		for (int i = 1; i <rowCount; i++) {
			 TeacherModel model = new TeacherModel();
			 // Clear the XML attributes object.
             atts.clear();
			 
			 String group = sheet.getCell(0, i).getContents();
			 String name = sheet.getCell(1, i).getContents();
			 String shortNo = sheet.getCell(2, i).getContents();
			 
			 if(!teacherService.valideNo(shortNo)){
                  hd.startElement("","","field",null);                                                // Start element and set its attribute.
                  hd.characters(shortNo.toCharArray(),0,shortNo.length());          // Set the "field" tag's value.
                  hd.endElement("","","field");                                                       // Close the "field" tag.                                                       // Close the "field" tag.
                  continue;
			 }
			 
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
			 model.setTeacherDepartment(group);
			 
			 teacherService.save(model);
			 workbook.close(); 
		}
		
        hd.endElement("","","response");                                                        // End the "response" element.
        hd.endDocument();                                                                       // End the XML document.
        out.close(); 
    }

		
		 /*
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
		   }*/
		 

	@Autowired
	public void setTeacherService(@Qualifier("teacherService") TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	public TeacherService getTeacherService() {
		return teacherService;
	}
	
}
