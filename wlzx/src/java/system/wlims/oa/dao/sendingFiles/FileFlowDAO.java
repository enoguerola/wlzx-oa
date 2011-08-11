package system.wlims.oa.dao.sendingFiles;

import java.util.List;

import system.BaseDAO;
import system.DAOException;
import system.wlims.oa.entity.sendingFiles.FileFlowModel;

public interface FileFlowDAO extends BaseDAO<FileFlowModel> {


	/**
	 * 得到所有 某step的FileFlowModel list
	 * @param sendingFiles
	 * @param step
	 * @return FileFlowModel中sendingFiles被置为null
	 * @throws DAOException
	 */
	//List<FileFlowModel> getList(SendingFileModel sendingFiles, Integer step)throws DAOException;
	
	/**
	 * 得到某步之前 所有 FileFlowModel List
	 * @param sendingFiles
	 * @param maxStep
	 * @return
	 * @throws DAOException
	 */
	//List<FileFlowModel> getAllBefore(SendingFileModel sendingFiles, Integer maxStep)throws DAOException;
	
	/**
	 * 得到所有 某type的FileFlowModel list
	 * @param sendingFiles
	 * @param type
	 * @return
	 * @throws DAOException
	 */
	List<FileFlowModel> getListByType(String sendingFileId, Integer type)throws DAOException;
	
}
