package com.Interface.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.hc.core5.http.ParseException;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class DoGetDemo
 */
@WebServlet("/req/DoGetDemo")
public class DoGetDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoGetDemo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置编码，以防中文乱码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//获取jsp页面输入的request请求内容
		String reqMethod = request.getParameter("selectReqMehthod");
		String url = request.getParameter("url");
		String json = request.getParameter("json");
		
		ServletContext context = this.getServletContext();
		JSONObject result = null;
		context.setAttribute("reqMethod",reqMethod);
		context.setAttribute("url",url);
		context.setAttribute("json",json);
		
		System.out.println("传到DO的方法"+reqMethod);
		System.out.println("传到DO的url"+url);
		System.out.println("传到DO的json"+json);
		try {	
			if (reqMethod.equals("get")&&json.equals("")) {
				result = HttpDriver.doGet(url);
			} else if (reqMethod.equals("post") && !json.equals("")) {
				result = HttpDriver.doPost(url, json);
			} else if (reqMethod.equals("get") && !json.equals("")) {
				result = HttpDriver.doGet(url + json);
			}else if (reqMethod.equals("put") && !json.equals("")) {
				result = HttpDriver.doPut(url , json);
			}else if (reqMethod.equals("delete") && !json.equals("")) {
				result = HttpDriver.doDelete(url);
			}
			context.setAttribute("result",result.toString());
			response.sendRedirect("/InterfaceTest/interfice.jsp");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
