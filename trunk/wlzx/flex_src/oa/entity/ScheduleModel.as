package oa.entity
{
	import oa.entity.BaseModel;
	[Bindable]
	[RemoteClass(alias="system.wlims.oa.entity.schedule.ScheduleModel")] 
	public class ScheduleModel extends BaseModel
	{

		public var title:String;
		public var content:String;
		public var beginTime:String;
		public var endTime:String;
		public var posterId:String;
		public var departmentId:String;
		public var type:int;
		public var schoolShare:int;
		public var departmentShare:int;
		public var emergence:int;
		public var finishStatus:int;
		public var submitStatus:int;
		public var repeatStatus:int;
		public var repeatType:int;
		public var repeatInterval:int;
		public var repeatOnDays:String;
		public var repeatEndTime:String;
		public function ScheduleModel()
		{
			super();
		}
	}
}