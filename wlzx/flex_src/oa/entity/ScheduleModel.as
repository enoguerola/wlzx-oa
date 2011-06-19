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
		public var endTime:int;
		public var posterId:String;
		public var departmentId:String;
		public var type:int;
		public var share:int;
		public var emergence:int;
		public var finishStatus:int;
		public var submitStatus:int;
		public function ScheduleModel()
		{
			super();
		}
	}
}