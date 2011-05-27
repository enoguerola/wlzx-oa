package system.wlims.basic.serviceImpl;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import system.utils.StringUtils;
import system.wlims.basic.dao.DirectoryDao;
import system.wlims.basic.entity.DirectoryModel;
import system.wlims.basic.service.DirectoryService;

public class DirectoryServiceImpl implements DirectoryService {
	private DirectoryDao directoryDao;

	public DirectoryDao getDirectoryDao() {
		return directoryDao;
	}

	public void setDirectoryDao(DirectoryDao directoryDao) {
		this.directoryDao = directoryDao;
	}

	@Override
	public boolean deleteDirectoryItem(String id) {
		// TODO Auto-generated method stub
		if(!StringUtils.isEmpty(id)){
			DirectoryModel model=directoryDao.get(id);
			if(model==null)return false;
			directoryDao.remove(model);
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DirectoryModel> getDirectoryItemsByType(String type) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(DirectoryModel.class);
		criteria.add(Restrictions.eq("type", type));
		criteria.addOrder(Order.asc("sequence"));
		List<DirectoryModel> result = directoryDao.getListByCriteria(criteria);
		return result;
	}

	@Override
	public boolean saveDirectoryItem(String id, String type, String name,
			String value, int sequence,String extraValue) {
		if(StringUtils.isEmpty(id)){
			DirectoryModel model=new DirectoryModel();
			model.setType(type);
			model.setName(name);
			model.setValue(value);
			model.setExtraValue(extraValue);
			model.setSequence(sequence);
			model.setCreationDate(new Date());
			model.setModifiedDate(model.getCreationDate());
			directoryDao.saveOrUpdate(model);
		}else{
			DirectoryModel model=directoryDao.get(id);
			model.setName(name);
			model.setValue(value);
			model.setExtraValue(extraValue);
			model.setSequence(sequence);
			model.setModifiedDate(new Date());
			directoryDao.saveOrUpdate(model);
		}
		return true;
	}
}
