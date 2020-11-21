package ru.nmicrk.util;

import ru.nmicrk.model.beans.Article;
import ru.nmicrk.model.beans.Author;
import ru.nmicrk.model.beans.Place;
import ru.nmicrk.model.beans.Source;

import java.util.List;
import java.util.Objects;

public class HtmlUtil {
    private static final String SYMBOL_CODE_TEMPLATE = "%s-%s-%s";
    private static final String ORCID_LINK_TEMPLATE = "<a href=\"%s\" target=\"_blank\">" +
            "<img border=\"0\" alt=\"ORCID\" " +
            "src=\"/images/orcid.png\" width=\"16\" height=\"16\"></a>";

    public static String generateSymbolCode(String year, int mainNum, Article article) {
        String translitName = TranslitUtil.toTranslit(article.getName());
        if (translitName.length() > 128) {
            translitName = translitName.substring(0, 127);
        }
        return String.format(SYMBOL_CODE_TEMPLATE, year, mainNum, translitName);
    }

    public static String generateAuthors(List<Author> authors) {
        StringBuilder sb = new StringBuilder();
        for (Author author : authors) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append("<sup>").append(author.getPlace()).append("</sup> ");
            String[] authorValues = author.getValue().split("@");
            if (authorValues.length > 1) {
                sb.append(getOrcidLink(authorValues[0]));
                sb.append(authorValues[1]);
            } else {
                sb.append(author.getValue());
            }
        }
        return sb.toString();
    }

    private static String getOrcidLink(String authorOrcidLink) {
        return String.format(ORCID_LINK_TEMPLATE, authorOrcidLink);
    }

    public static String generatePlaces(List<Place> places) {
        StringBuilder sb = new StringBuilder();
        for (Place place : places) {
            if (sb.length() > 0) {
                sb.append("<br>");
            }
            sb.append("<sup>").append(place.getNum()).append("</sup> ");
            sb.append(place.getValue());
        }
        return sb.toString();
    }

    public static String generateAnnotation(String annotation) {
        StringBuilder sb = new StringBuilder();
        return sb.append("<p>").append(annotation.replaceAll("\r\n", "<br>").replaceAll("\t", "")).append("</p>").toString();
    }

    public static String generateSources(List<Source> sources) {
        if (Objects.isNull(sources)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<ol class=\"archive-links\">");
        for (Source source : sources) {
            sb.append("<li>").append(source.getValue()).append("</li>");
        }
        sb.append("</ol>");
        return sb.toString();
    }
}
