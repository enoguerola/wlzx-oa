package system.wlims.oa.service.sendingFiles;

import java.util.List;

import system.ServiceException;
import system.wlims.oa.entity.sendingFiles.SendingFileModel;

public interface SendingFileService {


  @SuppressWarnings("unchecked")
  SendingFileModel addSendingFile(SendingFileModel model, List list)throws ServiceException;
  SendingFileModel updateSendingFile(SendingFileModel model,String adds,String removes)throws ServiceException;

  void removeById(String id)throws ServiceException;

  SendingFileModel getById(String id)throws ServiceException;

  List<SendingFileModel> getByConditions(String dispatchWord,String dispatchYear,String dispatchNumber,String title,String auspiceDepartment,String beginDate,String endDate,String states)throws ServiceException;

  boolean changeWorkFlow(String id,String nextState)throws ServiceException;
  String generateSWFById(String id)throws ServiceException;
}
