package basic.entity
{
	import flashx.textLayout.formats.Float;
	
	import mx.collections.ArrayCollection;

	[Bindable]
	[RemoteClass(alias="system.wlims.basic.entity.PlaceModel")] 
	public class PlaceModel extends BaseModel
	{

		
		public var  symbol:String;
		public var  name:String;
		public var  type:String;
		public var  position:String;
		public var  functions:String;
		public var  areaBegin:Number;
		public var  areaEnd:Number;
		public var  containBegin:int;
		public var  containEnd:int;
		public var  remarks:String;
		public var  creationDate:Date;
		public var  modifiedDate:Date;
		
		public function PlaceModel()
		{
			super();
		}
		

	}
}
