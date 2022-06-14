import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
public class CreatePDF {
//	int Salary;
	void displayPaySlip(int id, String na, int Salary,  String dep)
	{
		float DA, TA, CCA, MED_ALL, PF, GPF, LIC, Gross_Sal;
		DA = 0.2f*Salary;
		TA = 0.1f*Salary;
		CCA = 5000.0f;
		MED_ALL = 0.1f*Salary;
		PF = 0.05f*Salary;
		GPF = 0.05f*Salary;
		LIC = 0.02f*Salary;
		Gross_Sal = Salary + DA + TA + CCA + MED_ALL - PF - GPF - LIC;
//		System.out.println("DA : "+DA);
//		System.out.println("TA : "+TA);
//		System.out.println("CCA : "+CCA);
//		System.out.println("MED_ALL : "+MED_ALL);
//		System.out.println("PF : "+PF);
//		System.out.println("GPF : "+GPF);
//		System.out.println("LIC : "+LIC);
//		System.out.println("Gross_Sal : "+Gross_Sal);
		
		Document doc = new Document();
		try
		{
			String s1 = "D:\\"+na+".pdf";
			PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(s1));
			System.out.println("PDF Created");
			doc.open();
			String mess=""+Gross_Sal;
//			doc.add(new Paragraph("Id-"+id+"Name-"+na+"Salary"+Salary+"Department"+dep));
			doc.add(new Paragraph("Id			:	"+id));
			doc.add(new Paragraph("Name			:	"+na));
			doc.add(new Paragraph("Salary		:	"+Salary));
			doc.add(new Paragraph("Department	:"+dep));
			doc.add(new Paragraph("                            "));
			doc.add(new Paragraph("                            "));
			doc.add(new Paragraph("DA		:"+DA));
			doc.add(new Paragraph("TA		:"+TA));
			doc.add(new Paragraph("CCA		:"+CCA));
			doc.add(new Paragraph("MED_ALL	:"+MED_ALL));
			doc.add(new Paragraph("                            "));
			doc.add(new Paragraph("PF		:"+PF));
			doc.add(new Paragraph("GPF		:"+GPF));
			doc.add(new Paragraph("LIC		:"+LIC));
			doc.add(new Paragraph("                            "));
			doc.add(new Paragraph("                            "));
			doc.add(new Paragraph("Final Salary	:"+Gross_Sal));
			
			doc.close();
			writer.close();
			
		}
		catch(DocumentException e)
		{
			e.printStackTrace();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
	}

}
