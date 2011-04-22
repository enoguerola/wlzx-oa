package system.entity
{
	[Bindable]
	[RemoteClass(alias="system.entity.BaseModel")] 
	public class BaseModel
	{
		public var id:String;
		public var name:String;
		public var symbol:String;
		public var creationDate: Date;
		public var modifiedDate: Date ;
		public function BaseModel()
		{
		}
	}
}