package system.wlims.oa;


import system.BaseTest;
import system.ServiceException;
import system.wlims.oa.entity.receipt.FileAttachmentModel;
import system.wlims.oa.service.receipt.FileAttachmentService;

public class ReceiptAttachmentTest extends BaseTest {

	private FileAttachmentService fileAttachmentService;
	
	public ReceiptAttachmentTest(){
		setFileAttachmentService((FileAttachmentService)(applicationContext.getBean("fileAttachmentService")));
	}
	
	public void save(){
		
		FileAttachmentModel attachment = new FileAttachmentModel();
		attachment.setName("gg");
		attachment.setPath("/////");
		attachment.setType(".oh");
		try {
			fileAttachmentService.save(attachment);
			System.out.println("save done");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		ReceiptAttachmentTest test = new ReceiptAttachmentTest();
		test.save();
	}

	public void setFileAttachmentService(FileAttachmentService fileAttachmentService) {
		this.fileAttachmentService = fileAttachmentService;
	}

	public FileAttachmentService getFileAttachmentService() {
		return fileAttachmentService;
	}
}
