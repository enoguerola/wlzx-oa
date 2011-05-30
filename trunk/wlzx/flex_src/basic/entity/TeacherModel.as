package basic.entity
{
	import system.entity.PersonModel;
	
	[Bindable]
	[RemoteClass(alias="system.wlims.basic.entity.teacher.TeacherModel")] 
	public class TeacherModel extends PersonModel
	{
		public var  teacherMarried:String;
		public var  teacherID:String;
		public var  teacherNativePlace:String;
		public var  teacherMail:String;
		public var  teacherNo:String;
		public var  teacherEducation:int;
		public var  teacherProfession:String;
		public var  teacherGraduateSchool:String;
		public var  teacherProfessionTitle:String;
		public var  teacherSkillLevel:String;
		public var  teacherSkillLevelDate:Date;
		public var  teacherDepartment:String;
		public var  teacherPosition:String;
		public var  teacherContactPhone:String;
		public var  teacherOfficePhone:String;
		public var  teacherWorkDate:Date;
		public var  teacherAddress:String;
		public var  teacherPhoto:String;
		public var  teacherStatus:String;
		public var  teacherAttendDate:Date;
		
		//public var  teacherStaus:String;
		//public var  teacherStaus:String;
		//public var  teacherStaus:String;
		
		public function TeacherModel()
		{
			super();
		}
	}
}