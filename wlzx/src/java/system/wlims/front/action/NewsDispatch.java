package system.wlims.front.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import system.PaginationSupport;
import system.wlims.front.entity.ModelNews;




public class NewsDispatch  {
	public static String WebRoot="http://www.wms.edu/";
	
	@SuppressWarnings("deprecation")
	private static String getRequestDispatchedResult(String path){
		 HttpClient client = new HttpClient();
	      HttpMethod method = new GetMethod(WebRoot+path);//使用Get方式提交数据
	      method.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"GB2312");  
	     try {
			client.executeMethod(method);
		    String response =   new String(method.getResponseBodyAsString());
//		     System.out.println(method.getStatusLine());
//		     System.out.println(response);
		     method.releaseConnection();
		     client.setTimeout(1000);
		     client.setConnectionTimeout(1000);
		     return response;
		} catch (HttpException e) {
			e.printStackTrace();
			method.releaseConnection();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			method.releaseConnection();
			return null;
		}
	    
		
	}
	public static PaginationSupport<ModelNews> getNewsList(String page) throws Exception{
		List<ModelNews> results=new ArrayList<ModelNews>();
		System.out.println(System.currentTimeMillis());
		String html=getRequestDispatchedResult("Article/ShowSmallType.asp?ClassID=86&page="+page);
		System.out.println(System.currentTimeMillis());

        Document htmlDoc = Jsoup.parse(html);
		Elements tds = htmlDoc.select("td[height=20]");
		if(tds!=null&&tds.size()>0){
			for(int i=0;i<tds.size();i++){
				Element td=tds.get(i);
				ModelNews news=new ModelNews();
				news.setTitle(replaceSpecialStr(td.select("a").text()));
				news.setPostTime(td.select("font").text());
				news.setId(td.select("a").attr("href").split("=")[1]);
//				System.out.println(news.getId());
				System.out.println(news.getTitle());
//				System.out.println(news.getPostTime());
				results.add(news);
			}
			
		}
		System.out.println(System.currentTimeMillis());
		String totalCount=htmlDoc.select("b").get(0).text();
		String maxPageItems=htmlDoc.select("b").get(1).text();
		String currentPage=htmlDoc.select("font[color=red]").get(0).text();
//		System.out.println(totalCount);
//		System.out.println(currentPage);
//		System.out.println(maxPageItems);

		return new PaginationSupport<ModelNews>(results,Integer.parseInt(totalCount),(Integer.parseInt(currentPage)-1)*Integer.parseInt(maxPageItems),Integer.parseInt(maxPageItems));
	}
	public static ModelNews getNews(String id) throws Exception{
		ModelNews news=new ModelNews();
		String html=getRequestDispatchedResult("Article/ShowNews.asp?NewsID="+id);
        Document htmlDoc = Jsoup.parse(html);
		Element td = htmlDoc.select("td[bgcolor=#F8FAFC]").get(0);
		Elements es=td.select("table tr");
		Element first=es.get(0);
		Element secord=es.get(1);
		Element third=es.get(2);
		String title=first.select("font").html();
		String authorAndTime=secord.select("td").text();
		String content=third.select("td").html();

        news.setId(id);
        news.setContent(replaceSpecialStr(replaceAddress(content)));
        news.setTitle(replaceSpecialStr(title));
//        System.out.println(news.getContent());
//        System.out.println(replaceSpecialStr(authorAndTime));
        news.setAuthor(authorAndTime.substring(authorAndTime.indexOf("作者:")+3, authorAndTime.indexOf("点击数：")));
        news.setReadNums(authorAndTime.substring(authorAndTime.indexOf("点击数：")+4, authorAndTime.indexOf("时间：")));
        news.setPostTime(authorAndTime.substring(authorAndTime.indexOf("时间：")+3));

		return news;
	}
	
	
	public static String replaceAddress(String content){
		String replaceStr="UploadFiles";
		String afterReplaceStr=WebRoot+"Article/"+replaceStr;
		String s=content.replace(replaceStr, afterReplaceStr);
		return s.replace("onmousewheel=\"return bbimg(this)\"", "").replace("onload=\"resizepic(this)\"", "");
	}
	public static String replaceSpecialStr(String content){
		String replaceStr="才�";
		String afterReplaceStr="才锜";
		return content.replace(replaceStr, afterReplaceStr);
		
	}
	
	public static void main(String[] args) throws Exception {
		//getNews("1046");
		//getNewsList("2");
//		String temp="<img onmousewheel='return bbimg(this)' src='UploadFiles/201201/20120117165034867.jpg' onload='resizepic(this)' border='0' style='zoom: 80%; '>";
//		System.out.println(replaceAddress(temp));
	}


}
