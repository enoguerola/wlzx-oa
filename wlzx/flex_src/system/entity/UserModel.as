package system.entity
{
	import mx.collections.ArrayCollection;
	import system.utils.CommonUtils;
	import mx.controls.Alert;
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
		public function getAllDams():Array
		{	
			var damList:Array = new Array();
			var roleList:ArrayCollection = ArrayCollection(roles);
			if(mainRole!=null)roleList.addItem(mainRole);
			for (var i:int = 0; i < roleList.length; i++){
				var _role:Object = roleList.getItemAt(i);	
				for (var j:int = 0; j < _role.dataAccessModes.length; j++){
					var _dam:Object = _role.dataAccessModes.getItemAt(j);	
					damList.push(_dam.symbol);
				}
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
		public function getAllSubordinates():ArrayCollection {
			var results:ArrayCollection = new ArrayCollection();
			var roleList:ArrayCollection = ArrayCollection(roles);
			if(mainRole!=null)
				roleList.addItem(mainRole);
			for (var i:int = 0; i < roleList.length; i++){
				
				if(roleList[i].subordinates!=null&&roleList[i].subordinates.length>0){
					//Alert.show(roleList[i].subordinates.length+"");
					for (var j:int = 0; j < roleList[i].subordinates.length; j++){
						if(roleList[i].subordinates[j].getAllUsers()!=null&&roleList[i].subordinates[j].getAllUsers().length>0){
							for (var k:int = 0; k < roleList[i].subordinates[j].getAllUsers().length; k++){
								results.addItem(roleList[i].subordinates[j].getAllUsers()[k].id);
							}
						}
					}
				}
				
			}
			//Alert.show(mainRole.supervisorFlag+"");

			if(mainRole!=null&&mainRole.supervisorFlag==true){
				var department:DepartmentModel=mainRole.getBelongDepartment();
				if(department!=null&&department.getUsers().length>0){
					//Alert.show(department.getUsers().length+"");
					for (var i:int = 0; i < department.getUsers().length; i++){
						results.addItem(department.getUsers()[i].id);
					}
//					for (var i:int = 0; i < department.subordinates.length; i++){
//						if(department.subordinates[i]!=null&&department.subordinates[i].getAllRoles()!=null&&department.subordinates[i].getAllRoles().length>0){
//							for (var j:int = 0; j < department.subordinates[i].getAllRoles().length; j++){
//								if(department.subordinates[i].getAllRoles()[j].getAllUsers()!=null&&department.subordinates[i].getAllRoles()[j].getAllUsers().length>0){
//									for (var k:int = 0; k< department.subordinates[i].getAllRoles()[j].getAllUsers().length; k++){
//										results.add(department.subordinates[i].getAllRoles()[j].getAllUsers()[k]);
//									}
//								}
//							}
//						}
//					}
				}
				
			}
			return results;
		}
	}
}
