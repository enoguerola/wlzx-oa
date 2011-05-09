package system.utils
{	
	import mx.collections.ArrayCollection;
	import mx.collections.Sort;
	import mx.collections.SortField;
	import mx.formatters.*;
	public class CommonUtils
	{
		public static function sortBySequence(list:ArrayCollection):void{
			var sort:Sort=new Sort();  
			//按照sequence升序排序  
			sort.fields=[new SortField("sequence")];  
			list.sort=sort;
			list.refresh();//更新  
			
		}
		public static function formatDate(date:Date,patten:String=null):String{
			if(date==null)return null;
			var dateFormatter:DateFormatter=new DateFormatter();
			if(patten==null)dateFormatter.formatString="YYYY-MM-DD JJ:NN:SS";
			else dateFormatter.formatString=patten;
			return dateFormatter.format(date);
		}
		
	}
}