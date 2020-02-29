<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="dao.CommDAO"%>
<%@page import="util.Info"%>
<%@page import="util.PageManager"%>
 <%
HashMap user = Info.getUser(request);
String uname = user.get("uname").toString();
String utype = user.get("utype").toString();
String userid = user.get("id").toString();
 %>
 <%   

response.setHeader("Pragma","No-cache");    

response.setHeader("Cache-Control","no-cache");    

response.setDateHeader("Expires", -10);   

%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head> 
<title>无标题文档</title>
<style>a { text-decoration: none }</style> 
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE1 {font-size: 13px}
.STYLE3 {font-size: 12px; font-weight: bold; }
.STYLE4 {
	color: #03515d;
	font-size: 12px;
}
-->
</style>
 
</head>

<% 
new CommDAO().delete(request,"wpcrinfo"); 
String id = request.getParameter("id"); 
String erjitype = request.getParameter("erjitype"); 
String myztree = request.getParameter("myztree"); 
HashMap ext = new HashMap(); 
ext.put("uname",Info.getUser(request).get("uname")); 
new CommDAO().update(request,response,"wpcrinfo",ext,true,false); 
HashMap mmm = new CommDAO().getmap(id,"wpcrinfo"); 
%>
<body>

<form  action="thwpcrinfoxg.jsp?f=f&id=<%=mmm.get("id")%>"  name="f1" method="post"  onsubmit="return checkform()" >
<table width="100%" border="0" cellspacing="0" cellpadding="0">
<tr><td height="2"></td></tr>
  <tr>
    <td height="30" background="/productsys/admin/tab/images/tab_05.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="30"><img src="/productsys/admin/tab/images/tab_03.gif" width="12" height="30" /></td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="46%" valign="middle"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="5%"><div align="center"><img src="/productsys/admin/tab/images/tb.gif" width="16" height="16" /></div></td>
                <td width="95%" class="STYLE1"><span class="STYLE3">你当前的位置</span>  ： 信息查看</td>
              </tr>
            </table></td>
            <td width="54%"><table border="0" align="right" cellpadding="0" cellspacing="0">
              <tr>
                
              </tr>
            </table></td>
          </tr>
        </table></td>
        <td width="16"><img src="/productsys/admin/tab/images/tab_07.gif" width="16" height="30" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="8" background="/productsys/admin/tab/images/tab_12.gif">&nbsp;</td>
        <td><table style="margin-top:3px" width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#C3E5FB" >
          <tr style="display:none">
            <td height="28" colspan="2" background="/productsys/admin/tab/images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">信息标题</span></div></td>
            </tr>
         
         
         
          <tr>
            <td width="17%" height="30" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">客户</span></div></td>
            <td width="83%" bgcolor="#FFFFFF" class="STYLE1">&nbsp;<%=mmm.get("member")%></td>
          </tr>
<tr>
            <td width="17%" height="30" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">入库批次</span></div></td>
            <td width="83%" bgcolor="#FFFFFF" class="STYLE1">&nbsp;<%=mmm.get("pchi")%></td>
          </tr>
<tr>
            <td width="17%" height="30" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">物品编号</span></div></td>
            <td width="83%" bgcolor="#FFFFFF" class="STYLE1">&nbsp;<%=mmm.get("wpno")%></td>
          </tr>
<tr>
            <td width="17%" height="30" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">物品名称</span></div></td>
            <td width="83%" bgcolor="#FFFFFF" class="STYLE1">&nbsp;<%=mmm.get("spname")%></td>
          </tr>
<tr>
            <td width="17%" height="30" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">预售价</span></div></td>
            <td width="83%" bgcolor="#FFFFFF" class="STYLE1">&nbsp;<%=mmm.get("yprice")%></td>
          </tr>
          
          <tr>
            <td width="17%" height="30" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">出库数量</span></div></td>
            <td width="83%" bgcolor="#FFFFFF" class="STYLE1">&nbsp;<%=new CommDAO().getmap("wpcrinfo",mmm.get("guig").toString()).get("tnum")%></td>
          </tr>
          
<tr>
            <td width="17%" height="30" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">供应商</span></div></td>
            <td width="83%" bgcolor="#FFFFFF" class="STYLE1">&nbsp;<%=mmm.get("gys")%></td>
          </tr>
<tr>
            <td width="17%" height="30" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">退货日期</span></div></td>
            <td width="83%" bgcolor="#FFFFFF" class="STYLE1">&nbsp;<input type=text size='12'   onblur='checkform()'  class=''   name='opdate'  id='opdate' onclick='WdatePicker();'  /><label id='clabelopdate' /></td>
          </tr>
<tr>
            <td width="17%" height="30" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">退货数量</span></div></td>
            <td width="83%" bgcolor="#FFFFFF" class="STYLE1">&nbsp;<input type=text size='8' class='' id='tnum'  name='tnum' onkeyup='clearNoNum(this);' onblur='clearNoNum(this);checkform();' onmouseup='clearNoNum(this);'  /><label id='clabeltnum' /></td>
          </tr>
<tr>
            <td width="17%" height="30" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">退货原因</span></div></td>
            <td width="83%" bgcolor="#FFFFFF" class="STYLE1">&nbsp;<textarea  cols='45' rows='3'  onblur='checkform()'   style='margin-top: 1px;margin-bottom: 1px'  class=''   name='jcontent'   ></textarea></td>
          </tr>
<tr>
            <td width="17%" height="30" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">退货总金额</span></div></td>
            <td width="83%" bgcolor="#FFFFFF" class="STYLE1">&nbsp;<input type=text size='8' class='' id='je'  name='je' onkeyup='clearNoNum(this);' onblur='clearNoNum(this);checkform();' onmouseup='clearNoNum(this);'  /><label id='clabelje' /></td>
          </tr>

            
            
            
            <tr>
            <td height="32" colspan="2" align="center" valign="middle" bgcolor="#FFFFFF">
            
            <input type="submit" name="Submit"  value="提交信息" />&nbsp;&nbsp;&nbsp;<input type=button value='返回上页' onclick='window.location.replace("thwpcrinfocx.jsp")' />            </td>
            </tr>
            
            
            
        </table></td>
        <td width="8" background="/productsys/admin/tab/images/tab_15.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="35" background="/productsys/admin/tab/images/tab_19.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="35"><img src="/productsys/admin/tab/images/tab_18.gif" width="12" height="35" /></td>
        <td align="center" valign="middle">&nbsp;</td>
        <td width="16"><img src="/productsys/admin/tab/images/tab_20.gif" width="16" height="35" /></td>
      </tr>
    </table></td>
  </tr>
</table>


</form>
</body>
</html>
<script language=javascript src='/productsys/js/My97DatePicker/WdatePicker.js'></script> 
<script language=javascript src='/productsys/js/ajax.js'></script> 
<script language=javascript src='/productsys/js/popup.js'></script> 
<%@page import="util.Info"%> 
<%@page import="util.Info"%> 
<%@page import="java.util.ArrayList"%> 
<%@page import="java.util.HashMap"%> 
<%@page import="util.PageManager"%> 
<%@page import="dao.CommDAO"%> 
<script language=javascript >  
 
</script>  
<script language=javascript >  
 function checkform(){  
var opdateobj = document.getElementById("opdate");  
if(opdateobj.value==""){  
document.getElementById("clabelopdate").innerHTML="&nbsp;&nbsp;<font color=red>请输入退货日期</font>";  
return false;  
}else{ 
document.getElementById("clabelopdate").innerHTML="  ";  
}  
var jeobj = document.getElementById("je");  
if(jeobj.value==""){  
document.getElementById("clabelje").innerHTML="&nbsp;&nbsp;<font color=red>请输入退货总金额</font>";  
return false;  
}else{ 
document.getElementById("clabelje").innerHTML="  ";  
}  
return true;   
}   
</script>  
<%=Info.tform(mmm)%> 
<script language=javascript >  
 
</script>  
<%=Info.tform(mmm)%> 
