package edu.hxy.select;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.hxy.database.UpdateImplementTable;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet(description = "删除接口", urlPatterns = { "/DeleteImplementServlet" })
public class DeleteImplementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteImplementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("1111111111111111111111111111111111111111111111111111111");
		int TimplementId = Integer.parseInt(String.valueOf(request.getParameter("TimplementId")));
		int IimplementId = Integer.valueOf(request.getParameter("IimplementId"));
		
		System.out.println("第一个"+TimplementId);
		System.out.println("第二个"+IimplementId);
		try {
			if(TimplementId==IimplementId) {
				UpdateImplementTable.deleteImplement(IimplementId);
			}
			else {
				System.out.println("输入id不符");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("/implementManage.jsp").forward(request,response);
	}

}
