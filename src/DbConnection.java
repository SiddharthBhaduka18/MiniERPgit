import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class DbConnection {
	static Connection connect()
	{
		Connection con = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded......");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/minierp","root","");
			System.out.println("Connection Established......");
		}catch(Exception e){
			e.printStackTrace();
		}
		return(con);
	}
//	public static void main(String args[])
//	{
//		DbConnection db = new DbConnection();
//		db.connect();
//		Registration rg = new Registration();
//		rg.register();
//		Login lg = new Login();
//		lg.validatelogin();
//		CreateReminder cr = new CreateReminder();
//		cr.reminder();
//	}
	
	public static void main(String args[])
	{
		/*System.out.println("-----Welcome to Reminder System------");
		int flag=1,ch;*/
		DbConnection db = new DbConnection();
		db.connect();
		/*Scanner sc = new Scanner(System.in);
		while(flag!=0)
		{
//			System.out.println("Enter Your Choice :\n1.Registration\n2.Login\n3.CreateReminder\n4.ViewReminder\n5.DeleteReminder\n6.Exit");
			System.out.println("Enter Your Choice :\n1.Registration\n2.Login\n3.Exit");
			ch = sc.nextInt();
			switch(ch)
			{
			case 1:
				Registration rg = new Registration();
				rg.register();
				break;
			case 2:
				Login2 lg = new Login2();
				lg.validatelogin();
				break;
//			case 3:
//				CreateReminder cr = new CreateReminder();
//				cr.reminder();
//				break;
//			case 4:
//				ViewReminder vr = new ViewReminder();
//				vr.view();
//				break;
//			case 5:
//				DeleteReminder dr = new DeleteReminder();
//				dr.delete();
//				break;
			case 3:
				flag=0;
				break;
			default : 
				System.out.println("Enter the valid input!!!!");
			}
		}*/
		
		
		
		
		
	}
}