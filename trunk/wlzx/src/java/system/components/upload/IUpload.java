package system.components.upload;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.xml.sax.SAXException;

public interface IUpload {

	/**
	 * 保存上传的文件
	 * @param file
	 * @param response
	 */
	void doSave(CommonsMultipartFile file, HttpServletResponse response, HttpServletRequest request);
	
	/**
	 * 返回给客户端
	 * @param id
	 * @throws SAXException
	 */
	void doResponse(String id)throws SAXException;
	
	void upload(CommonsMultipartFile file,HttpServletResponse response, HttpServletRequest request)throws Exception;
}
