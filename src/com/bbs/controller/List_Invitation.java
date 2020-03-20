package com.bbs.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbs.pojo.ClientInvitation; 
import com.bbs.service.ClientService;
 
@WebServlet("/list_invitation")
public class List_Invitation extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	private ClientService clientService=new ClientService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8"); 
		//接收plateId
		String splateId=request.getParameter("plateId");
		Integer plateId=null;
		if(splateId.)
		// 查询数据库，获取到所有版块的列表
		List<ClientInvitation> plates = clientService.listInvitations(plateId);
		response.sendRedirect("${pageContext.request.contextPath}/index");
		return;
	} 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
