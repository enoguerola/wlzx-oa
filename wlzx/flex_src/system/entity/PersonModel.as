package system.entity
{
	import basic.entity.BaseModel;
	
	[Bindable]
	[RemoteClass(alias="system.entity.PersonModel")] 
	public class PersonModel extends BaseModel
	{
		public var name:String;
		public var sex:int;
		public var birthday: Date;
		public var nation: String;
		public var politicsStatus:int;
		public var homePhone:String;
		public var style:int;
		public var address:String;
		
		public var creationDate:Date;
		public var modifiedDate:Date;
		
		public var user:UserModel;
		
		public function PersonModel()
		{
			super();
		}
	}
}