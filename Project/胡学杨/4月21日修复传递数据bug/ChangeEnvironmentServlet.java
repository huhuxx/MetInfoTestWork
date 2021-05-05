package edu.hxy.select;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.hxy.database.UpdateEnvironmentTable;
import edu.hxy.string.ToString;


/**
 * Servlet implementation class TestServlet
 */
@WebServlet(description = "修改环境", urlPatterns = { "/ChangeEnvironmentServlet" })
public class ChangeEnvironmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeEnvironmentServlet() {
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
		
		int environmentId = Integer.parseInt(String.valueOf(request.getParameter("TenvironmentId")));
		String environmentName = ToString.toString(request.getParameter("environmentName"));
		String URL = ToString.toString(request.getParameter("url"));
		String project = ToString.toString(request.getParameter("project"));
		try {
			UpdateEnvironmentTable.changeEnvironment(environmentId,environmentName,URL,project);
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