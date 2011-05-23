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
		public var subordinates:Object=new Array();//直属下级角色
		public var leaders:Object=new Array();//直属上级角色
		public var roles:Object=new Array();//角色集
		public var departments:Object=new Array();//所属部门集

		public function UserModel()
		{
		}
		public function getAllRoles():String
		{	var result:String="";
			var roleList:ArrayCollection = ArrayCollection(roles);
			for (var i:int = 0; i < roleList.length; i++){
				var _role:Object = roleList.getItemAt(i);	
				result=result.concat(_role.name).concat("  |  ");
			}
			return result;
		}
	}
}
