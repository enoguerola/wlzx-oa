package system.components;


import org.springframework.security.core.context.SecurityContextHolder;

import system.entity.PersonModel;
import system.entity.RoleModel;
import system.entity.UserModel;
import system.utils.CipherUtil;
import system.utils.StringUtils;
import system.wlims.basic.dao.teacher.TeacherDAO;
import system.wlims.basic.entity.teacher.TeacherModel;


public class SecurityUserHolder {
	
	private static TeacherDAO teacherDAO;
	/**
	 * 获取当前系统登录用户信息
	 * @return
	 */
	public static UserModel getCurrentUser(){
		UserModel user=null;
		try{
			if( SecurityContextHolder.getContext().getAuthentication()!=null)
			 user= (UserModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if(user.getAccountStyle()==PersonModel.PersonStyle.Teacher.getStyle()){
				TeacherModel teacher=teacherDAO.getTeacherByUserId(user.getId());
				/**针对BlazeDS不支持延迟加载的临时解决方案*/
				teacher.setExperiences(null);
				teacher.setRelations(null);
				teacher.setOtherDepartments(null);
				user.setPerson(teacher);
			}
			 
			return user;
		}catch(Exception e){
			return null;
		}
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
		superModel.setId("-1");
		superModel.setName(WlzxUserDetailsService.superUserName);
		superModel.setPwd(WlzxUserDetailsService.superUserPwd);
		superModel.getRoles().add(getSuperRootRoleModel());
		return superModel;
	}
	public static RoleModel getSuperRootRoleModel(){
		RoleModel superModel = new RoleModel();
		superModel.setId("-1");
		superModel.setName(WlzxUserDetailsService.superUserRole);
		superModel.setSymbol(WlzxUserDetailsService.superUserRole);
		return superModel;
	}

	public TeacherDAO getTeacherDAO() {
		return teacherDAO;
	}

	public void setTeacherDAO(TeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}
}
