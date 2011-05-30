package system.wlims.basic.service.teacher;

import java.sql.Date;

import system.ServiceException;
import system.dao.UserDAO;
import system.entity.UserModel;
import system.entity.PersonModel.PersonStyle;
import system.utils.CipherUtil;
import system.utils.StringUtils;
import system.utils.UtilDateTime;
import system.wlims.basic.dao.teacher.TeacherDAO;
import system.wlims.basic.entity.teacher.TeacherModel;

public class TeacherService {

	private TeacherDAO teacherDAO;
	private UserDAO userDAO;
	
	public TeacherModel save(TeacherModel model)throws ServiceException{
		if(model.getCreationDate() != null)
			model.setCreationDate(Date.valueOf(UtilDateTime.nowDateString()));
		
		model.setModifiedDate(Date.valueOf(UtilDateTime.nowDateString()));
		
		if(model.getStyle() == null)
			model.setStyle(PersonStyle.Teacher.getStyle());
		
		if(StringUtils.isEmpty(model.getId())){
			//save user
			UserModel user = new UserModel();
			user.setActive(true);
			user.setCreationDate(UtilDateTime.nowDate());
			user.setEmail(model.getTeacherMail());
			user.setLastLoginIP("");
			user.setLastLoginTime(null);
			user.setModifiedDate(null);
			user.setName(model.getTeacherNo());
			user.setPwd(CipherUtil.encodeByMD5(user.getName()));
			user.setSequence(2190);
			user.setSymbol("");
			userDAO.saveOrUpdate(user);
			System.out.println(user.getId());
			model.setUser(user);
			teacherDAO.saveOrUpdate(model);
		}else{
			teacherDAO.saveOrUpdate(model);
		}
		
		return model;
	}
	
    public void remove()throws ServiceException{
		
	}
    
    public TeacherModel get(String id)throws ServiceException{
    	return teacherDAO.get(id);
    }

	public void setTeacherDAO(TeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}

	public TeacherDAO getTeacherDAO() {
		return teacherDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}
	
}
