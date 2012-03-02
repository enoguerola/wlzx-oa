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
<script>
	function tab_switch_page(page){
		//alert(page);
		document.getElementById("cpage").value=page;
		document.forms[0].submit(); 
	}

</script>
<body style="overflow-x:hidden;">
<div class="center" id="container">
	<div id="top">
		<img alt="数字化校园" src="resources/common/layout/preloader.png">
	</div>
	<div id="page">
    	<div id="left">
    		<div class="search">
    		<form method="post" action="newsList.action">
					<ul>
						<li style="margin:10px;">
							<label>关 键 字：</label>
							<input type="text" style="width:120px;margin-top:5px;" id="title" name="title">
						</li>
					</ul>
					<input type="hidden" value="1" id="cpage" name="cpage"/>
					<input type="submit"  value="查找" style="margin-left:120px;"/>	
				</form>
			</div>
		</div>	
		<div id="right">
			<div class="rightTitle">
				您现在的位置>>校园动态
				
			</div>
			<div>
				<c:if test="${newsPages!=null}">
					<ul class="append">
						<c:forEach items="${newsPages.items}" var="news">       
							<li>
				    			<a target="_blank" title="${news.title}[${fn:substring(news.postTime,0,16)}]" href="newsDetail.action?id=${news.id}">
				    				<c:set var="oneNews" value="${news.title}[${fn:substring(news.postTime,0,16)}]" scope="request"/>
				    				${fn:substring(oneNews,0,67)}
				    			</a>
				    		</li>
						</c:forEach>
					</ul>
					<c:set var='total' value="${newsPages.totalPage}" scope="request"/>
					<c:set var='currentPage' value="${newsPages.currentPage}" scope="request"/>
					<div class="pagination" style="padding-left:350px;padding-top:10px;">
						<div class="pageopr">
							<a href="javascript:tab_switch_page(1);" title="首页"><img align="absmiddle" src="resources/front/page_home.jpg"></a>
							<a href="javascript:tab_switch_page(<c:out value='${currentPage - 1 eq 0 ? 1 : currentPage - 1}' />);" title="上一页"><img align="absmiddle" src="resources/front/page_pre.jpg"></a>
							<a href="javascript:tab_switch_page(<c:out value='${currentPage + 1 gt total ? total : currentPage + 1}' />);" title="下一页"><img align="absmiddle" src="resources/front/page_next.jpg"></a>
							<a href="javascript:tab_switch_page(${total});" title="尾页"><img align="absmiddle" src="resources/front/page_last.jpg"></a>
							<a class="top" href="newsList.action#top"><img align="absmiddle" src="resources/front/page_top.jpg"></a>
							<span>数据：${newsPages.totalCount}条</span>
							<span>第${currentPage}/<label id='totalPage'>${total}</label>页</span>
<!-- 							<span><a href="javascript:tab_switch_page();"><img align="absmiddle" src="resources/front/page_redirect.jpg"></a></span> -->
						</div>
						
					</div>
				</c:if>	
				<c:if test="${newsPages==null}">
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