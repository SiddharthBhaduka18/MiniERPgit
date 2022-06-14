

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Sales
 */
public class Sales extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sales() {
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
			String uemail = request.getParameter("email");
			String upass = request.getParameter("password");
			String urole = request.getParameter("role");
			PreparedStatement pstmt = con.prepareStatement("select * from salescounter where email=? and pwd=? and role=?");
			pstmt.setString(1, uemail);
			pstmt.setString(2, upass);
			pstmt.setString(3, urole);
			ResultSet rs = pstmt.executeQuery();
//			if(uemail.equals("admin") && upass.equals("admin"))
//			{
//				response.sendRedirect("createremind.html");			
//			}
			if(rs.next())
			{
				response.sendRedirect("selectmanager.html");						
			}
			else
			{
				response.sendRedirect("index.html");					
			}
		}
		catch(Exception e)
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
