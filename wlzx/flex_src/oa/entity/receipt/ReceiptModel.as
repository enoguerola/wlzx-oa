package oa.entity.receipt
{
	import basic.entity.BaseModel;
	[Bindable]
	[RemoteClass(alias="system.wlims.oa.entity.receipt.ReceiptModel")]
	public class ReceiptModel extends BaseModel
	{
		public var doNumber:String;
		public var office:String;
		public var inNumber:String;
		public var inDate:Date;
		public var subject:Date;
		public var title:String;
		public var summary:String;
		public var status:int;
		public var isCompleted:int;
		public var registedDate:Date;
		
		public var attachments:Object = new Array();
		public function ReceiptModel()
		{
			super();
		}
	}
}