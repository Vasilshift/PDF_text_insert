package org.example_pdfBox;

import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.TextPosition;
import java.io.IOException;
import java.util.List;

public class FindTextPosition extends PDFTextStripper {

    public FindTextPosition() throws IOException {
    }


    //@Override
    public void writeString(String string, List<TextPosition> textPositions) throws IOException {

        for (TextPosition text : textPositions) {

            System.out.println(text.getUnicode()+ " [(X=" + text.getXDirAdj() + ",Y=" +
                    text.getYDirAdj() + ") height=" + text.getHeightDir() + " width=" +
                    text.getWidthDirAdj() + "]");
        }
    }

//    @Override
//    protected void processTextPosition(TextPosition text) {
//        System.out.println(text.getUnicode() + " " + text.getXDirAdj() + ","
//                + text.getYDirAdj() + " fs=" + text.getFontSize() + " xscale="
//                + text.getXScale() + " height=" + text.getHeightDir() + " space="
//                + text.getWidthOfSpace() + " width="
//                + text.getWidthDirAdj() + "]" );
//    }
}
