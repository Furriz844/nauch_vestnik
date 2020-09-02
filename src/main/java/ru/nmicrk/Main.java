package ru.nmicrk;

import org.apache.commons.text.StringEscapeUtils;
import ru.nmicrk.model.beans.Magazine;
import ru.nmicrk.util.XmlUtil;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception{
        File file = new File("F:\\1-2019_bad.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(Magazine.class);
        String content = Files.lines(file.toPath()).collect(Collectors.joining(System.lineSeparator()));
        InputStream stream = new ByteArrayInputStream(XmlUtil.getCleanedXml(content).getBytes(StandardCharsets.UTF_8));
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Magazine magazine = (Magazine) jaxbUnmarshaller.unmarshal(stream);
        System.out.println(magazine);
    }
}
