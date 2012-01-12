package system.wlims.front.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import system.PaginationSupport;
import system.ServiceException;
import system.dao.DepartmentDAO;
import system.entity.DepartmentModel;
import system.utils.StringUtils;
import system.wlims.basic.service.DirectoryService;
import system.wlims.oa.entity.notice.NoticeModel;
import system.wlims.oa.service.notice.NoticeService;





@Controller
public class NoticeListAction  {
	private NoticeService noticeServiceDest;
	private DepartmentDAO departmentDAO;
	private DirectoryService directoryServiceDest;
	@RequestMapping("/noticeList")
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = (String)request.getParameter("type");
		String emergence = (String)request.getParameter("emergence");
		String deparmentIds = (String)request.getParameter("deparmentIds");
		String title = (String)request.getParameter("title");
		String beginDate = (String)request.getParameter("beginDate");
		String endDate = (String)request.getParameter("endDate");
		int pageSize = 15;
		int startIndex = StringUtils.isEmpty(request.getParameter("startIndex"))?0:Integer.parseInt(request.getParameter("startIndex"));
		 try {
			 PaginationSupport<NoticeModel> noticePages=noticeServiceDest.getFrontPageSchoolNoticesByConditions(type, emergence, deparmentIds, title, beginDate, endDate, pageSize, startIndex);
			if(noticePages!=null&&noticePages.getItemCount()>0){
				for(NoticeModel notice:noticePages.getItems()){
					DepartmentModel department=departmentDAO.get(notice.getPostDepartmentId());
					if(department!=null)
					notice.setPostDepartmentName(department.getName());
				}
			}
			
		   request.setAttribute("noticeTypes", directoryServiceDest.getDirectoryItemsByType("noticeType"));
		   
		   request.setAttribute("departments", departmentDAO.getAllDepartments());
		   request.setAttribute("noticePages", noticePages);
			
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		 
		 
		 ServletContext app = request.getSession().getServletContext();
		 RequestDispatcher disp;
		 disp = app.getRequestDispatcher("/front/noticeList.jsp");
		 disp.forward(request, response);
	}
	public NoticeService getNoticeServiceDest() {
		return noticeServiceDest;
	}
	@Autowired
	public void setNoticeServiceDest(@Qualifier("noticeServiceDest")NoticeService noticeServiceDest) {
		this.noticeServiceDest = noticeServiceDest;
	}
	
	public DepartmentDAO getDepartmentDAO() {
		return departmentDAO;
	}
	@Autowired
	public void setDepartmentDAO(@Qualifier("departmentDAO")DepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}
	public DirectoryService getDirectoryServiceDest() {
		return directoryServiceDest;
	}
	@Autowired
	public void setDirectoryServiceDest(@Qualifier("directoryServiceDest")DirectoryService directoryServiceDest) {
		this.directoryServiceDest = directoryServiceDest;
	}
	
	


}
