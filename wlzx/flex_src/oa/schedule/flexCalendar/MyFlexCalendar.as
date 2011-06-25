package oa.schedule.flexCalendar
{
import com.flexcalendar.components.calendar.FlexCalendar;
import com.flexcalendar.components.calendar.editor.*;
import mx.controls.Alert;
public class MyFlexCalendar extends FlexCalendar
{
	public function MyFlexCalendar()
	{
		super();
		this.header = new MyCalendarHeader(this); 
		
	}

//	override protected function createHeader():void
//	{
//		//do not call super
//		this.header = new MyCalendarHeader(this); 
//	}
	
}
}