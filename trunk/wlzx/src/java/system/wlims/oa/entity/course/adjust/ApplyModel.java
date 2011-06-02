package system.wlims.oa.entity.course.adjust;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import system.wlims.oa.entity.BaseModel;



public class ApplyModel extends BaseModel {

	private static final long serialVersionUID = -6080864595443488206L;
	private String applyNo;
	private int applyType;
	private String applyTeacherId;	
	private String applyReason;
	private int applyStatus;
	private String approveTeacherId;
	private String approveRemark;
	private Date approveDate;	
	private Date applyCreationDate;
	private Set<ApplyItemModel> applyItems=new TreeSet<ApplyItemModel>();
	public static enum ApplyType{
		ADJUST(0, "调课"),
		REPLACE(1, "代课");
		private int type;
		private String name;
		
		private ApplyType(int type, String name){
			this.setType(type);
			this.setName(name);
		}

		public void setType(int type) {
			this.type = type;
		}

		public int getType() {
			return type;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}
	public static enum ApplyStatus{
		WAITING(0, "待审批"),
		PASS(1, "审批通过"),
		DENY(2, "审批未通过"),
		CANCLE(3, "取消");
		private int status;
		private String name;
		
		private ApplyStatus(int status, String name){
			this.setStatus(status);
			this.setName(name);
		}

		public void setStatus(int status) {
			this.status = status;
		}

		public int getStatus() {
			return status;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}
	public int getApplyType() {
		return applyType;
	}
	public void setApplyType(int applyType) {
		this.applyType = applyType;
	}
	public String getApplyTeacherId() {
		return applyTeacherId;
	}
	public void setApplyTeacherId(String applyTeacherId) {
		this.applyTeacherId = applyTeacherId;
	}
	
	public String getApplyReason() {
		return applyReason;
	}
	public void setApplyReason(String applyReason) {
		this.applyReason = applyReason;
	}
	public int getApplyStatus() {
		return applyStatus;
	}
	public void setApplyStatus(int applyStatus) {
		this.applyStatus = applyStatus;
	}
	public String getApplyNo() {
		return applyNo;
	}
	public void setApplyNo(String applyNo) {
		this.applyNo = applyNo;
	}
	public String getApproveTeacherId() {
		return approveTeacherId;
	}
	public void setApproveTeacherId(String approveTeacherId) {
		this.approveTeacherId = approveTeacherId;
	}
	public String getApproveRemark() {
		return approveRemark;
	}
	public void setApproveRemark(String approveRemark) {
		this.approveRemark = approveRemark;
	}
	public Date getApproveDate() {
		return approveDate;
	}
	public void setApproveDate(Date approveDate) {
		this.approveDate = approveDate;
	}
	public Date getApplyCreationDate() {
		return applyCreationDate;
	}
	public void setApplyCreationDate(Date applyCreationDate) {
		this.applyCreationDate = applyCreationDate;
	}
	public Set<ApplyItemModel> getApplyItems() {
		return applyItems;
	}
	public void setApplyItems(Set<ApplyItemModel> applyItems) {
		this.applyItems = applyItems;
	}

}
