<%@ page language="java" contentType="text/html; charset=gbk" errorPage=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="gbk">
<title>登录</title>

<script>
    /*
    分析：点击超链接或者图片，需要换一张
        1.给超链接和图片绑定单击事件

        2.重新设置图片的src属性值
	 */

	 window.onload = function(){
	        //1.获取图片对象
	        var img = document.getElementById("checkcode");
	        //2.绑定单击事件
	        img.onclick = function(){
	            //加时间戳
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
                <td>用户名</td>
                <td><input type="text" name="username" placeholder="请输入用户名" ></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td>验证码</td>
                <td><input type="text" name="checkCode"></td>
            </tr>
            <tr>
                <td colspan="2"><img id="checkcode" src="/TomcatStudy/CheckCodeServlet" />
                    <a id="change" href="">看不清换一张？</a>
                </td>
            </tr>
            <tr>
                <td><input type="submit" value="登录"></td>
            </tr>
        </table>        
        
    </form>
    
    <div><%=request.getAttribute("login_error")==null?"":request.getAttribute("login_error")%></div>
    <div><%= request.getAttribute("checkCode_error")==null?"":request.getAttribute("checkCode_error")%></div>
   
    
</body>
</html>