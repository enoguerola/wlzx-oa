package system.servlet;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import org.springframework.web.context.support.WebApplicationContextUtils;

import system.ServiceException;
import system.utils.ResourcesUtils;
import system.wlims.oa.entity.notice.AttachmentModel;
import system.wlims.oa.service.notice.AttachmentService;

import com.google.gson.Gson;


public class FileUpload extends HttpServlet {

	private static final long serialVersionUID = -4925518710024329720L;
	

	// 定义文件的上传路径
	private String uploadDirectory = ResourcesUtils.getWebRootPath() + "uploads"+System.getProperty("file.separator")+"oa"+System.getProperty("file.separator")+"attachment"+System.getProperty("file.separator");
	private int maxPostSize = 20 * 1024 * 1024; // 最大20M

	
	
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		processRequest(request, response);
	}

	@SuppressWarnings("unchecked")
	protected void processRequest(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = this.getServletContext();  
		AttachmentService attachmentService=(AttachmentService)WebApplicationContextUtils.getRequiredWebApplicationContext(context).getBean("attachmentService");
		 
		System.out.println("开始上传==============");
		response.setContentType("text/html;charset=UTF-8");
		// 保存文件到服务器中
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(4096);
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("utf-8");
		upload.setSizeMax(maxPostSize);
		try {
			List<FileItem> fileItems = upload.parseRequest(request);
			Iterator<FileItem> iter = fileItems.iterator();
			while (iter.hasNext()) {
				FileItem item = iter.next();
				if (!item.isFormField()) {
					String name = new SimpleDateFormat("yyyyMMddHHMMss").format(new Date())+"_"+item.getName();
					System.out.println(name);
					try {
						File directory=new File(uploadDirectory);
						if(!directory.exists())
							directory.mkdirs();
						item.write(new File(uploadDirectory + name));
						
						AttachmentModel attachment = new AttachmentModel();
						attachment.setName(item.getName());
						attachment.setPath(name);
						attachment.setType(item.getName().substring(item.getName().lastIndexOf("."), item.getName().length()));
						attachment.setSize(item.getSize()+"");
						attachment.setDate(new Date());
						try {
							attachmentService.save(attachment);
						} catch (ServiceException e) {
							e.printStackTrace();
						}
						Gson gson = new Gson();  
						String json = gson.toJson(attachment);  
						response.getWriter().write(json);
						System.out.println("上传成功==============");
					} catch (Exception e) {
						e.printStackTrace();
						response.getWriter().write(e.getMessage());
						System.out.println("上传失败==============");
					}
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
			response.getWriter().write(e.getMessage());
			System.out.println(e.getMessage() + "结束");
		}
	}

	

}
