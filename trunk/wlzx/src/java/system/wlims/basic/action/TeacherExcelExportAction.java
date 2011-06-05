package system.wlims.basic.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class TeacherExcelExportAction  implements Controller{
	TeacherExcelExportAction(){
		System.out.println("CCCCCCCCCCCCCCCCCCCCCCCCc");
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");

		return null;
	}


}
