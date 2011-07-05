package system.entity
{
	import mx.collections.ArrayCollection;
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
		public function UserModel()
		{
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
				if(damList[i]==symbol){
					has=true;
					break;
				}
			}
			return has;
			
		}
	}
}
