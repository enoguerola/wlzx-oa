package system.wlims.basic.serviceImpl.teacher;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import system.DAOException;
import system.ServiceException;
import system.wlims.basic.dao.teacher.TeacherDAO;
import system.wlims.basic.dao.teacher.TeacherExperienceDAO;
import system.wlims.basic.entity.teacher.TeacherExperience;
import system.wlims.basic.entity.teacher.TeacherModel;
import system.wlims.basic.service.teacher.TeacherExperienceService;

public class TeacherExperienceServiceImpl  implements TeacherExperienceService{
	
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
	
	public List<TeacherExperience> get(String id, int page, int pageCount)throws ServiceException{
		DetachedCriteria criteria = DetachedCriteria.forClass(TeacherExperience.class);
		
		criteria.createCriteria("teacher").add(Restrictions.eq("id", id));
		
		List<TeacherExperience> list = teacherExperienceDAO.getListByCriteria(criteria, (page - 1)*pageCount, pageCount);
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
