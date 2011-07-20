package system.wlims.oa;

import java.util.ArrayList;
import java.util.List;

import system.BaseTest;
import system.ServiceException;
import system.wlims.oa.entity.notice.NoticeModel;
import system.wlims.oa.service.notice.NoticeService;

public class NoticeTest extends BaseTest {
	
	private NoticeService noticeService;
	
	public NoticeTest(){
		noticeService = (NoticeService)applicationContext.getBean("noticeService");
	}
	
	public void save(){
		try {
			NoticeModel notice = noticeService.get("10");
			List list = new ArrayList();
			list.add("24");
			list.add("25");
//			noticeService.updateNotice(notice, list);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NoticeTest test = new NoticeTest();
		test.save();
	}

	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}

	public NoticeService getNoticeService() {
		return noticeService;
	}

}
