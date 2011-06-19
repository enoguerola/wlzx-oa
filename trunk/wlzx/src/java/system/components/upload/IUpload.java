package system.components.upload;

import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.xml.sax.SAXException;

public interface IUpload {

	void doSave(CommonsMultipartFile file);
	void doResponse()throws SAXException;
}
