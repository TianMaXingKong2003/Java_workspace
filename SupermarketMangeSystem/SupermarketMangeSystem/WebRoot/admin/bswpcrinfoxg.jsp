﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

if(request.getParameter("f")!=null){
new CommDAO().jiajian("wpcrinfo", "nnum", request.getParameter("pchi"), "-"+request.getParameter("tnum"), request.getParameter("ynum"), "update"); 
}

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

<form  action="bswpcrinfoxg.jsp?f=f&id=<%=mmm.get("id")%>&ynum=<%=mmm.get("tnum")%>"  name="f1" method="post"  onsubmit="return checkform()" >
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
            <td width="17%" height="30" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">报损日期</span></div></td>
            <td width="83%" bgcolor="#FFFFFF" class="STYLE1">&nbsp;<input type=text size='12'   onblur='checkform()'  class=''   name='opdate'  id='opdate' onclick='WdatePicker();'  /><label id='clabelopdate' /></td>
          </tr>
<tr>
            <td width="17%" height="30" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">入库批次</span></div></td>
            <td width="83%" bgcolor="#FFFFFF" class="STYLE1">&nbsp;<%=Info.getselect("pchi","wpcrinfo","pchi~无名","optype='入库'")%><label id='clabelpchi' />
</td>
          </tr>
<tr>
            <td width="17%" height="30" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">物品编号</span></div></td>
            <td width="83%" bgcolor="#FFFFFF" class="STYLE1">&nbsp;<input type=text readonly style='background-color:#EBEBE4'  onblur='checkform()'  class='' id='wpno' name='wpno' size=35 /><label id='clabelwpno' /></td>
          </tr><script language=javascript> 
function wpnopchichange(){ 
document.getElementById("pchi").onchange=function(){
wpnopchichange();  
 
} 
var pchivalue = document.getElementById("pchi").value; 
var wpnoobj = document.getElementById("wpno"); 
wpnoobj.value=''; 
var ajax = new AJAX(); 
ajax.post("/productsys/factory/getsonops.jsp?glb=wpcrinfo&glzd=wpno~无名&jlzd=pchi&jlzdb=pchi&value="+pchivalue+"&ctype=text&ttime=<%=Info.getDateStr()%>"); 
var msg = ajax.getValue(); 
wpnoobj.value=msg.replace(" ","") 
} 
</script> 

<tr>
            <td width="17%" height="30" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">物品名称</span></div></td>
            <td width="83%" bgcolor="#FFFFFF" class="STYLE1">&nbsp;<input type=text readonly style='background-color:#EBEBE4'  onblur='checkform()'  class='' id='spname' name='spname' size=35 /><label id='clabelspname' /></td>
          </tr><script language=javascript> 
function spnamepchichange(){ 
document.getElementById("pchi").onchange=function(){
wpnopchichange();  
spnamepchichange();  
 
} 
var pchivalue = document.getElementById("pchi").value; 
var spnameobj = document.getElementById("spname"); 
spnameobj.value=''; 
var ajax = new AJAX(); 
ajax.post("/productsys/factory/getsonops.jsp?glb=wpcrinfo&glzd=spname~无名&jlzd=pchi&jlzdb=pchi&value="+pchivalue+"&ctype=text&ttime=<%=Info.getDateStr()%>"); 
var msg = ajax.getValue(); 
spnameobj.value=msg.replace(" ","") 
} 
</script> 

<tr>
            <td width="17%" height="30" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">进货价</span></div></td>
            <td width="83%" bgcolor="#FFFFFF" class="STYLE1">&nbsp;<input type=text readonly style='background-color:#EBEBE4'  onblur='checkform()'  class='' id='price' name='price' size=35 /><label id='clabelprice' /></td>
          </tr><script language=javascript> 
function pricepchichange(){ 
document.getElementById("pchi").onchange=function(){
wpnopchichange();  
spnamepchichange();  
pricepchichange();  
 
} 
var pchivalue = document.getElementById("pchi").value; 
var priceobj = document.getElementById("price"); 
priceobj.value=''; 
var ajax = new AJAX(); 
ajax.post("/productsys/factory/getsonops.jsp?glb=wpcrinfo&glzd=price~无名&jlzd=pchi&jlzdb=pchi&value="+pchivalue+"&ctype=text&ttime=<%=Info.getDateStr()%>"); 
var msg = ajax.getValue(); 
priceobj.value=msg.replace(" ","") 
} 
</script> 


<tr>
            <td width="17%" height="30" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">当前数量</span></div></td>
            <td width="83%" bgcolor="#FFFFFF" class="STYLE1">&nbsp;<input type=text readonly style='background-color:#EBEBE4'  onblur='checkform()'  class='' id='nnum' name='nnum' size=35 /><label id='clabelnnum' /></td>
          </tr><script language=javascript> 
function nnumpchichange(){ 
document.getElementById("pchi").onchange=function(){
wpnopchichange();  
spnamepchichange();  
pricepchichange();  
nnumpchichange();  
 
} 
var pchivalue = document.getElementById("pchi").value; 
var nnumobj = document.getElementById("nnum"); 
nnumobj.value=''; 
var ajax = new AJAX(); 
ajax.post("/productsys/factory/getsonops.jsp?glb=wpcrinfo&glzd=nnum~无名&jlzd=pchi&jlzdb=pchi&value="+pchivalue+"&ctype=text&ttime=<%=Info.getDateStr()%>"); 
var msg = ajax.getValue(); 
nnumobj.value=msg.replace(" ","") 
} 
</script> 

<tr>
            <td width="17%" height="30" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">供应商</span></div></td>
            <td width="83%" bgcolor="#FFFFFF" class="STYLE1">&nbsp;<input type=text readonly style='background-color:#EBEBE4'  onblur='checkform()'  class='' id='gys' name='gys' size=35 /><label id='clabelgys' /></td>
          </tr><script language=javascript> 
function gyspchichange(){ 
document.getElementById("pchi").onchange=function(){
wpnopchichange();  
spnamepchichange();  
pricepchichange();  
nnumpchichange();  
gyspchichange();  
 
} 
var pchivalue = document.getElementById("pchi").value; 
var gysobj = document.getElementById("gys"); 
gysobj.value=''; 
var ajax = new AJAX(); 
ajax.post("/productsys/factory/getsonops.jsp?glb=wpcrinfo&glzd=gys~无名&jlzd=pchi&jlzdb=pchi&value="+pchivalue+"&ctype=text&ttime=<%=Info.getDateStr()%>"); 
var msg = ajax.getValue(); 
gysobj.value=msg.replace(" ","") 
} 
</script> 


            

<tr>
            <td width="17%" height="30" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">报损数量</span></div></td>
            <td width="83%" bgcolor="#FFFFFF" class="STYLE1">&nbsp;<input type=text size='8' class='' id='tnum'  name='tnum' onkeyup='clearNoNum(this);' onblur='clearNoNum(this);getjia();checkform();' onmouseup='clearNoNum(this);'  /><label id='clabeltnum' /></td>
          </tr>
          
           <script language=javascript>
          function getjia(){
           
          var price  = document.getElementById("price").value;
          var tnum  = document.getElementById("tnum").value;
          document.getElementById("je").value=price*tnum;
          }
          </script>
          
<tr>
            <td width="17%" height="30" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">报损原因</span></div></td>
            <td width="83%" bgcolor="#FFFFFF" class="STYLE1">&nbsp;<textarea  cols='45' rows='3'  onblur='checkform()'   style='margin-top: 1px;margin-bottom: 1px'  class=''   name='jcontent'   ></textarea></td>
          </tr>


<tr>
            <td width="17%" height="30" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">报损总金额</span></div></td>
            <td width="83%" bgcolor="#FFFFFF" class="STYLE1">&nbsp;<input type=text size='8' class='' id='je'  name='je' onkeyup='clearNoNum(this);' onblur='clearNoNum(this);checkform();' onmouseup='clearNoNum(this);'  /><label id='clabelje' /></td>
          </tr>

            
            
            <tr>
            <td height="32" colspan="2" align="center" valign="middle" bgcolor="#FFFFFF">
            
            <input type="submit" name="Submit"  value="提交信息" />&nbsp;&nbsp;&nbsp;<input type=button value='返回上页' onclick='window.location.replace("bswpcrinfocx.jsp")' />            </td>
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
wpnopchichange();  
spnamepchichange();  
pricepchichange();  
nnumpchichange();  
gyspchichange();  
 
</script>  
<script language=javascript >  
 function checkform(){  
var opdateobj = document.getElementById("opdate");  
if(opdateobj.value==""){  
document.getElementById("clabelopdate").innerHTML="&nbsp;&nbsp;<font color=red>请输入报损日期</font>";  
return false;  
}else{ 
document.getElementById("clabelopdate").innerHTML="  ";  
}  
var pchiobj = document.getElementById("pchi");  
if(pchiobj.value==""){  
document.getElementById("clabelpchi").innerHTML="&nbsp;&nbsp;<font color=red>请输入入库批次</font>";  
return false;  
}else{ 
document.getElementById("clabelpchi").innerHTML="  ";  
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
var tnumobj = document.getElementById("tnum");  
if(tnumobj.value==""){  
document.getElementById("clabeltnum").innerHTML="&nbsp;&nbsp;<font color=red>请输入报损数量</font>";  
return false;  
}else{ 
document.getElementById("clabeltnum").innerHTML="  ";  
}  

 if(Number(document.getElementById("tnum").value)>Number(document.getElementById("nnum").value))
 {
 document.getElementById("clabeltnum").innerHTML="&nbsp;&nbsp;<font color=red>数量超出现有范围</font>";  
 return false;
 }else{
 document.getElementById("clabeltnum").innerHTML="   ";  
 }


var jeobj = document.getElementById("je");  
if(jeobj.value==""){  
document.getElementById("clabelje").innerHTML="&nbsp;&nbsp;<font color=red>请输入报损总金额</font>";  
return false;  
}else{ 
document.getElementById("clabelje").innerHTML="  ";  
}  
return true;   
}   
</script>  
<%=Info.tform(mmm)%> 
<script language=javascript >  
wpnopchichange();  
spnamepchichange();  
pricepchichange();  
nnumpchichange();  
gyspchichange(); 
</script>  
<%=Info.tform(mmm)%> 
