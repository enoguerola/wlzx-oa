package system.wlims.front;


import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

public class NewsDataCrawlerController {
	
	public static void main(String[] args) throws Exception {
		/*
		 * crawlStorageFolder is a folder where intermediate crawl data is
		 * stored. 
		 */
        String crawlStorageFolder = "/data/crawl/root";
        
        
        /*
		 * numberOfCrawlers shows the number of concurrent threads
		 * that should be initiated for crawling.
		 */
        int numberOfCrawlers = 1;

        CrawlConfig config = new CrawlConfig();
        config.setCrawlStorageFolder(crawlStorageFolder);
        /*
         * You can set the maximum crawl depth here. The default value is -1 for
         * unlimited depth
         */
        config.setMaxDepthOfCrawling(-1);
        /*
		 * Be polite:
		 * Make sure that we don't send more than 5 requests per 
		 * second (200 milliseconds between requests).
		 */
        config.setPolitenessDelay(500);

        /*
         * Instantiate the controller for this crawl.
         */
        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);

        /*
         * For each crawl, you need to add some seed urls. These are the first
         * URLs that are fetched and then the crawler starts following links
         * which are found in these pages
         */
        controller.addSeed("http://www.wms.edu/Article/ShowSmallType.asp?ClassID=86");
//        controller.addSeed("http://www.ics.uci.edu/~lopes/");
//        controller.addSeed("http://www.ics.uci.edu/");

        /*
         * Start the crawl. This is a blocking operation, meaning that your code
         * will reach the line after this only when crawling is finished.
         */
        controller.start(NewsDataCrawler.class, numberOfCrawlers);    
        
}

}
