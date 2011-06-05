package system.wlims.basic.dao.teacher;

import system.BaseDAOImpl;
import system.DAOException;
import system.wlims.basic.entity.teacher.TeacherModel;

public class TeacherDAO extends BaseDAOImpl<TeacherModel>{

	public void remove(String id)throws DAOException{
		String hql = "delete from TeacherModel where id=" + id;
		execUpdateByHSQL(hql);
	}
}
