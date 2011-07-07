package system.entity
{
	[Bindable]
	[RemoteClass(alias="system.entity.OperationModel")] 
	public class OperationModel extends BaseModel
	{

		public var detail:String;
		public var rsType:String;
		public var rsValue:String;
		public var modules:Object=new Array();//操作所属模块集
		public var dataAccessModes:Object=new Array();//操作数据访问方式集

		public function OperationModel()
		{
			super();
		}
	}
}