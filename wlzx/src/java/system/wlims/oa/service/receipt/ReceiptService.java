package system.wlims.oa.service.receipt;

import java.util.List;

import system.ServiceException;
import system.wlims.oa.entity.receipt.ReceiptModel;

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
  String register(String id)throws ServiceException;
}
