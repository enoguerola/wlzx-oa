package system.entity
{
	[Bindable]
	[RemoteClass(alias="system.entity.ModuleModel")] 
	public class ModuleModel extends BaseModel
	{
		
		public var detail:String;
		public var url:String;
		public var children:Object;//子系统集
		public var parent:Object;//父亲系统集

		public function ModuleModel()
		{
		}
	}
}