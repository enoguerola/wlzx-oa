package oa.schedule.flexCalendar
{
import com.flexcalendar.components.calendar.FlexCalendar;

public class MyFlexCalendar extends FlexCalendar
{
	public function MyFlexCalendar()
	{
		super();
		this.createHeader();
	}

	override protected function createHeader():void
	{
		//do not call super
		this.header = new MyCalendarHeader(this); 
	}
}
}