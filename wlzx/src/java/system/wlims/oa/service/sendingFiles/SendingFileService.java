package system.wlims.oa.service.sendingFiles;

import java.util.List;

import system.ServiceException;
import system.wlims.oa.entity.sendingFiles.SendingFileModel;
import system.wlims.oa.vo.SendingFileWorkFlowVO;

public interface SendingFileService {


  @SuppressWarnings("unchecked")
  SendingFileModel addSendingFile(SendingFileModel model, List list)throws ServiceException;
  SendingFileModel updateSendingFile(SendingFileModel model,String adds,String removes)throws ServiceException;

  void removeById(String id)throws ServiceException;
  boolean complete(String id)throws ServiceException;
  SendingFileModel getById(String id)throws ServiceException;

  List<SendingFileModel> getByConditions(String dispatchWord,String dispatchYear,String dispatchNumber,String title,String auspiceDepartment,String beginDate,String endDate,String states,Integer isCompleted)throws ServiceException;

 // boolean changeWorkFlow(String id,String nextState)throws ServiceException;//just for finish Draft depressed
  boolean finishWorkFlow(String flowId,String state,String text)throws ServiceException;

  String generateSWFById(String id)throws ServiceException;
  boolean addNextWorkFlows(String sendingFileId,String flowType,String userIds);
  
  List<SendingFileWorkFlowVO> getWorkFlowsByConditions(String dispatchWord,String dispatchYear,String dispatchNumber,String title,String auspiceDepartment,String beginDate,String endDate,String states,Integer isCompleted,String userId)throws ServiceException;

}
