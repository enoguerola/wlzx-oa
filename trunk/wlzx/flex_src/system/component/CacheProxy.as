package system.component
{
	/**
	 * 作者：WarmC 菜虫
	 * Blog：http://flex.joelove.cn/
	 * Email:warm.cai@gmail.com
	 * **/
	import WarmC.Cache.MySharedObject;
	
	public class CacheProxy
	{
		private var so:MySharedObject;
		public function CacheProxy(soName:String)
		{
			trace(">>>启用客户端本地缓存……");
			so=MySharedObject.getLocal(soName);
		}
		/**-----------Getter and Setter-----------**/
		private var _useVersioning:Boolean=false;
		public function set useVersioning(bool:Boolean):void{
			if(bool){
				trace(">>>启用客户端本地缓存 版本控制……");
				_useVersioning=bool;
				contrastVersion();
			}
		}
		public function get useVersioning():Boolean{
			return _useVersioning;
		}
		private var _version:String=null;
		public function setVersion(value:String):void{
			if(_version!=value){
				_version=value;
			}
		}
		public function getCache(index:int):Object{
			return so.data[index];
		}
		public function setCache(index:int,data:Object):void{
			so.data[index]=data;
			if(_useVersioning)
				so.data.version=_version;
			so.flush();
		}
		/**-----------private function------------**/
		private function contrastVersion():void{
			if(so.data){
				if(so.data.version!=_version){
					trace("版本不一致，或者不存在缓存。重置……");
					so.clear();
					so.flush();
				}
			}
		}
	}
}