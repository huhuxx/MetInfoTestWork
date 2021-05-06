package edu.hxy.select;


import static org.testng.Assert.fail;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.hc.core5.http.ParseException;

import com.inter.controller.HttpDriver;
import com.mysql.jdbc.PreparedStatement;

import edu.hxy.string.GetRowcount;
import edu.hxy.string.ToString;
import freemarker.template.TemplateException;
import net.sf.json.JSONObject;



/**
 * Servlet implementation class TestServlet
 */
@WebServlet(description = "运行用例", urlPatterns = { "/RunCaseServlet"})
public class RunCaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RunCaseServlet() {
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
		int successNum = 0;
		int failNum = 0;
		int allNum = 0;
		try {
			allNum = GetRowcount.getRowcount("caseManage");
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		
		//连接数据库
		String driverStr="com.mysql.jdbc.Driver";
		String connUrl = "jdbc:mysql://localhost:3306/implementTest?useUnicode=true&characterEncoding=utf-8";
		try {
			Class.forName(driverStr);
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(connUrl,"root","123456");
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	    ResultSet resultSet = null;  
	    JSONObject responseResult = null;
	    //读取数据
		try {
			if(!conn.isClosed()){
				String sql = "select * from caseManage";  
				PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
			    resultSet = pstmt.executeQuery(sql);     
			    while(resultSet.next()) {
			    	 String caseName = resultSet.getString("caseName");  
			    	 String environment = resultSet.getString("environment");
			    	 String url = resultSet.getString("implement");
			    	 String requestText = resultSet.getString("requestTest");
			    	 String reqMethod = resultSet.getString("requestMethod");
//			    	 String dataStyle=resultSet.getString("dataStyle");
			    	 int id=resultSet.getInt("caseId");
			    	 System.out.println(id);
			    	 System.out.println(caseName);
			    	 System.out.println(environment);
			    	 System.out.println("url:"+url);
			    	 System.out.println("reqText:"+requestText);//输出请求信息
			    	 
			    	 //调用方法、运行测试用例
		 			if (reqMethod.equals("get")&&requestText==null) {
		 				responseResult = HttpDriver.doGet(url);
		 			}else if (reqMethod.equals("post") && requestText!=null) {
		 				responseResult = HttpDriver.doPost(url, requestText);
		 			} else if (reqMethod.equals("get") && requestText!=null) {
		 				responseResult = HttpDriver.doGet(url + requestText);
		 			}else if (reqMethod.equals("put") && requestText!=null) {
		 				responseResult = HttpDriver.doPut(url , requestText);
		 			}else if (reqMethod.equals("delete") && requestText!=null) {
		 				responseResult = HttpDriver.doDelete(url);
			 		}
		 			Integer respCode=(Integer)responseResult.get("code");
		 			
		 			//统计用例执行情况
		 			if(respCode.equals(200)) {
		 				successNum++;
		 			}else {
						failNum++;
					}
		 	
//		 			System.out.println("respCode:"+responseResult.get("code"));
//			    	System.out.println("响应结果："+responseResult.toString());
			 			
			    }
//			    System.out.println("总数："+allNum);
//	 			System.out.println("成功："+successNum);
//	 			System.out.println("失败："+failNum);
			}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	

		HttpSession session=request.getSession(true); 
		session.setAttribute("allNum", allNum);
		session.setAttribute("successNum", successNum);
		session.setAttribute("failNum", failNum);
		
		//发送邮件
		try {
			TestFreemarker.sendMails(allNum, successNum, failNum);//发送邮件
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("caseManage.jsp");
	}

}
