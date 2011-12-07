<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head><title>温岭中学加班登记表</title>

<script language='javascript' type='text/javascript'>

</script>

<!--****** 隐藏打印按钮的代码并打印*******-->
<script>
  function beforePrint(){
  var btn = document.getElementById("mySpan");
  btn.style.display = "none";
  }
</script>
<!--****** /隐藏打印按钮的代码并打印*******-->

</head>

 
<body>
	<div style="text-align:center;">	
       <h2> 温岭中学加班登记表
       </h2><br />
       
      
    </div>   
     <div style="width:90%;text-align:right;">
	     <span id="mySpan">
	    	 <input id="btnPrint" type="button" value="打印" onClick="javascript:beforePrint();window.print();" />
	     </span>
    </div>
    <div style="width:90%;text-align:right;">
    	编号：【${owForm.applyNo}】   
    </div>
     
     
    

<table width="80%" height="250" border="1" align="center"  style="text-align:center" cellpadding="1" cellspacing="0">
  <tr>
    <td width="20%" height="26">姓名</td>
    <td width="30%">${owForm.teacherId}</td>
    <td width="15%">时间</td>
    <td width="35%">${owForm.beginDate}</td>
  </tr>
  <tr>
    <td height="40">事由</td>
    <td colspan="3">${owForm.reason}</td>  
  </tr>
 
  <tr>
    <td height="40">处室负责人</td>
    <td colspan="3"><table width="100%" >
      <tr>
        <td>${owForm.officeChiefApproveOption}</td>
      </tr>
      <tr>
        <td align="right"  > 
        	<div style="text-align: left; padding-left: 250px;">
        		(${owForm.officeChiefStatus==null?"暂无" :(owForm.officeChiefStatus==1?"通过":"未通过")}) 
        	</div>
	         <div style="text-align:left; padding-left:250px; ">
	        	签名:${owForm.officeChiefApproverId} 
	        </div>
	         <div style="text-align:left; padding-left:250px; ">
	        	日期：${fn:substring(owForm.officeChiefApproveTime,0,10)}
	        </div>
        </td>
      </tr>
    
    </table></td>
</tr>
  
</table>
<table width="80%"  border="0" align="center" cellpadding="1"  cellspacing="0">
    <tr >
        <td>
        
          <h3 style="line-height:25px;"> 说明：<br />
因个人工作和特殊情况需加班的，由各处室做好登记工作。每月汇总后交督导科。
</h3>
        </td>
    
    </tr>

</table>
	
       
</body>
</html> 