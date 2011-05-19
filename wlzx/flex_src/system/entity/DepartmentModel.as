package system.entity
{
	import mx.collections.ArrayCollection;
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
		/** 
		 * 获取部门主管角色
		 * @创建时间 2011-4-15 上午10:41:15
		 */ 
		public  function getSupervisorRole():Object{
			var list:ArrayCollection = ArrayCollection(roles);
			if(list!=null&&list.length>0){
				for (var i:int = 0; i < list.length; i++){
					var _role:Object = list.getItemAt(i);	
					if(_role.supervisorFlag==true)
						return _role;
				}
			}
			
			return null;
		}

	}
}
