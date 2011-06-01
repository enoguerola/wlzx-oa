package system.wlims.basic.service.teacher;

import system.DAOException;
import system.ServiceException;
import system.wlims.basic.dao.teacher.TeacherDAO;
import system.wlims.basic.dao.teacher.TeacherDepartmentDAO;
import system.wlims.basic.entity.teacher.TeacherDepartment;
import system.wlims.basic.entity.teacher.TeacherModel;

public class TeacherDepartmentService {

	private TeacherDAO teacherDAO;
	private TeacherDepartmentDAO teacherDepartmentDAO;
	
	public int save(TeacherDepartment model, String id)throws ServiceException{
		try {
			TeacherModel teacher = teacherDAO.get(id);
			model.setTeacher(teacher);
			teacherDepartmentDAO.saveOrUpdate(model);
			return 1;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	public TeacherDAO getTeacherDAO() {
		return teacherDAO;
	}

	public void setTeacherDAO(TeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}

	public TeacherDepartmentDAO getTeacherDepartmentDAO() {
		return teacherDepartmentDAO;
	}

	public void setTeacherDepartmentDAO(TeacherDepartmentDAO teacherDepartmentDAO) {
		this.teacherDepartmentDAO = teacherDepartmentDAO;
	}
}
