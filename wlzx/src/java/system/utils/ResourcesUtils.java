package system.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;

import system.constants.Constants;


/**
 * 
 * @author JeccyZhao
 *
 */
public class ResourcesUtils {
	
	/**
	 * 获取ClassPath路径
	 * @return
	 * @author JeccyZhao
	 */
	public static String getWebClassPath(){
		String classPath = ResourcesUtils.class.getResource("/").toString();
		if(classPath.indexOf(Constants.RESOURCE_FILE_PREFIX) > -1){
			classPath = classPath.substring(Constants.RESOURCE_FILE_PREFIX.length());
		}
		return classPath;
	}
	
	/**w
	 * 获取Web根路径
	 * @return
	 * @author JeccyZhao
	 */
	public static String getWebRootPath(){
		String classPath = ResourcesUtils.getWebClassPath();
		String rootPath = "";
		if(classPath.indexOf(Constants.RESOURCE_WEB_INF) > -1){
			rootPath = classPath.substring(0,classPath.indexOf(Constants.RESOURCE_WEB_INF));
		}
		return rootPath;
	}
	
	/**
	 * 
	 * @param path
	 * @return
	 * @author JeccyZhao
	 */
	public static File[] getFiles(String path){
		if(path.indexOf(Constants.RESOURCE_CLASSPATH_PREFIX) > -1){
			path = path.replaceFirst(
					Constants.RESOURCE_CLASSPATH_PREFIX, ResourcesUtils.getWebClassPath()); 
		}
		File file = new File(path);
		return file.exists() ? file.listFiles() : null;
	}
	
	/**
	 * 
	 * @param path
	 * @return
	 * @author JeccyZhao
	 */
	public static String[] getFilePaths(String path){
		if(path.indexOf(Constants.RESOURCE_CLASSPATH_PREFIX) > -1){
			path = path.replaceFirst(
					Constants.RESOURCE_CLASSPATH_PREFIX, ResourcesUtils.getWebClassPath()); 
		}
		File[] files = ResourcesUtils.getFiles(path);
		if (files != null && files.length > 0){
			String[] paths = new String[files.length];
			int count = 0;
			for(File file : files){
				paths[count++] = file.getPath();
			}
			return paths;
		}
		return null;
	}
	
	/**
	 * 
	 * @param propFilePath  format can be classpath:xxxx,etc.
	 * @return
	 * @author JeccyZhao
	 */
	public static Map<String, String> getProperties(String propFile){
		Properties props = new Properties();
		InputStream stream = null;
		try {
			if(propFile.indexOf(Constants.RESOURCE_CLASSPATH_PREFIX) > -1){
				propFile = propFile.replaceFirst(
						Constants.RESOURCE_CLASSPATH_PREFIX, ResourcesUtils.getWebClassPath()); 
			}
			stream = new FileInputStream(new File(propFile));
			props.load(stream);
			Map<String, String> propMaps = new HashMap<String, String>();
			for(Entry<Object, Object> entry : props.entrySet()){
				if(entry.getKey() != null){
					propMaps.put(entry.getKey().toString(), entry.getValue().toString());
				}
			}
			return propMaps;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(stream != null){
				try {
					stream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	public static ByteArrayOutputStream getFileStream(String filePath) throws IOException {
		ByteArrayOutputStream out = null;
		File file = new File(filePath);
		
		if (file.exists()) {

			out = new ByteArrayOutputStream();

			// -----------------------------------------------------------------
			// create buffered input and output stream
			// -----------------------------------------------------------------
			BufferedInputStream bis = null;
			BufferedOutputStream bos = null;

			try {
				bis = new BufferedInputStream(new FileInputStream(filePath));
				bos = new BufferedOutputStream(out);

				byte[] buff = new byte[2048];
				int bytesRead;

				// Simple read/write loop.
				while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
					bos.write(buff, 0, bytesRead);
				}

			} catch (final IOException e) {
				throw e;
			} finally {
				if (bis != null) {
					bis.close();
				}

				if (bos != null) {
					bos.close();
				}
			}
		}
		return out;
	}
	
	public static void main(String[] args){
		System.out.println(ResourcesUtils.getWebClassPath());
		System.out.println(ResourcesUtils.class.getResource(""));
	}
	
}
