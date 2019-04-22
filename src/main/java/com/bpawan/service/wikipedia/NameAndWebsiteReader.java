package com.bpawan.service.wikipedia;

import com.bpawan.service.model.DistrictMetaData;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static com.bpawan.util.StringHelper.normalizeString;
import static com.bpawan.util.WebsiteCrawler.parserHtmlFile;

/**
 * This class will extract english name, nepali name and the DDC website from wikipedia
 * The url that it parses: https://en.wikipedia.org/wiki/District_Coordination_Committees.
 * <p>
 * Make sure to download the file first and provide the location of downloaded file.
 */
@Service
public class NameAndWebsiteReader extends BaseWikipediaParser {

    private static final String HTML_FILE_PATH = "data/ddc.html";
    private static final String CSS_QUERY = ".wikitable";

    public List<DistrictMetaData> readMetaData() throws IOException {
        return this.readRows();
    }

    private List<DistrictMetaData> readRows() throws IOException {
        return this
                .extractRows(parserHtmlFile(HTML_FILE_PATH), CSS_QUERY)
                .stream()
                .filter(strings -> !strings.isEmpty())
                .map(this::createTuple)
                .collect(Collectors.toList());
    }

    private DistrictMetaData createTuple(Elements elements) {

        var inter = elements
                .stream()
                .map(this::extractFromRow)
                .collect(Collectors.toList());

        return DistrictMetaData
                .builder()
                .sno(Integer.valueOf(inter.get(0)))
                .normalizedName(normalizeString(inter.get(1)))
                .englishName(inter.get(1))
                .nepaliName(inter.get(2))
                .website(inter.get(5))
                .build();
    }

    private String extractFromRow(Element element) {
        var websiteElement = element.select(".external");
        if (!websiteElement.isEmpty()) {
            return websiteElement.attr("href");
        }
        return element.text();
    }
}
