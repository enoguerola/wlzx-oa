package oa.entity
{
	import oa.entity.BaseModel;
	import system.utils.CommonUtils;
	[Bindable]
	[RemoteClass(alias="system.wlims.oa.entity.conference.ConferenceModel")] 
	public class ConferenceModel extends BaseModel
	{
		public var name:String;
		public var meetingDate:Date;
		public var beginTime:String;
		public var endTime:String;
		public var attendNum:String;
		public var teacherAttendIds:String;
		public var departmentId:String;
		public var placeId:String;
		public var contactUserId:String;
		public var contactPhoneNumber:String;
		public var serviceNeeded:String;
		public var description:String;
		public var applyUserId:String;
		public var applyDateTime:Date;
		public var summaryAttachments:Object=new Array(); 
		public var attachments:Object=new Array(); 
		public var applyStatus:int;
		public function ConferenceModel()
		{
			super();
		}
		public function getTime():String{
			return CommonUtils.formatDate(meetingDate,"YYYY-MM-DD")+" "+beginTime+"--"+endTime;
		}
	}
}