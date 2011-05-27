package system.wlims.basic.service;

import java.util.List;

import system.wlims.basic.entity.DirectoryModel;

public interface DirectoryService {
	List<DirectoryModel> getDirectoryItemsByType(String type);
	boolean saveDirectoryItem(String id,String type,String name,String value,int sequence,String extraValue);
	boolean deleteDirectoryItem(String id);
}
