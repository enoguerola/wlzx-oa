package system.wlims.basic.serviceImpl;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
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
			String searchType, String searchBuilding, Float areaBegin,
			Float areaEnd, Integer containBegin, Integer containEnd) {
		System.out.println(searchName+";"+searchType+";"+searchBuilding+";"+areaBegin+";"+areaEnd+";"+containBegin+";"+containEnd);
		DetachedCriteria criteria = DetachedCriteria.forClass(PlaceModel.class);
		if(!StringUtils.isEmpty(searchName)){
//			criteria.add(Restrictions.eq("name", searchName));
			criteria.add(Restrictions.like("name", searchName,MatchMode.ANYWHERE));

		}
		if(!StringUtils.isEmpty(searchType)){
			criteria.add(Restrictions.eq("type", searchType));
		}
		if(!StringUtils.isEmpty(searchBuilding)){
			criteria.add(Restrictions.like("position", searchBuilding,MatchMode.START));
		}
		if(areaBegin!=null){
			criteria.add(Restrictions.ge("areaBegin", areaBegin));
		}
		if(areaEnd!=null){
			criteria.add(Restrictions.le("areaEnd", areaEnd));
		}
		if(containBegin!=null){
			criteria.add(Restrictions.ge("containBegin", containBegin));
		}
		if(containEnd!=null){
			criteria.add(Restrictions.le("containEnd", containEnd));
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

	@Override
	public PlaceModel getPlaceById(String id) {
		// TODO Auto-generated method stub
		if(!StringUtils.isEmpty(id)){
			return placeDao.get(id);
		}
		return null;
	}

	@Override
	public PlaceModel placeAdd(PlaceModel place) {
		// TODO Auto-generated method stub
		place.setCreationDate(new Date());
		place.setModifiedDate(new Date());
		placeDao.saveOrUpdate(place);
		return place;
	}

	@Override
	public PlaceModel placeUpdate(PlaceModel place) {
		// TODO Auto-generated method stub
		place.setModifiedDate(new Date());
		placeDao.saveOrUpdate(place);
		return place;
	}

	

	
}
