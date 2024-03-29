package system.utils;

import java.security.MessageDigest;

/**
 * 对密码进行加密和验证的类 
 * 
 * @author Somebody
 * @date：2009-12-29
 *
 */
public class CipherUtil {
	
	//十六进制下数字到字符的映射数组
    private final static String[] hexDigits = {"0", "1", "2", "3", "4",
        "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
	
    /**
     * 
     * @param inputString
     * @param length
     * @return
     * @author Zhao.Xiang
     */
    public static String generatePassword(String inputString,int length){
    	String pwd = generatePassword(inputString);
    	return pwd.length() < length ? pwd : pwd.substring(0,length);
    }
    
    public static String generatePassword(String inputString){
        return encodeByMD5(inputString);
    }
    
    public static boolean validatePassword(String password, String inputString,int length){
        if(password.equals(generatePassword(inputString,length))){
            return true;
        } else{
            return false;
        }
    }
    
    /**
     * 验证输入的密码是否正确
   * @param password    加密后的密码
   * @param inputString    输入的字符串
   * @return    验证结果，TRUE:正确 FALSE:错误
   */
  public static boolean validatePassword(String password, String inputString){
      if(password.equals(encodeByMD5(inputString))){
          return true;
      } else{
          return false;
      }
  }
  /**  对字符串进行MD5加密     */
  public static String encodeByMD5(String originString){
      if (originString != null){
          try{
              //创建具有指定算法名称的信息摘要
              MessageDigest md = MessageDigest.getInstance("MD5");
              //使用指定的字节数组对摘要进行最后更新，然后完成摘要计算
              byte[] results = md.digest(originString.getBytes());
              //将得到的字节数组变成字符串返回
              String resultString = byteArrayToHexString(results);
              return resultString.toLowerCase();
          } catch(Exception ex){
              ex.printStackTrace();
          }
      }
      return null;
  }
  
  /**
   * 
   * @param originString
   * @param len
   * @return
   * @author Zhao.Xiang
   */
  public static String encodeByMD5(String originString,int len){
	  String encode = encodeByMD5(originString);
	  return encode != null && !"".equals(encode) ? encode.toLowerCase().substring(0,len) : "";
  }
  /** 
   * 转换字节数组为十六进制字符串
   * @param     字节数组
   * @return    十六进制字符串
   */
  private static String byteArrayToHexString(byte[] b){
      StringBuffer resultSb = new StringBuffer();
      for (int i = 0; i < b.length; i++){
          resultSb.append(byteToHexString(b[i]));
      }
      return resultSb.toString();
  }
  
  /** 将一个字节转化成十六进制形式的字符串     */
  private static String byteToHexString(byte b){
      int n = b;
      if (n < 0)
          n = 256 + n;
      int d1 = n / 16;
      int d2 = n % 16;
      return hexDigits[d1] + hexDigits[d2];
  }
  
  public static void main(String[] args){
	  System.out.println(CipherUtil.encodeByMD5("iamsuperroot"));
  }
}
