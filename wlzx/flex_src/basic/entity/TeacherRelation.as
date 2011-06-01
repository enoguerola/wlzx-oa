package basic.entity
{
	[Bindable]
	[RemoteClass(alias="system.wlims.basic.entity.teacher.TeacherRelation")] 
	public class TeacherRelation extends BaseModel
	{
		public var name:String;
		public var company:String;
		public var relation:String;
		public var phone:String;
		
		public var teacher:TeacherModel;
		
		public function TeacherRelation()
		{
			super();
		}
	}
}