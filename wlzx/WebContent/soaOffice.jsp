<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*,java.util.*" errorPage="" %>
<%request.setCharacterEncoding("gb2312");%>
<%@page pageEncoding="GB2312"%>
<%
//此处代码演示动态获取 BaseUrl，ServerIP 的方法， 不是SOAOFFICE 控件的必需代码。
//BaseUrl：SOAOffice.ocx控件的文件路径
//ServerIP：用来给控件的 Server属性赋值
String ServerIP = request.getServerName();

String sPageName = "soaOffice.jsp";
String sHost =  request.getHeader("Host");
String sRAdd = request.getRequestURI(); 
	sRAdd = sRAdd.substring(0,sRAdd.length()-sPageName.length());
String BaseUrl = "Http://" + sHost + sRAdd;
%>
<%
//此处代码获取 要打开文件的fileN,fileSubject， 不是SOAOFFICE 控件的必需代码。
String userN = request.getParameter("user");
String sID = request.getParameter("ID");
String fileN = "redhead01.doc";
//此处代码演示改变控件颜色及样式， 不是SOAOFFICE 控件的必需代码。
Random r = new Random();
int i = r.nextInt(6) ;
// 释放数据库连接对象
//51448黄色  5292104绿色 1083135桔红色
String  menubarColor= "";
int j = r.nextInt(3);
if (j == 0)   menubarColor = "51448";
if (j == 1)   menubarColor = "5292104";
if (j == 2)   menubarColor = "1083135";
  
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<TITLE>SOAOffice网络文档控件 在线演示</TITLE>
		<META http-equiv="Content-Type" content="text/html; charset=gb2312">
		<SCRIPT LANGUAGE="javascript"  type="text/javascript" src="control.js"></SCRIPT>
	<script language="javascript">
		var BaseUrl = "<%=BaseUrl%>";
	</script>
		<META content="MSHTML 6.00.2800.1498" name="GENERATOR">
	</HEAD>
	<!-- body 标签中对soaOpen()和soaClose()的调用是SOAOFFICE的必需代码-->
	<BODY bgColor="#ffffff" leftMargin="0" topMargin="0" onload="soaOpen();window.focus();"
		onunload="soaClose();">
	<script language="javascript">
		var bDocOpen = false;// 必需代码，标识当前文档是否打开，在control.js中多次被引用。
		
		function soaOpen() 
		{ 
			try {
				formData.SOAOfficeCtrl.UserMenuCaption = "自定义菜单(&N)";
				formData.SOAOfficeCtrl.AppendMenuItem(1, "显示痕迹(&S)");
				formData.SOAOfficeCtrl.AppendMenuItem(2, "隐藏痕迹(&H)");
				formData.SOAOfficeCtrl.AppendMenuItem(3, "接受所有修订(&A)");
				formData.SOAOfficeCtrl.AppendMenuItem(4, "-");
				formData.SOAOfficeCtrl.AppendMenuItem(5, "显示标题(&T)");
				formData.SOAOfficeCtrl.AppendMenuItem(6, "-");
				formData.SOAOfficeCtrl.AppendMenuItem(7, "领导圈阅签字(&D)");
				formData.SOAOfficeCtrl.AppendMenuItem(8, "插入印章(&I)");	
				formData.SOAOfficeCtrl.AppendMenuItem(9, "分层显示手写批注(&G)");			
				formData.SOAOfficeCtrl.AppendMenuItem(10, "-");
				formData.SOAOfficeCtrl.AppendMenuItem(11, "数字签名");
				formData.SOAOfficeCtrl.AppendMenuItem(12, "验证数字签名");
								
				formData.SOAOfficeCtrl.SaveDocURL ="../SaveDoc.jsp";// 必需代码
				formData.SOAOfficeCtrl.SaveHtmlURL = "../SaveHtml.jsp";		
				formData.SOAOfficeCtrl.WebOpen( "<%= fileN %>",1,"<%= userN %>");// 必需代码
				// WebOpen采用线程技术，执行时会立即返回，在WebOpen下应立即执行 return true; ，请不要再插入其他语句。
				// 如果想执行什么操作，可以把代码放在下面的OnDocumentOpened事件里执行。						
				return true; 
			} 
			catch (e) 
			{ 
				var ErrorMsg = '未定义的意外错误。';
				alert(e.description);
				WEBWORD_OBJECT.innerHTML="<div align=center><b><font color=red>文档加载失败，错误信息："+e.description+"</font></b></div>"; 
				return false; 
			} 
		} 
		function soaClose() 
		{ 
			try {
				if (bDocOpen)
					formData.SOAOfficeCtrl.Close();
				return true; 
			} 
			catch (e) 
			{ 
				alert("关闭文档失败!\n错误信息："+e.message); 
				return false; 
			} 
		} 	 
		//文档另存为Html，并发布到web服务器
		function SaveAsHtml()
		{
			try {
				
				formData.SOAOfficeCtrl.WebSaveAsHtml();
				window.open("htmlDoc.jsp?ID=<%=request.getParameter("ID")%>");				
			} 
			catch (e) 
			{
			   alert("保存为Html失败！\n错误信息:" + e.message);			        
			}
		}				
		</script>
		<SCRIPT language="JavaScript" event="OnDocumentOpened(str, obj)" for="SOAOfficeCtrl">
			bDocOpen = true;
		</SCRIPT>
		<SCRIPT language="JavaScript" event="OnDocumentClosed()" for="SOAOfficeCtrl">
			bDocOpen = false;
		</SCRIPT>
		<SCRIPT language="JavaScript" event="OnUserMenuClick(index, caption)" for="SOAOfficeCtrl">
			if(index == 1) soaShowTrack(true);
			if(index == 2) soaShowTrack(false);
			if(index == 3) AcceptAllRevisions();
			if(index == 5) alert("该菜单的标题是："+caption);
			if(index == 7) soaStartHandDraw();
			if(index == 8) soaInsertSeal();
			if(index == 9) soaShowHandDrawDispBar();
			if(index == 11) soaAddDigitalSignature();
			if(index == 12) soaValidateDigitalSignatures();
			</SCRIPT>		
		<form name="formData" method="post" action="UploadDoc.jsp?Type=word&ID=<%=request.getParameter("ID")%>" id="formData">
			<TABLE>
				<TBODY>
					<TR vAlign="top">
						<TD style="OVERFLOW-X: hidden" width="144" height="100%">
							<DIV  id="mnpMenuTop" style="OVERFLOW-X: hidden; WIDTH: 144px">
								<DIV class="mnpMenuRow" >
								部分功能列表 </DIV>
								<DIV class="menuItem" >
										<A href="javascript:soaDisplayError();"><font color="#FF0000"><u>保存错误调试信息</u></font></A></DIV>
								<DIV class="menuItem" >
										<A href="javascript:soaShowTrack(true);">显示痕迹</A></DIV>
								<DIV class="menuItem" >
										<A href="javascript:soaShowTrack(false);">隐藏痕迹</A></DIV>
								<DIV class="menuItem" >
										<A href="javascript:AcceptAllRevisions();">接受所有修订</A></DIV>
								<DIV class="menuItem" >
										<A href="javascript:GetAllRevisions();">列举所有痕迹内容</A></DIV>
								<DIV class=mnpMenuBorder style="WIDTH: 141px"></DIV>
								<DIV class="menuItem" >
										<A href="javascript:soaStartHandDraw();">领导圈阅签字</A></DIV>
								<DIV class="menuItem" >
										<A href="javascript:soaInsertSeal();">插入印章</A></DIV>
								<DIV class="menuItem" >
										<A href="javascript:soaInsertLocalSeal();">插入本地印章</A></DIV>
								<DIV class="menuItem" >
										<A href="javascript:soaInsertSignature();">插入手写签名</A></DIV>
								<DIV class="menuItem" >
										<A href="javascript:soaValidateSeal();">验证印章/签名</A></DIV>
								<DIV class="menuItem" >
										<A href="javascript:soaCanCopy(false);">禁止复制/拷贝</A></DIV>
								<DIV class="menuItem" >
										<A href="javascript:soaCanCopy(true);">允许复制/拷贝</A></DIV>
								<DIV class=mnpMenuBorder style="WIDTH: 141px"></DIV>
								<DIV class="menuItem" >
										<A href="javascript:InsertWebImage();">插入Web图片</A></DIV>
								<DIV class="menuItem" >
										<A href="javascript:OpenImageDialog();">插入本地图片</A></DIV>
								<DIV class="menuItem" >
										<A href="javascript:soaSave();">直接保存文档</A></DIV>
								<DIV class="menuItem" >
										<A href="javascript:soaSubmitSave();">提交页面保存文档</A></DIV>
								<DIV class="menuItem" >
										<A href="javascript:SaveAsHtml();">另存Html到服务器</A></DIV>
								<DIV class=mnpMenuBorder style="WIDTH: 141px"></DIV>
								<DIV class="menuItem" >
										<A href="javascript:InsertVBATemplate();">VBA套红</A></DIV>
								<DIV class="menuItem" >
										<A href="javascript:ApplyFileTemplate();">模板套红</A></DIV>
								<DIV class="menuItem" >
										<A href="javascript:ToggleTitlebar();">切换标题栏</A></DIV>
								<DIV class="menuItem" >
										<A href="javascript:ToggleMenubar();">切换菜单栏</A></DIV>
								<DIV class="menuItem" >
										<A href="javascript:ToggleToolbars();">切换工具栏</A></DIV>
								<DIV class="menuItem" >
										<A href="javascript:DocPageSetup();">页面设置</A></DIV>
								<DIV class="menuItem" >
										<A href="javascript:EnablePrint(false);">禁止打印</A></DIV>
								<DIV class="menuItem" >
										<A href="javascript:EnablePrint(true);">允许打印</A></DIV>
								<DIV class="menuItem" >
										<A href="javascript:EnableSave(false);">禁止保存</A></DIV>
								<DIV class="menuItem" >
										<A href="javascript:EnableSave(true);">允许保存</A></DIV>
								<DIV class="menuItem" >
										<A href="javascript:EnableSaveAs(false);">禁止另存</A></DIV>
								<DIV class="menuItem" >
										<A href="javascript:EnableSaveAs(true);">允许另存</A></DIV>
								<DIV class="menuItem" >
										<A href="javascript:WordToText();">获取文档Txt正文</A></DIV>
								<DIV class="menuItem" >
										<A href="javascript:DisableDragAndDrop();">禁止/允许WORD拖曳</A></DIV>
								<DIV class="mnpMenuBorder" style="MARGIN-BOTTOM: 0px; WIDTH: 143px"></DIV>
							</DIV>
						</TD>
						<TD width="100%">
											<OBJECT id="SOAOfficeCtrl" codeBase="<%=BaseUrl%>SOAOffice.ocx#version=4,1,1,0" height="100%"
												width="100%" classid="clsid:BBD098CA-63C3-4105-B7AF-5FF3E2649082" data="">
											<param name="ServerPort" value="4357"><param name="Caption" value="您可以修改这里的文字，正式版本的控件不会出现科翰软件的关于对话框">
											<param name="Server" value="<%=ServerIP%>">
											<param name="BorderStyle" value="0">
											<param name="TitleBarColor" value="16777215">
											<param name="TitlebarTextColor" value="0">
											<param name="MenubarColor" value=<%=menubarColor%>>
											<param name="MenubarStyle" value=<%=i%>>
												<SPAN STYLE="color:red">未能载入SOAOffice网络文档控件。请在安装控件的提示对话框里确认安装，才能使用本控件的功能。</SPAN>
											</OBJECT>
						</TD>
					</TR>
				</TBODY>
			</TABLE>			

</form>
	</BODY>
</HTML>
