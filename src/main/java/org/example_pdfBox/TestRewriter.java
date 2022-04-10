//package org.example_pdfBox;
//
//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.text.PDFTextStripper;
//import org.apache.pdfbox.text.TextPosition;
//
//import java.io.*;
//import java.util.List;
//
//public class TestRewriter extends PDFTextStripper {
//    public static String textToFind = "Уникальный номер записи об аккредитации в реестре аккредитованных лиц ________";
//
//    public TestRewriter() throws IOException {
//    }
//
//    public static void main(String[] args) throws IOException {
//        File file = new File("C:/updatepdf/исходники/исходник1.pdf");
//        PDDocument document = PDDocument.load(file);
//
//        PDFTextStripper stripper = new MyGetCoordinate();
//        Writer dummy = new OutputStreamWriter(new ByteArrayOutputStream());
//        stripper.writeText(document, dummy);
//
//
//
//        document.save("C:/updatepdf/исходники/исходник1.pdf");
//        document.close();
//
//    }
//
//    void printSubwords(PDDocument document, String searchTerm) throws IOException
//    {
//        System.out.printf("* Looking for '%s'\n", searchTerm);
//        for (int page = 1; page <= document.getNumberOfPages(); page++)
//        {
//            //List<TextPosition> hits;
//            for (List<TextPosition> hit : hits)
//            {
//
//                System.out.printf("  Page %s at %s, %s with width %s and last letter '%s' at %s, %s\n",
//                        page, hit.getX(), hit.getY(), hit.getWidth(),
//                        lastPosition.getUnicode(), lastPosition.getXDirAdj(), lastPosition.getYDirAdj());
//            }
//        }
//    }
//
//
//
//
//}
