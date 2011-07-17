package oa.entity.receipt
{
	import basic.entity.BaseModel;
	[Bindable]
	[RemoteClass(alias="system.wlims.oa.entity.receipt.FileAttachmentModel")]
	public class FileAttachmentModel extends BaseModel
	{
		public var name:String;
		public var path:String;
		public var type:String;
		public var date:Date;
		
		public function FileAttachmentModel()
		{
			super();
		}
	}
}