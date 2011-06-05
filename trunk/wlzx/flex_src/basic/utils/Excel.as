package basic.utils
{
	import flash.net.URLRequest;
	import flash.net.URLRequestMethod;
	import flash.net.navigateToURL;
	
	public class Excel
	{
		public function Excel()
		{
		}
		
		/**
		 * 导出excel
		 */ 
		public function load(url:String, keyids:String):void{
			//用get方式发送数据
			var urlStr:String = url + '?keyids=' + keyids;
			var u:URLRequest = new URLRequest(urlStr);
			u.method = URLRequestMethod.GET; 
			
			navigateToURL(u,"_blank");
		}
	}
}