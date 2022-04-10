package org.example_pdfBox.examples;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.TextPosition;

import java.io.*;

public class GetCoordinateProcessTextPosition extends PDFTextStripper {

    public static String myText = "Уникальный номер записи об аккредитации в реестре аккредитованных лиц ________";

    public GetCoordinateProcessTextPosition() throws IOException {
    }

    public static void main(String[] args) throws IOException {
        File file = new File("C:/updatepdf/исходники/исходник1.pdf");
        PDDocument document = PDDocument.load(file);
        PDFTextStripper stripper = new GetCoordinateProcessTextPosition();
        Writer dummy = new OutputStreamWriter(new ByteArrayOutputStream());
        stripper.writeText(document, dummy);
        document.save("C:/updatepdf/исходники/исходник1.pdf");
        document.close();

        TextPosition textPosition = null;
        textPosition.getXDirAdj();

    }



    //@Override
    protected void processTextPosition(TextPosition textPos) {
        //String tChar = text.getUnicode().charAt(70);


            float xDirAdj = textPos.getXDirAdj();
            float endY = textPos.getEndY();
            System.out.println(xDirAdj + " - " + endY);

    }

}
