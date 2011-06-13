package basic.service
{
	import mx.rpc.AsyncToken;
	public interface TeacherService 
	{
		function checkNoAvailability(teacherID:String, teacherNo:String):AsyncToken
	}
}