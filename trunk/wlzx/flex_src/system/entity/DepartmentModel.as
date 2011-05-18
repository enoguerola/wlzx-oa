package system.entity
{
	[Bindable]
	[RemoteClass(alias="system.entity.DepartmentModel")] 
	public class DepartmentModel extends BaseModel
	{
		
		public var detail:String;
		public var phone:String;
		public var roles:Object=new Array();//部门角色集
		public var subordinates:Object=new Array();//直属下级部门
		public var leaders:Object=new Array();//直属上级部门
		public var dataAccessModes:Object=new Array();//部门数据访问权限
		public function DepartmentModel()
		{
		}
	}
}
