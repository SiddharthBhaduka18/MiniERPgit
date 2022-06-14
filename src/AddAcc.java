

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddAcc
 */
public class AddAcc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAcc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
			DbConnection db = new DbConnection();
			Connection con = db.connect();
			String uAccNum = request.getParameter("id");
			String uName = request.getParameter("name");
			String uemail = request.getParameter("salary");
			String upwd = request.getParameter("department");
			String s = "insert into acc values(?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(s);
			pstmt.setString(1, uAccNum);
			pstmt.setString(2, uName);
			pstmt.setString(3, uemail);
			pstmt.setString(4, upwd);
			int i = pstmt.executeUpdate();
			if(i>0)
			{
				response.sendRedirect("AccLogin.html");					
			}
			else
			{
				response.sendRedirect("index.html");									
			}
//			else
//			{
//				response.sendRedirect("createremind.html");	
//			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
