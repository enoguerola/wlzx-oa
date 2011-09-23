package system.entity
{
	import mx.collections.ArrayCollection;
	
	import oa.receipt.component.item.Department;

	[Bindable]
	[RemoteClass(alias="system.entity.DRModel")] 
	public class DRModel 
	{
		public var id:String;
		public var departmentId:String;
		public var roleId:String;
		public var basicFlag:Boolean;
		public var users:Object=new Array();
		public var mainUsers:Object=new Array();
		public var dataAccessModes:Object=new Array();
	
		public function DRModel()
		{
			super();
		}
		
		public  function getAllUsers():ArrayCollection{
			var results:ArrayCollection= ArrayCollection(mainUsers);
			var list:ArrayCollection=ArrayCollection(users);
			for (var i:int = 0; i < list.length; i++){
				var user:UserModel=list.getItemAt(i) as UserModel;
					if(user!=null&&results.contains(user))
					results.addItem(user);
			}
			return results;
		}
		
	
	}
}
