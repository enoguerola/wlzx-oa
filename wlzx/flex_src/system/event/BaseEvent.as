package system.event
{
	import flash.events.Event;
	
	import mx.modules.Module;
	/**
	 *  Custom events
	 */
	public class BaseEvent extends Event
	{
	
		public static const RETURN:String = "returnHomeModule";
		public static const Enter:String = "enterNewModule";
		public static const Reload:String = "reloadModule";
		
		public var moduleContain:Module;
		public var module:String;
		public var item:Object; //item is use to storage parameters.
		
		public function BaseEvent(type:String, targetModule:String=null,  targetModuleContain:Module=null,bubbles:Boolean=false, cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
			this.module = targetModule;
			this.moduleContain = targetModuleContain;
		}

	}
}