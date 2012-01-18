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
<title>温岭中学通知公告</title>
</head>
<body>
<div class="center" id="container">
	<div id="top">
		<img alt="数字化校园" src="resources/common/layout/preloader.png">
	</div>
<!-- 	<div class="myPanelTitleLine"></div> -->
	<div id="page">
			<div style="width:100%;padding:20px;">
				<h2 style="margin:0;padding:0;width:100%;"><span style="color:red;font-weight:bold;" id="lbTitle">${notice.title}</span>
				部门：<span>${notice.postDepartmentName}</span>&nbsp;&nbsp;发布时间：<span>${notice.postTime}</span></h2>
			</div>
			<div style="width:100%;font-size:16px;;padding:20px; ">
				${notice.content}
          	</div>
			<div style="width:100%;margin-bottom:20px;;padding:20px;">
				<img src="resources/front/attachment.jpg">附件区
					<c:forEach items="${notice.attachments}" var="attachment">       
						<div style="color:#A02A00;font-size:14px;height:30px;margin-top:10px;margin-left:40px;">
							<a href="uploads/oa/attachment/${attachment.path}" target="_blank"> ${attachment.name}</a>
						</div>	    
					</c:forEach>
				
			</div>
	</div>
<!-- 	<div class="myPanelTitleLine"></div> -->
	<div class="bottom">浙江省温岭中学  CopyRight：2011-2012           杭州池墨科技有限公司</div>
</div>
</body>
</html> 