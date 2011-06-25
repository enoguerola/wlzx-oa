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
		public static function sortByCondition(list:ArrayCollection,condition:String):void{
			var sort:Sort=new Sort();  
			//按照condition升序排序  
			sort.fields=[new SortField(condition)];  
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
		public static function currentMonthBeginDate():Date{
			var currentDate:Date=new Date();
			return new Date(currentDate.getFullYear(),currentDate.getMonth(),1);
		}
		public static function currentMonthEndDate():Date{
			var currentDate:Date=new Date();
			return new Date(currentDate.getFullYear(),currentDate.getMonth()+1,0);
		}
		public static function int2Boolean(num:int):Boolean{
			if(num==0)return false;
			else return true;
		}
	}
}