package ru.nmicrk.model.beans;

import lombok.*;
import ru.nmicrk.model.xml.XmlModel;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@Setter
@Builder
@AllArgsConstructor
@ToString
@NoArgsConstructor
@XmlRootElement(name = XmlModel.AUTHOR)
public class Author {
    private String place;
    private String value;

    @XmlAttribute(name = XmlModel.PLACE)
    public String getPlace() {
        return place;
    }

    @XmlValue
    public String getValue() {
        return value;
    }
}
