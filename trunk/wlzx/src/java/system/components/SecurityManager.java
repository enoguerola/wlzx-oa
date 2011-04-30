package system.components;

import java.util.Map;

public interface SecurityManager {
	
	public static final String unAuthUserRole = "UNAUTH_ROLE";
	
	public static final String superUserName = "super_root";
	public static final String superUserPwd = "134bca5421a15476a1e5ebaebdba1ede";
	public static final String superUserRole = "ROLE_SUPER_ROOT";
	
	public static final String cookieUserNameKey = "__moau";
	public static final String cookieUserPwdKey = "__moas";
	public static final String cookieRememberPwdKey = "__moarmp";
	public static final String cookiePwdDefaultAlgorithm = "Base64";
	
	public Map<String, String> loadUrlAuthorities();

}
