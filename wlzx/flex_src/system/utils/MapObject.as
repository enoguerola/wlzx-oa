package system.utils
{
	public class MapObject
	{
		private var _key:String=null;
		private var _value:Object=null;
		public function MapObject(k:String,v:Object)
		{
			this._key=k;
			this.value=v;
		}
		public function set key(k:String):void
		{
			this._key = k;
		}
		public function get key():String
		{
			return this._key;
		}
		public function set value(v:Object):void
		{
			this._value = v;
		}
		public function get value():Object
		{
			return this._value;
		}
	}
}