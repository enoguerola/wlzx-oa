package system.wlims.basic.service.teacher;

import java.util.List;




import system.ServiceException;

import system.utils.TripleObject;

import system.wlims.basic.entity.teacher.TeacherDepartment;
import system.wlims.basic.vo.UserAddressVo;

public interface TeacherAccountBridgeService {

	public Boolean save(String departmentId,String  positionId, String teacherId,String preDepartmentId,String prePositionId)throws ServiceException;
	
	public List<TeacherDepartment> get(String teacherId, int page, int pageCount)throws ServiceException;
	
	public void remove(String teacherId,String departmentId,String positionId )throws ServiceException;
	public TripleObject getTeacherById(String userId);
	public List<TripleObject<String, String,String>> teacherAccountGetAll();
	public List<TripleObject<String, String,String>> getUsersByCondition(String userId,String departmentId,String roleId);
	//获得未授权用户
	public List<TripleObject<String, String,String>>  getUnAuthUsers();
	public List<UserAddressVo> getUserAddressesByConditions(String departmentId,String userId);
	

	
}
