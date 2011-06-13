package system.constants;

public class Constants {
	public static final int DaysOfSections=3;//每天3个时间段早上、下午、晚上，最小计量单位
	public static String DefaultFileUploadDir = "uploads";
	// AJAX request parameter
	public static String  DefaultAjaxParamFlag = "ajax";
	// default page size
	public static Integer DefaultPageSize  = 20;
	// default password for enterprise
	public static String DefaultStaffPassword = "123456";
	// page query parameter
	public static String  DefaultPageParamFlag = "page";
	// default editable category value
	public static Integer DefaultEditableCatVal = 1;
	
	public static String DeclarationIntroductions="1";
	
	public static String WorkPurpose="2";
	
	// file separator
	public static String FileSeparator = System.getProperty("file.separator");
	// resource of WEB-INF
	public static String RESOURCE_WEB_INF = "WEB-INF";
	
	// prefix of file resource
	public static String RESOURCE_FILE_PREFIX = "file:/";
	
	// file output path
	public static String TEMP_FILE_OUTPUT_PATH = "temp";
	
	// prefix of classpath resource
	public static String RESOURCE_CLASSPATH_PREFIX = "classpath:";
	
	public static final String BASIC_XLS_TPL_PATH = "resources/basic/tpl/xls";


}

