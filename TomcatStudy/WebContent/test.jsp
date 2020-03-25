<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>主页+登录</title>
<link href="css/css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="scripts/jquery-1.4.1-vsdoc.js"></script>
<script src="scripts/input.js" type="text/javascript"></script>
<script src="scripts/tooltip.js" type="text/javascript"></script>
<script type="text/javascript">
function checkform(){
	var name = document.getElementById("userName").value;
	var pwd = document.getElementById("pwd").value;
	var code = document.getElementById("code").value;
	if(name.length<=0){
		alert("用户名不能为空！");
		}
	else if(pwd.length<=0){
		alert("密码不能为空！");
		}
	else if(code.length<=0){
		alert("验证码不能为空！");
		}
	else
		document.loginForm.submit();
		
}
function ccheckform(){
	var cname = document.getElementById("cuserName").value;
	var cpwd = document.getElementById("cpwd").value;
	var ccode = document.getElementById("ccode").value;
	if(cname.length<=0){
		alert("用户名不能为空！");
		}
	else if(cpwd.length<=0){
		alert("密码不能为空！");
		}
	else if(ccode.length<=0){
		alert("验证码不能为空！");
		}
	else
		document.cloginForm.submit();
		
}
        
     $(function(){
	    var $div_li =$("div.left_title ul li");
	    $div_li.click(function(){
			$(this).addClass("selected")          
				   .siblings().removeClass("selected"); 
            var index =  $div_li.index(this);  
			$("div.box_11 > div")   	 
					.eq(index).show()   
					.siblings().hide(); 
		}).hover(function(){
			$(this).addClass("hover");
		},function(){
			$(this).removeClass("hover");
			alert(index);
		});
		$("#inputSearch").keyup(function(){
		$(".liebiao ul li").hide().filter(":contains('"+($(this).val())+"')").show();
	});
	})
            
</script>
</head>
<body>
<div class="zhong">
  <div class="top">
    <div class="top_left">Logo</div>
    <div class="top_right">
      <div class="top_right_1"><a href="">设为首页</a>　|　<a href="">加入收藏</a>　|　<a href="">繁體中文</a></div>
      <div class="top_right_2"><img src="images/img_1.gif" /></div>
    </div>
    <div class="clear"></div>
  </div>
  <div class="menu">
    <div class="menusel" style="width:95px;">
      <h2><a href="index.jsp">首页</a></h2>
    </div>
    <div id="menu1" class="menusel">
      <h2><a href="">院校信息</a></h2>
      <div class="position">
        <ul class="clearfix typeul">
          <li><a href="">学院简介</a></li>
          <li><a href="">学院文化</a></li>
        </ul>
      </div>
    </div>
    <div id="menu2" class="menusel">
      <h2><a href="news.jsp">新闻信息</a></h2>
      <div class="position">
        <ul class="clearfix typeul">
        <li class="lli"><a href="">行业新闻</a></li>
        <li class="lli"><a href="">公司动态</a></li>
        </ul>
      </div>
    </div>
    
    <div id="menu4" class="menusel">
      <h2><a href="EmploymentServlet?flag=list">招聘信息</a></h2>
      <div class="position">
        <ul class="clearfix typeul">
          
        </ul>
      </div>
    </div>
    <div id="menu5" class="menusel">
      <h2><a href="ResumeServlet?flag=list">诚聘英才</a></h2>
      <div class="position">
        <ul class="clearfix typeul">
        </ul>
      </div>
    </div>
    <div id="menu6" class="menusel">
      <h2><a href="">在线留言</a></h2>
      <div class="position">
        <ul class="clearfix typeul">
          <li><a href="">发表留言</a></li>
          <li><a href="">留言列表</a></li>
          <li><a href="">留言</a></li>
          <li><a href="">建议</a></li>
          <li class="lli"><a href="">投诉</a></li>
        </ul>
      </div>
    </div>
    <div id="menu7" class="menusel">
      <h2><a href="">联系我们</a></h2>
      <div class="position">
        <ul class="clearfix typeul">
        </ul>
      </div>
    </div>
  </div>
  <%
	String userName = (String)session.getAttribute("userName");
	if(userName==null){
%>
	<div class="main">
    <div class="left">
      <div class="box_1">
        <div class="left_title">
        <ul>
        	<li class="selected">会员中心</li>
        	<li>|</li>
        	<li>企业会员</li>
        </ul>
        </div>
       <div class="box_11">
      <div>
      <form id="form1" name="loginForm" method="post" action="LoginServlet" >
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="32%" height="37" valign="middle">用户名：</td>
            <td width="68%" valign="middle">
              <input type="text" name="userName" id="userName" class="input_1"/>
            </td>
          </tr>
          <tr>
            <td height="37" valign="middle">密　码：</td>
            <td valign="middle">
              <input type="text" name="pwd" id="pwd" class="input_2"/>
            </td>
          </tr>
          <tr>
            <td height="37" valign="middle">验证码：</td>
            <td valign="middle">
              <input type="text" name="verifyCode" id="code" class="input_3" style="float:left"/>
              <span style="float:left; margin-left:6px;"><img src="VerifyCodeServlet" /></span></td>
          </tr>
          <tr>
            <td colspan="2">
              <img src="images/img_4.gif" onclick="javascript:checkform();"/>
              <a href="register.jsp"><img src="images/img_5.gif" style="margin:0 10px;"/></a>
              <img src="images/img_6.gif" />
            </td>
          </tr>
        </table>
        </form>
        </div>
        <div></div>
        <div class="hide">
      <form id="form1" name="cloginForm" method="post" action="CLoginServlet" >
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="32%" height="37" valign="middle">企业名：</td>
            <td width="68%" valign="middle">
              <input type="text" name="cuserName" id="cuserName" class="input_1"/>
            </td>
          </tr>
          <tr>
            <td height="37" valign="middle">密　码：</td>
            <td valign="middle">
              <input type="text" name="cpwd" id="cpwd" class="input_2"/>
            </td>
          </tr>
          <tr>
            <td height="37" valign="middle">验证码：</td>
            <td valign="middle">
              <input type="text" name="cverifyCode" id="ccode" class="input_3" style="float:left"/>
              <span style="float:left; margin-left:6px;"><img src="VerifyCodeServlet" /></span></td>
          </tr>
          <tr>
            <td colspan="2">
              <img src="images/img_4.gif" onclick="javascript:ccheckform();"/>
              <a href="register.jsp"><img src="images/img_5.gif" style="margin:0 10px;"/></a>
              <img src="images/img_6.gif" />
            </td>
          </tr>
        </table>
        </form>
        </div>
        </div>
        </div>
    <%}else{ 	%>
        <div class="meun_2">欢迎您：<%=userName %> 您上次登陆的时间为 2009-04-10 07：50 <a href="LogoutServlet">退出</a></div>
        <div class="main">
        <div class="left">
   <%}%>
      <div class="box_1">
        <div class="left_title">本站公告</div>
        <div class="left_nr">
          <ul>
            <li><a href="#" class="tooltip" title="[活动] 伊伴春鞋迎春大促">滚动滚动滚动滚动</a></li>
            <li><a href="">穿透内网文件传输</a></li>
            <li><a href="">网络版本的个人资料库</a></li>
            <li><a href="">强大的手机短信双向功能</a></li>
          </ul>
        </div>
      </div>
      <div class="box_1" style="margin:0px;">
        <div class="left_title">产品分类</div>
        <div class="left_nr">
          <ul>
            <li><a href="">WEB信息发布系列</a></li>
            <li><a href="">WEB信息发布系列</a></li>
            <li><a href="">WEB信息发布系列</a></li>
          </ul>
        </div>
      </div>
    </div>
    <div class="right">
      <div class="right_top_img">
      <div class="search">
			<input type="text" id="inputSearch" class="" value="请输入查询信息" />
		</div>
		</div>
      <img src="images/img_8.gif" style="float:left"/>
      <div class="news">
        <div class="news_title"><span><img src="images/title_1.gif" /></span><a href="http://www.mycodes.net"><img src="images/more.gif" /></a></div>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
        </table>
        <div class="liebiao">
        <ul>
          <li><a href="">昆山六丰机械最新大量招聘</a><span>2012-02-21</span></li>
          <li><a href="">电子厂质检最新招聘</a><span>2012-02-21</span></li>
          <li><a href="">客服专员助理话务员最新招</a><span>2012-02-21</span></li>
          <li><a href="">普工+苏州电子厂最新招聘</a><span>2012-02-21</span></li>
          <li><a href="">普工/寒假工苏州最新招聘</a><span>2012-02-21</span></li>
          <li><a href="">苏州最新招工信息</a><span>2012-02-21</span></li>
          <li><a href="">最新招聘寒假工+高薪</a><span>2012-02-21</span></li>
          <li><a href="">最新乘服员乘务员安检员招</a><span>2012-02-21</span></li>
          <li><a href="">最新和谐号招乘服员乘务员</a><span>2012-02-21</span></li>
          <li><a href="">保安最新高招包吃住好福利</a><span>2012-02-21</span></li>
          <li><a href="">最新安检员乘服员飞翔万里</a><span>2012-02-21</span></li>
          <li><a href="">上海地铁最新招聘包吃住</a><span>2012-11-20</span></li>
          <li><a href="">最新乘服员乘务员招聘了</a><span>2012-12-21</span></li>
          <li><a href="">好孩子最新招保安寒假工等</a><span>2012-11-21</span></li>
          <li><a href="">捷安特最新招寒假工焊工等</a><span>2012-12-21</span></li>
        </ul>
      </div>
      <div class="fanye">
        <div class="fanye_left">页次：1/1页　每页20</div>
        <div class="fanye_right">分页：<a href=""><img src="images/img_13.gif" /></a><a href="">1</a><a href=""><img src="images/img_14.gif" /></a></div>
      </div>
      </div>
      </div>
    <div class="clear"></div>
    <div class="huoban">
      <div class="huoban_title"><img src="images/title_2.gif" /></div>
      <div class="huoban_nr">
        <ul>
          <li><img src="images/huoban_logo.gif" /></li>
          <li><img src="images/huoban_logo.gif" /></li>
          <li><img src="images/huoban_logo.gif" /></li>
          <li><img src="images/huoban_logo.gif" /></li>
          <li><img src="images/huoban_logo.gif" /></li>
        </ul>
        <div class="clear"></div>
      </div>
    </div>
  </div>
  <div class="bottom">  2012-2013 </div>
</div>
<script src="js/meun.js" type="text/javascript"></script>
</body>
</html>
