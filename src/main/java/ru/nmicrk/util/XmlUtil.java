package ru.nmicrk.util;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XmlUtil {

    public static final Pattern XML_ENTITY_PATTERN = Pattern.compile("\\&\\#(?:x([0-9a-fA-F]+)|([0-9]+))\\;");

        //<.*?> ищет тэги
        //(?:<) ищет все <
    /**
     * Remove problematic xml entities from the xml string so that you can parse it with java DOM / SAX libraries.
     */
    public static String getCleanedXml(String xmlString) {
        return xmlString.replace("<value>","<value><![CDATA[").replace("</value>","]]></value>")
                .replace("<annotation>","<annotation><![CDATA[").replace("</annotation>","]]></annotation>");
    }
}
