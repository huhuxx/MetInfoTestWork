package edu.hxy.select;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet(description = "我的第一个servlet", urlPatterns = { "/TestServlet" })
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		String str = "{\"name\":\"" + name + "\",\"sex\":\"" + sex + "\",\"age\":" + age + "}";
		response.getWriter().write(str);
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String account = request.getParameter("account");
		String psd = request.getParameter("psd");
		if(account.equals("admin") && psd.equals("123456")) {
			request.getRequestDispatcher("test1.jsp").forward(request, response);
		}else if(account.equals("admin") && !psd.equals("123456")) {
			request.setAttribute("psdErrorString", "password is error");
			request.getRequestDispatcher("test.jsp").forward(request, response);
		}else if(!account.equals("admin") && psd.equals("123456")) {
			request.setAttribute("accountErrorString", "account is error");
			request.getRequestDispatcher("test.jsp").forward(request, response);
		}else {
			request.setAttribute("errorString", "login error");
			request.getRequestDispatcher("test.jsp").forward(request, response);
		}
	}

}
