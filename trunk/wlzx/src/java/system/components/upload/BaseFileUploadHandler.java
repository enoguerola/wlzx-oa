package system.components.upload;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;


import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;


public abstract class BaseFileUploadHandler implements IUpload{

	protected String uploadDirectory;		
	protected TransformerHandler hd = null;
	private String filename;
	
	private PrintWriter out = null;
	
	protected abstract void init();
	
//	private String getFileName(String filename){
//		int index = filename.indexOf(".");
//		if(index > -1){
//			return filename.substring(0, index);
//		}else
//			return filename;
//	}
	
	public String getFileType(String filename){
		int index = filename.indexOf(".");
		if(index > -1){
			return filename.substring(index + 1, filename.length());
		}else
			return filename;
	}
	
	protected void doUpload(CommonsMultipartFile file,HttpServletResponse response, HttpServletRequest request)throws Exception{
		init();
		
		if (file != null && !file.isEmpty()) {
//			Calendar calendar = Calendar.getInstance();
		    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMddhhmmss");
//		    filename = getFileName(file.getOriginalFilename()) + "_" + simpleDateFormat.format(calendar.getTime()) + "."
//		    				+ getFileType(file.getOriginalFilename());
		    filename =  "attach_"+simpleDateFormat.format(new Date()) + "."+ getFileType(file.getOriginalFilename());
		    File directory=new File(uploadDirectory);
		    if(!directory.exists()){
		    	directory.mkdir();
		    }
		    DataOutputStream out = new DataOutputStream(new FileOutputStream(uploadDirectory + filename));// 存放文件的绝对路径
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
		
		doSave(file, response, request);
	}
	
	/*public void upload(@RequestParam("file") CommonsMultipartFile file,HttpServletResponse response)throws Exception{
		
		init();
		
		if (file != null && !file.isEmpty()) {
			Calendar calendar = Calendar.getInstance();
		    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMddhhmmss");
		    filename = getFileName(file.getOriginalFilename()) + "_" + simpleDateFormat.format(calendar.getTime()) + "."
		    				+ getFileType(file.getOriginalFilename());
		    DataOutputStream out = new DataOutputStream(new FileOutputStream(uploadDirectory + filename));// 存放文件的绝对路径
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
		
		doSave(file, response);
		//doUpload(response);
	}*/
	
	protected void response(HttpServletResponse response, String id){
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
	 
	            doResponse(id);
	           
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
	
	

	@Override
	public void doResponse(String id) throws SAXException {
		// TODO Auto-generated method stub
		AttributesImpl atts = new AttributesImpl();
		atts.addAttribute("","","id","CDATA","id");                          // Add the "id" attribute of the "field" element. 
        
        hd.startElement("","","field",atts);                                                // Start element and set its attribute.
        hd.characters(id.toCharArray(),0,id.length());          // Set the "field" tag's value.
        hd.endElement("","","field");                                                       // Close the "field" tag.
        atts.clear(); 
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
}
