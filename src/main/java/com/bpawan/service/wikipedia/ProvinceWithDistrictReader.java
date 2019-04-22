package com.bpawan.service.wikipedia;

import com.bpawan.service.model.ProvinceWithDistricts;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static com.bpawan.util.NumberFormatter.unformatNumber;
import static com.bpawan.util.StringHelper.normalizeString;
import static com.bpawan.util.WebsiteCrawler.parserHtmlFile;

/**
 * This class will extract province, district, province headquarter, population and area for each province from wikipedia
 * The url that it parses: https://en.wikipedia.org/wiki/Administrative_divisions_of_Nepal
 * Will parse the second data table on the link.
 * <p>
 * Make sure to download the file first and provide the location of downloaded file.
 */
@Service
public class ProvinceWithDistrictReader extends BaseWikipediaParser {
    private static final String HTML_FILE_PATH = "data/province.html";
    private static final String CSS_QUERY = "table.sortable";
    private String currentProvince;

    public List<ProvinceWithDistricts> read() throws IOException {
        return this.extractRows(parserHtmlFile(HTML_FILE_PATH), CSS_QUERY)
                .stream()
                .filter(elements -> elements.size() != 0)
                .map(elements -> {
                    var provinceBuilder = ProvinceWithDistricts.builder();

                    provinceBuilder.sno(Integer.valueOf(elements.get(0).text()));

                    if (elements.size() == 6) {
                        this.currentProvince = elements.get(1).text();
                        provinceBuilder
                                .districtName(prepareDistrictName(elements.get(2).text()))
                                .normalizedDistrictName(prepareNormalizedDistrictName(elements.get(2).text()))
                                .headquarter(elements.get(3).text())
                                .area(unformatNumber(elements.get(4).text()))
                                .provinceName(this.currentProvince)
                                .normalizedProvinceName(normalizeString(this.currentProvince))
                                .population(unformatNumber(elements.get(5).text()));
                    } else {
                        provinceBuilder
                                .districtName(prepareDistrictName(elements.get(1).text()))
                                .normalizedDistrictName(prepareNormalizedDistrictName(elements.get(1).text()))
                                .headquarter(elements.get(2).text())
                                .provinceName(this.currentProvince)
                                .normalizedProvinceName(normalizeString(this.currentProvince))
                                .area(unformatNumber(elements.get(3).text()))
                                .population(unformatNumber(elements.get(4).text()));
                    }

                    return provinceBuilder.build();
                })
                .collect(Collectors.toList());
    }

    private String prepareNormalizedDistrictName(String input) {
        return normalizeString(prepareDistrictName(input));
    }

    private String prepareDistrictName(String input) {
        return input.replaceAll("District", "").trim();
    }
}
