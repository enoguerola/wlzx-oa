package system.wlims.basic.service.teacher;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import system.ServiceException;
import system.constants.Constants;
import system.excel.ExcelTemplateSupport;
import system.excel.VoTplExcelObj;
import system.utils.ResourcesUtils;
import system.wlims.basic.dao.teacher.TeacherDAO;
import system.wlims.basic.dao.teacher.TeacherDepartmentDAO;
import system.wlims.basic.dao.teacher.TeacherExperienceDAO;
import system.wlims.basic.dao.teacher.TeacherRelationDAO;

public class TeacherExcelService {
	
	private TeacherDAO teacherDAO;
	private TeacherDepartmentDAO teacherDepartmentDAO;
	private TeacherExperienceDAO teacherExperienceDAO;
	private TeacherRelationDAO teacherRelationDAO;
	
	public InputStream exportAll()throws ServiceException{
		VoTplExcelObj obj = ExcelTemplateSupport.getTplObjFromTplFile(Constants.BASIC_XLS_TPL_PATH + "/teachers.xml");
		
		List<Map<String, Object>> data = new ArrayList<Map<String,Object>>();
		Map<String, String> extraParams = new HashMap<String, String>();
		
		obj = ExcelTemplateSupport.fillTplData(obj, data, extraParams);
		if (obj != null) {
			String dir = ResourcesUtils.getWebRootPath() + Constants.TEMP_FILE_OUTPUT_PATH;
			File file = new File(dir);
			if (!file.exists()) {
				file.mkdir();
			}
			String filePath = dir + "/export"+ new SimpleDateFormat("ddHHmmssSS").format(new Date()) + ".xls";
			
			ExcelTemplateSupport.createExcel(filePath, obj);
			
			File xlsFile = new File(filePath);
			try {
				if (xlsFile.exists()) {
					ByteArrayOutputStream out;
					out = ResourcesUtils.getFileStream(filePath);
					InputStream excelStream = new ByteArrayInputStream(out.toByteArray());
					return excelStream;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			/*File xlsFile = new File(filePath);
			if (xlsFile.exists()) {
				xlsFile.delete();
			}*/
		}
		return null;
		
	}
	
	public TeacherDAO getTeacherDAO() {
		return teacherDAO;
	}
	public void setTeacherDAO(TeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}
	public TeacherDepartmentDAO getTeacherDepartmentDAO() {
		return teacherDepartmentDAO;
	}
	public void setTeacherDepartmentDAO(TeacherDepartmentDAO teacherDepartmentDAO) {
		this.teacherDepartmentDAO = teacherDepartmentDAO;
	}
	public TeacherExperienceDAO getTeacherExperienceDAO() {
		return teacherExperienceDAO;
	}
	public void setTeacherExperienceDAO(TeacherExperienceDAO teacherExperienceDAO) {
		this.teacherExperienceDAO = teacherExperienceDAO;
	}
	public TeacherRelationDAO getTeacherRelationDAO() {
		return teacherRelationDAO;
	}
	public void setTeacherRelationDAO(TeacherRelationDAO teacherRelationDAO) {
		this.teacherRelationDAO = teacherRelationDAO;
	}

}
