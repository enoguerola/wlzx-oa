package system.wlims.basic.entity.teacher;

import java.sql.Date;

import system.wlims.basic.entity.BaseModel;

public class TeacherExperience extends BaseModel {

	private static final long serialVersionUID = -3985171187118090393L;
	
	private Date startDate;
	private Date endDate;
	private String company;
	private String position;
	
	private TeacherModel teacher;
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
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
