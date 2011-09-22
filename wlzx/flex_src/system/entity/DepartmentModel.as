package system.entity
{
	import mx.collections.ArrayCollection;
	
	import oa.receipt.component.item.Department;

	[Bindable]
	[RemoteClass(alias="system.entity.DepartmentModel")] 
	public class DepartmentModel extends BaseModel
	{
		
		public var detail:String;
		public var phone:String;
		public var level:int;
		public var roles:Object=new Array();//部门角色集
		public var subordinates:Object=new Array();//直属下级部门
		public var leaders:Object=new Array();//直属上级部门
	
//		public var mainUsers:Object=new Array();//主部门用户集
		
		public var leaderUsers:Object=new Array();//直属领导用户集
		public var masterUsers:Object=new Array();//部门普通用户集
		public var relativeDRs:Object=new Array();

		
		public function DepartmentModel()
		{
			super();
		}
		/** 
		 * 获取部门主管角色
		 * @创建时间 2011-4-15 上午10:41:15
		 */ 
//		public  function getSupervisorRole():RoleModel{
//			var list:ArrayCollection = ArrayCollection(roles);
//			if(list!=null&&list.length>0){
//				for (var i:int = 0; i < list.length; i++){
//					var _role:RoleModel = list.getItemAt(i) as RoleModel;	
//					if(_role.supervisorFlag==true)
//						return _role;
//				}
//			}
//			
//			return null;
//		}
//		/** 
//		 * 获取上级部门
//		 * @创建时间 2011-4-15 上午10:41:15
//		 */ 
//		public  function getLeaderDepartment():DepartmentModel{
//			var list:ArrayCollection = ArrayCollection(leaders);
//			if(list!=null&&list.length>0){
//					var _department:DepartmentModel = list.getItemAt(0) as DepartmentModel;	
//					return _department;
//			}
//			
//			return null;
//		}
//		/** 
//		 * 获取上级部门至一级部门级别
//		 * @创建时间 2011-4-15 上午10:41:15
//		 */ 
//		public  function getLeaderDepartment2FirstLevel():DepartmentModel{
//			var parent:DepartmentModel=this;
//			do{
//				parent=parent.getLeaderDepartment();
//			}while(parent.level!=1&&parent.level!=0)
//			return parent;
//		}
////		//获得部门及子部门所有用户集
////		public function getUsers():ArrayCollection{
////			var results:ArrayCollection=ArrayCollection(mainUsers);
////			if(this.getAllRoles()!=null&&this.getAllRoles().length>0)
////			for (var i:int = 0; i < this.getAllRoles().length; i++){
////				var _role:RoleModel = this.getAllRoles().getItemAt(i) as RoleModel;
////				if(_role.getAllUsers()!=null&&_role.getAllUsers().length>0){
////					for (var j:int = 0; j < _role.getAllUsers().length; j++){
////						results.addItem(_role.getAllUsers().getItemAt(j));
////					}
////				}
////			}
////			return results;
////		}
////		//获得部门及子部门所有岗位
////		public function getAllRoles():ArrayCollection{
////			var result:ArrayCollection=new ArrayCollection();
////			for (var i:int = 0; i < roles.length; i++){
////				result.addItem(roles[i]);
////				addSubRoles(roles[i],result);
////			}
////			return result;
////		}
////		public function addSubRoles(role:RoleModel ,result:ArrayCollection):void{
////			if(role==null)return ;
////			for (var i:int = 0; i < role.subordinates.length; i++){
////				result.addItem(role.subordinates[i]);
////				addSubRoles(role.subordinates[i],result);
////			}
////			
////		}
//		//获得所有子部门
//		public function getAllSubordinates():ArrayCollection{
//			var results:ArrayCollection=new ArrayCollection();
//			addSubordinates(this,results);
//			return results;
//		}
//		public function addSubordinates(department:DepartmentModel,results:ArrayCollection):void{
//			if(department.subordinates!=null&&department.subordinates.length>0){
//				var list:ArrayCollection=ArrayCollection(this.getAllSubordinates());
//				for (var i:int = 0; i < list.length; i++){
//					var sub:DepartmentModel=list.getItemAt(i) as DepartmentModel;
//					results.addItem(sub);
//					addSubordinates(sub,results);
//				}
//			}
//		}
//		//获得部门及子部门所有用户集
//		
//		public  function getAllUsers():ArrayCollection{
//			var results:ArrayCollection=new ArrayCollection();
//			var list:ArrayCollection=ArrayCollection(this.getAllSubordinates());
//
//			for (var i:int = 0; i < list.length; i++){
//				var department:DepartmentModel=list.getItemAt(i) as DepartmentModel;
//				var users:ArrayCollection= department.getSelfUsers();
//				for (var j:int = 0; j <users.length; j++){
//					results.addItem(users.getItemAt(j));
//				}
//			}
//				
//			
//			return results;
//		}
//		//获得本部门所有用户集
//		public  function getSelfUsers():ArrayCollection{
//			var results:ArrayCollection=ArrayCollection(mainUsers);
//			var list:ArrayCollection = ArrayCollection(commonUsers);
//			for (var i:int = 0; i < list.length; i++){
//				results.addItem(list.getItemAt(i));
//			}
//		
//			return results;
//		}
	}
}
