package system.wlims.oa.entity.course.adjust;


import java.util.Date;

import system.wlims.oa.entity.BaseModel;



public class ApplyItemModel extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9138753937770377935L;
	private String applyClass;
	private String applyCourse;
	private Date applyCourseDate;
	private String applyCourseTime;
	private Date adjustMeanDate;
	private String adjustMeanTime;
	private String adjustMeanTeacherId;
	private Date adjustActualDate;
	private String adjustActualTime;
	private String adjustActualTeacherId;
	private Integer adjustArrangeAlready;
	private Date adjustArrangeDate;
	private ApplyModel apply;
	public String getApplyClass() {
		return applyClass;
	}
	public void setApplyClass(String applyClass) {
		this.applyClass = applyClass;
	}
	public String getApplyCourse() {
		return applyCourse;
	}
	public void setApplyCourse(String applyCourse) {
		this.applyCourse = applyCourse;
	}
	public Date getApplyCourseDate() {
		return applyCourseDate;
	}
	public void setApplyCourseDate(Date applyCourseDate) {
		this.applyCourseDate = applyCourseDate;
	}
	public String getApplyCourseTime() {
		return applyCourseTime;
	}
	public void setApplyCourseTime(String applyCourseTime) {
		this.applyCourseTime = applyCourseTime;
	}
	public Date getAdjustMeanDate() {
		return adjustMeanDate;
	}
	public void setAdjustMeanDate(Date adjustMeanDate) {
		this.adjustMeanDate = adjustMeanDate;
	}
	public String getAdjustMeanTeacherId() {
		return adjustMeanTeacherId;
	}
	public void setAdjustMeanTeacherId(String adjustMeanTeacherId) {
		this.adjustMeanTeacherId = adjustMeanTeacherId;
	}
	public Date getAdjustActualDate() {
		return adjustActualDate;
	}
	public void setAdjustActualDate(Date adjustActualDate) {
		this.adjustActualDate = adjustActualDate;
	}
	public String getAdjustActualTime() {
		return adjustActualTime;
	}
	public void setAdjustActualTime(String adjustActualTime) {
		this.adjustActualTime = adjustActualTime;
	}
	public String getAdjustActualTeacherId() {
		return adjustActualTeacherId;
	}
	public void setAdjustActualTeacherId(String adjustActualTeacherId) {
		this.adjustActualTeacherId = adjustActualTeacherId;
	}
	public ApplyModel getApply() {
		return apply;
	}
	public void setApply(ApplyModel apply) {
		this.apply = apply;
	}
	public String getAdjustMeanTime() {
		return adjustMeanTime;
	}
	public void setAdjustMeanTime(String adjustMeanTime) {
		this.adjustMeanTime = adjustMeanTime;
	}
	public Integer getAdjustArrangeAlready() {
		return adjustArrangeAlready;
	}
	public void setAdjustArrangeAlready(Integer adjustArrangeAlready) {
		this.adjustArrangeAlready = adjustArrangeAlready;
	}
	public Date getAdjustArrangeDate() {
		return adjustArrangeDate;
	}
	public void setAdjustArrangeDate(Date adjustArrangeDate) {
		this.adjustArrangeDate = adjustArrangeDate;
	}
	

}
