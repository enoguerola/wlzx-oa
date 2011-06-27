package system.wlims.oa.action;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import system.ServiceException;
import system.components.upload.BaseFileUploadHandler;
import system.utils.ResourcesUtils;
import system.wlims.oa.entity.notice.AttachmentModel;
import system.wlims.oa.service.notice.AttachmentService;

@Controller
public class AttachmentUploadHandler extends BaseFileUploadHandler{
	
	private AttachmentService attachmentService;
	private AttachmentModel attachment = new AttachmentModel();

	@Override
	public void doResponse() throws SAXException {
		// TODO Auto-generated method stub
		AttributesImpl atts = new AttributesImpl();
		atts.addAttribute("","","id","CDATA","id");                          // Add the "id" attribute of the "field" element. 
        
        hd.startElement("","","field",atts);                                                // Start element and set its attribute.
        hd.characters(attachment.getId().toCharArray(),0,attachment.getId().length());          // Set the "field" tag's value.
        hd.endElement("","","field");                                                       // Close the "field" tag.
        atts.clear(); 
	}

	@Override
	public void doSave(CommonsMultipartFile file) {
		// TODO Auto-generated method stub
		attachment.setName(file.getOriginalFilename());
		attachment.setPath(getFilename());
		attachment.setType(getFileType(file.getOriginalFilename()));
		attachment.setId(null);
		try {
			attachmentService.save(attachment);
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

	public AttachmentService getAttachmentService() {
		return attachmentService;
	}

	@Autowired
	public void setAttachmentService(@Qualifier("attachmentService")AttachmentService attachmentService) {
		this.attachmentService = attachmentService;
	}
}
