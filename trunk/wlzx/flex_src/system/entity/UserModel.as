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
		public var subordinates:Object=new Array();//直属下级角色
		public var leaders:Object=new Array();//直属上级角色
		public var roles:Object=new Array();//角色集
		public var departments:Object=new Array();//所属部门集
		public var mainRole:RoleModel;//角色集
		public var mainDepartment:DepartmentModel;//角色集
		public var authorizations:Object=new Array();////辅助
		public function UserModel()
		{
			super();
		}
		public function getAllRoles():String
		{	var result:String="";
			if(mainRole!=null)
			result=result.concat(mainRole.name).concat("  |  ");
			var roleList:ArrayCollection = ArrayCollection(roles);
			CommonUtils.sortByCondition(roleList,'level');
			for (var i:int = 0; i < roleList.length; i++){
				var _role:Object = roleList.getItemAt(i);	
				result=result.concat(_role.name).concat("  |  ");
			}
			return result;
		}
		public function getAllRolesList():ArrayCollection
		{	var results:ArrayCollection = new ArrayCollection();
			if(mainRole!=null)
			results.addItem(mainRole);
			var roleList:ArrayCollection = ArrayCollection(roles);
			CommonUtils.sortByCondition(roleList,'level');
			for (var i:int = 0; i < roleList.length; i++){
				var _role:Object = roleList.getItemAt(i);	
				results.addItem(_role);
			}
			return results;
		}
		public function getDepartments():ArrayCollection
		{	var results:ArrayCollection = new ArrayCollection();
			var list:ArrayCollection=getAllRolesList();
			for (var i:int = 0; i < list.length; i++){
				var _role:Object = list.getItemAt(i);	
				if(_role.getBelongDepartment()!=null){
					if(results.contains(_role.getBelongDepartment())==false)
					results.addItem(_role.getBelongDepartment());
				}
			}
			return results;
		}
		public function getAllDams():Array
		{	
//			var damList:Array = new Array();
//			var roleList:ArrayCollection = ArrayCollection(roles);
//			if(mainRole!=null)roleList.addItem(mainRole);
//			for (var i:int = 0; i < roleList.length; i++){
//				var _role:Object = roleList.getItemAt(i);	
//				for (var j:int = 0; j < _role.dataAccessModes.length; j++){
//					var _dam:Object = _role.dataAccessModes.getItemAt(j);	
//					damList.push(_dam.symbol);
//				}
//			}
//			return damList;
			var damList:Array = new Array();
			var auths:ArrayCollection = ArrayCollection(authorizations);
			for (var j:int = 0; j < auths.length; j++){
				var _dam:Object = auths.getItemAt(j);	
				damList.push(_dam.symbol);
			}
			return damList;
		}
		public function hasDam(symbol:String):Boolean
		{	
			var has:Boolean=false;
			var damList:Array =getAllDams();
			for (var i:int = 0; i < damList.length; i++){
					//Alert.show(damList[i]);
				if(damList[i]==symbol){
					has=true;
					break;
				}
			}
			return has;
			
		}
		//获得用户本部门所有下属集
		public function getAllSubordinates():Array {
			var results:Array = new Array();
			var roleList:ArrayCollection = ArrayCollection(roles);
			if(mainRole!=null)
				roleList.addItem(mainRole);
			//Alert.show(roleList.length+"a");
			for (var i:int = 0; i < roleList.length; i++){
				var _role:RoleModel=roleList.getItemAt(i) as RoleModel;
				if(_role.subordinates!=null&&_role.subordinates.length>0){
					for (var j:int = 0; j < _role.subordinates.length; j++){
						if(_role.subordinates[j].getAllUsers()!=null&&_role.subordinates[j].getAllUsers().length>0){
							for (var k:int = 0; k < _role.subordinates[j].getAllUsers().length; k++){
								results.push(_role.subordinates[j].getAllUsers().getItemAt(k).id);
							}
						}
					}
				}
				
			}
			//Alert.show(mainRole.supervisorFlag+"");

			if(mainRole!=null&&mainRole.supervisorFlag==true){
				var _department:DepartmentModel=mainRole.getBelongDepartment();
				//Alert.show(_department.getUsers().length+"");
				if(_department!=null&&_department.getUsers().length>0){
					var departmentUsers:ArrayCollection=_department.getUsers();
					for (var l:int = 0; l <departmentUsers.length; l++){
						if(!results.hasOwnProperty(departmentUsers.getItemAt(l).id))
						results.push(departmentUsers.getItemAt(l).id);
					}

				}
				
			}
			return results;
		}
		public function hasSubordinateUser(userId:String):Boolean
		{	
			var has:Boolean=false;
			var subordinates:Array =getAllSubordinates();
			for (var i:int = 0; i < subordinates.length; i++){
				//Alert.show(damList[i]);
				if(subordinates[i]==userId){
					has=true;
					break;
				}
			}
			return has;
			
		}
	}
}
