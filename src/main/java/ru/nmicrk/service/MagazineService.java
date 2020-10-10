package ru.nmicrk.service;

import ru.nmicrk.model.beans.Magazine;
import ru.nmicrk.model.beans.Source;
import ru.nmicrk.parsers.DocxParser;
import ru.nmicrk.parsers.XmlParser;
import ru.nmicrk.util.CheckingUtil;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.*;

public class MagazineService {

    private static final String XML_NAME_TEMLPLATE = "%s-%s.xml";
    private static final String DOCX_NAME_TEMPLATE = "%s-%s-%s.docx";
    private static final String PDF_NAME_TEMPLATE = "%s-%s-%s.pdf";

    private XmlParser xmlParser = new XmlParser();
    private DocxParser docxParser = new DocxParser();


    public MagazineService() {
        super();
    }

    public Map<String, List<Magazine>> processFolder(String folderPath)
            throws NoSuchFileException, IllegalArgumentException {
        CheckingUtil.isFileExists(folderPath);
        File rootFolder = new File(folderPath);
        File[] years = rootFolder.listFiles();
        Map<String, List<Magazine>> catalog = new HashMap<>();
        for (File year : years) {
            catalog.put(year.getName(), processYear(year));
        }
        return catalog;
    }

    private List<Magazine> processYear(File year) throws IllegalArgumentException, NoSuchFileException {
        List<Magazine> magazines = new ArrayList<>();
        CheckingUtil.isDirectory(year, CheckingUtil.ROOT_CONTAIN_FILE);
        File[] volumes = year.listFiles();
        for (File volume : volumes) {
            Magazine magazine = processVolume(year.getName(), volume);
            if (!Objects.isNull(magazine)) {
                magazines.add(magazine);
            }
        }
        System.out.println(magazines.toString());
        return magazines;
    }

    private Magazine processVolume(String year, File volume) throws IllegalArgumentException, NoSuchFileException {
        Magazine magazine = null;
        CheckingUtil.isDirectory(volume, CheckingUtil.YEAR_CONTAIN_FILE);
        String xmlName = getXmlName(year, volume.getName());
        String path = volume.getAbsolutePath() + "\\" + xmlName;
        //System.out.println(path);
        CheckingUtil.isFileExists(path);
        try {
            magazine = xmlParser.parse(path);
            fillSources(year, volume, magazine);
            fillPdf(year, volume.getName(), magazine);
            magazine.setPath(volume.getParent());
        } catch (JAXBException | IOException e) {
            System.out.println("Exception while " + path + " parsing.");
            e.printStackTrace();
        }

        return magazine;
    }

    private void fillPdf(String year, String volume, Magazine magazine) {
        magazine
                .getSections()
                .forEach(section -> section
                        .getArticles()
                        .forEach(article -> article.setPdfUrl(getPdfUrl(year, volume, article.getNum()))));
    }

    private String getPdfUrl(String year, String volume, int num) {
        StringBuilder sb = new StringBuilder();
        return sb
                .append("/upload/archive/").append(year)
                .append("/").append(volume)
                .append("/").append(getPdfName(year, volume, num)).toString();
    }

    private void fillSources(String year, File volume, Magazine magazine) {
        magazine
                .getSections()
                .forEach(section -> section
                        .getArticles()
                        .forEach(article -> article.setSources(getSources(year, volume, article.getNum()))));

    }

    private List<Source> getSources(String year, File volume, int num) {
        String sourceFileName = getDocxName(year, volume.getName(), num);
        String path = volume.getAbsolutePath() + "\\" + sourceFileName;
        System.out.println(path);
        try {
            CheckingUtil.isFileExists(path);
            return docxParser.parseDocx(path);
        } catch (NoSuchFileException e) {
            System.out.println(String.format("WARNING: %s doesn't exists.", path));
        }
        return null;
    }

    private String getXmlName(String year, String volume) {
        return String.format(XML_NAME_TEMLPLATE, volume, year);
    }

    private String getDocxName(String year, String volume, int articleNum) {
        return String.format(DOCX_NAME_TEMPLATE, volume, year, articleNum);
    }

    private String getPdfName(String year, String volume, int articleNum) {
        return String.format(PDF_NAME_TEMPLATE, volume, year, articleNum);
    }

}
