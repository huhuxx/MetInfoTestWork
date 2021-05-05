package edu.hxy.select;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.hxy.database.UpdateImplementTable;
import edu.hxy.string.GetRowcount;
import edu.hxy.string.ToString;


/**
 * Servlet implementation class TestServlet
 */
@WebServlet(description = "查询接口", urlPatterns = { "/FindImplementServlet" })
public class FindImplementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindImplementServlet() {
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
		String implementName =ToString.toString(request.getParameter("implementName"));
		String environment = "'"+ToString.toString(request.getParameter("environment"))+"'";
		String requestStyle ="'" +ToString.toString(request.getParameter("requestStyle"))+"'";
		String dataStyle = "'" +ToString.toString(request.getParameter("dataStyle"))+"'";
		String sql1=null;
		String sql2=null;
		String sql3=null;
		String sql4=null;
			
		String sql = null;

		if(environment.equals("'全部'")) {
			environment="environment";
		}
		if(requestStyle.equals("'全部'")) {
			requestStyle="requestStyle";
		}
		if(dataStyle.equals("'全部'")) {
			dataStyle="dataStyle";
		}
//		if(implementName.equals("全部")) {
//			sql = "SELECT * from implementManage where  environment="+environment+" and requestStyle="+requestStyle+" and dataStyle="+dataStyle+" order by implementId limit ?, ?;";
//		}
	 	sql = "SELECT * from implementManage where implementName like '%"+implementName+"%' and environment="+environment+" and requestStyle="+requestStyle+" and dataStyle="+dataStyle+" order by implementId limit ?, ?;";
		
		HttpSession session=request.getSession(true); 
		session.setAttribute("sql", sql);
		
		request.getRequestDispatcher("interfaceList").forward(request,response);
	}

}
