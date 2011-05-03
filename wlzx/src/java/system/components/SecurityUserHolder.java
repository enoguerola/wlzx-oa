package system.components;

import org.springframework.security.core.context.SecurityContextHolder;

import system.entity.UserModel;
import system.utils.CipherUtil;
import system.utils.StringUtils;


public class SecurityUserHolder {
	
	
	/**
	 * 获取当前系统登录用户信息
	 * @return
	 */
	public static UserModel getCurrentUser(){
		UserModel user = (UserModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(user!=null)return user;
		else return getSuperRootUserModel();
	}
	public static boolean isSuperRootUser(){
		return isSuperRootUser(SecurityUserHolder.getCurrentUser().getName());
	}
	
	public static boolean isSuperRootUser(String userName){
		return isSuperRootUser(userName,null);
	}
	
	public static boolean isSuperRootUser(String userName, String pwd){
		boolean result = userName.equals(WlzxUserDetailsService.superUserName);
		if(pwd != null && StringUtils.isNotEmpty(pwd)){
			result = WlzxUserDetailsService.superUserPwd.equals(CipherUtil.encodeByMD5(pwd));
		}
		return result;
	}
	
	public static UserModel getSuperRootUserModel(){
		UserModel superModel = new UserModel();
		superModel.setName(WlzxUserDetailsService.superUserName);
		superModel.setPwd(WlzxUserDetailsService.superUserPwd);
		return superModel;
	}
}
