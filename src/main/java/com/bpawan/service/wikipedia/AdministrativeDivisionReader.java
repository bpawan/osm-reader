package com.bpawan.service.wikipedia;

import com.bpawan.service.model.District;
import com.bpawan.service.model.ProvinceMetaData;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.bpawan.util.NumberFormatter.unformatNumber;
import static com.bpawan.util.StringHelper.stringEqual;

/**
 * Url for province and district list:
 * https://en.wikipedia.org/wiki/Administrative_divisions_of_Nepal
 */
@Slf4j
@Service
public class AdministrativeDivisionReader extends BaseWikipediaParser {

    private static final String HTML_FILE_PATH = "data/province.html";
    private static final String CSS_QUERY = "table.sortable";

    private List<ProvinceMetaData> provinces;
    private ProvinceMetaData activeProvince;


    private District createDistrict(List<String> strings) {
        var province = this.extractProvince(strings);

        if (null != province) {
            this.activeProvince = province;
        }

        return District
                .builder()
                .sno(Integer.valueOf(strings.get(0)))
                .nameEnglish(strings.get(2).replaceAll("District", ""))
                .headquarter(strings.get(3))
                .area(unformatNumber(strings.get(4)))
                .build();
    }

    private List<List<String>> extractDistricts(Document doc) {
        return doc
                .select("table.sortable")
                .first()
                .select("tr")
                .stream()
                .map(element -> element
                        .select("td")
                        .stream()
                        .map(Element::text)
                        .collect(Collectors.toList())
                )
                .filter(strings -> !strings.isEmpty())
                .collect(Collectors.toList());
    }

    private ProvinceMetaData extractProvince(List<String> strings) {

        var provinceName = "";

        if (strings.size() == 6) {
            provinceName = strings.get(1);

            for (ProvinceMetaData province : this.provinces) {
                if (stringEqual(provinceName, province.getName())) {
                    return province;
                }
            }
        }

        return null;
    }

    private List<ProvinceMetaData> createProvinceList(ArrayList<List<String>> provinceList) {
        return provinceList
                .stream()
                .filter(strings -> !strings.isEmpty())
                .map(strings -> ProvinceMetaData
                        .builder()
                        .sno(Integer.valueOf(strings.get(0)))
                        .name(strings.get(1))
                        .headquarter(strings.get(2))
                        .area(unformatNumber(strings.get(3)))
                        .population(unformatNumber(strings.get(4)))
                        .build())
                .collect(Collectors.toList());
    }
}
