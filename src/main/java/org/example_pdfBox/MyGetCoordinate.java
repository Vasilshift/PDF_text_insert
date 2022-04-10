package org.example_pdfBox;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.TextPosition;

import java.io.*;
import java.util.List;

public class MyGetCoordinate extends PDFTextStripper {

    public static Float yDirAdjForInsert;

    public MyGetCoordinate() throws IOException {
    }

    public static String textToFind = "Уникальный номер записи об аккредитации в реестре аккредитованных лиц ________";

    public static void main(String[] args) throws IOException {

        File file = new File("C:/updatepdf/исходники/исходник1.pdf");
        PDDocument document = PDDocument.load(file);

        PDFTextStripper stripper = new MyGetCoordinate();
        Writer dummy = new OutputStreamWriter(new ByteArrayOutputStream());
        stripper.writeText(document, dummy);

        document.save("C:/updatepdf/исходники/исходник1.pdf");
        document.close();

    }


//    protected void processTextPosition(TextPosition text) {
//
//        if (text.equalsIgnoreCase(textToFind)) {
//
//            float yDirAdj = textPositions.get(string.length() - 7).getYDirAdj();
//            float xDirAdj = textPositions.get(string.length() - 7).getXDirAdj();
//            System.out.println(yDirAdj);
//            System.out.println(xDirAdj);
//            yDirAdjForInsert = (float) (yDirAdj + 0.5);
//        }
//
//
//        if (text.equals(textToFind)) {
//            System.out.println("String[" + text.getXDirAdj() + ","
//                    + text.getYDirAdj() + " fs=" + text.getFontSize() + " xscale="
//                    + text.getXScale() + " height=" + text.getHeightDir() + " space="
//                    + text.getWidthOfSpace() + " width="
//                    + text.getWidthDirAdj() + "]" + text.getUnicode());
//        }
//    }


    @Override
    public void writeString(String string, List<TextPosition> textPositions) throws IOException {
        //int count = string.length() - 7;
        //System.out.println(string);
        //char c = string.charAt(count);


        if (string.equalsIgnoreCase(textToFind)) {

            float yDirAdj = textPositions.get(string.length() - 7).getYDirAdj();
            float xDirAdj = textPositions.get(string.length() - 7).getXDirAdj();
            System.out.println(yDirAdj);
            System.out.println(xDirAdj);
            yDirAdjForInsert = (float) (yDirAdj + 0.5);


            //Begin the Content stream
            //contentStream.beginText();

//            //Setting the font to the Content stream
            //contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
//
//            //Setting the position for the line
//            contentStream.newLineAtOffset(25, 725);
//
//            String text = "This is the sample document and we are adding content to it.";
//
//            //Adding text in the form of string
//            contentStream.showText(text);
//
//            //Ending the content stream
//            contentStream.endText();
//
//            System.out.println("Content added");
//
//            //Closing the content stream
//            contentStream.close();
//
//            //Saving the document
//            document.save(new File("C:/PdfBox_Examples/new.pdf"));


//            for (TextPosition text : textPositions) {
//
//            //System.out.println(textPositions.stream().map(TextPosition::getEndY));
//
//                System.out.println(text.getUnicode() + " [(X=" + text.getXDirAdj() + ",Y=" +
//                        text.getYDirAdj() + ") height=" + text.getHeightDir() + " width=" +
//                        text.getWidthDirAdj() + "]");
//            }

//        }


        }

    }
}





