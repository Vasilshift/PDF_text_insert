package org.example_pdfBox.examples;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import java.io.IOException;

public class Adding_Pages {

    public static void main(String[] args) throws IOException {

        //Creating PDF document object
        PDDocument document = new PDDocument();

        for (int i=0; i<1; i++) {
            //Creating a blank page
            PDPage blankPage = new PDPage();

            //Adding the blank page to the document
            document.addPage( blankPage );
        }

        //Saving the document
        document.save("C:/PdfBox_Examples/my_doc.pdf");
        System.out.println("Pages attached in document");

        //Closing the document
        document.close();

    }
}