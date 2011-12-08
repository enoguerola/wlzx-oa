/**
 * 
 */
package system.daoImpl;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import system.BaseDAOImpl;
import system.dao.MessageDAO;
import system.entity.MessageModel;
import system.utils.StringUtils;
import system.vo.MessageVO;





  

public class MessageDAOImpl extends BaseDAOImpl<MessageModel> implements MessageDAO{


	@SuppressWarnings("unchecked")
	public List<MessageModel> getMessagesByConditions(String beginDate,String endDate) {
//		System.out.println(fromId+"   "+toId+"  "+status+"  ");
		DetachedCriteria criteria = DetachedCriteria.forClass(MessageModel.class);
//		if(StringUtils.isNotEmpty(fromId)){
//			criteria.add(Restrictions.sqlRestriction("from_id='"+fromId+"'"));	
//		}
//		if(StringUtils.isNotEmpty(toId)){
//			criteria.add(Restrictions.sqlRestriction("LOCATE("+toId+",to_ids) >0"));
//
//		}
//		if(status!=null){
//			criteria.add(Restrictions.eq("status", status.intValue()));
//		}
		if(StringUtils.isNotEmpty(beginDate))
			criteria.add(Restrictions.sqlRestriction("creation_date >= '"+beginDate+" 00:00:00'"));
			
		if(StringUtils.isNotEmpty(endDate))
			criteria.add(Restrictions.sqlRestriction("creation_date <= '"+endDate+" 23:59:59'"));
		criteria.addOrder(Order.desc("creationDate"));
		List<MessageModel> result = this.getListByCriteria(criteria);
		return result;
	}
	public List<MessageVO> getMessagesByConditions(String fromId,String toId,Integer status,String beginDate,String endDate){
		List<MessageVO> result=new ArrayList<MessageVO>();
		List<MessageModel> list=getMessagesByConditions(beginDate,endDate);
		for(MessageModel model:list){
			if(StringUtils.isNotEmpty(fromId)){
				if(model.getFromId().equals(fromId)&&model.getPostRemovedFlag().equals(MessageModel.MessageRemoveFlag.NotRemoved.getValue()+"")){
					MessageVO vo=new MessageVO();
					vo.setId(model.getId());
					vo.setFromId(model.getFromId());
					vo.setToIds(model.getToIds());
					vo.setContent(model.getContent());
					vo.setCreationDate(model.getCreationDate());
					vo.setType(model.getType());
					vo.setLinkObjectId(model.getLinkObjectId());
					vo.setLinkObjectType(model.getLinkObjectType());
					result.add(vo);
				}
			}else if(StringUtils.isNotEmpty(toId)){
				if(model.toIdsContains(toId)&&model.getRemovedFlagByUserId(toId).equals(MessageModel.MessageRemoveFlag.NotRemoved.getValue()+"")&&model.getReadFlagByUserId(toId).equals(status.intValue()+"")){
					MessageVO vo=new MessageVO();
					vo.setId(model.getId());
					vo.setFromId(model.getFromId());
					vo.setToIds(toId);
					vo.setContent(model.getContent());
					vo.setCreationDate(model.getCreationDate());
					vo.setType(model.getType());
					vo.setReadDate(model.getReadDateByUserId(toId));
					vo.setReadFlag(model.getReadFlagByUserId(toId));
					vo.setLinkObjectId(model.getLinkObjectId());
					vo.setLinkObjectType(model.getLinkObjectType());
					result.add(vo);
				}
			}
		}	
		return result;
		
	}
}
