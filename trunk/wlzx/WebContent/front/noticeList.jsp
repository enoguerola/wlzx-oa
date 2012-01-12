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
<script>
	function tab_switch_page(page){
		
		document.getElementById("startIndex").value=(page-1)*15;
		document.forms[0].submit(); 
	}

</script>
<body>
<div class="center" id="container">
	<div id="top">
		<img alt="数字化校园" src="resources/common/layout/preloader.png">
	</div>
	<div id="page">
    	<div id="left">
    		<div class="search">
    		<form method="post" action="noticeList.action">
					<ul>
						<li style="margin:10px;">
							<label>公告优先级</label>
							<select style="width:120px;margin-top:5px;" id="emergence" name="emergence">
								<option value="">全部</option>
								<option value="1">--紧急--</option>
								<option value="0">--普通--</option>
							
							</select>
						</li>
						<li style="margin:10px;">
							<label>公告类型</label>
							<select style="width:120px;margin-top:5px;" id="type" name="type">
								<option value="">全部</option>
								<c:if test="${noticeTypes!=null}">
									<c:forEach items="${noticeTypes}" var="noticeType">
										<option value="${noticeType.value}">${noticeType.name}</option>
									</c:forEach>
								</c:if>    
								<option value="其他">其他</option>
							
							</select>
						</li>
						<li style="margin:10px;">
							<label>发布部门</label>
							<select style="width:120px;margin-top:5px;" id="departmentIds" id="departmentIds">
								<option value="">全部</option>
								<c:if test="${departments!=null}">
									<c:forEach items="${departments}" var="department">
										<option value="${department.id}">${department.name}</option>
									</c:forEach>
								</c:if>    
							</select>
						</li>
<!-- 						<li style="margin:10px;"> -->
<!-- 							<label>发布时间</label> -->
							
<!-- 						</li> -->
						<li style="margin:10px;">
							<label>关 键 字：</label>
							<input type="text" style="width:120px;margin-top:5px;" id="title" name="title">
						</li>
					</ul>
					<input type="hidden" value="0" id="startIndex" name="startIndex"/>
					<input type="submit"  value="查找" style="margin-left:120px;"/>	
				</form>
			</div>
		</div>	
		<div id="right">
			<div class="rightTitle">
				您现在的位置>>通知公告
				
			</div>
			<div>
				<c:if test="${noticePages!=null}">
					<ul class="append">
						<c:forEach items="${noticePages.items}" var="notice">       
							<li>
				    			<a target="_blank" title="${notice.title}[${fn:substring(notice.postTime,0,16)}][${notice.postDepartmentName}]" href="noticeDetail.action?id=${notice.id}">
				    				<c:set var="oneNotice" value="${notice.title}[${fn:substring(notice.postTime,0,16)}][${notice.postDepartmentName}]" scope="request"/>
				    				${fn:substring(oneNotice,0,67)}
				    			</a>
				    		</li>
						</c:forEach>
					</ul>
					<c:set var='total' value="${noticePages.totalPage}" scope="request"/>
					<c:set var='currentPage' value="${noticePages.currentPage}" scope="request"/>
					<div class="pagination" style="padding-left:350px;padding-top:10px;">
						<div class="pageopr">
							<a href="javascript:tab_switch_page(1);" title="首页"><img align="absmiddle" src="resources/front/page_home.jpg"></a>
							<a href="javascript:tab_switch_page(<c:out value='${currentPage - 1 eq 0 ? 1 : currentPage - 1}' />);" title="上一页"><img align="absmiddle" src="resources/front/page_pre.jpg"></a>
							<a href="javascript:tab_switch_page(<c:out value='${currentPage + 1 gt total ? total : currentPage + 1}' />);" title="下一页"><img align="absmiddle" src="resources/front/page_next.jpg"></a>
							<a href="javascript:tab_switch_page(${total});" title="尾页"><img align="absmiddle" src="resources/front/page_last.jpg"></a>
							<a class="top" href="noticeList.action#top"><img align="absmiddle" src="resources/front/page_top.jpg"></a>
							<span>数据：${noticePages.totalCount}条</span>
							<span>第${currentPage}/<label id='totalPage'>${total}</label>页</span>
<!-- 							<span><a href="javascript:tab_switch_page();"><img align="absmiddle" src="resources/front/page_redirect.jpg"></a></span> -->
						</div>
						
					</div>
				</c:if>	
				<c:if test="${noticePages==null}">
					当前不存在数据
				</c:if>
			</div>
		</div>
		
	</div>
<!-- 	<div class="myPanelTitleLine"></div> -->
	<div class="bottom">浙江省温岭中学  CopyRight：2011-2012           杭州池墨科技有限公司</div>
</div>
</body>
</html> 