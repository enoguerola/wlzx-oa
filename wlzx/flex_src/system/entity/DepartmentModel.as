package system.entity
{
	[Bindable]
	[RemoteClass(alias="system.entity.DepartmentModel")] 
	public class DepartmentModel extends BaseModel
	{
		
		public var detail:String;
		public var indexPath:String;
		public var roles:Object;//部门角色集
		public var subordinates:Object;//直属下级部门
		public var leaders:Object;//直属上级部门
		public var dataAccessModes:Object;//部门数据访问权限
		public function DepartmentModel()
		{
		}
	}
}
