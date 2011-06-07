package system.wlims.basic.service.teacher;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import system.DAOException;
import system.ServiceException;
import system.wlims.basic.dao.teacher.TeacherDAO;
import system.wlims.basic.dao.teacher.TeacherDepartmentDAO;
import system.wlims.basic.entity.teacher.TeacherDepartment;
import system.wlims.basic.entity.teacher.TeacherModel;

public class TeacherDepartmentService {

	private TeacherDAO teacherDAO;
	private TeacherDepartmentDAO teacherDepartmentDAO;
	
	public TeacherDepartment save(TeacherDepartment model, String id)throws ServiceException{
		try {
			TeacherModel teacher = teacherDAO.get(id);
			model.setTeacher(teacher);
			teacherDepartmentDAO.saveOrUpdate(model);
			model.setTeacher(null);
			return model;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public List<TeacherDepartment> get(String id, int page, int pageCount)throws ServiceException{
		DetachedCriteria criteria = DetachedCriteria.forClass(TeacherDepartment.class);
		
		criteria.createCriteria("teacher").add(Restrictions.eq("id", id));
		
		List<TeacherDepartment> list = teacherDepartmentDAO.getListByCriteria(criteria, page, pageCount);
		System.out.println(list.size());
		System.out.println(id);
		for(TeacherDepartment model:list)
			model.setTeacher(null);
		return list;
	}
	
	public void remove(String id)throws ServiceException{
		teacherDepartmentDAO.remove(id);
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
