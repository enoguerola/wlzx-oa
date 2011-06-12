package system.wlims.basic.dao.teacher;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import system.BaseDAOImpl;
import system.DAOException;
import system.utils.StringUtils;
import system.wlims.basic.entity.teacher.TeacherModel;

public class TeacherDAO extends BaseDAOImpl<TeacherModel>{

	public void remove(String id)throws DAOException{
		String hql = "delete from TeacherModel where id=" + id;
		execUpdateByHSQL(hql);
	}
	@SuppressWarnings("unchecked")
	public TeacherModel getTeacherByUserId(String userId) throws DAOException{
		if (StringUtils.isNotEmpty(userId)) {
			DetachedCriteria criteria = DetachedCriteria.forClass(TeacherModel.class);
			criteria.add(Restrictions.sqlRestriction("user_id='"+userId+"'"));
			List<TeacherModel> result = this.getListByCriteria(criteria);
			return result != null && result.size() > 0 ? result.get(0) : null;
		}
		return null;
	}
	@SuppressWarnings("unchecked")
	public List<TeacherModel> getTeachersByStatus(String states) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(TeacherModel.class);
		if (StringUtils.isNotEmpty(states)) {
			criteria.add(Restrictions.sqlRestriction("teacher_status  in("+states+")"));
		}
		List<TeacherModel> result = this.getListByCriteria(criteria);
		return result;
	}
}
