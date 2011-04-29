package system.entity
{
	[Bindable]
	[RemoteClass(alias="system.entity.ModuleModel")] 
	public class ModuleModel extends BaseModel
	{
		
		public var detail:String;
		public var url:String;
		public var children:Object;//子模块集
		public var parent:Object;//父模块集
		public var operations:Object;//操作集
		public var menus:Object;//所属菜单集
		
		public function ModuleModel()
		{
		}
	}
}