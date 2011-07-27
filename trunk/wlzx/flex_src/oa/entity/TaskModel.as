package oa.entity
{
	import oa.entity.BaseModel;
	[Bindable]
	[RemoteClass(alias="system.wlims.oa.entity.task.TaskModel")] 
	public class TaskModel extends BaseModel
	{
		
		public var title:String;
		public var content:String;
		public var assignerId:String;
		public var workerIds:String;
		public var workerStatus:String;
		public var postTime:Date;
		public var lastEditorId:String;
		public var lastEditTime:Date;
		public var status:int;
		public function TaskModel()
		{
			super();
		}
	}
}