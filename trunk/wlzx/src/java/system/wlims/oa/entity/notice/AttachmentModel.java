package system.wlims.oa.entity.notice;

import java.util.Set;
import java.util.TreeSet;

import system.wlims.oa.entity.BaseModel;
import system.wlims.oa.entity.conference.ConferenceModel;

public class AttachmentModel extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3049622687536503053L;
	private String name;
	private String path;
	private String type;
	private String size;
	private Set<NoticeModel> notices=new TreeSet<NoticeModel>();//仅用于删除通知附件时级联删除两者关系
	private Set<ConferenceModel> conferences1=new TreeSet<ConferenceModel>();//仅用于删除会议附件时级联删除两者关系
	private Set<ConferenceModel> conferences2=new TreeSet<ConferenceModel>();//仅用于删除会议总结附件时级联删除两者关系
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public Set<NoticeModel> getNotices() {
		return notices;
	}
	public void setNotices(Set<NoticeModel> notices) {
		this.notices = notices;
	}
	public Set<ConferenceModel> getConferences1() {
		return conferences1;
	}
	public void setConferences1(Set<ConferenceModel> conferences1) {
		this.conferences1 = conferences1;
	}
	public Set<ConferenceModel> getConferences2() {
		return conferences2;
	}
	public void setConferences2(Set<ConferenceModel> conferences2) {
		this.conferences2 = conferences2;
	}

}
