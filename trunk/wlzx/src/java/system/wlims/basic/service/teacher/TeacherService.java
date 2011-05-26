package system.wlims.basic.service.teacher;

import system.ServiceException;
import system.wlims.basic.dao.teacher.TeacherDAO;
import system.wlims.basic.entity.teacher.TeacherModel;

public class TeacherService {

	private TeacherDAO teacherDAO;
	
	public void save()throws ServiceException{
		
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
	
}
