package system.wlims.basic.entity.teacher;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;


import system.entity.PersonModel;

public class TeacherModel extends PersonModel{

	private static final long serialVersionUID = -8699764053458317416L;
	
	private Boolean teacherMarried;
	private String teacherID;
	private String teacherNativePlace;
	private String teacherMail;
	private String teacherNo;
	private String teacherEducation;
	private String teacherProfession;
	private String teacherGraduateSchool;
	private String teacherProfessionTitle;
	private String teacherSkillLevel;
	private Date teacherSkillLevelDate;
	private String teacherDepartment;
	private String teacherPosition;
	private String teacherContactPhone;
	private String teacherOfficePhone;
	private Date teacherWorkDate;
	//private String teacherWorkPeriod;
	private String teacherAddress;
	private String teacherPhoto;
	private Integer teacherStatus;
	
	private Date teacherAttendDate;
	//private String teacherAttendPeriod;
	
	private Set<TeacherDepartment> otherDepartments = new HashSet<TeacherDepartment>();
	private Set<TeacherRelation> relations = new HashSet<TeacherRelation>();
	private Set<TeacherExperience> experiences = new HashSet<TeacherExperience>();

	public Boolean getTeacherMarried() {
		return teacherMarried;
	}
	public void setTeacherMarried(Boolean teacherMarried) {
		this.teacherMarried = teacherMarried;
	}
	public String getTeacherID() {
		return teacherID;
	}
	public void setTeacherID(String teacherID) {
		this.teacherID = teacherID;
	}
	public String getTeacherNativePlace() {
		return teacherNativePlace;
	}
	public void setTeacherNativePlace(String teacherNativePlace) {
		this.teacherNativePlace = teacherNativePlace;
	}
	public String getTeacherMail() {
		return teacherMail;
	}
	public void setTeacherMail(String teacherMail) {
		this.teacherMail = teacherMail;
	}
	public String getTeacherNo() {
		return teacherNo;
	}
	public void setTeacherNo(String teacherNo) {
		this.teacherNo = teacherNo;
	}
	public String getTeacherEducation() {
		return teacherEducation;
	}
	public void setTeacherEducation(String teacherEducation) {
		this.teacherEducation = teacherEducation;
	}
	public String getTeacherProfession() {
		return teacherProfession;
	}
	public void setTeacherProfession(String teacherProfession) {
		this.teacherProfession = teacherProfession;
	}
	public String getTeacherGraduateSchool() {
		return teacherGraduateSchool;
	}
	public void setTeacherGraduateSchool(String teacherGraduateSchool) {
		this.teacherGraduateSchool = teacherGraduateSchool;
	}
	public String getTeacherProfessionTitle() {
		return teacherProfessionTitle;
	}
	public void setTeacherProfessionTitle(String teacherProfessionTitle) {
		this.teacherProfessionTitle = teacherProfessionTitle;
	}
	public String getTeacherSkillLevel() {
		return teacherSkillLevel;
	}
	public void setTeacherSkillLevel(String teacherSkillLevel) {
		this.teacherSkillLevel = teacherSkillLevel;
	}
	public Date getTeacherSkillLevelDate() {
		return teacherSkillLevelDate;
	}
	public void setTeacherSkillLevelDate(Date teacherSkillLevelDate) {
		this.teacherSkillLevelDate = teacherSkillLevelDate;
	}
	public String getTeacherDepartment() {
		return teacherDepartment;
	}
	public void setTeacherDepartment(String teacherDepartment) {
		this.teacherDepartment = teacherDepartment;
	}
	public String getTeacherPosition() {
		return teacherPosition;
	}
	public void setTeacherPosition(String teacherPosition) {
		this.teacherPosition = teacherPosition;
	}
	public String getTeacherContactPhone() {
		return teacherContactPhone;
	}
	public void setTeacherContactPhone(String teacherContactPhone) {
		this.teacherContactPhone = teacherContactPhone;
	}
	public String getTeacherOfficePhone() {
		return teacherOfficePhone;
	}
	public void setTeacherOfficePhone(String teacherOfficePhone) {
		this.teacherOfficePhone = teacherOfficePhone;
	}
	public Date getTeacherWorkDate() {
		return teacherWorkDate;
	}
	public void setTeacherWorkDate(Date teacherWorkDate) {
		this.teacherWorkDate = teacherWorkDate;
	}
	public String getTeacherAddress() {
		return teacherAddress;
	}
	public void setTeacherAddress(String teacherAddress) {
		this.teacherAddress = teacherAddress;
	}
	public String getTeacherPhoto() {
		return teacherPhoto;
	}
	public void setTeacherPhoto(String teacherPhoto) {
		this.teacherPhoto = teacherPhoto;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public void setOtherDepartments(Set<TeacherDepartment> otherDepartments) {
		this.otherDepartments = otherDepartments;
	}
	public Set<TeacherDepartment> getOtherDepartments() {
		return otherDepartments;
	}
	public void setRelations(Set<TeacherRelation> relations) {
		this.relations = relations;
	}
	public Set<TeacherRelation> getRelations() {
		return relations;
	}
	public void setExperiences(Set<TeacherExperience> experiences) {
		this.experiences = experiences;
	}
	public Set<TeacherExperience> getExperiences() {
		return experiences;
	}
	public void setTeacherAttendDate(Date teacherAttendDate) {
		this.teacherAttendDate = teacherAttendDate;
	}
	public Date getTeacherAttendDate() {
		return teacherAttendDate;
	}
	public void setTeacherStatus(Integer teacherStatus) {
		this.teacherStatus = teacherStatus;
	}
	public Integer getTeacherStatus() {
		return teacherStatus;
	}

}
