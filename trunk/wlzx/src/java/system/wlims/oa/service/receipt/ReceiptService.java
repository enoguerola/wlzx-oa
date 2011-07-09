package system.wlims.oa.service.receipt;

import java.util.List;

import system.ServiceException;
import system.wlims.oa.entity.receipt.ReceiptModel;

public interface ReceiptService {

  ReceiptModel save(ReceiptModel model)throws ServiceException;
  
  void remove(String id)throws ServiceException;
  
  ReceiptModel get(String id)throws ServiceException;
  
  List<ReceiptModel> get(String inNumber, String office, String doNumber, String status, 
		  String title, String startDate, String endDate, int page, int pageCount)throws ServiceException;
  
  String complete(String id)throws ServiceException;
  
  String register(String id)throws ServiceException;
}
