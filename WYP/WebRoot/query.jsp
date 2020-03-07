<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,wyp.bean.*,wyp.service.imp.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="css/base.css" />
<link rel="stylesheet" href="css/info-mgt.css" />
<link rel="stylesheet" href="css/WdatePicker.css" />
<title>求职招聘网站</title>
<style type="text/css">
	a:link {
 	font-size: 12px;
 	color: #000000;
	text-decoration: none;
	}
	a:visited {
	font-size: 12px;
	color: #000000;
 	text-decoration: none;
	}
	a:hover {
 	font-size: 12px;
 	color: #999999;
 	text-decoration: none;
	}
</style>
</head>

<body>
<% 	//第一次进query.jsp页面，显示所有公司的招聘信息
	if(request.getParameter("source")==null)
	{	
		List<Company> companies = new ICompanyServiceImp().listAllCompanies();
		application.setAttribute("companies", companies);
	}
%>
<div class="title"><h2>职位搜索</h2></div>
<div class="query">
<form method="post" action="listServlet">
	<div class="query-conditions ue-clear">
        <div class="conditions name ue-clear">
            <label>职位类别：</label>
            <select name="trade" style="width:200px;height:28px;border:1px solid #C5D6E0">
            	<option value="">不限</option>
               	<option>软件工程师</option>
            	<option>会计</option>
            	<option>文员</option>
            	<option>客户经理</option>
            	<option>网站策划</option>
            	<option>平面设计师</option>
            </select>
        </div>
        <div class="conditions operate-time ue-clear">
            <label>薪资范围：</label>
            <div class="select-wrap">
               <select name="salary" style="width:200px;height:28px;border:1px solid #C5D6E0">
                	<option value="">不限</option>
        			<option >3000-4000</option>
            		<option >4000-5000</option>
                  	<option >5000-6000</option>
                  	<option >6000-7000</option>
            		<option >7000-8000</option>
            		<option >8000以上</option>
            		<option >工资面议</option>
            	</select>
            </div>
        </div>
        <div class="conditions time ue-clear">
            <label>截止时间：</label>
            <div class="time-select">
            	<input name="pubtime" type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
                <i class="icon"></i>
            </div>
        </div>
        <!--注意！传递type参数  -->
        <input name="type" type="hidden" value="个人">
    </div>
    <div class="query-btn ue-clear">
		<input style="background-color:#68B86C;color:white;border-radius:10px" type="submit" value="查询"/>
		<input style="background-color:#EFF6FA;color:black;border-radius:10px" type="reset" value="清空"/>    
	</div>
</form>
</div>
<div class="table-box">
	<table>
    	<thead>
        	<tr>
            	<th class="num">序号</th>
                <th class="name">公司名称</th>
                <th class="process">职位需求</th>
                <th class="node">薪资</th>
                <th class="node">联系方式</th>
                <th class="node">操作</th>
            </tr>
        </thead>
        <tbody>
			<c:forEach items="${companies }" var ="company"  begin="0" varStatus="status">  
				<tr>
            		<td class="num">${status.count }</td>
                	<td class="name">${company.name}</td>
                	<td class="node">${company.trade}</td>
                	<td class="node">${company.salary}</td>
                	<td class="node">${company.phone}</td>
                	<td class="node">
        				<a style="color:blue" href="info.jsp?id=${company.id }" target="_blank">详细信息</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                		<a style="color:red" href="applyServlet?p_id=${person.id}&c_id=${company.id }">我要申请</a>
                	</td>
            	</tr>
      		</c:forEach>  
        </tbody>
    </table>
</div>
<div class="pagination ue-clear"></div>
</body>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/WdatePicker.js"></script>
<!--  <script type="text/javascript" src="js/jquery.pagination.js"></script>-->
<!--<script type="text/javascript">
 $('.pagination').pagination(100,{
	callback: function(page){
	},
	display_msg: true,
	setPageNo: true
});
</script>-->
<script type="text/javascript">
$("tbody").find("tr:odd").css("backgroundColor","#eff6fa");

showRemind('input[type=text], textarea','placeholder');
</script>
</html>