package system.wlims.basic.serviceImpl.teacher;

import java.sql.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.security.core.context.SecurityContextHolder;

import system.PaginationSupport;
import system.ServiceException;
import system.dao.DRDAO;
import system.dao.DepartmentDAO;
import system.dao.RoleDAO;
import system.dao.UserDAO;
import system.entity.DRModel;
import system.entity.DepartmentModel;
import system.entity.RoleModel;
import system.entity.UserModel;
import system.entity.PersonModel.PersonStyle;
import system.utils.CipherUtil;
import system.utils.StringUtils;
import system.utils.UtilDateTime;
import system.wlims.basic.dao.teacher.TeacherDAO;
import system.wlims.basic.entity.teacher.TeacherModel;
import system.wlims.basic.service.teacher.TeacherService;

public class TeacherServiceImpl implements TeacherService{

	private TeacherDAO teacherDAO;
	private UserDAO userDAO;
	private RoleDAO roleDAO;
	private DepartmentDAO departmentDAO;
	private DRDAO drDAO;
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
			DRModel dr=drDAO.getDRByDepartmentIdAndRoleId(model.getTeacherDepartment(), model.getTeacherPosition());
			if(dr==null){
				dr=new DRModel();
				dr.setDepartmentId(model.getTeacherDepartment());
				dr.setRoleId(model.getTeacherPosition());
			}
			user.setMainDR(dr);
			//初始角色部门初始化，若不存在则置空
//			if(!StringUtils.isEmpty(model.getTeacherPositionName())){
//				RoleModel role = roleDAO.getRoleByName(model.getTeacherPositionName());
//				if(role!=null){
//					user.setMainRole(role);
//					model.setTeacherPosition(role.getId());
//
//				}
//			}
//			if(!StringUtils.isEmpty(model.getTeacherDepartmentName())){
//				DepartmentModel department=departmentDAO.getDepartmentByName(model.getTeacherDepartmentName());
//				if(department!=null){
//					user.setMainDepartment(department);
//					model.setTeacherDepartment(department.getId());
//				}
//			}
			
			userDAO.saveOrUpdate(user);
			model.setUserID(user.getId());
			teacherDAO.saveOrUpdate(model);
		}else{
			UserModel user=userDAO.get(model.getUserID());
			DRModel dr=drDAO.getDRByDepartmentIdAndRoleId(model.getTeacherDepartment(), model.getTeacherPosition());
			if(dr==null){
				dr=new DRModel();
				dr.setDepartmentId(model.getTeacherDepartment());
				dr.setRoleId(model.getTeacherPosition());
				drDAO.saveOrUpdate(dr);
			}
			user.setMainDR(dr);
			//初始角色部门初始化，若不存在则置空
//			if(!StringUtils.isEmpty(model.getTeacherPositionName())){
//				RoleModel role = roleDAO.getRoleByName(model.getTeacherPositionName());
//				if(role!=null){
//					user.setMainRole(role);
//					model.setTeacherPosition(role.getId());
//
//				}
//			}
//			if(!StringUtils.isEmpty(model.getTeacherDepartmentName())){
//				DepartmentModel department=departmentDAO.getDepartmentByName(model.getTeacherDepartmentName());
//				if(department!=null){
//					user.setMainDepartment(department);
//					model.setTeacherDepartment(department.getId());
//				}
//			}
			userDAO.saveOrUpdate(user);
			teacherDAO.saveOrUpdate(model);
		}
		
		return model;
	}
	
	@SuppressWarnings("unchecked")
	public List<TeacherModel> getTeacherModels(TeacherModel model)throws ServiceException{
		DetachedCriteria criteria = DetachedCriteria.forClass(TeacherModel.class);
		
		if(model != null){
			
			if(StringUtils.isNotEmpty(model.getName()))
				criteria.add(Restrictions.like("name", model.getName()));
			
			if(StringUtils.isNotEmpty(model.getTeacherDepartment()))
				criteria.add(Restrictions.eq("teacherDepartment", model.getTeacherDepartment()));
				
			if(model.getTeacherAttendDate() != null)
				criteria.add(Restrictions.eq("teacherAttendDate", model.getTeacherAttendDate()));
			
			 //System.out.println(model.getTeacherStatus());
			
			if(model.getTeacherStatus() != null && model.getTeacherStatus() > -1)
				criteria.add(Restrictions.eq("teacherStatus", model.getTeacherStatus()));
				
		}else{
			
		}
		
//		List<TeacherModel> list =  teacherDAO.getListByCriteria(criteria, startIndex, pageCount);
		List<TeacherModel> list =  teacherDAO.getListByCriteria(criteria);
//		for(TeacherModel teacher : list){
//			UserModel user = userDAO.getUserByUserAccount(teacher.getTeacherNo());
//			teacher.setTeacherDepartmentName(user.getMainDepartment()==null?"未指定":user.getMainDepartment().getName());
//			teacher.setTeacherPositionName(user.getMainRole()==null?"未指定":user.getMainRole().getName());
//			teacher.setTeacherDepartment(user.getMainDepartment()==null?null:user.getMainDepartment().getId());
//			teacher.setTeacherPosition(user.getMainRole()==null?null:user.getMainRole().getId());
//			teacher.setExperiences(null);
//			teacher.setOtherDepartments(null);
//			teacher.setRelations(null);
//		}
		return list;
		
	}
	public PaginationSupport<TeacherModel> getTeacherModels(TeacherModel model, int index,int pageSize)throws ServiceException{
		DetachedCriteria criteria = DetachedCriteria.forClass(TeacherModel.class);
		
		if(model != null){
			
			if(StringUtils.isNotEmpty(model.getName()))
				criteria.add(Restrictions.like("name", model.getName()));
			
			if(StringUtils.isNotEmpty(model.getTeacherDepartment()))
				criteria.add(Restrictions.eq("teacherDepartment", model.getTeacherDepartment()));
				
			if(model.getTeacherAttendDate() != null)
				criteria.add(Restrictions.eq("teacherAttendDate", model.getTeacherAttendDate()));
			
			 //System.out.println(model.getTeacherStatus());
			
			if(model.getTeacherStatus() != null && model.getTeacherStatus() > -1)
				criteria.add(Restrictions.eq("teacherStatus", model.getTeacherStatus()));
				
		}
		
		return teacherDAO.findPageByCriteria(criteria, pageSize, index);
		
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
    	TeacherModel teacher = null;
    	if(id==null||id.equalsIgnoreCase("null")){
    		UserModel user= (UserModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    		String userId = user.getId();
    		teacher = teacherDAO.getTeacherByUserId(userId);
    	}else{
    		teacher = teacherDAO.get(id);
    	}
    	teacher.setExperiences(null);
		teacher.setOtherDepartments(null);
		teacher.setRelations(null);
		//从user对象里取得部门与职务信息
		if(teacher!=null){
			UserModel user=userDAO.get(teacher.getUserID());
			if(user!=null){
				DRModel mainDR=user.getMainDR();
				if(mainDR!=null){
					RoleModel role=roleDAO.get(mainDR.getRoleId());
					if(role!=null){
						teacher.setTeacherPosition(role.getId());
						teacher.setTeacherPositionName(role.getName());
						
					}
					DepartmentModel department=departmentDAO.get(mainDR.getDepartmentId());
					if(department!=null){
						teacher.setTeacherDepartment(department.getId());
						teacher.setTeacherDepartmentName(department.getName());
					}
					
				}
				
				
				
			}
		}
    	return teacher;
    }
    public String getTeacherNameByUserId(String userId){
    	TeacherModel model=teacherDAO.getTeacherByUserId(userId);
    	if(model!=null)return model.getName();
    	else return null;
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

	public DRDAO getDrDAO() {
		return drDAO;
	}

	public void setDrDAO(DRDAO drDAO) {
		this.drDAO = drDAO;
	}
	
}
