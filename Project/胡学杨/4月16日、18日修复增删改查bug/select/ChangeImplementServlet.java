package edu.hxy.select;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.hxy.database.UpdateImplementTable;
import edu.hxy.string.ToString;


/**
 * Servlet implementation class TestServlet
 */
@WebServlet(description = "修改接口", urlPatterns = { "/ChangeImplementServlet" })
public class ChangeImplementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeImplementServlet() {
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
		int implementId = Integer.parseInt(String.valueOf(request.getParameter("TimplementId")));
		String implementName = ToString.toString(request.getParameter("implementName"));
		String environment = ToString.toString(request.getParameter("environment"));
		String requestStyle = request.getParameter("requestStyle");
		String dataStyle = request.getParameter("dataStyle");
		String requestUrl = ToString.toString(request.getParameter("url"));
		try {
			UpdateImplementTable.changeImplement(implementId,implementName,environment,requestStyle,dataStyle,requestUrl);
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
