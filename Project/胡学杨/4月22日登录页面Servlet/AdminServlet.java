package edu.hxy.select;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.hxy.database.UserTable;
import edu.hxy.string.ToString;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet(description = "登录", urlPatterns = { "/AdminServlet" })
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String iname = ToString.toString(request.getParameter("name"));
		String ipassword = ToString.toString(request.getParameter("password"));	
		int i = 0;
		try {
			i=UserTable.username(iname, ipassword);
	//		System.out.print(i);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpSession session=request.getSession(true); 
		session.setAttribute("name", iname);
//		int successNum = 10;
//		int failNum = 10;
//		session.setAttribute("successNum", successNum);
//		session.setAttribute("failNum", failNum);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8;");
		if(i==0) {

			response.getWriter().write("<script>history.go(-1);alert('用户名不存在');</script>");
		}else if(i==1) {
			try {
				UserTable.setUserTime(iname);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("/ThemeManageServlet").forward(request,response);		
		}else if(i==-1) {
//			System.out.println("密码错误");
			response.getWriter().write("<script>history.go(-1);alert('密码错误');</script>");
		}
	}

}
