package oa.entity.sendingFiles
{
	import oa.entity.BaseModel;
	[Bindable]
	[RemoteClass(alias="system.wlims.oa.entity.sendingFiles.FileFlowModel")]
	public class FileFlowModel extends BaseModel
	{
		public var type:int;
		public var isCompleted:int;
		public var text:String;
		public var completedDate:Date;
		public var user:String;
		public var sendingFileModel:sendingFile;

		public function FileFlowModel()
		{
			super();
		}
	}
}