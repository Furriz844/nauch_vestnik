package ru.nmicrk.model.beans;

import lombok.*;
import ru.nmicrk.model.xml.XmlModel;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@Setter
@Builder
@AllArgsConstructor
@ToString
@XmlRootElement(name = XmlModel.ARTICLE)
public class Article {
    private String name;
    private String enName;
    private String annotation;
    private String enAnnotation;
    private String keywords;
    private String enKeyWords;
    private int num;
    private String doi;
    private String type;
    private List<Place> places;
    private List<Place> enPlaces;
    private List<Author> authors;
    private List<Author> enAuthors;
    private List<Source> sources;
    private List<Source> enSources;
    private String citation;
    private String enCitation;
    private String range;
    private String pdfUrl;


    public Article() {
        this.sources = new ArrayList<Source>();
        this.places = new ArrayList<Place>();
        this.authors = new ArrayList<Author>();
    }

    @XmlAttribute(name = XmlModel.NAME)
    public String getName() {
        return name;
    }

    @XmlElementWrapper(name = XmlModel.AUTHORS)
    @XmlElement(name = XmlModel.AUTHOR)
    public List<Author> getAuthors() {
        return authors;
    }

    @XmlElement(name = XmlModel.ANNOTATION)
    public String getAnnotation() {
        return annotation;
    }

    @XmlElement(name = XmlModel.KEYWORDS)
    public String getKeywords() {
        return keywords;
    }

    @XmlElementWrapper(name = XmlModel.SOURCES)
    @XmlElement(name = XmlModel.SOURCE)
    public List<Source> getSources() {
        return sources;
    }

    @XmlAttribute(name = XmlModel.NUM)
    public int getNum() {
        return num;
    }

    @XmlAttribute(name = XmlModel.DOI)
    public String getDoi() {
        return doi;
    }

    @XmlAttribute(name = XmlModel.TYPE)
    public String getType() {
        return type;
    }

    @XmlElementWrapper(name = XmlModel.PLACES)
    @XmlElement(name = XmlModel.PLACE)
    public List<Place> getPlaces() {
        return places;
    }

    @XmlElement(name = XmlModel.CITATION)
    public String getCitation() {
        return citation;
    }

    @XmlElement(name = XmlModel.RANGE)
    public String getRange() {
        return range;
    }

    @XmlAttribute(name = XmlModel.EN_NAME)
    public String getEnName() {
        return enName;
    }

    @XmlElement(name = XmlModel.EN_ANNOTATION)
    public String getEnAnnotation() {
        return enAnnotation;
    }

    @XmlElement(name = XmlModel.EN_KEYWORDS)
    public String getEnKeyWords() {
        return enKeyWords;
    }

    @XmlElementWrapper(name = XmlModel.EN_PLACES)
    @XmlElement(name = XmlModel.EN_PLACE)
    public List<Place> getEnPlaces() {
        return enPlaces;
    }

    @XmlElementWrapper(name = XmlModel.EN_AUTHORS)
    @XmlElement(name = XmlModel.EN_AUTHOR)
    public List<Author> getEnAuthors() {
        return enAuthors;
    }

    @XmlElementWrapper(name = XmlModel.EN_SOURCES)
    @XmlElement(name = XmlModel.EN_SOURCE)
    public List<Source> getEnSources() {
        return enSources;
    }

    @XmlElement(name = XmlModel.EN_CITATION)
    public String getEnCitation() {
        return enCitation;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }
}
