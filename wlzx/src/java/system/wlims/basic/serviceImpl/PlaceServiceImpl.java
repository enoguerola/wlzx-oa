package system.wlims.basic.serviceImpl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;


import system.utils.StringUtils;
import system.wlims.basic.dao.PlaceDao;
import system.wlims.basic.entity.PlaceModel;
import system.wlims.basic.service.PlaceService;


public class PlaceServiceImpl implements PlaceService {
	private PlaceDao placeDao;

	public PlaceDao getPlaceDao() {
		return placeDao;
	}

	public void setPlaceDao(PlaceDao placeDao) {
		this.placeDao = placeDao;
	}

	@Override
	public boolean deletePlace(String id) {
		// TODO Auto-generated method stub
		if(!StringUtils.isEmpty(id)){
			PlaceModel model=placeDao.get(id);
			if(model==null)return false;
			placeDao.remove(model);
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlaceModel> getPlacesByCondition(String searchName,
			String searchPlace, String searchBuilding, Integer areaBegin,
			Integer areaEnd, Integer containBegin, Integer containEnd) {
		DetachedCriteria criteria = DetachedCriteria.forClass(PlaceModel.class);
		if(!StringUtils.isEmpty(searchName)){
			criteria.add(Restrictions.eq("name", searchName));
		}
		if(!StringUtils.isEmpty(searchPlace)){
			criteria.add(Restrictions.eq("place", searchPlace));
		}
		if(!StringUtils.isEmpty(searchBuilding)){
			criteria.add(Restrictions.eq("position", searchBuilding));
		}
		if(areaBegin!=null){
			criteria.add(Restrictions.sizeGe("areaNum", areaBegin));
		}
		if(areaEnd!=null){
			criteria.add(Restrictions.sizeLe("areaNum", areaEnd));
		}
		if(containBegin!=null){
			criteria.add(Restrictions.sizeGe("containNum", containBegin));
		}
		if(containEnd!=null){
			criteria.add(Restrictions.sizeLe("containNum", containEnd));
		}
		
		criteria.addOrder(Order.asc("symbol"));
		List<PlaceModel> result = placeDao.getListByCriteria(criteria);
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlaceModel> getAllPlaces() {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(PlaceModel.class);		
		List<PlaceModel> result = placeDao.getListByCriteria(criteria);
		return result;
	}

	
}
