package ru.nmicrk.model.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Setter;
import lombok.ToString;
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
@XmlRootElement(name = XmlModel.SECTION)
public class Section {
    private int num;
    private String name;
    private List<Article> articles;

    public Section() {
        this.articles = new ArrayList<Article>();
    }

    @XmlAttribute(name = XmlModel.NUM)
    public int getNum() {
        return num;
    }

    @XmlAttribute(name = XmlModel.NAME)
    public String getName() {
        return name;
    }

    @XmlElementWrapper(name = XmlModel.ARTICLES)
    @XmlElement(name = XmlModel.ARTICLE)
    public List<Article> getArticles() {
        return articles;
    }
}
