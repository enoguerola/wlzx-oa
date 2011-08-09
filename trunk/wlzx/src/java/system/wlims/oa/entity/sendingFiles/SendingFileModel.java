package system.wlims.oa.entity.sendingFiles;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;


import system.wlims.basic.entity.BaseModel;
import system.wlims.oa.entity.notice.AttachmentModel;

/**
 * 发文
 * @author Administrator
 *
 */
public class SendingFileModel extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1077456552278700041L;
	
	private String title;
	private String content;
	private String authorId;
	private Date creationDate;
	private String auspiceDepartment;
	private String subject;
	private String mainSends;
	private String upSends;
	private String downSends;
	private String dispatchWord;
	private String dispatchYear;
	private String dispatchNumber;
	private Date dispatchDate;
	private Integer status;
	private Set<AttachmentModel> attachments=new TreeSet<AttachmentModel>(); 
	private Set<FileFlowModel> fileFlows;
	public static enum EStatus{
		Drafting(0, "拟稿中"),
		Drafted(1, "拟稿完毕"),
		CheckDrafting(2, "核稿中"),
		CheckDrafted(3, "核稿完毕"),
		CounterSigning(4, "会签中"),
		CounterSigned(5, "会签完毕"),
		Issueing(6, "签发中"),
		Issueed(7, "签发完毕"),
		Circulateing(8, "传阅中"),
		Circulated(9, "传阅完毕");
		private int value;
		private String text;
		
		EStatus(int value, String text){
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

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getAuspiceDepartment() {
		return auspiceDepartment;
	}

	public void setAuspiceDepartment(String auspiceDepartment) {
		this.auspiceDepartment = auspiceDepartment;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMainSends() {
		return mainSends;
	}

	public void setMainSends(String mainSends) {
		this.mainSends = mainSends;
	}

	public String getUpSends() {
		return upSends;
	}

	public void setUpSends(String upSends) {
		this.upSends = upSends;
	}

	public String getDownSends() {
		return downSends;
	}

	public void setDownSends(String downSends) {
		this.downSends = downSends;
	}

	public String getDispatchWord() {
		return dispatchWord;
	}

	public void setDispatchWord(String dispatchWord) {
		this.dispatchWord = dispatchWord;
	}

	public String getDispatchYear() {
		return dispatchYear;
	}

	public void setDispatchYear(String dispatchYear) {
		this.dispatchYear = dispatchYear;
	}

	public String getDispatchNumber() {
		return dispatchNumber;
	}

	public void setDispatchNumber(String dispatchNumber) {
		this.dispatchNumber = dispatchNumber;
	}

	public Date getDispatchDate() {
		return dispatchDate;
	}

	public void setDispatchDate(Date dispatchDate) {
		this.dispatchDate = dispatchDate;
	}

	public Set<AttachmentModel> getAttachments() {
		return attachments;
	}

	public void setAttachments(Set<AttachmentModel> attachments) {
		this.attachments = attachments;
	}

	public Set<FileFlowModel> getFileFlows() {
		return fileFlows;
	}

	public void setFileFlows(Set<FileFlowModel> fileFlows) {
		this.fileFlows = fileFlows;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}


	
}
