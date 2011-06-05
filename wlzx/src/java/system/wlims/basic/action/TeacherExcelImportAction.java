package system.wlims.basic.action;

import java.io.FileOutputStream;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/image") 
public class TeacherExcelImportAction {
	TeacherExcelImportAction(){
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}

	public class ImageController {
	    @RequestMapping("/imageUpload")   
	    public String processImageUpload(
	    		@RequestParam() MultipartFile file    // 关键就是这句话起了作用
	    		) throws Exception {
        if (!file.isEmpty()) {
            byte[] bytes = file.getBytes();
            FileOutputStream fos = new FileOutputStream("d:/upload/"+file.getOriginalFilename()); // 上传到写死的上传路径
            fos.write(bytes);  //写入文件
          } 
        System.out.println ("name: "+file.getOriginalFilename()+"  size: "+file.getSize() );  // 打印文件大小和文件名称
         return "redirect:/image";   // 跳转你所指定的页面名称
        }
	} 
	
}
