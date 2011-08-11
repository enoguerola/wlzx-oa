package system.wlims.oa.daoImpl.sendingFiles;


import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import system.BaseDAOImpl;
import system.DAOException;
import system.utils.StringUtils;
import system.wlims.oa.dao.sendingFiles.FileFlowDAO;
import system.wlims.oa.entity.sendingFiles.FileFlowModel;

public class FileFlowDAOImpl extends BaseDAOImpl<FileFlowModel> implements
		FileFlowDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<FileFlowModel> getListByType(String sendingFileId, Integer type)
			throws DAOException {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(FileFlowModel.class);
		
		if(StringUtils.isNotEmpty(sendingFileId))
			criteria.add(Restrictions.eq("sendingFileId", sendingFileId));
		
		if(type != null)
			criteria.add(Restrictions.eq("type", type));
		criteria.addOrder(Order.asc("creationDate"));
				
		List<FileFlowModel> list = getListByCriteria(criteria);
		
		return list;
	}


}
