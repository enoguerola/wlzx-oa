<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head><title>温岭中学教职工${tlForm.type==0?"请假":"出差审批"}单打印</title>

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
       <h2> 温岭中学教职工${tlForm.type==0?"请假":"出差审批"}单
       </h2><br />
       
      
    </div>   
     <div style="width:90%;text-align:right;">
      <span id="mySpan">
	    	 <input id="btnPrint" type="button" value="打印" onClick="javascript:beforePrint();window.print();" />
	     </span>
    </div>
    <div style="width:90%;text-align:right;">
    	编号：【${tlForm.applyNo}】
    </div>
    
     
    

<table width="95%" height="600" border="1" style="text-align:center;" align="center" cellpadding="1" cellspacing="0">
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
    <td align="left" rowspan="3" style="text-align:center;">${tlForm.type==0?"请假":"出差"}期间工作安排情况</td>
    <td colspan="3" height="30" style="text-align: left;">教学工作: ${tlForm.arrangeTech}
    <div style="text-align:right;">
    (${tlForm.arrangeTechDealAlready==true?"已落实":"未落实"})
    </div>
    </td>
   
  </tr>
  <tr>
    <td  height="30" colspan="3" style="text-align: left;">服务工作:${tlForm.arrangeService}
    <div style="text-align:right;">
     (${tlForm.arrangeServiceDealAlready==true?"已落实":"未落实"})
    </div>
    </td>
  </tr>
  <tr>
    <td height="36" colspan="3" style="text-align: left;">管理工作:${tlForm.arrangeManage} 
    <div style="text-align:right;">
    (${tlForm.arrangeManageDealAlready==true?"已落实":"未落实"})
    </div>
    </td>
  </tr>
  <tr>
    <td height="84">处室负责人意见</td>
    <td colspan="3"><table width="100%" >
      <tr>
        <td> 		
        	<div style="text-align: left; padding-left: 50px; font-size:20">
        		${tlForm.officeChiefStatus==null?"" :(tlForm.officeChiefStatus==1?"同意":"不同意")}
        	</div>
        	<div style="text-align: left; padding-left: 50px; ">
        		${tlForm.officeChiefApproveOption}
        	</div>
        </td>
      </tr>
      <tr>
        <td align="right">
	        <div style="text-align:left; padding-left: 280px;">
	        	签名:${tlForm.officeChiefApproverId} 
	        </div>
	         <div style="text-align:left; padding-left: 280px;">
	         	日期：${fn:substring(tlForm.officeChiefApproveTime,0,10)}
	         </div>
        </td>
      </tr>
    </table></td>
  </tr>
   <tr>
    <td height="91">分管校长意见</td>
    <td colspan="3"><table width="100%" >
      <tr>
        <td> 		
        	<div style="text-align: left; padding-left: 50px; font-size:20">
        		${tlForm.vicePrincipalStatus==null?"" :(tlForm.vicePrincipalStatus==1?"同意":"不同意")}
        	</div>
        	<div style="text-align: left; padding-left: 50px; ">
        		${tlForm.vicePrincipalApproveOption}
        	</div>
        </td>
      </tr>
      <tr>
        <td align="right"> 
	         <div style="text-align:left; padding-left: 280px;">
	                签名:${tlForm.vicePrincipalApproverId} 
	        </div>    
	         <div style="text-align:left; padding-left: 280px;">
	        		日期：${fn:substring(tlForm.vicePrincipalApproveTime,0,10)}
	        </div>   
        </td>
      </tr>
    </table></td>
  </tr>
   <tr>
    <td height="97">校长意见</td>
    <td colspan="3"><table width="100%" >
     <tr>
        <td> 		
        	<div style="text-align: left; padding-left: 50px; font-size:20">
        		${tlForm.principalStatus==null?"" :(tlForm.principalStatus==1?"同意":"不同意")}
        	</div>
        	<div style="text-align: left; padding-left: 50px; ">
        		${tlForm.principalApproveOption}
        	</div>
        </td>
      </tr>
      <tr>
        <td align="right">
	        <div style="text-align:left; padding-left: 280px;">
	                      签名:${tlForm.principalApproverId} 
	        </div>
	        <div style="text-align:left; padding-left: 280px;">
	       		 日期：${fn:substring(tlForm.principalApproveTime,0,10)}
	       	 </div>
        </td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="100">备注</td>
    <td colspan="3">${tlForm.remark==""||tlForm.remark==null?"":tlForm.remark}</td>  
  </tr>
  
</table>
<table width="95%"  border="0" align="center" style="text-align: left;font-weight: bold;line-height: 25px;" cellpadding="1" cellspacing="0">
    <tr>
    	<td>
        说明：<br/>
1.	${tlForm.type==0?"凡因病、因事请假的，口头请假一律无效，必须填写请假单。":"因公外出必须填写出差审批单，口头请假一律无效。"}<br/>
2.	${tlForm.type==0?"请假一天，经课程处（处室）负责人批准，请假二天，经分管校长批准，请假三天（三天以上）须交校长审批，并落实好相应的工作。":"出差一天，经课程处（处室）负责人批准，出差二天，经分管校长批准，出差三天（三天以上）须交校长审批，并落实好相应的工作。" }<br/>
3.	要按要求离校前将${tlForm.type==0?"请假单":"出差审批单"}（一式两份）一份交课程处（处室），一份交督导科，回校后及时到课程处（处室）及督导科销假。<br/>
4.	如遇特殊情况，先电话分别告知课程处（处室）和督导科，事后必须做好补假及注销手续。
<br/>
        </td>
    </tr>
</table>
</body>
</html> 