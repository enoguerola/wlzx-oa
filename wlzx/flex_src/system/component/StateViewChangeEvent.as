package system.component
{//自定义事件  
	import mx.events.FlexEvent;  
	public class StateViewChangeEvent extends FlexEvent  
	{  
		//public static const ONCHANGE:String ="onChange";  
		public var eventInfo:String;  
		public function StateViewChangeEvent(s:String)  
		{  
			super(s);//如果在构造时不设bubbles，默认是false，也就是不能传递的  
			eventInfo="这个事件是："+s;  
		}  
		
	}  
} 