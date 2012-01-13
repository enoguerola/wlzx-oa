package oa.schedule.flexCalendar
{
import com.flexcalendar.components.calendar.core.dataModel.CalendarItem;
import com.flexcalendar.components.calendar.core.dataModel.formatICalendar.Recur;
import com.flexcalendar.components.calendar.core.dataModel.formatICalendar.WeekDay;
import com.flexcalendar.components.calendar.utils.DateUtils;
import mx.controls.Alert;
/**
 * Converter for ItemEditorVO.
 * Can convert CalendarItem to ItemEditorVO.
 * Can create new CalendarItem from ItemEditorVO
 * Can update fields of CalendarItem based on new ItemEditorVO values
 */

public class  MyItemEditorVOConverter
{
	public function MyItemEditorVOConverter()
	{
	}

	public function calendarItemToItemEditorVO(calendarItem:CalendarItem):MyItemEditorVO
	{
		var itemEditorVO:MyItemEditorVO = new MyItemEditorVO();
		itemEditorVO.summary = calendarItem.summary;
		itemEditorVO.description = calendarItem.description;
		itemEditorVO.start = calendarItem.start;
		itemEditorVO.end = calendarItem.end;
		itemEditorVO.recurring = calendarItem.isRecurring();
		/*if (itemEditorVO.recurring)
		{
			itemEditorVO.repeatRuleId = getRepeatRuleId(calendarItem.recur);

			if (itemEditorVO.repeatRuleId == MyItemEditorVO.WEEKLY)
			{
				markWeekDays(itemEditorVO, calendarItem.recur);
			}

			itemEditorVO.interval = calendarItem.recur.interval > 0 ? calendarItem.recur.interval - 1 : 0;
			itemEditorVO.endDateSpecified = calendarItem.recur.until != null;
			if (itemEditorVO.endDateSpecified)
			{
				itemEditorVO.endDate = calendarItem.recur.until;
			}
		}*/

		return itemEditorVO;
	}

	private function getRepeatRuleId(recur:Recur):int
	{
		if (recur.freq == Recur.DAILY)
			return MyItemEditorVO.DAILY;
		if (recur.freq == Recur.MONTHLY)
			return MyItemEditorVO.MONTHLY;
		if (recur.freq == Recur.YEARLY)
			return MyItemEditorVO.YEARLY;
		if (recur.freq == Recur.WEEKLY)
			return MyItemEditorVO.WEEKLY;

		return -1;
	}

	private function markWeekDays(itemEditorVO:MyItemEditorVO, recur:Recur):void
	{
		/*itemEditorVO.MO = markDay(DateUtils.MO, recur.byDay);
		itemEditorVO.TU = markDay(DateUtils.TU, recur.byDay);
		itemEditorVO.WE = markDay(DateUtils.WE, recur.byDay);
		itemEditorVO.TH = markDay(DateUtils.TH, recur.byDay);
		itemEditorVO.FR = markDay(DateUtils.FR, recur.byDay);
		itemEditorVO.SA = markDay(DateUtils.SA, recur.byDay);
		itemEditorVO.SU = markDay(DateUtils.SU, recur.byDay);*/
	}

	private function markDay(day:String, byDay:Array):Boolean
	{
		if (byDay == null || byDay.length == 0)
			return false;
		for each(var weekDay:WeekDay in byDay)
		{
			if (weekDay.day == day)
				return true;
		}
		return false;
	}

	public function itemEditorVOToCalendarItem(itemEditorVO:MyItemEditorVO, calendarItem:CalendarItem = null):CalendarItem
	{
		if(calendarItem == null)
		{
			calendarItem = new CalendarItem(itemEditorVO.start, itemEditorVO.end, itemEditorVO.summary, itemEditorVO.description);
		}
	//	calendarItem.setRange(itemEditorVO.start, itemEditorVO.end);
		calendarItem.summary = itemEditorVO.summary;
		calendarItem.description = itemEditorVO.description;

		/*if(itemEditorVO.recurring)
		{
			var recurString:String = new String();
			recurString += getFreqType(itemEditorVO.repeatRuleId);
			recurString += getEndDay(itemEditorVO);
			recurString += getInterval(itemEditorVO.interval);
			recurString += getByDay(itemEditorVO);


			calendarItem.recur = new Recur(recurString);
		}*/

		return calendarItem;
	}


	public static function getFreqType(repeatRuleId:int):String
	{
		var recurString:String = "FREQ=";
		switch(repeatRuleId)
		{
			case MyItemEditorVO.DAILY:
				recurString += Recur.DAILY;
				break;

			case MyItemEditorVO.EVERY_WEEKDAY:
			case MyItemEditorVO.EVERY_MO_WED_FRI:
			case MyItemEditorVO.EVERY_THUES_THURS:
			case MyItemEditorVO.WEEKLY:
				recurString += Recur.WEEKLY;
				break;

			case MyItemEditorVO.MONTHLY:
				recurString += Recur.MONTHLY;
				break;

			case MyItemEditorVO.YEARLY:
				recurString += Recur.YEARLY;
				break;

			default:
				throw new Error("Unable to create recurrence instance");
		}

		return recurString;
	}

	public static function getInterval(interval:int):String
	{
		if(interval != 0)
		{
			return ";INTERVAL=" + (interval + 1);
		}
		else
		{
			return "";			
		}
	}

	private function getByDay(itemEditorVO:MyItemEditorVO):String
	{
		/*if(itemEditorVO.repeatRuleId == MyItemEditorVO.EVERY_MO_WED_FRI)
		{
			return ";BYDAY=MO,WE,FR";
		}
		else if(itemEditorVO.repeatRuleId == MyItemEditorVO.EVERY_THUES_THURS)
		{
			return ";BYDAY=TU,TH";
		}
		else if(itemEditorVO.repeatRuleId == MyItemEditorVO.EVERY_WEEKDAY)
			{
				return ";BYDAY=MO,TU,WE,TH,FR"
			}
		else if(itemEditorVO.repeatRuleId == MyItemEditorVO.WEEKLY)
				{
					var byDayString:String = ";BYDAY=";
					var days:Array = ["MO", "TU", "WE", "TH", "FR", "SA", "SU"];
					var anyDaySelected:Boolean = false;
					for(var i:int = 0; i < days.length; i++)
					{
						var dayAbbr:String = days[i];
						if(itemEditorVO[dayAbbr])
						{
							byDayString += (anyDaySelected ? "," : "") + dayAbbr; 
							anyDaySelected = true;
						}
					}
					if(anyDaySelected)
						return byDayString;
					else
						return "";
					
				}*/
		
		return "";
	}
	public static function getByDay2(repeatRuleId:int,repeatOnDays:String):String
	{
		if(repeatRuleId == MyItemEditorVO.EVERY_MO_WED_FRI)
		{
			return ";BYDAY=MO,WE,FR";
		}
		else if(repeatRuleId == MyItemEditorVO.EVERY_THUES_THURS)
		{
			return ";BYDAY=TU,TH";
		}
		else if(repeatRuleId == MyItemEditorVO.EVERY_WEEKDAY)
		{
			return ";BYDAY=MO,TU,WE,TH,FR"
		}
		else if(repeatRuleId == MyItemEditorVO.WEEKLY)
		{
			var byDayString:String = ";BYDAY=";
			var days:Array = ["MO", "TU", "WE", "TH", "FR", "SA", "SU"];
			var anyDaySelected:Boolean = false;
			for(var i:int = 0; i < days.length; i++)
			{
				var dayAbbr:String = days[i];
				if(repeatOnDays.split(";")[i]=="1")
				{
					byDayString += (anyDaySelected ? "," : "") + dayAbbr; 
					anyDaySelected = true;
				}
			}
			if(anyDaySelected)
				return byDayString;
			else
				return "";
			
		}
		
		return "";
	}

	private function getEndDay(itemEditorVO:MyItemEditorVO):String
	{
		/*if(!itemEditorVO.endDateSpecified)
		{
			return "";
		}
		else
		{
			var untilString:String = ";UNTIL=";
			untilString += itemEditorVO.endDate.fullYear;
            untilString += itemEditorVO.endDate.month < 9 ? "0" + (itemEditorVO.endDate.month + 1) :
                    "" + itemEditorVO.endDate.month + 1;
			untilString += itemEditorVO.endDate.date < 10 ? "0" + itemEditorVO.endDate.date :
                    "" + itemEditorVO.endDate.date;

			return untilString;
		}*/
		return "";
	}

}
}