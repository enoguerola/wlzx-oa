/**
 * 
 */
package system.dao;


import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import system.BaseDAOImpl;
import system.entity.MessageModel;
import system.utils.StringUtils;





  

public class MessageDAO extends BaseDAOImpl<MessageModel>{


	@SuppressWarnings("unchecked")
	public List<MessageModel> getMessagesByConditions(String fromId,String toId,Integer status) {
//		System.out.println(fromId+"   "+toId+"  "+status+"  ");
		DetachedCriteria criteria = DetachedCriteria.forClass(MessageModel.class);
		if(StringUtils.isNotEmpty(fromId)){
			criteria.add(Restrictions.sqlRestriction("from_user_id='"+fromId+"'"));	
		}else criteria.add(Restrictions.sqlRestriction("from_user_id=NULL"));	
		if(StringUtils.isNotEmpty(toId)){
			criteria.add(Restrictions.sqlRestriction("to_user_id='"+toId+"'"));	
		}
		if(status!=null){
			criteria.add(Restrictions.eq("status", status.intValue()));
		}
		List<MessageModel> result = this.getListByCriteria(criteria);
		return result;
	}

}
