package system.wlims.oa.serviceImpl.sendingFiles;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.jswiff.SWFDocument;
import com.jswiff.SWFWriter;
import com.jswiff.swfrecords.Matrix;
import com.jswiff.swfrecords.RGBA;
import com.jswiff.swfrecords.Rect;
import com.jswiff.swfrecords.tags.DefineEditText;
import com.jswiff.swfrecords.tags.DefineFont2;
import com.jswiff.swfrecords.tags.PlaceObject2;
import com.jswiff.swfrecords.tags.ShowFrame;

import system.DAOException;
import system.ServiceException;
import system.constants.Constants;
import system.utils.ResourcesUtils;
import system.utils.StringUtils;
import system.wlims.oa.dao.notice.AttachmentDAO;
import system.wlims.oa.dao.sendingFiles.SendingFileDAO;
import system.wlims.oa.entity.notice.AttachmentModel;
import system.wlims.oa.entity.sendingFiles.SendingFileModel;
import system.wlims.oa.service.sendingFiles.SendingFileService;

public class SendingFileServiceImpl implements SendingFileService {
	private SendingFileDAO sendingFileDAO;
	private AttachmentDAO attachmentDAO;

	@Override
	public List<SendingFileModel> getByConditions(
			String dispatchWord,String dispatchYear,String dispatchNumber, String title,
			String auspiceDepartment, String beginDate, String endDate,String states,Integer isCompleted)
			throws ServiceException {
		return sendingFileDAO.getByConditions(dispatchWord,dispatchYear,dispatchNumber, title, auspiceDepartment, beginDate, endDate, states,isCompleted);
	}

	@Override
	public SendingFileModel getById(String id) throws ServiceException {
		// TODO Auto-generated method stub
		return sendingFileDAO.get(id);
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

	@Override
	public String generateSWFById(String id) throws ServiceException {
		  SendingFileModel model=sendingFileDAO.get(id);
		  if(model==null)return null;
		  String dir = ResourcesUtils.getWebRootPath() + Constants.TEMP_SWF_OUTPUT_PATH;
		  File file = new File(dir);
		  if (!file.exists()) {
			file.mkdir();
		  }
		  String fileName = "sendingFile_"+id + ".swf";
		  String filePath = dir + "/"+fileName;
		  SWFDocument document = new SWFDocument();

		  int fontId = document.getNewCharacterId();
		  DefineFont2 defineFont2 = new DefineFont2(fontId, "Arial", null, null);
		  document.addTag(defineFont2);
		  int textId = document.getNewCharacterId();

		  DefineEditText defineEditText = new DefineEditText(
		   textId, new Rect(0, 0, 0, 0), null);
		  defineEditText.setAutoSize(true);
		  defineEditText.setFont(fontId, 20 * 24);
		  defineEditText.setTextColor(new RGBA(255, 0, 0, 255));
		  defineEditText.setReadOnly(true);
		  defineEditText.setHtml(true);
		  defineEditText.setMultiline(true);
		  defineEditText.setInitialText(model.getContent());
		  document.addTag(defineEditText);
		  PlaceObject2 placeObject2 = new PlaceObject2(1);
		  placeObject2.setCharacterId(textId);
		  placeObject2.setMatrix(new Matrix(20 * 45, 20 * 10));
		  document.addTag(placeObject2); // place text
		  document.addTag(new ShowFrame()); // show frame
	      try{
		    writeDocument(document, filePath);
		    return fileName;
	  	  }catch (IOException e){
		    System.out.println("An error occured while writing " + filePath + ":");
		    e.printStackTrace();
		    return null;
	      }
		 }
	

	 private static void writeDocument(SWFDocument document, String filePath)throws IOException {
		  SWFWriter writer = new SWFWriter(document, new FileOutputStream(filePath));
		  writer.write();
	 }
	

  
}
