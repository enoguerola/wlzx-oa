package system.wlims.basic.daoImpl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import system.BaseDAOImpl;
import system.utils.StringUtils;
import system.wlims.basic.dao.PlaceDao;
import system.wlims.basic.entity.PlaceModel;

public class PlaceDaoImpl extends BaseDAOImpl<PlaceModel> implements PlaceDao {
	@SuppressWarnings("unchecked")
	public List<PlaceModel> getPlacesByCondition(String searchName,
			String searchType, String searchBuilding, Float areaBegin,
			Float areaEnd, Integer containBegin, Integer containEnd) {
		//System.out.println(searchName+";"+searchType+";"+searchBuilding+";"+areaBegin+";"+areaEnd+";"+containBegin+";"+containEnd);
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
		List<PlaceModel> result = getListByCriteria(criteria);
		return result;
	}
}
