package system.wlims.basic.serviceImpl.teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;



import system.DAOException;
import system.ServiceException;
import system.dao.DRDAO;
import system.dao.DepartmentDAO;
import system.dao.RoleDAO;
import system.dao.UserDAO;
import system.entity.DRModel;
import system.entity.DepartmentModel;
import system.entity.RoleModel;
import system.entity.UserModel;
import system.utils.StringUtils;
import system.utils.TripleObject;
import system.wlims.basic.dao.teacher.TeacherDAO;
import system.wlims.basic.entity.teacher.TeacherDepartment;
import system.wlims.basic.entity.teacher.TeacherModel;
import system.wlims.basic.service.teacher.TeacherAccountBridgeService;
import system.wlims.basic.vo.UserAddressVo;

public class TeacherAccountBridgeServiceImpl  implements  TeacherAccountBridgeService{

	private TeacherDAO teacherDAO;
//	private TeacherDepartmentDAO teacherDepartmentDAO;
	private UserDAO userDAO;
	private RoleDAO roleDAO;
	private DepartmentDAO departmentDAO;
	private DRDAO drDAO;
	public Boolean save(String departmentId,String  positionId, String teacherId,String preDepartmentId,String prePositionId)throws ServiceException{
		try {
			TeacherModel teacher = teacherDAO.get(teacherId);
			UserModel user=userDAO.get(teacher.getUserID());
//			RoleModel role=roleDAO.get(positionId);	
			DRModel dr=drDAO.getDRByDepartmentIdAndRoleId(departmentId, positionId);
			if(dr==null){
				dr=new DRModel();
				dr.setDepartmentId(departmentId);
				dr.setRoleId(positionId);
				drDAO.saveOrUpdate(dr);
			}
			user.getDrs().add(dr);
			if(StringUtils.isNotEmpty(prePositionId)&&StringUtils.isNotEmpty(preDepartmentId)){
				DRModel preDr=drDAO.getDRByDepartmentIdAndRoleId(preDepartmentId, prePositionId);	
				if(preDr!=null)
				user.getDrs().remove(preDr);
			}
			userDAO.merge(user);
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
		for(DRModel dr:user.getDrs()){
			TeacherDepartment td=new TeacherDepartment();
			//td.setDepartmentName(role.getBelongDepartment().getName());
			td.setPositionId(dr.getRoleId());
			RoleModel role=roleDAO.get(dr.getRoleId());
			td.setPositionName(role.getName());
			td.setTeacherId(teacher.getId());
			DepartmentModel department=departmentDAO.get(dr.getDepartmentId());
			td.setDepartmentId(dr.getDepartmentId());
			td.setDepartmentName(department.getName());
			list.add(td);
		}
		return list;
	}
	
	public void remove(String teacherId,String departmentId,String positionId )throws ServiceException{
//		teacherDepartmentDAO.remove(id);
		TeacherModel teacher = teacherDAO.get(teacherId);
		UserModel user=userDAO.get(teacher.getUserID());
		DRModel dr=drDAO.getDRByDepartmentIdAndRoleId(departmentId, positionId);
		//RoleModel role=roleDAO.get(positionId);	
		if(dr!=null)
		user.getDrs().remove(dr);
		userDAO.merge(user);
	}
	
	public TripleObject getTeacherById(String userId){
		TeacherModel tm = teacherDAO.getTeacherByUserId(userId);
		return new TripleObject<String, String,String>(tm.getName(), tm.getTeacherNo(),tm.getUserID());
	}
	
	public List<TripleObject<String, String,String>> teacherAccountGetAll(){
		List<TripleObject<String, String,String>> triples = new ArrayList<TripleObject<String, String,String>>();
		List<TeacherModel> teachers =teacherDAO.getTeachersByStatus(null) ;
		
		if(teachers != null){
			for(int i=0;i<teachers.size();i++){
//				UserModel user=userDAO.get(teacher.getUserID());
//				user.setRoles(null);
//				if(user==null) continue;
				triples.add(new TripleObject<String, String,String>(
						teachers.get(i).getName(), teachers.get(i).getTeacherNo(),teachers.get(i).getUserID()));
			}
		}	
		return triples;
	}
	public List<TripleObject<String, String,String>> getUsersByCondition(String userId,String departmentId,String roleId){
		List<TripleObject<String, String,String>> triples = new ArrayList<TripleObject<String, String,String>>();
		if(StringUtils.isNotEmpty(userId)){
			UserModel user=userDAO.get(userId);
			triples.add(new TripleObject<String, String,String>(null,user.getName(),user.getId()));
		}else if(StringUtils.isNotEmpty(roleId)){
			RoleModel role=roleDAO.get(roleId);
			Set<UserModel> users=role.getAllUsers();
			for(UserModel user:users){
				triples.add(new TripleObject<String, String,String>(null,user.getName(),user.getId()));
			}
		}else if(StringUtils.isNotEmpty(departmentId)){
			DepartmentModel department=departmentDAO.get(departmentId);
			
			Set<UserModel> users=department.getLevel()==0?department.getSelfUsers():department.getAllUsers();
//			List<UserModel> mainUsers=userDAO.getUsersByMainDepartment(departmentId);
//			if(mainUsers!=null&&mainUsers.size()>0){
//				for(UserModel user:mainUsers)
//					users.add(user);
//			}
			for(UserModel user:users){
				triples.add(new TripleObject<String, String,String>(null,user.getName(),user.getId()));
			}
		}else {
			List<UserModel> users=userDAO.getAllUsers();
			for(UserModel user:users){
				triples.add(new TripleObject<String, String,String>(null,user.getName(),user.getId()));
			}
		}
		
		return triples;
	}
	//获得未授权用户
	public List<TripleObject<String, String,String>>  getUnAuthUsers(){	
		List<TripleObject<String, String,String>> triples = new ArrayList<TripleObject<String, String,String>>();
		List<UserModel> allUsers=userDAO.getAllUsers();
		for(UserModel user:allUsers){
			if(user.getAllDRs()==null||user.getAllDRs().size()==0){
				triples.add(new TripleObject<String, String,String>(null,user.getName(),user.getId()));
			}
		}
		return triples;
		
	}
	public List<UserAddressVo> getUserAddressesByConditions(String departmentId,String userId){
		List<UserAddressVo> results = new ArrayList<UserAddressVo>();
		if(StringUtils.isNotEmpty(departmentId)){
			DepartmentModel department=departmentDAO.get(departmentId);
			if(department!=null){
				Set<UserModel> users=department.getSelfUsers();
//				List<UserModel> mainUsers=userDAO.getUsersByMainDepartment(departmentId);
//				if(mainUsers!=null&&mainUsers.size()>0){
//					for(UserModel user:mainUsers)
//						users.add(user);
//				}
				if(users!=null&&users.size()>0){
					for(UserModel user : users){
						UserAddressVo vo=new UserAddressVo();
						vo.setUserID(user.getId());
						vo.setUserAccount(user.getName());
						if(user.getMainDR()!=null){
							vo.setMainRoleName(user.getMainDR().getRoleId());
							
						}else{
							vo.setMainRoleName("未指定");
						}
						if(user.getMainDR()!=null){
								vo.setMainDepartmentName(user.getMainDR().getDepartmentId());
						}else {
							vo.setMainDepartmentName("未指定");
						}
						TeacherModel teacher=teacherDAO.getTeacherByUserId(user.getId());
						if(teacher!=null){
							vo.setUserName(teacher.getName());
							vo.setEmail(teacher.getTeacherMail());
							vo.setMobilePhone(teacher.getTeacherMobilePhone());
							vo.setOfficePhone(teacher.getTeacherOfficePhone());
						}
						results.add(vo);
					}
				}
			}
			
		}else if(StringUtils.isNotEmpty(userId)){
			UserModel user=userDAO.get(userId);
			UserAddressVo vo=new UserAddressVo();
			vo.setUserID(user.getId());
			vo.setUserAccount(user.getName());
			if(user.getMainDR()!=null){
				vo.setMainRoleName(user.getMainDR().getRoleId());
				
			}else{
				vo.setMainRoleName("未指定");
			}
			if(user.getMainDR()!=null){
					vo.setMainDepartmentName(user.getMainDR().getDepartmentId());
			}else {
				vo.setMainDepartmentName("未指定");
			}
			TeacherModel teacher=teacherDAO.getTeacherByUserId(user.getId());
			if(teacher!=null){
				vo.setUserName(teacher.getName());
				vo.setEmail(teacher.getTeacherMail());
				vo.setMobilePhone(teacher.getTeacherMobilePhone());
				vo.setOfficePhone(teacher.getTeacherOfficePhone());
			}
			results.add(vo);
		}else{

			List<UserModel> users=userDAO.getAllUsers();
			if(users!=null&&users.size()>0){
				for(UserModel user : users){
					UserAddressVo vo=new UserAddressVo();
					vo.setUserID(user.getId());
					vo.setUserAccount(user.getName());
					if(user.getMainDR()!=null){
						vo.setMainRoleName(user.getMainDR().getRoleId());
						
					}else{
						vo.setMainRoleName("未指定");
					}
					if(user.getMainDR()!=null){
							vo.setMainDepartmentName(user.getMainDR().getDepartmentId());
					}else {
						vo.setMainDepartmentName("未指定");
					}
					TeacherModel teacher=teacherDAO.getTeacherByUserId(user.getId());
					if(teacher!=null){
						vo.setUserName(teacher.getName());
						vo.setEmail(teacher.getTeacherMail());
						vo.setMobilePhone(teacher.getTeacherMobilePhone());
						vo.setOfficePhone(teacher.getTeacherOfficePhone());
					}
					results.add(vo);
				}
			}
		
		}
		return results;
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
