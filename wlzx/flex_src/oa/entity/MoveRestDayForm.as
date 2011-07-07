package oa.entity
{
	
	import mx.collections.ArrayCollection;
	
	import oa.entity.BaseModel;

	[Bindable]
	[RemoteClass(alias="system.wlims.oa.entity.workFlow.moveRestDay.MoveRestDayForm")] 
	public class MoveRestDayForm extends BaseModel
	{
		public var applyNo:String;
		public var teacherId:String;
		public var times:String;

		public var officeChiefApproverId:String;
		public var officeChiefApproveTime:Date;
		public var officeChiefApproveOption:String;
		public var vicePrincipalApproverId:String;
		public var vicePrincipalApproveTime:Date;
		public var vicePrincipalApproveOption:String; 
		
		public var status:int;
		public var officeChiefStatus:int;
		public var vicePrincipalStatus:int;
		public var logs:Object=new Array();
		
		public function MoveRestDayForm()
		{
			super();
		}
		
		
	}
}
