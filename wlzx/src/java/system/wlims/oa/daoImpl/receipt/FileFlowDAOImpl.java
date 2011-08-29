package system.wlims.oa.daoImpl.receipt;


import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import system.BaseDAOImpl;
import system.DAOException;
import system.wlims.oa.dao.receipt.FileFlowDAO;
import system.wlims.oa.entity.receipt.FileFlowModel;
import system.wlims.oa.entity.receipt.ReceiptModel;

public class FileFlowDAOImpl extends BaseDAOImpl<FileFlowModel> implements
		FileFlowDAO {

	@Override
	public List<FileFlowModel> getList(ReceiptModel receipt, Integer type) throws DAOException {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(FileFlowModel.class);
		
		if(receipt != null)
			criteria.add(Restrictions.eq("receipt", receipt));
		
		if(type != null)
			criteria.add(Restrictions.eq("step", type));
		else
			criteria.addOrder(Order.asc("step"));
				
		List<FileFlowModel> list = getListByCriteria(criteria);
		
//		if(list != null && list.size() > 0){
//			for(FileFlowModel model:list){
//				model.setReceipt(null);
//			}
//		}
		return list;
	}

	@Override
	public List<FileFlowModel> getAllBefore(ReceiptModel receipt,
			Integer maxStep) throws DAOException {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(FileFlowModel.class);
		
		if(receipt != null)
			criteria.add(Restrictions.eq("receipt", receipt));
		
		if(maxStep != null)
			criteria.add(Restrictions.le("step", maxStep));
		else
			criteria.addOrder(Order.asc("step"));
				
		List<FileFlowModel> list = getListByCriteria(criteria);
		
//		if(list != null && list.size() > 0){
//			for(FileFlowModel model:list){
//				model.setReceipt(null);
//			}
//		}
		return list;
	}

	@Override
	public List<FileFlowModel> getListByType(ReceiptModel receipt, Integer type)
			throws DAOException {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(FileFlowModel.class);
		
		if(receipt != null)
			criteria.add(Restrictions.eq("receipt", receipt));
		
		if(type != null)
			criteria.add(Restrictions.le("type", type));
		else
			criteria.addOrder(Order.asc("step"));
				
		List<FileFlowModel> list = getListByCriteria(criteria);
		
//		if(list != null && list.size() > 0){
//			for(FileFlowModel model:list){
//				model.setReceipt(null);
//			}
//		}
		return list;
	}


}
