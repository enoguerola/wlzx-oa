package system.component
{
	import flash.text.TextField;
	
	import mx.containers.HBox;
	import mx.controls.Alert;
	import mx.controls.DateChooser;
	import mx.controls.TextInput;
	import mx.core.IUITextField;
	import mx.core.UITextField;
	import mx.core.mx_internal;
	
	import spark.components.HGroup;
	
	use namespace mx_internal;
	
	public class WlzxMonthSchedule extends DateChooser
	{
		
		public function WlzxMonthSchedule()
		{
			super();
		}
		
		override protected function createChildren():void
		{
			super.createChildren();
			
			var rows:Array=dateGrid.dayBlocksArray;
			for (var rowIndex:int=1; rowIndex < 7; rowIndex++)
			{
				var row:Array=rows[rowIndex];
				var label:UITextField=UITextField(row[row.length - 1]);
				var childIndex:int=dateGrid.getChildIndex(label);
				
				for (var colIndex:int=0; colIndex < 7; colIndex++)
				{
					label=UITextField(row[colIndex]);
					label.height=200;
					var textField:HBox=new HBox();
					textField.setStyle("backgroundColor","blue");
					dateGrid.addChildAt(textField, childIndex++);
				}
			}
		}
		
		override protected function updateDisplayList(unscaledWidth:Number, unscaledHeight:Number):void
		{
			super.updateDisplayList(unscaledWidth, unscaledHeight);
			
//			var paddingLeft:Number=dateGrid.getStyle("paddingLeft");
//			var paddingRight:Number=dateGrid.getStyle("paddingRight");
//			var paddingBottom:Number=dateGrid.getStyle("paddingBottom");
//			var paddingTop:Number=dateGrid.getStyle("paddingTop");
//			
//			var blockX:Number=paddingLeft;
//			var cellWidth:Number=Math.max((unscaledWidth - (paddingLeft + paddingRight)) / 7, 4);
//			var cellHeight:Number=Math.max((unscaledHeight - paddingBottom) / 7, 4);
//			
//			var labelPosition:Number=paddingTop;
//			
//			for (var columnIndex:int=0; columnIndex < 7; columnIndex++)
//			{
//				
//				for (var rowIndex:int=0; rowIndex < 7; rowIndex++)
//				{
//					var label:IUITextField=dateGrid.dayBlocksArray[columnIndex][rowIndex];
//					if (rowIndex == 0)
//						labelPosition=paddingTop;
//					else
//						labelPosition+=cellHeight;
//					
//					
//					if (rowIndex > 0)
//					{
//						var textInput:HBox=HBox(textFieldArray[rowIndex - 1][columnIndex]);
//						label.setActualSize(cellWidth, Math.max(cellHeight * 2 / 3));
//						label.move(blockX, labelPosition);
//						textInput.setActualSize(cellWidth, Math.max(cellHeight * 1 / 3));
//						textInput.move(blockX, labelPosition + textInput.height);
////						textInput.percentWidth=200;
////						textInput.height=200;
////						textInput.setStyle("backgroundColor","blue");
//						textInput.setStyle("borderVisible",true);
////						if (label.text) {
////							textInput.visible = true;
////							textInput.includeInLayout = true;
////						} else {
////							textInput.visible = false;
////							textInput.includeInLayout = false;
////						}
//					}
//				}
//				
//				blockX+=cellWidth;
//			}
			
		}
		
	}
}