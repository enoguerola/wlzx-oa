package system.wlims.basic.entity;


import java.util.Date;


public class PlaceModel extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8639815502223620376L;
	/**
	 * 
	 */
	private String symbol;
	private String name;
	private String type;
	private String position;
	private String function;
	private String areaNum;
	private String containNum;
	private String remarks;
	private Date creationDate;
	private Date modifiedDate;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getFunction() {
		return function;
	}
	public void setFunction(String function) {
		this.function = function;
	}
	public String getAreaNum() {
		return areaNum;
	}
	public void setAreaNum(String areaNum) {
		this.areaNum = areaNum;
	}
	public String getContainNum() {
		return containNum;
	}
	public void setContainNum(String containNum) {
		this.containNum = containNum;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
}
