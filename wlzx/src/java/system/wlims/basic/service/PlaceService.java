package system.wlims.basic.service;

import java.util.List;

import system.wlims.basic.entity.PlaceModel;

public interface PlaceService {
	
	List<PlaceModel> getPlacesByCondition(String searchName,String searchPlace,String searchBuilding,Integer areaBegin,Integer areaEnd,Integer containBegin,Integer containEnd);
	boolean deletePlace(String id);
	List<PlaceModel> getAllPlaces();
}
