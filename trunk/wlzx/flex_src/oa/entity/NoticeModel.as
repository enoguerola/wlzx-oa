package oa.entity
{
	import oa.entity.BaseModel;
	[Bindable]
	[RemoteClass(alias="system.wlims.oa.entity.notice.NoticeModel")] 
	public class NoticeModel extends BaseModel
	{
		public var scope:int;
		public var type:String;
		public var postDepartmentId:String;
		public var posterId:String;
		public var emergence:int;
		public var title:String;
		public var content:String;
		public var postTime:Date;
		public var lastEditorId:String;
		public var lastEditTime:Date;
		public var attachments:Object=new Array(); 
		public var status:int;
		public var readNums:int=0;
		public function NoticeModel()
		{
			super();
		}
	}
}