package system.entity;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class UploadDTO implements Serializable {

	private static final long serialVersionUID = 8176234209104280194L;
	
	private MultipartFile file;  
	  
    /** 
     * @return Returns the file. 
     */  
    public MultipartFile getFile() {  
        return file;  
    }  
  
    /** 
     * @param file The file to set. 
     */  
    public void setFile(MultipartFile file) {  
        this.file = file;  
    }   

}
