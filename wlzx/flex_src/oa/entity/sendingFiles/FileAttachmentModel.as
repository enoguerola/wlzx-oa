package oa.entity.sendingFiles
{
	import oa.entity.BaseModel;
	[Bindable]
	[RemoteClass(alias="system.wlims.oa.entity.sendingFiles.FileAttachmentModel")]
	public class FileAttachmentModel extends BaseModel
	{
		public var name:String;
		public var path:String;
		public var type:String;
		public var date:Date;
		public var size:String;
		public var sendingFileModel:sendingFile;

		public function FileAttachmentModel()
		{
			super();
		}
	}
}