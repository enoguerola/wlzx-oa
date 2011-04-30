package system.entity
{
	[Bindable]
	[RemoteClass(alias="system.entity.UserModel")] 
	public class UserModel extends BaseModel
	{

		public var pwd:String;
		public var lastLoginTime:Date;
		public var lastLoginIP:String;
		public var email:String;
		public var subordinates:Object;//直属下级角色
		public var leaders:Object;//直属上级角色
		public var roles:Object;//角色集

		public function UserModel()
		{
		}
	}
}
