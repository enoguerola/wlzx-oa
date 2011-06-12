package system.wlims.basic.service.teacher;

import java.util.ArrayList;
import java.util.List;



import system.DAOException;
import system.ServiceException;
import system.dao.RoleDAO;
import system.dao.UserDAO;
import system.entity.RoleModel;
import system.entity.UserModel;
import system.utils.StringUtils;
import system.utils.TripleObject;
import system.wlims.basic.dao.teacher.TeacherDAO;
import system.wlims.basic.entity.teacher.TeacherDepartment;
import system.wlims.basic.entity.teacher.TeacherModel;

public class TeacherAccountBridgeService {

	private TeacherDAO teacherDAO;
//	private TeacherDepartmentDAO teacherDepartmentDAO;
	private UserDAO userDAO;
	private RoleDAO roleDAO;
	public Boolean save(String  positionId, String teacherId,String prePositionId)throws ServiceException{
		try {
			TeacherModel teacher = teacherDAO.get(teacherId);
			UserModel user=userDAO.get(teacher.getUserID());
			RoleModel role=roleDAO.get(positionId);	
			user.getRoles().add(role);
			if(StringUtils.isNotEmpty(prePositionId)){
				RoleModel preRole=roleDAO.get(prePositionId);	
				user.getRoles().remove(preRole);
			}
			userDAO.saveOrUpdate(user);
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public List<TeacherDepartment> get(String teacherId, int page, int pageCount)throws ServiceException{
//		DetachedCriteria criteria = DetachedCriteria.forClass(TeacherDepartment.class);
//		
//		criteria.createCriteria("teacher").add(Restrictions.eq("id", id));
//		
//		List<TeacherDepartment> list = teacherDepartmentDAO.getListByCriteria(criteria, page, pageCount);
//		for(TeacherDepartment model:list)
//			model.setTeacher(null);
//		return list;
		TeacherModel teacher = teacherDAO.get(teacherId);
		UserModel user=userDAO.get(teacher.getUserID());
		List<TeacherDepartment> list =new ArrayList<TeacherDepartment>();
		for(RoleModel role:user.getRoles()){
			TeacherDepartment td=new TeacherDepartment();
			td.setDepartmentName(role.getBelongDepartment().getName());
			td.setPositionId(role.getId());
			td.setPositionName(role.getName());
			td.setTeacherId(teacher.getId());
			td.setDepartmentId(role.getBelongDepartment().getId());
			list.add(td);
		}
		return list;
	}
	
	public void remove(String teacherId,String positionId )throws ServiceException{
//		teacherDepartmentDAO.remove(id);
		TeacherModel teacher = teacherDAO.get(teacherId);
		UserModel user=userDAO.get(teacher.getUserID());
		RoleModel role=roleDAO.get(positionId);	
		user.getRoles().remove(role);
		userDAO.saveOrUpdate(user);
	}
	public List<TripleObject<String, String,String>> teacherAccountGetAll(){
		List<TripleObject<String, String,String>> triples = new ArrayList<TripleObject<String, String,String>>();
		List<TeacherModel> teachers =teacherDAO.getTeachersByStatus(null) ;
		if(teachers != null){
			for(TeacherModel teacher : teachers){
				UserModel user=userDAO.get(teacher.getUserID());
				if(user==null) continue;
				triples.add(new TripleObject<String, String,String>(
						teacher.getName(), user.getName(),user.getId()));
			}
		}
		return triples;
	}
	public TeacherDAO getTeacherDAO() {
		return teacherDAO;
	}

	public void setTeacherDAO(TeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public RoleDAO getRoleDAO() {
		return roleDAO;
	}

	public void setRoleDAO(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}

	
}
