
package system.entity;

import java.io.Serializable;
import java.util.Date;

  /**
 *
 * 类名称：BaseModel
 * 类描述：
 * 创建人：wuyuyue
 * 创建时间：2011-4-14 下午05:17:25
 * 修改人：wuyuyue
 * 修改时间：2011-4-14 下午05:17:25
 * 修改备注：
 * @version
 *
 */

public  class BaseModel implements Comparable<BaseModel>,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2975949181971555105L;
	protected String id = null;
	private String name;
	private String symbol;
	private Date creationDate;
	private Date modifiedDate;
	private int sequence;

	public String getId(){
		return id;
	}
	
	public void setId(String id){
		try{
			this.id = (id == null || "" == id ||Integer.parseInt(id) < 0) ? null : id;
		} catch (NumberFormatException e){
			this.id = null;
		}
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

    @Override  
    public boolean equals(Object obj) {  
        return getId().equals(((BaseModel)obj).getId());  
    }
    @Override  
    public int hashCode() {  
        // TODO Auto-generated method stub  
        return   Integer.parseInt(getId()) ;
    } 
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(BaseModel baseModel) {
		// TODO Auto-generated method stub
		return this.symbol.compareTo(baseModel.symbol);//这里的compareTo方法是String中的，String已实现 Comparable接口，按照字母顺序来排序的。它返回的也是int（1,,0,,-1）同时实现了对字母排序。比如，有年龄相同的姓名不相同的元素，那么就会按字母顺序来排，如果都一样，则就是同一元素
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
}
