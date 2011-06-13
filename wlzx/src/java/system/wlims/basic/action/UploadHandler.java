package system.wlims.basic.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import system.components.upload.FileFilter;
import system.utils.ResourcesUtils;
 
 
/**
 * Receives the HTTP upload request from Flex and generates valid XML.
 * 
 * @author  Alex Cougarman
 */
public class UploadHandler extends HttpServlet {
    private static final String CONTENT_TYPE = "text/xml;charset=utf-8";
 
    /**
     * Initialize of the servlet handler.
     * 
     * @param config
     * @throws ServletException
     */
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
 
    /**
     * Receives the POST request from Flex. The request contains form fields,
     * including an uploaded file. Writes the image file to the server using 
     * the employee ID sent with the request and responds with some XML to 
     * indicate status. It uses some simple exception handling for the most 
     * common problems; modify it to meet your needs.
     * 
     * @param request
     * @param response
     * @throws ServletException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        response.setContentType(CONTENT_TYPE);                                                     
        // Set the servlet's response type to XML.
        PrintWriter out = null;
        String uploadDirectory = this.getServletConfig().getInitParameter("UploadDirectory");
        uploadDirectory = ResourcesUtils.getWebRootPath() + uploadDirectory;
        // Get the upload directory from the web.xml file.
       
        ArrayList<String> allowedFormats = new ArrayList<String>();
        // Allowed image format types are stored in an ArrayList.
        allowedFormats.add("jpeg");
        allowedFormats.add("png");
        allowedFormats.add("gif");
        allowedFormats.add("jpg");
       
        File disk = null;
        FileItem item = null;
        DiskFileItemFactory factory = new DiskFileItemFactory();                                   
        // We use the FileUpload package provided by Apache to process the request.
        String statusMessage = "";
        String employeeID = "";
       
        ListIterator iterator = null;
        List items = null;
        ServletFileUpload upload = new ServletFileUpload( factory );
 
        // SAX 2.0 ContentHandler.
        TransformerHandler hd = null;
 
        try {
            out = response.getWriter();
            StreamResult streamResult = new StreamResult(out);                                      // Used for writing debug errors to the screen.
   
            SAXTransformerFactory tf = (SAXTransformerFactory) SAXTransformerFactory.newInstance(); // SAX XML parsing factory.
           
            items = upload.parseRequest(request);
            iterator = items.listIterator();
           
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
 
            while( iterator.hasNext() )                                                             // Loop over the items in the request.
            {
           
              // Clear the XML attributes object.
              atts.clear();
             
              item = (FileItem)iterator.next();
 
              // If the current item is an HTML form field...
              if( item.isFormField() )
              {
                /*
                 * First item from Flex is Filename, automatically 
                 * added to the HTTP request header when uploading
                 * a file. We'll set the variable when we iterate 
                 * to the correct URLVariable for the employeeID.
                 * The last item is another field that Flex adds
                 * automatically to the HTTP request header, 
                 * Upload, the value for the upload button.
                 */
                if (item.getFieldName().equalsIgnoreCase("employeeid")){
                    employeeID = item.getString();                                                  // Get the value and store it.
                }
                atts.addAttribute("","","id","CDATA",item.getFieldName());                          // Add the "id" attribute of the "field" element. 
               
                hd.startElement("","","field",atts);                                                // Start element and set its attribute.
                hd.characters(item.getString().toCharArray(),0,item.getString().length());          // Set the "field" tag's value.
                hd.endElement("","","field");                                                       // Close the "field" tag.
                atts.clear();                                                                       // Clear the attributes object so it can be used again.
              } else {  // If the item is a file...
                    /* 
                     * Use an ImageInputStream to validate the file's format name. 
                     * This actually reads the image's internal file format, versus
                     * reading the file extension, which isn't always reliable.
                     */
                    ImageInputStream imageInputStream = ImageIO.createImageInputStream(item.getInputStream());
                    Iterator<ImageReader> imageReaders = ImageIO.getImageReaders(imageInputStream);
                  
                    ImageReader imageReader = null;
                 
                    if(imageReaders.hasNext()){                                                     // Get the next (only) image.
                        imageReader = imageReaders.next();
                    }
                  
                    /* 
                    * Non-image files will throw a NullPointerException on the next line.
                    * This code uses a high-level Try/Catch block, but you can use a
                    * more fine-grained exception handling mechanism.
                    */
                    String imageFormat = imageReader.getFormatName();
             
                    String newFileName = employeeID + "." + imageFormat;                            // New image's filename, concatenation of employee ID and image format.
                   
                    if (allowedFormats.contains(imageFormat.toLowerCase())){                        // If the image format is one of the allowed ones...
                        /*
                         * Custom FileFilter implements java.io.FilenameFilter.
                         * See FileFilter.java.
                         */
                        FileFilter fileFilter = new FileFilter();                                   // Declare and instantiate a FileFilter object.
                        fileFilter.setEmployeeID(employeeID);                                       // Set the employee ID and the allowed image types on the FileFilter.
                        fileFilter.setImageTypes(allowedFormats);
                        File fileList[] = (new File(uploadDirectory)).listFiles(fileFilter);        // Get a filtered list of files from the upload directory.
                       
                        if(fileList != null)
                        	for (int i=0; i < fileList.length; i++){                                    // Delete any previous instances of the image file from the directory.
                        		(new File(fileList[i].getAbsolutePath())).delete();
                        	}
                       
                        disk = new File(uploadDirectory + newFileName);                             // Instantiate a File object for the file to be written.
                        item.write(disk);                                                           // Write the uploaded file to disk.
                       
                        /*
                         * Get a Calendar object and fetch the current time from it.
                         */
                        Calendar calendar = Calendar.getInstance();
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM.dd.yy hh:mm:ss aaa");
                        statusMessage = "File successfully written to server at " + simpleDateFormat.format(calendar.getTime());
                    }
                  
                    /*
                     * If you're processing multiple files, you'd place 
                     * these lines outside of the loop.
                     */
                    imageReader.dispose();
                    imageInputStream.close();
                   
                    atts.addAttribute("","","id","CDATA",newFileName);                              // Add the "id" attribute of the "file" element.
                  
                    hd.startElement("","","file",atts);                                             // Start the "file" element.
                    hd.characters(statusMessage.toCharArray(),0,statusMessage.length());            // Set the "file" element tag's value.
                    hd.endElement("","","file");                                                    // End the "file" element.
           
                    /*
                     * TODO: You can add code here to store the image name to a database.
                     */
              }
            }       
           
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
        catch (FileUploadException fileUploadException) {
            out.println(fileUploadException.getMessage());
            System.out.println(fileUploadException.getMessage());
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

}
