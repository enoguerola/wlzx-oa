package system.wlims.basic.service.teacher;

import system.DAOException;
import system.ServiceException;
import system.wlims.basic.dao.teacher.TeacherDAO;
import system.wlims.basic.dao.teacher.TeacherRelationDAO;
import system.wlims.basic.entity.teacher.TeacherModel;
import system.wlims.basic.entity.teacher.TeacherRelation;

public class TeacherRelationService {

	private TeacherDAO teacherDAO;
	private TeacherRelationDAO teacherRelationDAO;
	
	public int save(TeacherRelation model, String id)throws ServiceException{
		try {
			TeacherModel teacher = teacherDAO.get(id);
			model.setTeacher(teacher);
			teacherRelationDAO.saveOrUpdate(model);
			return 1;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	public void setTeacherDAO(TeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}
	public TeacherDAO getTeacherDAO() {
		return teacherDAO;
	}
	public void setTeacherRelationDAO(TeacherRelationDAO teacherRelationDAO) {
		this.teacherRelationDAO = teacherRelationDAO;
	}
	public TeacherRelationDAO getTeacherRelationDAO() {
		return teacherRelationDAO;
	}
	
	
}
