package org.example_pdfBox;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.TextPosition;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.io.*;
import java.util.List;

public class GetCoordinate extends PDFTextStripper implements Runnable {

    float xDirAdj = 0;
    float yEndAdj = 0;
    public static String textToFind = "Уникальный номер записи об аккредитации в реестре аккредитованных лиц ________";

    private static Logger logger = LogManager.getLogger(GetCoordinate.class);

    public GetCoordinate() throws IOException {
    }

    public static void main(String[] args) throws IOException {

        Thread object = new Thread(new GetCoordinate());
        object.start();


//        Runnable r1 = new GetCoordinate();
//        r1.run();

        logger.debug("Debug log message");
        logger.info("Info log message");
        logger.error("Error log message");
        File file = new File("C:/updatepdf/исходники/исходник1.pdf");
        PDDocument document = PDDocument.load(file);
        PDFTextStripper stripper = new GetCoordinate();
        Writer dummy = new OutputStreamWriter(new ByteArrayOutputStream());
        stripper.writeText(document, dummy);
        document.save("C:/updatepdf/исходники/исходник1.pdf");
        document.close();

        System.out.println("file uploaded");
        //MyInsertText.insertText(320, 320);

    }

    @Override
    public void run() {
        try {
            writeString(textToFind);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeString(String string, List<TextPosition> textPositions) throws IOException {

        if (string.equalsIgnoreCase(textToFind)) {
            TextPosition textPosition = textPositions.get(string.length() - 7);
            xDirAdj = textPosition.getXDirAdj();
            yEndAdj = textPosition.getEndY();
            System.out.println(xDirAdj);
            System.out.println(yEndAdj);
            MyInsertText.insertText(xDirAdj, yEndAdj + 1);

        }

    }



}

