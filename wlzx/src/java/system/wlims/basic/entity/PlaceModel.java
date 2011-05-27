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
	private String functions;
	private Float areaBegin;
	private Float areaEnd;
	private Integer containBegin;
	private Integer containEnd;
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
	public String getFunctions() {
		return functions;
	}
	public void setFunctions(String functions) {
		this.functions = functions;
	}
	public Float getAreaBegin() {
		return areaBegin;
	}
	public void setAreaBegin(Float areaBegin) {
		this.areaBegin = areaBegin;
	}
	public Float getAreaEnd() {
		return areaEnd;
	}
	public void setAreaEnd(Float areaEnd) {
		this.areaEnd = areaEnd;
	}
	public Integer getContainBegin() {
		return containBegin;
	}
	public void setContainBegin(Integer containBegin) {
		this.containBegin = containBegin;
	}
	public Integer getContainEnd() {
		return containEnd;
	}
	public void setContainEnd(Integer containEnd) {
		this.containEnd = containEnd;
	}
	
}
