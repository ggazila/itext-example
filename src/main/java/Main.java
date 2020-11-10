import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        OutputStream file = null;
        try {
            file = new FileOutputStream(new File("Contacts.pdf"));
            Document document = new Document();
            PdfWriter.getInstance(document, file);

            document.open();

            document.add(
                    new Paragraph("hello world, creating java pdf is easy"));
            document.add(new Paragraph("Second Paragraph"));
            document.add(new Paragraph("The end"));
            document.add(new Paragraph(
                    new Date(new java.util.Date().getTime()).toString()));

            document.addCreationDate();
            document.addAuthor("Serhii Yevtushok");
            document.addTitle("Title text");
            document.addCreator("Thanks to iText, writing into PDF is easy");

            document.close();

            System.out.println("Document is created");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } finally {
            if (file != null) {
                file.close();
            }
        }
    }
}
