package oa.schedule.flexCalendar
{
	import com.flexcalendar.components.calendar.editor.baloon.*;
	import com.flexcalendar.components.calendar.*;
	import com.flexcalendar.components.calendar.core.dataModel.*;
	import com.flexcalendar.components.calendar.displayClasses.grids.*;
	import com.flexcalendar.components.calendar.editor.*;
	import com.flexcalendar.components.calendar.editor.builders.*;
	import com.flexcalendar.components.calendar.events.*;
	import flash.display.*;
	import flash.geom.*;
	import mx.managers.*;
	import mx.resources.*;
	import mx.controls.Alert;
	public class MyBaloonItemEditor  extends Object implements IItemEditor
	{
		private var isNew:Boolean = false;
		private var calendarItem:CalendarItem;
		private var calendarMouseEvent:CalendarMouseEvent;
		private var editorPanel:MyBaloonEditorPanel;
		private var calendar:FlexCalendar;
		private var converter:ItemEditorVOConverter;
		private var doubleClickOnRenderers:Boolean;
		private var doubleClickOnCalendar:Boolean;
		private var preferedTimeForNewEvents:Number;
		
		public function MyBaloonItemEditor(calendar:FlexCalendar, doubleClickOnRenderers:Boolean = false, doubleClickOnCalendar:Boolean = false)
		{
			this.converter = new ItemEditorVOConverter();
			this.calendar = calendar;
			this.doubleClickOnRenderers = doubleClickOnRenderers;
			this.doubleClickOnCalendar = doubleClickOnCalendar;
			return;
		}// end function
		
		public function calendarClickHandler(event:CalendarMouseEvent) : void
		{
			if (!this.doubleClickOnCalendar)
			{
				this.addNewItemPopup(event);
			}
			return;
		}// end function
		
		public function calendarDoubleClickHandler(event:CalendarMouseEvent) : void
		{
			if (this.doubleClickOnCalendar)
			{
				this.addNewItemPopup(event);
			}
			return;
		}// end function
		
		private function addNewItemPopup(event:CalendarMouseEvent) : void
		{
			this.calendarMouseEvent = event;
			this.preferedTimeForNewEvents = event.preferredTimeInMills;
			this.calendarItem = new CalendarItem(event.selectedDate, new Date(event.selectedDate.time + this.preferedTimeForNewEvents), ResourceManager.getInstance().getString("FlexCalendar", "editor.newItem"));
			this.isNew = true;
			var _loc_2:* = this.calendarMousePositionFromEvent(event);
			this.createEditorPopUp(_loc_2.x, _loc_2.y, this.saveCallbackForCreateHandler);
			return;
		}// end function
		
		public function rendererClickHandler(event:CalendarMouseEvent) : void
		{
			if (!this.doubleClickOnRenderers)
			{
				this.editItemPopup(event);
			}
			return;
		}// end function
		
		public function rendererDoubleClickHandler(event:CalendarMouseEvent) : void
		{
			if (this.doubleClickOnRenderers)
			{
				this.editItemPopup(event);
			}
			return;
		}// end function
		
		public function spaceRendererClickHandler(event:CalendarMouseEvent) : void
		{
			if (!this.doubleClickOnRenderers)
			{
				this.addNewItemPopup(event);
			}
			return;
		}// end function
		
		public function spaceRendererDoubleClickHandler(event:CalendarMouseEvent) : void
		{
			if (this.doubleClickOnRenderers)
			{
				this.addNewItemPopup(event);
			}
			return;
		}// end function
		
		private function editItemPopup(event:CalendarMouseEvent) : void
		{
			this.calendarMouseEvent = event;
			this.calendarItem = event.item;
			this.preferedTimeForNewEvents = event.preferredTimeInMills;
			this.isNew = false;
			var _loc_2:* = this.calendarMousePositionFromEvent(event);
			this.createEditorPopUp(_loc_2.x, _loc_2.y, this.saveCallbackForUpdateHandler);
			return;
		}// end function
		
		private function createEditorPopUp(clickedX:Number, clickedY:Number, saveCallback:Function) : void
		{
			this.editorPanel = new MyBaloonEditorPanel();
			this.editorPanel.item = this.converter.calendarItemToItemEditorVO(this.calendarItem);
			this.editorPanel.saveCallback = saveCallback;
			this.editorPanel.cancelCallback = this.cancelCallbackHandler;
			this.editorPanel.deleteCallback = this.deleteCallback;
			this.editorPanel.repeatVariants = new RepeatVariantsBuilder().repeatVariants;
			this.editorPanel.intervalVariants = new IntervalVariantsBuilder().intervalVariants;
			this.editorPanel.isNew = this.isNew;
			PopUpManager.addPopUp(this.editorPanel, this.calendar, true);
			this.editorPanel.calculatePosition(clickedX, clickedY);
			return;
		}// end function
		
		private function fixRange() : void
		{
			if (this.calendarMouseEvent.item != null)
			{
			}
			if (this.calendarMouseEvent.item.start != null)
			{
			}
			if (this.calendarMouseEvent.item.end != null)
			{
				if (this.calendarItem.start >= this.calendarMouseEvent.item.start)
				{
				}
				if (this.calendarItem.end <= this.calendarMouseEvent.item.start)
				{
					this.calendarItem.start = this.calendarMouseEvent.item.start;
					this.calendarItem.end = new Date(this.calendarMouseEvent.item.start.time + this.preferedTimeForNewEvents);
				}
				else
				{
					if (this.calendarItem.start < this.calendarMouseEvent.item.end)
					{
					}
					if (this.calendarItem.end > this.calendarMouseEvent.item.end)
					{
						this.calendarItem.start = new Date(this.calendarMouseEvent.item.end.time - this.preferedTimeForNewEvents);
						this.calendarItem.end = this.calendarMouseEvent.item.end;
					}
				}
			}
			return;
		}// end function
		
		private function saveCallbackForUpdateHandler() : void
		{
			var _loc_1:DayViewGrid = null;
			if (this.calendarMouseEvent != null)
			{
			}
			if (this.calendarMouseEvent.renderersContainer != null)
			{
				_loc_1 = this.calendarMouseEvent.renderersContainer as DayViewGrid;
				if (_loc_1 != null)
				{
					if (!_loc_1.isAvailableSpaceForGivenPeriod(this.editorPanel.item.start, this.editorPanel.item.end))
					{
						this.calendar.refresh();
						this.removeAndClosePopUp();
						return;
					}
				}
			}
			this.calendarItem = this.converter.itemEditorVOToCalendarItem(this.editorPanel.item, this.calendarItem);
			this.fixRange();
			this.calendar.refresh();
			this.removeAndClosePopUp();
			return;
		}// end function
		
		private function saveCallbackForCreateHandler() : void
		{
			var _loc_1:DayViewGrid = null;
			if (this.calendarMouseEvent != null)
			{
			}
			if (this.calendarMouseEvent.renderersContainer != null)
			{
				_loc_1 = this.calendarMouseEvent.renderersContainer as DayViewGrid;
				if (_loc_1 != null)
				{
					if (!_loc_1.isAvailableSpaceForGivenPeriod(this.editorPanel.item.start, this.editorPanel.item.end))
					{
						this.calendar.refresh();
						this.removeAndClosePopUp();
						return;
					}
				}
			}
			this.calendarItem = this.converter.itemEditorVOToCalendarItem(this.editorPanel.item, this.calendarItem);
			this.fixRange();
			this.calendar.dataProvider.itemSets[0].addItem(this.calendarItem);
			this.calendar.refresh();
			this.removeAndClosePopUp();
			return;
		}// end function
		
		private function cancelCallbackHandler() : void
		{
			this.removeAndClosePopUp();
			return;
		}// end function
		
		private function deleteCallback() : void
		{
			this.calendar.dataProvider.itemSets[0].removeItem(this.calendarItem);
			this.calendar.refresh();
			this.removeAndClosePopUp();
			return;
		}// end function
		
		private function removeAndClosePopUp() : void
		{
			if (this.editorPanel)
			{
				PopUpManager.removePopUp(this.editorPanel);
				this.editorPanel = null;
				this.calendarMouseEvent = null;
			}
			return;
		}// end function
		
		private function calendarMousePositionFromEvent(event:CalendarMouseEvent) : Point
		{
			return this.calendar.globalToLocal((event.target as DisplayObject).localToGlobal(new Point(event.target.mouseX, event.target.mouseY)));
		}// end function
	}
}