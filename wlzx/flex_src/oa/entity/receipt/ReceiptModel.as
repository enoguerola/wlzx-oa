package oa.entity.receipt
{
	import basic.entity.BaseModel;
	
	import mx.collections.ArrayCollection;
	
	[Bindable]
	[RemoteClass(alias="system.wlims.oa.entity.receipt.ReceiptModel")]
	public class ReceiptModel extends BaseModel
	{
		public var doNumber:String;
		public var office:String;
		public var inNumber:String;
		public var inDate:Date;
		public var subject:String;
		public var title:String;
		public var summary:String;
		public var status:int;
		public var isCompleted:int;
		public var registedDate:Date;
		public var receiverId:String;
		public var fileFlows:ArrayCollection = new ArrayCollection();
		public var attachments:ArrayCollection = new ArrayCollection();
		public function ReceiptModel()
		{
			super();
		}
		public function getFirstDraftStepFlowId():String{
			for(var i:int=0;i<fileFlows.length;i++){
				if(fileFlows.getItemAt(i).type==0){
					return fileFlows.getItemAt(i).id;
				}
			}
			return null;
		}
	}
}