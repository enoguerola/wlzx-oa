package system.wlims.basic.service.teacher;

import java.sql.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import system.ServiceException;
import system.constants.Constants;
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
	
	/**
	 * 
	 * @param model
	 * @return
	 * @throws ServiceException
	 */
	public TeacherModel save(TeacherModel model)throws ServiceException{
		if(model.getCreationDate() == null)
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
			user.setSequence(0);
			user.setSymbol(user.getName());
			userDAO.saveOrUpdate(user);
			model.setUserID(user.getId());
			teacherDAO.saveOrUpdate(model);
		}else{
			teacherDAO.saveOrUpdate(model);
		}
		
		return model;
	}
	
	@SuppressWarnings("unchecked")
	public List<TeacherModel> getTeacherModels(TeacherModel model, int page, int pageCount)throws ServiceException{
		DetachedCriteria criteria = DetachedCriteria.forClass(TeacherModel.class);
		
		if(model != null){
			
			if(StringUtils.isNotEmpty(model.getName()))
				criteria.add(Restrictions.like("name", model.getName()));
			
			if(StringUtils.isNotEmpty(model.getTeacherDepartment()))
				criteria.add(Restrictions.eq("teacherDepartment", model.getTeacherDepartment()));
				
			if(model.getTeacherAttendDate() != null)
				criteria.add(Restrictions.eq("teacherAttendDate", model.getTeacherAttendDate()));
			
			if(model.getTeacherStatus() != null)
				criteria.add(Restrictions.eq("teacherStatus", model.getTeacherStatus()));
				
		}else{
			
		}
		
		int startIndex = (page - 1) * pageCount;
		
		List<TeacherModel> list =  teacherDAO.getListByCriteria(criteria, startIndex, pageCount);
		for(TeacherModel teacher : list){
			teacher.setExperiences(null);
			teacher.setOtherDepartments(null);
			teacher.setRelations(null);
		}
		return list;
		
	}
	
	public void changeStatus(String id, int status)throws ServiceException{
		String hql = "update TeacherModel set teacherStatus=" + status + " where id=" + id;
		teacherDAO.execUpdateByHSQL(hql);
	}
	
    public void remove(String id)throws ServiceException{
		teacherDAO.remove(id);
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
