package system.wlims.basic.entity.teacher;

import system.wlims.basic.entity.BaseModel;

public class TeacherRelation extends BaseModel {

	private static final long serialVersionUID = 4961769417289910770L;
	
	private String name;
	private String relation;
	private String company;
	private String phone;
	
	private TeacherModel teacher;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
