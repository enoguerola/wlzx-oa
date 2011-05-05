package system.component
{	
	import mx.collections.ArrayCollection;
	import mx.collections.Sort;
	import mx.collections.SortField;
	public class CommonUtils
	{
		public static function sortBySequence(list:ArrayCollection):void{
			var sort:Sort=new Sort();  
			//按照sequence升序排序  
			sort.fields=[new SortField("sequence")];  
			list.sort=sort;
			list.refresh();//更新  
			
		}
	}
}