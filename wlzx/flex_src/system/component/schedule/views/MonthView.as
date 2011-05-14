package system.component.schedule.views
{
	import flash.events.Event;
	import flash.events.MouseEvent;
	import mx.events.FlexEvent;
	import mx.containers.ApplicationControlBar;
	import mx.containers.Canvas;
	import mx.containers.Grid;
	import mx.containers.GridItem;
	import mx.containers.GridRow;
	import mx.controls.Alert;
	import mx.controls.Button;
	import mx.controls.Label;
	import mx.utils.ObjectUtil;
	
	import spark.components.VGroup;
	
	import system.component.schedule.views.cellViews.*;
	import system.component.schedule.views.events.*;
	import system.component.schedule.views.model.*;
	import system.component.schedule.views.utils.*;

	/**
	 * THIS CLASS WILL ALLOW TO GENERATE A GRID OF CURRENT MONTH
	 * 
	 * THIS CLASS USES monthCell TO REPRESENT A SINGLE DAY.
	 * 
	 * ADDITIONALLY IT CONNECTS WITH DATA HOLDER AND CHECK FOR EVENT EXISTENSE FOR A PARTICULAR
	 * DATE AND GENERATE THE VIEW ACCORDINGLY.  
	 * 
	 * THIS CLASS IS EXTENDED TO CANVAS SO IT COULD BE USED A DISPLAY OBJECT IN MXML FILES AS WELL.
	*/
	
	public class MonthView extends Canvas
	{
		private var m_monthViewGrid:Grid ;
		private var m_dayGrid:Grid;
		private var m_appBar:ApplicationControlBar;
		private var date:Label;
		private var m_intCurrentMonth:int;
		private var m_intCurrentYear:int;
		private var Day_Text:Array=new Array("周日"," 周一","周二","周三","周四","周五","周六");

		private var fwdMonthButton:Button;

		private var backMonthButton:Button;
		
		public function MonthView()
		{
			super();			
			createIntialChildren();
		}
		
		// function responsible for generating the view
		private function createIntialChildren():void
		{

			// add application bar which will show days name on the top of the view
			m_appBar = new ApplicationControlBar();
			m_appBar.percentWidth = 100;
			m_appBar.height = 30;
			date = new Label();
			date.setStyle("textAlign","center");
			date.percentWidth=100;
			
			
			// Create the previous-month button.
			if (!backMonthButton)
			{
				backMonthButton = new Button();
				backMonthButton.label="<-";
				backMonthButton.width=30;
				backMonthButton.styleName="customButton";
//				backMonthButton.styleName = new StyleProxy(this, prevMonthStyleFilters);
//				backMonthButton.focusEnabled = false;
//				backMonthButton.autoRepeat = true;
//				backMonthButton.upSkinName = "prevMonthUpSkin";
//				backMonthButton.overSkinName = "prevMonthOverSkin";
//				backMonthButton.downSkinName = "prevMonthDownSkin";
//				backMonthButton.disabledSkinName = "prevMonthDisabledSkin";
//				backMonthButton.skinName = "prevMonthSkin";
//				backMonthButton.upIconName = "";
//				backMonthButton.overIconName = "";
//				backMonthButton.downIconName = "";
//				backMonthButton.disabledIconName = "";
				backMonthButton.addEventListener(FlexEvent.BUTTON_DOWN,backMonthButton_buttonDownHandler);
				m_appBar.addChild(backMonthButton);
			}
			m_appBar.addChild(date);

			// Create the next-month button.
			if (!fwdMonthButton)
			{
				fwdMonthButton = new Button();
				fwdMonthButton.label="->";
				fwdMonthButton.width=30;
				fwdMonthButton.styleName="customButton";
				//				fwdMonthButton.styleName = new StyleProxy(this,nextMonthStyleFilters);
				//				fwdMonthButton.autoRepeat = true;
				//				fwdMonthButton.focusEnabled = false;
				//				fwdMonthButton.upSkinName = "nextMonthUpSkin";
				//				fwdMonthButton.overSkinName = "nextMonthOverSkin";
				//				fwdMonthButton.downSkinName = "nextMonthDownSkin";
				//				fwdMonthButton.disabledSkinName = "nextMonthDisabledSkin";
				//				fwdMonthButton.skinName = "nextMonthSkin";
				//				fwdMonthButton.upIconName = "";
				//				fwdMonthButton.overIconName = "";
				//				fwdMonthButton.downIconName = "";
				//				fwdMonthButton.disabledIconName = "";
				fwdMonthButton.addEventListener(FlexEvent.BUTTON_DOWN,fwdMonthButton_buttonDownHandler);
				m_appBar.addChild(fwdMonthButton);
			}
			this.addChild(m_appBar);
			
			m_dayGrid = new Grid();
			m_dayGrid.percentWidth=100;
			m_dayGrid.height=20;
			m_dayGrid.setStyle("backgroundColor","#D0E8AA");
			m_dayGrid.setStyle("border","1px");
			m_dayGrid.alpha=0.5;
			var m_dayGridRow:GridRow= new GridRow();
			m_dayGridRow.percentWidth=100;
			m_dayGridRow.percentHeight=100;
			m_dayGrid.addChild(m_dayGridRow);
			m_dayGrid.top=30;	
			for(var i:int=0;i<7;i++){
				var m_dayGridItem:GridItem = new GridItem();	
				m_dayGridItem.percentWidth=100;
				m_dayGridItem.percentHeight=100;
				
				var m_lblDaysName:Label = new Label();
				m_lblDaysName.percentWidth=100;
				m_lblDaysName.percentHeight=100;
				m_lblDaysName.text=Day_Text[i];
				m_lblDaysName.setStyle("textAlign","center");
				m_lblDaysName.setStyle("verticalAlign","middle");
				m_dayGridItem.addChild(m_lblDaysName);	
				m_dayGridRow.addChild(m_dayGridItem);			
			}		
			
			this.addChild(m_dayGrid);	
			// add a new grid
			m_monthViewGrid = new Grid();
			m_monthViewGrid.percentWidth=100;
			m_monthViewGrid.percentHeight=100;
			m_monthViewGrid.top=50;	
			m_monthViewGrid.setStyle("verticalGap","1");
			m_monthViewGrid.setStyle("horizontalGap","1");
			this.addChild(m_monthViewGrid);
			
		}
				
		override protected function updateDisplayList(unscaledWidth:Number,
												  unscaledHeight:Number):void
		{
			super.updateDisplayList(unscaledWidth, unscaledHeight);
		}
		
		// create grid of days in current month as per current date provided
		private function createDaysGrid():void
		{
			// always assume that first day of a month will have date as 1
			// currentMonth and currentYear are supplied by main.mxml file		
			var objDate:Date = new Date(currentYear, currentMonth, 1);
			
			// get total days count for currentMonth in currentYear
			var intTotalDaysInMonth:int = CommonUtils.getDaysCount(currentMonth, currentYear);
			var i:int;
			/**
			 * Add Total number of Grid items in a Array 
			 * 
			**/
			
			// add empty items in case first day is not Sunday
			// i.e. MonthView always shows 7 coloumns starting from Sunday and ending to Saturday
			// so if it suppose Wednesday is the date 1 of this month that means we need to
			// add 3 empty cells at start
			var arrDays:Array = new Array();
			for(i=0; i<objDate.getDay(); i++)
			{
				arrDays.push(-1);
			}
			
			// now loop through total number of days in this month and save values in array
			for(i=0; i<intTotalDaysInMonth; i++)
			{
				var objDate1:Date = new Date(currentYear, currentMonth, (i+1));
				var strStartDayName:String = CommonUtils.getDayName(objDate1.getDay());
				arrDays.push({data:i+1, label:strStartDayName});
			}
			
			// if first day of the month is Friday and it is not a leap year then we need to show 7 rows
			// there could be max 42 items in a calendar grid for a month with 6 rows
			// so add blank values in case still some cells are pending as per count of 7 cols x 6 rows = 42
			if(objDate.getDay() >= 5 && arrDays.length <= 32)
			{
				for(i=arrDays.length; i<42; i++)
				{
					arrDays.push(-1);
				}
			}
			else
			{
				for(i=arrDays.length; i<35; i++)
				{
					arrDays.push(-1);
				}
			}
		

			m_monthViewGrid.removeAllChildren();
				
			var objGridRow:GridRow;
			
			// once array is created now loop through the array and generate the Grid
			for(i=0; i<arrDays.length; i++)
			{
				
				if(i % 7 == 0)
				{
					objGridRow = new GridRow();
					objGridRow.percentWidth=100;
					objGridRow.percentHeight=100;
					m_monthViewGrid.addChild(objGridRow);
				}
				
				var objGridItem:GridItem = new GridItem();
				
				var objDayCell:monthCell = new monthCell();
								
				objGridItem.addChild(objDayCell);
				objGridRow.addChild(objGridItem);
				objGridItem.percentWidth=100;
				objGridItem.percentHeight=100;
				
				objDayCell.txtDesc.visible = false;
						
				if(arrDays[i] == -1)
				{
					objDayCell.canHeader.visible = false;
				}
				else
				{
//					mx.controls.Alert.show(arrDays[i].data+"");
					objDayCell.lblDate.text = arrDays[i].data;
					objDayCell.addEventListener(MouseEvent.CLICK, onDayCellClick);
					objDayCell.data = {date: new Date(currentYear, currentMonth, arrDays[i].data) };
					
					// check if current date has some event stored in DataHolder
					// if YES then display event description
					for(var j:int=0; j<DataHolder.getInstance().dataProvider.length; j++)
					{
						var obj:Object = DataHolder.getInstance().dataProvider[j];
						if(ObjectUtil.dateCompare(obj.date, objDayCell.data.date) == 0)
						{
							objDayCell.txtDesc.text = obj.desc;
							objDayCell.txtDesc.visible = true;
							break;
						}
					}
				} 
			}
			
			
			
		}
		
		public function redraw():void
		{
			createDaysGrid();
		}
		
		// click event for a day cell
		// will change the view to Day View and set current date as per cell clicked in the Grid
		private function onDayCellClick(_event:MouseEvent):void
		{
//			var objDayCell:monthCell
//			if(_event.target.toString().indexOf("txtDesc") == -1)
//			{
//				objDayCell = monthCell(_event.target);
//			}
//			else
//			{
//				objDayCell = monthCell(_event.target.parent.parent);
//			}
//			dispatchEvent(new CustomEvents(CustomEvents.MONTH_VIEW_CLICK, objDayCell.data));
		}
		/**
		 *  @private
		 *  event is either a KeyboardEvent or a FlexEvent
		 */
		private function fwdMonthButton_buttonDownHandler(event:Event):void
		{
			if (m_intCurrentMonth < 11)
			{
				m_intCurrentMonth++;
			}
			else if(m_intCurrentMonth==11){
				m_intCurrentMonth=0;
				m_intCurrentYear++;
			}
			createDaysGrid();
			date.text=m_intCurrentYear+"年"+(m_intCurrentMonth+1)+"月";
		}
		
		/**
		 *  @private
		 *  event is either a KeyboardEvent or a FlexEvent
		 */
		private function backMonthButton_buttonDownHandler(event:Event):void
		{
			if (m_intCurrentMonth >0)
			{
				m_intCurrentMonth--;
			}
			else if(m_intCurrentMonth==0){
				m_intCurrentMonth=11;
				m_intCurrentYear--;
			}
			createDaysGrid();
			date.text=m_intCurrentYear+"年"+(m_intCurrentMonth+1)+"月";
		}
	
		
		/**
		 * Custom Properties
		 * 
		**/
		public function set currentMonth(_intCurrentMonth:int):void
		{
			m_intCurrentMonth = _intCurrentMonth;
		}
		
		public function get currentMonth():int
		{
			return m_intCurrentMonth;
		}
		
		public function set currentYear(_intCurrentYear:int):void
		{
			m_intCurrentYear = _intCurrentYear;
			createDaysGrid();
			date.text=m_intCurrentYear+"年"+(m_intCurrentMonth+1)+"月";

		}
		
		public function get currentYear():int
		{
			return m_intCurrentYear;
		}
	}
}