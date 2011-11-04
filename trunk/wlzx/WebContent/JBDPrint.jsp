<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head><title>温岭中学教职工加班单打印</title>

<script language='javascript' type='text/javascript'>

</script>
</head>


<body>
	<div style="text-align:center;">	
       <h2> 温岭中学教职工加班单
       </h2><br />
       
      
    </div>   
     <div style="width:90%;text-align:right;">
     <input id="btnPrint" type="button" value="打印" onclick="javascript:window.print();" />
    </div>
    <div style="width:90%;text-align:right;">
    	 ${owForm.applyNo}   
    </div>
    
    
    

<table width="80%" height="600" border="1" align="center" cellpadding="1" cellspacing="0">
  <tr>
    <td width="20%" height="26">姓名</td>
    <td width="15%">${owForm.teacherId}</td>
    <td width="15%">加班单时间</td>
    <td width="50%">${owForm.beginDate}</td>
  </tr>
  <tr>
    <td height="49">加班单事由</td>
    <td colspan="3">${owForm.reason}</td>  
  </tr>
 
  <tr>
    <td height="84">处室负责人意见</td>
    <td colspan="3"><table width="100%" >
      <tr>
        <td>${owForm.officeChiefApproveOption}</td>
      </tr>
      <tr>
        <td align="right"> (${owForm.officeChiefStatus==null?"暂无" :(owForm.officeChiefStatus==1?"通过":"未通过")}) 
        <div style="text-align:right;">
        	签名:${owForm.officeChiefApproverId} 日期：${fn:substring(owForm.officeChiefApproveTime,0,10)}
        </div>
        </td>
      </tr>
    </table></td>
</tr>
  
</table>
</body>
</html> 