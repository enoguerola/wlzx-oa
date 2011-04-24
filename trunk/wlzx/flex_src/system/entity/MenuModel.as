package system.entity
{
	[Bindable]
	[RemoteClass(alias="system.entity.MenuModel")] 
	public class MenuModel extends BaseModel
	{
		
		public var detail:String;
		public var children:Object;//子系统集
		public var parent:Object;//父亲系统集
		public var systems:Object;//系统集
		public var modules:Object;//模块集
		public function MenuModel()
		{
		}
	}
}