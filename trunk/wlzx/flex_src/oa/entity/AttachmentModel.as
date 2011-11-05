package oa.entity
{
	import basic.entity.BaseModel;
	[Bindable]
	[RemoteClass(alias="system.wlims.oa.entity.AttachmentModel")] 
	
	public class AttachmentModel extends BaseModel
	{
		public var belongObject:String;
		public var belongObjectId:String;
		public var name:String;
		public var path:String;
		public var type:String;
		public var size:String;
		public var date:Date;
		public function AttachmentModel()
		{
			super();
		}
	}
}