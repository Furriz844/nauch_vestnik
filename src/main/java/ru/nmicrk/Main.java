package ru.nmicrk;


import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import ru.nmicrk.model.beans.Magazine;
import ru.nmicrk.parsers.XmlParser;
import ru.nmicrk.service.MagazineService;

import javax.xml.bind.JAXBException;

import java.io.*;

import java.nio.file.NoSuchFileException;
import java.util.List;


public class Main {
    public static void main(String[] args) throws NoSuchFileException {
        //readXml();
        //readWord();
        MagazineService magazineService = new MagazineService();
        magazineService.processFolder("F:\\Работа\\nmicrk\\CATALOG");
    }

    public static void readXml() {
        String path = "F:\\Работа\\nmicrk\\01-2020\\01-2020_upd.xml";
        XmlParser xmlParser = new XmlParser();
        try {
            Magazine magazine = xmlParser.parse(path);
            System.out.println(magazine);
        } catch (JAXBException | IOException e) {
            System.out.println("Exception while " + path + " parsing.");
            e.printStackTrace();
        }
    }

    public static void readWord() {
        String path = "F:\\nmicrk\\2019\\01\\01-2019-02.docx";
        try {
            FileInputStream fis = new FileInputStream(path);
            XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fis));

            List<XWPFParagraph> paragraphList = xdoc.getParagraphs();
            int n = 1;
            for (XWPFParagraph paragraph : paragraphList) {

                System.out.println(n++ + ") " + paragraph.getText());
                System.out.println("********************************************************************");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
