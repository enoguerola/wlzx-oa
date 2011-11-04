package basic.utils
{	
	import flash.utils.ByteArray;
	
	import mx.collections.ArrayCollection;
	import mx.collections.Sort;
	import mx.collections.SortField;
	import mx.formatters.*;
	import mx.controls.Alert;
	public class DateTimeTool
	{
		public static const DAYS:Array = ["周日", "周一", "周二", "周三", "周四","周五", "周六"];
		/**
		* 格式化日期
		*/
		public static function formatDate(date:Date,patten:String=null):String{
			if(date==null)return null;
			var dateFormatter:DateFormatter=new DateFormatter();
			if(patten==null)dateFormatter.formatString="YYYY-MM-DD JJ:NN:SS";
			else dateFormatter.formatString=patten;
			return dateFormatter.format(date);
		}
		/**
		 * 本年度年初日期
		 */
		public static function currentYearBeginDate():Date{
			var currentDate:Date=new Date();
			return new Date(currentDate.getFullYear(),0,1);
		}
		/**
		 * 本年度年末日期
		 */
		public static function currentYearEndDate():Date{
			var currentDate:Date=new Date();
			return new Date(currentDate.getFullYear()+1,0,0);
		}
		/**
		 * 本月月初日期
		 */
		public static function currentMonthBeginDate():Date{
			var currentDate:Date=new Date();
			return new Date(currentDate.getFullYear(),currentDate.getMonth(),1);
		}
		/**
		 * 本月月末日期
		 */
		public static function currentMonthEndDate():Date{
			var currentDate:Date=new Date();
			return new Date(currentDate.getFullYear(),currentDate.getMonth()+1,0);
		}
		/**
		 * 本周周一日期
		 */
		public static function currentWeekBeginDate():Date{
			var currentDate:Date=new Date();
			return new Date(currentDate.getFullYear(),currentDate.getMonth(),currentDate.date-((currentDate.day+6)%7));
		}
		/**
		 * 本周周末日期
		 */
		public static function currentWeekEndDate():Date{
			var currentDate:Date=new Date();
			return new Date(currentDate.getFullYear(),currentDate.getMonth(),currentDate.date-((currentDate.day+6)%7)+6);
		}
		/**
		 * 两个日期间的所有日期集合
		 */
		public static function getDatesDateRange(startDate:Date,endDate:Date):ArrayCollection{
			var dates:ArrayCollection=new ArrayCollection();
			var offset:int = getIntervalDays(startDate, endDate);  	
			if(offset==0){
				dates.addItem({"date":formatDate(startDate,"YYYY-MM-DD"),"week":DAYS[startDate.getDay()]});
				return dates;
			}
			for(var i:int=0;i<=offset;i++){
				var temp:Date=new Date(startDate.time);
				temp["date"]+=i; 
				dates.addItem({"date":formatDate(temp,"YYYY-MM-DD"),"week":DAYS[temp.getDay()]});
			}
			return dates;
		}
		/**
		 * 两个日期间的间隔天数
		 */
		public static function getIntervalDays( startday:Date, endday:Date):int{
			var sl:Number=startday.valueOf();
			var el:Number=endday.valueOf();
			var ei:Number=el-sl;
			return (int)(ei/(1000*60*60*24));
		}
//		public static function int2Boolean(num:int):Boolean{
//			if(num==0)return false;
//			else return true;
//		}
//		//深复制调用的方法
//		public static function clone(source:Object):Array
//		{
//			var myBA:ByteArray = new ByteArray();
//			myBA.writeObject(source);
//			myBA.position = 0;
//			return(myBA.readObject());
//		}
//		/**
//		 * 生成datagrid第一列用的序号
//		 */
//		import mx.core.mx_internal;//注意这里 
//		public static function formatIndexNumber(item:Object, colum:Object):String
//		{
//			return indexNumLabelFun(item, colum.mx_internal::owner);
//		}
//		
//		public static function indexNumLabelFun(value:Object, dataGrid:Object):String
//			
//		{
//			var arr: Array = dataGrid.dataProvider.source;
//			var indexNum: int = (arr.indexOf(value) + 1);            
//			return indexNum.toString();
//		}
	}
}