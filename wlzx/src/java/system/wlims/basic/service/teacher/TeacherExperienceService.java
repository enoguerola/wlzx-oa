package system.wlims.basic.service.teacher;

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
