package system.wlims.oa.action;

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
import system.wlims.oa.entity.receipt.FileAttachmentModel;
import system.wlims.oa.service.receipt.FileAttachmentService;

@Controller
public class ReceiptAttachmentHandler extends BaseFileUploadHandler {
	
	private FileAttachmentService fileAttachmentService;

	@Override
	protected void init() {
		// TODO Auto-generated method stub
		uploadDirectory = ResourcesUtils.getWebRootPath() + "uploads/oa/attachment/";
	}

	@Override
	public void doSave(CommonsMultipartFile file, HttpServletResponse response) {
		// TODO Auto-generated method stub
		FileAttachmentModel attachment = new FileAttachmentModel();
		attachment.setName(file.getOriginalFilename());
		attachment.setPath(getFilename());
		attachment.setType(getFileType(file.getOriginalFilename()));
		try {
			fileAttachmentService.save(attachment);
			doUpload(response, attachment.getId());
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	@RequestMapping("/oa/receipt/spring/attachmentUpload.action") 
    @ResponseBody
	public void upload(@RequestParam("file") CommonsMultipartFile file,HttpServletResponse response)throws Exception{
		doUpload(file, response);
	}

	@Autowired
	public void setFileAttachmentService(@Qualifier("fileAttachmentService")FileAttachmentService fileAttachmentService) {
		this.fileAttachmentService = fileAttachmentService;
	}

	public FileAttachmentService getFileAttachmentService() {
		return fileAttachmentService;
	}
}
