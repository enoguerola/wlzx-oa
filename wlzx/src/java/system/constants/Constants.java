package system.constants;

public class Constants {
	public static final int DaysOfSections=2;//每天2个时间段早上、下午，最小计量单位
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
	public static  String TEMP_SWF_OUTPUT_PATH = "swf";

	
	// prefix of classpath resource
	public static String RESOURCE_CLASSPATH_PREFIX = "classpath:";
	
	public static final String BASIC_XLS_TPL_PATH = "resources/basic/tpl/xls";
	public static final String OA_XLS_TPL_PATH = "resources/oa/tpl/xls";
	
	//error code
	public static final String NONE_ERROR = "0";
	public static final String DAO_ERROR = "4";
	public static final String FIELD_NONE_ERROR = "5";
	public static final String FIELD_FORMATE_ERROR = "6";


}

