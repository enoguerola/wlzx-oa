package system.wlims.basic.service;

import java.util.List;

import system.wlims.basic.entity.PlaceModel;

public interface PlaceService {
	
	List<PlaceModel> getPlacesByCondition(String searchName,String searchType,String searchBuilding,Float areaBegin,Float areaEnd,Integer containBegin,Integer containEnd);
	boolean deletePlace(String id);
	List<PlaceModel> getAllPlaces();
	PlaceModel placeAdd(PlaceModel place);
	PlaceModel placeUpdate(PlaceModel place);
	PlaceModel getPlaceById(String id);
}
