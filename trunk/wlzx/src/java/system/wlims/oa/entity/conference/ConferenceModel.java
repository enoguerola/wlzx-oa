package system.wlims.oa.entity.conference;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import system.wlims.oa.entity.BaseModel;
import system.wlims.oa.entity.notice.AttachmentModel;

public class ConferenceModel extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5064507889339370316L;
	/**
	 * 
	 */
	private String name;
	private Date meetingDate;
	private String beginTime;
	private String endTime;
	private int attendNum;
	private String teacherAttendIds;
	private String departmentId;
	private String placeId;
	private String contactUserId;
	private String contactPhoneNumber;
	private String serviceNeeded;
	private String description;
	private String applyUserId;
	private Date applyDateTime;
	private Set<AttachmentModel> attachments=new TreeSet<AttachmentModel>(); 
	private Set<AttachmentModel> summaryAttachments=new TreeSet<AttachmentModel>(); 
	private Integer applyStatus;
	public static enum EStatus{
		Booking(1, "预约中"),
		Arranged(3, "已安排"),
		Cancled(2, "已取消");
		
		private Integer value;
		private String text;
		
		EStatus(Integer value, String text){
			this.value = value;
			this.text = text;
		}
		
		public Integer getValue(){
			return value;
		}
		
		public String getText(){
			return this.text;
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getMeetingDate() {
		return meetingDate;
	}
	public void setMeetingDate(Date meetingDate) {
		this.meetingDate = meetingDate;
	}
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public int getAttendNum() {
		return attendNum;
	}
	public void setAttendNum(int attendNum) {
		this.attendNum = attendNum;
	}
	public String getTeacherAttendIds() {
		return teacherAttendIds;
	}
	public void setTeacherAttendIds(String teacherAttendIds) {
		this.teacherAttendIds = teacherAttendIds;
	}
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public String getPlaceId() {
		return placeId;
	}
	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}
	public String getContactUserId() {
		return contactUserId;
	}
	public void setContactUserId(String contactUserId) {
		this.contactUserId = contactUserId;
	}
	public String getContactPhoneNumber() {
		return contactPhoneNumber;
	}
	public void setContactPhoneNumber(String contactPhoneNumber) {
		this.contactPhoneNumber = contactPhoneNumber;
	}
	public String getServiceNeeded() {
		return serviceNeeded;
	}
	public void setServiceNeeded(String serviceNeeded) {
		this.serviceNeeded = serviceNeeded;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getApplyUserId() {
		return applyUserId;
	}
	public void setApplyUserId(String applyUserId) {
		this.applyUserId = applyUserId;
	}
	public Date getApplyDateTime() {
		return applyDateTime;
	}
	public void setApplyDateTime(Date applyDateTime) {
		this.applyDateTime = applyDateTime;
	}
	public Set<AttachmentModel> getAttachments() {
		return attachments;
	}
	public void setAttachments(Set<AttachmentModel> attachments) {
		this.attachments = attachments;
	}
	public Set<AttachmentModel> getSummaryAttachments() {
		return summaryAttachments;
	}
	public void setSummaryAttachments(Set<AttachmentModel> summaryAttachments) {
		this.summaryAttachments = summaryAttachments;
	}
	
	public Integer getApplyStatus() {
		return applyStatus;
	}
	public void setApplyStatus(Integer applyStatus) {
		this.applyStatus = applyStatus;
	}
	
	
	
	
}
