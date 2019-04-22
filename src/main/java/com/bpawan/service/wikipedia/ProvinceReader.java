package com.bpawan.service.wikipedia;

import com.bpawan.service.model.ProvinceMetaData;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static com.bpawan.util.NumberFormatter.unformatNumber;
import static com.bpawan.util.StringHelper.normalizeString;
import static com.bpawan.util.WebsiteCrawler.parserHtmlFile;

/**
 * This class will extract name, headquarter, area and population for each provinces from wikipedia
 * The url it parses is: https://en.wikipedia.org/wiki/Administrative_divisions_of_Nepal
 * The data is located on the first table with css class of wikitable on the page.
 */
@Service
public class ProvinceReader extends BaseWikipediaParser {
    private static final String HTML_FILE_PATH = "data/province.html";
    private static final String CSS_QUERY = ".wikitable";

    public List<ProvinceMetaData> readProvinces() throws IOException {

        return this.extractRows(parserHtmlFile(HTML_FILE_PATH), CSS_QUERY)
                .stream()
                .map(this::extractString)
                .filter(strings -> !strings.isEmpty())
                .map(this::createProvince)
                .collect(Collectors.toList());
    }

    private ProvinceMetaData createProvince(List<String> strings) {
        return ProvinceMetaData
                .builder()
                .sno(Integer.valueOf(strings.get(0)))
                .name(strings.get(1))
                .headquarter(strings.get(2))
                .normalizedName(normalizeString(strings.get(1)))
                .area(unformatNumber(strings.get(3)))
                .population(unformatNumber(strings.get(4)))
                .build();
    }

    private List<String> extractString(Elements elements) {
        return elements
                .stream()
                .map(Element::text)
                .collect(Collectors.toList());
    }
}
