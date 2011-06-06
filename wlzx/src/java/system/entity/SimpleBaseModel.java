
package system.entity;

import java.io.Serializable;


public  class SimpleBaseModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8954007398183913798L;
	/**
	 * 
	 */
	protected String id = null;

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

	
}
