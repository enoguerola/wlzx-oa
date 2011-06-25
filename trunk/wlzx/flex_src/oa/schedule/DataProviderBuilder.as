package oa.schedule
{
import com.flexcalendar.components.calendar.core.dataModel.CalendarDataProvider;
import com.flexcalendar.components.calendar.core.dataModel.CalendarItem;
import com.flexcalendar.components.calendar.core.dataModel.CalendarItemSet;
import com.flexcalendar.components.calendar.core.dataModel.ItemType;
import com.flexcalendar.components.calendar.core.dataModel.formatICalendar.Recur;
import com.flexcalendar.components.calendar.displayClasses.decoration.IRendererColors;
import com.flexcalendar.components.calendar.displayClasses.decoration.RendererColors;
import com.flexcalendar.components.calendar.displayClasses.decoration.RendererColorsFactory;
import com.flexcalendar.components.calendar.utils.DateUtils;

import mx.collections.ArrayCollection;
import mx.controls.Alert;
import mx.formatters.DateFormatter;

import oa.entity.ScheduleModel;
import oa.schedule.flexCalendar.*;
import system.utils.*;
public class DataProviderBuilder
{

	public function DataProviderBuilder()
	{
	}
	
	public function buildDataProvider(allList:ArrayCollection):CalendarDataProvider
	{
		var itemSet:CalendarItemSet = new CalendarItemSet();
		itemSet.addItemAsSpace(buildItemWithDay(0, 0, 24, null, false), ItemType.AVAILABLE_SPACE);
		itemSet.addItemAsSpace(buildItemWithDay(1, 0, 24, null, false), ItemType.AVAILABLE_SPACE);
		itemSet.addItemAsSpace(buildItemWithDay(2, 0, 24, null, false), ItemType.AVAILABLE_SPACE);
		itemSet.addItemAsSpace(buildItemWithDay(3, 0, 24, null, false), ItemType.AVAILABLE_SPACE);
		itemSet.addItemAsSpace(buildItemWithDay(4, 0, 24, null, false), ItemType.AVAILABLE_SPACE);
		itemSet.addItemAsSpace(buildItemWithDay(5, 0, 24, null, false), ItemType.AVAILABLE_SPACE);
		itemSet.addItemAsSpace(buildItemWithDay(6, 0, 24, null, false), ItemType.AVAILABLE_SPACE);
		var builtDp:CalendarDataProvider = new CalendarDataProvider();
		var converter:MyItemEditorVOConverter=new MyItemEditorVOConverter()
		for(var j:int = 0;j<allList.length;j++){
			var model:ScheduleModel=allList.getItemAt(j) as ScheduleModel;
			//if(model.repeatStatus==0){
//				var calendarItem:CalendarItem=new CalendarItem(DateFormatter.parseDateString(model.beginTime),DateFormatter.parseDateString(model.endTime),model.title);
//				
//				var recurString:String = new String();
//				recurString += MyItemEditorVOConverter.getFreqType(model.repeatType);
//				recurString += MyItemEditorVOConverter.getByDay2(model.repeatType,model.repeatOnDays);
//				recurString += MyItemEditorVOConverter.getInterval(model.repeatInterval);
//				calendarItem.recur = new Recur(recurString);
//				Alert.show(recurString);
//				itemSet.addItem(calendarItem);
//			}else{
//			
//			}
			var item:MyItemEditorVO=new MyItemEditorVO();
			item.start=DateFormatter.parseDateString(model.beginTime);
			item.end=DateFormatter.parseDateString(model.endTime);
			item.summary=model.title;
			item.description=model.content;
			item.departmentShare=CommonUtils.int2Boolean(model.departmentShare);
			item.schoolShare=CommonUtils.int2Boolean(model.schoolShare);
			item.emergence=model.emergence;
			item.interval=model.repeatInterval;
			item.recurring=CommonUtils.int2Boolean(model.repeatStatus);
			item.repeatRuleId=model.repeatType;
			item.type=model.type;
			item.endDateSpecified=(model.repeatEndTime!=null?true:false);
			item.endDate=DateFormatter.parseDateString(model.repeatEndTime);
			//Alert.show(model.repeatEndTime);
			var calendarItem:CalendarItem=converter.itemEditorVOToCalendarItem(item);
			calendarItem.itemId=model.id;
			//Alert.show(calendarItem.recur.until+"");
//			Alert.show(item.interval+"");
			itemSet.addItem(calendarItem);
		}
		builtDp.addItemSet(itemSet);	
		return builtDp;
		
	}

//	public function buildExampleDataProvider():CalendarDataProvider
//	{
//		var itemSet:CalendarItemSet = new CalendarItemSet();
////		var itemSet:CalendarItemSet = new CalendarItemSet(true); // calendar set marked as read only - example
////		var item_one:CalendarItem = buildItemWithDay(1, 6.5, 7.5, "Morning excercises");
////		item_one.recur = new Recur("FREQ=DAILY");
////		itemSet.addItem(item_one);
////		itemSet.addItemAsSpace(buildItemWithDay(0, 0, 24, "Holiday", false), ItemType.UNAVAILABLE_SPACE);
////		itemSet.addItemAsSpace(buildItemWithDay(6, 0, 24, "Holiday", false), ItemType.UNAVAILABLE_SPACE);
////		itemSet.addItemAsSpace(buildItemWithDay(1, 8, 16, "Available", false, RendererColorsFactory.buildColors(RendererColors.YELLOW)), ItemType.AVAILABLE_SPACE);
////		itemSet.addItemAsSpace(buildItemWithDay(1, 18, 20, "Available", false), ItemType.AVAILABLE_SPACE);
////		itemSet.addItemAsSpace(buildItemWithDay(2, 8, 16, "Available", false), ItemType.AVAILABLE_SPACE);
////		itemSet.addItemAsSpace(buildItemWithDay(3, 8, 16, "Available", false), ItemType.AVAILABLE_SPACE);
////		itemSet.addItemAsSpace(buildItemWithDay(3, 18, 20, "Available", false), ItemType.AVAILABLE_SPACE);
////		itemSet.addItemAsSpace(buildItemWithDay(4, 8, 16, "Available", false), ItemType.AVAILABLE_SPACE);
////		itemSet.addItemAsSpace(buildItemWithDay(5, 8, 16, "Available", false), ItemType.AVAILABLE_SPACE);
////		itemSet.addItemAsSpace(buildItemWithDay(5, 18, 20, "Available", false), ItemType.AVAILABLE_SPACE);
//		itemSet.addItemAsSpace(buildItemWithDay(0, 0, 24, null, false), ItemType.AVAILABLE_SPACE);
//		itemSet.addItemAsSpace(buildItemWithDay(1, 0, 24, null, false), ItemType.AVAILABLE_SPACE);
//		itemSet.addItemAsSpace(buildItemWithDay(2, 0, 24, null, false), ItemType.AVAILABLE_SPACE);
//		itemSet.addItemAsSpace(buildItemWithDay(3, 0, 24, null, false), ItemType.AVAILABLE_SPACE);
//		itemSet.addItemAsSpace(buildItemWithDay(4, 0, 24, null, false), ItemType.AVAILABLE_SPACE);
//		itemSet.addItemAsSpace(buildItemWithDay(5, 0, 24, null, false), ItemType.AVAILABLE_SPACE);
//		itemSet.addItemAsSpace(buildItemWithDay(6, 0, 24, null, false), ItemType.AVAILABLE_SPACE);
//
//
//		itemSet.addItem(buildItemWithDay(1, 8.5, 11, "Important meeting", false, RendererColorsFactory.buildColorsWithGradient(RendererColors.RED)));
//		itemSet.addItem(buildItemWithDay(1, 11.5, 12.5, "Lunch with Mark", false, RendererColorsFactory.buildColorsWithGradient(RendererColors.YELLOW)));
//
//		itemSet.addItem(buildItemWithDay(2, 9.5, 12.5, "Negotiations with ABCD", false, RendererColorsFactory.buildColorsWithGradient(RendererColors.LIGHT_BLUE)));
//
//		itemSet.addItem(buildItemWithDay(3, 13, 16, "Busy", false, RendererColorsFactory.buildColorsWithGradient(RendererColors.VIOLET)));
//
//		itemSet.addItem(buildItemWithDay(4, 8, 13, "Strategy planning", false, RendererColorsFactory.buildColorsWithGradient(RendererColors.ORANGE)));
//
//		itemSet.addItem(buildItemWithDay(4, 14, 16, "Read only event", true));
//
//		itemSet.addItem(buildItemWithDay(5, 10, 16, "Ecology meeting", false, RendererColorsFactory.buildColorsWithGradient(RendererColors.GREEN)));
//		itemSet.addItem(buildItemWithDay(5, 18, 19, "Consultation", false, RendererColorsFactory.buildColorsWithGradient(RendererColors.BROWN)));
//
//		var builtDp:CalendarDataProvider = new CalendarDataProvider();
//		builtDp.addItemSet(itemSet);
//
//		return builtDp;
//
//	}
//
	private function buildItem(startTime:Number, endTime:Number, summary:String, readOnly:Boolean = false, rendererColors:IRendererColors=null):CalendarItem
	{
		var today:Date = DateUtils.startOfDay(new Date());
		var start:Date = new Date();
		start.time = today.time + startTime*DateUtils.MILLI_IN_HOUR;
		var end:Date = new Date();
		end.time = today.time + endTime*DateUtils.MILLI_IN_HOUR;
		return new CalendarItem(start, end, summary, null, readOnly, rendererColors);
	}

	private function buildItemWithDay(dayOffset:Number, startTime:Number, endTime:Number, summary:String, readOnly:Boolean = false, rendererColors:IRendererColors=null):CalendarItem
	{
		var today:Date = DateUtils.startOfDay(new Date());
		var sunday:Date = DateUtils.startOfDay(new Date());
		DateUtils.addDays(sunday, 0-today.day);
		DateUtils.addDays(sunday, dayOffset);
		var start:Date = new Date();
		start.time = sunday.time + startTime*DateUtils.MILLI_IN_HOUR;
		var end:Date = new Date();
		end.time = sunday.time + endTime*DateUtils.MILLI_IN_HOUR;
		return new CalendarItem(start, end, summary, null, readOnly, rendererColors);
	}

	private function buildLongItem(dayCount:int, startTime:Number, endTime:Number, summary:String):CalendarItem
	{
		var today:Date = DateUtils.startOfDay(new Date());
		var start:Date = new Date();
		start.time = today.time + startTime*DateUtils.MILLI_IN_HOUR;
		var end:Date = new Date();
		end.time = today.time + dayCount * DateUtils.MILLI_IN_DAY + endTime*DateUtils.MILLI_IN_HOUR;
		return new CalendarItem(start, end, summary);
	}
}
}