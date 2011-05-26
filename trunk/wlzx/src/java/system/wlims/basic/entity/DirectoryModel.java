package system.wlims.basic.entity;


import java.util.Date;


public class DirectoryModel extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -917530983550918568L;
	private int sequence;
	private String name;
	private String value;
	private String type;
	private String extraValue;
	private Date creationDate;
	private Date modifiedDate;
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getExtraValue() {
		return extraValue;
	}
	public void setExtraValue(String extraValue) {
		this.extraValue = extraValue;
	}

	public int getSequence() {
		return sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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

}
