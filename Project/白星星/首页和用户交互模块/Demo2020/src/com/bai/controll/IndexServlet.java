package com.bai.controll;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bai.bean.Api;
import com.bai.bean.Person;
import com.bai.bean.Task;
import com.bai.dao.ApiDao;
import com.bai.dao.ApiDaoImpl;
import com.bai.dao.ItemDao;
import com.bai.dao.ItemDaoImpl;
import com.bai.dao.PersonDao;
import com.bai.dao.PersonDaoImpl;
import com.bai.dao.TaskDao;
import com.bai.dao.TaskDaoImpl;
@WebServlet("/Index")
public class IndexServlet extends HttpServlet{
	private String message;

	  public void init() throws ServletException
	  {
	      // 执行必需的初始化
	      message = "Hello World";
	  }
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ApiDao api = new ApiDaoImpl();
		PersonDao person = new PersonDaoImpl();
		ItemDao item = new ItemDaoImpl();
		TaskDao task = new TaskDaoImpl();
		req.getSession().setAttribute("apinum", api.findAll().size());
		req.getSession().setAttribute("personnum", person.findAll().size());
		req.getSession().setAttribute("itemnum", item.findAll().size());
		req.getSession().setAttribute("tasknum", task.findAll().size());
		System.out.println("接口的数据"+api.findAll().size());
		System.out.println("person的数据"+person.findAll().size());
		System.out.println("task的数据"+task.findAll().size());
		System.out.println("item的数据"+item.findAll().size());
		req.getRequestDispatcher("Index.jsp").forward(req, resp);
		System.out.println("doget()");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		System.out.println("dopost()");
		
	}
	
}
