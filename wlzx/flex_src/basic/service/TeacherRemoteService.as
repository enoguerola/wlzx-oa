package basic.service
{
	import mx.rpc.AsyncToken;
	import mx.rpc.AsyncResponder;
	import mx.rpc.remoting.mxml.RemoteObject;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.events.FaultEvent;
	
	public class TeacherRemoteService implements TeacherService
	{
		private var teacherService:RemoteObject;
		
		public function TeacherRemoteService(teacherService:RemoteObject)
		{
			this.teacherService = teacherService;
		}
		
		public function checkNoAvailability(teacherID:String, teacherNo:String):AsyncToken
		{
			var token:AsyncToken = teacherService.checkNo(teacherID, teacherNo);
			token.addResponder(new AsyncResponder(checkNo_resultHandler, checkNo_faultHandler)
			);
			return token;
		}
		
		private function checkNo_resultHandler(event:ResultEvent, token:AsyncToken=null):void
		{ 
			event.token.dispatchEvent(event);
		} 
		
		private function checkNo_faultHandler(event:FaultEvent, token:AsyncToken=null):void
		{
			event.token.dispatchEvent(event);
		}
	}
}