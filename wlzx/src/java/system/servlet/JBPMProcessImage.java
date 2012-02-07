package system.servlet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipInputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jbpm.api.Configuration;
import org.jbpm.api.ExecutionService;
import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.ProcessEngine;
import org.jbpm.api.ProcessInstance;
import org.jbpm.api.RepositoryService;

public class JBPMProcessImage extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = 3306242777135633153L;
	private ProcessEngine processEngine;  
    private RepositoryService repositoryService;  
    private ExecutionService executionService;
    public JBPMProcessImage() throws FileNotFoundException{
		processEngine=Configuration.getProcessEngine();
		repositoryService=processEngine.getRepositoryService();  
		executionService=processEngine.getExecutionService();
//		ZipInputStream zis;
//		try {
//			zis = new ZipInputStream(new FileInputStream("E:/AdobeFlashBuilder4.5/wlzx/src/java/logistis-caigou.zip"));
//		     processEngine.getRepositoryService().createDeployment().addResourcesFromZipInputStream(zis).deploy();
//		     zis.close();  
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		 String processInstanceId = request.getParameter("processInstanceId");//流程定义ID
		 ProcessInstance processInstance = executionService.findProcessInstanceById(processInstanceId);
         String processDefinitionId = processInstance.getProcessDefinitionId();
         ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionId(processDefinitionId).uniqueResult();
         InputStream inputStream = repositoryService.getResourceAsStream(processDefinition.getDeploymentId(), processDefinition.getImageResourceName());
         if(inputStream!=null)
         {	 response.setContentType("image/png");   
             byte[] bytes = new byte[1024*4];
             int size = 0;
             //输出流程图
             while ((size = inputStream.read(bytes, 0, 1024*4)) != -1) {
                 response.getOutputStream().write(bytes,0,size);
             }
         }
	}

	

}
