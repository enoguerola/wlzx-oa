package oa.entity.logistics
{
	
	import mx.collections.ArrayCollection;
	
	import oa.entity.BaseModel;

	[Bindable]
	[RemoteClass(alias="system.wlims.oa.entity.logistics.PurchaseApplyModel")] 
	public class PurchaseApplyModel extends BaseModel
	{
		public var applyNo:String;
		public var purchaseName:String;
		public var purchaseDescription:String;

		public var isGovernmentPurchase:Boolean;
		public var applyUser:Date;
		public var applyUserDepartmentId:String;
		public var applyTime:Date;
		public var money:Number; 
		
		public var applyUserDepartmentLeader:String;
		public var resourceDepartmentLeader:String;
		public var applyUserViceHeaderMaster:String;
		public var financeViceHeaderMaster:String;
		public var headerMaster:String;
		
		
		
		public function PurchaseApplyModel()
		{
			super();
		}
		
		
	}
}
