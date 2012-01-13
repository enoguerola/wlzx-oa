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
<title>温岭中学数字化校园</title>
</head>
<body>
<div class="center" id="container">
	<div id="top">
		<img alt="数字化校园" src="resources/common/layout/preloader.png">
	</div>
	<div id="sidebar">
		<div id="ims">
			<div class="myPanelTitle2">信息系统</div>
			<ul id="boxes">
				<li><a href="login.html" target="_blank">协同办公系统</a></li>
			</ul>
			
		</div>
		<div id="links">
			<div class="myPanelTitle2">友情链接</div>

				
		</div>
	</div>
	<div id="maincolumn">
		 <div>
		 	<div class="myPanelTitle"><a target="_self" class="title_hover" title="通知公告" href="noticeList.action">通知公告</a></div>
		 	<div class="myPanelTitleLine"></div>
		 	<div class="myPanelContent">
		 		<ul class="append">
		 			<c:forEach items="${notices}" var="notice">       
						<li>
			    			<a target="_blank" title="${notice.title}[${fn:substring(notice.postTime,0,16)}][${notice.postDepartmentName}]" href="noticeDetail.action?id=${notice.id}">
			    				<c:set var="oneNotice" value="${notice.title}[${fn:substring(notice.postTime,0,16)}][${notice.postDepartmentName}]" scope="request"/>
			    				${fn:substring(oneNotice,0,67)}
			    			</a>
			    		</li>
					</c:forEach>
			    	
			    </ul>
		 	</div>
		 </div>
		  
		  <div>
		 	<div class="myPanelTitle"><a target="_self" class="title_hover" title="校园新闻" href="#">校园新闻</a></div>
		 	<div class="myPanelTitleLine"></div>
		 	<div class="myPanelContent">
		 	
		 	</div>
		 </div>
		 <div>
		 	<div class="myPanelTitle"><a target="_self" class="title_hover" title="学校日程" href="scheduleList.action">今日日程</a></div>
		 	<div class="myPanelTitleLine"></div>
		 	<div>
		 		<ul class="append">
		 			<c:forEach items="${schedules}" var="schedule">       
						<li>
			    			<span title="主题：${schedule.title}
			    			内容：${schedule.content}">
			    			
			    			<c:set var="oneSchedule" value="${schedule.title}[${fn:substring(schedule.beginTime,0,16)}--${fn:substring(schedule.endTime,0,16)}][${schedule.departmentName}]" scope="request"/>
			    				${oneSchedule}
			    			</span>
			    		</li>
					</c:forEach>
			    	
			    </ul>
		 	
		 	</div>
		 </div>
	</div>
	<div class="myPanelTitleLine"></div>
	<div class="bottom">浙江省温岭中学  CopyRight：2011-2012           杭州池墨科技有限公司</div>
</div>
</body>
</html> 