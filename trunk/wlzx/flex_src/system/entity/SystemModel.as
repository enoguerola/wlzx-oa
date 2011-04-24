package system.entity
{
	[Bindable]
	[RemoteClass(alias="system.entity.SystemModel")] 
	public class SystemModel extends BaseModel
	{
		
		public var detail:String;
		public var indexPath:String;
		public var menus:Object;//系统功能菜单集
		public var children:Object;//子系统集
		public var parent:Object;//父亲系统集
		public function SystemModel()
		{
		}
	}
}