package com.bai.controll;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bai.bean.Person;
import com.bai.dao.PersonDao;
import com.bai.dao.PersonDaoImpl;
import com.sun.xml.internal.bind.v2.model.core.ID;

@WebServlet("/Yhglupdate")
public class YhglUpdateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		//值传递
		req.setCharacterEncoding("utf-8");
	
		String idStr = req.getParameter("id");
		String name = req.getParameter("name");
		int id = Integer.parseInt(idStr);
		System.out.println(id + "---------------------");
		
		req.getSession().setAttribute("id", id);
		req.getSession().setAttribute("name", req.getParameter("name"));
		req.getSession().setAttribute("password",req.getParameter("password"));
		req.getSession().setAttribute("email",req.getParameter("email"));
		req.getSession().setAttribute("tright", req.getParameter("tright"));
		
		req.getRequestDispatcher("UpdatePerson.jsp").forward(req, resp);
		System.out.println("doget()");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		//接收修改值，并返回到用户管理JSP页面
		req.setCharacterEncoding("utf-8");
		PersonDao personDao = new PersonDaoImpl();
		Object[] personMsg = new Object[6];
		System.out.println("修改后的id是"+req.getParameter("id"));
		Object oldname = req.getSession().getAttribute("name");
		personMsg[0] = req.getParameter("id");
		personMsg[1] = req.getParameter("name");
		personMsg[2] = req.getParameter("password");
		personMsg[3] = req.getParameter("email");
		personMsg[4] = req.getParameter("tright");
		personMsg[5] = req.getSession().getAttribute("name");
		personDao.updata(personMsg);
		req.getRequestDispatcher("Yhgl.jsp").forward(req, resp);
		System.out.println("dopost()");
	}

}
