package system.component.schedule.views
{
	import flash.events.Event;
	import flash.events.MouseEvent;
	
	import mx.containers.ApplicationControlBar;
	import mx.containers.Canvas;
	import mx.containers.Grid;
	import mx.containers.GridItem;
	import mx.containers.GridRow;
	import mx.controls.Alert;
	import mx.controls.Button;
	import mx.controls.Label;
	import mx.events.FlexEvent;
	import mx.utils.ObjectUtil;
	
	import spark.components.VGroup;
	
	import system.component.schedule.views.cellViews.*;
	import system.component.schedule.views.events.*;
	import system.component.schedule.views.model.*;
	import system.component.schedule.views.utils.*;
	/**
	 * THIS CLASS WILL ALLOW TO GENERATE A LIST OF HOUR CELLS
	 * WHICH WILL BE FROM 00hr. TO 24hr. AND THIS LIST WILL BE GENERATED FOR 7 DAYS IN CURRENT WEEK
	 * 
	 * THIS CLASS USES hourCell TO GENERATE THE LIST. IT READ CURRENT DATE TO GENERATE
	 * THE VIEW FOR THAT PARTICULAR WEEK.
	 * 
	 * ADDITIONALLY IT CONNECTS WITH DATA HOLDER AND CHECK FOR EVENT EXISTENSE FOR A PARTICULAR
	 * DATE AND GENERATE THE VIEW ACCORDINGLY.  
	 * 
	 * THIS CLASS IS EXTENDED TO CANVAS SO IT COULD BE USED A DISPLAY OBJECT IN MXML FILES AS WELL.
	*/

	public class WeekView extends Canvas
	{

		private var Day_Text:Array=new Array("周日","周一","周二","周三","周四","周五","周六");
		private var m_intCurrentMonth:int=0;
		private var m_intCurrentYear:int=0;
		private var m_intCurrentDay:int=0;
		
		private var m_appBar:ApplicationControlBar;

		private var fwdMonthButton:Button;
		private var weeks:Label;
		private var backMonthButton:Button;
		
		private var m_WeekViewGrid:Grid ;

		public function WeekView()
		{
			super();			
			createIntialChildren();
		}
		
		// function responsible for generating the view
		private function createIntialChildren():void
		{
			if(m_intCurrentMonth==0||m_intCurrentYear==0||m_intCurrentDay==0){
				var tmpDate:Date=new Date();
				m_intCurrentMonth=tmpDate.getMonth();
				m_intCurrentYear=tmpDate.getFullYear();
				m_intCurrentDay=tmpDate.getDate();
			}
			// add application bar which will show sth on the top of the view
			m_appBar = new ApplicationControlBar();
			m_appBar.percentWidth = 100;
			m_appBar.height = 30;
			weeks = new Label();
			weeks.setStyle("textAlign","center");
			weeks.percentWidth=100;
			
			
			// Create the previous-week button.
			if (!backMonthButton)
			{
				backMonthButton = new Button();
				backMonthButton.label="<-";
				backMonthButton.addEventListener(FlexEvent.BUTTON_DOWN,backMonthButton_buttonDownHandler);
				m_appBar.addChild(backMonthButton);
			}
			m_appBar.addChild(weeks);
			
			// Create the next-week button.
			if (!fwdMonthButton)
			{
				fwdMonthButton = new Button();
				fwdMonthButton.label="->";
				fwdMonthButton.addEventListener(FlexEvent.BUTTON_DOWN,fwdMonthButton_buttonDownHandler);
				m_appBar.addChild(fwdMonthButton);
			}
			this.addChild(m_appBar);
			
		
			// add a new grid
			m_WeekViewGrid = new Grid();
			m_WeekViewGrid.percentWidth=100;
			m_WeekViewGrid.percentHeight=100;
			m_WeekViewGrid.top=30;	
			m_WeekViewGrid.setStyle("verticalGap","1");
			m_WeekViewGrid.setStyle("horizontalGap","1");
			this.addChild(m_WeekViewGrid);
		}
				
				
		override protected function updateDisplayList(unscaledWidth:Number,
												  unscaledHeight:Number):void
		{
			super.updateDisplayList(unscaledWidth, unscaledHeight);
		}
		
		public function redraw():void
		{
			createDaysGrid();
		}
		private function createDaysGrid():void
		{
			updateTitle();
			m_WeekViewGrid.removeAllChildren();
			var array:Array=getWeekDates();
			for(var i:int=0;i<7;i++){
//				mx.controls.Alert.show(array[i]+"");
				var objGridRow:GridRow = new GridRow();
				objGridRow.percentWidth=100;
					var objGridItem:GridItem = new GridItem();
					objGridItem.percentWidth=100;
						var objWeekCell:weekCell=new weekCell();
						objWeekCell.percentWidth=100;
						objWeekCell.addEventListener(MouseEvent.CLICK, onDayCellClick);
					objGridItem.addChild(objWeekCell);
				objGridRow.addChild(objGridItem);
				m_WeekViewGrid.addChild(objGridRow);
				objWeekCell.lblDate.text = ""+array[i]+"";
				objWeekCell.lblDate.setStyle("verticalAlign","middle");
//				mx.controls.Alert.show(array[i]+"");
			}
			
			
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
			var currentDate:Date=new Date(m_intCurrentYear,m_intCurrentMonth,m_intCurrentDay);
			var nextWeekDate:Date=new Date(currentDate.getFullYear(), currentDate.getMonth(), currentDate.getDate()+7);
			m_intCurrentMonth=nextWeekDate.getMonth();
			m_intCurrentYear=nextWeekDate.getFullYear();
			m_intCurrentDay=nextWeekDate.getDate();
			createDaysGrid();
		}
		
		/**
		 *  @private
		 *  event is either a KeyboardEvent or a FlexEvent
		 */
		private function backMonthButton_buttonDownHandler(event:Event):void
		{
			var currentDate:Date=new Date(m_intCurrentYear,m_intCurrentMonth,m_intCurrentDay);
			var preWeekDate:Date=new Date(currentDate.getFullYear(), currentDate.getMonth(), currentDate.getDate()-7);
			m_intCurrentMonth=preWeekDate.getMonth();
			m_intCurrentYear=preWeekDate.getFullYear();
			m_intCurrentDay=preWeekDate.getDate();
			createDaysGrid();
		}
		private function updateTitle():void
		{
			var currentDate:Date=new Date(m_intCurrentYear,m_intCurrentMonth,m_intCurrentDay);
			var beginDate:Date=new Date(currentDate.getFullYear(), currentDate.getMonth(), currentDate.getDate()- currentDate.getDay() + 1);
			var endDate:Date=new Date(currentDate.getFullYear(), currentDate.getMonth(), currentDate.getDate()- currentDate.getDay() + 7);
			weeks.text=beginDate.getFullYear()+"年"+(beginDate.getMonth()+1)+"月"+beginDate.getDate()+"日"
						+"--"
						+endDate.getFullYear()+"年"+(endDate.getMonth()+1)+"月"+endDate.getDate()+"日";
		
		}
		private function getWeekDates():Array
		{
			var list:Array = new Array();
			var now:Date=new Date(m_intCurrentYear,m_intCurrentMonth,m_intCurrentDay);

			var day:int= now.getDay();
			if (day == 0)day = 7;
			for (var i:int = 1; i <= 7; i++) {
				
				var tmpDate:Date= new Date(now.getFullYear(), now.getMonth(), now.getDate()- day + i );
				var month:String = "";
				var date:String= "";
				if (tmpDate.getMonth() + 1 < 10)
					month = "0" + (tmpDate.getMonth() + 1);
				else
					month = "" + (tmpDate.getMonth() + 1);
				if (tmpDate.getDate() < 10)
					date = "0" + (tmpDate.getDate());
				else
					date = "" + (tmpDate.getDate());
				
				list.push(tmpDate.getFullYear() + "年" + month + "月" + date+"日"+Day_Text[tmpDate.getDay()]);
//				mx.controls.Alert.show(list[i-1]);
			}
			return list;
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
			
			
		}
		
		public function get currentYear():int
		{
			return m_intCurrentYear;
		}
		public function set currentDay(_intCurrentDay:int):void
		{
			m_intCurrentDay = _intCurrentDay;
			createDaysGrid();	
		}
		
		public function get currentDay():int
		{
			return m_intCurrentDay;
		}
	}
}