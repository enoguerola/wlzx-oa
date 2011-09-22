
package system.entity;

import java.io.Serializable;


public  class SimpleBaseModel implements Comparable<SimpleBaseModel>, Serializable{

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
	 @Override  
	    public boolean equals(Object obj) {  
	        return getId().equals(((SimpleBaseModel)obj).getId());  
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
		public int compareTo(SimpleBaseModel baseModel) {
			// TODO Auto-generated method stub
			return this.id.compareTo(baseModel.id);//这里的compareTo方法是String中的，String已实现 Comparable接口，按照字母顺序来排序的。它返回的也是int（1,,0,,-1）同时实现了对字母排序。比如，有年龄相同的姓名不相同的元素，那么就会按字母顺序来排，如果都一样，则就是同一元素
		}

	
}
