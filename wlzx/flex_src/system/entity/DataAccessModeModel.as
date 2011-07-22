package system.entity
{
	[Bindable]
	[RemoteClass(alias="system.entity.DataAccessModeModel")] 
	public class DataAccessModeModel extends BaseModel
	{

		public var detail:String;
		public var value:String;
		public var emptyFlag:Boolean;//额外数据访问方式【非默认数据访问方式】
		public var operations:Object=new Array();//所属操作集

		public function DataAccessModeModel()
		{
			super();
		}
	}
}