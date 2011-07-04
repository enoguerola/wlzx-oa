package oa.entity.course.adjust
{
	
	import mx.collections.ArrayCollection;
	import oa.entity.BaseModel;

	[Bindable]
	[RemoteClass(alias="system.wlims.oa.entity.course.adjust.ApplyModel")] 
	public class ApplyModel extends BaseModel
	{
		
		public var applyNo:String;
		public var applyType:int;
		public var applyTeacherId:String;	
		public var applyReason:String;
		public var applyStatus:int;
		public var approveTeacherId:String ;
		public var approveRemark:String ;
		public var approveDate:Date;	
		public var applyCreationDate:Date;
		public var applyItems:Object=new Array();
		public var logs:Object=new Array();
		public function ApplyModel()
		{
		}
		
		
	}
}
