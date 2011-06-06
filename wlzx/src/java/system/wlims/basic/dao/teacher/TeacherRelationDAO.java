package system.wlims.basic.dao.teacher;

import system.BaseDAOImpl;
import system.DAOException;
import system.wlims.basic.entity.teacher.TeacherRelation;

public class TeacherRelationDAO extends BaseDAOImpl<TeacherRelation> {

	public void remove(String id)throws DAOException{
		String hql = "delete from TeacherRelation where id=" + id;
		execUpdateByHSQL(hql);
	}
	
}
