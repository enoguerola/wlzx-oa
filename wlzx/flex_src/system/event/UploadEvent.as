package system.event
{
	import flash.events.Event;
	
	public class UploadEvent extends Event
	{
		// Used for the event type.
		public static const UPLOAD_EVENT:String = "uploadevent";
		public static const COMPLETED:String = "uploaded";
		public static const DELETED:String = "deleted";
		
		private var _id:String;
		private var _serverResponse:String = "";
		private var _serverResponseRaw:String = "";
		
		/**
		 * Class constructor sets the default values for 
		 * the bubbles and cancelable parameters. 
		 */
		public function UploadEvent(type:String, _id:String, bubbles:Boolean=true, cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
			this.id = _id;
		}
		
		/**
		 * Getter method for the _serverResponse member 
		 * variable.
		 */ 
		public function get ServerResponse():String {
			return _serverResponse;
		}
		
		/**
		 * @private
		 */
		public function set ServerResponse(value:String):void {
			_serverResponse = value;
		}
		
		/**
		 * Getter method for the _serverResponseRaw member 
		 * variable.
		 */
		public function get ServerResponseRaw():String {
			return _serverResponseRaw;
		}
		
		/**
		 * @private
		 */
		public function set ServerResponseRaw(value:String):void {
			_serverResponseRaw = value;
		}
		
		public function get id():String {
			return _id;
		}
		
		public function set id(value:String):void {
			_id = value;
		}
	}
}