package system.wlims.oa;

import java.util.Set;

import system.BaseTest;
import system.dao.DepartmentDAO;
import system.dao.UserDAO;
import system.entity.DepartmentModel;

public class DepartmentTest extends BaseTest {

	private DepartmentDAO departmentDAO;
	private UserDAO userDAO;
	
	public DepartmentTest(){
		setDepartmentDAO((DepartmentDAO)applicationContext.getBean("departmentDAO"));
		setUserDAO((UserDAO)applicationContext.getBean("userDAO"));
	}
	
	public void getAllSub(){
		DepartmentModel department = departmentDAO.get("1");
		Set<DepartmentModel> set = departmentDAO.getAllSubordinates(department);
		System.out.println("sub department in department1");
		for(DepartmentModel model: set){
			System.out.print(model.getId() + " ");
		}
	}
	
//	public void getAllLeader(){
//		UserModel userModel = userDAO.get("2");
//		Set<DepartmentModel> departments = userModel.getDepartments();		
//		Set<DepartmentModel> set = userDAO.getAllLeaders(userModel);
//		
//		if(set != null && set.size() > 0){
//			System.out.println("leader department in user2");
//			for(DepartmentModel model: set){
//				System.out.print(model.getId() + " ");
//			}
//		}
//		departments.addAll(set);
//		
//	}
	
	public static void main(String[] args){
		DepartmentTest test = new DepartmentTest();
		test.getAllSub();
	}

	public void setDepartmentDAO(DepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}

	public DepartmentDAO getDepartmentDAO() {
		return departmentDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}
}
