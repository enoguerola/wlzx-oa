package system.wlims.oa.action;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import system.wlims.basic.service.teacher.TeacherService;
import system.wlims.oa.entity.course.adjust.ApplyItemModel;
import system.wlims.oa.entity.course.adjust.ApplyModel;
import system.wlims.oa.service.course.adjust.CourseAdjustService;


@Controller
public class TKDPrintAction  {
	
	
	private CourseAdjustService  courseAdjustServiceDest;
	
	private TeacherService  teacherServiceDest;

	@RequestMapping("/general/print/TKDPrint")
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 String id = (String)request.getParameter("id");
		 ApplyModel apply = courseAdjustServiceDest.getApplyById(id);
			// PrintWriter out = response.getWriter();
			//response.setContentType("text/html;charset=GB2312");
			// out.println("<HTML><BODY>");
			// out.println(tlFotm.getApplyNo());
			// out.println("</BODY></HTML>");
		 try {
				String tm = teacherServiceDest.getTeacherNameByUserId(apply.getApplyTeacherId());
				apply.setApplyTeacherId(tm);
				
				Set<ApplyItemModel> temp = apply.getApplyItems();
				Iterator<ApplyItemModel>  it  =  temp.iterator();
				Set<ApplyItemModel> applyItems = new HashSet <ApplyItemModel>();
				
				while(it.hasNext()){
					ApplyItemModel aim = it.next();
					if(aim.getAdjustMeanTeacherId()!=null&&!aim.getAdjustMeanTeacherId().equalsIgnoreCase("")){
						tm = teacherServiceDest.getTeacherNameByUserId(aim.getAdjustMeanTeacherId());
						aim.setAdjustMeanTeacherId(tm);
					}
					if(aim.getAdjustActualTeacherId()!=null&&!aim.getAdjustActualTeacherId().equalsIgnoreCase("")){
						tm = teacherServiceDest.getTeacherNameByUserId(aim.getAdjustActualTeacherId());
						aim.setAdjustActualTeacherId(tm);
					}
					applyItems.add(aim);
		 		}
				apply.setApplyItems(applyItems);
				
				if(apply.getApproveTeacherId()!=null&&!apply.getApproveTeacherId().equalsIgnoreCase("")){
					tm = teacherServiceDest.getTeacherNameByUserId(apply.getApproveTeacherId());
					apply.setApproveTeacherId(tm);
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		 request.setAttribute("apply", apply);
		 
		
		 
		 
		 
		 ServletContext app = request.getSession().getServletContext();
		 RequestDispatcher disp;
		 disp = app.getRequestDispatcher("/TKDPrint.jsp");
		 disp.forward(request, response);
	}
	
	
	@Autowired
	public void setCourseAdjustService(@Qualifier("courseAdjustServiceDest")CourseAdjustService courseAdjustServiceDest) {
		this.courseAdjustServiceDest = courseAdjustServiceDest;
	}
	public CourseAdjustService getCourseAdjustService() {
		return courseAdjustServiceDest;
	}
	
	@Autowired
	public void setTeacherService(@Qualifier("teacherServiceDest")TeacherService teacherServiceDest) {
		this.teacherServiceDest = teacherServiceDest;
	}
	public TeacherService getTeacherService() {
		return teacherServiceDest;
	}
	

}
