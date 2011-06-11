package basic.entity
{
	[Bindable]
	[RemoteClass(alias="system.wlims.basic.entity.teacher.TeacherDepartment")] 
	public class TeacherDepartment
	{
		public var departmentName:String;
		public var positionName:String;
		public var positionId:String;
		public var teacherId:String;
		
		
		public function TeacherDepartment()
		{
			super();
		}
	}
}