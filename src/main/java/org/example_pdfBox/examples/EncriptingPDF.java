package org.example_pdfBox.examples;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;
import java.io.File;

public class EncriptingPDF {

    public static void main(String args[]) throws Exception {
        //Loading an existing document
        File file = new File("C:/PdfBox_Examples/sample.pdf");
        PDDocument document = PDDocument.load(file);

        //Creating access permission object
        AccessPermission ap = new AccessPermission();

        //Creating StandardProtectionPolicy object
        StandardProtectionPolicy spp = new StandardProtectionPolicy("1234", "1234", ap);

        //Setting the length of the encryption key
        spp.setEncryptionKeyLength(128);

        //Setting the access permissions
        spp.setPermissions(ap);

        //Protecting the document
        document.protect(spp);

        System.out.println("Document encrypted");

        //Saving the document
        document.save("C:/PdfBox_Examples/sample.pdf");
        //Closing the document
        document.close();

    }
}
