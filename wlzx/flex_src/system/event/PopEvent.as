package system.event
{
	import flash.events.Event;
	
	public class PopEvent extends Event
	{
		public static const POP_EVENT:String = "pop";
		public static const COMPLETED:String = "completed";
		public static const CHOOSED_ROOM:String = "choosed_room";
		public static const CHOOSED_STAFF:String = "choosed_staff";
		public static const CHOOSED_Date_Range:String = "choosed_date_range";

		private var id:String;
		private var arg1:String;
		private var arg2:String;
		private var arg3:String;
		private var arg4:Object;
		public function PopEvent(type:String, id:String, arg1:String, arg2:String, arg3:String, bubbles:Boolean=true, cancelable:Boolean=false, arg4:Object=null)
		{
			super(type, bubbles, cancelable);
			this.id =id;
			this.arg1=arg1;
			this.arg2=arg2;
			this.arg3=arg3;
			this.arg4=arg4;
		}
		
		public function get _id():String {
			return id;
		}
		public function get _arg1():String {
			return arg1;
		}
		public function get _arg2():String {
			return arg2;
		}
		public function get _arg3():String {
			return arg3;
		}
		public function get _arg4():Object {
			return arg4;
		}
	}
}