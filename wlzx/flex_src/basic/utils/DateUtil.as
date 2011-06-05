package basic.utils
{
		import mx.controls.dataGridClasses.DataGridColumn;
		import mx.formatters.DateFormatter;
		
		public class DateUtil {
			public function DateUtil() {
			}
			
			//转换日期字符串如19990101为1999-01-01格式
			public static function DateStringFormatter(str:String):String {
				var dateStr:String;
				if (str != null && str.length >= 8) {
					dateStr = str.substr(0, 4) + "-" + str.substr(4, 2) + "-" + str.substr(6, 2)
				}
				return dateStr;
			}
			
			//转换日期字符串如1999-01-01为19990101格式
			public static function DateStringFormatter_two(str:String):String {
				var dateStr:String;
				if (str != null) {
					dateStr = str.replace(/-/g, "");
				}
				return dateStr;
			}
			
			// 转换时间字符串如19990101080808为1999-01-01 08:08:08格式
			public static function formatTimeString(str:String):String {
				if (null != str && str.length == 14)
					return str.substr(0, 4) + "-" + str.substr(4, 2) + "-" + str.substr(6, 2) + " " 
						+ str.substr(8, 2) + ":" + str.substr(10, 2) + ":" + str.substr(12, 2);
				else
					return str;
			}
			public static function formatDate(date:Date, dateFormat:String):String {
				var format:DateFormatter = new DateFormatter();
				format.formatString = dateFormat;
				var dateStr:String = format.format(date);
				return dateStr;
			}
			
			//LableFunction获取用户类型名称
			public static function formatDate2String4LabelFunction(item:Object,column:DataGridColumn):String{
				return	formatDate(item.datecreated, 'YYYY-MM-DD');
			}
			
			public static function formatDate2SubOneDay(date:Date):String{
				
				var format:DateFormatter = new DateFormatter();
				format.formatString = "YYYY-MM-DD";
				var dateStr:String = format.format(date);
				return dateStr;
			}
			
			/** 年 月 日 计算
			 * datepart值:"fullyear":"month":"date":"hours":"minutes":"seconds":"milliseconds":
			 * ("fullYear", 2)两年后
			 * ("fullYear", -2)两年前
			 * ("month", 11)11个月后的日期
			 * ("month", 11)11个月前的日期
			 * ("date", 4)4天后的日期
			 * ("date", -4)4天前的日期 * 
			 * */
			public static  function dateAdd(datepart:String = "", number:Number = 0, date:Date = null):Date {
				if (date == null) {
					/* Default to current date. */
					date = new Date();
				}
				
				var returnDate:Date = new Date(date.time);;
				
				switch (datepart.toLowerCase()) {
					case "fullyear":
					case "month":
					case "date":
					case "hours":
					case "minutes":
					case "seconds":
					case "milliseconds":
						returnDate[datepart] += number;
						break;
					default:
						/* Unknown date part, do nothing. */
						break;
				}
				return returnDate;
			}
			
			
		}	
}