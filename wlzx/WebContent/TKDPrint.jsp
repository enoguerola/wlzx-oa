<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head><title>温岭中学调课申请单打印</title>

<script language='javascript' type='text/javascript'>

</script>
</head>



<body>

	<div style="text-align:center;">	
       <h2> 温岭中学调课申请单 [编号：${apply.applyNo}]
       </h2><br />
       
      
    </div>   
     <div style="width:90%;text-align:right;">
     <input id="btnPrint" type="button" value="打印" onclick="javascript:window.print();" />
    </div>

   <table  width="80%" border="1px" align="center"  cellpadding="1" cellspacing="0">
   <tr><td>
<table width="100%" border="0" align="center">
  <tr>
    <td width="15%">申请类型</td>
    <td width="20%">${apply.applyType==0?"调课":"代课"}</td>
    <td width="15%">申请人</td>
    <td width="20%">${apply.applyTeacherId}</td>
    <td width="15%">审批状态</td>
    <td width="25%">${apply.applyStatus==0?"待审批":(apply.applyStatus==1?"审批通过":(apply.applyStatus==2?"审批未通过":"取消"))}</td>
  </tr>
  <tr>
    <td>申请事由</td>
    <td colspan="5">${apply.applyReason}</td>
  </tr>
  <tr>
    <td colspan="6"><table width="80%" border="1" align="center" cellpadding="1" cellspacing="0">
      <tr>
        <td align="center" width="10%">调课班级</td>
        <td align="center" width="10%">调课课程</td>
        <td align="center" width="20%">原上课时间</td>
        <td align="center" width="20%">意向时间</td>
        <td align="center" width="10%">意向教师</td>
        <td align="center" width="10%">指派教师</td>
        <td align="center" width="20%">补课时间</td>
      </tr>
      <c:forEach items="${apply.applyItems}" var="item" >
      <tr>
      	<td>${item.applyClass}</td>
        <td>${item.applyCourse}</td>
        <td>${fn:substring(item.applyCourseDate,0,10)}</td>
        <td>${fn:substring(item.adjustMeanDate,0,10)}</td>
        <td>${item.adjustMeanTeacherId}</td>
        <td>${item.adjustActualTeacherId==null?"--":item.adjustActualTeacherId}</td>
      	<td>${fn:substring(item.adjustActualDate==null?"--":item.adjustActualDate,0,10)}</td>
      </tr>
      </c:forEach>
    </table></td>
  </tr>
  <tr>
    <td colspan="6">审批批注     ${apply.approveRemark==null?"--":apply.approveRemark}</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td colspan="2">审批意见     ${(apply.applyStatus==0||apply.applyStatus==3)?"--":(apply.applyStatus==1?"审批通过":"审批未通过")}
    </td>
    <td colspan="2">审批人  ${item.ApproveTeacherId==null?"--":item.ApproveTeacherId}</td>
  </tr>
  <tr>
    <td colspan="6" align="right">审批时间    ${fn:substring(item.approveDate==null?"--":item.approveDate,0,10)}</td>
  </tr>
</table>
</td>
</tr></table>
</body>
</html> 