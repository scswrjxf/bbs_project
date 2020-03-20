package com.bbs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbs.pojo.ClientInvatationAnswer; 
import com.bbs.service.ClientService;
 
@WebServlet("/invitation_answer_access")
public class InvitationAnswerAccess extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	private ClientService clientService=new ClientService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 接收帖子id的值
		String invitationId = request.getParameter("invitationId");
		// 调用服务，根据invitationId查询invitation
		ClientInvatationAnswer invitation = clientService.findInvitationById(invitationId);
		// 把帖子对象放入request中
		request.setAttribute("invitation", invitation);
		request.getRequestDispatcher("invitation_answer.jsp").forward(request, response);
	} 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
