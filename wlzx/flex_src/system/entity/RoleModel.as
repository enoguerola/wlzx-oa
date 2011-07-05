package system.entity
{
	import mx.collections.ArrayCollection;

	[Bindable]
	[RemoteClass(alias="system.entity.RoleModel")] 
	public class RoleModel extends BaseModel
	{

		
		public var supervisorFlag:Boolean=false;
		public var basicFlag:Boolean=false;
		public var detail:String;
		public var level:int;
		public var subordinates:Object=new Array();//直属下级角色
		public var leaders:Object=new Array();//直属上级角色
		public var users:Object=new Array();//角色用户集
		public var mainUsers:Object=new Array();//主角色用户集
		public var dataAccessModes:Object=new Array();//角色数据访问权限
		public var departments:Object=new Array();//所属部门集
		public var leadingDepartments:Object=new Array();//该角色所领导的部门集
		public function RoleModel()
		{
		}
		/** 
		 * 获取上级领导
		 * @创建时间 2011-4-15 上午10:41:15
		 */ 
		public  function getLeaderRole():RoleModel{
			var list:ArrayCollection = ArrayCollection(leaders);
			if(list!=null&&list.length>0){
				var _role:RoleModel = list.getItemAt(0) as RoleModel;	
				return _role;
			}
			
			return null;
		}
		public  function getAllUsers():ArrayCollection{
			var list:ArrayCollection = new ArrayCollection();
			for(var i:int=0;i<users.length;i++){
				list.addItem(users[i]);
			}
			for(var j:int=0;j<mainUsers.length;j++){
				list.addItem(mainUsers[j]);
			}
			
			return list;
		}

	}
}
