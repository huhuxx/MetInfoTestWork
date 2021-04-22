package com.inter.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inter.entity.InterfaceRecord;
import com.inter.entity.Page;
import com.inter.service.InterServiceImpl;

/**
 * Servlet implementation class InterfaceServlet
 */
@WebServlet("/interfaceList")
public class InterfaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InterfaceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page1 = request.getParameter("page");
		String tableName="implementManage";
		int pageNum = 1, pageSize = 10;
		//第一次加载第一页的时候page1为空,pageNum默认为1,查询第一页内容
		//之后点“下一页”的时候，page1不为空，此时赋值给pageNum
		if(page1!=null && !page1.equals("")) {
			pageNum = Integer.parseInt(page1);
		}
		
		InterServiceImpl interServiceImpl=new InterServiceImpl();
		//查询第pageNum页的pageSize条记录并保存在page对象
		Page<InterfaceRecord> page=interServiceImpl.listByPage(pageNum, pageSize,tableName);
		//设置参数page
		request.setAttribute("page", page);
		//转发给jsp页面，并将page对象传递过去
		request.getRequestDispatcher("/interfaceManage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
