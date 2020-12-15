package com.bai.controll;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bai.dao.PersonDao;
import com.bai.dao.PersonDaoImpl;
@WebServlet("/Yhgladd")
public class YhglAddServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		System.out.println("doget()");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		//增加
		req.setCharacterEncoding("utf-8"); 
		PersonDao personDao = new PersonDaoImpl();
		Object[] personMsg = new Object[8];
		String id1 = req.getParameter("id");
		String name1 = req.getParameter("name");
		String password1 = req.getParameter("password");
		String email1 = req.getParameter("email");
		String tright1 = req.getParameter("tright");
		
		System.out.println(req.getParameter("id"));
	
		personMsg[0] = id1;
		personMsg[1] = name1;
		personMsg[2] = password1;
		personMsg[3] = new Date();
		personMsg[4] = null;
		personMsg[5] = email1;
		personMsg[6] = 0;
		personMsg[7] = tright1;
		personDao.save(personMsg);
		req.getRequestDispatcher("Yhgl.jsp").forward(req, resp);
		System.out.println("dopost()");
	}

}
