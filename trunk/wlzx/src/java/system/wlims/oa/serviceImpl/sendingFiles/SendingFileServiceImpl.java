package system.wlims.oa.serviceImpl.sendingFiles;

import java.util.Date;
import java.util.List;

import system.DAOException;
import system.ServiceException;
import system.utils.StringUtils;
import system.wlims.oa.dao.notice.AttachmentDAO;
import system.wlims.oa.dao.sendingFiles.SendingFileDAO;
import system.wlims.oa.entity.notice.AttachmentModel;
import system.wlims.oa.entity.sendingFiles.FileFlowModel;
import system.wlims.oa.entity.sendingFiles.SendingFileModel;
import system.wlims.oa.service.sendingFiles.SendingFileService;

public class SendingFileServiceImpl implements SendingFileService {
	private SendingFileDAO sendingFileDAO;
	private AttachmentDAO attachmentDAO;

	@Override
	public List<SendingFileModel> getByConditions(
			String dispatchWord,String dispatchYear,String dispatchNumber, String title,
			String auspiceDepartment, String beginDate, String endDate,String states)
			throws ServiceException {
		return sendingFileDAO.getByConditions(dispatchWord,dispatchYear,dispatchNumber, title, auspiceDepartment, beginDate, endDate, states);
	}

	@Override
	public SendingFileModel getById(String id) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public void removeById(String id) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public SendingFileModel addSendingFile(SendingFileModel model,List list)
			throws ServiceException {
		// TODO Auto-generated method stub
		if(list != null && list.size() > 0){
			for(Object id : list){
				System.out.println(id);
				AttachmentModel attachmentModel = attachmentDAO.get((String)id);
				model.getAttachments().add(attachmentModel);
			}
		}
		model.setCreationDate(new Date());
		model.setStatus(SendingFileModel.EStatus.Drafting.getValue());
		
//		FileFlowModel flow=new FileFlowModel();
//		flow.setType(FileFlowModel.EType.Draft.getValue());
//		flow.setText(FileFlowModel.EType.Draft.getText());
//		
//		flow.setUser(model.getAuthorId());
//		model.getFileFlows().add(flow);
		sendingFileDAO.saveOrUpdate(model);

		return model;
	}


	@Override
	public SendingFileModel updateSendingFile(SendingFileModel model,String adds,String removes)
			throws ServiceException {
		try{
//			if(list != null && list.size() > 0){
//				for(Object id : list){
//					System.out.println(id);
//					AttachmentModel attachmentModel = attachmentDAO.get((String)id);
//					notice.getAttachments().add(attachmentModel);
//				}
//			}
			if(StringUtils.isNotEmpty(adds)){
				String[] adds_attr=adds.split(";");
				for(int i=0;i<adds_attr.length;i++){
					String id=adds_attr[i];
					if(StringUtils.isNotEmpty(id)){
						AttachmentModel attachmentModel = attachmentDAO.get(id);
						if(attachmentModel!=null)
							model.getAttachments().add(attachmentModel);
					}
				}
			}
			if(StringUtils.isNotEmpty(removes)){
				String[] removes_attr=removes.split(";");
				for(int i=0;i<removes_attr.length;i++){
					String id=removes_attr[i];
					if(StringUtils.isNotEmpty(id)){
						AttachmentModel attachmentModel =null;
						for(AttachmentModel a:model.getAttachments()){
							if(a.getId().equals(id)){
								attachmentModel=a;
								break;
							}
						}
						if(attachmentModel!=null)
							model.getAttachments().remove(attachmentModel);
					}
				}
			}
			sendingFileDAO.saveOrUpdate(model);
			return model;
		}catch (DAOException e){
			return null;
		}
	}
	@Override
	public boolean changeWorkFlow(String id, String nextState)
			throws ServiceException {
		// TODO Auto-generated method stub
		SendingFileModel model=sendingFileDAO.get(id);
		if(model==null)return false;
		model.setStatus(Integer.parseInt(nextState));
		sendingFileDAO.saveOrUpdate(model);
		return true;
	}
	public SendingFileDAO getSendingFileDAO() {
		return sendingFileDAO;
	}

	public void setSendingFileDAO(SendingFileDAO sendingFileDAO) {
		this.sendingFileDAO = sendingFileDAO;
	}

	public AttachmentDAO getAttachmentDAO() {
		return attachmentDAO;
	}

	public void setAttachmentDAO(AttachmentDAO attachmentDAO) {
		this.attachmentDAO = attachmentDAO;
	}

	

  
}
