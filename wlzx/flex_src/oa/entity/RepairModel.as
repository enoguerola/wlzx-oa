package oa.entity
{
	import oa.entity.BaseModel;
	import system.utils.CommonUtils;
	[Bindable]
	[RemoteClass(alias="system.wlims.oa.entity.logistics.RepairModel")] 
	public class RepairModel extends BaseModel
	{
		public var repairNo:String;
		public var items:String;
		public var description:String;
		public var isElectric:int;//是否电教： 1电教 2非电教
		public var applyId:String;
		public var applyDate:Date;
		public var phone:String;
		public var repairType:int;
		public var cause:int;//故障原因：1人为  2非人为
		public var failureCause:String;
		public var result:int;//维修结果：1完成 2未完成
		public var repairResult:String;
		public var repairer:String;
		public var repairDate:Date;
		public var operatorId:String;
		public var operateDate:Date;
		public var status:int;//状态：0未提交 1已提交未确认 2已确认未处理 3已处理 4已取消		
		public function RepairModel()
		{
			super();
		}
	}
}