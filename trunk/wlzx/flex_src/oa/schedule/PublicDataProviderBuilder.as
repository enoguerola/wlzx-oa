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
public class PublicDataProviderBuilder
{

	public function PublicDataProviderBuilder()
	{
	}
	
	public function buildDataProvider(allList:ArrayCollection):CalendarDataProvider
	{
		var itemSet:CalendarItemSet = new CalendarItemSet();
		var builtDp:CalendarDataProvider = new CalendarDataProvider();
		var converter:MyItemEditorVOConverter=new MyItemEditorVOConverter();
		//Alert.show(allList.length+"");
		for(var j:int = 0;j<allList.length;j++){
			var model:ScheduleModel=allList.getItemAt(j) as ScheduleModel;

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
			var calendarItem:CalendarItem=converter.itemEditorVOToCalendarItem(item);
			calendarItem.itemId=model.id;
			if(model.finishStatus==1){
				calendarItem.itemColors=RendererColorsFactory.buildColors(RendererColors.GRAY);
				calendarItem.readOnly=true;
			}
			itemSet.addItem(calendarItem);
		}
		builtDp.addItemSet(itemSet);	
		return builtDp;
		
	}


}
}