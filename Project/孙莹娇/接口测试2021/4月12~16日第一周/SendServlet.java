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
 * 发送请求
 * @author sunyingjiao
 */
@WebServlet("/req/SendServlet")
public class SendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SendServlet() {
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
		String btnValue=request.getParameter("raw");
		
		//ServletContext保存内容，再传给响应页面
		ServletContext context = this.getServletContext();
		JSONObject result = null;
		context.setAttribute("reqMethod",reqMethod);
		context.setAttribute("url",url);
		context.setAttribute("json",json);
		context.setAttribute("btnValue", btnValue);
		
		System.out.println("传到DO的方法:"+reqMethod);
		System.out.println("传到DO的url:"+url);
		System.out.println("传到DO的json:"+json);
		System.out.println("传到DO的btnValue:"+btnValue);
		try {	
			if (reqMethod.equals("get")&&json==null) {
				result = HttpDriver.doGet(url);
			} else if (reqMethod.equals("post") && json!=null) {
				result = HttpDriver.doPost(url, json);
			} else if (reqMethod.equals("get") && json!=null) {
				result = HttpDriver.doGet(url + json);
			}else if (reqMethod.equals("put") && json!=null) {
				result = HttpDriver.doPut(url , json);
			}else if (reqMethod.equals("delete") && json!=null) {
				result = HttpDriver.doDelete(url);
			}
			context.setAttribute("result",result.toString());
			if (reqMethod.equals("get")) {
				response.sendRedirect("/Demo2020/interface_test_param.jsp");
			}else {
				response.sendRedirect("/Demo2020/interface_Test.jsp");
			}
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
