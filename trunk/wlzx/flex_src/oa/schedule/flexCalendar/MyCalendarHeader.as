package oa.schedule.flexCalendar
{
import com.flexcalendar.components.calendar.FlexCalendar;
import com.flexcalendar.components.calendar.displayClasses.headers.CalendarHeader;

import mx.controls.Alert;
import mx.controls.Button;

public class MyCalendarHeader extends CalendarHeader
{
	public var maxControlButton:Button=new Button();
	public function MyCalendarHeader(calendar:FlexCalendar)
	{
		super(null,calendar);
		//createChildren();
	}

	override protected function createChildren():void
	{
		
		super.createChildren();

		dayButton.width=80;
		weekButton.width=80;
		workingWeekButton.width=80;
		monthButton.width=80;
		Alert.show("a");
		maxControlButton.label="最大化";
		maxControlButton.width=80;
		maxControlButton.height=80;
		this.addChild(maxControlButton);
	}
}
}