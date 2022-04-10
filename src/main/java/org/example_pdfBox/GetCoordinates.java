//package org.example_pdfBox;
//
//import org.apache.pdfbox.text.PDFTextStripper;
//import org.apache.pdfbox.text.TextPosition;
//import java.io.IOException;
//import java.util.List;
//
//public class GetCoordinates extends PDFTextStripper {
//
//    public Float yDirAdjForInsert;
//    public Float xDirAdj;
//    public Float yEndAdj;
//
//    public static String textToFind = "Уникальный номер записи об аккредитации в реестре аккредитованных лиц ________";
//
//    public GetCoordinates(Float yDirAdjForInsert, Float xDirAdj, Float yEndAdj) throws IOException {
//        this.yDirAdjForInsert = yDirAdjForInsert;
//        this.xDirAdj = xDirAdj;
//        this.yEndAdj = yEndAdj;
//    }
//
//    public Float getxDirAdj() {
//        return xDirAdj;
//    }
//
//    public Float getyEndAdj() {
//        return yEndAdj;
//    }
//
//    public Float getyDirAdjForInsert() {
//        return yDirAdjForInsert;
//    }
//
//    @Override
//    public void writeString(String string, List<TextPosition> textPositions) throws IOException {
//
//        if (string.equalsIgnoreCase(textToFind)) {
//            TextPosition textPosition = textPositions.get(string.length() - 7);
//            xDirAdj = textPosition.getXDirAdj();
//            yEndAdj = textPosition.getEndY();
//            System.out.println(xDirAdj);
//            System.out.println(yEndAdj);
//
//            float yDirAdjForInsert = (float) (yEndAdj + 1);
//
//        }
//
//
//    }
//
//}
