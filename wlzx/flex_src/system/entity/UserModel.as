package system.entity
{
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	
	import system.utils.CommonUtils;
	[Bindable]
	[RemoteClass(alias="system.entity.UserModel")] 
	
	public class UserModel extends BaseModel
	{

		public var pwd:String;
		public var active:Boolean;
		public var lastLoginTime:Date;
		public var lastLoginIP:String;
		public var email:String;
		public var person:Object=new Object();
		public var personName:String;
		
		public var mainDR:Object;
		public var drs:Object=new Array();
		
		public var authorizations:Object=new Array();////辅助
		
		private var leaderDepartments:Object=new Array();//领导部门
		private var masterDepartments:Object=new Array();//主管部门
		
	
		
	
		
		
		
		public function UserModel()
		{
			super();
		}
		public function getAllDRs():ArrayCollection
		{	var results:ArrayCollection = new ArrayCollection();
			if(mainDR!=null&&mainDR.id!=null&&mainDR.id!='')
				results.addItem(mainDR);
			var drList:ArrayCollection = ArrayCollection(drs);
			if(drList!=null&&drList.length>0)
			for (var i:int = 0; i < drList.length; i++){
				var _dr:Object = drList.getItemAt(i);	
				if(_dr!=null&&!results.contains(_dr))
					results.addItem(_dr);
			}
			return results;
		}
		public function getAllRoleIds():String
		{	
			var results:String = "";
			var drList:ArrayCollection=getAllDRs();
			if(drList!=null&&drList.length>0)
			for (var i:int = 0; i < drList.length; i++){
				var _dr:Object = drList.getItemAt(i);	
				results+=(_dr.roleId+";");
			}

			return results;
		}
//		public function getAllRoles():String
//		{	var result:String="";
//			if(mainRole!=null)
//			result=result.concat(mainRole.name).concat("  |  ");
//			var roleList:ArrayCollection = ArrayCollection(roles);
//			CommonUtils.sortByCondition(roleList,'level');
//			for (var i:int = 0; i < roleList.length; i++){
//				var _role:Object = roleList.getItemAt(i);	
//				result=result.concat(_role.name).concat("  |  ");
//			}
//			return result;
//		}
//		public function getAllRolesList():ArrayCollection
//		{	var results:ArrayCollection = new ArrayCollection();
//			if(mainRole!=null)
//			results.addItem(mainRole);
//			var roleList:ArrayCollection = ArrayCollection(roles);
//			CommonUtils.sortByCondition(roleList,'level');
//			for (var i:int = 0; i < roleList.length; i++){
//				var _role:Object = roleList.getItemAt(i);	
//				results.addItem(_role);
//			}
//			return results;
//		}
//		//获得用户所属部门集
//		public function getAllDepartments():ArrayCollection{
//			var results:ArrayCollection = new ArrayCollection();
//			if(mainDepartment!=null)
//				results.addItem(mainDepartment);
//			var departmentsList:ArrayCollection = ArrayCollection(departments);
//			for (var i:int = 0; i < departmentsList.length; i++){
//				var _department:Object = departmentsList.getItemAt(i);	
//				results.addItem(_department);
//			}
//			
//			return results;
//		}
////		public function getDepartments():ArrayCollection
////		{	var results:ArrayCollection = new ArrayCollection();
////			var list:ArrayCollection=getAllRolesList();
////			for (var i:int = 0; i < list.length; i++){
////				var _role:Object = list.getItemAt(i);	
////				if(_role.getBelongDepartment()!=null){
////					if(results.contains(_role.getBelongDepartment())==false)
////					results.addItem(_role.getBelongDepartment());
////				}
////			}
////			return results;
////		}
//		public function getAllDams():Array
//		{	
////			var damList:Array = new Array();
////			var roleList:ArrayCollection = ArrayCollection(roles);
////			if(mainRole!=null)roleList.addItem(mainRole);
////			for (var i:int = 0; i < roleList.length; i++){
////				var _role:Object = roleList.getItemAt(i);	
////				for (var j:int = 0; j < _role.dataAccessModes.length; j++){
////					var _dam:Object = _role.dataAccessModes.getItemAt(j);	
////					damList.push(_dam.symbol);
////				}
////			}
////			return damList;
//			var damList:Array = new Array();
//			var auths:ArrayCollection = ArrayCollection(authorizations);
//			for (var j:int = 0; j < auths.length; j++){
//				var _dam:Object = auths.getItemAt(j);	
//				damList.push(_dam.symbol);
//			}
//			return damList;
//		}
//		public function hasDam(symbol:String):Boolean
//		{	
//			var has:Boolean=false;
//			var damList:Array =getAllDams();
//			for (var i:int = 0; i < damList.length; i++){
//					//Alert.show(damList[i]);
//				if(damList[i]==symbol){
//					has=true;
//					break;
//				}
//			}
//			return has;
//			
//		}
//		//获得用户本部门所有下属集
//		public function getAllSubordinates():Array {
//			var results:Array = new Array();
////			var roleList:ArrayCollection = ArrayCollection(roles);
////			if(mainRole!=null)
////				roleList.addItem(mainRole);
////			//Alert.show(roleList.length+"a");
////			for (var i:int = 0; i < roleList.length; i++){
////				var _role:RoleModel=roleList.getItemAt(i) as RoleModel;
////				if(_role.subordinates!=null&&_role.subordinates.length>0){
////					for (var j:int = 0; j < _role.subordinates.length; j++){
////						if(_role.subordinates[j].getAllUsers()!=null&&_role.subordinates[j].getAllUsers().length>0){
////							for (var k:int = 0; k < _role.subordinates[j].getAllUsers().length; k++){
////								results.push(_role.subordinates[j].getAllUsers().getItemAt(k).id);
////							}
////						}
////					}
////				}
////				
////			}
////			//Alert.show(mainRole.supervisorFlag+"");
////
////			if(mainRole!=null&&mainRole.supervisorFlag==true){
////				var _department:DepartmentModel=mainRole.getBelongDepartment();
////				//Alert.show(_department.getUsers().length+"");
////				if(_department!=null&&_department.getUsers().length>0){
////					var departmentUsers:ArrayCollection=_department.getUsers();
////					for (var l:int = 0; l <departmentUsers.length; l++){
////						if(!results.hasOwnProperty(departmentUsers.getItemAt(l).id))
////						results.push(departmentUsers.getItemAt(l).id);
////					}
////
////				}
////				
////			}
//			results.push(this.id);
//			var leaderDepartmentsList:ArrayCollection = ArrayCollection(leaderDepartments);
//			for (var i:int = 0; i < leaderDepartmentsList.length; i++){
//					var department:DepartmentModel=leaderDepartmentsList.getItemAt(i) as DepartmentModel;
//					if(department.getAllUsers()!=null&&department.getAllUsers().length>0){
//						for (var j:int = 0; j <department.getAllUsers().length; j++){
//							var userList:ArrayCollection = ArrayCollection(department.getAllUsers());
//							var user:UserModel=userList.getItemAt(j) as UserModel;
//							if(!results.hasOwnProperty(user.id))
//							results.push(user.id);
//						}
//					}
//			}
//			var masterDepartmentsList:ArrayCollection = ArrayCollection(masterDepartments);
//			for (var i:int = 0; i < masterDepartmentsList.length; i++){
//				var department:DepartmentModel=masterDepartmentsList.getItemAt(i) as DepartmentModel;
//				if(department.getAllUsers()!=null&&department.getAllUsers().length>0){
//					for (var j:int = 0; j <department.getAllUsers().length; j++){
//						var userList:ArrayCollection = ArrayCollection(department.getAllUsers());
//						var user:UserModel=userList.getItemAt(j) as UserModel;
//						if(!results.hasOwnProperty(user.id))
//							results.push(user.id);
//					}
//				}
//			}
//			var leaderRolesList:ArrayCollection = ArrayCollection(leaderRoles);
//			for (var i:int = 0; i < leaderRolesList.length; i++){
//				var role:RoleModel=leaderRolesList.getItemAt(i) as RoleModel;
//				if(role.getAllUsers()!=null&&role.getAllUsers().length>0){
//					for (var j:int = 0; j <role.getAllUsers().length; j++){
//						var userList:ArrayCollection = ArrayCollection(role.getAllUsers());
//						var user:UserModel=userList.getItemAt(j) as UserModel;
//						if(!results.hasOwnProperty(user.id))
//							results.push(user.id);
//					}
//				}
//			}
//			var masterRolesList:ArrayCollection = ArrayCollection(masterRoles);
//			for (var i:int = 0; i < masterRolesList.length; i++){
//				var role:RoleModel=masterRolesList.getItemAt(i) as RoleModel;
//				if(role.getAllUsers()!=null&&role.getAllUsers().length>0){
//					for (var j:int = 0; j <role.getAllUsers().length; j++){
//						var userList:ArrayCollection = ArrayCollection(role.getAllUsers());
//						var user:UserModel=userList.getItemAt(j) as UserModel;
//						if(!results.hasOwnProperty(user.id))
//							results.push(user.id);
//					}
//				}
//			}
//			
//			return results;
//		}
//		public function hasSubordinateUser(userId:String):Boolean
//		{	
//			var has:Boolean=false;
//			var subordinates:Array =getAllSubordinates();
//			for (var i:int = 0; i < subordinates.length; i++){
//				//Alert.show(damList[i]);
//				if(subordinates[i]==userId){
//					has=true;
//					break;
//				}
//			}
//			return has;
//			
//		}
	}
}
