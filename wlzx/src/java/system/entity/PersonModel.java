/**
 * 
 */
package system.entity;

import java.sql.Date;

import system.wlims.basic.entity.BaseModel;


  
  /**
 *
 * 类名称：PersonModel
 * 类描述：人员抽象模型
 * 创建人：wuyuyue
 * 创建时间：2011-4-14 下午09:38:30
 * 修改人：wuyuyue
 * 修改时间：2011-4-14 下午09:38:30
 * 修改备注：
 * @version
 *
 */

public class PersonModel extends BaseModel{

	private static final long serialVersionUID = 6869991706996571288L;
	
	private String name;
	private Integer sex;
	private Date birthday;
	private String nation;
	private Integer politicsStatus;
	private String homePhone;
	private Integer style;
	private String address;
	
	private Date creationDate;
	private Date modifiedDate;
	
	private String userID;
	
	public static enum PersonStyle{
		Teacher(0, "教师");
		
		private int style;
		private String name;
		
		private PersonStyle(int style, String name){
			this.setStyle(style);
			this.setName(name);
		}

		public void setStyle(int style) {
			this.style = style;
		}

		public int getStyle() {
			return style;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public Integer getPoliticsStatus() {
		return politicsStatus;
	}

	public void setPoliticsStatus(Integer politicsStatus) {
		this.politicsStatus = politicsStatus;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public void setStyle(Integer style) {
		this.style = style;
	}

	public Integer getStyle() {
		return style;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserID() {
		return userID;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getSex() {
		return sex;
	}
}
