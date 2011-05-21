package system.entity
{
	[Bindable]
	[RemoteClass(alias="system.entity.SystemModel")] 
	public class SystemModel extends BaseModel
	{
		
		public var detail:String;
		public var indexPath:String;
		public var menus:Object=new Array();//系统功能菜单集
		public var children:Object=new Array();//子系统集
		public var parent:Object=new Array();//父亲系统集
		public function SystemModel()
		{
		}
	}
}