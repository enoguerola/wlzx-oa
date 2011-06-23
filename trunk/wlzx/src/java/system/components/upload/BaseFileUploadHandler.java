package system.components.upload;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import com.sun.corba.se.spi.orb.StringPair;

public abstract class BaseFileUploadHandler implements IUpload{

	protected String uploadDirectory;		
	protected TransformerHandler hd = null;
	private String filename;
	
	private PrintWriter out = null;
	
	protected abstract void init();
	
	private String getFileName(String filename){
		int index = filename.indexOf(".");
		if(index > -1){
			return filename.substring(0, index);
		}else
			return filename;
	}
	
	public String getFileType(String filename){
		int index = filename.indexOf(".");
		if(index > -1){
			return filename.substring(index + 1, filename.length());
		}else
			return filename;
	}
	
	@RequestMapping("/oa/notice/spring/attachmentUpload.action") 
    @ResponseBody//这个是表示，返回内容以这里构造的为准。不返回常用的视图。需要配置支持。
	public void upload(@RequestParam("file") CommonsMultipartFile file,HttpServletResponse response)throws Exception{
		
		init();
		
		if (file != null && !file.isEmpty()) {
			Calendar calendar = Calendar.getInstance();
		    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMddhhmmss");
		    filename = getFileName(file.getOriginalFilename()) + "_" + simpleDateFormat.format(calendar.getTime()) + "."
		    				+ getFileType(file.getOriginalFilename());
		    DataOutputStream out = new DataOutputStream(new FileOutputStream("c:/" + filename));// 存放文件的绝对路径
		    InputStream is = null;// 附件输入流
		    try {
		    	is = file.getInputStream();
		        byte[] b = new byte[is.available()];
		        is.read(b);
		        out.write(b);
		    } catch (IOException exception) {
		        exception.printStackTrace();
		    } finally {
		        if (is != null) {
		        	is.close();
		        }
		        if (out != null) {
		        	out.close();
		        }
		    }
		}
		
		doSave(file);
		doUpload(response);
	}
	
	private void doUpload(HttpServletResponse response){
		 try {
	            out = response.getWriter();
	            StreamResult streamResult = new StreamResult(out);                                      // Used for writing debug errors to the screen.
	   
	            SAXTransformerFactory tf = (SAXTransformerFactory) SAXTransformerFactory.newInstance(); // SAX XML parsing factory.
	           
	            hd = tf.newTransformerHandler();                                                        // Set the XML handler.
	            Transformer serializer = hd.getTransformer();                                           // You'll serialize the data.
	            serializer.setOutputProperty(OutputKeys.ENCODING,"UTF-8");                              // You'll use UTF-8 for the XML encoding.
	            serializer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM,"response.dtd");                 // Set the doctype to the custom DTD.
	            serializer.setOutputProperty(OutputKeys.INDENT,"yes");                                  // Though not required, you can provide automatic indentation of the XML.
	            serializer.setOutputProperty(OutputKeys.METHOD,"xml");                                  // Identifies the method used for outputting the result tree.
	            hd.setResult(streamResult);
	   
	            hd.startDocument();                                                                     // Start the XML document.
	   
	            AttributesImpl atts = new AttributesImpl();                                             // Declare and instantiate a new attributes object.
	   
	            hd.startElement("","","response",atts);                                                 // Start the main response element.
	 
	            doResponse();
	           
	            hd.endElement("","","response");                                                        // End the "response" element.
	            hd.endDocument();                                                                       // End the XML document.
	            out.close();                                                                            // Close the output.
	        }
	        /*
	         * Some very basic exception handling. 
	         * Modify as per your needs.
	         */
	        catch (TransformerConfigurationException tcException) {
	            out.println(tcException.getMessage());
	            System.out.println(tcException.getMessage());
	        }
	        catch (IOException ioException) {
	            out.println(ioException.getMessage());
	            System.out.println(ioException.getMessage());
	        }
	        catch (SAXException saxException) {
	            out.println(saxException.getMessage());
	            System.out.println(saxException.getMessage());
	        }
	        catch (NullPointerException exception) {
	            out.println(exception.getMessage());
	            System.out.println(exception.getMessage());
	        }
	        catch (Exception e){
	            out.println(e.getMessage());
	            System.out.println(e.getMessage());
	        }
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
}
