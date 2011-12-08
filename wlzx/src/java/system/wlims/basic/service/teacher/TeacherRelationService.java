package system.wlims.basic.service.teacher;

import java.util.List;


import system.ServiceException;

import system.wlims.basic.entity.teacher.TeacherRelation;

public interface TeacherRelationService {

	public int save(TeacherRelation model, String id)throws ServiceException;
	
	public List<TeacherRelation> get(String id, int page, int pageCount)throws ServiceException;
	
	public void remove(String id)throws ServiceException;
	
	
}
