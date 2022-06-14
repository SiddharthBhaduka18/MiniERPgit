

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddSales1
 */
public class AddSales1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSales1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		DbConnection db = new DbConnection();
		Connection con = DbConnection.connect();
		System.out.println("Generate sales");
		try
		{
			String uId = request.getParameter("id");
			String uProduct = request.getParameter("product");
			String uName = request.getParameter("name");
			String uMob = request.getParameter("mob_no");
			String uemail = request.getParameter("email");
			String uQt = request.getParameter("quantity");
			int id = Integer.parseInt(uId);
//			int gst = Integer.parseInt(uQt);
			String s = "insert into sales values(?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(s);
			pstmt.setInt(1, id);
			pstmt.setString(2, uProduct);
			pstmt.setString(3, uName);
			pstmt.setString(4, uMob);
			pstmt.setString(5, uemail);
			pstmt.setString(6, uQt);
			int i = pstmt.executeUpdate();
			System.out.println("Generate sales");
			if(i>0)
			{
				response.sendRedirect("selectSales.html");					
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
