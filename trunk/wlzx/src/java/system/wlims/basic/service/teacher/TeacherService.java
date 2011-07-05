package system.wlims.basic.service.teacher;

import java.sql.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import system.ServiceException;
import system.dao.DepartmentDAO;
import system.dao.RoleDAO;
import system.dao.UserDAO;
import system.entity.DepartmentModel;
import system.entity.RoleModel;
import system.entity.UserModel;
import system.entity.PersonModel.PersonStyle;
import system.utils.CipherUtil;
import system.utils.StringUtils;
import system.utils.UtilDateTime;
import system.wlims.basic.dao.teacher.TeacherDAO;
import system.wlims.basic.entity.teacher.TeacherModel;

public class TeacherService {

	private TeacherDAO teacherDAO;
	private UserDAO userDAO;
	private RoleDAO roleDAO;
	private DepartmentDAO departmentDAO;
	/**
	 * 
	 * @param model
	 * @return
	 * @throws ServiceException
	 */
	public TeacherModel save(TeacherModel model)throws ServiceException{
		if(model.getCreationDate() == null)
			model.setCreationDate(Date.valueOf(UtilDateTime.nowDateString()));
		
		model.setModifiedDate(Date.valueOf(UtilDateTime.nowDateString()));
		
		if(model.getStyle() == null)
			model.setStyle(PersonStyle.Teacher.getStyle());
		
		if(StringUtils.isEmpty(model.getId())){
			//validate no
			List<UserModel> userList = userDAO.getUsersByCondition(model.getTeacherNo(), null);
			if(userList != null && userList.size() > 0){
				model.setTeacherNo("");
				return model;
			}
			//save user
			UserModel user = new UserModel();
			user.setActive(true);
			user.setCreationDate(UtilDateTime.nowDate());
			user.setEmail(model.getTeacherMail());
			user.setLastLoginIP("");
			user.setLastLoginTime(null);
			user.setModifiedDate(null);
			user.setName(model.getTeacherNo());
			user.setPwd(CipherUtil.encodeByMD5(user.getName()));
			user.setSequence(0);
			user.setSymbol(user.getName());
			//初始角色部门初始化，若不存在则置空
			if(!StringUtils.isEmpty(model.getTeacherPositionName())){
				RoleModel role = roleDAO.getRoleByName(model.getTeacherPositionName());
				if(role!=null){
					user.setMainRole(role);
					model.setTeacherPosition(role.getId());
					if(role.getBelongDepartment()!=null){
						user.setMainDepartment(role.getBelongDepartment());
						model.setTeacherDepartment(role.getBelongDepartment().getId());
					}
				}
			}else{
				if(!StringUtils.isEmpty(model.getTeacherPosition())){
					RoleModel role = roleDAO.get(model.getTeacherPosition());
					if(role!=null){
						user.setMainRole(role);
						model.setTeacherPosition(role.getId());
						if(role.getBelongDepartment()!=null){
							user.setMainDepartment(role.getBelongDepartment());
							model.setTeacherDepartment(role.getBelongDepartment().getId());
						}
					}else model.setTeacherPosition(null); 
				}else{
					user.setMainRole(null);
					model.setTeacherPosition(null);
					if(!StringUtils.isEmpty(model.getTeacherDepartmentName())){
						DepartmentModel department=departmentDAO.getDepartmentByName(model.getTeacherDepartmentName());
						if(department!=null){
							user.setMainDepartment(department);
							model.setTeacherDepartment(department.getId());
						}
					}else if(!StringUtils.isEmpty(model.getTeacherDepartment())){
						DepartmentModel department=departmentDAO.get(model.getTeacherDepartment());
						if(department!=null){
							user.setMainDepartment(department);
							model.setTeacherDepartment(department.getId());
						}
					}
				}
			}
			
			userDAO.saveOrUpdate(user);
			model.setUserID(user.getId());
			teacherDAO.saveOrUpdate(model);
		}else{
			UserModel user=userDAO.get(model.getUserID());
			//初始角色部门初始化，若不存在则置空
			if(!StringUtils.isEmpty(model.getTeacherPosition())){
				RoleModel role = roleDAO.get(model.getTeacherPosition());
				if(role!=null){
					user.setMainRole(role);
					model.setTeacherPosition(role.getId());
					if(role.getBelongDepartment()!=null){
						user.setMainDepartment(role.getBelongDepartment());
						model.setTeacherDepartment(role.getBelongDepartment().getId());
					}
				}else model.setTeacherPosition(null); 
			}else{
				model.setTeacherPosition(null);
				if(!StringUtils.isEmpty(model.getTeacherDepartment())){
					DepartmentModel department=departmentDAO.get(model.getTeacherDepartment());
					if(department!=null){
						user.setMainDepartment(department);
						model.setTeacherDepartment(department.getId());
					}
					else model.setTeacherDepartment(null);
				}else model.setTeacherDepartment(null);
			}
			userDAO.saveOrUpdate(user);
			teacherDAO.saveOrUpdate(model);
		}
		
		return model;
	}
	
	@SuppressWarnings("unchecked")
	public List<TeacherModel> getTeacherModels(TeacherModel model, int page, int pageCount)throws ServiceException{
		DetachedCriteria criteria = DetachedCriteria.forClass(TeacherModel.class);
		
		if(model != null){
			
			if(StringUtils.isNotEmpty(model.getName()))
				criteria.add(Restrictions.like("name", model.getName()));
			
			if(StringUtils.isNotEmpty(model.getTeacherDepartment()))
				criteria.add(Restrictions.eq("teacherDepartment", model.getTeacherDepartment()));
				
			if(model.getTeacherAttendDate() != null)
				criteria.add(Restrictions.eq("teacherAttendDate", model.getTeacherAttendDate()));
			
			System.out.println(model.getTeacherStatus());
			
			if(model.getTeacherStatus() != null && model.getTeacherStatus() > -1)
				criteria.add(Restrictions.eq("teacherStatus", model.getTeacherStatus()));
				
		}else{
			
		}
		
		int startIndex = (page - 1) * pageCount;
		
//		List<TeacherModel> list =  teacherDAO.getListByCriteria(criteria, startIndex, pageCount);
		List<TeacherModel> list =  teacherDAO.getListByCriteria(criteria);
		for(TeacherModel teacher : list){
//			UserModel user = userDAO.getUserByUserAccount(teacher.getTeacherNo());
//			teacher.setTeacherDepartmentName(user.getMainDepartment()==null?"未指定":user.getMainDepartment().getName());
//			teacher.setTeacherPositionName(user.getMainRole()==null?"未指定":user.getMainRole().getName());
//			teacher.setTeacherDepartment(user.getMainDepartment()==null?null:user.getMainDepartment().getId());
//			teacher.setTeacherPosition(user.getMainRole()==null?null:user.getMainRole().getId());
			teacher.setExperiences(null);
			teacher.setOtherDepartments(null);
			teacher.setRelations(null);
		}
		return list;
		
	}
	
	public void changeStatus(String id, int status)throws ServiceException{
		String hql = "update TeacherModel set teacherStatus=" + status + " where id=" + id;
		teacherDAO.execUpdateByHSQL(hql);
	}
	
    public void remove(String id)throws ServiceException{
    	TeacherModel model = teacherDAO.get(id);
		teacherDAO.remove(model);
		UserModel user=userDAO.get(model.getUserID());
    	userDAO.remove(user);
	}
    
    public Boolean valideNo(String no)throws ServiceException{
    	List<UserModel> userList = userDAO.getUsersByCondition(no, null);
		if(userList != null && userList.size() > 0){
			return false;
		}else
			return true;
    }
    
    /**
     * 
     * @param id
     * @return
     * @throws ServiceException
     */
    public TeacherModel get(String id)throws ServiceException{
    	TeacherModel teacher = teacherDAO.get(id);
    	teacher.setExperiences(null);
		teacher.setOtherDepartments(null);
		teacher.setRelations(null);
		//从user对象里取得部门与职务信息
		if(teacher!=null){
			UserModel user=userDAO.get(teacher.getUserID());
			if(user!=null){
				RoleModel role=user.getMainRole();
				if(role!=null){
					teacher.setTeacherPosition(role.getId());
					teacher.setTeacherPositionName(role.getName());
					DepartmentModel department=role.getBelongDepartment();
					if(department!=null){
						teacher.setTeacherDepartment(department.getId());
						teacher.setTeacherDepartmentName(department.getName());
					}
				}else{
					DepartmentModel department=user.getMainDepartment();
					if(department!=null){
						teacher.setTeacherDepartment(department.getId());
						teacher.setTeacherDepartmentName(department.getName());
					}
				}
				
			}
		}
    	return teacher;
    }

	public void setTeacherDAO(TeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}

	public TeacherDAO getTeacherDAO() {
		return teacherDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public RoleDAO getRoleDAO() {
		return roleDAO;
	}

	public void setRoleDAO(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}

	public DepartmentDAO getDepartmentDAO() {
		return departmentDAO;
	}

	public void setDepartmentDAO(DepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}
	
}
