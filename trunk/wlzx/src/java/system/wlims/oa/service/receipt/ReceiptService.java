package system.wlims.oa.service.receipt;

import java.util.List;

import system.ServiceException;
import system.wlims.oa.entity.receipt.ReceiptModel;
import system.wlims.oa.vo.ReceiptWorkFlowVO;

public interface ReceiptService {

  /**
   * 
   * @param model
   * @return
   * @throws ServiceException
   */
  ReceiptModel save(ReceiptModel model)throws ServiceException;
  
  /**
   * 
   * @param id
   * @throws ServiceException
   */
  void remove(String id)throws ServiceException;
  
  /**
   * 
   * @param id
   * @return
   * @throws ServiceException
   */
  ReceiptModel get(String id)throws ServiceException;
  
  /**
   * 
   * @param inNumber
   * @param office
   * @param doNumber
   * @param status
   * @param title
   * @param startDate
   * @param endDate
   * @param page
   * @param pageCount
   * @return
   * @throws ServiceException
   */
  List<ReceiptModel> get(String inNumber, String office, String doNumber, String status, 
		  String title, String startDate, String endDate, int page, int pageCount)throws ServiceException;
  
  /**
   * 
   * @param id
   * @return
   * @throws ServiceException
   */
  String complete(String id)throws ServiceException;
  
  
  /**
   * 
   * @param id
   * @return
   * @throws ServiceException
   */
  String uncomplete(String id)throws ServiceException;
  
  /**
   * 
   * @param id
   * @return
   * @throws ServiceException
   */
  String register(String id)throws ServiceException;
  
  
  @SuppressWarnings("unchecked")
  ReceiptModel addReceipt(ReceiptModel model, String list)throws ServiceException;
  ReceiptModel updateReceipt(ReceiptModel model,String adds,String removes)throws ServiceException;
  boolean addNextWorkFlows(String receiptId,String flowType,String userIds);
  boolean finishWorkFlow(String flowId,String state,String text)throws ServiceException;
  List<ReceiptWorkFlowVO> getWorkFlowsByConditions(String inNumber, String office, String doNumber,String title,String subject,String summary,String startDate,String endDate,String states,Integer isCompleted,String userId)throws ServiceException;


}
