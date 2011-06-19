package system.component.validator
{
	import mx.validators.Validator;
	import mx.validators.ValidationResult;
	import mx.controls.Alert;
	
	public class ComboxValidator extends Validator
	{
		public function ComboxValidator()
		{
			super();
		}
		
		protected override function doValidation(value:Object):Array{
			var results:Array = new Array(); 
			results=super.doValidation(value);
			results.push(new ValidationResult(true,null,"请选择","你必须选择一个类型"));
			if(value.data == null)
			{
				results.push(new ValidationResult(true,null,"请选择","你必须选择一个类型"));
			}
			return results;
		}

	}
}