package com.Interface.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Interface.entity.Request;
import com.Interface.service.ReqServiceImpl;

/**
 * Servlet implementation class AddRequest
 */
@WebServlet("/req/add")
public class AddRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String requestMehthod=request.getParameter("selectReqMehthod");
		String url=request.getParameter("url");
		Request req=new Request();
		req.setRequestMethod(requestMehthod);
		req.seturl(url);
		System.out.println(requestMehthod);
		System.out.println(url);
		boolean isSave= new ReqServiceImpl().addRequest(req);
		if (isSave) {
//			request.getRequestDispatcher("/interfice.jsp").forward(request,response);
			response.sendRedirect("/InterfaceTest/interfice.jsp");
		}
		
	}

}
