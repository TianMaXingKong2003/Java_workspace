<%@ page language="java" contentType="text/html; charset=gbk" errorPage=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="gbk">
<title>��¼</title>

<script>
    /*
    ��������������ӻ���ͼƬ����Ҫ��һ��
        1.�������Ӻ�ͼƬ�󶨵����¼�

        2.��������ͼƬ��src����ֵ
	 */

	 window.onload = function(){
	        //1.��ȡͼƬ����
	        var img = document.getElementById("checkcode");
	        //2.�󶨵����¼�
	        img.onclick = function(){
	            //��ʱ���
	            var date = new Date().getTime();
                img.src = "/TomcatStudy/CheckCodeServlet?"+date;
            }
	 }
    
</script>

<style>
<!--
div {
	color: red;
}
-->
</style>

</head>
<body>

<form action="/TomcatStudy/LoginServlet" method="post">
        <table>
            <tr>
                <td>�û���</td>
                <td><input type="text" name="username" placeholder="�������û���" ></td>
            </tr>
            <tr>
                <td>����</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td>��֤��</td>
                <td><input type="text" name="checkCode"></td>
            </tr>
            <tr>
                <td colspan="2"><img id="checkcode" src="/TomcatStudy/CheckCodeServlet" />
                    <a id="change" href="">�����廻һ�ţ�</a>
                </td>
            </tr>
            <tr>
                <td><input type="submit" value="��¼"></td>
            </tr>
        </table>        
        
    </form>
    
    <div><%=request.getAttribute("login_error")==null?"":request.getAttribute("login_error")%></div>
    <div><%= request.getAttribute("checkCode_error")==null?"":request.getAttribute("checkCode_error")%></div>
   
    
</body>
</html>