package system.wlims.oa.entity.task;

import java.util.Date;

import system.wlims.oa.entity.BaseModel;

public class TaskModel extends BaseModel {


	/**
	 * 
	 */
	private static final long serialVersionUID = 3765023301911321085L;
	private String title;
	private String content;
	private String assignerId;
	private Date postTime;
	private String workerIds;
	private String workerStatus;
	private String lastEditorId;
	private Date lastEditTime;
	private Integer status;
	
	
	public static enum EStatus{
		OnGoing(0, "进行中"),
		Finished(1, "已完成 ");
		
		private Integer value;
		private String text;
		
		EStatus(Integer value, String text){
			this.value = value;
			this.text = text;
		}
		
		public Integer getValue(){
			return value;
		}
		
		public String getText(){
			return this.text;
		}
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getAssignerId() {
		return assignerId;
	}


	public void setAssignerId(String assignerId) {
		this.assignerId = assignerId;
	}


	public Date getPostTime() {
		return postTime;
	}


	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}


	public String getWorkerIds() {
		return workerIds;
	}


	public void setWorkerIds(String workerIds) {
		this.workerIds = workerIds;
	}


	public String getLastEditorId() {
		return lastEditorId;
	}


	public void setLastEditorId(String lastEditorId) {
		this.lastEditorId = lastEditorId;
	}


	public Date getLastEditTime() {
		return lastEditTime;
	}


	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public String getWorkerStatus() {
		return workerStatus;
	}


	public void setWorkerStatus(String workerStatus) {
		this.workerStatus = workerStatus;
	}
	
	public String getStatusByWorkerId(String workerId){
		String[] workerIdsAttr=workerIds.split(";");
		String[] workerStatusAttr= workerStatus.split(";");
		for(int i=0;i<workerIdsAttr.length;i++){
			if(workerIdsAttr[i].equals(workerId)){
				return workerStatusAttr[i];
			}
		}
		return null;
	}
	public void setStatusByWorkerId(String state,String workerId){
		String[] workerIdsAttr=workerIds.split(";");
		String[] workerStatusAttr= workerStatus.split(";");
		for(int i=0;i<workerIdsAttr.length;i++){
			if(workerIdsAttr[i].equals(workerId)){
				String result="";
				for(int j=0;j<i;j++){
					result+=workerStatusAttr[j]+";";
				}
				result+=state+";";
				for(int k=i+1;k<workerStatusAttr.length;k++){
					result+=workerStatusAttr[k]+";";
				}
				setWorkerStatus(result);
			}
		}
		
	}
	public boolean isAllFinished(){
		String[] workerStatusAttr= workerStatus.split(";");
		for(int i=0;i<workerStatusAttr.length;i++){
			if(!workerStatusAttr[i].equals(TaskModel.EStatus.Finished.getValue().intValue()+"")){
				return false;
			}
		}
		return true;
	}
}
