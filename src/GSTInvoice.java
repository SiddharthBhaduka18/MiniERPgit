

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GSTInvoice
 */
public class GSTInvoice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GSTInvoice() {
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
			String uId = request.getParameter("id");
			int id = Integer.parseInt(uId);
			PreparedStatement pstmt = con.prepareStatement("select * from acc where id=?");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
//			if(uemail.equals("admin") && upass.equals("admin"))
//			{
//				response.sendRedirect("createremind.html");			
//			}
			if(rs.next())
			{
//				response.sendRedirect("selectmember.html");	
				int eid = rs.getInt("id");
				String ename = rs.getString("name");
				String esal = rs.getString("salary");
				int sal = Integer.parseInt(esal);
				String edep = rs.getString("department");
				CreatePDF c = new CreatePDF();
				c.displayPaySlip(eid, ename, sal, edep);
				response.sendRedirect("selectAccountant.html");						
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
