package system.utils
{	
	import flash.utils.ByteArray;
	
	import mx.collections.ArrayCollection;
	import mx.collections.Sort;
	import mx.collections.SortField;
	import mx.controls.Alert;
	import mx.formatters.*;
	public class CommonUtils
	{
		public static const DAYS:Array = ["周日", "周一", "周二", "周三", "周四","周五", "周六"];
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
		public static function contains(list:ArrayCollection,data:String):Boolean{
			var contain:Boolean=false;
			for(var i:int=0;i<list.length;i++){
				var item:Object=list.getItemAt(i) as Object;
				if(item.data==data){contain=true;break;}
			} 
			return contain;
			
		}
		public static function formatDate(date:Date,patten:String=null):String{
			if(date==null)return null;
			var dateFormatter:DateFormatter=new DateFormatter();
			if(patten==null)dateFormatter.formatString="YYYY-MM-DD JJ:NN:SS";
			else dateFormatter.formatString=patten;
			return dateFormatter.format(date);
		}
		public static function currentYearBeginDate():Date{
			var currentDate:Date=new Date();
			return new Date(currentDate.getFullYear(),0,1);
		}
		public static function currentYearEndDate():Date{
			var currentDate:Date=new Date();
			return new Date(currentDate.getFullYear()+1,0,0);
		}
		public static function currentMonthBeginDate():Date{
			var currentDate:Date=new Date();
			return new Date(currentDate.getFullYear(),currentDate.getMonth(),1);
		}
		public static function currentMonthEndDate():Date{
			var currentDate:Date=new Date();
			return new Date(currentDate.getFullYear(),currentDate.getMonth()+1,0);
		}
		public static function currentWeekBeginDate():Date{
			var currentDate:Date=new Date();
			return new Date(currentDate.getFullYear(),currentDate.getMonth(),currentDate.date-((currentDate.day+6)%7));
		}
		public static function currentWeekEndDate():Date{
			var currentDate:Date=new Date();
			return new Date(currentDate.getFullYear(),currentDate.getMonth(),currentDate.date-((currentDate.day+6)%7)+6);
		}
		public static function int2Boolean(num:int):Boolean{
			if(num==0)return false;
			else return true;
		}
		//深复制调用的方法
		public static function clone(source:Object):Array
		{
			var myBA:ByteArray = new ByteArray();
			myBA.writeObject(source);
			myBA.position = 0;
			return(myBA.readObject());
		}
		public static function getDatesDateRange(startDate:Date,endDate:Date):ArrayCollection{
			var dates:ArrayCollection=new ArrayCollection();
			var offset:int = getIntervalDays(startDate, endDate);  	
			if(offset==0){
			//	dates.add(startDate);
				dates.addItem({"date":formatDate(startDate,"YYYY-MM-DD"),"week":DAYS[startDate.getDay()]});
				return dates;
			}
			//Alert.show(offset+"");
			for(var i:int=0;i<=offset;i++){
				var temp:Date=new Date(startDate.time);
				temp["date"]+=i; 
//				Calendar calendar= Calendar.getInstance();
//				calendar.setTime(startDate);
//				calendar.add(Calendar.DATE, i);
				dates.addItem({"date":formatDate(temp,"YYYY-MM-DD"),"week":DAYS[temp.getDay()]});
			}
			return dates;
		}
		public static function getIntervalDays( startday:Date, endday:Date):int{
			//分别得到两个时间的毫秒数
			var sl:Number=startday.valueOf();
			var el:Number=endday.valueOf();
			
			var ei:Number=el-sl;
			//根据毫秒数计算间隔天数
			return (int)(ei/(1000*60*60*24));
		}
		/**
		 * 生成datagrid第一列用的序号
		 */
		import mx.core.mx_internal;//注意这里 
		public static function formatIndexNumber(item:Object, colum:Object):String
		{
			return indexNumLabelFun(item, colum.mx_internal::owner);
		}
		
		public static function indexNumLabelFun(value:Object, dataGrid:Object):String
			
		{
			var arr: Array = dataGrid.dataProvider.source;
			var indexNum: int = (arr.indexOf(value) + 1);            
			return indexNum.toString();
		}
	}
}