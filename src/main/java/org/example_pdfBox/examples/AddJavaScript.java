package org.example_pdfBox.examples;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionJavaScript;
import java.io.File;
/*
 todo: don't work
 */
public class AddJavaScript {

    public static void main(String args[]) throws Exception {

        //Loading an existing file
        File file = new File("C:/PdfBox_Examples/new.pdf");
        PDDocument document = PDDocument.load(file);

        String javaScript = "app.alert( {cMsg: 'this is an example', nIcon: 3,"
                + " nType: 0, cTitle: 'PDFBox Javascript example’} );";

        //Creating PDActionJavaScript object
        PDActionJavaScript PDAjavascript = new PDActionJavaScript(javaScript);

        //Embedding java script
        document.getDocumentCatalog().setOpenAction(PDAjavascript);

        //Saving the document
        document.save( new File("C:/PdfBox_Examples/new.pdf") );
        System.out.println("Data added to the given PDF");

        //Closing the document
        document.close();

    }
}