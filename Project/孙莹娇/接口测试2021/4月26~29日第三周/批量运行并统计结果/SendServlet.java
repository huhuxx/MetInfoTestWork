package com.inter.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.hc.client5.http.cookie.CookieStore;
import org.apache.hc.core5.http.ParseException;
import org.apache.jasper.tagplugins.jstl.core.ForEach;

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
		
		String key = request.getParameter("paramKey");
		String value = request.getParameter("paramValue");
		String addBtnCount = request.getParameter("addBtn");
		
		//ServletContext保存内容，再传给响应页面
		ServletContext context = this.getServletContext();
		JSONObject result = null;
		context.setAttribute("reqMethod",reqMethod);
		context.setAttribute("url",url);
		context.setAttribute("json",json);
		context.setAttribute("btnValue", btnValue);
		context.setAttribute("param_key",key);
		context.setAttribute("param_value", value);
		context.setAttribute("addBtn",addBtnCount );
		
//		System.out.println("传到SendServlet的方法:"+reqMethod);
//		System.out.println("传到SendServlet的url:"+url);
//		System.out.println("传到SendServlet的json:"+json);
//		System.out.println("传到SendServlet的btnValue:"+btnValue);
		System.out.println("addBtn"+addBtnCount);

		try {					
	
			if(reqMethod.equals("get")) {
				//将key和value值分别保存在字符数组中
				String[] keyArrays=request.getParameterValues("paramKey");
				String[] valueArrays=request.getParameterValues("paramValue");
				//构造url中的的参数部分
				StringBuilder getParam=new StringBuilder(20);
				getParam.append("?");
				for(int i=0; i<keyArrays.length;i++) {
					
					getParam.append(keyArrays[i]+"="+valueArrays[i]);
					if (i!=keyArrays.length-1) {
						getParam.append("&");
					}
				}
				System.out.println("getParam:"+getParam);
				
				if(key.equals("null")||key.isEmpty()){
					result = HttpDriver.doGet(url);
				}else if(!key.equals("null")||!key.isEmpty()) {
					result = HttpDriver.doGet(url,getParam.toString());
				}
			}else if (reqMethod.equals("post") && json!=null) {
				result = HttpDriver.doPost(url, json);
			}else if (reqMethod.equals("put") && json!=null) {
				result = HttpDriver.doPut(url , json);
			}else if (reqMethod.equals("delete") && json!=null) {
				result = HttpDriver.doDelete(url);
			}
			context.setAttribute("result",result.toString());
			if (reqMethod.equals("get")) {
				response.sendRedirect("/MyFristServlet/interface_testParam.jsp");
			}else {
				response.sendRedirect("/MyFristServlet/interfaceTest.jsp");
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
