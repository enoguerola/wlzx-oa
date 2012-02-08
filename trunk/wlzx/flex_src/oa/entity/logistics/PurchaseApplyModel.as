package oa.entity.logistics
{
	
	import mx.collections.ArrayCollection;
	
	import oa.entity.BaseModel;

	[Bindable]
	[RemoteClass(alias="system.wlims.oa.entity.logistics.PurchaseApplyModel")] 
	public class PurchaseApplyModel extends BaseModel
	{
		public var processInstanceId:String;
		public var applyNo:String;
		public var purchaseName:String;
		public var purchaseDescription:String;

		public var isGovernmentPurchase:Boolean;
		public var applyUser:String;
		public var applyUserDepartmentId:String;
		public var applyTime:Date;
		public var money:Number=0; 
		
		public var applyUserDepartmentLeader:String;
		public var resourceDepartmentLeader:String;
		public var applyUserViceHeaderMaster:String;
		public var financeViceHeaderMaster:String;
		public var headerMaster:String;
		public var cancleFlag:Boolean;
		public var submitFlag:Boolean;
		public var state:String;//辅助
		public function PurchaseApplyModel()
		{
			super();
		}
		
		
	}
}
