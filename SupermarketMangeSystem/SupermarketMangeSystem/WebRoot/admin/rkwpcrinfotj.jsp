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
ext.put("optype","入库"); 
ext.put("nnum",request.getParameter("tnum")); 
ext.put("uname",Info.getUser(request).get("uname")); 
new CommDAO().insert(request,response,"wpcrinfo",ext,true,false); 
%>
<body>

<form  action="rkwpcrinfotj.jsp?f=f&tglparentid=<%=tglparentid%>"  name="f1" method="post"  onsubmit="return checkform()" >
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
            <td width="17%" height="30" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">入库日期</span></div></td>
            <td width="83%" bgcolor="#FFFFFF" class="STYLE1">&nbsp;<input type=text  onblur='checkform()'  size='12' class=''   name='opdate'  id='opdate' onclick='WdatePicker();'  /><label id='clabelopdate' /></td>
          </tr>
<tr>
            <td width="17%" height="30" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">物品编号</span></div></td>
            <td width="83%" bgcolor="#FFFFFF" class="STYLE1">&nbsp;<%=Info.getselect("wpno","wpjbxx","wpno~无名"," 1=1 ")%> 
<label id='clabelwpno' />
</td>
          </tr>
<tr>
            <td width="17%" height="30" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">物品名称</span></div></td>
            <td width="83%" bgcolor="#FFFFFF" class="STYLE1">&nbsp;<input type=text readonly style=' background-color:#EBEBE4'  onblur='checkform()' class='' id='spname' name='spname' size=35 /><label id='clabelspname' /></td>
          </tr><script language=javascript> 
function spnamewpnochange(){ 
document.getElementById("wpno").onchange=function(){spnamewpnochange();  
 } 
var wpnovalue = document.getElementById("wpno").value; 
var spnameobj = document.getElementById("spname"); 
spnameobj.value=''; 
var ajax = new AJAX(); 
ajax.post("/productsys/factory/getsonops.jsp?glb=wpjbxx&glzd=wpname~无名&jlzd=wpno&jlzdb=wpno&value="+wpnovalue+"&ctype=text&ttime=<%=Info.getDateStr()%>"); 
var msg = ajax.getValue(); 
spnameobj.value=msg.replace(" ",""); 
} 
</script> 

<tr>
            <td width="17%" height="30" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">进货价</span></div></td>
            <td width="83%" bgcolor="#FFFFFF" class="STYLE1">&nbsp;<input type=text   size='8' class=''  id='price'  name='price'  onkeyup='clearNoNum(this);' onblur='clearNoNum(this);checkform();' onmouseup='clearNoNum(this);'    /><label id='clabelprice' /></td>
          </tr>
<tr>
            <td width="17%" height="30" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">预售价</span></div></td>
            <td width="83%" bgcolor="#FFFFFF" class="STYLE1">&nbsp;<input type=text   size='8' class=''  id='yprice'  name='yprice'  onkeyup='clearNoNum(this);' onblur='clearNoNum(this);checkform();' onmouseup='clearNoNum(this);'    /><label id='clabelyprice' /></td>
          </tr>
<tr>
            <td width="17%" height="30" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">入库数量</span></div></td>
            <td width="83%" bgcolor="#FFFFFF" class="STYLE1">&nbsp;<input type=text   size='8' class=''  id='tnum'  name='tnum'  onkeyup='clearNoNum(this);' onblur='clearNoNum(this);checkform();getjia();' onmouseup='clearNoNum(this);'    /><label id='clabeltnum' /></td>
          </tr>
          
           <script language=javascript>
          function getjia(){
          var price  = document.getElementById("price").value;
          var tnum  = document.getElementById("tnum").value;
          document.getElementById("je").value=price*tnum;
          }
          </script>
          
<tr>
            <td width="17%" height="30" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">进货总金额</span></div></td>
            <td width="83%" bgcolor="#FFFFFF" class="STYLE1">&nbsp;<input type=text   size='8' class=''  id='je'  name='je'  onkeyup='clearNoNum(this);' onblur='clearNoNum(this);checkform();' onmouseup='clearNoNum(this);'    /><label id='clabelje' /></td>
          </tr>
<tr>
            <td width="17%" height="30" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">规格</span></div></td>
            <td width="83%" bgcolor="#FFFFFF" class="STYLE1">&nbsp;<input type=text  onblur='checkform()' class='' id='guig' name='guig' size=35 /><label id='clabelguig' /></td>
          </tr>
 
<tr>
            <td width="17%" height="30" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">供应商</span></div></td>
            <td width="83%" bgcolor="#FFFFFF" class="STYLE1">&nbsp;<%=Info.getselect("gys","sysuser","uname~无名","utype='供应商'")%> 
<label id='clabelgys' />
</td>
          </tr>
<tr>
            <td width="17%" height="30" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">入库批次</span></div></td>
            <td width="83%" bgcolor="#FFFFFF" class="STYLE1">&nbsp;<input type=text  onblur='checkform()' class='' id='pchi' name='pchi' size=35 /><label id='clabelpchi' /></td>
          </tr>
<tr>
            <td width="17%" height="30" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">生产日期</span></div></td>
            <td width="83%" bgcolor="#FFFFFF" class="STYLE1">&nbsp;<input type=text  onblur='checkform()'  size='12' class=''   name='scdate'  id='scdate' onclick='WdatePicker();'  /><label id='clabelscdate' /></td>
          </tr>
<tr>
            <td width="17%" height="30" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">有效期截止</span></div></td>
            <td width="83%" bgcolor="#FFFFFF" class="STYLE1">&nbsp;<input type=text  onblur='checkform()'  size='12' class=''   name='yxdate'  id='yxdate' onclick='WdatePicker();'  /><label id='clabelyxdate' /></td>
          </tr>
<tr>
            <td width="17%" height="30" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">存放位置</span></div></td>
            <td width="83%" bgcolor="#FFFFFF" class="STYLE1">&nbsp;<%=Info.getselect("cfwz","bases","bname~无名"," 1=1 ")%> 
<label id='clabelcfwz' />
</td>
          </tr>

            
            
            
            <tr>
            <td height="32" colspan="2" align="center" valign="middle" bgcolor="#FFFFFF">
            
            <input type="submit" name="Submit"  value="提交信息" />&nbsp;&nbsp;&nbsp;<input type=button value='返回上页' onclick='window.location.replace("rkwpcrinfocx.jsp")' />            </td>
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
spnamewpnochange();  
 
 function checkform(){  
var opdateobj = document.getElementById("opdate");  
if(opdateobj.value==""){  
document.getElementById("clabelopdate").innerHTML="&nbsp;&nbsp;<font color=red>请输入入库日期</font>";  
return false;  
}else{
document.getElementById("clabelopdate").innerHTML="  ";  
}  
  
var wpnoobj = document.getElementById("wpno");  
if(wpnoobj.value==""){  
document.getElementById("clabelwpno").innerHTML="&nbsp;&nbsp;<font color=red>请输入物品编号</font>";  
return false;  
}else{
document.getElementById("clabelwpno").innerHTML="  ";  
}  
  
var spnameobj = document.getElementById("spname");  
if(spnameobj.value==""){  
document.getElementById("clabelspname").innerHTML="&nbsp;&nbsp;<font color=red>请输入物品名称</font>";  
return false;  
}else{
document.getElementById("clabelspname").innerHTML="  ";  
}  
  
var priceobj = document.getElementById("price");  
if(priceobj.value==""){  
document.getElementById("clabelprice").innerHTML="&nbsp;&nbsp;<font color=red>请输入进货价</font>";  
return false;  
}else{
document.getElementById("clabelprice").innerHTML="  ";  
}  
  
var ypriceobj = document.getElementById("yprice");  
if(ypriceobj.value==""){  
document.getElementById("clabelyprice").innerHTML="&nbsp;&nbsp;<font color=red>请输入预售价</font>";  
return false;  
}else{
document.getElementById("clabelyprice").innerHTML="  ";  
}  
  
var tnumobj = document.getElementById("tnum");  
if(tnumobj.value==""){  
document.getElementById("clabeltnum").innerHTML="&nbsp;&nbsp;<font color=red>请输入入库数量</font>";  
return false;  
}else{
document.getElementById("clabeltnum").innerHTML="  ";  
}  
  
var jeobj = document.getElementById("je");  
if(jeobj.value==""){  
document.getElementById("clabelje").innerHTML="&nbsp;&nbsp;<font color=red>请输入进货总金额</font>";  
return false;  
}else{
document.getElementById("clabelje").innerHTML="  ";  
}  
  
var gysobj = document.getElementById("gys");  
if(gysobj.value==""){  
document.getElementById("clabelgys").innerHTML="&nbsp;&nbsp;<font color=red>请输入供应商</font>";  
return false;  
}else{
document.getElementById("clabelgys").innerHTML="  ";  
}  
  
var pchiobj = document.getElementById("pchi");  
if(pchiobj.value==""){  
document.getElementById("clabelpchi").innerHTML="&nbsp;&nbsp;<font color=red>请输入入库批次</font>";  
return false;  
}else{
document.getElementById("clabelpchi").innerHTML="  ";  
}  
  
var pchiobj = document.getElementById("pchi");  
if(pchiobj.value!=""){  
var ajax = new AJAX();
ajax.post("/productsys/factory/checkno.jsp?table=wpcrinfo&col=pchi&value="+pchiobj.value+"&checktype=insert&ttime=<%=Info.getDateStr()%>") 
var msg = ajax.getValue();
if(msg.indexOf('Y')>-1){
document.getElementById("clabelpchi").innerHTML="&nbsp;&nbsp;<font color=red>入库批次已存在</font>";  
return false;
}else{document.getElementById("clabelpchi").innerHTML="  ";  
}  
}  
var scdateobj = document.getElementById("scdate");  
if(scdateobj.value==""){  
document.getElementById("clabelscdate").innerHTML="&nbsp;&nbsp;<font color=red>请输入生产日期</font>";  
return false;  
}else{
document.getElementById("clabelscdate").innerHTML="  ";  
}  
  
var yxdateobj = document.getElementById("yxdate");  
if(yxdateobj.value==""){  
document.getElementById("clabelyxdate").innerHTML="&nbsp;&nbsp;<font color=red>请输入有效期截止</font>";  
return false;  
}else{
document.getElementById("clabelyxdate").innerHTML="  ";  
}  
  
var cfwzobj = document.getElementById("cfwz");  
if(cfwzobj.value==""){  
document.getElementById("clabelcfwz").innerHTML="&nbsp;&nbsp;<font color=red>请输入存放位置</font>";  
return false;  
}else{
document.getElementById("clabelcfwz").innerHTML="  ";  
}  
  
return true;   
}   
</script>  
