package system.wlims.basic.dao.teacher;

import system.BaseDAOImpl;
import system.DAOException;
import system.wlims.basic.entity.teacher.TeacherDepartment;

public class TeacherDepartmentDAO extends BaseDAOImpl<TeacherDepartment> {

	public void remove(String id)throws DAOException{
		String hql = "delete from TeacherDepartment where id=" + id;
		execUpdateByHSQL(hql);
	}
}
