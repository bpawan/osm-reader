package com.bpawan.service.wikipedia;

import com.bpawan.util.WebsiteCrawler;

import java.io.IOException;

/**
 * https://en.wikipedia.org/wiki/List_of_gaunpalikas_of_Nepal
 */
public class GaunPalikaReader extends BaseWikipediaParser {
    private static final String FILE_NAME = "gaunpalika_list.html";

    private static final String WIKIPEDIA_URL = "https://en.wikipedia.org/wiki/List_of_gaunpalikas_of_Nepal";

    public void downloadHtmlFile() throws IOException {
        WebsiteCrawler.downloadFile(WIKIPEDIA_URL, FILE_NAME);
    }

    public void parse() throws IOException {

    }


}
