package system.wlims.basic.dao;

import java.util.List;

import system.BaseDAO;
import system.wlims.basic.entity.PlaceModel;

public interface PlaceDao extends BaseDAO<PlaceModel>{
	List<PlaceModel> getPlacesByCondition(String searchName,String searchType,String searchBuilding,Float areaBegin,Float areaEnd,Integer containBegin,Integer containEnd);

}
