package basic.utils
{
	import mx.events.ValidationResultEvent;
	import mx.validators.Validator;
	import mx.controls.TextInput;
	import mx.controls.listClasses.IListItemRenderer;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.events.FaultEvent;
	import basic.service.TeacherService;
	import mx.validators.ValidationResult;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import flash.events.Event;
	
	public class TeacherIDValidator extends Validator
	{
		public var teacherService:TeacherService; //Service delegate to process the remote validation
		private var _itemEditor:IListItemRenderer;

		public function TeacherIDValidator()
		{
			super();
		}
		
		public function validateNO(teacherID:String, teacherNO:String, itemEditor:TextInput):void
		{
			var list:Array;
			list.push(teacherID);
			list.push(teacherNO);
			trace("id=" + teacherID);
			trace("no=" + teacherNO);
			var validatorResult:ValidationResultEvent = this.validate(list);
			
			if(validatorResult.type == ValidationResultEvent.INVALID){
				if(validatorResult.results[0].errorCode == "validating"){
					// Prevent the user from removing focus,  and leave the cell editor open.  
					// Also, the edit will not continue and store the blank value
					//dgEvent.preventDefault();
					// Write a message to the errorString property. 
					// This message appears when the user mouses over the editor.
					TextInput(itemEditor).errorString = validatorResult.message;
					trace("Please wait, server is validating...");
					return;
				}
				else{
					// A client-side "invalid", handled the same.  This time the message 
					// does not include "Please wait" text
					//dgEvent.preventDefault();
					TextInput(itemEditor).errorString = validatorResult.message;
					return;
				}
			}
			else if(validatorResult.type==ValidationResultEvent.VALID){
				// Everything was successful, update the UI
				TextInput(itemEditor).errorString = "";
				TextInput(itemEditor).text = teacherNO;
				return;
			}
		}
		
		override protected function doValidation(value:Object):Array
		{
			var id:String = Array(value)[0];
			var no:String = Array(value)[1];
			var results:Array = super.doValidation(value); // Call base class doValidation().
			results.push(new ValidationResult(true, null, "validating", "Please wait: \nThe server is validating this corpID."));
			
			var token:AsyncToken = this.teacherService.checkNoAvailability(id, no);			
			token.addResponder(new Responder(teacherNoValidator_resultHandler, teacherNoValidator_faultHandler));
			
			return results; 
		}
		
		private function teacherNoValidator_resultHandler(event:ResultEvent):void
		{
			trace("userNameService_resultHandler(event)");
			//_nameCheckResult = event.result as int;
			this.dispatchEvent(new Event("complete"));
		}
		
		/**
		 * This fault handler is invoked because my Server (via BlazeDS) actually 
		 * returns/throws a custom Exception.  This will dispatch an error to it's consumer
		 * (MyPage.mxml) using the details of that Exception/FaultEvent, used later to populate
		 * the same UI component as Flex's standard "Validator" (client-side) would. 
		 * @see: http://livedocs.adobe.com/flex/3/html/help.html?content=validators_2.html
		 */
		private function teacherNoValidator_faultHandler(event:FaultEvent):void
		{
			trace("UserNameValidator.handleNameCheckError");
			dispatchEvent(new Event("error"));
		}
	}
}