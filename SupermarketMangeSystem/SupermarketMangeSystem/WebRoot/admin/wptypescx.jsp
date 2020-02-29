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

<form  action="wptypescx.jsp"  name="f1" method="post"    >
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
                <td width="95%" class="STYLE1"><span class="STYLE3">你当前的位置</span>  ： 货物类别管理</td>
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
            <td colspan=3 height="36" bgcolor="#FFFFFF" align="left" class="STYLE1">  &nbsp;&nbsp;&nbsp;
<% 
String ptname = request.getParameter("tname")==null?"":request.getParameter("tname"); 
String starttname = request.getParameter("starttname")==null?"":request.getParameter("starttname"); 
String endtname = request.getParameter("endtname")==null?"":request.getParameter("endtname"); 
   %>

<%
 HashMap mmm = new HashMap();%> 

&nbsp;&nbsp;
类别名称 
&nbsp;:&nbsp; 
<input type=text class=''  size=20 name='tname' />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<input type=submit class='' value='查询信息' />
 &nbsp;&nbsp;
<input type=button   class='' value='添加信息' onclick="window.location.replace('wptypestj.jsp')" /> 
&nbsp;&nbsp;</td>
            </tr>
        
        
        
          <tr>
            <td   height="28" background="/productsys/admin/tab/images/bg.png" bgcolor="#FFFFFF" align="center" class="STYLE1">类别名称  </td>
<td   height="28" background="/productsys/admin/tab/images/bg.png" bgcolor="#FFFFFF" align="center" class="STYLE1">操作  </td>
            </tr>
         
         
         
          <% 
new CommDAO().delete(request,"wptypes"); 
if(request.getParameter("tnameid1")!=null){ 
 new CommDAO().commOper("update wptypes set tname ='' where id="+request.getParameter("tnameid1"));  
} 
if(request.getParameter("tnameid2")!=null){ 
 new CommDAO().commOper("update wptypes set tname ='' where id="+request.getParameter("tnameid2"));  
} 
String sql = "select * from wptypes where 1=1 " ;
 if(!ptname.equals("")){ 
 sql+= " and tname like'%"+ptname+"%' " ;
 }  
 if(!starttname.equals("")){  
 mmm.put("starttname",starttname) ;
 sql+= " and tname >'"+starttname+"' " ;
 }  
 if(!endtname.equals("")){  
 mmm.put("endtname",endtname) ;
 sql+= " and tname <'"+Info.getDay(endtname,1)+"' " ;
 }  
  sql +=" order by id desc ";
String url = "wptypescx.jsp?1=1&tname="+ptname+""; 
ArrayList<HashMap> list = PageManager.getPages(url,5, sql, request ); 
for(HashMap map:list){ %>
<tr>

            <td height="30" valign="middle" bgcolor="#FFFFFF" class="STYLE1" align="center"><%=map.get("tname")%></td>
            <td height="30" valign="middle" bgcolor="#FFFFFF" class="STYLE1" align="center">
<a href="wptypesxg.jsp?id=<%=map.get("id")%>">修改</a>
&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;

<a onclick="return confirm('确定要删除这条记录吗?')" href="wptypescx.jsp?scid=<%=map.get("id")%>">删除</a>
</td>
</tr>
<%}%>
            
            
        </table></td>
        <td width="8" background="/productsys/admin/tab/images/tab_15.gif" class="STYLE1" >&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="35" background="/productsys/admin/tab/images/tab_19.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="35"><img src="/productsys/admin/tab/images/tab_18.gif" width="12" height="35" /></td>
        <td colspan=3 align="center" valign="middle"  class="STYLE1" >${page.info}</td>
        <td width="16"><img src="/productsys/admin/tab/images/tab_20.gif" width="16" height="35" /></td>
      </tr>
    </table></td>
  </tr>
</table>


</form>
</body>
</html>
<script language=javascript src='/productsys/js/ajax.js'></script>
<% 
mmm.put("tname",ptname); 
%>
<%=Info.tform(mmm)%> 
<script language=javascript >  
 
</script>  
<%=Info.tform(mmm)%> 
<script language=javascript src='/productsys/js/My97DatePicker/WdatePicker.js'></script>
<script language=javascript src='/productsys/js/popup.js'></script>
<script language=javascript> 
function update(no){ 
pop('wptypesxg.jsp?id='+no,'信息修改',550,'100%') 
}
</script> 
<script language=javascript> 
function add(){ 
pop('wptypestj.jsp','信息添加',550,'100%') 
}
</script> 
<%@page import="util.Info"%> 
<%@page import="java.util.ArrayList"%> 
<%@page import="java.util.HashMap"%> 
<%@page import="util.PageManager"%> 
<%@page import="dao.CommDAO"%> 
