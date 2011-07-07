package oa.entity
{
	
	import mx.collections.ArrayCollection;
	
	import oa.entity.BaseModel;

	[Bindable]
	[RemoteClass(alias="system.wlims.oa.entity.workFlow.overWork.OverWorkForm")] 
	public class OverWorkForm extends BaseModel
	{
		public var applyNo:String;
		public var teacherId:String;
		public var times:String;
		public var reason:String;
		
		public var officeChiefApproverId:String;
		public var officeChiefApproveTime:Date;
		public var officeChiefApproveOption:String;
		
		public var officeChiefStatus:int;
		public var status:int;
		public var logs:Object=new Array();
		
		public function OverWorkForm()
		{
			super();
		}
		
		
	}
}
