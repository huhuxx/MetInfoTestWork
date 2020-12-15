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

@WebServlet("/Yhgldelete")
public class YhglDeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		//删除，并到用户管理页面
		req.setCharacterEncoding("utf-8");
		PersonDao personDao = new PersonDaoImpl();
		Object[] personMsg = new Object[1];
		Object name = req.getParameter("name");
		personMsg[0] = name;
		personDao.delete(personMsg);
		req.getRequestDispatcher("Yhgl.jsp").forward(req, resp);
		System.out.println("doget()");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		//接收修改值，并返回到用户管理JSP页面
		
		System.out.println("dopost()");
	}

}
