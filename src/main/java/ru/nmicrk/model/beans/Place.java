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
@NoArgsConstructor
@ToString
@XmlRootElement(name = XmlModel.PLACE)
public class Place {
    private int num;
    private String value;

    @XmlAttribute(name = XmlModel.NUM)
    public int getNum() {
        return num;
    }

    @XmlValue
    public String getValue() {
        return value;
    }
}
