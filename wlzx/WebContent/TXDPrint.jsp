<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head><title>温岭中学调休登记表打印</title>

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
       <h2> 温岭中学调休登记表
       </h2><br />
       
      
    </div>   
     <div style="width:90%;text-align:right;">
      <span id="mySpan">
	    	 <input id="btnPrint" type="button" value="打印" onClick="javascript:beforePrint();window.print();" />
	     </span>
    </div>
    <div style="width:90%;text-align:right;">
    	 编号：【${mrForm.applyNo}】   
    </div> 
    
    
    

<table width="95%" height="250" border="1" align="center" style="text-align:center;" cellpadding="1" cellspacing="0">
  <tr>
    <td width="20%" height="26">姓名</td>
    <td width="15%">${mrForm.teacherId}</td>
    <td width="15%">时间</td>
    <td width="50%">${mrForm.time}</td>
  </tr>
 
  <tr>
    <td height="84">处室意见</td>
    <td colspan="3">
    <table width="100%" >
      <tr>
        <td>
      		<div style="text-align: left; padding-left: 50px; font-size:20">
        		${mrForm.officeChiefStatus==null?"" :(mrForm.officeChiefStatus==1?"同意":"不同意")}
        	</div>
        	<div style="text-align: left; padding-left: 50px; ">
        		${mrForm.officeChiefApproveOption}
        	</div>
        </td>
      </tr>
      <tr>
        <td align="right">
	         <div style="text-align:left; padding-left: 280px;">
	        	签名:${mrForm.officeChiefApproverId}
	       	</div>
	       	<div style="text-align:left; padding-left: 280px;" >
	       	 	日期：${fn:substring(mrForm.officeChiefApproveTime,0,10)}
	       	 	 </div>
	     </td>
	  </tr>
    </table>
    </td>
  </tr>
   <tr>
    <td height="91">分管校长意见</td>
    <td colspan="3">
    <table width="100%" >
      <tr>
        <td>
      		<div style="text-align: left; padding-left: 50px; font-size:20">
        		${mrForm.vicePrincipalStatus==null?"" :(mrForm.vicePrincipalStatus==1?"同意":"不同意")}
        	</div>
        	<div style="text-align: left; padding-left: 50px; ">
        		${mrForm.vicePrincipalApproveOption}
        	</div>
        </td>
      </tr>
      <tr>
        <td align="right"> 
	         <div style="text-align:left; padding-left: 280px;">
	                      签名:${mrForm.vicePrincipalApproverId} 
	        </div>          
	          <div style="text-align:left; padding-left: 280px;">
	        	  日期：${fn:substring(mrForm.vicePrincipalApproveTime,0,10)}
	          </div>    
        </td>
      </tr>
    </table>
    </td>
  </tr>
   
  
</table>
<table width="95%"  border="0" align="center" style="text-align:left;font-weight: bold;line-height: 25px;" cellpadding="1" cellspacing="0">
 <tr>
    	<td>
        说明：<br/>
1.	因个人工作和特殊情况需加班后要合理的安排工作及时调休。<br/>
2.	调休一天，经处室负责人批准；二天以上经分管校长批准。<br/>
3.	申请后将登记表交督导科。<br/>

        </td>
    </tr>
</table>
</body>
</html>