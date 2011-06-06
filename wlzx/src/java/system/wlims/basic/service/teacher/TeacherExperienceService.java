package system.wlims.basic.service.teacher;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import system.DAOException;
import system.ServiceException;
import system.wlims.basic.dao.teacher.TeacherDAO;
import system.wlims.basic.dao.teacher.TeacherExperienceDAO;
import system.wlims.basic.entity.teacher.TeacherExperience;
import system.wlims.basic.entity.teacher.TeacherModel;

public class TeacherExperienceService {
	
	private TeacherExperienceDAO teacherExperienceDAO;
	private TeacherDAO teacherDAO;
	
	public int save(TeacherExperience model, String id)throws ServiceException{
		try {
			TeacherModel teacher = teacherDAO.get(id);
			model.setTeacher(teacher);
			teacherExperienceDAO.saveOrUpdate(model);
			return 1;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	public List<TeacherExperience> get(int pageCount)throws ServiceException{
		DetachedCriteria criteria = DetachedCriteria.forClass(TeacherExperience.class);
		List<TeacherExperience> list = teacherExperienceDAO.getListByCriteria(criteria, 0, pageCount);
		for(TeacherExperience model:list)
			model.setTeacher(null);
		return list;
	}
	
	public void remove(String id)throws ServiceException{
		teacherExperienceDAO.remove(id);
	}

	public void setTeacherExperienceDAO(TeacherExperienceDAO teacherExperienceDAO) {
		this.teacherExperienceDAO = teacherExperienceDAO;
	}

	public TeacherExperienceDAO getTeacherExperienceDAO() {
		return teacherExperienceDAO;
	}

	public void setTeacherDAO(TeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}

	public TeacherDAO getTeacherDAO() {
		return teacherDAO;
	}

}
