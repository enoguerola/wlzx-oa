package oa.entity
{
	
	import mx.collections.ArrayCollection;
	
	import oa.entity.BaseModel;

	[Bindable]
	[RemoteClass(alias="system.wlims.oa.entity.workFlow.takeLeave.TakeLeaveForm")] 
	public class TakeLeaveForm extends BaseModel
	{
		public var applyNo:String;
		public var type:int;
		public var teacherId:String;
		public var beginTime:String;
		public var endTime:String;
		public var reason:String;
		public var arrangeTech:String;
		public var arrangeService:String;
		public var arrangeManage:String;
		public var arrangeTechDealAlready:Boolean;
		public var arrangeServiceDealAlready:Boolean;
		public var arrangeManageDealAlready:Boolean;
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
		public var officeChiefStatus:int;
		public var vicePrincipalStatus:int;
		public var principalStatus:int;
		public var logs:Object=new Array();
		public var terminateForms:Object=new Array();
		//public var takeLeaveTerminateForm:Object=null;
		public function TakeLeaveForm()
		{
			super();
		};
		public function getTakeLeaveTerminateForm():Object{
			if(terminateForms!=null&&ArrayCollection(terminateForms).length>0){
				return ArrayCollection(terminateForms).getItemAt(0);
			}
			else return null;
		};
		
	}
}
