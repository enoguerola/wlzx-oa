package system.wlims.oa.action;


import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import system.ServiceException;
import system.components.upload.BaseFileUploadHandler;
import system.utils.ResourcesUtils;
import system.wlims.oa.entity.notice.AttachmentModel;
import system.wlims.oa.service.notice.AttachmentService;

@Controller
public class AttachmentUploadHandler extends BaseFileUploadHandler{
	
	private AttachmentService attachmentService;

	@Override
	public void doSave(CommonsMultipartFile file, HttpServletResponse response, HttpServletRequest request) {
		// TODO Auto-generated method stub
		AttachmentModel attachment = new AttachmentModel();
		attachment.setName(file.getOriginalFilename());
		attachment.setPath(getFilename());
		attachment.setType(getFileType(file.getOriginalFilename()));
		attachment.setSize(file.getSize()+"");
		attachment.setId(null);
		attachment.setDate(new Date());
		try {
			attachmentService.save(attachment);
			response(response, attachment.getId());
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void init() {
		// TODO Auto-generated method stub
		uploadDirectory = ResourcesUtils.getWebRootPath() + "uploads/oa/attachment/";
	}
	
	@Override
	@RequestMapping("/spring/attachmentUpload.action") 
    @ResponseBody
	public void upload(@RequestParam("file") CommonsMultipartFile file,HttpServletResponse response, HttpServletRequest request)throws Exception{
		doUpload(file, response, request);
	}

	public AttachmentService getAttachmentService() {
		return attachmentService;
	}

	@Autowired
	public void setAttachmentService(@Qualifier("attachmentService")AttachmentService attachmentService) {
		this.attachmentService = attachmentService;
	}
}
