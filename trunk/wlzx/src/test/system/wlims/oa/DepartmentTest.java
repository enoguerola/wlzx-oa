package system.wlims.oa;

import java.util.Set;

import system.BaseTest;
import system.dao.DepartmentDAO;
import system.entity.DepartmentModel;

public class DepartmentTest extends BaseTest {

	private DepartmentDAO departmentDAO;
	
	public DepartmentTest(){
		setDepartmentDAO((DepartmentDAO)applicationContext.getBean("departmentDAO"));
	}
	
	public void getAllSub(){
		DepartmentModel department = departmentDAO.get("1");
		Set<DepartmentModel> set = departmentDAO.getAllSubordinates(department);
		
		for(DepartmentModel model: set){
			System.out.println(model.getId());
		}
	}
	
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
}
