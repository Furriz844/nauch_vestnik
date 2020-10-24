package ru.nmicrk.model.csv;

public class BitrixCSV {
    public static final String DELIM = "@";

    public static final String HEADER =
            "IE_XML_ID" + DELIM +
                    "IE_NAME" + DELIM +
                    "IE_ID" + DELIM +
                    "IE_ACTIVE" + DELIM +
                    "IE_ACTIVE_FROM" + DELIM +
                    "IE_ACTIVE_TO" + DELIM +
                    "IE_PREVIEW_PICTURE" + DELIM +
                    "IE_PREVIEW_TEXT" + DELIM +
                    "IE_PREVIEW_TEXT_TYPE" + DELIM +
                    "IE_DETAIL_PICTURE" + DELIM +
                    "IE_DETAIL_TEXT" + DELIM +
                    "IE_DETAIL_TEXT_TYPE" + DELIM +
                    "IE_CODE" + DELIM +
                    "IE_SORT" + DELIM +
                    "IE_TAGS" + DELIM +
                    "IP_PROP8" + DELIM +
                    "IP_PROP11" + DELIM +
                    "IP_PROP6" + DELIM +
                    "IP_PROP14" + DELIM +
                    "IP_PROP45" + DELIM +
                    "IP_PROP3" + DELIM +
                    "IP_PROP31" + DELIM +
                    "IP_PROP7" + DELIM +
                    "IP_PROP12" + DELIM +
                    "IP_PROP10" + DELIM +
                    "IP_PROP9" + DELIM +
                    "IP_PROP13" + DELIM +
                    "IP_PROP1" + DELIM +
                    "IP_PROP15" + DELIM +
                    "IP_PROP5" + DELIM +
                    "IP_PROP4" + DELIM +
                    "IC_GROUP0" + DELIM +
                    "IC_GROUP1" + DELIM +
                    "IC_GROUP2";

    private String
            IE_XML_ID,
            IE_NAME,
            IE_ID,
            IE_ACTIVE = "Y",
            IE_ACTIVE_FROM = "",
            IE_ACTIVE_TO = "",
            IE_PREVIEW_PICTURE = "",
            IE_PREVIEW_TEXT = "",
            IE_PREVIEW_TEXT_TYPE = "text",
            IE_DETAIL_PICTURE = "",
            IE_DETAIL_TEXT = "",
            IE_DETAIL_TEXT_TYPE = "html",
            IE_CODE = "",
            IE_SORT = "",
            IE_TAGS = "",
            IP_PROP8 = "",
            IP_PROP11 = "",
            IP_PROP6 = "",
            IP_PROP14 = "",
            IP_PROP45 = "",
            IP_PROP3 = "",
            IP_PROP31 = "",
            IP_PROP7 = "",
            IP_PROP12 = "",
            IP_PROP10 = "",
            IP_PROP9 = "",
            IP_PROP13 = "",
            IP_PROP1 = "",
            IP_PROP15 = "",
            IP_PROP5 = "",
            IP_PROP4 = "",
            IC_GROUP0 = "",
            IC_GROUP1 = "",
            IC_GROUP2 = "";

    public BitrixCSV setArticleId(String IE_XML_ID) {
        this.IE_XML_ID = IE_XML_ID;
        this.IE_ID = IE_XML_ID;

        return this;
    }

    public BitrixCSV setArticleName(String IE_NAME) {
        this.IE_NAME = IE_NAME;
        return this;
    }

    public BitrixCSV setSymbolCode(String IE_CODE) {
        this.IE_CODE = IE_CODE;
        return this;
    }

    public BitrixCSV setSort(String IE_SORT) {
        this.IE_SORT = IE_SORT;
        return this;
    }

    public BitrixCSV setKeyWords(String IE_TAGS) {
        this.IE_TAGS = IE_TAGS;
        return this;
    }

    public BitrixCSV setEnKeyWords(String IP_PROP45) {
        this.IP_PROP45 = IP_PROP45;
        return this;
    }

    public BitrixCSV setAuthors(String IP_PROP8) {
        this.IP_PROP8 = "[HTML]" + IP_PROP8;
        return this;
    }

    public BitrixCSV setEnAuthors(String IP_PROP11) {
        this.IP_PROP11 = "[HTML]" + IP_PROP11;
        return this;
    }

    public BitrixCSV setCitation(String IP_PROP6) {
        this.IP_PROP6 = "[TEXT]" + IP_PROP6;
        return this;
    }

    public BitrixCSV setEnCitation(String IP_PROP14) {
        this.IP_PROP14 = "[TEXT]" + IP_PROP14;
        return this;
    }

    public BitrixCSV setDoi(String IP_PROP3) {
        this.IP_PROP3 = IP_PROP3;
        return this;
    }

    public BitrixCSV setBuyInElibrary(String IP_PROP31) {
        this.IP_PROP31 = IP_PROP31;
        return this;
    }

    public BitrixCSV setPlaces(String IP_PROP7) {
        this.IP_PROP7 = "[HTML]" + IP_PROP7;
        return this;
    }

    public BitrixCSV setEnPlaces(String IP_PROP12) {
        this.IP_PROP12 = "[HTML]" + IP_PROP12;
        return this;
    }

    public BitrixCSV setEnArticleName(String IP_PROP10) {
        this.IP_PROP10 = IP_PROP10;
        return this;
    }

    public BitrixCSV setAnnotation(String IP_PROP9) {
        this.IP_PROP9 = "[HTML]" + IP_PROP9;
        return this;
    }

    public BitrixCSV setEnAnnotation(String IP_PROP13) {
        this.IP_PROP13 = "[HTML]" + IP_PROP13;
        return this;
    }

    public BitrixCSV setSources(String IP_PROP1) {
        this.IP_PROP1 = "[HTML]" + IP_PROP1;
        return this;
    }

    public BitrixCSV setEnSources(String IP_PROP15) {
        this.IP_PROP15 = "[HTML]" + IP_PROP15;
        return this;
    }


    public BitrixCSV setPages(String IP_PROP5) {
        this.IP_PROP5 = IP_PROP5;
        return this;
    }

    public BitrixCSV setPdfLink(String IP_PROP4) {
        this.IP_PROP4 = IP_PROP4;
        return this;
    }

    public BitrixCSV setYear(String IC_GROUP0) {
        this.IC_GROUP0 = IC_GROUP0;
        return this;
    }

    public BitrixCSV setMagazine(String IC_GROUP1) {
        this.IC_GROUP1 = IC_GROUP1;
        return this;
    }

    public BitrixCSV setSection(String IC_GROUP2) {
        this.IC_GROUP2 = IC_GROUP2;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(IE_XML_ID).append(DELIM)
                .append(IE_NAME).append(DELIM)
                .append(IE_ID).append(DELIM)
                .append(IE_ACTIVE).append(DELIM)
                .append(IE_ACTIVE_FROM).append(DELIM)
                .append(IE_ACTIVE_TO).append(DELIM)
                .append(IE_PREVIEW_PICTURE).append(DELIM)
                .append(IE_PREVIEW_TEXT).append(DELIM)
                .append(IE_PREVIEW_TEXT_TYPE).append(DELIM)
                .append(IE_DETAIL_PICTURE).append(DELIM)
                .append(IE_DETAIL_TEXT).append(DELIM)
                .append(IE_DETAIL_TEXT_TYPE).append(DELIM)
                .append(IE_CODE).append(DELIM)
                .append(IE_SORT).append(DELIM)
                .append(IE_TAGS).append(DELIM)
                .append(IP_PROP8).append(DELIM)
                .append(IP_PROP11).append(DELIM)
                .append(IP_PROP6).append(DELIM)
                .append(IP_PROP14).append(DELIM)
                .append(IP_PROP45).append(DELIM)
                .append(IP_PROP3).append(DELIM)
                .append(IP_PROP31).append(DELIM)
                .append(IP_PROP7).append(DELIM)
                .append(IP_PROP12).append(DELIM)
                .append(IP_PROP10).append(DELIM)
                .append(IP_PROP9).append(DELIM)
                .append(IP_PROP13).append(DELIM)
                .append(IP_PROP1).append(DELIM)
                .append(IP_PROP15).append(DELIM)
                .append(IP_PROP5).append(DELIM)
                .append(IP_PROP4).append(DELIM)
                .append(IC_GROUP0).append(DELIM)
                .append(IC_GROUP1).append(DELIM)
                .append(IC_GROUP2);
        return sb.toString();
    }

}
