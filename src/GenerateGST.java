

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GenerateGST
 */
public class GenerateGST extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerateGST() {
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
			String uMobNo = request.getParameter("mob_no");
			int id = Integer.parseInt(uId);
			PreparedStatement pstmt = con.prepareStatement("select * from sales where id=? and mob_no=?");
			pstmt.setInt(1, id);
			pstmt.setString(2, uMobNo);
			ResultSet rs = pstmt.executeQuery();
//			if(uemail.equals("admin") && upass.equals("admin"))
//			{
//				response.sendRedirect("createremind.html");			
//			}
			if(rs.next())
			{
//				response.sendRedirect("selectmember.html");	
				int gid = rs.getInt("id");
				String gProduct = rs.getString("product");
				String gName = rs.getString("name");
				String gMobNo = rs.getString("mob_no");
				String gEmail = rs.getString("email");
				String gQt = rs.getString("quantity");
				int qt = Integer.parseInt(gQt);
				
				String gProcess = "processedMaterial";
				PreparedStatement pstmt2 = con.prepareStatement("select * from material where item=? and role=?");
				pstmt2.setString(1, gProduct);
				pstmt2.setString(2, gProcess);
				ResultSet rs2 = pstmt2.executeQuery();
				if(rs2.next())
				{
					int gPPU = rs2.getInt("ppu");
					CreateGSTPDF c = new CreateGSTPDF();
					c.displayGSTSlip(gid, gProduct, gName, gMobNo, gEmail, qt, gPPU);
//					c.displayPaySlip(eid, ename, sal, edep);
					response.sendRedirect("gstInvoice.html");						
					response.sendRedirect("selectSales.html");
				}
				
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
