<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt'%>
<!DOCTYPE html>

<link rel="stylesheet" href="front/index.less" type="text/less" media="screen" />
<script src="front/js/less-1.1.3.min.js" type="text/javascript"></script>
<!--[if lt IE 9]><script type="text/javascript" src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->


<link rel='stylesheet' type='text/css' href='front/fullcalendar/fullcalendar.css' />
<link rel='stylesheet' type='text/css' href='front/fullcalendar/fullcalendar.print.css' media='print' />
<script type='text/javascript' src='front/jquery/jquery-1.5.2.min.js'></script>
<script type='text/javascript' src='front/jquery/jquery-ui-1.8.11.custom.min.js'></script>
<script type='text/javascript' src='front/fullcalendar/fullcalendar.min.js'></script>
<script type='text/javascript'>

	$(document).ready(function() {
		var last=JSON.stringify(${data}); //将JSON对象转化为JSON字符

// 		alert(last);
		var date = new Date();
		var d = date.getDate();
		var m = date.getMonth();
		var y = date.getFullYear();
		
		$('#calendar').fullCalendar({
			defaultView:"month", // year, month, date: 整数, 初始化加载时的日期，默认是month
			height: 900, // 日历高度,包括表头 contentHeight: 600 内容高度，不包括表头
			editable: false, // 默认值false, 用来设置日历中的日程是否可以编辑
			draggable: false, // 是否可拖动
			weekends: true, // 默认为true, 标识是否显示周六和周日的列
			slotMinutes:30, // 整型, 默认值30, 表示在agenda的views中, 两个时间之间的间隔
			disableDragging:true, // Boolean类型, 默认false, 所有的event可以拖动, 必须editable = true
			diableResizing:false, // Boolean, 默认false, 所有的event可以改变大小, 必须editable = true
			dragRevertDuration:500, // 拖动恢复的时间, 默认500毫秒, 表示一个不成功的拖动之后, 控件回复到原始位置的时间.
			dragOpacity:.5, // Float类型, 表示拖动时候的不透明度.
			monthNames:['一月','二月', '三月', '四月', '五月', '六月', '七月','八月', '九月', '十月', '十一月', '十二月'], //默认为英文月分，这里可以改成中文
			dayNames:['星期日', '星期一', '星期二', '星期三','星期四', '星期五', '星期六'], //换成中文星期
			header:{
			left: 'month,agendaWeek,agendaDay', //左边显示的按钮 (month,basicWeek无时间格式,basicDay无时间格式,agendaWeek,agendaDay)
			center: 'title', //中间显示标题
			right: 'prevYear,prev,today,next,nextYear' //右边显示的按钮
			},
			buttonText:{ //按钮对应的文本
			prevYear: '去年', //不建议改这个值，因为它本身是含[去年、上一周、前天]三个意思，你就让它默认
			nextYear: '明年', //同上
			today: '今天',
			month: '月',
			week: '周',
			day: '日'
			},
			dayNamesShort:['周日', '周一', '周二', '周三','周四', '周五', '周六'], //短格式的星期
			titleFormat:{ //格式化标题
			month: 'MMMM yyyy', // 如：September 2009
			week: "MMM d[yyyy]{'—'[ MMM] d yyyy}", // 如：Sep 7 - 13 2009
			day: 'dddd, MMM d, yyyy' // 如：Tuesday, Sep 8, 2009
			},
			weekMode:'fixed', //固定显示6周高
			editable: false,
			events:JSON.parse(last)
		});
		
	});

</script>


<html>
<head>
<title>温岭中学校园日程</title>
</head>
<script>
	function tab_switch_page(page){
		
		document.getElementById("startIndex").value=(page-1)*15;
		document.forms[0].submit(); 
	}

</script>
<body style="overflow-x:hidden;">

<div class="center" id="container">
	<div id="top">
		<img alt="数字化校园" src="resources/common/layout/preloader.png">
	</div>
	<div id="page">
	
			<div class="rightTitle">
				您现在的位置>>校园日程
				
			</div>
			
			<div id='calendar'  style="padding-left:20px; padding-right:20px;padding-bottom:20px;">
			
			</div>
		
		
	</div>
<!-- 	<div class="myPanelTitleLine"></div> -->
	<div class="bottom">浙江省温岭中学  CopyRight：2011-2012           杭州池墨科技有限公司</div>
</div>
</body>
</html> 