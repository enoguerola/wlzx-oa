package system.wlims.oa.serviceImpl.receipt;

import java.sql.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import system.ServiceException;
import system.utils.StringUtils;
import system.utils.UtilDateTime;
import system.wlims.oa.dao.receipt.ReceiptDAO;
import system.wlims.oa.entity.receipt.ReceiptModel;
import system.wlims.oa.service.receipt.ReceiptService;

public class ReceiptServiceImpl implements ReceiptService {

	private ReceiptDAO receiptDAO;

	public void setReceiptDAO(ReceiptDAO receiptDAO) {
		this.receiptDAO = receiptDAO;
	}

	public ReceiptDAO getReceiptDAO() {
		return receiptDAO;
	}

	@Override
	public ReceiptModel get(String id) throws ServiceException {
		// TODO Auto-generated method stub
		return receiptDAO.get(id);
	}

	@Override
	public List<ReceiptModel> get(String inNumber, String office, String doNumber, String status, 
			  String title, String startDate, String endDate, int page, int pageCount) throws ServiceException {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(ReceiptModel.class);
		
		if(StringUtils.isNotEmpty(inNumber))
			criteria.add(Restrictions.eq("inNumber", inNumber));
		
		if(StringUtils.isNotEmpty(doNumber))
			criteria.add(Restrictions.eq("doNumber", doNumber));
		
		if(StringUtils.isNotEmpty(office))
			criteria.add(Restrictions.eq("office", office));
		
		if(StringUtils.isNotEmpty(status))
			criteria.add(Restrictions.eq("status", Integer.parseInt(status)));
		
		if(StringUtils.isNotEmpty(title))
			criteria.add(Restrictions.or(Restrictions.like("title", title, MatchMode.ANYWHERE), 
					Restrictions.like("summary", title,  MatchMode.ANYWHERE)));
		
		if(StringUtils.isNotEmpty(startDate))
			criteria.add(Restrictions.ge("inDate", Date.valueOf(startDate)));
		
		if(StringUtils.isNotEmpty(endDate))
			criteria.add(Restrictions.le("inDate", Date.valueOf(endDate)));
		
		criteria.addOrder(Order.asc("status")).addOrder(Order.asc("isCompleted")).addOrder(Order.desc("inDate"));
		
		return receiptDAO.getListByCriteria(criteria, (page - 1)*pageCount, pageCount);
	}

	@Override
	public void remove(String id) throws ServiceException {
		// TODO Auto-generated method stub
		receiptDAO.remove(receiptDAO.get(id));
	}

	@Override
	public ReceiptModel save(ReceiptModel model) throws ServiceException {
		// TODO Auto-generated method stub
		if(model.getStatus() != null && model.getStatus() == 1){
			model.setRegistedDate(Date.valueOf(UtilDateTime.nowDateString("yyyy-MM-DD")));
			model.setIsCompleted(0);
		}
		receiptDAO.saveOrUpdate(model);
		return model;
	}

	@Override
	public void complete(String id) throws ServiceException {
		// TODO Auto-generated method stub
		ReceiptModel model = receiptDAO.get(id);
		model.setIsCompleted(1);
		receiptDAO.saveOrUpdate(model);
	}
}
