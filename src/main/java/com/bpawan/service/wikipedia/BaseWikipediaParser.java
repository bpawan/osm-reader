package com.bpawan.service.wikipedia;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.List;
import java.util.stream.Collectors;

public class BaseWikipediaParser {
    protected List<Elements> extractRows(Document doc, String cssQuery) {
        return doc
                .select(cssQuery)
                .first()
                .select("tr").stream().map(this::readCellData)
                .collect(Collectors.toList());
    }

    private Elements readCellData(Element element) {
        return element.select("td");
    }
}
