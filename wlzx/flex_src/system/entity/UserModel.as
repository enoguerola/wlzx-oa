package system.entity
{
	import mx.collections.ArrayCollection;
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
		public function getAllRole():String
		{	var result:String="";
			var roleList:ArrayCollection = ArrayCollection(roles);
			for (var i:int = 0; i < roleList.length; i++){
				var _role:Object = roleList.getItemAt(i);	
				result=result.concat(_role.name);
			}
			return result;
		}
	}
}
