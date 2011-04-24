package system.event
{
	import flash.events.Event;
	
	/**
	 *  Custom events
	 */
	public class BaseEvent extends Event
	{
	
		public static const RETURN:String = "returnHomeModule";
		public static const Enter:String = "enterNewModule";
		
		public var module:String;
		
		public var item:Object; //item is use to storage parameters.
		
		public function BaseEvent(type:String, targetModule:String=null, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
			this.module = targetModule;
		}

	}
}