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
HashMap ext = new HashMap(); 
String tglparentid=request.getParameter("tglparentid")==null?"":request.getParameter("tglparentid"); 
ext.put("tglparentid",tglparentid); 
new CommDAO().insert(request,response,"wpjbxx",ext,true,false); 
%>
<body>

<form  action="wpjbxxtj.jsp?f=f&tglparentid=<%=tglparentid%>"  name="f1" method="post"  onsubmit="return checkform()" >
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
                <td width="95%" class="STYLE1"><span class="STYLE3">你当前的位置</span>  ： 信息添加</td>
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
            <td width="17%" height="30" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">货物货号</span></div></td>
            <td width="83%" bgcolor="#FFFFFF" class="STYLE1">&nbsp;<input type=text  onblur='checkform()' class='' id='wpno' name='wpno' size=35 /><label id='clabelwpno' /></td>
          </tr>
<tr>
            <td width="17%" height="30" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">货物名称</span></div></td>
            <td width="83%" bgcolor="#FFFFFF" class="STYLE1">&nbsp;<input type=text  onblur='checkform()' class='' id='wpname' name='wpname' size=35 /><label id='clabelwpname' /></td>
          </tr>
<tr>
            <td width="17%" height="30" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">单位</span></div></td>
            <td width="83%" bgcolor="#FFFFFF" class="STYLE1">&nbsp;<input type=text  onblur='checkform()' class='' id='danwei' name='danwei' size=35 /><label id='clabeldanwei' /></td>
          </tr>
<tr>
            <td width="17%" height="30" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">货物类别</span></div></td>
            <td width="83%" bgcolor="#FFFFFF" class="STYLE1">&nbsp;<%=Info.getselect("wptype","wptypes","tname~无名"," 1=1 ")%> 
<label id='clabelwptype' />
</td>
          </tr>
<tr>
            <td width="17%" height="30" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">预警上限</span></div></td>
            <td width="83%" bgcolor="#FFFFFF" class="STYLE1">&nbsp;<input type=text   size='8' class=''  id='maxnum'  name='maxnum'  onkeyup='clearNoNum(this);' onblur='clearNoNum(this);checkform();' onmouseup='clearNoNum(this);'    /><label id='clabelmaxnum' /></td>
          </tr>
<tr>
            <td width="17%" height="30" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">预警下限</span></div></td>
            <td width="83%" bgcolor="#FFFFFF" class="STYLE1">&nbsp;<input type=text  onblur='checkform()' class='' id='minum' name='minum' size=35 /><label id='clabelminum' /></td>
          </tr>
<tr>
            <td width="17%" height="30" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">备注</span></div></td>
            <td width="83%" bgcolor="#FFFFFF" class="STYLE1">&nbsp;<input type=text  onblur='checkform()' class='' id='bei' name='bei' size=35 /><label id='clabelbei' /></td>
          </tr>

            
            
            
            <tr>
            <td height="32" colspan="2" align="center" valign="middle" bgcolor="#FFFFFF">
            
            <input type="submit" name="Submit"  value="提交信息" />&nbsp;&nbsp;&nbsp;<input type=button value='返回上页' onclick='window.location.replace("wpjbxxcx.jsp")' />            </td>
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
<script language=javascript src='/productsys/js/popup.js'></script>
<script language=javascript src='/productsys/js/ajax.js'></script>
<%@page import="util.Info"%>
<%@page import="util.Info"%> 
<%@page import="java.util.ArrayList"%> 
<%@page import="java.util.HashMap"%> 
<%@page import="util.PageManager"%> 
<%@page import="dao.CommDAO"%> 
<script language=javascript >  
 
 function checkform(){  
var wpnoobj = document.getElementById("wpno");  
if(wpnoobj.value==""){  
document.getElementById("clabelwpno").innerHTML="&nbsp;&nbsp;<font color=red>请输入货物货号</font>";  
return false;  
}else{
document.getElementById("clabelwpno").innerHTML="  ";  
}  
  
var wpnoobj = document.getElementById("wpno");  
if(wpnoobj.value!=""){  
var ajax = new AJAX();
ajax.post("/productsys/factory/checkno.jsp?table=wpjbxx&col=wpno&value="+wpnoobj.value+"&checktype=insert&ttime=<%=Info.getDateStr()%>") 
var msg = ajax.getValue();
if(msg.indexOf('Y')>-1){
document.getElementById("clabelwpno").innerHTML="&nbsp;&nbsp;<font color=red>货物货号已存在</font>";  
return false;
}else{document.getElementById("clabelwpno").innerHTML="  ";  
}  
}  
var wpnameobj = document.getElementById("wpname");  
if(wpnameobj.value==""){  
document.getElementById("clabelwpname").innerHTML="&nbsp;&nbsp;<font color=red>请输入货物名称</font>";  
return false;  
}else{
document.getElementById("clabelwpname").innerHTML="  ";  
}  
  
var danweiobj = document.getElementById("danwei");  
if(danweiobj.value==""){  
document.getElementById("clabeldanwei").innerHTML="&nbsp;&nbsp;<font color=red>请输入单位</font>";  
return false;  
}else{
document.getElementById("clabeldanwei").innerHTML="  ";  
}  
  
var wptypeobj = document.getElementById("wptype");  
if(wptypeobj.value==""){  
document.getElementById("clabelwptype").innerHTML="&nbsp;&nbsp;<font color=red>请输入货物类别</font>";  
return false;  
}else{
document.getElementById("clabelwptype").innerHTML="  ";  
}  
  
var maxnumobj = document.getElementById("maxnum");  
if(maxnumobj.value==""){  
document.getElementById("clabelmaxnum").innerHTML="&nbsp;&nbsp;<font color=red>请输入预警上限</font>";  
return false;  
}else{
document.getElementById("clabelmaxnum").innerHTML="  ";  
}  
  
var minumobj = document.getElementById("minum");  
if(minumobj.value==""){  
document.getElementById("clabelminum").innerHTML="&nbsp;&nbsp;<font color=red>请输入预警下限</font>";  
return false;  
}else{
document.getElementById("clabelminum").innerHTML="  ";  
}  
  
return true;   
}   
</script>  
