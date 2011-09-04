<%@ page contentType="text/html;charset=UTF-8"%>

<%  
	String path = request.getContextPath();  
	String basePath = request.getScheme()+"://"+request.getServerName()+
		(request.getServerPort() == 80 ? "" : (":"+request.getServerPort())) +path+"/";  
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head><title></title>
<script type="text/javascript">
	var base_path = "<%=basePath%>";
</script>

<base href="<%=basePath%>">
<script language='javascript' type='text/javascript'>
	var secs =5; //倒计时的秒数
	var URL ;
	function load(url){
		URL =url;
		for(var i=secs;i>=0;i--)
		{
			window.setTimeout('doUpdate(' + i + ')', (secs-i) * 1000);
		}
	}
	function doUpdate(num){
		document.getElementById('showDiv').innerHTML = '将在'+num+'秒后自动跳转到指定页面' ;
		if(num == 0) { window.location=URL; }
	}
</script>
</head>
<body>
<div>长时间未操作，用户认证过期。请重新登录</div>
<div id="showDiv"></div>
<script language="javascript">
	load('login.html');
</script>
</body>
</html> 