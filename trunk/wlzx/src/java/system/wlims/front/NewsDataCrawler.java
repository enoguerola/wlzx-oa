package system.wlims.front;


import java.util.List;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;

/**
 * 数据源采集: http://www.tielu.org/
 * 
 * @author JeccyZhao
 *
 */
public class NewsDataCrawler extends WebCrawler {
	
	private final static Logger logger = Logger.getLogger(NewsDataCrawler.class);
	

    private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|bmp|gif|jpe?g" 
                                                      + "|png|tiff?|mid|mp2|mp3|mp4"
                                                      + "|wav|avi|mov|mpeg|ram|m4v|pdf" 
                                                      + "|rm|smil|wmv|swf|wma|zip|rar|gz))$");

    /**
     * You should implement this function to specify whether
     * the given url should be crawled or not (based on your
     * crawling logic).
     */
    @Override
    public boolean shouldVisit(WebURL url) {
            String href = url.getURL().toLowerCase();
            return !FILTERS.matcher(href).matches() &&(isNewsPage(href)||isNewsListPage(href));
    }

    /**
     * This function is called when a page is fetched and ready 
     * to be processed by your program.
     */
    @Override
    public void visit(Page page) {          
            String url = page.getWebURL().getURL();
            if(isNewsPage(url)){
            	System.out.println("URL: " + url);

                if (page.getParseData() instanceof HtmlParseData) {
                        HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
                        String html = htmlParseData.getHtml();
                        Document htmlDoc = Jsoup.parse(html);
            			Element td = htmlDoc.select("td[bgcolor=#F8FAFC]").get(0);
            			Elements es=td.select("table tr");
            			Element first=es.get(0);
            			Element secord=es.get(1);
            			Element third=es.get(2);
            			String title=first.select("font").html();
            			String authorAndTime=secord.select("td").text();
            			String content=third.select("span").html();
            			 System.out.println(title);
            			 System.out.println(authorAndTime);
                        System.out.println(content);
                }
            	
            }
            
    }

 
	private boolean isNewsPage (String href) {
		return href.toLowerCase().startsWith("http://www.wms.edu/article/shownews.asp?newsid="); 
	}
	
	
	private boolean isNewsListPage (String href) {
		return href.toLowerCase().startsWith("http://www.wms.edu/article/showsmalltype.asp"); 
	}

	public static Logger getLogger() {
		return logger;
	}
	
}
