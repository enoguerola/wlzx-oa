package system.utils
{
	[Bindable]
	[RemoteClass(alias="system.PaginationSupport")] 
	public class PaginationSupport
	{
		// 总记录数
		public var totalCount:int;
		//总页数
		public var totalPage:int;
		//当前页
		public var currentPage:int;
		public var items:Object = new Array();
	
		public function PaginationSupport()
		{
		}
	}
}