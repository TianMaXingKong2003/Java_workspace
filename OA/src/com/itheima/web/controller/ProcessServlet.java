package com.itheima.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.commons.Page;
import com.itheima.domain.Apply;
import com.itheima.service.ApplyService;
import com.itheima.service.impl.ApplyServiceImpl;
//后台处理申请有关
public class ProcessServlet extends HttpServlet {
	private ApplyService applyService = new ApplyServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = request.getParameter("op");
		if("listApplys".equals(op)){
			listApplys(request,response);
		}else if("passApply".equals(op)){
			passApply(request,response);
		}else if("closeApply".equals(op)){
			closeApply(request,response);
		}
	}
	//只是更改申请状态
	private void passApply(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		String number = request.getParameter("number");
		Apply apply = applyService.findApplyByNumber(number);
		apply.setStatus("申请审批通过");
		applyService.update(apply);
		request.setAttribute("message", "处理成功!");
		request.getRequestDispatcher("/manage/message.jsp").forward(request, response);
	}
	//把申请关闭，成功改为false
	private void closeApply(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		String number = request.getParameter("number");
		Apply apply = applyService.findApplyByNumber(number);
		apply.setClosed(true);
		apply.setSuccessed(false);
		apply.setStatus("申请已关闭");
		applyService.update(apply);
		request.setAttribute("message", "处理成功!");
		request.getRequestDispatcher("/manage/message.jsp").forward(request, response);
	}
	//列出待审批的申请：默认列出没有关闭的申请.分查询
	private void listApplys(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取用户要看的页码
		String num = request.getParameter("num");
		Page page = applyService.findAllNotClosedApplys(num);
		page.setUri("/manage/ProcessServlet?op=listApplys");
		request.setAttribute("page", page);
		request.getRequestDispatcher("/manage/listApplys.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
