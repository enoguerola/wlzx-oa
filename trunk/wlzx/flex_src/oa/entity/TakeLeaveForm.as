package oa.entity
{
	
	import mx.collections.ArrayCollection;
	
	import oa.entity.BaseModel;

	[Bindable]
	[RemoteClass(alias="system.wlims.oa.entity.workFlow.takeLeave.TakeLeaveForm")] 
	public class TakeLeaveForm
	{
		public var id:String;
		public var applyNo:String;
		public var type:int;
		public var teacherId:String;
		public var beginTime:String;
		public var endTime:String;
		public var reason:String;
		public var arrangeTech:String;
		public var arrangeService:String;
		public var arrangeManage:String;
		public var officeChiefApproverId:String;
		public var officeChiefApproveTime:Date;
		public var officeChiefApproveOption:String;
		public var vicePrincipalApproverId:String;
		public var vicePrincipalApproveTime:Date;
		public var vicePrincipalApproveOption:String; 
		public var principalApproverId:String;
		public var principalApproveTime:Date;
		public var principalApproveOption:String; 
		public var remark:String;
		public var status:int;
		public var logs:Object=new Array();
		
		public function TakeLeaveForm()
		{
		}
		
		
	}
}
