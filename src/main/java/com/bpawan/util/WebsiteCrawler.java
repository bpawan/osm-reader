package com.bpawan.util;

import com.google.common.base.Charsets;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WebsiteCrawler {
    public static void downloadFile(String url, String fileName) throws IOException {
        Document doc = Jsoup
                .connect(url)
                .get();

        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

        writer.write(doc.html());
    }

    public static Document parserHtmlFile(String filename) throws IOException {
        return Jsoup.parse(new File(filename), Charsets.UTF_8.name());
    }
}
