package oa.schedule.flexCalendar
{
	import com.flexcalendar.components.calendar.editor.*;
	import com.flexcalendar.components.calendar.editor.baloon.*;
	
	import flash.events.*;
	import flash.geom.*;
	import flash.ui.*;
	import flash.utils.*;
	
	import mx.binding.*;
	import mx.collections.*;
	import mx.containers.*;
	import mx.controls.*;
	import mx.core.*;
	import mx.events.*;
	import mx.styles.*;
	
	public class MyBaloonEditorPanel extends BaloonEditorPanel
	{
		public var _BaloonEditorPanel_Label10:Label=new Label();
		public var _BaloonEditorPanel_combox10:ComboBox=new ComboBox();
		public var _BaloonEditorPanel_combox11:CheckBox=new CheckBox();
		public var _BaloonEditorPanel_combox12:CheckBox=new CheckBox();
		public var scheduleType:ArrayCollection = new ArrayCollection(
			[	{label:"私人日程", data:1},
				{label:"工作日程", data:2}]
		); 
		public function MyBaloonEditorPanel()
		{
			var vbox:VBox=new VBox();
			vbox.percentWidth=100;
			vbox.height=100;
			var _BaloonEditorPanel_HBox10:HBox=new HBox();
			_BaloonEditorPanel_HBox10.percentWidth=100;
			_BaloonEditorPanel_Label10.text="类型:";
			_BaloonEditorPanel_combox10.dataProvider=scheduleType; 
			_BaloonEditorPanel_HBox10.addElement(_BaloonEditorPanel_Label10);
			_BaloonEditorPanel_HBox10.addElement(_BaloonEditorPanel_combox10);
			
			var _BaloonEditorPanel_HBox11:HBox=new HBox();
			_BaloonEditorPanel_HBox11.percentWidth=100;
			_BaloonEditorPanel_combox11.label="部门日程共享";
			_BaloonEditorPanel_combox12.label="学校日程共享";
			_BaloonEditorPanel_HBox11.addElement(_BaloonEditorPanel_combox11);
			_BaloonEditorPanel_HBox11.addElement(_BaloonEditorPanel_combox12);
			vbox.addElement(_BaloonEditorPanel_HBox10);
			vbox.addElement(_BaloonEditorPanel_HBox11);
			this.addElement(vbox);
//			this._BaloonEditorPanel_VBox2.validateNow();
			super();
			this.validateNow();

		}
	}
}