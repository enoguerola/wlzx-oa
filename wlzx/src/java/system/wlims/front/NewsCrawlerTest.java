package system.wlims.front;

import java.util.List;

import system.BaseTest;
import system.wlims.front.service.NewsService;


public class NewsCrawlerTest extends BaseTest {
	
	private NewsService newsService;
	
	public NewsCrawlerTest () {
		newsService = (NewsService)applicationContext.getBean("newsService");
	}

	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}

	public NewsService getNewsService() {
		return newsService;
	}
	
	public void TestDataCrawl () {
		
//		try {
//			
//			NewsDataCrawlerController crawler = new NewsDataCrawlerController();
//			
//			List<Object> data =crawler.startCrawl();
//			
//			if (data != null && data.size() > 0) {
////				for (Object obj : data) {
////					ModelNews model = (ModelNews)obj;
////					newsService.saveOrUpdate(model);
////				}
//			}
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
	}
	
	public static void main (String[] args) {
		
		NewsCrawlerTest test = new NewsCrawlerTest();
		test.TestDataCrawl();
	}
	
}
