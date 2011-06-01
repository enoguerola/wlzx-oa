package basic.entity
{
	[Bindable]
	[RemoteClass(alias="system.wlims.basic.entity.teacher.TeacherDepartment")] 
	public class TeacherDepartment extends BaseModel
	{
		public var department:String;
		public var position:String;
		
		public var teacher:TeacherModel;
		
		public function TeacherDepartment()
		{
			super();
		}
	}
}