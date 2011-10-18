package system.wlims.oa.action;

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

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import system.constants.Constants;
import system.excel.ExcelTemplateSupport;
import system.excel.VoTplExcelObj;
import system.utils.ResourcesUtils;
import system.wlims.oa.entity.schedule.ScheduleModel;
import system.wlims.oa.service.schedule.ScheduleService;


@Controller
public class PublicScheduleExcelExportAction{
	
	private ScheduleService scheduleServiceDest;
	
	@RequestMapping("/general/export/publicSchedule")
	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
        response.setContentType("application/vnd.ms-excel");

		VoTplExcelObj obj = ExcelTemplateSupport.getTplObjFromTplFile(Constants.OA_XLS_TPL_PATH + "/publicSchedule.xml");
		
		List<Map<String, Object>> data = new ArrayList<Map<String,Object>>();
		
		//insert data
		String keyIds=request.getParameter("keyids");
		String scheduelType=keyIds.split(";")[0].equalsIgnoreCase("null")?null:keyIds.split(";")[0];
		String scheduleState=keyIds.split(";")[1].equalsIgnoreCase("null")?null:keyIds.split(";")[1];
		String scheduelDepartmentShare=keyIds.split(";")[2].equalsIgnoreCase("null")?null:keyIds.split(";")[2];
		String scheduelDepartmentId=keyIds.split(";")[3].equalsIgnoreCase("null")?null:keyIds.split(";")[3];
		String scheduelSchoolShare=keyIds.split(";")[4].equalsIgnoreCase("null")?null:keyIds.split(";")[4];
		String scheduelEmergence=keyIds.split(";")[5].equalsIgnoreCase("null")?null:keyIds.split(";")[5];
		String scheduelTitle=keyIds.split(";")[6].equalsIgnoreCase("null")?null:keyIds.split(";")[6];
		String scheduleBeginDate=keyIds.split(";")[7].equalsIgnoreCase("null")?null:keyIds.split(";")[7];
		String scheduleEndDate=keyIds.split(";")[8].equalsIgnoreCase("null")?null:keyIds.split(";")[8];
		insertData(data,scheduelType,scheduleState,scheduelDepartmentShare,scheduelDepartmentId,scheduelSchoolShare,scheduelEmergence,scheduelTitle,scheduleBeginDate,scheduleEndDate);
		
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
			ServletOutputStream servletOutputStream = null;
			try {
				if (xlsFile.exists()) {
					ByteArrayOutputStream out;
					out = ResourcesUtils.getFileStream(filePath);
					InputStream excelStream = new ByteArrayInputStream(out.toByteArray());
					
			        response.setHeader("Content-Disposition", "attachment; filename=" + "personSchedule.xls");
			        servletOutputStream = response.getOutputStream();
			        // 读取数量
	                int iByteSum = 0;
	                // 读取字节数
	                int iByteRead = 0;
	                
	                // 缓存 1024
	                byte[] bufferByte = new byte[1024];
	                
	                //循环读取数据
	                while ((iByteRead = excelStream.read(bufferByte)) != -1)
	                {
	                    iByteSum += iByteRead;
	                    servletOutputStream.write(bufferByte, 0, iByteRead);
	                }
	                // 关闭输入流
	                excelStream.close();
                    //释放资源
	                excelStream = null;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				
                try{
                    //执行完毕关闭servletOutputStream
                    if (servletOutputStream != null){
                        // 关闭文件输出流
                        servletOutputStream.close();
                        //释放资源
                        servletOutputStream = null;
                    }
                }
                catch (IOException e){
                }
            }

		}
	}

	private void insertData(List<Map<String, Object>> data,String scheduelType,String scheduleState,String scheduelDepartmentShare,String scheduelDepartmentId,String scheduelSchoolShare,String scheduelEmergence,String scheduelTitle,String scheduleBeginDate,String scheduleEndDate){
		List<ScheduleModel> list = new ArrayList<ScheduleModel>();
			//attendanceCalculateService.getCalculateAttendanceByCondition(type, userId,departmentId,beginTime,endTime);
			//list =  scheduleServiceDest.getPersonSchedulesByConditions(userId, type, state, null, null, null, beginTime, endTime);
			//list = scheduleServiceDest.getSchedulesByConditions(userId, type, state, null, null, null, null, null, beginTime, endTime);
		list = 	scheduleServiceDest.getSchedulesByConditions(null, scheduelType, scheduleState, scheduelDepartmentShare, scheduelDepartmentId, scheduelSchoolShare, scheduelEmergence, scheduelTitle, scheduleBeginDate, scheduleEndDate);
		for(ScheduleModel model : list){
				Map<String, Object> ents = new HashMap<String, Object>();
				ents.put("base", model);
				data.add(ents);
		}
	
	}

	
	@Autowired
	public void setScheduleService(@Qualifier("scheduleServiceDest")ScheduleService scheduleServiceDest) {
		this.scheduleServiceDest = scheduleServiceDest;
	}
	public ScheduleService getScheduleService() {
		return scheduleServiceDest;
	}
	

}
