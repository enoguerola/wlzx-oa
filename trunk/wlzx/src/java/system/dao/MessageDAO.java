/**
 * 
 */
package system.dao;


import java.util.List;

import system.BaseDAO;
import system.entity.MessageModel;
import system.vo.MessageVO;





  

public interface MessageDAO extends BaseDAO<MessageModel>{
	public List<MessageModel> getMessagesByConditions(String beginDate,String endDate) ;
	public List<MessageVO> getMessagesByConditions(String fromId,String toId,Integer status,String beginDate,String endDate);
}
