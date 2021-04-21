package edu.hxy.select;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.hxy.database.UpdateEnvironmentTable;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet(description = "删除环境", urlPatterns = { "/DeleteEnvironmentServlet" })
public class DeleteEnvironmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteEnvironmentServlet() {
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
		int TenvironmentId = Integer.parseInt(String.valueOf(request.getParameter("TenvironmentId")));
		int IenvironmentId = Integer.valueOf(request.getParameter("IenvironmentId"));
		System.out.println(TenvironmentId + "MMM" + IenvironmentId);
		try {
			if(TenvironmentId==IenvironmentId) {
				UpdateEnvironmentTable.deleteEnvironment(IenvironmentId);
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
		request.getRequestDispatcher("/environmentManage.jsp").forward(request,response);
	}

}
