package WarmC.Cache
{
	/**
	 * 作者：WarmC 菜虫
	 * Blog：http://flex.joelove.cn/
	 * Email:warm.cai@gmail.com
	 * **/
	import flash.events.NetStatusEvent;
	import flash.net.SharedObject;
	import flash.net.SharedObjectFlushStatus;

	public class MySharedObject
	{
		private var FlushStatus:String="";
		public function MySharedObject(name:String,localPath:String,secure:Boolean,pc:PrivateClass)
		{
			instance=SharedObject.getLocal(name,localPath,secure);
		}
		public function get data():Object{
			return instance.data;
		}
		public function flush(minDiskSpace:int=0):String{
			if(AllowCache){
				FlushStatus=instance.flush(minDiskSpace)
				if(FlushStatus== SharedObjectFlushStatus.PENDING) {
					AllowCache=false;
			        instance.addEventListener(NetStatusEvent.NET_STATUS, onStatusChange);
			    }
			}
			return FlushStatus;
		}
		public function clear():void{
			instance.clear();
			instance.flush();
		}
		private var instance:SharedObject=null;
		public static function getLocal(name:String,localPath:String=null,secure:Boolean=false):MySharedObject{
			return new MySharedObject(name,localPath,secure,new PrivateClass());
		}
		private static var AllowCache:Boolean=true;
		public static var Warm_Human:Boolean=true;
		private function onStatusChange(event:NetStatusEvent):void {
		    if(event.info.code == "SharedObject.Flush.Success"){
		      AllowCache=true;
		      //用户同意了系统的缓存。  
		    }else if(event.info.code == "SharedObject.Flush.Failed"){
		      if(Warm_Human)
		     	 AllowCache=false;
	      	  instance.clear();
		    }
		    instance.removeEventListener(NetStatusEvent.NET_STATUS, onStatusChange);
		}
	}
}
class PrivateClass{}