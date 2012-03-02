<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt'%>
<!DOCTYPE html>
<%  
	String path = request.getContextPath();  
	String base = request.getScheme()+"://"+request.getServerName()+
	(request.getServerPort() == 80 ? "" : (":"+request.getServerPort()))+"/";  
	String basePath = request.getScheme()+"://"+request.getServerName()+
		(request.getServerPort() == 80 ? "" : (":"+request.getServerPort())) +path+"/";  

%>
<link rel="stylesheet" href="front/index.less" type="text/less" media="screen" />
<script src="front/js/less-1.1.3.min.js" type="text/javascript"></script>
<!--[if lt IE 9]><script type="text/javascript" src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
<script type='text/javascript' src='front/jquery/jquery-1.5.2.min.js'></script>
<script type='text/javascript'>
	$(document).ready(function() {
		$.ajax({


			url: "newsJSON.action",
			dataType: "json",//返回json格式的数据
			beforeSend: function(XMLHttpRequest){
				$("#ajaxResult").html("<img src='resources/front/loading.gif'/>");
			//ShowLoading();
			},
			success: function(data, textStatus){
				var last=JSON.stringify(data); 
				//alert(prodStr);
				var json=JSON.parse(last);
				var str="";
				$("#ajaxResult").html("aaa");
				 for(var i=0; i<data.length&&i<5; i++)
				  {
					 str+="<li><a target='_blank' title='"+data[i].title+data[i].postTime+"' href='newsDetail.action?id="+data[i].id+"'>"+data[i].title+data[i].postTime+"</a></li>";
					
				  }
// 				alert(str);
				$("#ajaxResult").html(str);

			},

			complete: function(XMLHttpRequest, textStatus){
// 				$("#ajaxResult").html("");

			//HideLoading();
			},
			error: function(){
				$("#ajaxResult").html("新闻来源温岭门户数据读取异常，请检查网络或门户所在服务器");
			//请求出错处理
			}
		});
		
		
	});
	
</script>
<style>
	#boxes li{
		padding:0;
		margin:0;
		vertical-align:middle;
		height:50px; 
		//text-align:left;
	}
	#boxes li a{
		padding:0;
		margin:0;
		vertical-align:middle;
		line-height:50px; 
		font-size:20px;
		font-family: "楷体";
		//font-weight:bold;
		//color:black;
		width:100%;
		//float:none;
		//word-spacing: 2em;
	}
	
</style>
<html>
<head>
<title>温岭中学数字化校园</title>
</head>
<body style="overflow-x:hidden;">
<div class="center" id="container">
	<div id="top" style="padding-left:0;padding-right:0;margin-left:0;margin-right:0;">
		<img alt="数字化校园" src="resources/common/layout/preloader.png">
	</div>
	<div id="sidebar">
		<div id="ims">
			<div class="myPanelTitle2" style="font-weight:bold;">信息系统</div>
			<ul id="boxes" style="padding-left:0;list-style-type:none;padding-top:30px;">
				<li style="background: url('resources/oa/oa.png') no-repeat left center;padding:0;"><a href="login.html" target="_blank" style="letter-spacing: 5px;" >办公系统</a></li>
				<li style="padding:0;"><a href="<%=base %>wlzxCourseSelective/login.jsp" target="_blank" style="letter-spacing: 5px;">选课系统</a></li>
			
			</ul>
			
		</div>
		<div id="links">
			<div class="myPanelTitle2" style="font-weight:bold;">友情链接</div>

				
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
		 	<div class="myPanelTitle"><a target="_self" class="title_hover" title="校园动态" href="newsList.action">校园动态</a></div>
		 	<div class="myPanelTitleLine"></div>
		 	<div>
			 	<ul class="append" id="ajaxResult">
			 	
			 	</ul>
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