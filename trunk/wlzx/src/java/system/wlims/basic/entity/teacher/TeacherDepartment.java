package system.wlims.basic.entity.teacher;

import system.wlims.basic.entity.BaseModel;

public class TeacherDepartment extends BaseModel {

	private static final long serialVersionUID = 2054850052851052154L;
	
	private String department;
	private String position;
	
	private TeacherModel teacher;
	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public void setTeacher(TeacherModel teacher) {
		this.teacher = teacher;
	}
	public TeacherModel getTeacher() {
		return teacher;
	}

}
