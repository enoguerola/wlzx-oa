package system.wlims.basic.service.teacher;

import java.util.List;


import system.ServiceException;
import system.wlims.basic.dao.teacher.TeacherExperienceDAO;
import system.wlims.basic.entity.teacher.TeacherExperience;

public interface TeacherExperienceService {
	
	public int save(TeacherExperience model, String id)throws ServiceException;
	
	public List<TeacherExperience> get(String id, int page, int pageCount)throws ServiceException;
	
	public void remove(String id)throws ServiceException;

	public void setTeacherExperienceDAO(TeacherExperienceDAO teacherExperienceDAO) ;



}
