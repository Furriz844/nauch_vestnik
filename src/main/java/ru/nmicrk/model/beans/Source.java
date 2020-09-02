package ru.nmicrk.model.beans;

import lombok.*;
import ru.nmicrk.model.xml.XmlModel;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@XmlRootElement(name = XmlModel.SOURCE)
public class Source {
    private int position;
    private String value;

    @XmlAttribute(name = XmlModel.POS)
    public int getPosition() {
        return position;
    }

    @XmlElement(name = "value")
    public String getValue() {
        return value;
    }
}
