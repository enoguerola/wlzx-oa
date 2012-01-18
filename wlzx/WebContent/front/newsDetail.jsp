<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt'%>
<!DOCTYPE html>

<link rel="stylesheet" href="front/index.less" type="text/less" media="screen" />
<script src="front/js/less-1.1.3.min.js" type="text/javascript"></script>
<!--[if lt IE 9]><script type="text/javascript" src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
<html>
<head>
<title>温岭中学校园动态</title>
</head>
<body>
<div class="center" id="container">
	<div id="top">
		<img alt="数字化校园" src="resources/common/layout/preloader.png">
	</div>
<!-- 	<div class="myPanelTitleLine"></div> -->
	<div id="page" >
			<div style="width:100%;padding:20px;">
				<h2 style="margin:0;padding:0;width:100%;text-align:center;"><span style="color:red;font-weight:bold;width:100%;" id="lbTitle">${news.title}</span></h2>
				<h3 style="margin:0;padding:0;width:100%;text-align:center;padding-top:10px;">作者：<span>${news.author}</span>&nbsp;&nbsp;发布时间：<span>${news.postTime}</span></h3>
			</div>
			<div style="font-size:14px;padding:10px;width:100%;">
				${news.content}
          	</div>
			
	</div>
<!-- 	<div class="myPanelTitleLine"></div> -->
	<div class="bottom">浙江省温岭中学  CopyRight：2011-2012           杭州池墨科技有限公司</div>
</div>
</body>
</html> 