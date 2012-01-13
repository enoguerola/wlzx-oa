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
	window.location="index.action";
</script>
</head>
<body>
</body>
</html> 