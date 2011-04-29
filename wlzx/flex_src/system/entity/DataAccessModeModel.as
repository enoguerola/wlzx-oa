package system.entity
{
	[Bindable]
	[RemoteClass(alias="system.entity.DataAccessModeModel")] 
	public class DataAccessModeModel extends BaseModel
	{

		public var detail:String;
		public var value:String;
		public var operations:Object;//所属操作集

		public function DataAccessModeModel()
		{
		}
	}
}