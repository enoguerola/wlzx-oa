package oa.entity.course.adjust
{
	
	import mx.collections.ArrayCollection;
	import oa.entity.BaseModel;
	[Bindable]
	[RemoteClass(alias="system.wlims.oa.entity.course.adjust.ApplyItemModel")] 
	public class ApplyItemModel extends BaseModel
	{
		
		public var applyClass:String;
		public var applyCourse:String;
		public var applyCourseDate:Date ;	
		public var applyCourseTime:String ;
		public var adjustMeanDate:Date;
		public var adjustMeanTime:String ;
		public var adjustMeanTeacherId:String ;
		public var adjustActualDate:Date ;
		public var adjustActualTime:String;	
		public var adjustActualTeacherId:String;
		public var adjustArrangeDate:Date ;
		public var adjustArrangeAlready:int ;
		public var apply:ApplyModel;
	
		public function ApplyItemModel()
		{
			super();
		}
		
		
	}
}
