package system.entity
{
	[Bindable]
	[RemoteClass(alias="system.entity.ModuleModel")] 
	public class ModuleModel extends BaseModel
	{
		
		public var detail:String;
		public var url:String;
		public var children:Object=new Array();//子模块集
		public var parent:Object=new Array();//父模块集
		public var operations:Object=new Array();//操作集
		public var menus:Object=new Array();//所属菜单集
		public var parms:String;
		public function ModuleModel()
		{
		}
	}
}