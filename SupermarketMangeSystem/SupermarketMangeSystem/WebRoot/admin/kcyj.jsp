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

<body>

<form  action="kcyj.jsp"  name="f1" method="post"    >
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
                <td width="95%" class="STYLE1"><span class="STYLE3">你当前的位置</span>  ： 库存预警</td>
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
        <td><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#C3E5FB" >
        
         
        
          <tr>
            <td   height="28" background="/productsys/admin/tab/images/bg.png" bgcolor="#FFFFFF" align="center" class="STYLE1">货物货号  </td>
<td   height="28" background="/productsys/admin/tab/images/bg.png" bgcolor="#FFFFFF" align="center" class="STYLE1">货物名称  </td>
<td   height="28" background="/productsys/admin/tab/images/bg.png" bgcolor="#FFFFFF" align="center" class="STYLE1">单位  </td>
<td   height="28" background="/productsys/admin/tab/images/bg.png" bgcolor="#FFFFFF" align="center" class="STYLE1">货物类别  </td>
<td   height="28" background="/productsys/admin/tab/images/bg.png" bgcolor="#FFFFFF" align="center" class="STYLE1">预警上限  </td>
<td   height="28" background="/productsys/admin/tab/images/bg.png" bgcolor="#FFFFFF" align="center" class="STYLE1">预警下限  </td>
<td   height="28" background="/productsys/admin/tab/images/bg.png" bgcolor="#FFFFFF" align="center" class="STYLE1">当前数量</td>
            </tr>
         
         
         
          <% 
new CommDAO().delete(request,"wpjbxx"); 
if(request.getParameter("wpnoid1")!=null){ 
 new CommDAO().commOper("update wpjbxx set wpno ='' where id="+request.getParameter("wpnoid1"));  
} 
if(request.getParameter("wpnoid2")!=null){ 
 new CommDAO().commOper("update wpjbxx set wpno ='' where id="+request.getParameter("wpnoid2"));  
} 
String sql = "select * from wpjbxx where 1=1 " ; 
  sql +=" order by id desc ";
String url = "kcyj.jsp?1=1"; 
ArrayList<HashMap> list = PageManager.getPages(url,35, sql, request ); 
for(HashMap map:list){ 
int max = Integer.parseInt(map.get("maxnum").toString());
int min = Integer.parseInt(map.get("minum").toString());
String spno = map.get("wpno").toString();
int rk = new CommDAO().getInt("select sum(nnum) from wpcrinfo where wpno='"+spno+"' and optype='入库'");
if(rk>max||rk<min){
%>
<tr>

            <td height="30" valign="middle" bgcolor="#FFFFFF" class="STYLE1" align="center"><%=map.get("wpno")%></td>
            <td height="30" valign="middle" bgcolor="#FFFFFF" class="STYLE1" align="center"><%=map.get("wpname")%></td>
            <td height="30" valign="middle" bgcolor="#FFFFFF" class="STYLE1" align="center"><%=map.get("danwei")%></td>
            <td height="30" valign="middle" bgcolor="#FFFFFF" class="STYLE1" align="center"><%=map.get("wptype")%></td>
            <td height="30" valign="middle" bgcolor="#FFFFFF" class="STYLE1" align="center"><%=map.get("maxnum")%></td>
            <td height="30" valign="middle" bgcolor="#FFFFFF" class="STYLE1" align="center"><%=map.get("minum")%></td>
            <td height="30" valign="middle" bgcolor="#FFFFFF" class="STYLE1" align="center">
 <%=rk %>
</td>
</tr>
<%}}%>
            
            
        </table></td>
        <td width="8" background="/productsys/admin/tab/images/tab_15.gif" class="STYLE1" >&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="35" background="/productsys/admin/tab/images/tab_19.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="35"><img src="/productsys/admin/tab/images/tab_18.gif" width="12" height="35" /></td>
        <td colspan=8 align="center" valign="middle"  class="STYLE1" >${page.info}</td>
        <td width="16"><img src="/productsys/admin/tab/images/tab_20.gif" width="16" height="35" /></td>
      </tr>
    </table></td>
  </tr>
</table>


</form>
</body>
</html>
<script language=javascript src='/productsys/js/ajax.js'></script>
 
<script language=javascript> 
function add(){ 
pop('wpjbxxtj.jsp','信息添加',550,'100%') 
}
</script> 
<%@page import="util.Info"%> 
<%@page import="java.util.ArrayList"%> 
<%@page import="java.util.HashMap"%> 
<%@page import="util.PageManager"%> 
<%@page import="dao.CommDAO"%> 
