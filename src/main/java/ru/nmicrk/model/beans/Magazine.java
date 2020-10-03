package ru.nmicrk.model.beans;

import lombok.*;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import ru.nmicrk.model.xml.XmlModel;

import java.util.ArrayList;
import java.util.List;

@Setter
@Builder
@AllArgsConstructor
@ToString
@XmlRootElement(name = XmlModel.MAGAZINE)
public class Magazine {
    private int year;
    private int number;
    private int mainNumber;
    private String month;
    List<Section> sections;

    public Magazine() {
        this.sections = new ArrayList<Section>();
    }

    @XmlAttribute(name = XmlModel.YEAR)
    public int getYear() {
        return year;
    }

    @XmlAttribute(name = XmlModel.NUM)
    public int getNumber() {
        return number;
    }

    @XmlElementWrapper(name = XmlModel.SECTIONS)
    @XmlElement(name = XmlModel.SECTION)
    public List<Section> getSections() {
        return sections;
    }

    @XmlAttribute(name = XmlModel.MAIN_NUM)
    public int getMainNumber() {
        return mainNumber;
    }

    @XmlAttribute(name = XmlModel.MONTH)
    public String getMonth() {
        return month;
    }
}
