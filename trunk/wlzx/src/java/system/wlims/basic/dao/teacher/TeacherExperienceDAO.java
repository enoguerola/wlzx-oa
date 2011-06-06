package system.wlims.basic.dao.teacher;

import system.BaseDAOImpl;
import system.DAOException;
import system.wlims.basic.entity.teacher.TeacherExperience;

public class TeacherExperienceDAO extends BaseDAOImpl<TeacherExperience> {

	public void remove(String id)throws DAOException{
		String hql = "delete from TeacherExperience where id=" + id;
		execUpdateByHSQL(hql);
	}
}
