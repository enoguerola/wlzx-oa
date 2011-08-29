package oa.entity.receipt
{
	import basic.entity.BaseModel;
	[Bindable]
	[RemoteClass(alias="system.wlims.oa.entity.receipt.FileFlowModel")]
	public class FileFlowModel extends BaseModel
	{
		public var type:int;
		public var isCompleted:int;
		public var text:String;
		//public var step:int;
		public var completedDate:Date;
		public var user:String;
		//public var department:String;
		public var receipt:ReceiptModel;
		
		public function FileFlowModel()
		{
			super();
		}
	}
}