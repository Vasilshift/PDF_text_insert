package org.example_pdfBox.examples;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.File;
import java.io.IOException;

public class InsertTextTest {
    public static void main(String[] str) throws IOException {

        File file = new File("C:/updatepdf/исходники/исходник1.pdf");
        PDDocument document = PDDocument.load(file);

        PDPage page = document.getPage(0);

        PDPageContentStream contentStream = new PDPageContentStream(document, page,
                PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream.beginText();

        contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);

        contentStream.newLineAtOffset(300, 300);

        String text = "blablabla";

        contentStream.showText(text);

        contentStream.endText();

        System.out.println("Content added");

        contentStream.close();

        document.save("C:/updatepdf/исходники/исходник1.pdf");

        document.close();
    }

}
