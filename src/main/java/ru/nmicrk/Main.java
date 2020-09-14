package ru.nmicrk;


import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import ru.nmicrk.model.beans.Magazine;
import ru.nmicrk.parsers.XmlParser;

import javax.xml.bind.JAXBException;

import java.io.*;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        readWord();
    }

    public static void readXml() {
        String path = "F:\\nmicrk\\2019\\1\\1-2019.xml";
        XmlParser xmlParser = new XmlParser();
        try {
            Magazine magazine = xmlParser.parse(path);
            System.out.println(magazine);
        } catch (JAXBException | IOException e) {
            System.out.println("Exception while " + path + " parsing.");
            e.printStackTrace();
        }
    }

    public static void readWord()  {
        String path = "F:\\nmicrk\\2019\\1\\1-2019.docx";
        try {
            FileInputStream fis = new FileInputStream(path);
            XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fis));

            List<XWPFParagraph> paragraphList = xdoc.getParagraphs();
            int n = 1;
            for (XWPFParagraph paragraph : paragraphList) {

                System.out.println(n+++") "+paragraph.getText());
                //System.out.println(paragraph.getAlignment());
                //System.out.print(paragraph.getRuns().size());
                //System.out.println(paragraph.getStyle());

                // Returns numbering format for this paragraph, eg bullet or lowerLetter.
                //System.out.println(paragraph.getNumFmt());
                //System.out.println(paragraph.getAlignment());

                //System.out.println(paragraph.isWordWrapped());

                System.out.println("********************************************************************");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
