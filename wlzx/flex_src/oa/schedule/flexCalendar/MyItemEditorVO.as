package oa.schedule.flexCalendar
{

/**
 * Item Editor Value Object - created empty or converted from CalendarItem.
 * Can be also converted to CalendarItem.  
 */

[Bindable]
public class MyItemEditorVO
{
	public static const DAILY:int = 0;
	public static const EVERY_WEEKDAY:int = 1;
	public static const EVERY_MO_WED_FRI:int = 2;
	public static const EVERY_THUES_THURS:int = 3;
	public static const WEEKLY:int = 4;
	public static const MONTHLY:int = 5;
	public static const YEARLY:int = 6;

	public var start:Date;
	public var end:Date;
	public var summary:String;
	public var description:String;
	public var recurring: Boolean;

	public var type:int;
	public var emergence:int;
	public var schoolShare:Boolean;
	public var departmentShare:Boolean;

/*	public var repeatRuleId:int;
	public var interval:int = 1;

	public var MO:Boolean;
	public var TU:Boolean;
	public var WE:Boolean;
	public var TH:Boolean;
	public var FR:Boolean;
	public var SA:Boolean;
	public var SU:Boolean; 

	public var endDateSpecified:Boolean;
	public var endDate:Date;*/


	public function MyItemEditorVO()
	{
		
	}
	

}
}