package system.entity
{
	[Bindable]
	[RemoteClass(alias="system.entity.RoleModel")] 
	public class RoleModel extends BaseModel
	{

		
		public var supervisorFlag:Boolean;
		public var detail:String;
		public var subordinates:Object;//直属下级角色
		public var leaders:Object;//直属上级角色
		public var users:Object;//角色用户集
		public var dataAccessModes:Object;//角色数据访问权限
		public var departments:Object;//所属部门集
		public function RoleModel()
		{
		}
	}
}
