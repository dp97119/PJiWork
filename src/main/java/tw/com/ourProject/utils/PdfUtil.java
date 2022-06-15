package tw.com.ourProject.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.springframework.stereotype.Component;

import com.itextpdf.kernel.pdf.EncryptionConstants;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.WriterProperties;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Table;

import tw.com.ourProject.model.Salaryslip;

@Component
public class PdfUtil {
	private static final byte[] USERPASS = "user".getBytes();
    private static final byte[] OWNERPASS = "owner".getBytes();
    PdfWriter pdfWriter;
    public void converPdf (Salaryslip salaryslip){
		try {
			pdfWriter = new PdfWriter(new FileOutputStream("D:/test6.pdf"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//    	產生密碼
    		WriterProperties ps =new WriterProperties();
    		ps.setStandardEncryption(USERPASS, OWNERPASS, EncryptionConstants.ALLOW_PRINTING, EncryptionConstants.ENCRYPTION_AES_128);
    	    PdfDocument pdf = new PdfDocument(pdfWriter);
    	   
//    		  介面物件
    		Document doc = new Document(pdf);
    		doc.setMargins(80, 0, 60, 150);
//    	    產生表格       
    			float[] pointColumnWidths = { 80F, 200F };
    			Table table = new Table(pointColumnWidths);
//    		表格資料
    		
    			
//    			table.addCell(colum);
//    			table.addCell(value);
    			
    // Adding Table to document
    			doc.add(table);
    			doc.close();
    			pdf.close();
    }

}
