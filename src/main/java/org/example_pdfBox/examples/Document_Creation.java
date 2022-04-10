package org.example_pdfBox.examples;
import org.apache.pdfbox.pdmodel.PDDocument;
import java.io.IOException;

public class Document_Creation {

    public static void main (String[] args) throws IOException {

        //Creating PDF document object
        PDDocument document = new PDDocument();

        //Saving the document
        document.save("C:/PdfBox_Examples/my_doc.pdf");

        System.out.println("PDF created");

        //Closing the document
        document.close();

    }
}
