package ru.nmicrk.parsers;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import ru.nmicrk.model.beans.Source;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class DocxParser {

    public DocxParser() {
        super();
    }

    public List<Source> parseDocx(String filePath) {
        List<Source> sources = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(filePath);
            XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fis));

            List<XWPFParagraph> paragraphList = xdoc.getParagraphs();
            int n = 1;
            Source source;
            for (XWPFParagraph paragraph : paragraphList) {
                source = new Source();
                source.setPosition(n++);
                source.setValue(paragraph.getText());
                sources.add(source);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return sources;
    }
}
