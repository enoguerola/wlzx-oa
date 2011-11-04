<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head><title>温岭中学教职工请假单打印</title>

<script language='javascript' type='text/javascript'>

</script>
</head>


<body>
	<div style="text-align:center;">	
       <h2> 温岭中学教职工${tlForm.type==0?"请假":"出差"}单
       </h2><br />
       
      
    </div>   
     <div style="width:90%;text-align:right;">
     <input id="btnPrint" type="button" value="打印" onclick="javascript:window.print();" />
    </div>
    <div style="width:90%;text-align:right;">
    	 ${tlForm.applyNo}   
    </div>
    
    
    

<table width="80%" height="600" border="1" align="center" cellpadding="1" cellspacing="0">
  <tr>
    <td width="20%" height="26">姓名</td>
    <td width="15%">${tlForm.teacherId}</td>
    <td width="15%">${tlForm.type==0?"请假":"出差"}时间</td>
    <td width="50%">${tlForm.beginDate} — ${tlForm.endDate}</td>
  </tr>
  <tr>
    <td height="49">${tlForm.type==0?"请假":"出差"}事由</td>
    <td colspan="3">${tlForm.reason}</td>  
  </tr>
  <tr>
    <td align="left" rowspan="3" >${tlForm.type==0?"请假":"出差"}期间工作安排情况</td>
    <td colspan="3" height="30">教学工作: ${tlForm.arrangeTech}
    <div style="text-align:right;">
    (${tlForm.arrangeTechDealAlready==true?"已落实":"未落实"})
    </div>
    </td>
   
  </tr>
  <tr>
    <td  height="30" colspan="3">服务工作:${tlForm.arrangeService}
    <div style="text-align:right;">
     (${tlForm.arrangeServiceDealAlready==true?"已落实":"未落实"})
    </div>
    </td>
  </tr>
  <tr>
    <td height="36" colspan="3">管理工作:${tlForm.arrangeManage} 
    <div style="text-align:right;">
    (${tlForm.arrangeManageDealAlready==true?"已落实":"未落实"})
    </div>
    </td>
  </tr>
  <tr>
    <td height="84">处室负责人意见</td>
    <td colspan="3"><table width="100%" >
      <tr>
        <td>${tlForm.officeChiefApproveOption}</td>
      </tr>
      <tr>
        <td align="right"> (${tlForm.officeChiefStatus==null?"暂无" :(tlForm.officeChiefStatus==1?"通过":"未通过")}) 
        <div style="text-align:right;">
        	签名:${tlForm.officeChiefApproverId} 日期：${fn:substring(tlForm.officeChiefApproveTime,0,10)}
        </div>
        </td>
      </tr>
    </table></td>
  </tr>
   <tr>
    <td height="91">分管校长意见</td>
    <td colspan="3"><table width="100%" >
      <tr>
        <td>${tlForm.vicePrincipalApproveOption}</td>
      </tr>
      <tr>
        <td align="right"> (${tlForm.vicePrincipalStatus==null?"暂无" :(tlForm.vicePrincipalStatus==1?"通过":"未通过")})
        <div style="text-align:right;">
                      签名:${tlForm.vicePrincipalApproverId} 日期：${fn:substring(tlForm.vicePrincipalApproveTime,0,10)}
        </div>              
        </td>
      </tr>
    </table></td>
  </tr>
   <tr>
    <td height="97">校长意见</td>
    <td colspan="3"><table width="100%" >
     <tr>
        <td>${tlForm.principalApproveOption}</td>
      </tr>
      <tr>
        <td align="right"> (${tlForm.principalStatus==null?"暂无" :(tlForm.principalStatus==1?"通过":"未通过")})
        <div style="text-align:right;">
                      签名:${tlForm.principalApproverId} 日期：${fn:substring(tlForm.principalApproveTime,0,10)}
        </div>
        </td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="100">备注</td>
    <td colspan="3">${tlForm.remark==""||tlForm.remark==null?"无":tlForm.remark}</td>  
  </tr>
  
</table>
</body>
</html> 