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

<form  action="kcpd.jsp"  name="f1" method="post"    >
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
                <td width="95%" class="STYLE1"><span class="STYLE3">你当前的位置</span>  ： 库存盘点</td>
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
            <td colspan=8 height="36" bgcolor="#FFFFFF" align="left" class="STYLE1">  &nbsp;&nbsp;&nbsp;
<% 
String pwpno = request.getParameter("wpno")==null?"":request.getParameter("wpno"); 
String startwpno = request.getParameter("startwpno")==null?"":request.getParameter("startwpno"); 
String endwpno = request.getParameter("endwpno")==null?"":request.getParameter("endwpno"); 
String pwpname = request.getParameter("wpname")==null?"":request.getParameter("wpname"); 
String startwpname = request.getParameter("startwpname")==null?"":request.getParameter("startwpname"); 
String endwpname = request.getParameter("endwpname")==null?"":request.getParameter("endwpname"); 
String pwptype = request.getParameter("wptype")==null?"":request.getParameter("wptype"); 
String startwptype = request.getParameter("startwptype")==null?"":request.getParameter("startwptype"); 
String endwptype = request.getParameter("endwptype")==null?"":request.getParameter("endwptype"); 
   %>

<%
 HashMap mmm = new HashMap();%> 

&nbsp;&nbsp;
货物货号 
&nbsp;:&nbsp; 
<input type=text class=''  size=20 name='wpno' />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

&nbsp;&nbsp;
货物名称 
&nbsp;:&nbsp; 
<input type=text class=''  size=20 name='wpname' />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
货物类别 
&nbsp;:&nbsp; 
<%=Info.getselect("wptype","wptypes","tname"," 1=1 ")%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 

<input type=submit class='' value='查询信息' />
 &nbsp;&nbsp;
 
&nbsp;&nbsp;</td>
            </tr>
        
        
        
          <tr>
            <td   height="28" background="/productsys/admin/tab/images/bg.png" bgcolor="#FFFFFF" align="center" class="STYLE1">货物货号  </td>
<td   height="28" background="/productsys/admin/tab/images/bg.png" bgcolor="#FFFFFF" align="center" class="STYLE1">货物名称  </td>
<td   height="28" background="/productsys/admin/tab/images/bg.png" bgcolor="#FFFFFF" align="center" class="STYLE1">单位  </td>
<td   height="28" background="/productsys/admin/tab/images/bg.png" bgcolor="#FFFFFF" align="center" class="STYLE1">货物类别  </td>
<td   height="28" background="/productsys/admin/tab/images/bg.png" bgcolor="#FFFFFF" align="center" class="STYLE1">预警上限  </td>
<td   height="28" background="/productsys/admin/tab/images/bg.png" bgcolor="#FFFFFF" align="center" class="STYLE1">预警下限  </td>
<td   height="28" background="/productsys/admin/tab/images/bg.png" bgcolor="#FFFFFF" align="center" class="STYLE1">当前数量 </td>
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
 if(!pwpno.equals("")){ 
 sql+= " and wpno like'%"+pwpno+"%' " ;
 }  
 if(!startwpno.equals("")){  
 mmm.put("startwpno",startwpno) ;
 sql+= " and wpno >'"+startwpno+"' " ;
 }  
 if(!endwpno.equals("")){  
 mmm.put("endwpno",endwpno) ;
 sql+= " and wpno <'"+Info.getDay(endwpno,1)+"' " ;
 }  
 if(!pwpname.equals("")){ 
 sql+= " and wpname like'%"+pwpname+"%' " ;
 }  
 if(!startwpname.equals("")){  
 mmm.put("startwpname",startwpname) ;
 sql+= " and wpname >'"+startwpname+"' " ;
 }  
 if(!endwpname.equals("")){  
 mmm.put("endwpname",endwpname) ;
 sql+= " and wpname <'"+Info.getDay(endwpname,1)+"' " ;
 }  
 if(!pwptype.equals("")){ 
 sql+= " and wptype like'%"+pwptype+"%' " ;
 }  
 if(!startwptype.equals("")){  
 mmm.put("startwptype",startwptype) ;
 sql+= " and wptype >'"+startwptype+"' " ;
 }  
 if(!endwptype.equals("")){  
 mmm.put("endwptype",endwptype) ;
 sql+= " and wptype <'"+Info.getDay(endwptype,1)+"' " ;
 }  
  sql +=" order by id desc ";
String url = "kcpd.jsp?1=1&wpno="+pwpno+"&wpname="+pwpname+"&wptype="+pwptype+""; 
ArrayList<HashMap> list = PageManager.getPages(url,5, sql, request ); 
for(HashMap map:list){ 
String spno = map.get("wpno").toString();
int rk = new CommDAO().getInt("select sum(nnum) from wpcrinfo where wpno='"+spno+"' and optype='入库'");
%>
<tr>

            <td height="30" valign="middle" bgcolor="#FFFFFF" class="STYLE1" align="center"><%=map.get("wpno")%></td>
            <td height="30" valign="middle" bgcolor="#FFFFFF" class="STYLE1" align="center"><%=map.get("wpname")%></td>
            <td height="30" valign="middle" bgcolor="#FFFFFF" class="STYLE1" align="center"><%=map.get("danwei")%></td>
            <td height="30" valign="middle" bgcolor="#FFFFFF" class="STYLE1" align="center"><%=map.get("wptype")%></td>
            <td height="30" valign="middle" bgcolor="#FFFFFF" class="STYLE1" align="center"><%=map.get("maxnum")%></td>
            <td height="30" valign="middle" bgcolor="#FFFFFF" class="STYLE1" align="center"><%=map.get("minum")%></td>
            <td height="30" valign="middle" bgcolor="#FFFFFF" class="STYLE1" align="center">
 <%=rk%> 
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
<% 
mmm.put("wpno",pwpno); 
mmm.put("wpname",pwpname); 
mmm.put("wptype",pwptype); 
%>
<%=Info.tform(mmm)%> 
<script language=javascript >  
 
</script>  
<%=Info.tform(mmm)%> 
<script language=javascript src='/productsys/js/My97DatePicker/WdatePicker.js'></script>
<script language=javascript src='/productsys/js/popup.js'></script>
<script language=javascript> 
function update(no){ 
pop('wpjbxxxg.jsp?id='+no,'信息修改',550,'100%') 
}
</script> 
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
