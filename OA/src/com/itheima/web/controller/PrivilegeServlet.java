package com.itheima.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.Function;
import com.itheima.domain.Role;
import com.itheima.domain.User;
import com.itheima.service.PrivilegeService;
import com.itheima.service.impl.PrivilegeServiceImpl;
import com.itheima.util.WebUtil;
//权限管理有关
public class PrivilegeServlet extends HttpServlet {
	private PrivilegeService privilegeService = new PrivilegeServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = request.getParameter("op");
		if("listFunctions".equals(op)){
			listFunctions(request,response);
		}else if("addFunction".equals(op)){
			addFunction(request,response);
		}else if("listRoles".equals(op)){
			listRoles(request,response);
		}else if("addRole".equals(op)){
			addRole(request,response);
		}else if("grantRole".equals(op)){
			grantRole(request,response);
		}else if("saveGrantRole".equals(op)){
			saveGrantRole(request,response);
		}else if("listUsers".equals(op)){
			listUsers(request,response);
		}else if("addUser".equals(op)){
			addUser(request,response);
		}else if("grantUser".equals(op)){
			grantUser(request,response);
		}else if("saveGrantUser".equals(op)){
			saveGrantUser(request,response);
		}
	}
	private void saveGrantUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		String userId = request.getParameter("userId");
		String[] roleIds = request.getParameterValues("roleId");
		if(roleIds!=null&&roleIds.length>0){
			privilegeService.grantRole2User(userId,roleIds);
		}
		request.setAttribute("message", "处理成功");
		request.getRequestDispatcher("/manage/message.jsp").forward(request, response);
	}
	private void grantUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		//根据id查询用户：查询用户同时把已经分配的角色查询出来
		String userId = request.getParameter("userId");
		User user = privilegeService.findUserById(userId);
		//查询所有的角色列表
		List<Role> roles = privilegeService.findAllRoles();
		//转向页面去显示
		request.setAttribute("user", user);
		request.setAttribute("roles", roles);
		request.getRequestDispatcher("/manage/grantUser.jsp").forward(request, response);
	}
	private void addUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		User user = WebUtil.fillBean(request, User.class);
		privilegeService.addUser(user);
		request.setAttribute("message", "添加成功");
		request.getRequestDispatcher("/manage/message.jsp").forward(request, response);
	}
	//用户列表
	private void listUsers(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		List<User> users = privilegeService.findAllUsers();
		request.setAttribute("users", users);
		request.getRequestDispatcher("/manage/listUsers.jsp").forward(request, response);
	}
	//保存功能分配
	private void saveGrantRole(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		String roleId = request.getParameter("roleId");
		String[] functionIds = request.getParameterValues("functionId");
		if(functionIds!=null&&functionIds.length>0){
			privilegeService.grantFunction2Role(roleId,functionIds);
		}
		request.setAttribute("message", "处理成功");
		request.getRequestDispatcher("/manage/message.jsp").forward(request, response);
	}
	//给角色分配功能
	private void grantRole(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//根据id查询角色：查询角色同时把已经分配的功能查询出来
		String roleId = request.getParameter("roleId");
		Role role = privilegeService.findRoleById(roleId);
		//查询所有的功能列表
		List<Function> functions = privilegeService.findAllFunctions();
		//转向页面去显示
		request.setAttribute("role", role);
		request.setAttribute("functions", functions);
		request.getRequestDispatcher("/manage/grantRole.jsp").forward(request, response);
	}
	private void addRole(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Role role = WebUtil.fillBean(request, Role.class);
		privilegeService.addRole(role);
		request.setAttribute("message", "添加成功");
		request.getRequestDispatcher("/manage/message.jsp").forward(request, response);
	}
	private void listRoles(HttpServletRequest request,
			HttpServletResponse response)  throws ServletException, IOException{
		List<Role> roles = privilegeService.findAllRoles();
		request.setAttribute("roles", roles);
		request.getRequestDispatcher("/manage/listRoles.jsp").forward(request, response);
	}
	//添加功能
	private void addFunction(HttpServletRequest request,
			HttpServletResponse response)  throws ServletException, IOException{
		Function function = WebUtil.fillBean(request, Function.class);
		privilegeService.addFunction(function);
		request.setAttribute("message", "添加成功");
		request.getRequestDispatcher("/manage/message.jsp").forward(request, response);
	}
	//列出所有的功能
	private void listFunctions(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Function> functions = privilegeService.findAllFunctions();
		request.setAttribute("functions", functions);
		request.getRequestDispatcher("/manage/listFunctions.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
