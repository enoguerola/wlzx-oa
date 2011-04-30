package system.components.support;

import org.springframework.security.core.context.SecurityContextHolder;

import system.components.SecurityManager;
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
		boolean result = userName.equals(SecurityManager.superUserName);
		if(pwd != null && StringUtils.isNotEmpty(pwd)){
			result = SecurityManager.superUserPwd.equals(CipherUtil.encodeByMD5(pwd));
		}
		return result;
	}
	
	public static UserModel getSuperRootUserModel(){
		UserModel superModel = new UserModel();
		superModel.setName(SecurityManager.superUserName);
		superModel.setPwd(SecurityManager.superUserPwd);
		return superModel;
	}
}
