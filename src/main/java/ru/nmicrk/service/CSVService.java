package ru.nmicrk.service;

import ru.nmicrk.model.beans.Article;
import ru.nmicrk.model.beans.Magazine;
import ru.nmicrk.model.beans.Section;
import ru.nmicrk.model.csv.BitrixCSV;
import ru.nmicrk.util.HtmlUtil;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVService {

    private static final String FILEPATH_TEMPLATE = "%s\\%s-%s.csv";
    private static final String MAGAZINE_NAME_TEMPLATE = "%s (%s) %s %s";

    public void generateCSV(Magazine magazine) {
        List<BitrixCSV> bitrixCSVList = parseMagazine(magazine);
        String content = buildCSV(bitrixCSVList);
        String filePath = buildFilePath(magazine);
        createFile(filePath, content);
    }

    private String buildFilePath(Magazine magazine) {
        return String.format(FILEPATH_TEMPLATE,
                magazine.getPath(),
                magazine.getNumber(),
                magazine.getYear());
    }

    private List<BitrixCSV> parseMagazine(Magazine magazine) {
        String year = String.valueOf(magazine.getYear());
        String magazineName = buildMagazineName(magazine);
        ArrayList<BitrixCSV> entries = new ArrayList<>();

        List<Section> sections = magazine.getSections();

        List<Article> articles;
        BitrixCSV entry;
        for (Section section : sections) {
            articles = section.getArticles();
            for (Article article : articles) {
                entry = buildEntry(magazine.getMainNumber(), year, magazineName, section, article);
                entries.add(entry);
            }
        }

        return entries;
    }

    private BitrixCSV buildEntry(int mainNum, String year, String magazineName, Section section, Article article) {
        BitrixCSV entry = new BitrixCSV();
        entry
                .setYear(year)
                .setMagazine(magazineName)
                .setArticleId(generateID(mainNum, year, article.getNum()))
                .setArticleName(article.getName())
                .setEnArticleName(article.getEnName())
                .setSymbolCode(HtmlUtil.generateSymbolCode(year, mainNum, article))
                .setSort(String.valueOf(article.getNum()))
                .setKeyWords(article.getKeywords())
                .setEnKeyWords(article.getEnKeyWords())
                .setAuthors(HtmlUtil.generateAuthors(article.getAuthors()))
                .setEnAuthors(HtmlUtil.generateAuthors(article.getEnAuthors()))
                .setCitation(article.getCitation())
                .setEnCitation(article.getEnCitation())
                .setDoi(article.getDoi())
                .setPlaces(HtmlUtil.generatePlaces(article.getPlaces()))
                .setEnPlaces(HtmlUtil.generatePlaces(article.getEnPlaces()))
                .setAnnotation(HtmlUtil.generateAnnotation(article.getAnnotation()))
                .setEnAnnotation(HtmlUtil.generateAnnotation(article.getEnAnnotation()))
                .setSources(HtmlUtil.generateSources(article.getSources()))
                .setEnSources(HtmlUtil.generateSources(article.getEnSources()))
                .setPages(article.getRange())
                .setPdfLink(article.getPdfUrl())
                .setSection(section.getName());
        return entry;
    }

    private String generateID(int mainNum, String year, int num) {
        int yearSubId = Integer.valueOf(year.substring(2)) * 10000;
        int numSubId = mainNum * 100;
        return String.valueOf(yearSubId + numSubId + num);

    }

    private String buildMagazineName(Magazine magazine) {
        return String.format(MAGAZINE_NAME_TEMPLATE,
                magazine.getNumber(),
                magazine.getMainNumber(),
                magazine.getMonth(),
                magazine.getYear());
    }

    private void createFile(String filepath, String content) {
        try {
            FileWriter myWriter = new FileWriter(filepath);
            myWriter.write(content);
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(filepath + " is ready.");
    }

    private String buildCSV(List<BitrixCSV> bitrixArticles) {
        StringBuilder sb = new StringBuilder();
        sb.append(BitrixCSV.HEADER).append("\r\n");
        for (BitrixCSV article : bitrixArticles) {
            sb.append(article.toString().replaceAll("\n", "")).append("\r\n");
        }
        return sb.toString();
    }
}
