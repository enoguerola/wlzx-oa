package system.wlims.basic.service.teacher;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

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
	
	public List<TeacherRelation> get(String id, int page, int pageCount)throws ServiceException{
		DetachedCriteria criteria = DetachedCriteria.forClass(TeacherRelation.class);
		
		criteria.createCriteria("teacher").add(Restrictions.eq("id", id));
		
		List<TeacherRelation> list = teacherRelationDAO.getListByCriteria(criteria, page, pageCount);
		for(TeacherRelation model:list)
			model.setTeacher(null);
		return list;
	}
	
	public void remove(String id)throws ServiceException{
		teacherRelationDAO.remove(id);
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
