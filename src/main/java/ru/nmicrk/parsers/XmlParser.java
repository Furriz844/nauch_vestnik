package ru.nmicrk.parsers;

import ru.nmicrk.model.beans.Magazine;
import ru.nmicrk.util.XmlUtil;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.stream.Collectors;

public class XmlParser {

    public XmlParser() {
        super();
    }

    public Magazine parse(String filePath) throws JAXBException, IOException {
        File file = new File(filePath);
        JAXBContext jaxbContext = JAXBContext.newInstance(Magazine.class);
        String content = Files.lines(file.toPath()).collect(Collectors.joining(System.lineSeparator()));
        content.replaceAll("\t", "");
        InputStream stream = new ByteArrayInputStream(XmlUtil.getCleanedXml(content).getBytes(StandardCharsets.UTF_8));
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Magazine magazine = (Magazine) jaxbUnmarshaller.unmarshal(stream);
        return magazine;
    }
}
