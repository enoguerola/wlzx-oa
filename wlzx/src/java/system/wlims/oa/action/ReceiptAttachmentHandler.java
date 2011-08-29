package system.wlims.oa.action;

import java.sql.Date;

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
import system.utils.UtilDateTime;
import system.wlims.oa.entity.receipt.FileAttachmentModel;
import system.wlims.oa.entity.receipt.ReceiptModel;
import system.wlims.oa.service.receipt.FileAttachmentService;
import system.wlims.oa.service.receipt.ReceiptService;

@Controller
public class ReceiptAttachmentHandler extends BaseFileUploadHandler {
	
//	private FileAttachmentService fileAttachmentService;
//	private ReceiptService receiptService;

	@Override
	protected void init() {
		// TODO Auto-generated method stub
		uploadDirectory = ResourcesUtils.getWebRootPath() + "uploads/oa/attachment/";
	}

	@Override
	public void doSave(CommonsMultipartFile file, HttpServletResponse response, HttpServletRequest request) {
//		// TODO Auto-generated method stub
//		FileAttachmentModel attachment = new FileAttachmentModel();
//		attachment.setName(file.getOriginalFilename());
//		attachment.setPath(getFilename());
//		attachment.setType(getFileType(file.getOriginalFilename()));
//		attachment.setDate(Date.valueOf(UtilDateTime.nowDateString()));
//		String receiptid = request.getParameter("id");
//		try {
//			ReceiptModel receipt = receiptService.get(receiptid);
//			attachment.setReceipt(receipt);
//			fileAttachmentService.save(attachment);
//			response(response, attachment.getId());
//		} catch (ServiceException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	@Override
	@RequestMapping("/oa/receipt/spring/attachmentUpload.action") 
    @ResponseBody
	public void upload(@RequestParam("file") CommonsMultipartFile file,HttpServletResponse response, HttpServletRequest request)throws Exception{
		doUpload(file, response, request);
	}

//	@Autowired
//	public void setFileAttachmentService(@Qualifier("fileAttachmentService")FileAttachmentService fileAttachmentService) {
//		this.fileAttachmentService = fileAttachmentService;
//	}
//
//	public FileAttachmentService getFileAttachmentService() {
//		return fileAttachmentService;
//	}
//
//	@Autowired
//	public void setReceiptService(@Qualifier("receiptService")ReceiptService receiptService) {
//		this.receiptService = receiptService;
//	}
//
//	public ReceiptService getReceiptService() {
//		return receiptService;
//	}
}
