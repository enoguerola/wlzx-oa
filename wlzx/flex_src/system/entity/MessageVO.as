package system.entity
{
	[Bindable]
	[RemoteClass(alias="system.entity.MessageVO")] 
	public class MessageVO
	{
		public var checked:Boolean=false;//辅助
		public var id:String;
		public var fromId:String;//0表示系统消息
		public var toIds:String;
		public var type:int;
		public var content:String;
		public var creationDate:Date;
		public var readFlag:String;
		public var readDate:String;

		public function MessageVO()
		{
			super();
		}
	}
}