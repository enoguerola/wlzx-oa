package system.wlims.basic.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Cell;
import jxl.CellType;
import jxl.DateCell;
import jxl.NumberCell;
import jxl.Sheet;
import jxl.Workbook;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TeacherExcelImportController{
	
	public TeacherExcelImportController(){
		System.out.println("cccasas");
	}

    @RequestMapping("/spring/imageUpload.action") 
    public void upload()
    {
    	System.out.println("cccasaaaaas");
    }



	/*public ModelAndView handleRequest(HttpServletRequest request,
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
		   System.out.print("\t");
		 }
		 System.out.print("\n");
		}
		//关闭它，否则会有内存泄露
		workbook.close(); 

		return null;
	}*/
	
}
