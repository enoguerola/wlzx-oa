package system.wlims.basic.service.teacher;

import java.util.List;

import system.ServiceException;

import system.wlims.basic.entity.teacher.TeacherModel;

public interface TeacherService {

	public TeacherModel save(TeacherModel model)throws ServiceException;
	
	public List<TeacherModel> getTeacherModels(TeacherModel model)throws ServiceException;
	public void changeStatus(String id, int status)throws ServiceException;
	
    public void remove(String id)throws ServiceException;
    
    public Boolean valideNo(String no)throws ServiceException;
    public TeacherModel get(String id)throws ServiceException;
    public String getTeacherNameByUserId(String userId);
	
}
