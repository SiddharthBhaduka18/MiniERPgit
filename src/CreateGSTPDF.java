import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class CreateGSTPDF {
//	c.displayGSTSlip(gid, gProduct, gName, gMobNo, gEmail, gQt, gPPU);
	int Price;
	void displayGSTSlip(int gid, String gProduct,String gName, String gMobNo, String gEmail, int gQt,  int gPPU)
	{
		Price = gQt * gPPU;
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
			String s1 = "D:\\"+gName+".pdf";
			PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(s1));
			System.out.println("PDF Created");
			doc.open();
			String mess=""+Price;
//			doc.add(new Paragraph("Id-"+gid+"Product"+gProduct+"Name-"+gName+"MobNo"+gMobNo+"Email"+gEmail+"Quantity"+gQt+"PPU"+gPPU));
			doc.add(new Paragraph("Id-"+gid));
			doc.add(new Paragraph("Product"+gProduct));
			doc.add(new Paragraph("Name-"+gName));
			doc.add(new Paragraph("MobNo"+gMobNo));
			doc.add(new Paragraph("Email"+gEmail));
//			doc.add(new Paragraph("                            "));
			doc.add(new Paragraph("Quantity"+gQt));
			doc.add(new Paragraph("PPU"+gPPU));
//			doc.add(new Paragraph("LIC:"+LIC));
			doc.add(new Paragraph("                            "));
			doc.add(new Paragraph("Price:"+Price));
			
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

