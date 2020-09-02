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
    private String authors;
    private String annotation;
    private String keywords;
    List<Source> sources;

    public Article() {
        this.sources = new ArrayList<Source>();
    }

    @XmlAttribute(name = XmlModel.YEAR)
    public String getName() {
        return name;
    }

    @XmlElement(name = XmlModel.AUTHORS)
    public String getAuthors() {
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
}
