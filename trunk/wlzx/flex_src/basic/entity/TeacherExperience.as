package basic.entity
{
	[Bindable]
	[RemoteClass(alias="system.wlims.basic.entity.teacher.TeacherExperience")] 
	public class TeacherExperience extends BaseModel
	{
		public var company:String;
		public var position:String;
		public var startDate:Date;
		public var endDate:Date;
		
		public var teacher:TeacherModel;
		
		public function TeacherExperience()
		{
			super();
		}
	}
}